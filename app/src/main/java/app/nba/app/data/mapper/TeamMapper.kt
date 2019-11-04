package app.nba.app.data.mapper

import app.nba.app.data.net.dto.TeamDto
import app.nba.app.domain.Team
import app.nba.app.presentation.base.model.TeamViewModel

fun TeamDto.toTeam(): Team =
    Team(
        id = id ?: 0,
        abbreviation = abbreviation ?: "",
        city = city ?: "",
        conference = conference ?: "",
        division = division ?: "",
        fullName = fullName ?: "",
        name = name ?: ""
    )

fun List<TeamDto>.toListTeams(): List<Team> = map { it.toTeam() }

fun Team.toTeamViewModel(): TeamViewModel = TeamViewModel(this)