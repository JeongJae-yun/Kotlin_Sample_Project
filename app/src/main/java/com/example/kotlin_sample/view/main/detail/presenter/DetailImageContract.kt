package com.example.kotlin_sample.view.main.detail.presenter

interface DetailImageContract {
    interface View{
        fun updateToolbarItem(buddyIcon:String, buddyName:String)

        fun updateItem(imageUrl:String, title:String, content:String, dat:String,viewCount:String, commentCount:String)
    }

    interface Presenter{
        fun loadDetailInfo(photoId : String)

    }
}