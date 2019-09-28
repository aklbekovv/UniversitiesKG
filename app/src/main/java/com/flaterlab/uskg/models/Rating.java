package com.flaterlab.uskg.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rating {
    public static final int GENERAL = 1;
    public static final int MEDICAL = 2;
    public static final int TECHNICAL = 3;
    public static final int HUMANITY = 4;
    public static final int LAW = 5;
    public static final int BUSINESS = 6;

    @SerializedName("general")
    @Expose
    private Double general;
    @SerializedName("medical")
    @Expose
    private Double medical;
    @SerializedName("technical")
    @Expose
    private Double technical;
    @SerializedName("humanity")
    @Expose
    private Double humanity;
    @SerializedName("law")
    @Expose
    private Double law;
    @SerializedName("business-man")
    @Expose
    private Double businessManagement;

    public Double getGeneral() {
        return general;
    }

    public void setGeneral(Double general) {
        this.general = general;
    }

    public Double getMedical() {
        return medical;
    }

    public void setMedical(Double medical) {
        this.medical = medical;
    }

    public Double getTechnical() {
        return technical;
    }

    public void setTechnical(Double technical) {
        this.technical = technical;
    }

    public Double getHumanity() {
        return humanity;
    }

    public void setHumanity(Double humanity) {
        this.humanity = humanity;
    }

    public Double getLaw() {
        return law;
    }

    public void setLaw(Double law) {
        this.law = law;
    }

    public Double getBusinessManagement() {
        return businessManagement;
    }

    public void setBusinessManagement(Double businessManagement) {
        this.businessManagement = businessManagement;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "general=" + general +
                ", medical=" + medical +
                ", technical=" + technical +
                ", humanity=" + humanity +
                ", law=" + law +
                ", businessManagement=" + businessManagement +
                '}';
    }
}