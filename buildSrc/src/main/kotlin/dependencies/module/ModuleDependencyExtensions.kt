package dependencies.module

import core.*
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

fun DependencyHandler.addDiModule(configurationName: String = "implementation") {
    add(configurationName, project(ModulesDep.di))
}

fun DependencyHandler.addDataModule() {
    add("implementation", project(ModulesDep.data))
}

fun DependencyHandler.addDomainModule() {
    add("implementation", project(ModulesDep.domain))
}

fun DependencyHandler.addModelModule(configurationName: String = "implementation") {
    add(configurationName, project(ModulesDep.model))
}

fun DependencyHandler.addCommonModule() {
    add("implementation", project(ModulesDep.common))
}
