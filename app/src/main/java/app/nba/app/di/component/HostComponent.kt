package app.nba.app.di.component

import app.nba.app.di.scope.ActivityScope
import app.nba.app.presentation.screen.host.MainHost
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface HostComponent {
    fun inject(host: MainHost)

    @Subcomponent.Factory
    interface Factory {
        fun create(): HostComponent
    }
}