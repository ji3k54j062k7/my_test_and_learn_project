package com.example.imac.kotlin_fragment_practice

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.imac.kotlin_fragment_practice.databinding.Work1FragmentBinding
import com.example.imac.kotlin_fragment_practice.databinding.Work2Binding

class FragmentB :Fragment(){
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var binding : Work2Binding = DataBindingUtil.inflate(inflater ,R.layout.work2,container , false)
        binding.view=this
        return binding.root
    }

    inline fun clickB(){
        Log.e("ggg","onClickB")
    }
}