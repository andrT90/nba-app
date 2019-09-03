package app.nba.app.data.interactor.team

import app.nba.app.domain.Team
import io.reactivex.Flowable

interface GetTeamInteractor {

    fun get(param: Params): Flowable<Result>

    data class Params(val id: Long)

    data class Result(val team: Team)
}