package app.nba.app.presentation.screen.team

import app.nba.app.data.interactor.team.GetTeamInteractor
import app.nba.app.extention.observeOnMain
import app.nba.app.presentation.base.BasePresenter
import app.nba.app.presentation.screen.team.model.DataState
import app.nba.app.presentation.screen.team.model.ErrorState
import app.nba.app.presentation.screen.team.model.LoadingState
import app.nba.app.presentation.screen.team.model.State
import moxy.InjectViewState
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class TeamPresenter @Inject constructor(
    private val teamId: Long,
    private val getTeamInteractor: GetTeamInteractor,
    private val router: Router
) : BasePresenter<TeamView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        getTeamInteractor
            .get(GetTeamInteractor.Params(teamId))
            .map { DataState(it.team) as State }
            .onErrorReturn { ErrorState(it) }
            .observeOnMain()
            .startWith(LoadingState)
            .subscribe { viewState.render(it) }
            .append()
    }

    fun onBackPressed() {
        router.exit()
    }
}