package app.nba.app.data.interactor.conference

import app.nba.app.data.repository.team.TeamRepository
import app.nba.app.domain.Conference
import app.nba.app.domain.Team
import io.reactivex.BackpressureStrategy
import io.reactivex.Single
import javax.inject.Inject

class GetConferenceInteractorImpl @Inject constructor(
    private val teamRepository: TeamRepository
) : GetConferenceInteractor {

    companion object {
        private const val EAST = "East"
        private const val WEST = "West"
    }

    override fun get(params: GetConferenceInteractor.Params): Single<GetConferenceInteractor.Result> = teamRepository
        .getTeams()
        .flattenAsObservable { it }
        .toFlowable(BackpressureStrategy.BUFFER)
        .filter { it.conference.isNotEmpty() }
        .toList()
        .map {
            val map = it.groupBy { team -> team.conference }
            GetConferenceInteractor.Result(
                Conference(EAST, map[EAST] ?: emptyList<Team>()),
                Conference(WEST, map[WEST] ?: emptyList<Team>())
            )
        }
}