package me.fonix232.movieapp.api.omdb

import kotlinx.coroutines.Deferred
import me.fonix232.movieapp.Keys
import me.fonix232.movieapp.api.IMovieClient
import me.fonix232.movieapp.api.omdb.model.MovieResult
import me.fonix232.movieapp.api.omdb.model.SearchResponse
import me.fonix232.movieapp.api.omdb.model.SearchResult
import me.fonix232.movieapp.model.Movie
import me.fonix232.movieapp.model.Rating
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

class OMDBClient : IMovieClient, KoinComponent {
    private val retrofit: Retrofit by inject()
    private val apiKey: String by inject(Keys.API_KEY)
    private val api: OMDBApi = retrofit.create(OMDBApi::class.java)

    override suspend fun search(query: String): List<Movie> {
        val result = api.searchMovies(query, apiKey).await()
        return result.results!!.map { convertSearchResult(it) }
    }

    override suspend fun get(id: String): Movie? {
        val response = api.getMovieById(id, apiKey).await()

        return if (response.isSuccessful) {
            convertMovieResult(response)
        } else {
            null
        }
    }

    private fun convertSearchResult(it: SearchResult): Movie {
        return Movie(it.imdbID, poster = it.poster, title = it.title, year = it.year, genre = it.type)
    }

    private fun convertMovieResult(it: MovieResult): Movie {
        return Movie(it.imdbID!!,
            poster = it.poster,
            title = it.title,
            year = it.year,
            genre = it.genre,
            runtime = it.runtime,
            director = it.director,
            writer = it.writer,
            actors =  it.actors,
            plot = it.plot,
            ratings = getRatings(it))
    }

    fun getRatings(it: MovieResult): List<Rating> {
        if(it.ratings == null) return listOf()

        return it.ratings.map { rating -> Rating(rating.source, rating.rating)}
    }

    interface OMDBApi {

        @GET("/")
        fun searchMovies(@Query("s") query: String, @Query("apikey") apiKey: String, @Query("page") page: Int? = null): Deferred<SearchResponse>

        @GET("/")
        fun getMovieById(@Query("i") movieId: String, @Query("apikey") apiKey: String): Deferred<MovieResult>
    }
}

