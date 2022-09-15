package com.build.dependences

internal val kotlinDependencies = listOf(
    Dependencies.coreKtx,
    Dependencies.coroutinesCore,
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

//androidTestImplementation
internal val androidTestImplementation = listOf(
    Dependencies.extJunit,
    Dependencies.espresso
)

//testImplementation
internal val testImplementation = listOf(
    Dependencies.junit,
)