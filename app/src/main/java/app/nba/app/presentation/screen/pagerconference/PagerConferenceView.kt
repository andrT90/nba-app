package app.nba.app.presentation.screen.pagerconference

import app.nba.app.presentation.base.model.TeamsState
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface PagerConferenceView : MvpView {
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun render(state: TeamsState)
}