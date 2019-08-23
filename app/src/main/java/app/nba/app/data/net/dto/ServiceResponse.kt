package app.nba.app.data.net.dto

import com.google.gson.annotations.SerializedName

data class ServiceResponse<T>(
    @SerializedName("data") val data: T? = null,
    @SerializedName("meta") val meta: MetaDto? = null
)