package com.example.kotlin_sample.listSample.recycler.holder

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_sample.R
import kotlinx.android.synthetic.main.item_list.view.*

class SimpleViewHolder(context: Context, parent : ViewGroup?) :
        RecyclerView.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list,parent,false)){
    //parent에 맞는 layout을 inflate 해준다.
    //ViewHolder 생성함과 동시에 bindView를 해준다.
    
    /*
    * onCreateViewHolder : View를 최초 한번 생성
    * onBindViewHolder를 통해 아이템의 VIew를 갱신
    * 아이템 리스트 직접 구현 가능
    * */

    fun bindView(item : String?){
        itemView.bindView(item)
    }

    fun View.bindView(item:String?){
        tv_message.text = item ?: ""
    }
}