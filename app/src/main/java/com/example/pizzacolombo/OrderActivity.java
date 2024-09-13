package com.example.pizzacolombo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {
    EditText Username, Password;
    Button Login_btn;
    Spinner Spinner_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Username = (EditText) findViewById(R.id.username);
        Password = (EditText) findViewById(R.id.password);
        Login_btn = (Button) findViewById(R.id.login_btn);
        Spinner_btn = (Spinner) findViewById(R.id.spinner_btn);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_btn,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        Spinner_btn.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String items = Spinner_btn.getSelectedItem().toString();

                if (items.equals("Customer") && Username.getText().toString().equals("customer") && Password.getText().toString().equals("customer")) {
                    Toast.makeText(getApplicationContext(),
                            "Successfully Login...!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), CustomerView.class);
                    startActivity(intent);
                } else if (items.equals("Administration") && Username.getText().toString().equals("admin") && Password.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(),
                            "Successfully Login", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), AdminActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Entered Wrong Username or Password", Toast.LENGTH_LONG).show();
                }


            }
        });

    }
}