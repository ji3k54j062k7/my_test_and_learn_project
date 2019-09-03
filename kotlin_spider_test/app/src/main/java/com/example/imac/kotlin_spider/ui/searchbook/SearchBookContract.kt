package com.example.imac.kotlin_spider.ui.searchbook

import com.example.user1.kotlin_project_test.Base.BaseAttacher
import com.example.user1.kotlin_project_test.Base.BaseView

interface SearchBookContract{
    interface View : BaseView {
    }
    interface ViewModel{
        fun onSearch(data:SearchBookData)
        fun onFantasy(data:SearchBookData)
        fun onCity(data:SearchBookData)
        fun onMartialArts(data:SearchBookData)
        fun onMilitary(data:SearchBookData)
        fun onOnlineGameOrSports(data:SearchBookData)
        fun onScienceFiction(data:SearchBookData)
        fun onAnime(data:SearchBookData)
        fun onEndBook(data:SearchBookData)
    }
    interface Adapter : BaseAttacher<View> {
    }
}