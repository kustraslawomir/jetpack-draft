package skustra.dark.domain.usecase.theme

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

internal object PreferencesKeys {
    val KEY_DARK_MODE_APPLIED = booleanPreferencesKey("KEY_DARK_MODE_APPLIED")
    val KEY_COLOR_THEME = stringPreferencesKey("KEY_COLOR_THEME")
}

