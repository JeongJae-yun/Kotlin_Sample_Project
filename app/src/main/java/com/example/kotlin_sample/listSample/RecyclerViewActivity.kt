package com.example.kotlin_sample.listSample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_sample.R
import com.example.kotlin_sample.listSample.recycler.holder.RecyclerViewSimpleAdapter
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {
    /*
    * RecyclerView는 LayoutManager를 통해서 View그리는 법을 정의
    * Adapter와 dataset을 통해 데이터 정의
    * 
    * LayoutManager? : Linear : 가장 기본적/ grid : 정확하게 가로세로 1:1 / staggered : 크기 각각 다르게
    * viewType을 정의해서 직접 구현해야한다.
    * */

    private val recyclerAdapter : RecyclerViewSimpleAdapter by lazy{
        RecyclerViewSimpleAdapter(this@RecyclerViewActivity)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        recycler_view2.run {
            layoutManager = LinearLayoutManager(this@RecyclerViewActivity)
            adapter = recyclerAdapter
        }

        //foreach문으로 하나씩 가져와서 넣는다.
        getList().forEach {
            recyclerAdapter.addItem(it)
        }
        //갱신을 알려준다.
        recyclerAdapter.notifyDataSetChanged()

    }


    //0부터 100까지 출력한다.
    private fun getList(): List<String>{
        return (0..100).map { "Index $it" }
    }
}
