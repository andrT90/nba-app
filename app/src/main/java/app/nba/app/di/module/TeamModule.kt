package app.nba.app.di.module

import app.nba.app.data.interactor.conference.GetConferenceInteractor
import app.nba.app.data.interactor.conference.GetConferenceInteractorImpl
import app.nba.app.data.interactor.team.GetTeamInteractor
import app.nba.app.data.interactor.team.GetTeamInteractorImpl
import app.nba.app.data.repository.team.TeamRepository
import app.nba.app.data.repository.team.TeamRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class TeamModule {

    @Binds
    abstract fun bindGetConferenceInteractor(interactor: GetConferenceInteractorImpl): GetConferenceInteractor

    @Binds
    abstract fun bindGetTeamInteractor(interactor: GetTeamInteractorImpl): GetTeamInteractor

    @Binds
    abstract fun bindTeamRepository(repository: TeamRepositoryImpl): TeamRepository
}