package com.example.singgihsaputro.samplerxjavaoperator.model;

import com.example.singgihsaputro.samplerxjavaoperator.model.User;
import com.example.singgihsaputro.samplerxjavaoperator.model.UserDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by singgihsaputro on 10/25/16.
 */

public class MockUser {
    private User mUser;
    private UserDetail mUserDetail;
    private List<User> ls_user = new ArrayList<User>();
    private List<UserDetail> user_detail = new ArrayList<>();

    public List<User> generateUser(){
        if(ls_user.size()==0) {
            mUser = new User(1, "Ichiji", "satu", true);
            ls_user.add(mUser);

            mUser = new User(2, "Niji", "dua", false);
            ls_user.add(mUser);

            mUser = new User(3, "Sanji", "tiga", true);
            ls_user.add(mUser);

            mUser = new User(4, "Yonji", "empat", false);
            ls_user.add(mUser);

            mUser = new User(5, "Goji", "lima", false);
            ls_user.add(mUser);
        }

        return ls_user;
    }

    public List<UserDetail> generateDetail(){
        if(user_detail.size()==0) {
            mUserDetail = new UserDetail(1, "Ichiji", "satu", "Developer");
            user_detail.add(mUserDetail);

            mUserDetail = new UserDetail(3, "Niji", "dua", "Programmer");
            user_detail.add(mUserDetail);


            mUserDetail = new UserDetail(3, "Goji", "lima", "PM");
            user_detail.add(mUserDetail);
        }

        return user_detail;
    }
}
