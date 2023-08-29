package com.youmu.helper.utils.language

import android.app.Application
import android.content.ComponentCallbacks
import android.content.res.Configuration
import android.content.res.Resources
import com.youmu.helper.ext.appContext
import java.util.Locale

/**
 *@Author weixuan
 *@Date 2023/6/8
 *@Description
 **/
class LanguagesObserver: ComponentCallbacks {
    companion object{
        @Volatile
        private var sSystemLanguage: Locale? = null
        init {
            sSystemLanguage = LanguagesUtils.getLocale(Resources.getSystem().configuration)
        }

        /**
         * 获取系统的语种
         */
        fun getSystemLanguage(): Locale? {
            return sSystemLanguage
        }

        /**
         * 注册系统语种变化监听
         */
        fun register(application: Application) {
            application.registerComponentCallbacks(LanguagesObserver())
        }
    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        val newLocale = LanguagesUtils.getLocale(newConfig)
        val oldLocale = sSystemLanguage
        // 更新 Application 的配置，否则会出现横竖屏切换之后 Application 的 orientation 没有随之变化的问题
        LanguagesUtils.updateConfigurationChanged(appContext, newConfig)
        if (newLocale == oldLocale) {
            return
        }
        sSystemLanguage = newLocale
        // 如果当前的语种是跟随系统变化的，那么就需要重置一下当前 App 的语种

        if (LanguagesConfig.isSystemLanguage(appContext)) {
            LanguagesConfig.clearLanguage(appContext)
        }

        MultiLanguages.getOnLanguagesListener()?.onSystemLocaleChange(oldLocale, newLocale)
    }

    override fun onLowMemory() {

    }
}