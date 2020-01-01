package com.liveinbits.rxjavamvvmremotelocaldb.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "employee")
public class Employee {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "firstname")
    @SerializedName("firstname")
    private String firstname;
    @ColumnInfo(name = "lastname")
    @SerializedName("lastname")
    private String lastname;
    @ColumnInfo(name = "age")
    @SerializedName("age")
    private String age;

    public Employee(String firstname, String lastname, String age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
