package app.nba.app.presentation.base

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface LoadingView : MvpView {
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showLoading(show: Boolean)
}