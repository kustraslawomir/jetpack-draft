package skustra.dark.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import skustra.dark.data.datastore.theme_prefenrences.ThemePreferencesStorage
import skustra.dark.data.datastore.theme_prefenrences.ThemePreferencesStorageImpl
import skustra.dark.domain.usecase.theme.ThemePreferences
import skustra.dark.domain.usecase.theme.ThemePreferencesUseCase

val appModule = module {

    single<DataStore<Preferences>> {
        androidContext().userPreferencesDataStore
    }

    single<ThemePreferencesStorage> { ThemePreferencesStorageImpl(get()) }
    single<ThemePreferences> { ThemePreferencesUseCase(get()) }

}

private val Context.userPreferencesDataStore: DataStore<Preferences> by preferencesDataStore(
    name = "preferences"
)