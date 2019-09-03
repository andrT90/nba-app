package app.nba.app.di

import android.app.Application
import app.nba.app.di.component.*
import app.nba.app.di.module.AppModule
import app.nba.app.domain.Team

object DI {
    private lateinit var appComponent: AppComponent

    fun init(application: Application) {
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(application))
            .build()
    }

    fun conferenceComponent(): ConferenceComponent =
        appComponent
            .conferenceComponentBuilder()
            .build()

    fun teamsComponent(teams: List<Team>): TeamsComponent =
        appComponent
            .teamsComponentFactory()
            .create(teams)

    fun hostComponentBuilder(): HostComponent =
        appComponent
            .hostComponentBuilder()
            .build()


}