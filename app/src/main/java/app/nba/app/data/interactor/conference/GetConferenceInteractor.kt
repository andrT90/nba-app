package app.nba.app.data.interactor.conference

import app.nba.app.domain.Conference
import io.reactivex.Single

interface GetConferenceInteractor {

    fun get(params: Params = Params()): Single<Result>

    class Params

    data class Result(val east: Conference, val west: Conference)
}