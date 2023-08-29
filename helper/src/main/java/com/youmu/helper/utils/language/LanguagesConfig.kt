package com.youmu.helper.utils.language

import android.content.Context
import com.funny.data_saver.core.mutableDataSaverStateOf
import com.funny.data_saver_mmkv.DefaultDataSaverMMKV
import java.util.Locale

/**
 *@Author weixuan
 *@Date 2023/6/8
 *@Description
 **/
object LanguagesConfig {
    @Volatile
    private var sCurrentLanguage: Locale? = null
    private var languageSetting: LanguagesModel by mutableDataSaverStateOf(DefaultDataSaverMMKV,"SAVE_LANGUAGE",
        LanguagesModel()
    )
    var systemLanguage:Boolean by mutableDataSaverStateOf(DefaultDataSaverMMKV,"IS_SYSTEM_LANGUAGE",true)

    fun setAppLanguage(locale:Locale){
        sCurrentLanguage = locale
        val mLanguagesModel = LanguagesModel(keyLanguage = locale.language, keyCountry = locale.country)
        languageSetting = mLanguagesModel
    }

    fun getAppLanguage(context: Context):Locale{
        if (sCurrentLanguage == null){
            sCurrentLanguage = if (languageSetting.keyLanguage.isNotBlank()){
                Locale(languageSetting.keyLanguage, languageSetting.keyCountry)
            }else{
                LanguagesUtils.getLocale(context)
            }
        }
        return sCurrentLanguage!!
    }

    fun isSystemLanguage(context: Context):Boolean{
        return languageSetting.keyLanguage.isBlank()
    }

    fun clearLanguage(context: Context){
        sCurrentLanguage = MultiLanguages.getSystemLanguage()
        languageSetting = LanguagesModel()
    }
}