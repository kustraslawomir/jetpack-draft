package skustra.dark.data.datastore.theme_prefenrences

interface ThemePreferencesStorage {

    suspend fun setDarkModeApplied(value: Boolean)

    suspend fun isDarkModeApplied(): Boolean?

    suspend fun setColorTheme(value: String)

    suspend fun getColorTheme(): String?
}