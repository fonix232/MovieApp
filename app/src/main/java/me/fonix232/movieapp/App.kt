package me.fonix232.movieapp

import android.app.Application
import org.koin.android.ext.android.startKoin
import timber.log.Timber

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        startKoin(this, listOf(omdbModule, networkModule, appModule))
    }
}