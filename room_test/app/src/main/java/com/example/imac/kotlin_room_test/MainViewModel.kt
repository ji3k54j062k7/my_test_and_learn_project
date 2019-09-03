package com.example.imac.kotlin_room_test

import android.databinding.ObservableField

class MainViewModel(data:MainData){
    var info = ObservableField<String>("a:${data.text1} b:${data.text2}")


}