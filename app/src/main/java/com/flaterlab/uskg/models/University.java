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

    @SerializedName("address")
    @Expose
    private String address;

    @SerializedName("city")
    @Expose
    private String city;

    @SerializedName("founded")
    @Expose
    private String founded;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("entrance-info")
    @Expose
    private String entranceInfo;

    @Embedded
    @SerializedName("contacts")
    @Expose
    private Contacts contacts;

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

    @TypeConverters(MajorTypeConverter.class)
    @ColumnInfo(name = "institutions")
    @SerializedName("institutions")
    @Expose
    private List<Major> institutions = null;

    @SerializedName("teachers")
    @Expose
    private int teachers;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFounded() {
        return founded;
    }

    public void setFounded(String founded) {
        this.founded = founded;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEntranceInfo() {
        return entranceInfo;
    }

    public void setEntranceInfo(String entranceInfo) {
        this.entranceInfo = entranceInfo;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
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

    public void setMostPopularMajors(List<Major> mostPopularMajors) {
        this.mostPopularMajors = mostPopularMajors;
    }

    public List<Major> getInstitutions() {
        return institutions;
    }

    public void setInstitutions(List<Major> institutions) {
        this.institutions = institutions;
    }

    public int getTeachers() {
        return teachers;
    }

    public void setTeachers(int teachers) {
        this.teachers = teachers;
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
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", founded='" + founded + '\'' +
                ", description='" + description + '\'' +
                ", entranceInfo='" + entranceInfo + '\'' +
                ", contacts=" + contacts +
                ", rating=" + rating +
                ", campus=" + campus +
                ", mostPopularMajors=" + mostPopularMajors +
                ", institutions=" + institutions +
                ", teachers=" + teachers +
                ", students=" + students +
                '}';
    }
}