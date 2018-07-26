package com.example.lmnop.onemeetingawaymap1.model;

import android.content.ContentValues;

import com.example.lmnop.onemeetingawaymap1.DataBase.MeetingsTable;

import java.util.UUID;

public class DataItemMeetings {

    private String idNumber;
    private String day;
    private String startTime;
    private String endTime;
    private String oc;
    private String meetingName;
    private String location;
    private String address;
    private String codes;

    public DataItemMeetings() {
    }

    public DataItemMeetings(String idNumber, String day, String startTime,
                            String endTime, String oc, String meetingName,
                            String location, String address, String codes) {
        if (idNumber == null) {
            idNumber = UUID.randomUUID().toString();
        }

        this.idNumber = idNumber;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.oc = oc;
        this.meetingName = meetingName;
        this.location = location;
        this.address = address;
        this.codes = codes;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getOc() {
        return oc;
    }

    public void setOc(String oc) {
        this.oc = oc;
    }

    public String getMeetingName() {
        return meetingName;
    }

    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCodes() {
        return codes;
    }

    public void setCodes(String codes) {
        this.codes = codes;
    }

    public ContentValues toValues() {
        ContentValues values = new ContentValues(9);
        values.put(MeetingsTable.COLUMN_ID, idNumber);
        values.put(MeetingsTable.COLUMN_DAY, day);
        values.put(MeetingsTable.COLUMN_STARTTIME, startTime);
        values.put(MeetingsTable.COLUMN_ENDTIME, endTime);
        values.put(MeetingsTable.COLUMN_OC, oc);
        values.put(MeetingsTable.COLUMN_MEETINGNAME, meetingName);
        values.put(MeetingsTable.COLUMN_LOCATION, location);
        values.put(MeetingsTable.COLUMN_ADDRESS, address);
        values.put(MeetingsTable.COLUMN_CODES, codes);
        return values;
    }

    @Override
    public String toString() {
        return "DataItemMeetings{" +
                "idNumber='" + idNumber + '\'' +
                ", day='" + day + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", oc='" + oc + '\'' +
                ", meetingName='" + meetingName + '\'' +
                ", location='" + location + '\'' +
                ", address='" + address + '\'' +
                ", codes='" + codes + '\'' +
                '}';
    }
}


