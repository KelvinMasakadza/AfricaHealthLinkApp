package com.africahealthlinkapp.e_treat.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.africahealthlinkapp.e_treat.R;
import com.africahealthlinkapp.e_treat.databinding.ActivitySignUpBinding;
import com.africahealthlinkapp.e_treat.helpers.AlertDialogHelper;
import com.africahealthlinkapp.e_treat.helpers.DB_Util;
import com.africahealthlinkapp.e_treat.helpers.FacebookLoginUtil;
import com.africahealthlinkapp.e_treat.helpers.GoogleLoginUtil;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {

    private static final int GOOGLE_SIGN_IN = 1;

    ProgressBar progressBar;
    Button signUpButton;

    String TAG = "SIGNUP";

    GoogleSignInClient mGoogleClient;
    FirebaseAuth mAuth;

    private GoogleLoginUtil mGoogleLoginUtil;
    private FacebookLoginUtil facebookLoginUtil;
    ActivitySignUpBinding bindingUtil;

    String role = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bindingUtil = DataBindingUtil.setContentView(this, R.layout.activity_sign_up);
        bindingUtil.setActivity(this);

        mAuth = FirebaseAuth.getInstance();
        signUpButton = findViewById(R.id.sign_up_button);
        progressBar = findViewById(R.id.progress_bar);

        Intent intent = getIntent();
        role = intent.getStringExtra("role") == null ? role : intent.getStringExtra("role");
        Log.d("ROLE", role);
        if (role.equals("doctor")) {
            signUpButton.setVisibility(View.INVISIBLE);
            findViewById(R.id.next_button).setVisibility(View.VISIBLE);
        }else{ //(role.equals("patient"))
            signUpButton.setVisibility(View.VISIBLE);
            findViewById(R.id.next_button).setVisibility(View.INVISIBLE);
        }
    }

    public void openDoctorInfo(String firstName, String lastName, String email, String phone, String password, String confirmPassword ){

        if(firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || phone.isEmpty()
                || password.isEmpty() || confirmPassword.isEmpty()){
            Snackbar.make(getWindow().getDecorView(), "Please make sure you have filled all the inputs correctly!", Snackbar.LENGTH_SHORT).show();
        }
        else if(!doStringsMatch(password, confirmPassword)){
            Snackbar.make(getWindow().getDecorView(),  "Passwords do not Match", Snackbar.LENGTH_SHORT).show();
        }
        else{
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                FirebaseUser user = mAuth.getCurrentUser();
                                user.sendEmailVerification();
                                Intent intent = new Intent(SignUpActivity.this, DoctorInfoActivity.class);
                                intent.putExtra("firstName", firstName);
                                intent.putExtra("lastName", lastName);
                                intent.putExtra("email", email);
                                intent.putExtra("phone", phone);
                                startActivity(intent);
                                finish();
                            }

                        }});
        }

    }
    
    public void startFacebookSignUp() {

        facebookLoginUtil = new FacebookLoginUtil(SignUpActivity.this, mAuth, "SIGN_UP");
        facebookLoginUtil.facebookLogin();
    }

    public void startGoogleSignUp() {
        mGoogleLoginUtil = new GoogleLoginUtil(this, mAuth);
        mGoogleClient = null;
        mGoogleLoginUtil.openGoogleIntent();

    }

    private boolean isEmpty(String string){
        return string.equals("");
    }

    private void showDialog(){
        progressBar.setVisibility(View.VISIBLE);
        signUpButton.setVisibility(View.INVISIBLE);

    }

    private void hideDialog(){
        if(progressBar.getVisibility() == View.VISIBLE){
            progressBar.setVisibility(View.INVISIBLE);
        }
        signUpButton.setVisibility(View.VISIBLE);
    }

    private boolean doStringsMatch(String s1, String s2){
        return s1.equals(s2);
    }

    public void openLoginScreen(){
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
        finish();
    }

    public void registerNewUserAccount(final String firstName, final String lastName, final String email, final String phone, String password, String confirmPassword){

        AlertDialogHelper dialogHelper = new AlertDialogHelper(this);
        if(!dialogHelper.isNetworkAvailable()){
            dialogHelper.showNoInternetAlertDialog();
        }
        else if(firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()){
            Snackbar.make(getWindow().getDecorView(), "Please make sure you have filled all the inputs correctly!", Snackbar.LENGTH_SHORT).show();
        }
        else if(!doStringsMatch(password,confirmPassword)){
            Snackbar.make(getWindow().getDecorView(),  "Passwords do not Match", Snackbar.LENGTH_SHORT).show();
        }
        else {
            showDialog();
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()){
                                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                Log.d(TAG, "onComplete: AuthState: " + user.getUid() );
                                user.sendEmailVerification();
                                DB_Util db_util = new DB_Util(SignUpActivity.this, mAuth);
                                db_util.addUserToDatabase(firstName, lastName, email, phone, "BASIC");


                            }
                            else if (!task.isSuccessful()) {
                                Toast.makeText(SignUpActivity.this, "Unable to Register", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
        }

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GOOGLE_SIGN_IN) {

            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {

                GoogleSignInAccount account = task.getResult(ApiException.class);
                Log.d(TAG, "firebaseAuthWithGoogle:" + account.getId());

                mGoogleLoginUtil.firebaseAuthWithGoogle(account.getIdToken(), account);
            } catch (ApiException e) {
                Log.w(TAG, "Google sign in failed", e);
                Snackbar.make(getWindow().getDecorView(), "Authentication Failed.", Snackbar.LENGTH_SHORT).show();

            }
        }
        else{
            facebookLoginUtil.onActivityResultFB(requestCode, resultCode, data);

        }
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }

}