package com.example.imac.kotlin_spider.di.module.searchbook

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import com.example.imac.kotlin_spider.ui.searchbook.SearchBookData
import com.example.imac.kotlin_spider.ui.searchbook.SearchBookModel
import dagger.Module
import dagger.Provides

@Module
class SearchBookModule(val activity: AppCompatActivity){
    @Provides
    internal fun provideActivity(): Activity {
        return activity
    }
    @Provides
    internal  fun provideViewModel():SearchBookModel {
        return SearchBookModel(SearchBookData())
    }
}