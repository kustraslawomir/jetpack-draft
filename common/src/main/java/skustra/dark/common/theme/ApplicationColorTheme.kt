package skustra.dark.common.theme

sealed class ApplicationColorTheme {
    data object Default : ApplicationColorTheme()
    data object Dynamic : ApplicationColorTheme()
    data object Orange : ApplicationColorTheme()
}