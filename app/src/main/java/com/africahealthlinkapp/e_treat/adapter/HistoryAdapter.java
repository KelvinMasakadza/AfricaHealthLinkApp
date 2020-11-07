package com.africahealthlinkapp.e_treat.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.africahealthlinkapp.e_treat.R;
import com.africahealthlinkapp.e_treat.databinding.AppointmentsmodelBinding;
import com.africahealthlinkapp.e_treat.databinding.HistorymodelBinding;
import com.africahealthlinkapp.e_treat.models.Appointment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.BinginHolder> {
    public List<Appointment> mAppointments;
    Context mContext;
    //public OnDoctorClickListener mOnDoctorClickListener;

    public HistoryAdapter(List<Appointment> appointments, Context context) {
        mAppointments = appointments;
        mContext = context;
        //mOnDoctorClickListener = onDoctorClickListener;
    }

    @NonNull
    @Override
    public BinginHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        HistorymodelBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext), R.layout.historymodel, parent, false);
        return new BinginHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull BinginHolder holder, int position) {
        Appointment appointment = mAppointments.get(position);
        holder.mBinding.setAppointment(appointment);
        holder.mBinding.executePendingBindings();

    }

    @Override
    public int getItemCount() {
        return mAppointments.size();
    }

    public static class BinginHolder extends RecyclerView.ViewHolder {
        //        @BindView(R.id.drugName)
        HistorymodelBinding mBinding;
        //OnDoctorClickListener mOnDoctorClickListener;


        public BinginHolder(@NonNull View itemView) {
            super(itemView);
            //ButterKnife.bind(this, itemView);
            mBinding = DataBindingUtil.bind(itemView);
            //mOnDoctorClickListener = onDoctorClickListener;

        }


    }
}