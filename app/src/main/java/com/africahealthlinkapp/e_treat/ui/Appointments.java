package com.africahealthlinkapp.e_treat.ui;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.africahealthlinkapp.e_treat.R;
import com.africahealthlinkapp.e_treat.databinding.ActivityAppointmentBinding;
import com.africahealthlinkapp.e_treat.models.Appointment;
import com.africahealthlinkapp.e_treat.models.Patients;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class Appointments extends AppCompatActivity {

    private ActivityAppointmentBinding mAppointmentBinding;
    private String doctorId;
    private Calendar mCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAppointmentBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_appointment);

        doctorId = getIntent().getStringExtra("doctorId");

        mCalendar = Calendar.getInstance();
        int month = mCalendar.get(Calendar.MONTH);
        int date = mCalendar.get(Calendar.DAY_OF_MONTH);
        int year = mCalendar.get(Calendar.YEAR);
        showDate(month, date, year);

    }

    private void showDate(int month, int date, int year) {
        mAppointmentBinding.selectedDated.setText(String.format("%d/%d/%d", month, date, year));
    }

    public void pickTime(View view) {
        int hour = mCalendar.get(Calendar.HOUR_OF_DAY);
        int mins = mCalendar.get(Calendar.MINUTE);
//        //create date picker dialog;
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                (timePicker, hours, minutes) -> mAppointmentBinding.selecteTime
                        .setText(String.format("%d:%d", hours, minutes)), hour, mins, false);
        timePickerDialog.show();
//                new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                        nDateofBirth = findViewById(R.id.dateOfBirth);
//                        nDateofBirth.setText(String.format("%d/%d/%d", dayOfMonth, month, year));
//                    }
//                }, year, month, date);
//        pickerDialog.show();
//    }
    }

    public void bookDoc(View view) {
        String patientId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        String time = mAppointmentBinding.selecteTime.getText().toString();
        String date = mAppointmentBinding.selectedDated.getText().toString();
        DatabaseReference patients = FirebaseDatabase.getInstance().getReference().child("users")
                .child("patients").child(patientId);
        patients.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Patients patientApps = snapshot.getValue(Patients.class);
                String name = patientApps.getName();
                String phone = patientApps.getPhone();
                String location = patientApps.getLocation();
                String profile_pics = patientApps.getProfile_pics();

                DatabaseReference appointMentsRef = FirebaseDatabase.getInstance().getReference().child("Appointments");
                DatabaseReference doctorsRef = FirebaseDatabase.getInstance().getReference().child("users")
                        .child("doctors").child(doctorId).child("patientsRequests").child("patientId");
                Appointment appointment = new Appointment(profile_pics, patientId, doctorId, name, phone,
                        location, time, date);
                appointMentsRef.child(patientId).setValue(appointment);
                doctorsRef.setValue(patientId);
                Toast.makeText(Appointments.this, "Booked", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    public void confirmDate(View view) {
    }
}