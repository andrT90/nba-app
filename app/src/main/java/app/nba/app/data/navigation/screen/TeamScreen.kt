package app.nba.app.data.navigation.screen

import androidx.fragment.app.Fragment
import app.nba.app.presentation.screen.team.TeamFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class TeamScreen(private val id: Long) : SupportAppScreen() {
    override fun getFragment(): Fragment = TeamFragment.newInstance(id)
}