package com.build.dependences

internal val kotlinDependencies = listOf(
    Dependencies.coreKtx,
    Dependencies.kotlinStdlib,
    Dependencies.coroutinesAndroid
)

internal val viewModelDependencies = listOf(
    Dependencies.livedata,
    Dependencies.viewModel,
)

internal val androidxDependencies = listOf(
    Dependencies.annotation,
    Dependencies.appcompat,
)

internal val androidUIDependencies = listOf(
    Dependencies.viewpager2,
    Dependencies.swipeRefreshLayout,
    Dependencies.recyclerview,
    Dependencies.flexbox,
)

internal val netWorkingDependencies = listOf(
    Dependencies.okhttp3,
    Dependencies.retrofit,
    Dependencies.converterGson,
    Dependencies.gson,
    Dependencies.loggingInterceptor,
)

internal val thirdLibDependencies = listOf(
    Dependencies.glide,
    Dependencies.glideCompiler,
    Dependencies.circleImageview,
    Dependencies.rxPermissions,
    Dependencies.rxjava,
)

//androidTestImplementation master
internal val androidTestImplementation = listOf(
    Dependencies.extJunit,
    Dependencies.espresso
)

//testImplementation  master
internal val testImplementation = listOf(
    Dependencies.junit,
)
//compose---------------------------------
internal val composeImplementation = listOf(
    Dependencies.composeUI,
    Dependencies.composePreview,
    Dependencies.composeMaterial,
    Dependencies.composeMaterial3,
    Dependencies.composeActivity,
    Dependencies.composeSystemUiController,
    Dependencies.composeInsets,
    Dependencies.composeNavigation,
)
internal val composeDebugImplementation = listOf(
    Dependencies.composeDebugUiTooling,
    Dependencies.composeDebugTestManifest,
)
internal val composeAndroidTestImplementation = listOf(
    Dependencies.composeUiTestJunit4,
)
//compose---------------------------------