package com.example.sample.base

import android.content.Context
import androidx.startup.Initializer
import com.youmu.helper.init.HelperInitializer

/**
 *@Author weixuan
 *@Date 2023/7/5
 *@Description
 **/
internal class AppInitializer : Initializer<Unit> {
    override fun create(context: Context) {


    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf(HelperInitializer::class.java)
    }

//    private fun initNet(context: Context){
//        NetConfig.initialize(Api.HOST, context) {
//            // 超时设置
//            connectTimeout(15, TimeUnit.SECONDS)
//            readTimeout(40, TimeUnit.SECONDS)
//            writeTimeout(40, TimeUnit.SECONDS)
//            // Http缓存协议和强制缓存模式
//            cache(Cache(context.cacheDir, 1024 * 1024 * 128)) // 缓存设置, 当超过maxSize最大值会根据最近最少使用算法清除缓存来限制缓存大小
//            // LogCat是否输出异常日志, 异常日志可以快速定位网络请求错误
//            setDebug(BuildConfig.DEBUG)
//
//            // 设置不代理
////            this.proxy(Proxy.NO_PROXY)
//
//            // 添加持久化Cookie管理
//            cookieJar(PersistentCookieJar(context))
//
//            // AndroidStudio OkHttp Profiler 插件输出网络日志
//            if (BuildConfig.DEBUG){
//                addInterceptor(LogRecordInterceptor(BuildConfig.DEBUG))
//            }
//            // 通知栏监听网络日志
//            addInterceptor(
//                ChuckerInterceptor.Builder(context)
//                    .collector(ChuckerCollector(context))
//                    .maxContentLength(250000L)
//                    .redactHeaders(emptySet())
//                    .alwaysReadResponseBody(false)
//                    .build()
//            )
//            // 添加请求拦截器, 可配置全局/动态参数
//            setRequestInterceptor(ApiRequestInterceptor())
//            // 数据转换器
//            setConverter(SerializationConverter())
//
//            setErrorHandler(ApiErrorHandler())
//
//        }
//    }

}