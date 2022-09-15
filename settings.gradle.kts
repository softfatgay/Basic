
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven (url = "https://jitpack.io")
    }
}
rootProject.name = "Basic"
include(":app")
include(":net")
include(":basic")
include(":stateview")
include(":lib-apm")
