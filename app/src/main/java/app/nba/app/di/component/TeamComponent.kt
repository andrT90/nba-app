package app.nba.app.di.component

import app.nba.app.di.scope.FragmentScope
import app.nba.app.presentation.screen.team.TeamFragment
import dagger.BindsInstance
import dagger.Subcomponent

@FragmentScope
@Subcomponent
interface TeamComponent {
    fun inject(fragment: TeamFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance id: Long): TeamComponent
    }
}