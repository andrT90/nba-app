package app.nba.app.di.component

import app.nba.app.di.scope.FragmentScope
import app.nba.app.domain.Team
import app.nba.app.presentation.screen.pagerconference.PagerConferenceFragment
import dagger.BindsInstance
import dagger.Subcomponent

@FragmentScope
@Subcomponent
interface PagerConferenceComponent {
    fun inject(fragment: PagerConferenceFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance teams: List<Team>): PagerConferenceComponent
    }
}