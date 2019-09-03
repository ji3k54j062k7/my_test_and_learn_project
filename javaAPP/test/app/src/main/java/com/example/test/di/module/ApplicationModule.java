package com.example.test.di.module;

import android.app.Application;
import android.content.Context;

import com.example.test.utils.rxjava.SchedulerProvider;
import com.example.test.utils.rxjava.SchedulerProviderImp;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ApplicationModule {
    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    public Context provideContext() {
        return application.getApplicationContext();
    }

    @Provides
    public Application provideApplication() {
        return application;
    }

    @Provides
    public SchedulerProvider provideSchedulerProvider(SchedulerProviderImp schedulerProviderImp) {
        return schedulerProviderImp;
    }

    @Provides
    public Observable<Object> provideUIObservable(SchedulerProvider schedulerProvider) {
        return Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Object> e) throws Exception {
                e.onComplete();
            }
        }).subscribeOn(schedulerProvider.io()).observeOn(schedulerProvider.ui());
    }

    @Provides
    public CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

}
