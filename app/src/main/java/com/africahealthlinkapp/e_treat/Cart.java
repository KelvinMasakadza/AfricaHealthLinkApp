package com.africahealthlinkapp.e_treat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.africahealthlinkapp.e_treat.adapter.CartAdapter;
import com.africahealthlinkapp.e_treat.databinding.ActivityCartBinding;
import com.africahealthlinkapp.e_treat.models.Drug;
import com.africahealthlinkapp.e_treat.ui.Home;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Cart extends AppCompatActivity {

    private ActivityCartBinding mCartBinding;
    private String mKey;
    private String mUid;
    private DatabaseReference mMCartRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCartBinding = DataBindingUtil.setContentView(this, R.layout.activity_cart);
        mKey = getIntent().getStringExtra("key");
        mUid = getIntent().getStringExtra("uid");
        mMCartRef = FirebaseDatabase.getInstance().getReference()
                .child("cart").child(mUid);


        populateCart();
    }

//    public void removeItem(View view) {
//        mMCartRef.child(mKey).removeValue();
//    }

    public void populateCart() {
        mMCartRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.getChildrenCount() == 0) {
                    finish();
                }
                int price = 0;
                List<Drug> drugList = new ArrayList<>();
                Iterable<DataSnapshot> drugs = snapshot.getChildren();

                for (DataSnapshot drg : drugs) {

                    Drug c = drg.getValue(Drug.class);
                    int value = Integer.parseInt(drg.child("price").getValue(String.class));
                    price += value;
                    String tprice = String.valueOf(price);
                    mCartBinding.totalAmount.setText("$" + tprice);

                    Log.d("drg:: ", c.getName() + " " + c.getPrice());
                    drugList.add(c);
                    RecyclerView mDrugRecycler = mCartBinding.cartrecyclerView;
                    mCartBinding.profressCart.setVisibility(View.GONE);

                    mDrugRecycler.setLayoutManager(new LinearLayoutManager(Cart.this));
                    CartAdapter drugAdapter = new CartAdapter(Cart.this, drugList);
                    mDrugRecycler.setAdapter(drugAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void checkOut(View view) {
        DatabaseReference cartRef = FirebaseDatabase.getInstance().getReference().child("cart").child(mUid);
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        Query cartQuery = cartRef;

        cartQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot cartSnapshot : dataSnapshot.getChildren()) {
                    cartSnapshot.getRef().removeValue();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
//                        Log.e(TAG, "onCancelled", databaseError.toException());
            }
        });
        Toast.makeText(this, "Checked Out", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, Home.class));
        finish();
    }

}