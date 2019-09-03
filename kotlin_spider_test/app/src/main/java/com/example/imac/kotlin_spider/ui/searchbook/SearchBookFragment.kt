package com.example.imac.kotlin_spider.ui.searchbook

import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.imac.kotlin_spider.R
import com.example.imac.kotlin_spider.databinding.FragmentSearchBookBinding
import com.example.imac.kotlin_spider.model.BookItem
import com.example.user1.kotlin_project_test.Base.BaseFragment
import io.reactivex.Observable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import org.jsoup.Jsoup
import java.util.ArrayList

class SearchBookFragment:Fragment(),BaseFragment,SearchBookContract.View{

    lateinit var mBinding :FragmentSearchBookBinding
    lateinit var mData:SearchBookData
    lateinit var mModel:SearchBookModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        mBinding=DataBindingUtil.inflate(inflater,R.layout.fragment_search_book,container,false)
        init()
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mModel.changePage.observe(this, Observer {
            when(it?.second){
                1 -> Log.e("sssss","ssssss")
                2 -> Log.e("sssss","ssssss2")
                3 -> Log.e("sssss","ssssss3")
                4 -> Log.e("sssss","ssssss4")
                5 -> Log.e("sssss","ssssss5")
                6 -> Log.e("sssss","ssssss6")
                7 -> Log.e("sssss","ssssss7")
                8 -> Log.e("sssss","ssssss8")
                9 -> Log.e("sssss","ssssss9")
            }
        })
    }

    override fun init (){
        mData=SearchBookData()
        mModel= SearchBookModel(mData)
        mBinding.vm=mModel
    }
}