package com.example.kotlin_sample.view.main.home.presenter

interface HomeContract{

    interface View{
        fun showImage(imageName: String)
        fun showProgress()
        fun hideProgress()

        fun showLoadFail()
        fun showLoadFail(messages: String)

        fun KeywordFail()
    }

    interface  Presenter{
        //fun loadImage()
        fun loadFlickrImage(keys: String)

        fun SearchKeyword(key : String)

    }
}