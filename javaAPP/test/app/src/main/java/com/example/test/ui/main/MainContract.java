package com.example.test.ui.main;

import com.example.test.base.BaseAttacher;
import com.example.test.base.BaseView;
import com.example.test.utils.DataResponse;

import java.util.List;

public interface MainContract {
     interface View extends BaseView {
        void callVone(String s);
        void onButtonTest();
        void getListToSetView(List<DataResponse> dataResponses);
    }
    interface Presenter<V extends MainContract.View> extends BaseAttacher<V> {
        void setData(User user);
        void  getData();
    }
}
