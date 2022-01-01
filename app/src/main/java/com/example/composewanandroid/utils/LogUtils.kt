package com.example.composewanandroid.utils

import android.util.Log
import com.example.composewanandroid.BuildConfig

/**
 * 日志工具类，release版不输出日志
 */
object LogUtils {

    private val isDebug = BuildConfig.DEBUG

    fun e(tag: String? = null, log: String) {
        if (isDebug) Log.e(tag, log)
    }

    fun i(tag: String? = null, log: String) {
        if (isDebug) Log.i(tag, log)
    }

    fun d(tag: String? = null, log: String) {
        if (isDebug) Log.d(tag, log)
    }

    fun w(tag: String? = null, log: String) {
        if (isDebug) Log.w(tag, log)
    }

    fun v(tag: String? = null, log: String) {
        if (isDebug) Log.v(tag, log)
    }

    fun wtf(tag: String? = null, log: String) {
        if (isDebug) Log.wtf(tag, log)
    }

}