package me.fonix232.movieapp.api

import me.fonix232.movieapp.model.Movie

interface IMovieClient {
    suspend fun search(query: String): List<Movie>
    suspend fun get(id: String): Movie?
}