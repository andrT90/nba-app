package app.nba.app.di.component

import app.nba.app.presentation.screen.conference.ConferenceFragment
import dagger.Subcomponent
import javax.inject.Scope

@ConferenceScope
@Subcomponent
interface ConferenceComponent {
    fun inject(fragment: ConferenceFragment)

    @Subcomponent.Builder
    interface Builder {
        fun build(): ConferenceComponent
    }
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ConferenceScope