package com.babydragons.oneride.oneride.models;

public class User {
//    private String username;
    private int balance;
    private String day;
    private String rideOrDrive;
    private String startTime;
    private String endTime;
    private String address;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getRideOrDrive() {
        return rideOrDrive;
    }

    public void setRideOrDrive(String rideOrDrive) {
        this.rideOrDrive = rideOrDrive;
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

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
