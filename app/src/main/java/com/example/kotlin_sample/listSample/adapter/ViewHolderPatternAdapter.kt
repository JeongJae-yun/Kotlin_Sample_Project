package com.example.kotlin_sample.listSample.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*
import com.example.kotlin_sample.R


class ViewHolderPatternAdapter (context : Context, resource : Int, objects : List<String>) :
        ArrayAdapter<String>(context,resource, objects){
    /*
    * ViewHolder패턴 사용시 view의 inflate를 최초 한번만 한다.
    * 메모리 차지가 크지 않다.
    * findViewById를 매번 호출하지 않는다.
    * 한번 생성해둔 view를 재사용하게 된다.
    * */

    private lateinit var view: View
    private lateinit var viewHolder : ViewHolder

    //convertView는 이 View를 가지고 있는 view이다.
    //그래서 그 뷰가 없을 때 null일 경우에만 inflate 시킨다.
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        if (convertView == null){  //layout inflate 하면 convertview가 item_list로 변경될 것.
            view = LayoutInflater.from(context).inflate(R.layout.item_list,parent,false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder //밑에서 재사용하게 만든 ViewHolder를 view에 있는 tag에 넣어준다. 그래서 밑에 리턴 시키면 convertView가 not null로 들어온다.
            Log.i("TAG","create Viewholder")
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
            Log.i("TAG","view holder get tag")
        }
        viewHolder.bindView(getItem(position))
        return view
    }

    //ViewHolder를 재사용할수있게 만들 수 있다.
    class ViewHolder(val itemView:View?){

        fun bindView(item:String?){
            itemView?.tv_message?.text = item ?: ""
        }
    }
}