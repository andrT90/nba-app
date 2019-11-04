package app.nba.app.presentation.screen.pagerconference

import app.nba.app.data.navigation.screen.TeamScreen
import app.nba.app.domain.Team
import app.nba.app.presentation.base.BasePresenter
import app.nba.app.presentation.base.model.TeamViewModel
import app.nba.app.presentation.base.model.TeamsState
import moxy.InjectViewState
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class PagerConferencePresenter @Inject constructor(
    private val team: List<Team>,
    private val router: Router
) : BasePresenter<PagerConferenceView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.render(TeamsState(team.map { TeamViewModel(it) }))
    }

    fun teamsClicked(team: Team) {
        router.navigateTo(TeamScreen(team.id))
    }
}