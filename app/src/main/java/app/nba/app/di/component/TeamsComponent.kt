package app.nba.app.di.component

import app.nba.app.domain.Team
import app.nba.app.presentation.screen.teams.TeamsFragment
import dagger.BindsInstance
import dagger.Subcomponent
import javax.inject.Scope

@TeamScope
@Subcomponent
interface TeamsComponent {
    fun inject(fragment: TeamsFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance teams: List<Team>): TeamsComponent
    }
}

@Scope
@Retention
annotation class TeamScope