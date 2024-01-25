package dependencies.dependency

import dependencies.DependenciesConst

val androidComposeDependencies = listOf(
    DependenciesConst.coreKtx,
    DependenciesConst.compose3Material,
    DependenciesConst.compose3WindowSize,
    DependenciesConst.compose3Adaptive,
    DependenciesConst.compose3NavigationSuite,
    DependenciesConst.composeActivity,
    DependenciesConst.composeUi,
    DependenciesConst.composePreviewUi
)

val androidxLifeCycleDependencies = listOf(
    DependenciesConst.viewModel,
    DependenciesConst.runtimeCompose,
    DependenciesConst.viewModelSaveState,
    DependenciesConst.lifecycleService,
)

val koinDependencies = listOf(
    DependenciesConst.koinCore,
    DependenciesConst.koinKtor,
    DependenciesConst.koinLoggerSlf4j
)

val networkDependencies = listOf(
    DependenciesConst.retrofit,
    DependenciesConst.okhHttp3,
    DependenciesConst.okhHttp3Interceptor
)

val coroutinesAndroidDependencies = listOf(
    DependenciesConst.kotlinCoroutines,
)

val coilImageLoadingDependencies = listOf(
    DependenciesConst.coil,
)


