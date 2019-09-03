package app.nba.app.presentation.screen.team.model

import app.nba.app.domain.Team

sealed class State

data class DataState(val team: Team) : State()

data class ErrorState(val throwable: Throwable) : State()

object LoadingState : State()