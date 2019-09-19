package com.flaterlab.uskg.models;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.flaterlab.uskg.data.CampusTypeConverter;
import com.flaterlab.uskg.data.MajorTypeConverter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

@Entity(tableName = "universities")
public class University implements Serializable {

    @PrimaryKey
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("abbreviation")
    @Expose
    private String abbreviation;

    @SerializedName("school-type")
    @Expose
    private String schoolType;

    @ColumnInfo(name = "icon-path")
    @SerializedName("icon-path")
    @Expose
    private String iconPath;

    @SerializedName("founded")
    @Expose
    private String founded;

    @SerializedName("location")
    @Expose
    private String location;

    @Embedded
    @SerializedName("rating")
    @Expose
    private Rating rating;

    @TypeConverters(CampusTypeConverter.class)
    @ColumnInfo(name = "campuses")
    @SerializedName("campuses")
    @Expose
    private List<Campus> campus = null;

    @TypeConverters(MajorTypeConverter.class)
    @ColumnInfo(name = "most-popular-majors")
    @SerializedName("most-popular-majors")
    @Expose
    private List<Major> mostPopularMajors = null;

    @SerializedName("students")
    @Expose
    private int students;

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

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(String schoolType) {
        this.schoolType = schoolType;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public String getFounded() {
        return founded;
    }

    public void setFounded(String founded) {
        this.founded = founded;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public List<Campus> getCampus() {
        return campus;
    }

    public void setCampus(List<Campus> campus) {
        this.campus = campus;
    }

    public List<Major> getMostPopularMajors() {
        return mostPopularMajors;
    }

    public void setMostPopularMajors(List<Major> mostPopularMajor) {
        this.mostPopularMajors = mostPopularMajor;
    }

    public int getStudents() {
        return students;
    }

    public void setStudents(int students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", schoolType='" + schoolType + '\'' +
                ", iconPath='" + iconPath + '\'' +
                ", founded='" + founded + '\'' +
                ", location='" + location + '\'' +
                ", rating=" + rating +
                ", campus=" + campus +
                ", mostPopularMajors=" + mostPopularMajors +
                ", students=" + students +
                '}';
    }
}