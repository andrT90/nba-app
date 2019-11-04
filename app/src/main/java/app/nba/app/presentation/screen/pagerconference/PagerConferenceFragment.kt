package app.nba.app.presentation.screen.pagerconference

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import app.nba.app.di.DI
import app.nba.app.domain.Team
import app.nba.app.extention.px
import app.nba.app.presentation.base.BaseFragment
import app.nba.app.presentation.base.model.TeamsState
import app.nba.app.presentation.view.BaseRecyclerViewAdapter
import dagger.Lazy
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

class PagerConferenceFragment : BaseFragment(), PagerConferenceView {

    companion object {

        private const val KEY_TEAMS = "key_teams"

        fun newInstance(teams: List<Team>): PagerConferenceFragment =
            PagerConferenceFragment().apply {
                arguments = bundleOf(KEY_TEAMS to teams)
            }
    }

    override val layoutRes: Int
        get() = -1

    private lateinit var list: RecyclerView
    private val adapter: BaseRecyclerViewAdapter by lazy {
        BaseRecyclerViewAdapter(TeamsAdapterDelegate { presenter.teamsClicked(it) })
    }

    @InjectPresenter
    lateinit var presenter: PagerConferencePresenter

    @Inject
    lateinit var lazyPresenter: Lazy<PagerConferencePresenter>

    @ProvidePresenter
    fun providePresenter(): PagerConferencePresenter = lazyPresenter.get()

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        DI.pagesConferenceComponentt(arguments?.getParcelableArrayList(KEY_TEAMS) ?: emptyList())
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        list = RecyclerView(requireContext())
        list.setPadding(16.px, 0, 16.px, 0)
        list.clipToPadding = false
        return list
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        list.adapter = adapter
        list.setHasFixedSize(true)
        val snap = PagerSnapHelper()
        snap.attachToRecyclerView(list)

    }

    override fun render(state: TeamsState) {
        adapter.items = state.team
    }
}