package dependencies

object DependenciesConst {
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtxVersion}"
    const val compose3Material = "androidx.compose.material3:material3:${Versions.material3Version}"
    const val compose3WindowSize = "androidx.compose.material3:material3-window-size-class:${Versions.material3Version}"
    const val compose3Adaptive = "androidx.compose.material3:material3-adaptive:${Versions.material3AdaptiveVersion}"
    const val compose3NavigationSuite = "androidx.compose.material3:material3-adaptive-navigation-suite:${Versions.material3AdaptiveNavigationSuiteVersion}"

    const val composeActivity =
        "androidx.activity:activity-compose:${Versions.activityComposeVersion}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.composeVersion}"
    const val composePreviewUi = "androidx.compose.ui:ui-tooling-preview:${Versions.composeVersion}"

    const val viewModel =
        "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycleVersion}"
    const val viewModelSaveState =
        "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.lifecycleVersion}"
    const val runtimeCompose =
        "androidx.lifecycle:lifecycle-runtime-compose:${Versions.lifecycleVersion}"
    const val lifecycleService = "androidx.lifecycle:lifecycle-service:${Versions.lifecycleVersion}"

    val koinCore = "io.insert-koin:koin-core:${Versions.koinVersion}"
    val koinKtor = "io.insert-koin:koin-ktor:${Versions.koinVersion}"
    val koinLoggerSlf4j = "io.insert-koin:koin-logger-slf4j:${Versions.koinVersion}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val moshi = "com.squareup.moshi:moshi:${Versions.moshiVersion}"
    const val okhHttp3 = "com.squareup.okhttp3:okhttp:${Versions.okhttp3Version}"
    const val okhHttp3Interceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp3Version}"

    const val kotlinCoroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"

    const val coil = "io.coil-kt:coil-compose:${Versions.coilVersion}"

    const val leakcanary =
        "com.squareup.leakcanary:leakcanary-android:${Versions.leakcanaryVersion}"

    const val timber = "com.jakewharton.timber:timber:${Versions.timberVersion}"

    const val jUnit = "androidx.compose.ui:ui-test-junit4:${Versions.composeVersion}"
    const val jUnitExt = "androidx.test.ext:junit:${Versions.jUnitExtVersion}"
    const val jUnitTestUi = "androidx.compose.ui:ui-test-junit4:${Versions.composeVersion}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoCoreVersion}"
    const val composeTooling = "androidx.compose.ui:ui-tooling:${Versions.composeVersion}"
    const val composeTestManifest =
        "androidx.compose.ui:ui-test-manifest:${Versions.composeVersion}"

    const val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val roomPaging = "androidx.room:room-paging:${Versions.roomVersion}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"

    val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigationComposeVersion}"
    val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigationComposeVersion}"
    val navigationCompose =
        "androidx.navigation:navigation-compose:${Versions.navigationComposeVersion}"

    val navigationSafeArgsPlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigationComposeVersion}"


}