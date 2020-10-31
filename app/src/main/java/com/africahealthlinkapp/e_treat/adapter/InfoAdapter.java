package com.africahealthlinkapp.e_treat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.africahealthlinkapp.e_treat.R;
import com.africahealthlinkapp.e_treat.databinding.InfoModelBinding;
import com.africahealthlinkapp.e_treat.models.Information;

import java.util.List;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.BinginHolder> {
    public List<Information> mInformation;
    Context mContext;
//public OnDoctorClickListener mOnDoctorClickListener;

    public InfoAdapter(List<Information> information, Context context) {
        mInformation = information;
        mContext = context;
        //mOnDoctorClickListener = onDoctorClickListener;
    }

    @NonNull
    @Override
    public BinginHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        InfoModelBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext), R.layout.info_model, parent, false);
        return new BinginHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull BinginHolder holder, int position) {
        Information information = mInformation.get(position);
        holder.mBinding.setInfo(information);
        holder.mBinding.executePendingBindings();

    }

    @Override
    public int getItemCount() {
        return mInformation.size();
    }

    public static class BinginHolder extends RecyclerView.ViewHolder {
        //        @BindView(R.id.drugName)
        InfoModelBinding mBinding;
        //OnDoctorClickListener mOnDoctorClickListener;


        public BinginHolder(@NonNull View itemView) {
            super(itemView);
            //ButterKnife.bind(this, itemView);
            mBinding = DataBindingUtil.bind(itemView);
            //mOnDoctorClickListener = onDoctorClickListener;

        }


    }
}