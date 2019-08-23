package app.nba.app.data.net.dto

import com.google.gson.annotations.SerializedName

data class TeamDto(
    @SerializedName("id") val id: Int? = 0,
    @SerializedName("abbreviation") val abbreviation: String? = "",
    @SerializedName("city") val city: String? = "",
    @SerializedName("conference") val conference: String? = "",
    @SerializedName("division") val division: String? = "",
    @SerializedName("full_name") val fullName: String? = "",
    @SerializedName("name") val name: String? = ""
)