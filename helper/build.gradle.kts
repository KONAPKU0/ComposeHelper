plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.youmu.helper"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    api("androidx.core:core-ktx:1.10.1")
    api("androidx.appcompat:appcompat:1.6.1")
    api("androidx.activity:activity-compose:1.7.2")
    api("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    api("androidx.core:core-splashscreen:1.0.1")
    api("androidx.startup:startup-runtime:1.2.0-alpha02")
    api("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
    api("androidx.lifecycle:lifecycle-runtime-compose:2.6.1")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.2")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.2")
    api("androidx.webkit:webkit:1.7.0")
    //https://developer.android.google.cn/jetpack/androidx/releases/compose-ui
    api("androidx.compose.ui:ui:1.6.0-alpha03")
    api("androidx.compose.material3:material3:1.2.0-alpha05")
    api("androidx.navigation:navigation-compose:2.7.0-rc01")
    api("androidx.paging:paging-runtime-ktx:3.2.0")
    api("androidx.paging:paging-compose:3.2.0")

    //https://github.com/google/accompanist/releases
    api("com.google.accompanist:accompanist-systemuicontroller:0.31.6-rc")
    api("com.google.accompanist:accompanist-webview:0.31.6-rc")
    api("androidx.constraintlayout:constraintlayout-compose:1.0.1")
    // 事件分发
    api("com.github.liangjingkanji:Channel:1.1.5")
    // 计时器
    api("com.github.liangjingkanji:Interval:1.0.3")
    // 键值对 https://github.com/FunnySaltyFish/ComposeDataSaver
    api("com.github.FunnySaltyFish.ComposeDataSaver:data-saver:1.1.6")
    api("com.github.FunnySaltyFish.ComposeDataSaver:data-saver-mmkv:1.1.6")
    api("com.tencent:mmkv:1.3.0")
    //占位
    api("com.valentinilk.shimmer:compose-shimmer:1.0.5")
    //https://github.com/holixfactory/bottomsheetdialog-compose
    api("com.holix.android:bottomsheetdialog-compose:1.4.0")




    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}