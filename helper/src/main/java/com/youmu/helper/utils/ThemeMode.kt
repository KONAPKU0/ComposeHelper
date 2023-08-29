package com.youmu.helper.utils

import androidx.appcompat.app.AppCompatDelegate
import com.funny.data_saver.core.mutableDataSaverStateOf
import com.funny.data_saver_mmkv.DefaultDataSaverMMKV

/**
 *@Author weixuan
 *@Date 2023/7/14
 *@Description
 **/
object ThemeMode {
    var appNightMode: Int by mutableDataSaverStateOf(DefaultDataSaverMMKV,"APP_NIGHT_MODE",AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM )

    fun setThemeModelCode(mode: Int) {
        appNightMode = mode
        AppCompatDelegate.setDefaultNightMode(mode)
    }


}

object ThemeModeUtils{
    fun getThemeModelCode():Int {
        return runCatching {
            when(ThemeMode.appNightMode){
                AppCompatDelegate.MODE_NIGHT_NO-> 0
                AppCompatDelegate.MODE_NIGHT_YES-> 1
                AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM-> 2
                else -> 2
            }
        }.getOrElse {
            2
        }
    }

//    fun getThemeModelText():String {
//        return try {
//            when(ThemeMode.appNightMode){
//                AppCompatDelegate.MODE_NIGHT_NO-> stringRes(R.string.bright_mode)
//                AppCompatDelegate.MODE_NIGHT_YES-> stringRes(R.string.dark_mode)
//                AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM-> stringRes(R.string.follow_system)
//                else -> stringRes(R.string.follow_system)
//            }
//        }catch (e:ExceptionInInitializerError){
//            stringRes(R.string.follow_system)
//        }
//
//    }
}