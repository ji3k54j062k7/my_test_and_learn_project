package com.example.test.di.module.main;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.example.test.di.annotation.main.MainAnnotation;
import com.example.test.ui.main.MainContract;
import com.example.test.ui.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    private AppCompatActivity activity;

    public MainModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return activity;
    }

    @Provides
    @MainAnnotation
    Context provideContext() {
        return activity;
    }

    @Provides
    @MainAnnotation
    MainContract.Presenter<MainContract.View>providePresenter(
            MainPresenter<MainContract.View> presenter){
        return presenter;
    }

}
