package com.example.imac.kotlin_fragment_practice

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.imac.kotlin_fragment_practice.databinding.Work1FragmentBinding

class FragmentA : Fragment(),FragmentAContract.View{
    override fun clickA() {
        Log.e("gggg","clickA")
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var binding : Work1FragmentBinding = DataBindingUtil.inflate(inflater ,R.layout.work1_fragment,container , false)
        binding.view=this
        return binding.root
    }

}