package com.example.kotlin_sample.listSample.recycler.holder

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewSimpleAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    //ViewHolder라는 기본 layout을 상속.

    private val List : List<String> = mutableListOf() //이런식으로 만들면 add가 불가능

    private val list = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        //원래는 viewtype을 구분해서 넘겨줘야 하는데 하나 밖에 없으니 그냥 return
        if(viewType ==0 ){
            //..
        }

        return SimpleViewHolder(context,parent)
    }

    override fun getItemCount(): Int  = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? SimpleViewHolder)?.bindView(list[position])
    }

    fun addItem(item: String){
        list.add(item)
    }

}
