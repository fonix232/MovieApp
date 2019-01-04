package me.fonix232.movieapp.ui.fragment

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import me.fonix232.common.ui.fragment.BaseFragment
import me.fonix232.movieapp.R
import me.fonix232.movieapp.bindings.MovieFragmentBinding
import me.fonix232.movieapp.ui.adapter.MovieListAdapter
import me.fonix232.movieapp.ui.adapter.RatingsAdapter
import me.fonix232.movieapp.viewmodel.MovieViewModel

class MovieFragment :
    BaseFragment<MovieViewModel, MovieFragmentBinding>(MovieViewModel::class, R.layout.fragment_movie) {

    private lateinit var adapter: RatingsAdapter

    override fun afterBind(binding: MovieFragmentBinding) {
        super.afterBind(binding)
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        viewModel.navController = findNavController()

        val movie = MovieFragmentArgs.fromBundle(arguments!!).movie
        viewModel.getMovie(movie.id)

        binding.movie = movie
        viewModel.movie.observe(this, Observer {
            binding.movie = it
        })

        adapter = RatingsAdapter(viewModel.ratings, this)
        binding.ratings.adapter = adapter
        binding.ratings.layoutManager = LinearLayoutManager(context)
    }
}