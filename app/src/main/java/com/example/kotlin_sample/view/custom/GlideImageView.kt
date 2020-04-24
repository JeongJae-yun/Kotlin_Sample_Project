package com.example.kotlin_sample.view.custom

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.kotlin_sample.R

class GlideImageView @JvmOverloads constructor (context: Context,attrs : AttributeSet? = null,defStyleAttr : Int = 0 ) :
    AppCompatImageView(context, attrs, defStyleAttr){

    fun loadImage(url : String?, @DrawableRes loadingImageRes : Int = R.drawable.ic_home_black_24dp){
        Glide.with(this)
            .load(url)
            .apply(RequestOptions.placeholderOf(loadingImageRes).centerCrop())
            .into(this)

    }
}