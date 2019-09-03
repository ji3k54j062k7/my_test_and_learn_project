package com.example.imac.kotlin_spider.database.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class BookData constructor(
        @ColumnInfo(name = "bookid")
        @PrimaryKey(autoGenerate = true)
        var bookId: Int,
        @ColumnInfo(name = "name")
        var name: String,
        @ColumnInfo(name = "autho")
        var autho: String,
        @ColumnInfo(name = "introduction")
        var Introduction:String,
        @ColumnInfo(name = "currentContent")
        var currentContent:String,
        @ColumnInfo(name = "url")
        var url:String,
        @ColumnInfo(name = "bookmark")
        var bookMark:String,
        @ColumnInfo(name="currentsize")
        var currentSize:Int
)
