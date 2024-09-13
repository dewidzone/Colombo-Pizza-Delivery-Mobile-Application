package com.example.pizzacolombo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context) {
        super(context, "Activity.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Userdetails(ItemName TEXT primary key, ItemPrice INTEGER, ItemCategory TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Userdetails");
    }

    public boolean insertuserdata(String ItemName, Integer ItemPrice, String ItemCategory)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ItemName", ItemName);
        contentValues.put("ItemPrice", ItemPrice);
        contentValues.put("ItemCategory", ItemCategory);
        long result=DB.insert("Userdetails", null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }
    public boolean updateuserdata(String ItemName, Integer ItemPrice, String ItemCategory)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ItemName", ItemName);
        contentValues.put("ItemPrice", ItemPrice);
        contentValues.put("ItemCategory", ItemCategory);
        Cursor cursor = DB.rawQuery
                ("Select * from Userdetails where ItemName = ?", new String[]{ItemName});
        if (cursor.getCount() > 0) {
            long result = DB.update
                    ("Userdetails", contentValues, "ItemName=?", new String[]{ItemName});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
    public boolean deletedata (String ItemName)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        Cursor cursor = DB.rawQuery("Select * from Userdetails where ItemName = ?", new String[]{ItemName});
        if (cursor.getCount() > 0) {
            long result = DB.delete("Userdetails",  "ItemName=?", new String[]{ItemName});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Cursor getdata ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails", null);
        return cursor;
    }
}