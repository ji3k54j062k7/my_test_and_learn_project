package com.example.imac.kotlin_spider.ui.readset

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.imac.kotlin_spider.R
import com.example.user1.kotlin_project_test.Base.BaseFragment

class ReadSetFragment:Fragment(),BaseFragment{
    override fun init() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_read_set, container, false)
    }
}