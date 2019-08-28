package app.nba.app.presentation.screen.teams.model

import app.nba.app.domain.Team
import app.nba.app.presentation.view.BaseViewModel

data class TeamViewModel(
    val team: Team
) : BaseViewModel {

    override fun calculateDiff(obj: Any): Boolean {
        val item = obj as? TeamViewModel
        return if (item == null) false
        else item.team.id == team.id
    }

    val name: String
        get() = team.fullName
}