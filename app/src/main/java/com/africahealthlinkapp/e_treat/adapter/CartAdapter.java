package com.africahealthlinkapp.e_treat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.africahealthlinkapp.e_treat.R;
import com.africahealthlinkapp.e_treat.databinding.CartBinding;
import com.africahealthlinkapp.e_treat.models.Drug;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.drugViewHolder> {
    private List<Drug> DrugList;
    private OnRemoveItem mOnRemoveItem;


    public List<Drug> AddedDrugs = new ArrayList<>();
    private Context mContext;

    public CartAdapter(Context context, List<Drug> drugList, OnRemoveItem onRemoveItem) {
        this.DrugList = drugList;
        this.mContext = context;
        this.mOnRemoveItem = onRemoveItem;

    }


    @NonNull
    @Override
    public drugViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        CartBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext), R.layout.cart, parent, false);
        return new CartAdapter.drugViewHolder(binding.getRoot(), mOnRemoveItem);
    }

    @Override
    public void onBindViewHolder(@NonNull drugViewHolder holder, final int position) {

        Drug drug = DrugList.get(position);
        holder.mListItemBinding.setDrugs(drug);
        holder.mListItemBinding.executePendingBindings();
//        holder.mListItemBinding.removeDrug.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
//                DatabaseReference cartRef = FirebaseDatabase.getInstance().getReference().child("cart").child(uid);
//
//                String key = cartRef.push().getKey();
//
//                DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
//                Query cartQuery = cartRef;
//
//                cartQuery.addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        for (DataSnapshot cartSnapshot : dataSnapshot.getChildren()) {
//                            cartSnapshot.getRef().removeValue();
//                            if (cartSnapshot.getChildrenCount() == 0) {
//                                mContext.startActivity(new Intent(mContext, Pharmacydetail.class));
//                            }
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
////                        Log.e(TAG, "onCancelled", databaseError.toException());
//                    }
//                });
//
//                Toast.makeText(mContext, "Medication removed", Toast.LENGTH_LONG).show();
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return DrugList.size();
    }

    public void setList(List<Drug> drugList) {
        this.DrugList = drugList;
        notifyDataSetChanged();
    }

    public class drugViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CartBinding mListItemBinding;
        OnRemoveItem mOnRemoveItem;

        public drugViewHolder(@NonNull View itemView, OnRemoveItem onRemoveItem) {
            super(itemView);
            this.mOnRemoveItem = onRemoveItem;
            mListItemBinding = DataBindingUtil.bind(itemView);
            mListItemBinding.removeDrug.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mOnRemoveItem.onItemClick(getAdapterPosition(), mListItemBinding);
        }
    }

    public interface OnRemoveItem {
        void onItemClick(int position, CartBinding listItemBinding);
    }
}
