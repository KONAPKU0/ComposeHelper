package com.example.sample.components

import androidx.compose.runtime.Composable
import com.example.sample.ui.theme.SampleTheme

/**
 *@Author weixuan
 *@Date 2023/8/17
 *@Description
 **/

@Composable
fun PreviewTheme(content:@Composable () -> Unit){
    SampleTheme {
        content()
    }
}
