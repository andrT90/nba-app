package app.nba.app.presentation.screen.pagerconference

import android.view.ViewGroup
import app.nba.app.R
import app.nba.app.domain.Team
import app.nba.app.extention.inflate
import app.nba.app.presentation.base.model.TeamViewModel
import app.nba.app.presentation.view.BaseViewModel
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

typealias TeamClickListener = (Team) -> Unit

class TeamsAdapterDelegate(private val callback: TeamClickListener) :
    AbsListItemAdapterDelegate<TeamViewModel, BaseViewModel, TeamViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup): TeamViewHolder =
        TeamViewHolder(parent.inflate(R.layout.pager_conference_team_item))

    override fun isForViewType(
        item: BaseViewModel,
        items: MutableList<BaseViewModel>,
        position: Int
    ): Boolean = item is TeamViewModel

    override fun onBindViewHolder(
        item: TeamViewModel,
        holder: TeamViewHolder,
        payloads: MutableList<Any>
    ) {
        holder.bind(item, callback)
    }
}