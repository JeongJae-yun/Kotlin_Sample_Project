package com.example.kotlin_sample.util

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*


//replace 확장
fun AppCompatActivity.replace(@IdRes frameId: Int, fragment : androidx.fragment.app.Fragment, tag:String? = null) {
    supportFragmentManager.beginTransaction().replace(frameId,fragment, tag).commit()
}

//AppCompatActivity
//tag는 null일 수 있다 null허용해준다.
//교체하는 아이디 값이 frameID

fun ClosedRange<Int>.random() = Random().nextInt(endInclusive-start)


fun String.decimalFormat(): String {
       return DecimalFormat("#,###").format(this.toLong())
    }


fun String.getDate(dateFormat: String): String {
        val calendar = Calendar.getInstance().apply {
                timeInMillis = this@getDate.toLong() * 1000
         }
      return SimpleDateFormat(dateFormat, Locale.getDefault()).format(calendar.time)
  }

