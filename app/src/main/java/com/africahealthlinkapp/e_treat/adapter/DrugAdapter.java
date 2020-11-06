package com.africahealthlinkapp.e_treat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.africahealthlinkapp.e_treat.R;
import com.africahealthlinkapp.e_treat.models.Drug;

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


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.drug_list_item,parent, false);
        return new DrugAdapter.drugViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull drugViewHolder holder, final int position) {

        holder.nameTV.setText(DrugList.get(position).getName());
        holder.doseTV.setText(String.valueOf(DrugList.get(position).getDose()));
        holder.priceTV.setText(String.valueOf(DrugList.get(position).getPrice()));
        holder.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = DrugList.get(position).getName();
                String dose=DrugList.get(position).getDose();
                int price= DrugList.get(position).getPrice();
                Drug drug =new Drug(name,dose,price);
                AddedDrugs.add(drug);
                Toast.makeText(mContext,"Medication added",Toast.LENGTH_LONG).show();

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
        TextView nameTV, doseTV, priceTV;
        Button addButton;
        public drugViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTV = itemView.findViewById(R.id.textview_name);
            //doseTV = itemView.findViewById(R.id.d);
            priceTV = itemView.findViewById(R.id.textview_price);
            addButton =itemView.findViewById(R.id.add_drug);
        }
    }
}
