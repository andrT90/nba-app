package app.nba.app.di.component

import app.nba.app.di.module.AppModule
import app.nba.app.di.module.NavigationModule
import app.nba.app.di.module.NetworkModule
import dagger.Component
import javax.inject.Singleton


@Component(
    modules = [
        AppModule::class, NetworkModule::class,
        NavigationModule::class
    ]
)
@Singleton
interface AppComponent {

    fun hostComponentBuilder(): HostComponent.Bulder
    fun conferenceComponentBuilder(): ConferenceComponent.Builder
    fun teamsComponentBuilder(): TeamsComponent.Builder
}