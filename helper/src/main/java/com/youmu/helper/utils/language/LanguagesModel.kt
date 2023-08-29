package com.youmu.helper.utils.language

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 *@Author weixuan
 *@Date 2023/5/16
 *@Description
 **/
@Parcelize
data class LanguagesModel(
    var keyLanguage:String="",
    var keyCountry :String="") : Parcelable
