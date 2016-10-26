package com.example.singgihsaputro.samplerxjavaoperator.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by singgihsaputro on 10/25/16.
 */
public class UserDetail {

    @SerializedName("id")
    public int id;
    @SerializedName("firstname")
    public String firstname;
    @SerializedName("lastname")
    public String lastname;
    @SerializedName("role")
    public String role;

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

    public String getRole() {return role;    }

    public void setRole(String role) {      this.role = role;    }

    public UserDetail(int id, String firstname, String lastname, String role) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
    }


}
