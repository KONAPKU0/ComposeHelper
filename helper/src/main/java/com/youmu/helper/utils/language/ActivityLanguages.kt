package com.youmu.helper.utils.language

import android.app.Activity
import android.app.Application.ActivityLifecycleCallbacks
import android.os.Bundle

/**
 *@Author weixuan
 *@Date 2023/6/8
 *@Description
 **/
class ActivityLanguages: ActivityLifecycleCallbacks {
    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        MultiLanguages.updateAppLanguage(activity)
        MultiLanguages.updateAppLanguage(activity.application)
    }

    override fun onActivityStarted(activity: Activity) {

    }

    override fun onActivityResumed(activity: Activity) {
        MultiLanguages.updateAppLanguage(activity)
        MultiLanguages.updateAppLanguage(activity.application)
    }

    override fun onActivityPaused(activity: Activity) {

    }

    override fun onActivityStopped(activity: Activity) {

    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

    }

    override fun onActivityDestroyed(activity: Activity) {

    }
}