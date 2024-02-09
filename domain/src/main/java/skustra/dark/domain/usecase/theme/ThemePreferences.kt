package skustra.dark.domain.usecase.theme

interface ThemePreferences {

    suspend fun setDarkModeApplied(value: Boolean)

    suspend fun isDarkModeApplied(): Boolean?

    suspend fun getColorTheme(): ThemeColorScheme

    suspend fun setColorTheme(value: ThemeColorScheme)
}