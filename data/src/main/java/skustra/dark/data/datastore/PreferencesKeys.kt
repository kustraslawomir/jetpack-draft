package skustra.dark.data.datastore

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object PreferencesKeys {
    val KEY_DARK_MODE_APPLIED = booleanPreferencesKey("KEY_DARK_MODE_APPLIED")
    val KEY_COLOR_THEME = stringPreferencesKey("KEY_COLOR_THEME")
}

