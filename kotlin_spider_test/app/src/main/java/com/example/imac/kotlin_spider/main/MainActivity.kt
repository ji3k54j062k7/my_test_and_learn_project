package com.example.imac.kotlin_spider.main

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.imac.kotlin_spider.R
import com.example.imac.kotlin_spider.databinding.ActivityMainBinding
import com.example.user1.kotlin_project_test.di.component.DaggerActivityComponent
import com.example.user1.kotlin_project_test.di.module.ActivityModule

class MainActivity : AppCompatActivity(),MainContract.View {
    private lateinit  var mAdpater: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }
    override fun init() {
        mAdpater=MainAdapter(supportFragmentManager)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_main
        )
        binding.view = this
        val activityComponent = DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this))
                .build()
        activityComponent.inject(this)
//        mAdpater.addFragment(FragmentPersonalBook(),this.resources.getString(R.string.title_personal_book))
//        mAdpater.addFragment(FragmentBookLabel(),this.resources.getString(R.string.title_book_label))
//        mAdpater.addFragment(FragmentSearchBook(),this.resources.getString(R.string.title_read_set))
//        mAdpater.addFragment(FragmentReadSet(),this.resources.getString(R.string.title_read_set))
        binding.mainViewPage.adapter=mAdpater
        binding.mainTab.setupWithViewPager(binding.mainViewPage)
    }
}
