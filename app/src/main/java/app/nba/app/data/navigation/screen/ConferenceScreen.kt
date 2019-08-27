package app.nba.app.data.navigation.screen

import androidx.fragment.app.Fragment
import app.nba.app.presentation.screen.conference.ConferenceFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class ConferenceScreen() : SupportAppScreen() {
    override fun getFragment(): Fragment = ConferenceFragment.newInstance()
}