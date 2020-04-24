package com.example.kotlin_sample.data.source.image

import com.example.kotlin_sample.data.ImageData

interface ImageDataSource {

    //리턴없음 Unit형태로 넘겨준다.
    fun loadImageFileName(fileName : (String)-> Unit)

    fun loadImageList(imageDataList : (List<ImageData>) -> Unit, size: Int)
}