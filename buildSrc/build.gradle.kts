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

repositories {
    mavenLocal()
    mavenCentral()
    google()
    maven(url = "https://jitpack.io")
}
dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")
    implementation("com.android.tools.build:gradle:7.2.2")
    implementation("com.android.tools.build:gradle-api:7.2.2")
}