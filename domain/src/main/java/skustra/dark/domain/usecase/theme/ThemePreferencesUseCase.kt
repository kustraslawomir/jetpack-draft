package skustra.dark.domain.usecase.theme

import skustra.dark.data.datastore.theme_prefenrences.ThemePreferencesStorage

class ThemePreferencesUseCase(private val storage: ThemePreferencesStorage) : ThemePreferences {

    override suspend fun setDarkModeApplied(value: Boolean) {
        storage.setDarkModeApplied(value)
    }

    override suspend fun isDarkModeApplied() = storage.isDarkModeApplied()

    override suspend fun setColorTheme(value: ApplicationColorTheme) {
        storage.setColorTheme(value.storageKey())
    }

    override suspend fun getColorTheme(): ApplicationColorTheme {
        return storage.getColorTheme()?.toColorTheme() ?: ApplicationColorTheme.Default
    }

    private fun ApplicationColorTheme.storageKey() = when (this) {
        ApplicationColorTheme.Default -> ThemeValue.VALUE_COLOR_THEME_DEFAULT
        ApplicationColorTheme.Dynamic -> ThemeValue.VALUE_COLOR_THEME_DYNAMIC
        ApplicationColorTheme.Orange -> ThemeValue.VALUE_COLOR_THEME_ORANGE
    }

    private fun String.toColorTheme() = when (this) {
        ThemeValue.VALUE_COLOR_THEME_DEFAULT -> ApplicationColorTheme.Default
        ThemeValue.VALUE_COLOR_THEME_DYNAMIC -> ApplicationColorTheme.Dynamic
        ThemeValue.VALUE_COLOR_THEME_ORANGE -> ApplicationColorTheme.Orange
        else -> throw IllegalArgumentException("Unknown key: $this")
    }

    object ThemeValue {
        const val VALUE_COLOR_THEME_DEFAULT = "VALUE_COLOR_THEME_DEFAULT"
        const val VALUE_COLOR_THEME_DYNAMIC = "VALUE_COLOR_THEME_DYNAMIC"
        const val VALUE_COLOR_THEME_ORANGE = "VALUE_COLOR_THEME_ORANGE"
    }
}