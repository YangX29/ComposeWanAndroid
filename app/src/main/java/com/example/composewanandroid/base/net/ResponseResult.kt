package com.example.composewanandroid.base.net

import com.google.gson.annotations.SerializedName

/**
 * 网络接口数据返回结果包装类
 * @param errorCode 错误码
 * @param errorMsg 错误信息
 * @param data 返回结果数据，指定泛型
 */
data class ResponseResult<T>(
    @SerializedName("errorCode")
    val errorCode: Int,
    @SerializedName("errorMsg")
    val errorMsg: String,
    @SerializedName("data")
    val data: T? = null
)