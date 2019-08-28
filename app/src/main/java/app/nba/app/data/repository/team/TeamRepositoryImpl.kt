package app.nba.app.data.repository.team

import app.nba.app.data.mapper.toListTeams
import app.nba.app.data.net.Api
import app.nba.app.domain.Team
import app.nba.app.extention.serviceResponseToData
import io.reactivex.Single
import javax.inject.Inject

class TeamRepositoryImpl @Inject constructor(private val api: Api) : TeamRepository {
    override fun getTeams(): Single<List<Team>> =
        api
            .teamService
            .getTeams()
            .serviceResponseToData()
            .map { it.toListTeams() }

    override fun getTeam(id: Long): Single<Team> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}