package skustra.dark.domain.usecase.theme

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.single
import skustra.dark.common.theme.ApplicationColorTheme

class ThemeRepositoryImpl(private val dataStore: DataStore<Preferences>) : ThemeRepository {

    override suspend fun setDarkModeApplied(value: Boolean) {
        dataStore.edit { mutablePreferences ->
            mutablePreferences[PreferencesKeys.KEY_DARK_MODE_APPLIED] = value
        }
    }

    override suspend fun isDarkModeApplied(): Boolean? {
        return dataStore
            .data
            .first()[PreferencesKeys.KEY_DARK_MODE_APPLIED]
    }

    override suspend fun setColorTheme(value: ApplicationColorTheme) {
        dataStore.edit { mutablePreferences ->
            mutablePreferences[PreferencesKeys.KEY_COLOR_THEME] = value.storageKey()
        }
    }

    override suspend fun getColorTheme(): ApplicationColorTheme {
        return dataStore
            .data
            .first()[PreferencesKeys.KEY_COLOR_THEME]
            ?.toColorTheme() ?: ApplicationColorTheme.Default
    }

    private fun ApplicationColorTheme.storageKey() = when (this) {
        ApplicationColorTheme.Default -> ThemeValue.VALUE_COLOR_THEME_DEFAULT
        ApplicationColorTheme.Dynamic -> ThemeValue.VALUE_COLOR_THEME_DYNAMIC
        ApplicationColorTheme.Orange -> ThemeValue.VALUE_COLOR_THEME_ORANGE
    }

    private fun String.toColorTheme() =
        when (this) {
            ThemeValue.VALUE_COLOR_THEME_DEFAULT -> ApplicationColorTheme.Default
            ThemeValue.VALUE_COLOR_THEME_DYNAMIC -> ApplicationColorTheme.Dynamic
            ThemeValue.VALUE_COLOR_THEME_ORANGE -> ApplicationColorTheme.Orange
            else -> throw IllegalArgumentException("Unknown key: $this")
        }
}