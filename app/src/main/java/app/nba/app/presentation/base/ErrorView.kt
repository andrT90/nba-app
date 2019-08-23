package app.nba.app.presentation.base

import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface ErrorView : MvpView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showError(message: String)
}