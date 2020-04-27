package com.example.kotlin_sample.view.main.detail.presenter

import com.example.kotlin_sample.data.source.PhotoInfo
import com.example.kotlin_sample.data.source.flickr.FlickrRepository
import com.example.kotlin_sample.util.decimalFormat
import com.example.kotlin_sample.util.getDate
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailImagePresenter (val view:DetailImageContract.View,
                            private val repository:FlickrRepository) : DetailImageContract.Presenter{

    private var webUrl: String = ""

    override fun loadDetailInfo(photoId: String) {
        repository.getPhotoDetail(photoId)
            .enqueue(object : Callback<PhotoInfo>{
                override fun onResponse(call: Call<PhotoInfo>, response: Response<PhotoInfo>) {

                    if (response.isSuccessful){
                        response.body()?.takeIf { it.stat == "ok" }?.let {
                            //처리
                            //photo가 계속적으로 사용되니까 let으로 묶는다.
                            it.photo.let {
                                view.updateItem(
                                    it.getImageUrl(),
                                    it.title._content,
                                    it.description._content,
                                    it.dates.lastupdate.getDate("MM-dd-yyyy hh:mm:ss"),
                                    it.views.toString().decimalFormat(),
                                    it.comments._content.toString().decimalFormat())

                                view.updateToolbarItem(
                                    it.owner.getBuddyIcons(),
                                    it.owner.username)

                                webUrl = it.urls.url.firstOrNull()?._content ?: ""
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<PhotoInfo>, t: Throwable) {

                }


            }


            )

    }

    override fun loadFlickrWebPage() {
        if (webUrl.isNotEmpty()) {
            view.showFlickrWebPage(webUrl)
        }
    }

}