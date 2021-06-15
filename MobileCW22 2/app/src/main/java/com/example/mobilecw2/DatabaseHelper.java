package com.example.mobilecw2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DataBase_Name = "Moviedata.db";
    public static final String Table_Name = "movie_table";
    public static final String COLUMN_1 = "ID";
    public static final String COLUMN_2 = "MOVIENAME";
    public static final String COLUMN_3 = "RELEASEDYEAR";
    public static final String COLUMN_4 = "DIRECTOR";
    public static final String COLUMN_5 = "RATINGS";
    public static final String COLUMN_6 = "CASTS";
    public static final String COLUMN_7 = "REVIEW";
    

    public DatabaseHelper(Context context) {
        super(context, DataBase_Name, null, 1);
    }

    //create a table
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + Table_Name +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,MOVIENAME TEXT,RELEASEDYEAR INTEGER,DIRECTOR TEXT,RATINGS TEXT,CASTS TEXT,REVIEW TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ Table_Name);
        onCreate(db);
    }
//insert data
    public boolean insert_User_Data(String moviename, String releasedyear, String director, String ratings, String casts, String review) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_2,moviename);
        contentValues.put(COLUMN_3,releasedyear);
        contentValues.put(COLUMN_4,director);
        contentValues.put(COLUMN_6,casts);
        contentValues.put(COLUMN_5,ratings);
        contentValues.put(COLUMN_7,review);
        long result = db.insert(Table_Name,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
//get data from all
    public Cursor getAll_Data() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+ Table_Name,null);
        return res;
    }
//to update data
    public boolean update_Data(String id, String moviename, String releasedyear, String director, String ratings, String casts, String review) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_1,id);
        contentValues.put(COLUMN_2,moviename);
        contentValues.put(COLUMN_3,releasedyear);
        contentValues.put(COLUMN_4,director);
        contentValues.put(COLUMN_6,casts);
        contentValues.put(COLUMN_5,ratings);
        contentValues.put(COLUMN_7,review);

        db.update(Table_Name, contentValues, "ID = ?",new String[] { id });
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(Table_Name, "ID = ?",new String[] {id});//return the values
    }
    //search
    public Cursor fetch_Data(String id){


        SQLiteDatabase database = getReadableDatabase();

        Cursor cursor = database.query(Table_Name, new String[]{COLUMN_1, COLUMN_2,COLUMN_3, COLUMN_4,COLUMN_5, COLUMN_6,COLUMN_7}, COLUMN_1 + "=?",new String[]{id},null,null,null );
        return cursor;
    }
}


//references : https://youtube.com/playlist?list=PLSrm9z4zp4mGK0g_0_jxYGgg3os9tqRUQ
//https://youtu.be/5_jyEGe6ZHo
