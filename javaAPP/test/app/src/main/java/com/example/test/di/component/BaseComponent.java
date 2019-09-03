package com.example.test.di.component;

import android.app.Application;

import com.example.test.di.module.APIModule;
import com.example.test.di.module.ApplicationModule;
import com.example.test.utils.ApiService;
import com.example.test.utils.rxjava.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Component;
import io.reactivex.disposables.CompositeDisposable;

@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                APIModule.class,
        }
)
public interface BaseComponent {
    void inject(Application application);

    ApiService getAPI();

    SchedulerProvider getSchedulerProvider();

    CompositeDisposable getCompositeDisposable();

}
