package app.nba.app.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Team(
    val id: Int = 0,
    val abbreviation: String = "",
    val city: String = "",
    val conference: String = "",
    val division: String = "",
    val fullName: String = "",
    val name: String = ""
) : Parcelable