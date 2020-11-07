package com.africahealthlinkapp.e_treat.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.africahealthlinkapp.e_treat.R;
import com.africahealthlinkapp.e_treat.databinding.CartBinding;
import com.africahealthlinkapp.e_treat.models.Drug;
import com.africahealthlinkapp.e_treat.ui.Pharmacydetail;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.drugViewHolder> {
    private List<Drug> DrugList;


    public List<Drug> AddedDrugs = new ArrayList<>();
    private Context mContext;

    public CartAdapter(Context context, List<Drug> drugList) {
        this.DrugList = drugList;
        this.mContext = context;

    }


    @NonNull
    @Override
    public drugViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        CartBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext), R.layout.cart, parent, false);
        return new CartAdapter.drugViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull drugViewHolder holder, final int position) {

        Drug drug = DrugList.get(position);
        holder.mListItemBinding.setDrugs(drug);
        holder.mListItemBinding.executePendingBindings();
        ;
        holder.mListItemBinding.removeDrug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                DatabaseReference cartRef = FirebaseDatabase.getInstance().getReference().child("cart").child(uid);

                String key = cartRef.push().getKey();

                DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                Query cartQuery = cartRef;

                cartQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot cartSnapshot : dataSnapshot.getChildren()) {
                            cartSnapshot.getRef().removeValue();
                            if (cartSnapshot.getChildrenCount() == 0) {
                                mContext.startActivity(new Intent(mContext, Pharmacydetail.class));
                            }
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
//                        Log.e(TAG, "onCancelled", databaseError.toException());
                    }
                });

                Toast.makeText(mContext, "Medication removed", Toast.LENGTH_LONG).show();

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
        CartBinding mListItemBinding;

        public drugViewHolder(@NonNull View itemView) {
            super(itemView);

            mListItemBinding = DataBindingUtil.bind(itemView);
        }
    }
}
