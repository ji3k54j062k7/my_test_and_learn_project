package com.example.test.ui.main;

import android.util.Log;

import com.example.test.base.BasePresenter;
import com.example.test.utils.ApiService;
import com.example.test.utils.DataResponse;
import com.example.test.utils.HttpMethods;
import com.example.test.utils.rxjava.SchedulerProvider;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

public class MainPresenter<V extends MainContract.View>  extends BasePresenter<V> implements MainContract.Presenter<V>{
    User user;
    @Inject
    public MainPresenter(ApiService api,
                         SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        super(api,schedulerProvider,compositeDisposable);
    }


    @Override
    public void setData(User user) {
        this.user=user;
    }

    @Override
    public void getData() {
        getCompositeDisposable().add((Disposable) getApiService().getData()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribeWith(new DisposableObserver<List<DataResponse>>() {
                    @Override
                    public void onNext(List<DataResponse> dataResponses) {
                        Log.d("MAIN", "获取数据完成" + dataResponses.size());
                        getView().getListToSetView(dataResponses);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("MAIN", "error" + e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.d("MAIN", "onComplete");
                    }
                })

        );

//
//        HttpMethods.getInstance().getJoke(new Observer<List<DataResponse>>() {
//            Disposable d;
//            @Override
//            public void onSubscribe(Disposable d) {
//                this.d=d;
//            }
//
//            @Override
//            public void onNext(List<DataResponse> dataResponses) {
//                Log.d("MAIN", "获取数据完成" + dataResponses.size());
//                getView().getListToSetView(dataResponses);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.d("MAIN", "error" + e.toString());
//                d.dispose();
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d("MAIN", "onComplete");
//                d.dispose();
//            }
//        });
    }
}