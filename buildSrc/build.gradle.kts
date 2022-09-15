plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}
sourceSets {
    main {
        java {
            setSrcDirs(listOf("src"))
        }
    }
}

buildscript {

    repositories {
        mavenLocal()
        mavenCentral()
        google()
        maven(url = "https://jitpack.io")
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")
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
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")

    // in order to recognize the "plugins" block in the common script
    implementation("com.android.tools.build:gradle:7.2.2")

    // in order to recognize the "android" block in the common script
    implementation("com.android.tools.build:gradle-api:7.2.2")
}