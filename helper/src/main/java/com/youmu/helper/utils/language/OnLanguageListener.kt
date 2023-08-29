package com.youmu.helper.utils.language

import java.util.Locale

/**
 *@Author weixuan
 *@Date 2023/6/8
 *@Description
 **/
interface OnLanguageListener {

    /**
     * 当前应用语种发生变化时回调
     *
     * @param oldLocale         旧语种
     * @param newLocale         新语种
     */
    fun onAppLocaleChange(oldLocale: Locale?, newLocale: Locale?)

    /**
     * 手机系统语种发生变化时回调
     *
     * @param oldLocale         旧语种
     * @param newLocale         新语种
     */
    fun onSystemLocaleChange(oldLocale: Locale?, newLocale: Locale?)
}