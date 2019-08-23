package app.nba.app.data.net.dto

import com.google.gson.annotations.SerializedName

data class MetaDto(
    @SerializedName("total_pages") val totalPages: Int? = 0,
    @SerializedName("current_page") val currentPage: Int? = 0,
    @SerializedName("next_page") val nextPage: Int? = null,
    @SerializedName("per_page") val perPage: Int? = 0,
    @SerializedName("total_count") val totalCount: Int? = 0
)