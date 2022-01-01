package com.example.composewanandroid.base.net

import com.example.composewanandroid.data.model.home.BannerModel
import retrofit2.http.GET

/**
 * WanAndroid项目相关网络接口
 */
interface WanAndroidApi {

    @GET("banner/json")
    suspend fun getBannerList(): ResponseResult<List<BannerModel>>

}