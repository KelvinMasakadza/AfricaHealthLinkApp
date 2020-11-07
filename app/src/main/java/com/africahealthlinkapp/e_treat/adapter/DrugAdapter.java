package com.africahealthlinkapp.e_treat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.africahealthlinkapp.e_treat.R;
import com.africahealthlinkapp.e_treat.databinding.AppointmentsmodelBinding;
import com.africahealthlinkapp.e_treat.databinding.DrugListItemBinding;
import com.africahealthlinkapp.e_treat.models.Appointment;
import com.africahealthlinkapp.e_treat.models.Drug;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class DrugAdapter extends RecyclerView.Adapter<DrugAdapter.drugViewHolder> {
    private List<Drug> DrugList ;


    public List <Drug> AddedDrugs = new ArrayList<>();
    private Context mContext;

    public DrugAdapter(Context context, List<Drug> drugList) {
        this.DrugList =drugList;
        this.mContext=context;
    }


    @NonNull
    @Override
    public drugViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        DrugListItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext), R.layout.drug_list_item, parent, false);
        return new DrugAdapter.drugViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull drugViewHolder holder, final int position) {
        DatabaseReference cartRef = FirebaseDatabase.getInstance().getReference().child("cart");
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        String key = cartRef.child(uid).push().getKey();

        Drug drug = DrugList.get(position);
        holder.mListItemBinding.setDrugs(drug);
        holder.mListItemBinding.executePendingBindings();;
        holder.mListItemBinding.addDrug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = DrugList.get(position).getName();
                String price= DrugList.get(position).getPrice();
                Drug drug =new Drug(name,key,price);
                AddedDrugs.add(drug);

                cartRef.child(uid).child(key).setValue(drug);

            }
        });
    }

    @Override
    public int getItemCount() {
        return DrugList.size();
    }

    public void setList(List<Drug> drugList) {
        this.DrugList = drugList;
        notifyDataSetChanged();
    }

    public class drugViewHolder extends RecyclerView.ViewHolder {
        DrugListItemBinding mListItemBinding;
        public drugViewHolder(@NonNull View itemView) {
            super(itemView);

            mListItemBinding = DataBindingUtil.bind(itemView);
        }
    }
}
