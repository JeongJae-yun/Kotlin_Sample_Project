package com.example.kotlin_sample.data.source.image

import com.example.kotlin_sample.data.ImageData

object ImageRepository : ImageDataSource{


    private val IMAGE_REMOTE_DATA : ImageRemoteData by lazy {
        ImageRemoteData()
    }

    override fun loadImageList(imageDataList: (List<ImageData>) -> Unit, size: Int) {
        IMAGE_REMOTE_DATA.loadImageList(imageDataList,size)
        //imageLocalData.loadImageList(imageDataList, size)
    }


    private val imageLocalData : ImageLocalData by lazy{
        ImageLocalData()
    }

    //얘가 불리면 다시 localData에 있는 loadIamgeFileName을 불러서 filename을 가져온다.
    override fun loadImageFileName(fileName: (String) -> Unit) {
        imageLocalData.loadImageFileName(fileName)
    }



}