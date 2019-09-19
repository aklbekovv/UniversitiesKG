package com.flaterlab.uskg.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Major {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("percentage")
    @Expose
    private Double percentage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Major{" +
                "name='" + name + '\'' +
                ", percentage=" + percentage +
                '}';
    }
}