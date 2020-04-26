package com.example.kotlin_sample.view.main.home.adapter.model

import com.example.kotlin_sample.data.ImageData
import com.example.kotlin_sample.data.source.Photo

interface ImageRecyclerModel {
    //model을 통해서 adapter에 접근이 가능하도록 만든다.

    fun addItem(imageData: Photo)
    fun getItemCount() : Int
    fun notifyDataSetChange()

    fun refreshItem()

    fun getItem(position:Int) : Photo

    var onClick: (Int) -> Unit

}