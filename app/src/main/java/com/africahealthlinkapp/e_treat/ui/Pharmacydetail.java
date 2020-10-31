package com.africahealthlinkapp.e_treat.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.africahealthlinkapp.e_treat.adapter.DrugAdapter;
import com.africahealthlinkapp.e_treat.R;
import com.africahealthlinkapp.e_treat.models.Drug;

import java.util.ArrayList;
import java.util.List;

/*
hello every body -
this is me ECHOMAN - mohamed alfedawy
this is part of andela community project
this activity shows pharmacy detail activity
where user can order the needed drugs
Echoman0101@gmail.com
 */
public class Pharmacydetail extends AppCompatActivity {
    private List<Drug> drugslist;
    private DrugAdapter mDrugAdapter;
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacydetail);
        drugslist = new ArrayList<>();
//dummy drugs
        Drug drug1 = new Drug("plavix", "75 mg", 100);
        drugslist.add(drug1);
        Drug drug2 = new Drug("crestor", "20 mg", 150);
        drugslist.add(drug2);
        Drug drug3 = new Drug("Aspirin", "75 mg", 75);
        drugslist.add(drug3);
        Drug drug4 = new Drug("cidophage", "1000 mg", 200);
        drugslist.add(drug4);
        Drug drug5 = new Drug("concor", "10 mg", 50);
        drugslist.add(drug5);
        Drug drug6 = new Drug("capotin", "25 mg", 180);
        drugslist.add(drug6);
        Drug drug7 = new Drug("adancor", "10 mg", 30);
        drugslist.add(drug7);
        Drug drug8 = new Drug("vastarel", "35 mg", 18);
        drugslist.add(drug8);
        Drug drug9 = new Drug("clexan", "75 mg", 10);
        drugslist.add(drug9);
        Drug drug10 = new Drug("seloken", "200 mg", 100);
        drugslist.add(drug10);


        RecyclerView.LayoutManager manager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mDrugAdapter = new DrugAdapter(this, drugslist);
        mDrugAdapter.setList(drugslist);
        mRecyclerView = findViewById(R.id.recycler);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mDrugAdapter);
        mDrugAdapter.notifyDataSetChanged();


    }
}