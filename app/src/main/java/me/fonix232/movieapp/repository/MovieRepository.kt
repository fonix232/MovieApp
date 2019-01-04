package me.fonix232.movieapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.fonix232.movieapp.api.IMovieClient
import me.fonix232.movieapp.model.Movie
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class MovieRepository : IMovieRepository, KoinComponent {

    private val client: IMovieClient by inject()

    override val movies: LiveData<List<Movie>> = MutableLiveData<List<Movie>>()
    override val movie: LiveData<Movie> = MutableLiveData<Movie>()

    override fun getMovies(query: String) {
        CoroutineScope(Dispatchers.IO).launch {
            moviesReceived(null)
            moviesReceived(client.search(query))
        }
    }

    override fun getMovie(movieId: String) {
        CoroutineScope(Dispatchers.IO).launch {
            movieReceived(null)
            movieReceived(client.get(movieId))
        }
    }

    private fun moviesReceived(newData: List<Movie>?) {
        CoroutineScope(Dispatchers.Main).launch {
            (movies as MutableLiveData<List<Movie>>).postValue(newData)
        }
    }

    private fun movieReceived(newData: Movie?) {
        CoroutineScope(Dispatchers.Main).launch {
            (movie as MutableLiveData<Movie>).postValue(newData)
        }
    }
}

interface IMovieRepository {
    fun getMovies(query: String)
    fun getMovie(movieId: String)

    val movies: LiveData<List<Movie>>
    val movie: LiveData<Movie>
}