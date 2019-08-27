package app.nba.app.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Conference(
    val name: String = "",
    val teams: List<Team> = emptyList()
) : Parcelable