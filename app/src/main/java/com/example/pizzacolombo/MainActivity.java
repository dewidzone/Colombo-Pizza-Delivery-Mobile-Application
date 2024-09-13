package com.example.pizzacolombo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout Order_btn;
    private ConstraintLayout Pizza_btn;
    private ConstraintLayout Beverage_btn;
    private ConstraintLayout Appetizer_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Order_btn = findViewById(R.id.order_btn);
        Pizza_btn = findViewById(R.id.pizza_btn);
        Beverage_btn = findViewById(R.id.beverage_btn);
        Appetizer_btn = findViewById(R.id.appetizer_btn);

        Order_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, OrderActivity.class));
            }
        });

        Pizza_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PizzaActivity.class));
            }
        });

        Beverage_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BeverageActivity.class));
            }
        });

        Appetizer_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AppetizerActivity.class));
            }
        });


    }
}
