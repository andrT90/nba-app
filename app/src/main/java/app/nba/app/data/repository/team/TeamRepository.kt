package app.nba.app.data.repository.team

import app.nba.app.domain.Team
import io.reactivex.Single

interface TeamRepository {
    fun getTeams(): Single<List<Team>>

    fun getTeam(id: Long): Single<Team>
}