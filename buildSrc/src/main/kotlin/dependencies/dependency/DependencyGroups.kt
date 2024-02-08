package dependencies.dependency

import dependencies.DependenciesConst

val androidMaterialDependencies = listOf(
    DependenciesConst.coreKtx,
    DependenciesConst.material,
)

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
    DependenciesConst.koinAndroid,
    DependenciesConst.koinWorkManager,
    DependenciesConst.koinNavigation,
    DependenciesConst.koinCompose
)

val networkDependencies = listOf(
    DependenciesConst.retrofit,
    DependenciesConst.okhHttp3,
    DependenciesConst.okhHttp3Interceptor
)
