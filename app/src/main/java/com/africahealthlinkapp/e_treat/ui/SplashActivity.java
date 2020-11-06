package com.africahealthlinkapp.e_treat.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.africahealthlinkapp.e_treat.R;
import com.africahealthlinkapp.e_treat.helpers.AlertDialogHelper;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_DISPLAY_LENGTH = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (ContextCompat.checkSelfPermission(SplashActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(SplashActivity.this,
                    Manifest.permission.ACCESS_FINE_LOCATION)){
                ActivityCompat.requestPermissions(SplashActivity.this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }
            else{
                ActivityCompat.requestPermissions(SplashActivity.this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }
        }
        else{
            //openSignUp();
            showRoleDialog();

        }


    }

    private void showRoleDialog() {
        AlertDialogHelper dialogHelper = new AlertDialogHelper(this);
        SharedPreferences pref = getSharedPreferences(getString(R.string.preference_name), Context.MODE_PRIVATE);
        String role = pref.getString("role","");
        if(role == "") {
            dialogHelper.showSetRoleAlertDialog();
        }
        else{
            dialogHelper.startSignUp(role);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults){


        switch (requestCode){
            case 1: {
                if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    if (ContextCompat.checkSelfPermission(SplashActivity.this,
                            Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED){
                        //openSignUp();
                        showRoleDialog();

                    }
                }else{
                    Toast.makeText(this, "Location Permission Denied", Toast.LENGTH_SHORT).show();
                    this.finish();
                }
                return;
            }
        }
    }


    private void openSignUp() {
        Intent intent = new Intent(SplashActivity.this , SignUpActivity.class);
        //Toast.makeText(this, "Location Permission Granted", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}