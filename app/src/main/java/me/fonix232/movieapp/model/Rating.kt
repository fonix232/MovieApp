package me.fonix232.movieapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Rating(val source: String? = null, val rating: String? = null): Parcelable