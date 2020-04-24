package com.example.kotlin_sample.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kotlin_sample.R
import kotlinx.android.synthetic.main.fragment_etc.*

class NotificationsFragment : Fragment() {

    companion object{
        val KEY_TITLE = "key-title"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
      = inflater.inflate(R.layout.fragment_etc, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        message.setText(arguments?.getInt(KEY_TITLE)?: 0)
    }
}
