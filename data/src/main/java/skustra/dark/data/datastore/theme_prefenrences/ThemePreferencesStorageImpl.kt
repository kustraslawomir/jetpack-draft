package skustra.dark.data.datastore.theme_prefenrences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.first
import skustra.dark.data.datastore.PreferencesKeys

class ThemePreferencesStorageImpl(private val dataStore: DataStore<Preferences>) :
    ThemePreferencesStorage {

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

    override suspend fun setColorTheme(value: String) {
        dataStore.edit { mutablePreferences ->
            mutablePreferences[PreferencesKeys.KEY_COLOR_THEME] = value
        }
    }

    override suspend fun getColorTheme(): String? {
        return dataStore
            .data
            .first()[PreferencesKeys.KEY_COLOR_THEME]
    }
}