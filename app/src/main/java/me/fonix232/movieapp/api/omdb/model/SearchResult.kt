package me.fonix232.movieapp.api.omdb.model

import com.google.gson.annotations.SerializedName

data class SearchResult(
    @SerializedName("Title") val title: String,
    @SerializedName("Year") val year: String,
    @SerializedName("imdbID") val imdbID: String,
    @SerializedName("Type") val type: String,
    @SerializedName("Poster") val poster: String
)

data class SearchResponse(
    @SerializedName("Search") val results: List<SearchResult>?,
    @SerializedName("totalResults") val count: String?,
    @SerializedName("Response") override val response: String,
    @SerializedName("Error") val error: String?
): BaseResponse(response)

