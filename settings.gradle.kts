pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        mavenLocal()
        google()
        maven("https://jitpack.io")
        maven("https://oss.jfrog.org/libs-snapshot")

    }

    gradle.projectsLoaded {
        plugins{
            plugins {
                id ("com.android.application") version(extra.properties["androidGradlePluginVersion"].toString())
                id ("com.android.library") version(extra.properties["androidGradlePluginVersion"].toString())
                id ("org.jetbrains.kotlin.android") version(extra.properties["kotlinVersion"].toString())
                id ("org.jetbrains.kotlin.jvm") version(extra.properties["kotlinVersion"].toString())
                id ("androidx.navigation.safeargs") version(extra.properties["navigationComposeVersion"].toString())
            }
        }
    }
}


dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        gradlePluginPortal()
        mavenCentral()
        mavenLocal()
        google()
        maven("https://jitpack.io")
        maven("https://oss.jfrog.org/libs-snapshot")
    }
}
rootProject.name = "JetPackComposeModularization"
include (":app")
include (":di")
include (":data")
include (":domain")
include (":model:apiresponse")
include (":model:entity")
include (":common")
