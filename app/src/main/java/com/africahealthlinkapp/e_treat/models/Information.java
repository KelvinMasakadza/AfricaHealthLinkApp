package com.africahealthlinkapp.e_treat.models;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.africahealthlinkapp.e_treat.R;
import com.bumptech.glide.Glide;

public class Information {
    private String info;
    private String infoImage;

    public Information() {
    }

    public Information(String info, String infoImage) {
        this.info = info;
        this.infoImage = infoImage;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfoImage() {
        return infoImage;
    }

    public void setInfoImage(String infoImage) {
        this.infoImage = infoImage;
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
