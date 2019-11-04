package app.nba.app.data.navigation.screen

import androidx.fragment.app.Fragment
import app.nba.app.domain.Team
import app.nba.app.presentation.screen.pagerconference.PagerConferenceFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class PagerTeamsScreen(private val team: List<Team>) : SupportAppScreen() {
    override fun getFragment(): Fragment = PagerConferenceFragment.newInstance(team)
}