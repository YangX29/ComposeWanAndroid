package com.example.composewanandroid.base.net

import com.example.composewanandroid.utils.LogUtils
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject


/**
 * 网络请求日志拦截器
 */
class LogInterceptor : Interceptor {

    companion object {
        private const val TAG = "LogInterceptor"
        private val LINE_SEPARATOR = System.getProperty("line.separator")
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        //输出请求数据
        printRequestLog(request)
        val startTime = System.currentTimeMillis()
        val response = chain.proceed(request)
        val endTime = System.currentTimeMillis()
        //输出响应数据
        val mediaType = response.body()?.contentType()
        val content = response.body()?.string()
        printResponse(content, response, (endTime - startTime).toFloat() / 1000)
        return response.newBuilder()
            .body(ResponseBody.create(mediaType, content))
            .build()
    }

    /**
     * 输出response日志
     */
    private fun printResponse(content: String?, response: Response, time: Float) {
        log("╔════════════════════════════════════════http response═════════════════════════════════════════")
        log("║cost time:${time}s")
        log("║request headers:============>")
        response.headers().toMultimap().forEach {
            log("║${it.key}:${it.value}")
        }
        //响应数据
        printJson(content ?: "", "Response data")
        log("╚═══════════════════════════════════════════════════════════════════════════════════════════════")
    }

    /**
     * 输出request日志
     */
    private fun printRequestLog(request: Request) {
        log("╔════════════════════════════════════════http request═════════════════════════════════════════")
        log("║method:${request.method()}")
        log("║url:${request.url()}")
        log("║request headers:============>")
        request.headers().toMultimap().forEach {
            log("║${it.key}:${it.value}")
        }
        log("║request boy:============>")
        log("║${request.body()?.toString()}")
        log("║request boy:============>")
        log("╚═══════════════════════════════════════════════════════════════════════════════════════════════")
    }

    /**
     * 输出请求结果
     */
    private fun printJson(msg: String, jsonStr: String) {
        var message = try {
            if (msg.startsWith("{")) {
                val jsonObject = JSONObject(msg)
                jsonObject.toString(4) //最重要的方法，就一行，返回格式化的json字符串，其中的数字4是缩进字符数
            } else if (msg.startsWith("[")) {
                val jsonArray = JSONArray(msg)
                jsonArray.toString(4)
            } else {
                msg
            }
        } catch (e: JSONException) {
            msg
        }
        log("╔═══════════════════════════════════════════════════════════════════════════════════════")
        message = jsonStr + LINE_SEPARATOR!!.toString() + message
        val lines: Array<String> = message.split(LINE_SEPARATOR).toTypedArray()
        for (line in lines) {
            log("║ $line")
        }
        log("╚═══════════════════════════════════════════════════════════════════════════════════════")
    }

    /**
     * 输出日志
     */
    private fun log(log: String) {
        LogUtils.v(TAG, log)
    }

}
