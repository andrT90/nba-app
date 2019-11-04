package app.nba.app.presentation.screen.pagerconference

import android.view.View
import app.nba.app.presentation.base.model.TeamViewModel
import app.nba.app.presentation.view.BaseViewHolder
import kotlinx.android.synthetic.main.teams_item_list.*

class TeamViewHolder(containerView: View) : BaseViewHolder(containerView) {
    private lateinit var item: TeamViewModel
    private lateinit var callback: TeamClickListener

    init {
        itemView.setOnClickListener {
            callback(item.team)
        }
    }

    fun bind(
        item: TeamViewModel,
        callback: TeamClickListener
    ) {
        this.item = item
        this.callback = callback
        team.text = item.name
    }
}