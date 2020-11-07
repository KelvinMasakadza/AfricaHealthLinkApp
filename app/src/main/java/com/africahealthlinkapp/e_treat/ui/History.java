package com.africahealthlinkapp.e_treat.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.africahealthlinkapp.e_treat.R;
import com.africahealthlinkapp.e_treat.adapter.HistoryAdapter;
import com.africahealthlinkapp.e_treat.databinding.ActivityHistoryBinding;
import com.africahealthlinkapp.e_treat.models.Appointment;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class History extends AppCompatActivity {

    private DatabaseReference mHistoryRef;
    private String mUid;
    private ActivityHistoryBinding mHistorymodelBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHistorymodelBinding = DataBindingUtil.setContentView(this, R.layout.activity_history);
        showhistory();
        mUid = FirebaseAuth.getInstance().getCurrentUser().getUid();

        mHistoryRef = FirebaseDatabase.getInstance()
                .getReference().child("History").child(mUid);

    }

    public void showhistory() {
        mHistoryRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.getChildrenCount() == 0) {
                    Toast.makeText(History.this, "No History yet", Toast.LENGTH_SHORT).show();

                } else {
                    int price = 0;
                    List<Appointment> historyList = new ArrayList<>();
                    Iterable<DataSnapshot> history = snapshot.getChildren();

                    for (DataSnapshot hist : history) {
                        Appointment c = hist.getValue(Appointment.class);
                        Log.d("hist:: ", c.getPatientName() + " " + c.getPatientPhone());
                        historyList.add(c);
                        RecyclerView historyRecyclerview = mHistorymodelBinding.historyRecyclerview;
                        mHistorymodelBinding.progressHist.setVisibility(View.GONE);

                        historyRecyclerview.setLayoutManager(new LinearLayoutManager(History.this));
                        HistoryAdapter drugAdapter = new HistoryAdapter(historyList, History.this);
                        historyRecyclerview.setAdapter(drugAdapter);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}