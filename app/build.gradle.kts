plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    compileSdk = com.build.dependences.ProjectConfigs.compileSdkVersion
    defaultConfig {
        applicationId = com.build.dependences.ProjectConfigs.applicationId
        minSdk = com.build.dependences.ProjectConfigs.minSdkVersion
        targetSdk = com.build.dependences.ProjectConfigs.targetSdkVersion
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        // We use a bundled debug keystore, to allow debug builds from CI to be upgradable
        named("debug") {
            storeFile = rootProject.file("keyStore.jks")
            storePassword = "qwer1234"
            keyAlias = "qwer1234"
            keyPassword = "qwer1234"
        }
    }

    buildTypes {
        getByName("debug") {
            signingConfig = signingConfigs.getByName("debug")
        }

        getByName("release") {
            isMinifyEnabled = true
            signingConfig = signingConfigs.getByName("debug")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    testOptions {
        unitTests {
            isReturnDefaultValues = true
            isIncludeAndroidResources = true
        }
    }

    // Tests can be Robolectric or instrumented tests
    sourceSets {
        val sharedTestDir = "src/sharedTest/java"
        getByName("test") {
            java.srcDir(sharedTestDir)
        }
        getByName("androidTest") {
            java.srcDir(sharedTestDir)
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"

    }

    viewBinding {
        enabled = true
    }

}

dependencies {
    implementation(com.build.dependences.Dependencies.coreKtx)
    implementation(com.build.dependences.Dependencies.kotlinStdlib)
    implementation(com.build.dependences.Dependencies.material)
    implementation(com.build.dependences.Dependencies.constraintLayout)

    testImplementation(com.build.dependences.Dependencies.junit)
    androidTestImplementation(com.build.dependences.Dependencies.extJunit)
    androidTestImplementation(com.build.dependences.Dependencies.espresso)

    implementation(com.build.dependences.Dependencies.rxPermissions)
    implementation(com.build.dependences.Dependencies.rxjava)
    // TODO: Replace when all samples use the same Material3 & Compose version
//    implementation("androidx.compose.animation:animation:1.3.0-beta01")
//    implementation("androidx.compose.foundation:foundation-layout:1.3.0-beta01")
//    implementation("androidx.compose.material:material-icons-extended:1.3.0-beta01")
//    implementation("androidx.compose.material3:material3:1.0.0-beta01")
//    implementation("androidx.compose.material3:material3-window-size-class:1.0.0-beta01")
//    implementation("androidx.compose.runtime:runtime-livedata:1.3.0-beta01")
//    implementation("androidx.compose.ui:ui-tooling-preview:1.3.0-beta01")
//    debugImplementation("androidx.compose.ui:ui-test-manifest:1.3.0-beta01")
//    debugImplementation("androidx.compose.ui:ui-tooling:1.3.0-beta01")

//    implementation(libs.androidx.compose.animation)
//    implementation(libs.androidx.compose.foundation.layout)
//    implementation(libs.androidx.compose.material.iconsExtended)
//    implementation(libs.androidx.compose.material3)
//    implementation(libs.androidx.compose.materialWindow)
//    implementation(libs.androidx.compose.runtime.livedata)
//    implementation(libs.androidx.compose.ui.tooling.preview)
//    debugImplementation(libs.androidx.compose.ui.test.manifest)
//    debugImplementation(libs.androidx.compose.ui.tooling)

//    implementation("com.google.accompanist:accompanist-swiperefresh:0.26.1-alpha")
//    implementation("com.google.accompanist:accompanist-systemuicontroller:0.26.1-alpha")
//    implementation(libs.accompanist.swiperefresh)
//    implementation(libs.accompanist.systemuicontroller)

    implementation(project(":net"))
    implementation(project(":basic"))
    implementation(project(":stateview"))
    implementation(project(":lib-apm"))

}

tasks.withType<Test>().configureEach {
    systemProperties.put("robolectric.logging", "stdout")
} 
