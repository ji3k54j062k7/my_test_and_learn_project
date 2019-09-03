package com.example.imac.kotlin_spider.main

import android.content.Context
import android.support.v4.app.Fragment
import android.widget.BaseAdapter
import com.example.user1.kotlin_project_test.Base.BaseAttacher
import com.example.user1.kotlin_project_test.Base.BaseView

class MainContract {
    interface View : BaseView {
    }
    interface Adapter :BaseAttacher<View> {
    }
}