package com.example.pizzacolombo;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class AdminActivity extends AppCompatActivity {
    EditText ItemName, ItemPrice, ItemCategory;
    Button Add, Update, Delete, View;
    Database DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_admin);
        ItemName = findViewById(R.id.ItemName);
        ItemPrice = findViewById(R.id.ItemPrice);
        ItemCategory = findViewById(R.id.ItemCategory);

        Add = findViewById(R.id.add_btn);
        Delete = findViewById(R.id.delete_btn);
        Update = findViewById(R.id.update_btn);
        View = findViewById(R.id.view_btn);

        DB = new Database(this);

        Add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String ItemNameTXT = ItemName.getText().toString();
                Integer ItemPriceTXT = Integer.parseInt (ItemPrice.getText().toString());
                String ItemCategoryTXT = ItemCategory.getText().toString();

                boolean checkInsertData = DB.insertuserdata(ItemNameTXT, ItemPriceTXT, ItemCategoryTXT);
                if(checkInsertData)
                    Toast.makeText(AdminActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(AdminActivity.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
                DB.close();
            }
        });

        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ItemNameTXT = ItemName.getText().toString();
                Integer ItemPriceTXT = Integer.parseInt(ItemPrice.getText().toString());
                String ItemCategoryTXT = ItemCategory.getText().toString();

                boolean checkUpdateData = DB.updateuserdata(ItemNameTXT, ItemPriceTXT, ItemCategoryTXT);
                if(checkUpdateData)
                    Toast.makeText(AdminActivity.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(AdminActivity.this, "New Entry Not Updated", Toast.LENGTH_SHORT).show();
                DB.close();
            }
        });

        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ItemNameTXT = ItemName.getText().toString();
                boolean checkDeleteData = DB.deletedata(ItemNameTXT);
                if(checkDeleteData)
                    Toast.makeText(AdminActivity.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(AdminActivity.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
                DB.close();
            }
        });

        View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdata();
                if(res.getCount() == 0){
                    Toast.makeText(AdminActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Item Name :"+res.getString(0)+"\n");
                    buffer.append("Item Price (Rs.) :"+res.getString(1)+"\n");
                    buffer.append("Category of Item :"+res.getString(2)+"\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(AdminActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Item Overview");
                builder.setMessage(buffer.toString());
                builder.show();
                DB.close();
            }
        });
    }
}