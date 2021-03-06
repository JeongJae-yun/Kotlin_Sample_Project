package com.example.kotlin_sample.view.main.home.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_sample.data.ImageData
import com.example.kotlin_sample.data.source.Photo
import com.example.kotlin_sample.view.main.home.adapter.holder.ImageViewHolder
import com.example.kotlin_sample.view.main.home.adapter.model.ImageRecyclerModel

class ImageRecyclerAdapter(private val context: Context) : ImageRecyclerModel, RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val list = mutableListOf<Photo>()

    override lateinit var onClick: (Int) -> Unit


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        //ViewType에 맞는 서로 다른 holder와 pattern을 가질 수 있도록 여러개 view holder 생성할 것.
        return ImageViewHolder(onClick,context,parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //holder가 넘어오면 image vi ew holder인지 체크해서 실제 onbind를 call 해주는 부분
        (holder as? ImageViewHolder)?.onBind(list[position]) //holder가 ImageViewHolder이면 onBind를 시킨다.
    }

 /*   override fun addItem(imageData: ImageData) {
        list.add(imageData)
    }*/

    override fun addItem(imageData: Photo) {
        list.add(imageData)
    }

    override fun getItemCount(): Int = list.size

    override fun notifyDataSetChange() {
        notifyDataSetChanged()
    }

    override fun refreshItem() {
        list.clear()
    }

    override fun getItem(position: Int): Photo {
        return list[position]
    }




}