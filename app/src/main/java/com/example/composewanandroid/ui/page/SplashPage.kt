package com.example.composewanandroid.ui.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.composewanandroid.base.net.HttpCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * 闪屏页
 * @param onNext 闪屏后的下一页
 */
@Composable
fun SplashPage(onNext:()->Unit) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        Button(onClick = {
            GlobalScope.launch {
                withContext(Dispatchers.IO) {
                    HttpCall.wanAndroidApi().getBannerList()
                }
            }
        }) {
            Text(text = "测试网络")
        }
    }
}

