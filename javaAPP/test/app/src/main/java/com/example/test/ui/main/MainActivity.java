package com.example.test.ui.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.test.R;
import com.example.test.base.BaseActivity;
import com.example.test.databinding.ActivityMainBinding;
import com.example.test.di.component.main.DaggerMainComponent;
import com.example.test.di.component.main.MainComponent;
import com.example.test.di.module.main.MainModule;
import com.example.test.utils.Application;
import com.example.test.utils.DataResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainContract.View {
//    private MainPresenter presenter;
    @Inject
    MainContract.Presenter<MainContract.View> mPresenter;

    private User user;
    private ActivityMainBinding activityMainBinding;
    private MainComponent mainComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user =new User();
        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        mainComponent = DaggerMainComponent.builder()
                .mainModule(new MainModule(this))
                .baseComponent(((Application) super.getApplication()).getApplicationComponent())
                .build();
        mainComponent.inject(this);
        activityMainBinding.setData(user);
        activityMainBinding.setView(this);
        user.setEmail(activityMainBinding.email.toString());
        user.setFullName(activityMainBinding.name.toString());
        activityMainBinding.setData(user);
        user.setEmail("2222222222222");
        user.setFullName("4greger");
        mPresenter.onAttached(this);
        mPresenter.setData(user);
    }
    @Override
    public void init() {

    }
    @Override
    public void callVone(String s) {
        Log.e("ggggg","Activity:"+s);
    }

    @Override
    public void onButtonTest() {
//        activityMainBinding.setData(user);
//        activityMainBinding.email.setText(user.getEmail());
//        activityMainBinding.name.setText(user.getFullName());
        mPresenter.getData();
    }

    @Override
    public void getListToSetView(List<DataResponse> dataResponses) {
        Log.e("dataSizeOnDataResponses",""+dataResponses.size());
        Log.e("dataOnDataResponses","Title:"+dataResponses.get(0).getTitle());
        Log.e("dataOnDataResponses","Url:"+dataResponses.get(0).getUrl());
        Log.e("dataOnDataResponses","Content:"+dataResponses.get(0).getContent());
        Log.e("dataOnDataResponses","Poster:"+dataResponses.get(0).getPoster());

    }

}
