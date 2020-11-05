package com.africahealthlinkapp.e_treat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.africahealthlinkapp.e_treat.R;
import com.africahealthlinkapp.e_treat.databinding.AppointmentsmodelBinding;
import com.africahealthlinkapp.e_treat.models.Appointment;

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
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                String mUID = FirebaseAuth.getInstance().getCurrentUser().getUid();
//                DatabaseReference nDoctors = FirebaseDatabase.getInstance().getReference().child("users").child("doctors");
//                //String uid = nDoctors.getKey();
//                Doctors doctors = mDoctors.get(position);
//                String uid = doctors.getUid();
//                Intent doctorsIntent = new Intent(mContext, DoctorProfile.class);
//               // doctorsIntent.putExtra("doctor", doctors);
//                doctorsIntent.putExtra("uid", uid);
//                mContext.startActivity(doctorsIntent);
//            }
//        });

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