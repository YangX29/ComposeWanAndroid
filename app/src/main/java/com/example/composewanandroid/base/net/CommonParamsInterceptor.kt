package com.example.composewanandroid.base.net

import okhttp3.Interceptor
import okhttp3.Response

/**
 * 公共参数拦截器
 */
class CommonParamsInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(chain.request())
    }

}