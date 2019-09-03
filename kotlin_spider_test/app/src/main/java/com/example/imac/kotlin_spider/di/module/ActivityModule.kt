package com.example.user1.kotlin_project_test.di.module

import android.app.Activity
import dagger.Module
import dagger.Provides

/**
 * Created by user1 on 2018/8/26.
 */
@Module
class ActivityModule(private var activity: Activity) {

    @Provides
    internal fun provideActivity(): Activity {
        return activity
    }
}