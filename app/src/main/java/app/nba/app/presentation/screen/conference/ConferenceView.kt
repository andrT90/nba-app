package app.nba.app.presentation.screen.conference

import app.nba.app.presentation.base.ErrorView
import app.nba.app.presentation.base.LoadingView
import app.nba.app.presentation.base.MessageView
import app.nba.app.presentation.screen.conference.model.ConferenceState
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface ConferenceView : MvpView, ErrorView, MessageView, LoadingView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun render(state: ConferenceState)
}