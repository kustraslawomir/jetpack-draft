package dependencies.dependency

import dependencies.DependenciesConst
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.addMaterialDependencies() {
    androidMaterialDependencies.forEach {
        add("implementation", it)
    }
}

fun DependencyHandler.addComposeDependencies() {
    androidComposeDependencies.forEach {
        add("implementation", it)
    }
}


fun DependencyHandler.addAndroLifeCycleDependencies() {
    androidxLifeCycleDependencies.forEach {
        add("implementation", it)
    }
}

fun DependencyHandler.addKoinDependencies() {
    koinDependencies.forEach {
        add("implementation", it)
    }
}

fun DependencyHandler.addNetworkDependencies(configurationName: String = "implementation") {
    networkDependencies.forEach {
        add(configurationName, it)
    }
}

fun DependencyHandler.addCoroutinesDependencies() {
    add("implementation", DependenciesConst.kotlinCoroutines)
}

fun DependencyHandler.addCoilImageLoadingDependencies() {
    add("implementation", DependenciesConst.coil)
}

fun DependencyHandler.addLeakcanaryDependencies() {
    add("debugImplementation", DependenciesConst.leakcanary)
}

fun DependencyHandler.addNavigationDependencies() {
    add("implementation", DependenciesConst.navigationFragment)
    add("implementation", DependenciesConst.navigationUi)
    add("implementation", DependenciesConst.navigationCompose)
}

fun DependencyHandler.addRoomDependencies() {
    add("implementation", DependenciesConst.roomRuntime)
    add("implementation", DependenciesConst.roomPaging)
    add("annotationProcessor", DependenciesConst.roomCompiler)
}

fun DependencyHandler.addTimberDependencies(configurationName: String = "implementation") {
    add(configurationName, DependenciesConst.timber)
}

fun DependencyHandler.addMoshi(configurationName: String = "implementation") {
    add(configurationName, DependenciesConst.moshi)
}

fun DependencyHandler.addDataStoreDependencies(configurationName: String = "implementation") {
    add(configurationName, DependenciesConst.dataStore)
}

fun DependencyHandler.addAndroidTestsDependencies() {
    add("testImplementation", DependenciesConst.jUnit)
    add("androidTestImplementation", DependenciesConst.jUnitTestUi)
    add("androidTestImplementation", DependenciesConst.jUnitExt)
    add("androidTestImplementation", DependenciesConst.espresso)
    add("debugImplementation", DependenciesConst.composeTooling)
    add("debugImplementation", DependenciesConst.composeTestManifest)
}