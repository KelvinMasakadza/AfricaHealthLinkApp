package com.africahealthlinkapp.e_treat.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.africahealthlinkapp.e_treat.R;
import com.africahealthlinkapp.e_treat.databinding.ActivityDoctorProfileBinding;
import com.africahealthlinkapp.e_treat.models.Doctors;
import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;;;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class DoctorProfile extends AppCompatActivity {

    private static final String TAG = "Profile";


    private BottomSheetDialog mEditProfile;
    private View mV;
    String mUid;
    ImageView docsPic;
    private Uri mSelectedImageUri;
    private Bitmap mSelectedImageBitmap;
    private byte[] mBytes;

    private static final int REQUEST_CODE = 1234;
    private static final double MB_THRESHHOLD = 5.0;
    private static final double MB = 1000000.0;

    Dialog imageUploadDialog;
    public static final int CAMERA_REQUEST_CODE = 5467;
    public static final int PICKFILE_REQUEST_CODE = 8352;
    private EditText mEdit;
    RelativeLayout mRelativeLayout;
    private TextView mConfirm;
    private TextView mCancel;
    private TextView mText_title;
    private ActivityDoctorProfileBinding mDoctorBinding;
    private String mUID;
    private DatabaseReference mDoctors;
    private String mDoctorUid;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDoctorBinding = DataBindingUtil.setContentView(this, R.layout.activity_doctor_profile);
        mUID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        mDoctors = FirebaseDatabase.getInstance().getReference().child("users").child("doctors");

        //editProfile();
        mUid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        init(firebaseUser);

        mDoctorUid = getIntent().getStringExtra("uid");
    }

    private void init(FirebaseUser firebaseUser) {
        Intent getProfle = getIntent();
        //String photoUrl = getProfle.getStringExtra("user_image");
        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(DoctorProfile.this));
    }



    @Override
    protected void onStart() {
        super.onStart();
        getUserinfo();
    }

    private void getUserinfo() {
        String docId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        mDoctors.child(mDoctorUid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists() && dataSnapshot.getChildrenCount() > 0) {
                    Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue();
                   // Users users = dataSnapshot.getValue(Users.class);
                    Doctors doctors = dataSnapshot.getValue(Doctors.class);
                    mDoctorBinding.setDoctors(doctors);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

}
