package com.youmu.helper.ext

import android.app.Application
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat

/**
 *@Author weixuan
 *@Date 2023/6/7
 *@Description
 **/

lateinit var appContext: Application
    internal set

inline val packageName: String get() = appContext.packageName

fun stringRes(id: Int): String = (currentActivity?: appContext).getString(id)
fun colorRes(resId: Int): Int = ContextCompat.getColor((currentActivity?: appContext),resId)
fun drawableRes(resId: Int): Drawable? = ContextCompat.getDrawable((currentActivity?: appContext),resId)
