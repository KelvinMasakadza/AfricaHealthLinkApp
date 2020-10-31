package com.africahealthlinkapp.e_treat.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.africahealthlinkapp.e_treat.R;
import com.bumptech.glide.Glide;

public class Doctors implements Parcelable {
    private String name;
    private String uid;
    private String phone;
    private String profile_pics;
    private String department;
    private String hospital;
    private String about;
    private String university;
    private String year;

    public Doctors() {
    }

    public Doctors(String name, String uid, String phone, String profile_pics, String department,
                   String hospital, String about, String university, String year) {
        this.name = name;
        this.uid = uid;
        this.phone = phone;
        this.profile_pics = profile_pics;
        this.department = department;
        this.hospital = hospital;
        this.about = about;
        this.university = university;
        this.year = year;

    }

    protected Doctors(Parcel in) {
        name = in.readString();
        phone = in.readString();
        profile_pics = in.readString();
        department = in.readString();
        uid = in.readString();
        about = in.readString();
        university = in.readString();
        year = in.readString();
    }

    public static final Creator<Doctors> CREATOR = new Creator<Doctors>() {
        @Override
        public Doctors createFromParcel(Parcel in) {
            return new Doctors(in);
        }

        @Override
        public Doctors[] newArray(int size) {
            return new Doctors[size];
        }
    };

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }


    public String getProfile_pics() {
        return profile_pics;
    }

    public void setProfile_pics(String profile_pics) {
        this.profile_pics = profile_pics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(phone);
        dest.writeString(profile_pics);
        dest.writeString(department);
    }

    @BindingAdapter("android:profilePic")
    public static void loadImage(ImageView view, String profile_pics) {
        if (profile_pics != null) {
            Glide.with(view)
                    .load(profile_pics)
                    .placeholder(R.drawable.profile_pic)
                    .into(view);
        } else {
            view.setBackgroundResource(R.drawable.profile_pic);
        }
    }
}
