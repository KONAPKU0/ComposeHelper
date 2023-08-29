package com.example.sample.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sample.components.PreviewTheme

/**
 *@Author weixuan
 *@Date 2023/8/17
 *@Description
 **/
@Preview
@Composable
private fun PreviewMainScreen(){
    PreviewTheme{
        MainScreen()
    }
}


@Composable
fun MainScreen(){
    LazyColumn(
        modifier = Modifier
            .systemBarsPadding()
            .fillMaxSize(), verticalArrangement = Arrangement.spacedBy(16.dp)){
        item {
            Button(modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth(),onClick = {

            }){
                Text(text = "测试")
            }
        }
    }
}