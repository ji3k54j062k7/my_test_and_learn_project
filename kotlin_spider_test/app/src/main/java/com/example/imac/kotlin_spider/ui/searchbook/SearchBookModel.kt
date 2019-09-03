package com.example.imac.kotlin_spider.ui.searchbook

import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.util.Log
import com.example.imac.kotlin_spider.model.BookItem
import com.example.imac.kotlin_spider.model.SingleLiveData
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import org.jsoup.Jsoup
import java.util.ArrayList
import javax.inject.Inject


class SearchBookModel (val data:SearchBookData):SearchBookContract.ViewModel {
    var searchData:String=data.searchData
    val changePage = SingleLiveData<Pair<SearchBookData,Int>>()
    override fun onFantasy(data:SearchBookData) {
        changePage.value=data to 1
    }

    override fun onCity(data:SearchBookData) {
        changePage.value=data to 2
    }

    override fun onMartialArts(data:SearchBookData) {
        changePage.value=data to 3
    }
    override fun onMilitary(data:SearchBookData) {
        changePage.value=data to 4
    }

    override fun onOnlineGameOrSports(data:SearchBookData) {
        changePage.value=data to 5
    }

    override fun onScienceFiction(data:SearchBookData) {
        changePage.value=data to 6
    }

    override fun onAnime(data:SearchBookData) {
        changePage.value=data to 7
    }

    override fun onEndBook(data:SearchBookData) {
        changePage.value=data to 8
    }

    override fun onSearch(data:SearchBookData) {
        changePage.value=data to 9
        Log.e("ggggg",""+searchData)
        val url :String ="https://www.uukanshu.com/"
        Observable.just(searchData)
                .observeOn(Schedulers.io())
                .map {
                    val bookitemArrayList = ArrayList<BookItem>()
                    val doc = Jsoup.connect("https://www.uukanshu.com/list/xuanhuan-1.html").get()
                    val elements = doc.select("div.content").select("span")
                    Log.e("ggggggg",""+elements)
                    Log.e("eeeeee",""+elements.size)
                    for (element in elements) {
                        val name = element.select("a").attr("title")
                        Log.e("ffffff",""+name)
                        val detailurl=element.select("div.book-info").select( "a").attr("href")
                        Log.e("ddddd",""+detailurl)

                        val detail = element.select("p").select("a").text()
                        Log.e("tttttt",""+detail)
                        val upDataTime = element.select("p").select("span").attr("data")
                        Log.e("tttttttt",""+upDataTime)
                        val bookitem = BookItem(name, detail, upDataTime, detailurl)
                        if (detailurl.equals("")){
                            Log.e("kkkkkk","no")
                        }else{
                            bookitemArrayList.add(bookitem)
                        }
                    }
                    bookitemArrayList
                }
                .subscribe(object : DisposableObserver<ArrayList<BookItem>>() {
                    override fun onNext(bookitems: ArrayList<BookItem>) {
                        bookitems.forEach {
                            Log.e("hhhhhh",""+it.detailurl)
                        }
                        Log.e("jjjjjjjj",""+bookitems.size)

                    }

                    override fun onError(e: Throwable) {
                    }

                    override fun onComplete() {
                    }
                })
    }
}