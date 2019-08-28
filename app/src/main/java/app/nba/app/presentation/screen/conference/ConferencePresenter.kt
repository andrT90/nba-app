package app.nba.app.presentation.screen.conference

import android.util.Log
import app.nba.app.data.interactor.conference.GetConferenceInteractor
import app.nba.app.extention.loading
import app.nba.app.extention.observeOnMain
import app.nba.app.presentation.base.BasePresenter
import app.nba.app.presentation.screen.conference.model.ConferenceState
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class ConferencePresenter @Inject constructor(
    private val getConferenceInteractor: GetConferenceInteractor
) : BasePresenter<ConferenceView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        getConferenceInteractor
            .get()
            .observeOnMain()
            .loading(viewState)
            .subscribe(
                { viewState.render(ConferenceState(listOf(it.east, it.west))) },
                { Log.d("Log", it.toString()) }
            )
            .append()
    }
}