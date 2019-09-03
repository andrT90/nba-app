package app.nba.app.presentation.screen.teams

import android.view.View
import app.nba.app.presentation.screen.teams.model.TeamViewModel
import app.nba.app.presentation.view.BaseViewHolder
import kotlinx.android.synthetic.main.teams_item_list.*

class TeamViewHolder(containerView: View) : BaseViewHolder(containerView) {
    private lateinit var item: TeamViewModel
    private lateinit var callback: TeamClickListener

    init {
        team.setOnClickListener { callback.invoke(item.team) }
    }

    fun bind(item: TeamViewModel, callback: TeamClickListener) {
        this.item = item
        this.callback = callback
        team.text = item.name
    }
}