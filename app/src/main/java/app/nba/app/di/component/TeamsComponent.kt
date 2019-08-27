package app.nba.app.di.component

import app.nba.app.domain.Team
import app.nba.app.presentation.screen.conference.ConferenceFragment
import app.nba.app.presentation.screen.teams.TeamsFragment
import dagger.BindsInstance
import dagger.Subcomponent
import javax.inject.Scope

@TeamScope
@Subcomponent
interface TeamsComponent {
    fun inject(fragment: TeamsFragment)

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun teams(teams: List<Team>): Builder

        fun build(): TeamsComponent
    }
}

@Scope
@Retention
annotation class TeamScope