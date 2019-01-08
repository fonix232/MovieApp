package me.fonix232.movieapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.navigation.NavController
import me.fonix232.common.viewmodel.BaseViewModel
import me.fonix232.movieapp.model.Movie
import me.fonix232.movieapp.model.Rating
import me.fonix232.movieapp.repository.IMovieRepository
import org.koin.standalone.inject

class MovieViewModel : BaseViewModel() {
    private val repo: IMovieRepository by inject()

    private val repoMovie = repo.movie
    val movie: LiveData<Movie> = MediatorLiveData()
    val ratings: LiveData<List<Rating>> = MediatorLiveData()
    val actors: LiveData<List<String>> = MediatorLiveData()

    init {
        (ratings as MediatorLiveData).postValue(listOf())
        (actors as MediatorLiveData).postValue(listOf())

        (movie as MediatorLiveData).addSource(repoMovie) { movie.postValue(it) }
        (ratings as MediatorLiveData).addSource(movie) { movie -> ratings.postValue(movie?.ratings) }
        (actors as MediatorLiveData).addSource(movie) { movie -> actors.postValue(movie.actors?.split(',')) }
    }

    lateinit var navController: NavController

    fun getMovie(id: String) {
        repo.getMovie(id)
    }

    fun setMovie(data: Movie) {
        (movie as MediatorLiveData<Movie>).postValue(data)
        getMovie(data.id)
    }
}