package com.africahealthlinkapp.e_treat.helpers;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.africahealthlinkapp.e_treat.R;
import com.africahealthlinkapp.e_treat.models.Patient;
import com.africahealthlinkapp.e_treat.ui.DoctorHome;
import com.africahealthlinkapp.e_treat.ui.Home;
import com.africahealthlinkapp.e_treat.ui.SignInActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DB_Util {

    private Activity activity;
    private FirebaseAuth auth;

    public DB_Util(Activity activity, FirebaseAuth auth) {
        this.activity = activity;
        this.auth = auth;
    }

    public void addUserToDatabase(String firstName, String lastName, String email, String phone, String signUpMethod) {


        String uId = auth.getCurrentUser().getUid();
        Patient patient = new Patient(firstName, lastName, email, phone, uId);
        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference();

        dbRef.child(activity.getString(R.string.user_node)).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChild(auth.getCurrentUser().getUid())) {
                    //User Exists , No Need To add new data.
                    openHomeActivity();
                    return;
                } else {
                    dbRef.child(activity.getString(R.string.user_node))
                            .child(auth.getCurrentUser().getUid())
                            .setValue(patient)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    //redirect the user to the login screen
                                    if (signUpMethod.equals("BASIC")) {

                                        new FirebaseAuth.AuthStateListener() {
                                            @Override
                                            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                                                FirebaseUser user = firebaseAuth.getCurrentUser();
                                                if (user != null) {
                                                    auth.signOut();
                                                } else {

                                                }

                                            }
                                        };

                                        openLoginScreen();
                                    } else {
                                        openHomeActivity();
                                    }

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(activity, "Something went wrong. Try again!", Toast.LENGTH_SHORT).show();
                            if (auth != null) {
                                auth.signOut();
                            }

                        }
                    });

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


    private void openHomeActivity() {

        Intent intent = new Intent(activity, Home.class);
        activity.startActivity(intent);
        activity.finish();
    }

    private void openLoginScreen() {
        Snackbar.make(activity.getWindow().getDecorView(), "We have sent you a verification email to activate your account. Please make sure to verify you email before you sign in!", Snackbar.LENGTH_SHORT).show();

        new Handler().postDelayed((Runnable) () -> {
            Intent intent = new Intent(activity, SignInActivity.class);
            activity.startActivity(intent);
            activity.finish();

        }, 500);


    }

    public void isUserAvailable(String role, String userId) {
        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference();
        if (role.equals("patient")) {
            dbRef.child(activity.getString(R.string.user_node)).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.hasChild(userId)) {
                        //Snackbar.make(activity.getWindow().getDecorView(), "Hi patient", Snackbar.LENGTH_SHORT).show();
                        openHomeActivity();
                    }
                    else{
                        Snackbar.make(activity.getWindow().getDecorView(), "Invalid Credentials. Try Again!", Snackbar.LENGTH_SHORT).setTextColor(activity.getResources().getColor(R.color.white)).setBackgroundTint(activity.getResources().getColor(R.color.red)).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Snackbar.make(activity.getWindow().getDecorView(), "Something went wrong. Try again!", Snackbar.LENGTH_SHORT).show();

                }
            });

        } else if (role.equals("doctor")) {
            dbRef.child(activity.getString(R.string.doctor_node)).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.hasChild(userId)) {
                        //Snackbar.make(activity.getWindow().getDecorView(), "Hi doctor", Snackbar.LENGTH_SHORT).show();
                        openDoctorHome();
                    }
                    else{
                        Snackbar.make(activity.getWindow().getDecorView(), "Invalid Credentials. Try Again!", Snackbar.LENGTH_SHORT).setTextColor(activity.getResources().getColor(R.color.white)).setBackgroundTint(activity.getResources().getColor(R.color.red)).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Snackbar.make(activity.getWindow().getDecorView(), "Something went wrong. Try again!", Snackbar.LENGTH_SHORT).show();

                }
            });
        } else {
            Snackbar.make(activity.getWindow().getDecorView(), "Make sure you have picked a role!", Snackbar.LENGTH_SHORT).setTextColor(activity.getResources().getColor(R.color.white)).setBackgroundTint(activity.getResources().getColor(R.color.red)).show();

        }

    }

    private void openDoctorHome() {
        Intent intent = new Intent(activity, DoctorHome.class);
        activity.startActivity(intent);
        activity.finish();
    }
}
