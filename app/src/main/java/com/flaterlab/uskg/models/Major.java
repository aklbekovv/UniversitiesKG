package com.flaterlab.uskg.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Major {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("lowest-fee")
    @Expose
    private long lowestFee;

    @SerializedName("highest-fee")
    @Expose
    private long highestFee;

    @SerializedName("currency")
    @Expose
    private String currency;

    @SerializedName("prestigious")
    @Expose
    private Double prestigious;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getLowestFee() {
        return lowestFee;
    }

    public void setLowestFee(long lowestFee) {
        this.lowestFee = lowestFee;
    }

    public long getHighestFee() {
        return highestFee;
    }

    public void setHighestFee(long highestFee) {
        this.highestFee = highestFee;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getPrestigious() {
        return prestigious;
    }

    public void setPrestigious(Double prestigious) {
        this.prestigious = prestigious;
    }

    @Override
    public String toString() {
        return "Major{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lowestFee=" + lowestFee +
                ", highestFee=" + highestFee +
                ", currency='" + currency + '\'' +
                ", prestigious=" + prestigious +
                '}';
    }
}