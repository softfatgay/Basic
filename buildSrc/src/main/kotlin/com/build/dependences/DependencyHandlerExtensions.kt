package com.build.dependences

import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.addKotlinDependencies() {
    kotlinDependencies.forEach {
        add("implementation", it)
    }
}

fun DependencyHandler.addViewModelDependencies() {
    viewModelDependencies.forEach {
        add("implementation", it)
    }
}

fun DependencyHandler.addAndroidxDependencies() {
    androidxDependencies.forEach {
        add("implementation", it)
    }
}

fun DependencyHandler.addAndroidUIDependencies() {
    androidUIDependencies.forEach {
        add("implementation", it)
    }
}

fun DependencyHandler.addNetWorkingDependencies() {
    netWorkingDependencies.forEach {
        add("implementation", it)
    }
}

fun DependencyHandler.addAndroidTestImplementation() {
    androidTestImplementation.forEach {
        add("androidTestImplementation", it)
    }
}

fun DependencyHandler.addTestImplementation() {
    testImplementation.forEach {
        add("testImplementation", it)
    }
}

//compose---------------------------------
fun DependencyHandler.addComposeImplementation() {
    composeImplementation.forEach {
        add("implementation", it)
    }
}

fun DependencyHandler.addComposeDebugImplementation() {
    composeDebugImplementation.forEach {
        add("debugImplementation", it)
    }
}

fun DependencyHandler.addComposeAndroidTestImplementation() {
    composeAndroidTestImplementation.forEach {
        add("androidTestImplementation", it)
    }
}
//compose---------------------------------