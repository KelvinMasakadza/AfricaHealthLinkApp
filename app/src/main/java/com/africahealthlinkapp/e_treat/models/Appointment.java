package com.africahealthlinkapp.e_treat.models;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.africahealthlinkapp.e_treat.R;
import com.bumptech.glide.Glide;

public class Appointment {
    private String profile_pics;
    private String uid;
    private String docId;
    private String patientName;
    private String patientPhone;
    private String patientLocation;
    private String time;
    private String date;

    public Appointment() {
    }


    public Appointment(String profile_pics, String uid, String docId, String patientName, String patientPhone
            , String patientLocation, String time, String date) {
        this.profile_pics = profile_pics;
        this.uid = uid;
        this.docId = docId;
        this.patientName = patientName;
        this.patientPhone = patientPhone;
        this.patientLocation = patientLocation;
        this.time = time;
        this.date = date;
    }

    public String getProfile_pics() {
        return profile_pics;
    }

    public void setProfile_pics(String profile_pics) {
        this.profile_pics = profile_pics;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    public String getPatientLocation() {
        return patientLocation;
    }

    public void setPatientLocation(String patientLocation) {
        this.patientLocation = patientLocation;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    @BindingAdapter("android:infopic")
    public static void loadImage(ImageView view, String infoImage) {
        if (infoImage != null) {
            Glide.with(view)
                    .load(infoImage)
                    .placeholder(R.drawable.profile_pic)
                    .into(view);
        } else {
            view.setBackgroundResource(R.drawable.profile_pic);
        }
    }
}
