package com.flaterlab.uskg.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rating {

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

    @Override
    public String toString() {
        return "Rating{" +
                "general=" + general +
                ", medical=" + medical +
                ", technical=" + technical +
                ", humanity=" + humanity +
                '}';
    }
}