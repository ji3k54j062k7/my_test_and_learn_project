package com.example.test.base;

public interface BaseAttacher<V extends BaseView> {
    void onAttached(V view);

    void onDetached();
}
