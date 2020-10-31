package com.africahealthlinkapp.e_treat.ui;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.africahealthlinkapp.e_treat.LocationService;
import com.africahealthlinkapp.e_treat.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


/*
hello every body -
this is me ECHOMAN - mohamed alfedawy
this is part of andela community project
this activity will get the user location and adding dummy data for near by pharmacy
wen user click twice on pharmacy marker it will take him to pharmacy detail activity
where he can order the needed drugs
Echoman0101@gmail.com

 */
public class PharmacyActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    private static final String TAG = "mainactivity";
    SupportMapFragment mapFragment;
    GoogleMap mMap;
    Marker marker1, marker2, marker3, marker4, marker5, marker;
    LocationBroadcastReceiver receiver;
    public LatLng mLatLng;
    public Boolean mClicked = false;
    public double mLat;
    public double mLongitude;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_map_activity);

        receiver = new LocationBroadcastReceiver();
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                //Req Location Permission
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            } else {
                //Start the Location Service
                startLocService();
            }
        } else {
            //Start the Location Service
            startLocService();
        }
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapFrag);
        mapFragment.getMapAsync(this);

        Button pharmacy_button = findViewById(R.id.pharmacy_button);
        pharmacy_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDummyMarker(mLat, mLongitude);
            }
        });


    }

    void startLocService() {
        IntentFilter filter = new IntentFilter("ACT_LOC");
        registerReceiver(receiver, filter);
        Intent intent = new Intent(PharmacyActivity.this, LocationService.class);
        startService(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                   startLocService();
                } else {
                    Toast.makeText(this, "Give me permissions", Toast.LENGTH_LONG).show();
                }
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMarkerClickListener(this);

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
         unregisterReceiver(receiver);

    }

    @Override
    public boolean onMarkerClick(Marker marker) {

        if (mClicked) {
            startActivity(new Intent(this, Pharmacydetail.class));
            mClicked = false;
        } else {
            mClicked = true;
        }
        return false;
    }


    public class LocationBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("ACT_LOC")) {
                mLat = intent.getDoubleExtra("latitude", 0f);
                mLongitude = intent.getDoubleExtra("longitude", 0f);
                if (mMap != null) {
                    mLatLng = new LatLng(mLat, mLongitude);
                    MarkerOptions markerOptions = new MarkerOptions();
                    markerOptions.position(mLatLng);
                    if (marker != null)
                        marker.setPosition(mLatLng);
                    else
                        marker = mMap.addMarker(markerOptions);
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(mLatLng, 14));
                }
            }
        }
    }

    private void addDummyMarker(double lat, double lang) {
        double lat1 = lat + 0.02;
        double lat2 = lat + -0.01;
        double lat3 = lat + 0.04;
        double lat4 = lat + -0.02;
        double lat5 = lat + 0.03;

        double long1 = lang + 0.02;
        double long2 = lang + 0.03;
        double long3 = lang + -0.04;
        double long4 = lang + 0.01;
        double long5 = lang + -0.06;


        LatLng latLng1 = new LatLng(lat5, long2);
        LatLng latLng2 = new LatLng(lat3, long4);
        LatLng latLng3 = new LatLng(lat2, long5);
        LatLng latLng4 = new LatLng(lat4, long3);
        LatLng latLng5 = new LatLng(lat1, long1);

        MarkerOptions markerOptions1 = new MarkerOptions();
        markerOptions1.position(latLng1)
                .title("first pharmacy")
                .snippet("dummy data for demonstration-tap again to enter")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                .flat(true);

        MarkerOptions markerOptions2 = new MarkerOptions();

        markerOptions2.position(latLng2)
                .title("2nd pharmacy")
                .snippet("dummy data for demonstration-tap again to enter")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))

                .flat(true);
        MarkerOptions markerOptions3 = new MarkerOptions();

        markerOptions3.position(latLng3)
                .title("third pharmacy")
                .snippet("dummy data for demonstration-tap again to enter")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))

                .flat(true);
        MarkerOptions markerOptions4 = new MarkerOptions();

        markerOptions4.position(latLng4)
                .title("fourth pharmacy")
                .snippet("dummy data for demonstration-tap again to enter")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                .flat(true);

        MarkerOptions markerOptions5 = new MarkerOptions();

        markerOptions5.position(latLng5)
                .title("fives pharmacy")
                .snippet("dummy data for demonstration-tap again to enter")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                .flat(true);

        marker1 = mMap.addMarker(markerOptions1);
        marker1.setTag(1);
        marker2 = mMap.addMarker(markerOptions2);
        marker2.setTag(2);
        marker3 = mMap.addMarker(markerOptions3);
        marker3.setTag(3);
        marker4 = mMap.addMarker(markerOptions4);
        marker4.setTag(4);
        marker5 = mMap.addMarker(markerOptions5);
        marker5.setTag(5);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng1, 14));



    }

}

