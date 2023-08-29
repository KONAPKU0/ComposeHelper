package com.youmu.helper.utils.language

import android.content.Context
import android.content.res.Resources
import com.youmu.helper.ext.appContext
import java.util.Locale

/**
 *@Author weixuan
 *@Date 2023/6/8
 *@Description https://github.com/getActivity/MultiLanguages v8.0
 **/
object MultiLanguages {
    private var sLanguageListener: OnLanguageListener? = null

    fun init() {
        LanguagesObserver.register(appContext)
        LanguagesUtils.setDefaultLocale(appContext)
        appContext.registerActivityLifecycleCallbacks(ActivityLanguages());

    }
    /**
     * 在上下文的子类中重写 attachBaseContext 方法（用于更新 Context 的语种）
     */
    fun attach(context: Context): Context {
        return if (LanguagesUtils.getLocale(context) == LanguagesConfig.getAppLanguage(context)
        ) {
            context
        } else LanguagesUtils.attachLanguages(
            context,
            LanguagesConfig.getAppLanguage(context)
        )
    }

    /**
     * 更新 Context 的语种
     */
    fun updateAppLanguage(context: Context) {
        updateAppLanguage(context.resources)
    }

    /**
     * 更新 Resources 的语种
     */
    fun updateAppLanguage(resources: Resources?) {
        if (resources == null) {
            return
        }
        if (LanguagesUtils.getLocale(resources.configuration)
                .equals(getAppLanguage())
        ) {
            return
        }
        LanguagesUtils.updateLanguages(resources, getAppLanguage())
    }

    /**
     * 获取 App 的语种
     */
    fun getAppLanguage(): Locale {
        return LanguagesConfig.getAppLanguage(appContext)
    }

    /**
     * 设置 App 的语种
     *
     * @return              语种是否发生改变了
     */
    fun setAppLanguage(context: Context, newLocale: Locale): Boolean {
        LanguagesConfig.setAppLanguage(newLocale)
        if (LanguagesUtils.getLocale(context).equals(newLocale)) {
            return false
        }
        val oldLocale = LanguagesUtils.getLocale(context)
        // 更新 Context 的语种
        LanguagesUtils.updateLanguages(context.resources, newLocale)
        if (context !== appContext) {
            // 更新 Application 的语种
            LanguagesUtils.updateLanguages(appContext.resources, newLocale)
        }
        LanguagesUtils.setDefaultLocale(context)
        sLanguageListener?.onAppLocaleChange(oldLocale, newLocale)
        return true
    }

    /**
     * 获取系统的语种
     */
    fun getSystemLanguage(): Locale? {
        return LanguagesObserver.getSystemLanguage()
    }


    /**
     * 跟随系统语种
     *
     * @return              语种是否发生改变了
     */
    fun clearAppLanguage(context: Context): Boolean {
        LanguagesConfig.clearLanguage(context)
        if (LanguagesUtils.getLocale(context).equals(getSystemLanguage())) {
            return false
        }
        LanguagesUtils.updateLanguages(context.resources, getSystemLanguage()!!)
        LanguagesUtils.setDefaultLocale(context)
        if (context !== appContext) {
            // 更新 Application 的语种
            LanguagesUtils.updateLanguages(
                appContext.resources,
                getSystemLanguage()!!
            )
        }
        return true
    }


    /**
     * 是否跟随系统的语种
     */
    fun isSystemLanguage(): Boolean {
        return LanguagesConfig.isSystemLanguage(appContext)
    }

    /**
     * 对比两个语言是否是同一个语种（比如：中文的简体和繁体，英语的美式和英式）
     */
    fun equalsLanguage(locale1: Locale, locale2: Locale): Boolean {
        return locale1.language == locale2.language
    }

    /**
     * 对比两个语言是否是同一个地方的（比如：中国大陆用的中文简体，中国台湾用的中文繁体）
     */
    fun equalsCountry(locale1: Locale, locale2: Locale): Boolean {
        return equalsLanguage(locale1, locale2) &&locale1.country == locale2.country
    }

    /**
     * 获取某个语种下的 String
     */

    fun getLanguageString(context: Context, locale: Locale, resId: Int): String {
        return getLanguageResources(context, locale).getString(resId)
    }

    /**
     * 获取某个语种下的 Resources 对象
     */
    fun getLanguageResources(context: Context?, locale: Locale?): Resources {
        return LanguagesUtils.getLanguageResources(context!!, locale!!)
    }

    /**
     * 设置语种变化监听器
     */
    fun setOnLanguageListener(listener: OnLanguageListener?) {
        sLanguageListener = listener
    }

    /**
     * 获取语种变化监听对象
     */
    fun getOnLanguagesListener(): OnLanguageListener? {
        return sLanguageListener
    }
}