package skustra.dark.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import skustra.dark.domain.usecase.theme.ThemeRepository
import skustra.dark.domain.usecase.theme.ThemeRepositoryImpl

val appModule = module {

    single<DataStore<Preferences>> {
        androidContext().userPreferencesDataStore
    }

    single<ThemeRepository> { ThemeRepositoryImpl(get()) }

}

private val Context.userPreferencesDataStore: DataStore<Preferences> by preferencesDataStore(
    name = "preferences"
)