import com.build.dependences.*
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
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

}