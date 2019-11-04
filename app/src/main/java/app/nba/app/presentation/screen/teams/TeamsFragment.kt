package app.nba.app.presentation.screen.teams

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.nba.app.di.DI
import app.nba.app.domain.Team
import app.nba.app.presentation.base.BaseFragment
import app.nba.app.presentation.base.model.TeamsState
import app.nba.app.presentation.view.BaseRecyclerViewAdapter
import dagger.Lazy
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

class TeamsFragment : BaseFragment(), TeamsView {

    companion object {
        private const val KEY_TEAMS = "teams"

        fun newInstance(teams: List<Team>): TeamsFragment = TeamsFragment().apply {
            arguments = bundleOf(KEY_TEAMS to teams)
        }
    }

    override val layoutRes: Int
        get() = -1

    @Inject
    lateinit var lazyPresenter: Lazy<TeamsPresenter>

    @InjectPresenter
    lateinit var presenter: TeamsPresenter

    @ProvidePresenter
    fun providePresenter(): TeamsPresenter = lazyPresenter.get()

    private lateinit var list: RecyclerView
    private val adapter: BaseRecyclerViewAdapter by lazy {
        BaseRecyclerViewAdapter(
            TeamsAdapterDelegate { presenter.teamClicked(it) }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        list = RecyclerView(requireContext())
        return list
    }

    override fun onAttach(context: Context?) {
        DI.teamsComponent(arguments?.getParcelableArrayList(KEY_TEAMS) ?: emptyList()).inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(requireContext())
        list.setHasFixedSize(true)
    }

    override fun render(state: TeamsState) {
        adapter.items = state.team
    }
}