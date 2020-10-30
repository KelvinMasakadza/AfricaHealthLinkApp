package com.africahealthlinkapp.e_treat.helpers;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;

public class FacebookLoginUtil {
    private Activity activity;
    private String option;
    private FirebaseAuth auth;
    private CallbackManager callbackManager;


    public FacebookLoginUtil(Activity activity, FirebaseAuth auth, String option)
    {
        this.activity = activity;
        this.auth = auth;
        this.option = option;

    }

    public void facebookLogin()
    {
        AlertDialogHelper dialogHelper = new AlertDialogHelper(activity);
        if(!dialogHelper.isNetworkAvailable()){
            dialogHelper.showNoInternetAlertDialog();
        }
        else{
            callbackManager = CallbackManager.Factory.create();
            LoginManager.getInstance().logInWithReadPermissions(activity, Arrays.asList("email","public_profile"));
            LoginManager.getInstance().registerCallback(callbackManager, new  FacebookCallback<LoginResult>()
            {

                @Override
                public void onSuccess(LoginResult loginResult)
                {
                    handleFacebookAccessToken(loginResult.getAccessToken());

                }

                @Override
                public void onCancel()
                {
                    Toast.makeText(activity.getApplicationContext(), "cancel", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onError(FacebookException error)
                {
                    Snackbar.make(activity.getWindow().getDecorView(), "Authentication Failed. Try Again!", Snackbar.LENGTH_SHORT).show();

                }


            });

        }


    }

    private void handleFacebookAccessToken(AccessToken token) {

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        auth.signInWithCredential(credential)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Profile profile = Profile.getCurrentProfile();

                            FirebaseUser user = auth.getCurrentUser();
                            DB_Util db_util = new DB_Util(activity, auth);
                            db_util.addUserToDatabase(profile.getFirstName(), profile.getLastName(), user.getEmail(), "FACEBOOK");
                            Snackbar.make(activity.getWindow().getDecorView(), "Login successful!", Snackbar.LENGTH_SHORT).show();


                        } else {
                            Snackbar.make(activity.getWindow().getDecorView(), "Authentication Failed. Try again!", Snackbar.LENGTH_SHORT).show();

                            /*Toast.makeText(activity.getApplicationContext(), "Facebook Authentication failed.",
                                    Toast.LENGTH_SHORT).show();*/
                        }

                    }
                });

    }



    public void onActivityResultFB(int requestCode, int resultCode, Intent data)
    {
        callbackManager.onActivityResult(requestCode, resultCode, data) ;

    }
}
