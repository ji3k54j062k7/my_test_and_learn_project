package com.example.user1.kotlin_project_test.Base

/**
 * Created by user1 on 2018/8/22.
 */
interface BaseAttacher<in V>{
    fun onAttached(view : V )

    fun onDetached()
}