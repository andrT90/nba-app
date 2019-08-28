package app.nba.app.presentation.screen.teams

import android.view.ViewGroup
import app.nba.app.R
import app.nba.app.extention.inflate
import app.nba.app.presentation.screen.teams.model.TeamViewModel
import app.nba.app.presentation.view.BaseViewModel
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class TeamsAdapterDelegate :
    AbsListItemAdapterDelegate<TeamViewModel, BaseViewModel, TeamViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup): TeamViewHolder = TeamViewHolder(
        parent.inflate(
            R.layout.teams_item_list
        )
    )

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
        holder.bind(item)
    }
}