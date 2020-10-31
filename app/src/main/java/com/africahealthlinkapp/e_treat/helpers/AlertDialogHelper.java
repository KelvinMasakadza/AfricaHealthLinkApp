package com.africahealthlinkapp.e_treat.helpers;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;

import com.africahealthlinkapp.e_treat.R;

public class AlertDialogHelper {

    private Activity activity;

    public AlertDialogHelper(Activity activity) {
        this.activity = activity;
    }

    private AlertDialog constructNoInternetAlert(){
        final AlertDialog.Builder alertBuilder = new AlertDialog.Builder(activity, R.style.CustomAlertDialog);
        ViewGroup viewGroup = activity.findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(activity).inflate(R.layout.no_internet_dialog, viewGroup, false);
        alertBuilder.setView(dialogView);

        final AlertDialog alertDialog = alertBuilder.create();
        alertDialog.show();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setCancelable(false);
        return alertDialog;

    }

    public void showNoInternetAlertDialog() {

        final AlertDialog alertDialog = constructNoInternetAlert();

        final Button retryButton =  alertDialog.getWindow().findViewById(R.id.retry_button);
        retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                final Handler handler = new Handler();
                if (!isNetworkAvailable()) {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            alertDialog.show();
                        }
                    }, 100);
                } else {
                    alertDialog.dismiss();

                }
            }
        });
    }

    public boolean isNetworkAvailable() {

        ConnectivityManager connectivityManager
                = (ConnectivityManager) activity.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
