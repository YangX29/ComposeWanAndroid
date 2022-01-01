package com.example.composewanandroid.ui.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composewanandroid.R
import com.example.composewanandroid.base.net.HttpCall
import com.example.composewanandroid.utils.Constants
import kotlinx.coroutines.*

/**
 * 闪屏页
 * @param onNext 闪屏后的下一页
 */
@Composable
fun SplashPage(onNext: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White), contentAlignment = Alignment.Center
    ) {
        LaunchedEffect(Unit) {
            delay(Constants.SPLASH_TIME)
            onNext.invoke()
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.mipmap.ic_launcher_round),
                contentDescription = "app icon",
                modifier = Modifier.size(120.dp)
            )
            Text(
                text = "Wan Android",
                fontSize = 32.sp,
                color = Color.LightGray,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp)
            )
        }
    }
}

