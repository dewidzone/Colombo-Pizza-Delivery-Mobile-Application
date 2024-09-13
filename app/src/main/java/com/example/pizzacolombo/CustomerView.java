package com.example.pizzacolombo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;


public class CustomerView extends AppCompatActivity {

    List<Model> modelList;
    RecyclerView recyclerView;
    OrderAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_view);

        modelList = new ArrayList<>();
        modelList.add(new Model("Sausage Pizza", getString(R.string.SausagePizza), R.drawable.seafoodpizza));
        modelList.add(new Model("Cheese Pizza", getString(R.string.CheesePizza), R.drawable.cheese_pinaple));
        modelList.add(new Model("Mighty Meaty Pizza", getString(R.string.MightyMeatyPizza), R.drawable.meatloadedpizza));
        modelList.add(new Model("Chicken Nugget", getString(R.string.ChickenNugget), R.drawable.nugget));
        modelList.add(new Model("Garlic Bread", getString(R.string.GarlicBread), R.drawable.bread));
        modelList.add(new Model("Chocolate Milkshake", getString(R.string.ChocolateMilkshake), R.drawable.cmilkshake));
        modelList.add(new Model("Strawberry Milkshake", getString(R.string.StrawberryMilkshake), R.drawable.smilkshake));

        // recyclerview
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(null));

        // adapter
        mAdapter = new OrderAdapter(this, modelList);
        recyclerView.setAdapter(mAdapter);

    }
}