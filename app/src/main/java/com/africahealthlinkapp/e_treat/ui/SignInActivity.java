package com.africahealthlinkapp.e_treat.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.africahealthlinkapp.e_treat.MainActivity;
import com.africahealthlinkapp.e_treat.R;
import com.africahealthlinkapp.e_treat.databinding.ActivitySignInBinding;
import com.africahealthlinkapp.e_treat.helpers.AlertDialogHelper;
import com.africahealthlinkapp.e_treat.helpers.DB_Util;
import com.africahealthlinkapp.e_treat.helpers.FacebookLoginUtil;
import com.africahealthlinkapp.e_treat.helpers.GoogleLoginUtil;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;



public class SignInActivity extends AppCompatActivity {

    Button signInBtn;
    FirebaseAuth auth;
    private String TAG = "SIGNIN";
    ProgressBar progressBar;
    FacebookLoginUtil facebookLoginUtil;

    private GoogleLoginUtil googleLoginUtil;

    private static final int GOOGLE_SIGN_IN = 1;


    ActivitySignInBinding bindingUtil;

    private String role = null;
    DB_Util dbUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bindingUtil = DataBindingUtil.setContentView(this, R.layout.activity_sign_in);
        bindingUtil.setActivity(this);

        auth = FirebaseAuth.getInstance();

        signInBtn = findViewById(R.id.sign_in_button);
        progressBar = findViewById(R.id.load_progress_bar);

        RadioGroup group = findViewById(R.id.radio_group);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.patient){
                    // search patient within patients node
                    role = "patient";
                }
                else if (i == R.id.doctor){
                    // search doctor within doctors node
                    role = "doctor";
                }
            }
        });
    }

    public void openSignUpScreen(){
        Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
        startActivity(intent);
        finish();
    }

    public void startGoogleSignIn() {
        googleLoginUtil = new GoogleLoginUtil(this, auth);
        googleLoginUtil.openGoogleIntent();

    }

    public void startFacebookSignIn() {
        facebookLoginUtil = new FacebookLoginUtil(SignInActivity.this, auth, "SIGN_IN");
        facebookLoginUtil.facebookLogin();

    }

    public void authenticateUser(String email, String password) {

        AlertDialogHelper dialogHelper = new AlertDialogHelper(this);
        if(!dialogHelper.isNetworkAvailable()){
            dialogHelper.showNoInternetAlertDialog();
        }
        else if(email.isEmpty() || password.isEmpty()){
            Snackbar.make(getWindow().getDecorView(), "Please make sure you have filled all the inputs correctly!", Snackbar.LENGTH_SHORT).show();

        }
        else{
            dbUtil = new DB_Util(this, auth);
            showDialog();
            auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser user = auth.getCurrentUser();
                                Log.d(TAG, "signIn:: success "+ user.getUid());
                                checkIfEmailVerified();

                            } else {
                                Log.d(TAG, "signIn::failure", task.getException());
                                Snackbar.make(getWindow().getDecorView(), "Authentication failed.", Snackbar.LENGTH_SHORT).show();

                            }
                            hideDialog();

                        }
                    });
        }



    }

    private void checkIfEmailVerified()
    {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user.isEmailVerified())
        {
            dbUtil.isUserAvailable(role, user.getUid());
            //finish();
            //Snackbar.make(getWindow().getDecorView(), "Login Successful!", Snackbar.LENGTH_SHORT).show();
        }
        else
        {
            FirebaseAuth.getInstance().signOut();
            Snackbar.make(getWindow().getDecorView(), "Please verify you email", Snackbar.LENGTH_SHORT).show();

        }
    }


    private void showDialog() {
        signInBtn.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);
    }

    private void hideDialog(){
        signInBtn.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GOOGLE_SIGN_IN) {

            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                Log.d(TAG, "firebaseAuthWithGoogle:" + account.getId());

                googleLoginUtil.firebaseAuthWithGoogle(account.getIdToken(), account);
            } catch (ApiException e) {
                Log.w(TAG, "Google sign in failed", e);
                Snackbar.make(getWindow().getDecorView(), "Authentication Failed.", Snackbar.LENGTH_SHORT).show();

            }
        }
        else if(facebookLoginUtil != null){
            facebookLoginUtil.onActivityResultFB(requestCode, resultCode, data);
        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}