package app.nba.app.presentation.base

import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface MessageView : MvpView {
    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showMessage(message: CharSequence)
}