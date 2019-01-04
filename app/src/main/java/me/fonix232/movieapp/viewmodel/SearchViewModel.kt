package me.fonix232.movieapp.viewmodel

import androidx.databinding.adapters.SearchViewBindingAdapter
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import me.fonix232.common.viewmodel.BaseViewModel
import me.fonix232.movieapp.model.Movie
import me.fonix232.movieapp.repository.IMovieRepository
import me.fonix232.movieapp.ui.fragment.MovieFragmentDirections
import org.koin.standalone.inject

class SearchViewModel : BaseViewModel() {
    private val repo: IMovieRepository by inject()

    val movies: LiveData<List<Movie>> = repo.movies

    lateinit var navController: NavController

    val onSubmit = SearchViewBindingAdapter.OnQueryTextSubmit {
        if (it != null) {
            search(it)
        } else {
            // TODO: Error handling of empty search
        }

        true
    }

    fun selectMovie(movie: Movie) = navController.navigate(MovieFragmentDirections.gotoMovie(movie))

    private fun search(value: String) = repo.getMovies(value)
}