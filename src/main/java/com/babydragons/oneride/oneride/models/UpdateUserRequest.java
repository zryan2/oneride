package com.babydragons.oneride.oneride.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdateUserRequest {
    @NotNull
    private String username;
    @NotBlank
    private int balance;
    @NotBlank
    private String rideOrDrive;
    @NotBlank
    private String startTime;
    @NotBlank
    private String endTime;
    @NotBlank
    private String day;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

    @Override
    public String toString() {
        return "UpdateUserRequest{" +
                "username='" + username + '\'' +
                ", balance=" + balance +
                ", rideOrDrive='" + rideOrDrive + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", day='" + day + '\'' +
                '}';
    }
}
