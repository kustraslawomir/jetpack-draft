package skustra.dark.domain.usecase.theme

sealed class ThemeColorScheme {
    data object Default : ThemeColorScheme()
    data object Dynamic : ThemeColorScheme()
    data object Orange : ThemeColorScheme()
}