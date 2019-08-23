package app.nba.app.di.component

import app.nba.app.di.module.AppModule
import app.nba.app.di.module.NetworkModule
import dagger.Component


@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {
}