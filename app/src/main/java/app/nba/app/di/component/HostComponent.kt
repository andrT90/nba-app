package app.nba.app.di.component

import app.nba.app.presentation.screen.host.MainHost
import dagger.Subcomponent
import javax.inject.Scope

@HostScope
@Subcomponent
interface HostComponent {
    fun inject(host: MainHost)

    @Subcomponent.Builder
    interface Bulder {
        fun build(): HostComponent
    }
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class HostScope