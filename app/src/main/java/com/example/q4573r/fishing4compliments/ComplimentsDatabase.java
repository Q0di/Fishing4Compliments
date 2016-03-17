package com.example.q4573r.fishing4compliments;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Q0di on 3/13/2016.
 */
public class ComplimentsDatabase extends SQLiteOpenHelper {


        //variables
        private static final int DATABASE_VERSION = 1;
        private static final String DATABASE_NAME = "compliments.db";
        private static final String TABLE_COMPLIMENTS = "compliments";
        private static final String COLUMN_ID = "_id";
        private static final String COLUMN_COMPLIMENT="compliment";

 public ComplimentsDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    //magic words for making the table
        String query = "CREATE TABLE " + TABLE_COMPLIMENTS + "(" + COLUMN_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_COMPLIMENT + " TEXT " + ");";
    //*Poof* Table is now created
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMPLIMENTS);
        onCreate(db);
    }

    //add row
    public void addCompliment(Compliment compliment){

        ContentValues values = new ContentValues();
        values.put(COLUMN_COMPLIMENT, compliment.get_compliment());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_COMPLIMENTS, null, values);
        db.close();

    }

    //delete row
    public void deleteCompliment (String compliment){
        SQLiteDatabase db= getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_COMPLIMENTS + " WHERE " + COLUMN_COMPLIMENT +
                "=\"" + compliment + "\";");
    }

    private Compliment cursorToCompliment(Cursor c) {
        Compliment compliment = new Compliment();
        compliment.set_id(c.getInt(0));
        compliment.set_compliment(c.getString(1));

        return compliment;
    }

   //To String
    public List<Compliment> dbToString(){
        List<Compliment> compliments = new ArrayList<Compliment>();
        SQLiteDatabase db=getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_COMPLIMENTS + " WHERE 1";

        //CURSOR
        Cursor c = db.rawQuery(query,null);
        //go to first row in results

        c.moveToFirst();

        while(!c.isAfterLast()){
            Compliment compliment = cursorToCompliment(c);
            compliments.add(compliment);
            c.moveToNext();

        }
        db.close();

    return compliments;
    }

    public String grabRandomCompliment(){
        SQLiteDatabase db = getReadableDatabase();
       /*
       // returns all compliments
       String query = "SELECT * FROM " + TABLE_COMPLIMENTS + " ORDER BY RANDOM() LIMIT 1";
        Cursor c = db.rawQuery(query,null);
        db.close();*/

        //query that selects random string from DB
        Cursor c = db.query(TABLE_COMPLIMENTS + " ORDER BY RANDOM() LIMIT 1",
                new String[] { COLUMN_COMPLIMENT },null,null,null,null,null);

        //returns query
        if(c.moveToFirst())
            return c.getString(c.getColumnIndex(COLUMN_COMPLIMENT));
        else
        //if database is empty show this instead
            return "You are beautiful";

    }
}