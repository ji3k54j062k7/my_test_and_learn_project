package com.example.imac.kotlin_seek_bar_practice

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import com.example.imac.kotlin_seek_bar_practice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainContract.View {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityMainBinding= DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.view=this
        binding.data = MainData("ggf")
        binding.seekBarWork.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                binding.data = MainData(""+p1)
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }
        })
    }

}
