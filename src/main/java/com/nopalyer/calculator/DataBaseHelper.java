package com.nopalyer.calculator;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.Toast;

import java.io.Console;
import java.util.ArrayList;

class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "Secret.db";
    public static final String TABLE_NAME = "PhoneBook";
    public static final String COL1 = "Name";
    public static final String COL2 = "Phone";
    public static final String TABLE_CREATE = "CREATE TABLE " + TABLE_NAME + " ("
            + COL1 + " TEXT , " + COL2 + " TEXT)";
    public static final String TABLE_NAME1 = "Photos";
    public static final String COL11 = "Name";
    public static final String COL22 = "Photo";
    public static final String TABLE_CREATE1 = "CREATE TABLE " + TABLE_NAME1 + " ("
            + COL11 + " TEXT , " + COL22 + " BLOB)";
    public static final String TABLE_NAME2 = "Pass";
    public static final String COL3 = "Pass";
    public static final String TABLE_CREATE2 = "CREATE TABLE " + TABLE_NAME2 + " ("
            + COL3 + " TEXT)";
    private static final String TAG = "LOG MSG ---> :";

    public DatabaseHelper(Context context) {

        super(context, DB_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(TABLE_CREATE);
        db.execSQL(TABLE_CREATE1);
        db.execSQL(TABLE_CREATE2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public boolean InsertPass(String text) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL3, text);
        ;
        try {
            sqLiteDatabase.insert(TABLE_NAME2, null, contentValues);
        } catch (SQLiteException e) {
            return false;
        }
        return true;
    }

    public void DeletePass() {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL("delete from " + TABLE_NAME2);

    }

    public boolean InsertNum(String text, String text2) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, text);
        ;
        contentValues.put(COL1, text2);
        ;
        try {
            sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        } catch (SQLiteException e) {
            return false;
        }
        return true;
    }

    public ArrayList pull(String x) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + TABLE_NAME, null);

        Log.d(TAG, "" + cursor.getCount() + " string names are: ");
        String[] arr = new String[cursor.getCount()];
        int i = 0;


        cursor.moveToFirst();
        while (i < cursor.getCount()) {
            try {
                arr[i] = cursor.getString(cursor.getColumnIndex(x));
                Log.d(TAG, "ARR[i] is" + arr[i]);
            } catch (CursorIndexOutOfBoundsException e) {
                arr[i] = "FAULT";
                Log.d(TAG, e.getMessage());
            }
            i++;
            cursor.moveToNext();
        }

        ArrayList<String> arr1 = new ArrayList<>();
        for (i = 0; i < arr.length; i++) {
            arr1.add(arr[i]);
        }
        return arr1;
    }

    public String pullPass() {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + TABLE_NAME2, null);

        Log.d(TAG, "" + cursor.getCount() + " string names are: ");
        String[] arr = new String[cursor.getCount()];
        int i = 0;


        cursor.moveToFirst();
        while (i < cursor.getCount()) {
            try {
                arr[i] = cursor.getString(cursor.getColumnIndex(COL3));
                Log.d(TAG, "ARR[i] is" + arr[i]);
            } catch (CursorIndexOutOfBoundsException e) {
                arr[i] = "FAULT";
                Log.d(TAG, e.getMessage());
            }
            i++;
            cursor.moveToNext();
        }

        ArrayList<String> arr1 = new ArrayList<>();
        for (i = 0; i < arr.length; i++) {
            arr1.add(arr[i]);
        }
        return arr[0];
    }
    public String pullPass1() {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + TABLE_NAME2, null);

        Log.d(TAG, "" + cursor.getCount() + " string names are: ");
        String[] arr = new String[cursor.getCount()];
        int i = 0;


        cursor.moveToFirst();
        while (i < cursor.getCount()) {
            try {
                arr[i] = cursor.getString(cursor.getColumnIndex(COL3));
                Log.d(TAG, "ARR[i] is" + arr[i]);
            } catch (CursorIndexOutOfBoundsException e) {
                arr[i] = "FAULT";
                Log.d(TAG, e.getMessage());
            }
            i++;
            cursor.moveToNext();
        }

        ArrayList<String> arr1 = new ArrayList<>();
        for (i = 0; i < arr.length; i++) {
            arr1.add(arr[i]);
        }
        return arr[1];
    }


    public void Delete(String name) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Log.d(TAG, "Delete: ->" + "delete from " + TABLE_NAME + " where " + COL1 + "='" + name + "'");
        sqLiteDatabase.execSQL("delete from " + TABLE_NAME + " where " + COL1 + "='" + name + "'");

    }
    public boolean CheckExsist(String name) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        //sqLiteDatabase.execSQL("select 1 from " + TABLE_NAME + " where " + COL1 + "='" + name + "'");

        Cursor cursor = sqLiteDatabase.rawQuery("select 1 from " + TABLE_NAME + " where " + COL1 + "='" + name + "'",null);
        if (cursor.getCount()<=0)
            return false;
        return true;


    }
    public boolean CheckPass(String name) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        //sqLiteDatabase.execSQL("select 1 from " + TABLE_NAME + " where " + COL1 + "='" + name + "'");

        Cursor cursor = sqLiteDatabase.rawQuery("select 1 from " + TABLE_NAME2 + " where " + COL3 + "='" + name + "'",null);
        if (cursor.getCount()<=0)
            return false;
        return true;


    }
    public void addPhoto( String name, byte[] image) throws SQLiteException{
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues cv = new  ContentValues();
        cv.put(COL11,    name);
        cv.put(COL22,   image);
        database.insert( TABLE_NAME1, null, cv );
    }

    public ArrayList<byte[]> retrievePhoto()
    {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + TABLE_NAME1, null);

        Log.d(TAG, "" + cursor.getCount() + " string names are: ");
        ArrayList<byte[]> arr=new ArrayList<>();

        int i = 0;


        cursor.moveToFirst();
        while (i < cursor.getCount()) {
            try {
                arr.add(cursor.getBlob(cursor.getColumnIndex(COL22)));
            } catch (CursorIndexOutOfBoundsException e) {

                Log.d(TAG, e.getMessage());
            }
            i++;
            cursor.moveToNext();
        }

        return arr;
    }
}