package me.fonix232.movieapp.api.omdb.model

abstract class BaseResponse(open val response: String) {

    val isSuccessful: Boolean
        get() = when (response) {
            "True" -> true
            "False" -> false
            else -> false
        }
}