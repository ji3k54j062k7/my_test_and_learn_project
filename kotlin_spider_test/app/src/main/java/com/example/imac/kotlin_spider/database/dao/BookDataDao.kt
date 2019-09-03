package com.example.imac.kotlin_spider.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.imac.kotlin_spider.database.entity.BookData

@Dao
interface BookDataDao{
    @get:Query("SELECT * FROM bookdata")
    val all: List<BookData>

    @Query("SELECT * FROM bookdata WHERE bookid IN (:bookid)")
    fun loadAllByIds(bookid: Array<Int>): List<BookData>

    @Insert
    fun insertAll(bookDataList: List<BookData>)

    @Delete
    fun delete(bookData: BookData)
}