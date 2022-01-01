package com.example.composewanandroid

import androidx.compose.runtime.*
import com.example.composewanandroid.ui.page.SplashPage
import com.example.composewanandroid.ui.page.home.HomePage

/**
 * app启动页
 */
@Composable
fun AppEntry() {
    var isSplash by remember { mutableStateOf(true) }
    if (isSplash) {
        SplashPage {
            isSplash = false
        }
    } else {
        HomePage()
    }
}