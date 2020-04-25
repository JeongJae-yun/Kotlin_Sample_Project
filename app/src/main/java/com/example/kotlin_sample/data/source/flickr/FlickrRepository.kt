package com.example.kotlin_sample.data.source.flickr

import com.example.kotlin_sample.data.source.PhotoResponse
import retrofit2.Call

object FlickrRepository : FlickrDataSource {

    private val flickrRemoteData = FlickrRemoteData()
    override fun getSearchPhoto(keyword: String, page: Int, perPage: Int)
        = flickrRemoteData.getSearchPhoto(keyword, page, perPage)
    /*override fun getRecentPhoto(page: Int, perPage: Int) = flickrRemoteData.getRecentPhoto(page,perPage)*/
}