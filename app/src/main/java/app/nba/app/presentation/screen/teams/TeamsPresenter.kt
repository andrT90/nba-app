package app.nba.app.presentation.screen.teams

import app.nba.app.domain.Team
import app.nba.app.presentation.base.BasePresenter
import app.nba.app.presentation.screen.teams.model.TeamViewModel
import app.nba.app.presentation.screen.teams.model.TeamsState
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class TeamsPresenter @Inject constructor(private val teams: List<Team>) :
    BasePresenter<TeamsView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.render(TeamsState(teams.map { TeamViewModel(it) }))
    }
}