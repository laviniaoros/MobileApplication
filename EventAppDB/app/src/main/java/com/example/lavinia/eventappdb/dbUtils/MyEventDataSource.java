package com.example.lavinia.eventappdb.dbUtils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import static com.example.lavinia.eventappdb.dbUtils.MySQLiteHelper.TABLE_EVENTS;

/**
 * Created by Lavinia on 12/12/2016.
 */

public class MyEventDataSource {

    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
            MySQLiteHelper.COLUMN_TITLE, MySQLiteHelper.COLUMN_DETAIL };

    public MyEventDataSource(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public MyEvent createEvent(String evTitle, String evDetails) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_TITLE,evTitle);
        values.put(MySQLiteHelper.COLUMN_DETAIL,evDetails);

        long insertId = database.insert(TABLE_EVENTS, null, values);
        Cursor cursor = database.query(TABLE_EVENTS,
                allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        MyEvent newEvent = cursorToEvent(cursor);
        cursor.close();
        return newEvent;
    }

    public void deleteEvent(MyEvent ev) {
        long id = ev.getId();
        database.delete(TABLE_EVENTS, MySQLiteHelper.COLUMN_ID
                + " = " + id, null);
    }

    public void updateEvent(long id, String newValue) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(MySQLiteHelper.COLUMN_DETAIL, newValue);
        System.out.println(cv.toString());
        System.out.println(MySQLiteHelper.TABLE_EVENTS);
        System.out.println(MySQLiteHelper.COLUMN_ID);
        db.update(TABLE_EVENTS, cv, MySQLiteHelper.COLUMN_ID + "=?" , new String[] {String.valueOf(id)});
    }


//        Cursor c=database.rawQuery(String.format("update %s set %s=%s where id='%s'",TABLE_EVENTS,MySQLiteHelper.COLUMN_DETAIL,newValue,id),null);
//        c.moveToFirst();
//        c.close();


    public List<MyEvent> getAllEvents() {
        List<MyEvent> events = new ArrayList<MyEvent>();

        Cursor cursor = database.query(TABLE_EVENTS,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            MyEvent ev = cursorToEvent(cursor);
            events.add(ev);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return events;
    }

    public  MyEvent getObjectById(long id){
        List<MyEvent> l= getAllEvents();
        for (MyEvent ev : l){
            if ( ev.getId()==id+1){
                return ev;
            }
        }
        return null;
    }

    private MyEvent cursorToEvent(Cursor cursor) {
        MyEvent ev = new MyEvent();
        ev.setId(cursor.getLong(0));
        ev.setTitle(cursor.getString(1));
        ev.setDetails(cursor.getString(2));

        return ev;
    }
}

