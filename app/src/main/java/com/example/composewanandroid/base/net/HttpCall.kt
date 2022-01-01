package com.example.composewanandroid.base.net

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * 网络通信
 */
object HttpCall {

    private const val BASE_URL = "https://www.wanandroid.com"
    //请求超时时间
    private const val TIMEOUT = 10 * 1000L

    private val httpClient by lazy {
        OkHttpClient
            .Builder()
            .connectTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
            .readTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
            .writeTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
            .addInterceptor(LogInterceptor())
            .addInterceptor(CommonParamsInterceptor())
            .build()
    }
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private val api by lazy {
        retrofit.create(WanAndroidApi::class.java)
    }

    fun wanAndroidApi(): WanAndroidApi {
        return api
    }


}