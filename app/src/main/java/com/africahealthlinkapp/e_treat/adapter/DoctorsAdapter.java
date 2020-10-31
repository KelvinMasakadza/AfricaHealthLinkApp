package com.africahealthlinkapp.e_treat.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.africahealthlinkapp.e_treat.R;
import com.africahealthlinkapp.e_treat.databinding.DoctormodelBinding;
import com.africahealthlinkapp.e_treat.models.Doctors;
import com.africahealthlinkapp.e_treat.ui.DoctorProfile;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.List;

public class DoctorsAdapter extends RecyclerView.Adapter<DoctorsAdapter.BinginHolder> {
    public List<Doctors> mDoctors;
    Context mContext;
    //public OnDoctorClickListener mOnDoctorClickListener;

    public DoctorsAdapter(List<Doctors> doctors, Context context) {
        mDoctors = doctors;
        mContext = context;
        //mOnDoctorClickListener = onDoctorClickListener;
    }

    @NonNull
    @Override
    public BinginHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DoctormodelBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext), R.layout.doctormodel, parent, false);
        return new BinginHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull BinginHolder holder, int position) {
        Doctors doctors = mDoctors.get(position);
        holder.mBinding.setDoctors(doctors);
        holder.mBinding.executePendingBindings();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String mUID = FirebaseAuth.getInstance().getCurrentUser().getUid();
                DatabaseReference nDoctors = FirebaseDatabase.getInstance().getReference().child("users").child("doctors");
                //String uid = nDoctors.getKey();
                Doctors doctors = mDoctors.get(position);
                String uid = doctors.getUid();
                Intent doctorsIntent = new Intent(mContext, DoctorProfile.class);
               // doctorsIntent.putExtra("doctor", doctors);
                doctorsIntent.putExtra("uid", uid);
                mContext.startActivity(doctorsIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDoctors.size();
    }

    public static class BinginHolder extends RecyclerView.ViewHolder {
        //        @BindView(R.id.drugName)
        DoctormodelBinding mBinding;
        //OnDoctorClickListener mOnDoctorClickListener;


        public BinginHolder(@NonNull View itemView) {
            super(itemView);
            //ButterKnife.bind(this, itemView);
            mBinding = DataBindingUtil.bind(itemView);
            //mOnDoctorClickListener = onDoctorClickListener;

        }


    }
}