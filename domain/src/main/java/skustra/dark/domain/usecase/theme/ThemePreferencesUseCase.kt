package skustra.dark.domain.usecase.theme

import skustra.dark.data.datastore.theme_prefenrences.ThemePreferencesStorage

class ThemePreferencesUseCase(private val storage: ThemePreferencesStorage) : ThemePreferences {

    override suspend fun setDarkModeApplied(value: Boolean) {
        storage.setDarkModeApplied(value)
    }

    override suspend fun isDarkModeApplied() = storage.isDarkModeApplied()

    override suspend fun setColorTheme(value: ThemeColorScheme) {
        storage.setColorTheme(value.storageKey())
    }

    override suspend fun getColorTheme(): ThemeColorScheme {
        return storage.getColorTheme()?.toColorTheme() ?: ThemeColorScheme.Default
    }

    private fun ThemeColorScheme.storageKey() = when (this) {
        ThemeColorScheme.Default -> ThemeValue.VALUE_COLOR_THEME_DEFAULT
        ThemeColorScheme.Dynamic -> ThemeValue.VALUE_COLOR_THEME_DYNAMIC
        ThemeColorScheme.Orange -> ThemeValue.VALUE_COLOR_THEME_ORANGE
    }

    private fun String.toColorTheme() = when (this) {
        ThemeValue.VALUE_COLOR_THEME_DEFAULT -> ThemeColorScheme.Default
        ThemeValue.VALUE_COLOR_THEME_DYNAMIC -> ThemeColorScheme.Dynamic
        ThemeValue.VALUE_COLOR_THEME_ORANGE -> ThemeColorScheme.Orange
        else -> throw IllegalArgumentException("Unknown key: $this")
    }

    object ThemeValue {
        const val VALUE_COLOR_THEME_DEFAULT = "VALUE_COLOR_THEME_DEFAULT"
        const val VALUE_COLOR_THEME_DYNAMIC = "VALUE_COLOR_THEME_DYNAMIC"
        const val VALUE_COLOR_THEME_ORANGE = "VALUE_COLOR_THEME_ORANGE"
    }
}