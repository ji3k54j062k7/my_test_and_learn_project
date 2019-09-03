package com.example.user1.kotlin_project_test.di.component

import com.example.imac.kotlin_spider.main.MainActivity
import com.example.user1.kotlin_project_test.di.module.ActivityModule
import dagger.Component
/**
 * Created by user1 on 2018/8/26.
 */
@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)
}