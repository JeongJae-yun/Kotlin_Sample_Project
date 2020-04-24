package com.example.kotlin_sample.listSample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_sample.R
import com.example.kotlin_sample.listSample.adapter.NonViewHolderPatternAdapter
import com.example.kotlin_sample.listSample.adapter.ViewHolderPatternAdapter
import kotlinx.android.synthetic.main.activity_main_recycler.*

class MainRecycler : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_recycler)
        list_view_non_view_holder_pattern.adapter = NonViewHolderPatternAdapter(this, 0, getList())
        list_view_view_holder_pattern.adapter = ViewHolderPatternAdapter(this, 0, getList())


        btn_recycler_view.setOnClickListener {
            startActivity(Intent(this, RecyclerViewActivity::class.java))
        }
    }

    //0부터 100까지 출력한다.
    private fun getList(): List<String>{
        return (0..100).map { "Index $it" }
    }
}
