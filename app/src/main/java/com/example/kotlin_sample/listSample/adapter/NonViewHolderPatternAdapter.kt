package com.example.kotlin_sample.listSample.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.kotlin_sample.R

class NonViewHolderPatternAdapter (context: Context, resource:Int, objects:List<String>)
    : ArrayAdapter<String>(context, resource, objects) {

    //getView는 list item count만큼 불리니 매번 불리게 된다. 스크롤 시에도 계속 불린다.
    //getView 자체가 view를 생성함과 동시에 사용하는 방식으로 되어 있다.
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = LayoutInflater.from(context).inflate(R.layout.item_list,parent,false)
        val textView = view.findViewById<TextView>(R.id.tv_message)
        textView.text = getItem(position)
        Log.d("TAG", "getView")
        return view
    }
}