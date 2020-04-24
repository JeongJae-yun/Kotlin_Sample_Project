package com.example.kotlin_sample.ImageLoadSample

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.util.LruCache
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import java.io.BufferedInputStream
import java.io.IOException
import java.lang.ref.WeakReference
import java.net.URL

object ImageDownloadThread {
    /*
    * LruCache를 사용한 Image 캐쉬 처리
    * */
    private val cache = LruCache<String, WeakReference<Bitmap?>>(5*1024*1024) //5mib

    fun loadImage(@DrawableRes loadingImageRes: Int, imageView: ImageView, url:String?, textView: TextView, randNumber: Int) :Boolean{
        imageView.setImageResource(loadingImageRes)

        url?.let { imageUrl ->
            cache.get(imageUrl).get()?.let {
                imageView.setImageBitmap(it)
                return true
            } ?: let{
                //이미지 뷰 동기화 위해서 tag 추가
                Thread(DownloadThread(imageView, imageUrl, textView, randNumber)).start()
            }
        }
        return false
    }

    private class DownloadThread(imageView: ImageView, private val imageUrl: String, textView: TextView, randNumber: Int) : Runnable {
        private val weakReferenceImageView: WeakReference<Data> = WeakReference(Data(imageUrl, imageView, textView, randNumber))

             private var bufferedInputStream: BufferedInputStream? = null


                override fun run() {
                       try {
                                URL(imageUrl).run { openConnection() }.run {
                                      connect()
                                      this@DownloadThread.bufferedInputStream = BufferedInputStream(this.getInputStream())
                               }
                               val options = BitmapFactory.Options().apply { inSampleSize = 2 }
                              cache.put(imageUrl, WeakReference(BitmapFactory.decodeStream(bufferedInputStream, null, options)))
                             draw(imageUrl)


                         } catch (e: IOException) {
                             closeStream()


                           } finally {
                             closeStream()
                           }
                  }


                private fun closeStream() {
                        try {
                              bufferedInputStream?.close()
                            } catch (e1: IOException) {
                                 e1.printStackTrace()
                        }


                }


           @SuppressLint("SetTextI18n")
           private fun draw(resourceUrl: String) {
                  Handler(Looper.getMainLooper()).post {
                          weakReferenceImageView.get()?.takeIf { it.tag == resourceUrl }?.let { data ->
                                         cache.get(resourceUrl)?.get()?.let {
                                               data.imageView.setImageBitmap(it)
                                               data.textView.text = "ACTION_THREAD cacheLoad : false - ${data.randNumber}"
                                           }
                                   }
                             }
                  }
           }


}