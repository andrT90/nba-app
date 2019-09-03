package app.nba.app.data.interactor.team

import app.nba.app.data.repository.team.TeamRepository
import io.reactivex.Flowable
import javax.inject.Inject

class GetTeamInteractorImpl @Inject constructor(
    private val teamRepository: TeamRepository
) : GetTeamInteractor {

    override fun get(param: GetTeamInteractor.Params): Flowable<GetTeamInteractor.Result> =
        teamRepository
            .getTeam(param.id)
            .map { GetTeamInteractor.Result(it) }
            .toFlowable()

}