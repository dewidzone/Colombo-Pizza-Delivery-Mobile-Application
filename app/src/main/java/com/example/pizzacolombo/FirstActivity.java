package com.example.pizzacolombo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FirstActivity extends AppCompatActivity {
private ConstraintLayout StartBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        StartBtn = findViewById(R.id.getStartedBtn);
        StartBtn.setOnClickListener(new  View.OnClickListener() {
    @Override
    public void onClick(View view){
        startActivity(new Intent(FirstActivity.this, MainActivity.class));
    }
        });
    }
}