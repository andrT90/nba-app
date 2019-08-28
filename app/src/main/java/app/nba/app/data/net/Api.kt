package app.nba.app.data.net

import javax.inject.Inject

class Api @Inject constructor(
    val teamService: TeamService
)