package skustra.dark.domain.usecase.theme

interface ThemePreferences {

    suspend fun setDarkModeApplied(value: Boolean)

    suspend fun isDarkModeApplied(): Boolean?

    suspend fun getColorTheme(): ApplicationColorTheme

    suspend fun setColorTheme(value: ApplicationColorTheme)
}