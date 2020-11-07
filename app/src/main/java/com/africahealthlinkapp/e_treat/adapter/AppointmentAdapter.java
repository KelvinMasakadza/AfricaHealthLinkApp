package com.africahealthlinkapp.e_treat.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.africahealthlinkapp.e_treat.R;
import com.africahealthlinkapp.e_treat.databinding.AppointmentsmodelBinding;
import com.africahealthlinkapp.e_treat.models.Appointment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class AppointmentAdapter extends RecyclerView.Adapter<AppointmentAdapter.BinginHolder> {
    public List<Appointment> mAppointments;
    Context mContext;
    //public OnDoctorClickListener mOnDoctorClickListener;

    public AppointmentAdapter(List<Appointment> appointments, Context context) {
        mAppointments = appointments;
        mContext = context;
        //mOnDoctorClickListener = onDoctorClickListener;
    }

    @NonNull
    @Override
    public BinginHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AppointmentsmodelBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext), R.layout.appointmentsmodel, parent, false);
        return new BinginHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull BinginHolder holder, int position) {
        Appointment appointment = mAppointments.get(position);
        holder.mBinding.setAppointment(appointment);
        holder.mBinding.executePendingBindings();
        holder.itemView.setOnClickListener(v -> {
            String mUID = FirebaseAuth.getInstance().getCurrentUser().getUid();
            DatabaseReference nDoctors = FirebaseDatabase.getInstance().getReference().child("users").child("doctors");
            AlertDialog.Builder closeAppointment = new AlertDialog.Builder(mContext);
            closeAppointment.setMessage("Finished Appointment ?");
            closeAppointment.setPositiveButton("Close", (dialogInterface, i) -> {

                dialogInterface.cancel();
                DatabaseReference history = FirebaseDatabase.getInstance().getReference().child("History").child(mUID);
                DatabaseReference appointments = FirebaseDatabase.getInstance().getReference().child("Appointments");
                String uid = appointments.getKey();

                assert uid != null;
                appointments.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String uid = snapshot.getKey();
                        Appointment app = snapshot.getValue(Appointment.class);
                        assert app != null;
                        Appointment histAppointmnts = new Appointment(
                                app.getProfile_pics(), null, null, app.getPatientName(),
                                app.getPatientPhone(), app.getPatientLocation(), app.getTime(), app.getDate());
                        history.push().setValue(histAppointmnts);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(mContext, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    }
                });


            }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            closeAppointment.show();
        });

    }

    @Override
    public int getItemCount() {
        return mAppointments.size();
    }

    public static class BinginHolder extends RecyclerView.ViewHolder {
        //        @BindView(R.id.drugName)
        AppointmentsmodelBinding mBinding;
        //OnDoctorClickListener mOnDoctorClickListener;


        public BinginHolder(@NonNull View itemView) {
            super(itemView);
            //ButterKnife.bind(this, itemView);
            mBinding = DataBindingUtil.bind(itemView);
            //mOnDoctorClickListener = onDoctorClickListener;

        }


    }
}