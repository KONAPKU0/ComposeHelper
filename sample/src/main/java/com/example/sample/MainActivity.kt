package com.example.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.sample.nav.RouterAnimation
import com.example.sample.ui.theme.SampleTheme
import com.funny.data_saver.core.LocalDataSaver
import com.funny.data_saver_mmkv.DefaultDataSaverMMKV
import com.youmu.helper.base.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleTheme {
                // 设置在compose 中使用mmkv
                CompositionLocalProvider(LocalDataSaver provides DefaultDataSaverMMKV){
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        RouterAnimation()
                    }


                }


            }
        }
    }
}

