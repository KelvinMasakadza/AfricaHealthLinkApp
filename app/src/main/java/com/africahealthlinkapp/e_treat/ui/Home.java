package com.africahealthlinkapp.e_treat.ui;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.africahealthlinkapp.e_treat.R;
import com.africahealthlinkapp.e_treat.adapter.InfoAdapter;
import com.africahealthlinkapp.e_treat.databinding.ActivityHomeBinding;
import com.africahealthlinkapp.e_treat.models.Information;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    private GoogleMap mMap;
    private String PatientId = "";
    Location mLastLocation;
    LocationRequest mLocationRequest;
    private String mPatientsRequests = "patientsRequests";

    private FusedLocationProviderClient mFusedLocationClient;

    private Button mLogout, mRequest, mSettings, mHistory;

    private LatLng pickupLocation;

    private Boolean requestBol = false;

    private Marker pickupMarker;

    private SupportMapFragment mapFragment;

    private String destination, requestService;

    private LatLng destinationLatLng;

    private CardView mDoctorInfo;

    private ImageView mDoctorProfileImage;

    private TextView mDoctorName, mDoctorPhone, mDriverCar;

    private RadioGroup mRadioGroup;

    private RatingBar mRatingBar;
    private DatabaseReference mPatientsRequestsRef;
    private String mPatientRideId;
    private ActivityHomeBinding mHomeBinding;
    private RecyclerView mDoctorRecycler;
    private String mPhone;
    private String mName;
    private FirebaseUser mUser;
    private InfoAdapter mInfoAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        showInfo();
        mHomeBinding.bottomNavigation.setOnNavigationItemReselectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.profile_home) {
                startActivity(new Intent(this, Profile.class));
            } else if (id == R.id.message_home) {

            }else if (id == R.id.notify_home) {

            }

        });

    }


    public void lookForDoc(View view) {
        startActivity(new Intent(this, SearchDoctor.class));
    }

    public void openPharmarcies(View view) {
        startActivity(new Intent(this, PharmacyActivity.class));
    }

    public void openDiagnosis(View view) {
        Toast.makeText(Home.this, "Not Implemented Yet", Toast.LENGTH_LONG).show();
    }

    private void showInfo() {

        DatabaseReference mCustomerDatabase = FirebaseDatabase.getInstance().getReference().child("information");
        mCustomerDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Information> informationList = new ArrayList<>();
                Iterable<DataSnapshot> information = dataSnapshot.getChildren();

                for (DataSnapshot docts : information) {
                    Information c = docts.getValue(Information.class);
                    // Log.d("docts:: ", c.getInfo());
                    informationList.add(c);
                    mDoctorRecycler = mHomeBinding.infomationRecycler;
                    mHomeBinding.loadingIfor.setVisibility(View.GONE);
                    mDoctorRecycler.setLayoutManager(new LinearLayoutManager(Home.this,
                            LinearLayoutManager.HORIZONTAL, false));

                    mInfoAdapter = new InfoAdapter(informationList, Home.this);
                    mDoctorRecycler.setAdapter(mInfoAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}
