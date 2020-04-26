package com.example.kotlin_sample.data.source.flickr

import com.example.kotlin_sample.data.source.PhotoInfo
import com.example.kotlin_sample.data.source.PhotoResponse
import com.example.kotlin_sample.network.FlickrServiceInterface
import com.example.kotlin_sample.network.createRetrofit
import retrofit2.Call

class FlickrRemoteData  : FlickrDataSource{

    companion object{
        const val FLICKR_URL = "https://api.flickr.com/services/rest/"
    }

    private val flickrServiceInterface = createRetrofit(FlickrServiceInterface::class.java, FLICKR_URL)
    override fun getSearchPhoto(keyword: String, page: Int, perPage: Int)
        = flickrServiceInterface.getFlickrSearchPhotos(
        keyword = keyword,
        page = page,
        perPage =  perPage
    )

    override fun getPhotoDetail(photoId: String): Call<PhotoInfo>
            =flickrServiceInterface.getFlickrPhotoDetail(photoId)
    /*override fun getRecentPhoto(page: Int, perPage: Int) = flickrServiceInterface.getFlickrRecentPhotos(page, perPage)*/


}