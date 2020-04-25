package com.example.kotlin_sample.view.main.home.adapter.holder

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_sample.R
import com.example.kotlin_sample.data.ImageData
import com.example.kotlin_sample.data.source.Photo
import kotlinx.android.synthetic.main.item_image_view.view.*

class ImageViewHolder (context: Context, parent: ViewGroup?)
    : RecyclerView.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_image_view,parent,false)){

    fun onBind(item:Photo){
      /*  //보통은 이렇게 많이 쓴다.
        itemView.run {
        }*/

        //이렇게 쓴다.
        itemView.onBind(item)
    }

    private fun View.onBind(item: Photo){
        //tv_title.text = item.name
        img_view.loadImage(item.getImageUrl())
        //img_view.setImageResource(resources.getIdentifier(item.fileName,"drawable",context.packageName))

    }

}