package app.nba.app.data.net

import app.nba.app.data.net.dto.ServiceResponse
import app.nba.app.data.net.dto.TeamDto
import io.reactivex.Single
import retrofit2.http.GET

interface TeamService {

    @GET("teams")
    fun getTeams(): Single<ServiceResponse<List<TeamDto>>>
}