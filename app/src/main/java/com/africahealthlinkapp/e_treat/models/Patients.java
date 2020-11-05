package com.africahealthlinkapp.e_treat.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.africahealthlinkapp.e_treat.R;
import com.bumptech.glide.Glide;

public class Patients implements Parcelable {
    private String name;
    private String uid;
    private String phone;
    private String profile_pics;
    private String location;


    public Patients() {
    }

    public Patients(String name, String uid, String phone, String profile_pics, String location) {
        this.name = name;
        this.uid = uid;
        this.phone = phone;
        this.profile_pics = profile_pics;
        this.location = location;
    }

    protected Patients(Parcel in) {
        name = in.readString();
        phone = in.readString();
        profile_pics = in.readString();
        uid = in.readString();
        location= in.readString();
    }

    public static final Creator<Patients> CREATOR = new Creator<Patients>() {
        @Override
        public Patients createFromParcel(Parcel in) {
            return new Patients(in);
        }

        @Override
        public Patients[] newArray(int size) {
            return new Patients[size];
        }
    };

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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
        dest.writeString(location);
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
