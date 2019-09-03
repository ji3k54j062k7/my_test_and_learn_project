package com.example.imac.kotlin_room_test

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.imac.kotlin_room_test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mBinding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        var data =MainData("a","b")
        mBinding.vm=MainViewModel(data)
    }
}
