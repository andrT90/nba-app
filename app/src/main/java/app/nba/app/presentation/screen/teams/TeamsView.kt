package app.nba.app.presentation.screen.teams

import app.nba.app.presentation.base.LoadingView
import app.nba.app.presentation.screen.teams.model.TeamsState
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface TeamsView : MvpView, LoadingView {
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun render(state: TeamsState)
}