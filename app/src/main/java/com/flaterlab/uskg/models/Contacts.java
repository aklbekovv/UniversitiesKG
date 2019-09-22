package com.flaterlab.uskg.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Contacts {

    @SerializedName("website")
    @Expose
    private String website;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("phone-number")
    @Expose
    private String phoneNumber;

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "website='" + website + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
