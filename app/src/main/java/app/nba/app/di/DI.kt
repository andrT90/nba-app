package app.nba.app.di

import android.app.Application
import app.nba.app.di.component.AppComponent
import app.nba.app.di.component.DaggerAppComponent
import app.nba.app.di.module.AppModule

object DI {
    private lateinit var appComponent: AppComponent

    fun init(application: Application) {
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(application))
            .build()
    }
}