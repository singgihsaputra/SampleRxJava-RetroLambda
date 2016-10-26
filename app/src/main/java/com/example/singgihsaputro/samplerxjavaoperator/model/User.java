package com.example.singgihsaputro.samplerxjavaoperator.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by singgihsaputro on 10/25/16.
 */

public class User {

    public User(int id, String firstname, String lastname, boolean isFollowing) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.isFollowing = isFollowing;
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

    public boolean isFollowing() {
        return isFollowing;
    }

    public void setFollowing(boolean following) {
        isFollowing = following;
    }

    @SerializedName("id")
    public int id;
    @SerializedName("firstname")
    public String firstname;
    @SerializedName("lastname")
    public String lastname;
    @SerializedName("isFollowing")
    public boolean isFollowing;
}
