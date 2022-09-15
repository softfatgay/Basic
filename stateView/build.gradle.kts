import com.build.dependences.*

plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    compileSdk = ProjectConfigs.compileSdkVersion
    defaultConfig {
        minSdk = ProjectConfigs.minSdkVersion
        targetSdk = ProjectConfigs.targetSdkVersion
        testInstrumentationRunner = ProjectConfigs.testInstrumentationRunner
    }

}
dependencies {
    implementation(Dependencies.kotlinStdlib)
    implementation(Dependencies.appcompat)
    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.extJunit)
    androidTestImplementation(Dependencies.espresso)
    compileOnly(Dependencies.constraintLayout)
    compileOnly(Dependencies.swipeRefreshLayout)
}