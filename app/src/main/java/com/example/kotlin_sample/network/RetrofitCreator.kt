package com.example.kotlin_sample.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun <T> createRetrofit(cls:Class<T>, baseUrl: String) : T{

    return Retrofit.Builder()
        .baseUrl(baseUrl) //넘겨받은 baseUrl을 사용할 것.
        .addConverterFactory(GsonConverterFactory.create())
        .client(createOkHttpClient())
        .build()
        .create(cls) //build가 끝나면 create까지 하고 이를 return한다.

}


private fun createOkHttpClient() : OkHttpClient {
    val builder : OkHttpClient.Builder = OkHttpClient.Builder()

    val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    builder.addInterceptor(interceptor)
    return builder.build()
}