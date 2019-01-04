package me.fonix232.movieapp

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import me.fonix232.movieapp.api.IMovieClient
import me.fonix232.movieapp.api.omdb.OMDBClient
import me.fonix232.movieapp.repository.IMovieRepository
import me.fonix232.movieapp.repository.MovieRepository
import me.fonix232.movieapp.viewmodel.MainViewModel
import me.fonix232.movieapp.viewmodel.MovieViewModel
import me.fonix232.movieapp.viewmodel.SearchViewModel
import org.koin.androidx.viewmodel.experimental.builder.viewModel
import org.koin.dsl.module.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Keys {
    const val BASE_URL = "baseUrl"
    const val API_KEY = "apiKey"
}

val appModule = module {
    single<IMovieRepository> { MovieRepository() }

    viewModel<MainViewModel>()
    viewModel<SearchViewModel>()
    viewModel<MovieViewModel>()
}

val networkModule = module {
    single<Gson> { GsonBuilder().create() }
    single<Converter.Factory> { GsonConverterFactory.create(get()) }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(get<String>(Keys.BASE_URL))
            .addConverterFactory(get<Converter.Factory>())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }
}

val omdbModule = module {
    single(Keys.BASE_URL) { "http://www.omdbapi.com/" }
    single(Keys.API_KEY) { BuildConfig.OMDB_ApiKey }
    single<IMovieClient> { OMDBClient() }
}