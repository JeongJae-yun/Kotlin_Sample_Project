package com.example.kotlin_sample.data.source.flickr

import com.example.kotlin_sample.data.source.Photo
import com.example.kotlin_sample.data.source.PhotoInfo
import com.example.kotlin_sample.data.source.PhotoResponse
import retrofit2.Call

interface FlickrDataSource{
    /*fun getRecentPhoto(page:Int, perPage:Int) : Call<PhotoResponse>*/
    fun getSearchPhoto(keyword:String, page:Int, perPage:Int) : Call<PhotoResponse>

    fun getPhotoDetail(photoId:String) : Call<PhotoInfo>
}