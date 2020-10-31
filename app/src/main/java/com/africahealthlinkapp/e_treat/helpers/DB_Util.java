package com.africahealthlinkapp.e_treat.helpers;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.africahealthlinkapp.e_treat.MainActivity;
import com.africahealthlinkapp.e_treat.R;
import com.africahealthlinkapp.e_treat.ui.SignInActivity;
import com.africahealthlinkapp.e_treat.models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
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

    public void addUserToDatabase(String firstName, String lastName, String email, String signUpMethod) {


        String uId = auth.getCurrentUser().getUid();
        User user = new User(firstName, lastName, email, uId);
        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference();

        dbRef.child(activity.getString(R.string.user_node)).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChild( auth.getCurrentUser().getUid())) {
                    //User Exists , No Need To add new data.
                    openMainActivity();
                    return;
                }
                else{
                    dbRef.child(activity.getString(R.string.user_node))
                        .child(auth.getCurrentUser().getUid())
                        .setValue(user)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                                //redirect the user to the login screen
                                if(signUpMethod.equals("BASIC")){
                                    auth.signOut();
                                    openLoginScreen();
                                }
                                else{
                                    openMainActivity();
                                }

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(activity, "Something went wrong. Try again!", Toast.LENGTH_SHORT).show();
                        if(auth != null){
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

    private void openMainActivity() {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }

    private void openLoginScreen(){
        Intent intent = new Intent(activity, SignInActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }
}
