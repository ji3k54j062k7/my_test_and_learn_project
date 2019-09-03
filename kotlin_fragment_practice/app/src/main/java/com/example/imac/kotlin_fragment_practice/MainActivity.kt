package com.example.imac.kotlin_fragment_practice

import android.app.Fragment
import android.app.FragmentManager
import android.app.FragmentTransaction
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import com.example.imac.kotlin_fragment_practice.R.id.add
import com.example.imac.kotlin_fragment_practice.R.id.fragment_layout
import com.example.imac.kotlin_fragment_practice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() ,MainContract.View, MainContract {
    override fun onChangee() {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_layout, FragmentB()).commit()
    }

    override fun onChange() {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_layout, FragmentA()).commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_main
        )
        binding.view=this
    }

}



