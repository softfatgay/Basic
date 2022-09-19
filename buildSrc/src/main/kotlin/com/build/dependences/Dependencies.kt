package com.build.dependences

object Dependencies {

    //android dependencies
    const val coreKtx = "androidx.core:core-ktx:${AndroidVersion.coreKtx}"
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${AndroidVersion.kotlin}"
    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:${AndroidVersion.kotlin}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${AndroidVersion.coroutines}"
    const val livedata =
        "androidx.lifecycle:lifecycle-livedata-ktx:${AndroidVersion.androidLifecycleGrouped}"
    const val viewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${AndroidVersion.androidLifecycleGrouped}"
    const val material = "com.google.android.material:material:${AndroidVersion.material}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${AndroidVersion.constraintLayout}"
    const val junit = "junit:junit:${AndroidVersion.junit}"
    const val extJunit = "androidx.test.ext:junit:${AndroidVersion.extJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${AndroidVersion.espresso}"
    const val annotation = "androidx.annotation:annotation:${AndroidVersion.annotation}"
    const val appcompat = "androidx.appcompat:appcompat:${AndroidVersion.appcompat}"
    const val viewpager2 = "androidx.viewpager2:viewpager2:${AndroidVersion.viewpager2}"
    const val swipeRefreshLayout =
        "androidx.swiperefreshlayout:swiperefreshlayout:${AndroidVersion.swipeRefreshLayout}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${AndroidVersion.recyclerview}"
    const val flexbox = "com.google.android.flexbox:flexbox:${AndroidVersion.flexbox}"


    //third lib dependencies
    const val glide = "com.github.bumptech.glide:glide:${LibVersion.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${LibVersion.glide}"
    const val circleImageview = "de.hdodenhof:circleimageview:${LibVersion.circleimageview}"
    const val rxPermissions = "com.github.tbruyelle:rxpermissions:${LibVersion.rxpermissions}"
    const val rxjava = "io.reactivex.rxjava3:rxjava:${LibVersion.rxjava}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${LibVersion.retrofit}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${LibVersion.converterGson}"
    const val gson = "com.google.code.gson:gson:${LibVersion.gson}"
    const val okhttp3 = "com.squareup.okhttp3:okhttp:${LibVersion.okhttp}"
    const val loggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${LibVersion.loggingInterceptor}"


    //compose

    const val composeMaterial =
        "androidx.compose.material:material:${AndroidVersion.composeVersion}"
    const val composeMaterial3 = "androidx.compose.material3:material3:1.0.0-beta01"
    const val composeActivity = "androidx.activity:activity-compose:1.5.1"
    const val composeUI = "androidx.compose.ui:ui:${AndroidVersion.composeVersion}"
    const val composePreview =
        "androidx.compose.ui:ui-tooling-preview:${AndroidVersion.composeVersion}"
    const val composeUiTestJunit4 =
        "androidx.compose.ui:ui-test-junit4:${AndroidVersion.composeVersion}"
    const val composeDebugUiTooling =
        "androidx.compose.ui:ui-tooling:${AndroidVersion.composeVersion}"
    const val composeDebugTestManifest =
        "androidx.compose.ui:ui-test-manifest:${AndroidVersion.composeVersion}"
    const val composeSystemUiController =
        "com.google.accompanist:accompanist-systemuicontroller:${AndroidVersion.accompanistVersion}"
    const val composeInsets = "com.google.accompanist:accompanist-insets:${AndroidVersion.accompanistVersion}"
const val composeNavigation = "androidx.hilt:hilt-navigation-compose:1.0.0-alpha03"
}