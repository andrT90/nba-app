package app.nba.app.presentation.screen.conference

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import app.nba.app.R
import app.nba.app.data.navigation.screen.TeamsScreen
import app.nba.app.di.DI
import app.nba.app.domain.Conference
import app.nba.app.presentation.base.BaseFragment
import app.nba.app.presentation.screen.conference.model.ConferenceState
import dagger.Lazy
import kotlinx.android.synthetic.main.conference.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

class ConferenceFragment : BaseFragment(), ConferenceView {

    companion object {
        fun newInstance(): ConferenceFragment = ConferenceFragment().apply {
            arguments = Bundle().apply {
            }
        }
    }

    override val layoutRes: Int
        get() = R.layout.conference


    @Inject
    lateinit var lazyPresenter: Lazy<ConferencePresenter>

    @InjectPresenter
    lateinit var presenter: ConferencePresenter

    @ProvidePresenter
    fun providePresenter(): ConferencePresenter = lazyPresenter.get()

    override fun onAttach(context: Context?) {
        DI.conferenceComponent().inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tabs.setupWithViewPager(pager)
    }

    override fun render(state: ConferenceState) {
        pager.adapter = ConferencePagerAdapter(state.conference, childFragmentManager)
        refresher?.isEnabled = false
    }

}

private class ConferencePagerAdapter(
    private val conferences: List<Conference>,
    fragmentManager: FragmentManager
) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment =
        TeamsScreen(conferences[position].teams).fragment

    override fun getCount(): Int = conferences.size

    override fun getPageTitle(position: Int): CharSequence? = conferences[position].name

}