plugins {
    `kotlin-dsl`
}

buildscript {

    repositories {
        mavenLocal()
        mavenCentral()
        google()
        maven(url = "https://jitpack.io")
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.0")
    }
}

repositories {
    mavenLocal()
    mavenCentral()
    google()
    maven(url = "https://jitpack.io")
}
dependencies {
    // in order to be able to use "kotlin-android" in the common script
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.0")

    // in order to recognize the "plugins" block in the common script
    implementation("com.android.tools.build:gradle:7.2.2")

    // in order to recognize the "android" block in the common script
    implementation("com.android.tools.build:gradle-api:7.2.2")
}