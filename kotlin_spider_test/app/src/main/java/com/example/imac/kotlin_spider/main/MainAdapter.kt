package com.example.imac.kotlin_spider.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.imac.kotlin_spider.ui.booklabel.BookLabelFragment
import com.example.imac.kotlin_spider.ui.personalbook.PersonalBookFragment
import com.example.imac.kotlin_spider.ui.readset.ReadSetFragment
import com.example.imac.kotlin_spider.ui.searchbook.SearchBookFragment

class MainAdapter(fragmentManager:FragmentManager): FragmentPagerAdapter(fragmentManager),MainContract.Adapter{

    override fun onDetached() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onAttached(view: MainContract.View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> return PersonalBookFragment()
            1 -> return BookLabelFragment()
            2 -> return SearchBookFragment()
            else -> return ReadSetFragment()
        }
    }

    override fun getCount(): Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence {
        when(position){
            0 -> return "個人書架"
            1 -> return "書籤"
            2 -> return "找書"
            else -> return "設定"
        }
    }
}

