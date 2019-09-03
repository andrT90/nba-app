package app.nba.app.di.component

import app.nba.app.di.module.AppModule
import app.nba.app.di.module.NavigationModule
import app.nba.app.di.module.NetworkModule
import app.nba.app.di.module.TeamModule
import dagger.Component
import javax.inject.Singleton


@Component(
    modules = [
        AppModule::class, NetworkModule::class,
        NavigationModule::class, TeamModule::class
    ]
)
@Singleton
interface AppComponent {

    fun hostComponentFactory(): HostComponent.Factory
    fun conferenceComponentFactory(): ConferenceComponent.Factory
    fun teamsComponentFactory(): TeamsComponent.Factory
    fun teamComponentFactory(): TeamComponent.Factory
}