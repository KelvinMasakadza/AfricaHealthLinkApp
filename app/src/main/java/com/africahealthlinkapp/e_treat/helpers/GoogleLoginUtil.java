package com.africahealthlinkapp.e_treat.helpers;

import android.app.Activity;
import android.content.Intent;

import androidx.annotation.NonNull;

import com.africahealthlinkapp.e_treat.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

public class GoogleLoginUtil {

    private Activity activity;
    private FirebaseAuth auth;

    private static final int GOOGLE_SIGN_IN = 1;

    public GoogleLoginUtil(Activity activity, FirebaseAuth auth) {
        this.activity = activity;
        this.auth = auth;
    }

    public void openGoogleIntent(){
        GoogleSignInClient client;
        AlertDialogHelper dialogHelper = new AlertDialogHelper(activity);
        if(!dialogHelper.isNetworkAvailable()){
            dialogHelper.showNoInternetAlertDialog();
        }
        else {
            GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestIdToken(activity.getString(R.string.default_web_client_id))
                    .requestEmail()
                    .build();
            client = GoogleSignIn.getClient(activity, gso);

            Intent signInIntent = client.getSignInIntent();
            activity.startActivityForResult(signInIntent, GOOGLE_SIGN_IN);
        }


    }

    public void firebaseAuthWithGoogle(String idToken, GoogleSignInAccount account) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        auth.signInWithCredential(credential)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //FirebaseUser user = mAuth.getCurrentUser();
                            DB_Util db_util = new DB_Util(activity, auth);
                            db_util.addUserToDatabase(account.getGivenName(),account.getFamilyName() ,account.getEmail(), "GOOGLE");

                        } else {

                            Snackbar.make(activity.getWindow().getDecorView(), "Authentication Failed.", Snackbar.LENGTH_SHORT).show();

                        }
                    }
                });
    }

}
