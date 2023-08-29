package com.youmu.helper.init

import android.app.Application
import android.content.Context
import androidx.startup.Initializer
import com.funny.data_saver.core.DataSaverConfig
import com.tencent.mmkv.MMKV
import com.youmu.helper.BuildConfig
import com.youmu.helper.ext.KtxActivityLifecycleCallbacks
import com.youmu.helper.ext.appContext
import com.youmu.helper.utils.ThemeMode
import com.youmu.helper.utils.language.MultiLanguages
import com.youmu.helper.utils.language.OnLanguageListener
import java.util.Locale

/**
 *@Author weixuan
 *@Date 2023/8/14
 *@Description
 **/
class HelperInitializer  : Initializer<Unit> {
    override fun create(context: Context) {
        initMmkv(context)
        activityManage(context)
        initMultiLanguages(context)
        ThemeMode.setThemeModelCode(ThemeMode.appNightMode)
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf()
    }

    private fun activityManage(context: Context) {
        appContext = context as Application
        appContext.registerActivityLifecycleCallbacks(KtxActivityLifecycleCallbacks())
    }

    private fun initMultiLanguages(context: Context){
        MultiLanguages.attach(context)
        MultiLanguages.init()
        // 设置语种变化监听器
        MultiLanguages.setOnLanguageListener(object : OnLanguageListener {
            override fun onAppLocaleChange(oldLocale: Locale?, newLocale: Locale?) {
//                LogCat.d("监听到应用切换了语种，旧语种：$oldLocale，新语种：$newLocale")
            }

            override fun onSystemLocaleChange(oldLocale: Locale?, newLocale: Locale?) {
//                LogCat.d("监听到系统切换了语种，旧语种：$oldLocale，新语种：$newLocale")
            }
        })

//        if (LanguagesConfig.systemLanguage){
//            val str = LanguagesObserver.getSystemLanguage().toString()
//            if (!str.contains("zh",true)&&!str.contains("HK",true)) {
//                LanguagesConfig.setAppLanguage(Locale.ENGLISH)
//            }else{
////                LogCat.d("LanguagesConfig"+str)
//                if (!str.contains("CN",true)){
//                    LanguagesConfig.setAppLanguage(Locale.TAIWAN)
//                }else{
//                    LanguagesConfig.setAppLanguage(Locale.SIMPLIFIED_CHINESE)
//                }
//            }
//        }
    }

    private fun initMmkv(context: Context) {
        MMKV.initialize(context)
        DataSaverConfig.DEBUG = BuildConfig.DEBUG
    }
}