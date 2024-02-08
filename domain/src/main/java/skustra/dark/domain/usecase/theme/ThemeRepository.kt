package skustra.dark.domain.usecase.theme

import skustra.dark.common.theme.ApplicationColorTheme

interface ThemeRepository {
    suspend fun setDarkModeApplied(value: Boolean)
    suspend fun isDarkModeApplied(): Boolean?
    suspend fun getColorTheme(): ApplicationColorTheme
    suspend fun setColorTheme(value: ApplicationColorTheme)
}