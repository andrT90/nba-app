package app.nba.app.presentation.screen.teams

import android.view.View
import app.nba.app.presentation.screen.teams.model.TeamViewModel
import app.nba.app.presentation.view.BaseViewHolder
import kotlinx.android.synthetic.main.teams_item_list.*

class TeamViewHolder(containerView: View) : BaseViewHolder(containerView) {
    private lateinit var item: TeamViewModel

    fun bind(item: TeamViewModel) {
        this.item = item
        team.text = item.name
    }
}