package app.nba.app.presentation.screen.conference.model

import app.nba.app.domain.Conference

data class ConferenceState(
    val conference: List<Conference>
)