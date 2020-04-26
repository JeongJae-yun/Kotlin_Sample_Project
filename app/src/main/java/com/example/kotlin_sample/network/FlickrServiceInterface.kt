package com.example.kotlin_sample.network

import com.example.kotlin_sample.BuildConfig
import com.example.kotlin_sample.data.source.PhotoInfo
import com.example.kotlin_sample.data.source.PhotoResponse
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query

interface FlickrServiceInterface {
    //retrofit에서 사용할 서비스 들을 적는 곳

    /*@POST("?method=flickr.photos.getRecent&api_key=${BuildConfig.FLICKR_API_KEY}&format=json&nojsoncallback=1")
    fun getFlickrRecentPhotos(
        @Query("page") page:Int,
        @Query("per_Page") perPage : Int
    ) : Call<PhotoResponse>*/

    @POST("?method=flickr.photos.search&api_key=${BuildConfig.FLICKR_API_KEY}&format=json&nojsoncallback=1")
    fun getFlickrSearchPhotos(
       @Query("text") keyword: String,
       @Query("safe_search") safeSearch: Int = 1,
       @Query("page") page: Int,
       @Query("per_page") perPage : Int
    ) : Call<PhotoResponse>


    @POST("?method=flickr.photos.getInfo&api_key=${BuildConfig.FLICKR_API_KEY}&format=json&nojsoncallback=1")
    fun getFlickrPhotoDetail(
        @Query("photo_id") photoId: String
    ) : Call<PhotoInfo>
}