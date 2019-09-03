package app.nba.app.presentation.screen.team

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import app.nba.app.R
import app.nba.app.di.DI
import app.nba.app.domain.Team
import app.nba.app.extention.hideLoadingAndDisable
import app.nba.app.presentation.base.BaseFragment
import app.nba.app.presentation.screen.team.model.DataState
import app.nba.app.presentation.screen.team.model.ErrorState
import app.nba.app.presentation.screen.team.model.LoadingState
import app.nba.app.presentation.screen.team.model.State
import dagger.Lazy
import kotlinx.android.synthetic.main.team.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

class TeamFragment : BaseFragment(), TeamView {

    companion object {
        private const val KEY_ID = "id"

        fun newInstance(id: Long): TeamFragment = TeamFragment().apply {
            arguments = bundleOf(KEY_ID to id)
        }
    }

    override val layoutRes: Int
        get() = R.layout.team

    @Inject
    lateinit var lazyPresenter: Lazy<TeamPresenter>

    @InjectPresenter
    lateinit var presenter: TeamPresenter

    @ProvidePresenter
    fun providePresenter(): TeamPresenter = lazyPresenter.get()


    override fun onAttach(context: Context?) {
        DI
            .teamComponent(
                arguments?.getLong(KEY_ID) ?: throw IllegalStateException("No id param in bundle.")
            )
            .inject(this)

        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar.setNavigationOnClickListener { presenter.onBackPressed() }
    }

    override fun render(state: State) {
        when (state) {
            is DataState -> renderData(state.team)
            is ErrorState -> renderError(state.throwable)
            is LoadingState -> renderLoading()
        }
    }

    private fun renderData(team: Team) {
        name.text = team.fullName
        division.text = getString(R.string.team_division_format, team.division)
        conference.text = getString(R.string.team_conference_format, team.conference)
        toolbar.title = team.name
        refresher?.hideLoadingAndDisable()
    }

    private fun renderError(throwable: Throwable) {
        refresher?.hideLoadingAndDisable()
        throwable.message?.let { showMessage(it) }
    }

    private fun renderLoading() {
        refresher?.isRefreshing = true
    }
}