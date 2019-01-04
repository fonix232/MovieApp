package me.fonix232.movieapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val id: String,
    val title: String? = null,
    val year: String? = null,
    val runtime: String? = null,
    val genre: String? = null,
    val director: String? = null,
    val writer: String? = null,
    val actors: String? = null,
    val plot: String? = null,
    var poster: String? = null,
    val ratings: List<Rating> = listOf()
): Parcelable