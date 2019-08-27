package app.nba.app.data.navigation.screen

import androidx.fragment.app.Fragment
import app.nba.app.domain.Team
import app.nba.app.presentation.screen.teams.TeamsFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class TeamsScreen(private val teams: List<Team>) : SupportAppScreen() {
    override fun getFragment(): Fragment = TeamsFragment.newInstance(teams)
}