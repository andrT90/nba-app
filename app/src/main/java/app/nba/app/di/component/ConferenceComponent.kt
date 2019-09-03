package app.nba.app.di.component

import app.nba.app.di.scope.FragmentScope
import app.nba.app.presentation.screen.conference.ConferenceFragment
import dagger.Subcomponent

@FragmentScope
@Subcomponent
interface ConferenceComponent {
    fun inject(fragment: ConferenceFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): ConferenceComponent
    }
}