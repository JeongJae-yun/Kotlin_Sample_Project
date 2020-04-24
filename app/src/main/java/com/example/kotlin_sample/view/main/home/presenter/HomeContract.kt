package com.example.kotlin_sample.view.main.home.presenter

interface HomeContract{

    interface View{
        fun showImage(imageName: String)
        fun showProgress()
        fun hideProgress()

    }

    interface  Presenter{
        fun loadImage()

    }
}