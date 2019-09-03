package app.nba.app.presentation.screen.team

import app.nba.app.presentation.screen.team.model.State
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface TeamView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun render(state: State)
}