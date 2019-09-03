package com.example.imac.kotlin_spider.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.imac.kotlin_spider.database.dao.BookDataDao
import com.example.imac.kotlin_spider.database.entity.BookData

@Database(entities = [BookData::class],version =1 , exportSchema = false)
abstract class AppDatabase:RoomDatabase(){
    abstract fun bookDataDao():BookDataDao
    companion object {
        var instance :AppDatabase?=null

        fun getAppDatabase(context: Context):AppDatabase?{
            if(instance==null){
                synchronized(AppDatabase::class){
                    instance= Room.databaseBuilder(context.applicationContext,
                            AppDatabase::class.java,"bookdb").build()
                }
            }
            return instance
        }
        fun destroyDataBase(){
            instance = null
        }
    }
}