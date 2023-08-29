package com.youmu.helper.utils.language

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.LocaleList
import java.util.Locale


/**
 *@Author weixuan
 *@Date 2023/6/8
 *@Description
 **/
object LanguagesUtils {

    /**
     * 获取语种对象
     */
    fun getLocale(context:Context):Locale{
        return getLocale(context.resources.configuration)
    }

    @SuppressLint("ObsoleteSdkInt")
    fun getLocale(config: Configuration): Locale {
        val mLocale: Locale = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            config.locales[0]
        } else {
            config.locale
        }
        return mLocale
    }


    /**
     * 设置语种对象
     */
    @SuppressLint("ObsoleteSdkInt")
    fun setLocale(config:Configuration, locale:Locale){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                val localeList = LocaleList(locale)
                config.setLocales(localeList)
            } else {
                config.setLocale(locale)
            }
        } else {
            config.locale = locale
        }
    }


    /**
     * 设置默认的语种环境（日期格式化会用到）
     */
    @SuppressLint("ObsoleteSdkInt")
    fun setDefaultLocale(context: Context){
        val configuration: Configuration = context.resources.configuration
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            LocaleList.setDefault(configuration.locales)
        } else {
            Locale.setDefault(configuration.locale)
        }
    }


    /**
     * 绑定当前 App 的语种
     */
    @SuppressLint("ObsoleteSdkInt")
    fun attachLanguages(context: Context, locale:Locale):Context{
        var mContext = context
        val resources: Resources = mContext.resources
        val config = Configuration(resources.configuration)
        setLocale(config, locale)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            mContext = mContext.createConfigurationContext(config)
        }
        resources.updateConfiguration(config, resources.displayMetrics)
        return mContext
    }

    /**
     * 更新 Resources 语种
     */
    fun updateLanguages(resources:Resources, locale:Locale){
        val config = Configuration(resources.configuration)
        setLocale(config, locale)
        resources.updateConfiguration(config, resources.displayMetrics)
    }

    /**
     * 更新手机配置信息变化
     */
    fun updateConfigurationChanged(context:Context ,newConfig:Configuration){
        val config = Configuration(newConfig)
        // 绑定当前语种到这个新的配置对象中
        setLocale(config, LanguagesConfig.getAppLanguage(context))
        val resources = context.resources
        // 更新上下文的配置信息
        resources.updateConfiguration(config, resources.displayMetrics)
    }

    /**
     * 获取某个语种下的 Resources 对象
     */
    @SuppressLint("ObsoleteSdkInt")
    fun getLanguageResources(context:Context, locale:Locale):Resources {
        val config = Configuration()
        setLocale(config, locale)
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            context.createConfigurationContext(config).resources
        } else Resources(context.assets, context.resources.displayMetrics, config)
    }
}