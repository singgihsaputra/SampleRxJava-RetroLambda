package com.example.singgihsaputro.samplerxjavaoperator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.example.singgihsaputro.samplerxjavaoperator.model.MockUser;
import com.example.singgihsaputro.samplerxjavaoperator.model.User;
import com.example.singgihsaputro.samplerxjavaoperator.model.UserDetail;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func2;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.tv_result)
    TextView tv_result;

    MockUser mcUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mcUser = new MockUser();
        ButterKnife.bind(this);
        tv_result.setMovementMethod(new ScrollingMovementMethod());
    }

    private Observable<User> getAllMyFriendsObservable() {
        return Observable.from(mcUser.generateUser());
    }

    private Observable<UserDetail> getUserDetailObservable() {
        return Observable.from(mcUser.generateDetail());
    }


    @OnClick(R.id.btn_map)
    public void data_mapping(){
        tv_result.setText("");
        getAllMyFriendsObservable()
                .map(user -> user)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(user -> tv_result.append(user.getId()+" - "+user.getFirstname()+"\n"));
    }

    @OnClick(R.id.btn_flat)
    public void data_flat(){
        tv_result.setText("");
        getAllMyFriendsObservable()
                .flatMap(user -> Observable.just(user))
                .filter(user -> !user.isFollowing())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(user -> tv_result.append(user.getId()+" - "+user.getFirstname()+"\n"));
    }

    @OnClick(R.id.btn_zip)
    public void combine_zip(){
        tv_result.setText("");
        Observable.zip(
                getAllMyFriendsObservable(),
                getUserDetailObservable(),
                (Func2<User, UserDetail, Object>)
                        (user, userDetail) -> user.getId() == userDetail.getId() ? user.getFirstname()+" - "+userDetail.getRole() : user.getFirstname()+" - null")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(user -> tv_result.append(user.toString()+"\n"), error -> tv_result.append("error"));
    }

    public void range(){
        Observable.range(4, 18)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(numb -> tv_result.append(numb.toString()+"\n"));
    }

}


