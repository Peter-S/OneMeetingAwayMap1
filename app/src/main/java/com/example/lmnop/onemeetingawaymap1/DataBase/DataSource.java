package com.example.lmnop.onemeetingawaymap1.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import com.example.lmnop.onemeetingawaymap1.model.DataItemMeetings;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    private Context mContext;
    private SQLiteDatabase mDatabase;
    SQLiteOpenHelper mDbHelper;


    public DataSource(Context context) {
        this.mContext = context;
        mDbHelper = new DBHelper(mContext);
        mDatabase =mDbHelper.getWritableDatabase();
    }

    public void open(){
        mDatabase =mDbHelper.getWritableDatabase();
    }

    public void close() {
        mDbHelper.close();
    }

    public DataItemMeetings createItem(DataItemMeetings item) {
        ContentValues values = item.toValues();
        mDatabase.insert(MeetingsTable.TABLE_ITEMS, null, values);
        return item;
    }

    public long getDataItemsCount() {
        return DatabaseUtils.queryNumEntries(mDatabase, MeetingsTable.TABLE_ITEMS);
    }

    public void seedDataBase(List<DataItemMeetings> dataItemMeetingsList) {
        long numItems = getDataItemsCount();
        if (numItems == 0) {
        for (DataItemMeetings item :
                dataItemMeetingsList) {
            try {
            createItem(item);
            } catch (SQLiteException e) {
                e.printStackTrace();
            }
        }
        Toast.makeText(mContext, "Data Inserted", Toast.LENGTH_SHORT).show();
        }else
        {
        Toast.makeText(mContext, "Data already inserted", Toast.LENGTH_SHORT).show();
        }
    }

    // QUERRY   ***********************************************************
    public List<DataItemMeetings> getAllItems() {
        List<DataItemMeetings> dataItems = new ArrayList<>();
        Cursor cursor =  mDatabase.query(MeetingsTable.TABLE_ITEMS,
                MeetingsTable.ALL_COLUMNS, null, null,
                null, null, null);

        while(cursor.moveToNext()) {
            DataItemMeetings item = new DataItemMeetings();
            item.setIdNumber(cursor.getString(cursor.getColumnIndex(MeetingsTable.COLUMN_ID)));
            item.setDay(cursor.getString(cursor.getColumnIndex(MeetingsTable.COLUMN_DAY)));
            item.setStartTime(cursor.getString(cursor.getColumnIndex(MeetingsTable.COLUMN_STARTTIME)));
            item.setEndTime(cursor.getString(cursor.getColumnIndex(MeetingsTable.COLUMN_ENDTIME)));
            item.setOc(cursor.getString(cursor.getColumnIndex(MeetingsTable.COLUMN_OC)));
            item.setMeetingName(cursor.getString(cursor.getColumnIndex(MeetingsTable.COLUMN_MEETINGNAME)));
            item.setLocation(cursor.getString(cursor.getColumnIndex(MeetingsTable.COLUMN_LOCATION)));
            item.setAddress(cursor.getString(cursor.getColumnIndex(MeetingsTable.COLUMN_ADDRESS)));
            item.setCodes(cursor.getString(cursor.getColumnIndex(MeetingsTable.COLUMN_CODES)));
            dataItems.add(item);
        }

        cursor.close();
        return dataItems;
    }
}


