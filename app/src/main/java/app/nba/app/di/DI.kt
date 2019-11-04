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
            .conferenceComponentFactory()
            .create()

    fun teamsComponent(teams: List<Team>): TeamsComponent =
        appComponent
            .teamsComponentFactory()
            .create(teams)

    fun hostComponentBuilder(): HostComponent =
        appComponent
            .hostComponentFactory()
            .create()

    fun teamComponent(id: Long): TeamComponent =
        appComponent
            .teamComponentFactory()
            .create(id)


    fun pagesConferenceComponentt(teams: List<Team>): PagerConferenceComponent =
        appComponent
            .pageConferenceComponent()
            .create(teams)

}