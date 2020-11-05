package com.africahealthlinkapp.e_treat.ui;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.africahealthlinkapp.e_treat.MainActivity;
import com.africahealthlinkapp.e_treat.R;
import com.africahealthlinkapp.e_treat.adapter.AppointmentAdapter;
import com.africahealthlinkapp.e_treat.databinding.ActivityPatientBinding;
import com.africahealthlinkapp.e_treat.models.Appointment;
import com.africahealthlinkapp.e_treat.models.Patients;
import com.bumptech.glide.Glide;
import com.directions.route.AbstractRouting;
import com.directions.route.Route;
import com.directions.route.RouteException;
import com.directions.route.Routing;
import com.directions.route.RoutingListener;
import com.firebase.geofire.GeoFire;
import com.firebase.geofire.GeoLocation;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoctorActivity extends FragmentActivity implements OnMapReadyCallback, RoutingListener {

    private GoogleMap mMap;
    Location mLastLocation;
    LocationRequest mLocationRequest;
    private String mPatientsRequests = "patientsRequests";

    private FusedLocationProviderClient mFusedLocationClient;


    private Button mLogout;
    private LinearLayout mSettings;
    private LinearLayout mHistory, mRideStatus;

    private Switch mWorkingSwitch;

    private int status = 0;

    private String PatientId = "", destination;
    private LatLng destinationLatLng, pickupLatLng;
    private float rideDistance;

    private Boolean isLoggingOut = false;

    private SupportMapFragment mapFragment;

    private CardView cardjob;

    private ImageView mPatientProfileImage;

    private TextView mPatientName, mPatientPhone, mPatientDestination, welcome, rideStatus;
    private FirebaseUser mUser;
    private DatabaseReference mDoctorsAvailable;
    private String mUserId;
    private ActivityPatientBinding mDbinding;
    private DatabaseReference mAssignedCustomerRef;
    private ValueEventListener mValueEventListener;
    private DatabaseReference mDriverRef;
    private DatabaseReference mHistoryRef;
    private DatabaseReference mPatientRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDbinding = DataBindingUtil.setContentView(
                this, R.layout.activity_patient);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        polylines = new ArrayList<>();
        loadAppointments();


        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        // mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        //mapFragment.getMapAsync(this);


        cardjob = findViewById(R.id.card_job);
        mDbinding.accept.setOnClickListener(view -> {
            acceptRequest();
        });
        mDbinding.decline.setOnClickListener(view -> {
            mDbinding.cardJob.setVisibility(View.GONE);
            mDriverRef.removeValue();
        });

        //mPatientProfileImage = findViewById(R.id.docs_ProfilePic);

//        welcome = findViewById(R.id.welcome);
//        rideStatus = findViewById(R.id.ride_status);

//        mWorkingSwitch = findViewById(R.id.turnOnline);
//        mWorkingSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
//            if (isChecked) {
//                welcome.setVisibility(View.GONE);
//                connectDriver();
//            } else {
//                disconnectDriver();
//            }
//        });

//        mSettings = findViewById(R.id.settings_profile);
//        mLogout = findViewById(R.id.logout);
//        mRideStatus = findViewById(R.id.rideStatus);
//        mHistory = findViewById(R.id.jobs);

//        mRideStatus.setOnClickListener(v -> {
//            switch (status) {
//                case 1:
//                    status = 2;
//                    erasePolylines();
//                    if (destinationLatLng.latitude != 0.0 && destinationLatLng.longitude != 0.0) {
//                        getRouteToMarker(destinationLatLng);
//                    }
//                    welcome.setVisibility(View.VISIBLE);
//                    welcome.setText("Meeting completed");
//
//                    break;
//                case 2:
//                    recordRide();
//                    endRide();
//                    break;
//            }
//        });

//        mLogout.setOnClickListener(v -> {
//            isLoggingOut = true;
//
//            disconnectDriver();
//
//            FirebaseAuth.getInstance().signOut();
//            Intent intent = new Intent(this, MainActivity.class);
//            startActivity(intent);
//            finish();
//            return;
//        });
//        mSettings.setOnClickListener(v -> {
//            Intent intent = new Intent(this, MainActivity.class);
//            startActivity(intent);
//            return;
//        });
//        mHistory.setOnClickListener(v -> {
//            Intent intent = new Intent(this, MainActivity.class);
//            intent.putExtra("patientOrDoctor", "doctors");
//            startActivity(intent);
//            return;
//        });
        getAssignedPatient();
        //mDbinding.cardJob.setVisibility(View.VISIBLE);
        mDbinding.bottomNavigation.setOnNavigationItemReselectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.appointments_menu) {
                startActivity(new Intent(this, DoctorActivity.class));
            } else if (id == R.id.history_menu) {

            }

        });

    }

    private void loadAppointments() {
        DatabaseReference mCustomerDatabase = FirebaseDatabase.getInstance().getReference().child("Appointments");
        mCustomerDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    //for (DataSnapshot doctorshot : dataSnapshot.getChildren()) {
//                    Doctors appoinment = doctorshot.getValue(Doctors.class);
                    List<Appointment> appointmentList = new ArrayList<>();
//                    //Doctors appoinment = new Doctors(mName, mPhone, null);
//                    appointmentList.add(appoinment);
                    //DataSnapshot contactSnapshot = dataSnapshot.child(doctorFoundId);
                    Iterable<DataSnapshot> appoinment = dataSnapshot.getChildren();

                    for (DataSnapshot hist : appoinment) {
                        Appointment c = hist.getValue(Appointment.class);
                        Log.d("hist:: ", c.getPatientName() + " " + c.getPatientPhone());
                        appointmentList.add(c);
                        RecyclerView mPatientRecycler = mDbinding.historyRecycler;
                        mPatientRecycler.setVisibility(View.VISIBLE);
                        mDbinding.historyPB.setVisibility(View.GONE);

                        mPatientRecycler.setLayoutManager(new LinearLayoutManager(DoctorActivity.this));

                        AppointmentAdapter appointmentAdapter = new AppointmentAdapter(appointmentList, DoctorActivity.this);
                        mPatientRecycler.setAdapter(appointmentAdapter);
                    }
                } else {
                    mDbinding.noHistory.setText("No Appointments");
                    mDbinding.historyPB.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    private void acceptRequest() {
        String doctorId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        mPatientRequest = FirebaseDatabase.getInstance().getReference().child("users")
                .child("doctors").child(doctorId).child(mPatientsRequests);
        mHistoryRef = FirebaseDatabase.getInstance().getReference().child("history");
        DatabaseReference appointments = FirebaseDatabase.getInstance().getReference().child("Appointments");


        mDbinding.cardJob.setVisibility(View.GONE);
        mPatientRequest.removeValue();
        appointments.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String pID = snapshot.getKey();
                DatabaseReference appoin = FirebaseDatabase.getInstance()
                        .getReference().child("users").child("patients").child(pID);
                appoin.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Appointment appointment = snapshot.getValue(Appointment.class);
                        Appointment patientAppointment = new Appointment(appointment.getProfile_pics(),
                                appointment.getUid(), null, appointment.getPatientName(),
                                appointment.getPatientPhone(), appointment.getPatientLocation(), null, null);
                        mHistoryRef.child(doctorId).setValue(patientAppointment);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getAssignedPatient() {
        String doctorId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        mAssignedCustomerRef = FirebaseDatabase.getInstance().getReference().child("users")
                .child("doctors").child(doctorId).child(mPatientsRequests).child("patientId");

        mValueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    status = 1;
                    PatientId = dataSnapshot.getValue().toString();
                    getAssignedCustomerPickupLocation();
                    getAssignedCustomerDestination();
                    getAssignedPatientInfo();
                } else {
                    //endRide();
                    Toast.makeText(DoctorActivity.this, "No Patient Requests Available", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };
        mAssignedCustomerRef.addValueEventListener(mValueEventListener);

    }

    Marker pickupMarker;
    private DatabaseReference assignedCustomerPickupLocationRef;
    private ValueEventListener assignedCustomerPickupLocationRefListener;

    private void getAssignedCustomerPickupLocation() {
        assignedCustomerPickupLocationRef = FirebaseDatabase.getInstance().getReference().child(mPatientsRequests).child(PatientId).child("l");
        assignedCustomerPickupLocationRefListener = assignedCustomerPickupLocationRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists() && !PatientId.equals("")) {
                    List<Object> map = (List<Object>) dataSnapshot.getValue();
                    double locationLat = 0;
                    double locationLng = 0;
                    if (map.get(0) != null) {
                        locationLat = Double.parseDouble(map.get(0).toString());
                    }
                    if (map.get(1) != null) {
                        locationLng = Double.parseDouble(map.get(1).toString());
                    }
                    pickupLatLng = new LatLng(locationLat, locationLng);
//                    pickupMarker = mMap.addMarker(new MarkerOptions().position(pickupLatLng).title("pickup location"));
//                    getRouteToMarker(pickupLatLng);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    private void getRouteToMarker(LatLng pickupLatLng) {
        if (pickupLatLng != null && mLastLocation != null) {
            Routing routing = new Routing.Builder()
                    .travelMode(AbstractRouting.TravelMode.DRIVING)
                    .withListener(this)
                    .alternativeRoutes(false)
                    .waypoints(new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude()), pickupLatLng)
                    .build();
            routing.execute();
        }
    }

    private void getAssignedCustomerDestination() {
        String driverId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference assignedCustomerRef = FirebaseDatabase.getInstance().getReference()
                .child("users").child("doctors").child(driverId).child(mPatientsRequests);
        assignedCustomerRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue();
                    if (map.get("destination") != null) {
                        //destination = map.get("destination").toString();
                        //mPatientDestination.setText("Destination: " + destination);
                    } else {
                        //mPatientDestination.setText("Destination: --");
                    }

                    Double destinationLat = 0.0;
                    Double destinationLng = 0.0;
                    if (map.get("destinationLat") != null) {
                        destinationLat = Double.valueOf(map.get("destinationLat").toString());
                    }
                    if (map.get("destinationLng") != null) {
                        destinationLng = Double.valueOf(map.get("destinationLng").toString());
                        destinationLatLng = new LatLng(destinationLat, destinationLng);
                    }

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }


    private void getAssignedPatientInfo() {
        String patientId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference mCustomerDatabase = FirebaseDatabase.getInstance().getReference()
                .child("users").child("patients").child(patientId);
        mCustomerDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists() && dataSnapshot.getChildrenCount() > 0) {
                    mDbinding.cardJob.setVisibility(View.VISIBLE);
                    Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue();
                    Patients patients = dataSnapshot.getValue(Patients.class);
                    mDbinding.patientName.setText(patients.getName());
                    mDbinding.patientPhone.setText(patients.getPhone());
                    mDbinding.patientLocation.setText(patients.getLocation());
                    if (map.get("profile_pics") != null) {
                        Glide.with(getApplicationContext()).load(map.get("profile_pics").toString()).into(mDbinding.patientImage);
                    }

                    //                   Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue();
//                    if (map.get("fName") != null) {
//                         mDbinding.patientName.setText(map.get("fName").toString());
//                    }
//                    if (map.get("phone") != null) {
//                        mDbinding.patientPhone.setText(map.get("phone").toString());
//                    }
//                    if (map.get("profile_pics") != null) {
//                        Glide.with(getApplication()).load(map.get("profile_pics").toString()).into(mPatientProfileImage);
//                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }


    private void endRide() {
        //rideStatus.setText("reached Patient");
        erasePolylines();

        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        mDriverRef = FirebaseDatabase.getInstance().getReference().child("users").child("doctors").child(userId).child(mPatientsRequests);
        mDriverRef.removeValue();

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child(mPatientsRequests);
        GeoFire geoFire = new GeoFire(ref);
        geoFire.removeLocation(PatientId);
        PatientId = "";
        rideDistance = 0;

        if (pickupMarker != null) {
            pickupMarker.remove();
        }
        if (assignedCustomerPickupLocationRefListener != null) {
            assignedCustomerPickupLocationRef.removeEventListener(assignedCustomerPickupLocationRefListener);
        }
        cardjob.setVisibility(View.GONE);
        //mDbinding.patientName.setText("");
        // mDbinding.patientPhone.setText("");
        // mPatientDestination.setText("Destination: --");
        //mDbinding.patientImage.setImageResource(R.drawable.user_image);
    }

    private void recordRide() {
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference driverRef = FirebaseDatabase.getInstance().getReference().child("users").child("doctors").child(userId).child("jobs");
        DatabaseReference customerRef = FirebaseDatabase.getInstance().getReference().child("users").child("patients").child(PatientId).child("jobs");
        DatabaseReference historyRef = FirebaseDatabase.getInstance().getReference().child("jobs");
        String requestId = historyRef.push().getKey();
        driverRef.child(requestId).setValue(true);
        customerRef.child(requestId).setValue(true);

        HashMap map = new HashMap();
        map.put("doctor", userId);
        map.put("patient", PatientId);
        map.put("rating", 0);
        map.put("timestamp", getCurrentTimestamp());
        map.put("destination", destination);
        map.put("location/from/lat", pickupLatLng.latitude);
        map.put("location/from/lng", pickupLatLng.longitude);
        map.put("location/to/lat", destinationLatLng.latitude);
        map.put("location/to/lng", destinationLatLng.longitude);
        map.put("distance", rideDistance);
        historyRef.child(requestId).updateChildren(map);
    }

    private Long getCurrentTimestamp() {
        Long timestamp = System.currentTimeMillis() / 1000;
        return timestamp;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

            } else {
                checkLocationPermission();
            }
        }
    }


    LocationCallback mLocationCallback = new LocationCallback() {
        @Override
        public void onLocationResult(LocationResult locationResult) {
            for (Location location : locationResult.getLocations()) {
                if (getApplicationContext() != null) {

                    if (!PatientId.equals("") && mLastLocation != null && location != null) {
                        rideDistance += mLastLocation.distanceTo(location) / 1000;
                    }
                    mLastLocation = location;


                    LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(11));

                    String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
                    DatabaseReference refAvailable = FirebaseDatabase.getInstance().getReference().child("doctorsAvailable");
                    DatabaseReference refWorking = FirebaseDatabase.getInstance().getReference().child("doctorsWorking");
                    GeoFire geoFireAvailable = new GeoFire(refAvailable);
                    GeoFire geoFireWorking = new GeoFire(refWorking);

                    switch (PatientId) {
                        case "":
                            geoFireWorking.removeLocation(userId);
                            geoFireAvailable.setLocation(userId, new GeoLocation(location.getLatitude(), location.getLongitude()));
                            break;

                        default:
                            geoFireAvailable.removeLocation(userId);
                            geoFireWorking.setLocation(userId, new GeoLocation(location.getLatitude(), location.getLongitude()));
                            break;
                    }
                }
            }
        }
    };

    private void checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                new AlertDialog.Builder(this)
                        .setTitle("give permission")
                        .setMessage("give permission message")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                ActivityCompat.requestPermissions(DoctorActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                            }
                        })
                        .create()
                        .show();
            } else {
                ActivityCompat.requestPermissions(DoctorActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        mFusedLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallback, Looper.myLooper());
                        mMap.setMyLocationEnabled(true);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Please provide the permission", Toast.LENGTH_LONG).show();
                }
                break;
            }
        }
    }


    private void connectDriver() {
        checkLocationPermission();
        mFusedLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallback, Looper.myLooper());
        mMap.setMyLocationEnabled(true);
        GeoFire mGeofire = new GeoFire(mDoctorsAvailable);
        if (mLastLocation != null) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
                    new LatLng(mLastLocation.getLatitude(),
                            mLastLocation.getLongitude()), 11));

            mGeofire.setLocation(mUserId, new GeoLocation(mLastLocation.getLatitude(), mLastLocation.getLongitude()));
        }
    }

    private void disconnectDriver() {
        if (mFusedLocationClient != null) {
            mFusedLocationClient.removeLocationUpdates(mLocationCallback);
        }
        mUserId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        mDoctorsAvailable = FirebaseDatabase.getInstance().getReference().child("doctorsAvailable");

        GeoFire geoFire = new GeoFire(mDoctorsAvailable);
        geoFire.removeLocation(mUserId);
    }


    private List<Polyline> polylines;
    private static final int[] COLORS = new int[]{R.color.primary_dark_material_light};

    @Override
    public void onRoutingFailure(RouteException e) {
        if (e != null) {
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Something went wrong, Try again", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRoutingStart() {
    }

    @Override
    public void onRoutingSuccess(ArrayList<Route> route, int shortestRouteIndex) {
        if (polylines.size() > 0) {
            for (Polyline poly : polylines) {
                poly.remove();
            }
        }

        polylines = new ArrayList<>();
        //add route(s) to the map.
        for (int i = 0; i < route.size(); i++) {

            //In case of more than 5 alternative routes
            int colorIndex = i % COLORS.length;

            PolylineOptions polyOptions = new PolylineOptions();
            polyOptions.color(getResources().getColor(COLORS[colorIndex]));
            polyOptions.width(10 + i * 3);
            polyOptions.addAll(route.get(i).getPoints());
            Polyline polyline = mMap.addPolyline(polyOptions);
            polylines.add(polyline);

            Toast.makeText(getApplicationContext(), "Route " + (i + 1) + ": distance - " + route.get(i).getDistanceValue() + ": duration - " + route.get(i).getDurationValue(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onRoutingCancelled() {
    }

    private void erasePolylines() {
        for (Polyline line : polylines) {
            line.remove();
        }
        polylines.clear();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mUser = FirebaseAuth.getInstance().getCurrentUser();
        if (mUser == null) {
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}