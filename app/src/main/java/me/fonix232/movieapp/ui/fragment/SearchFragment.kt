package me.fonix232.movieapp.ui.fragment

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import me.fonix232.common.ui.fragment.BaseFragment
import me.fonix232.movieapp.R
import me.fonix232.movieapp.bindings.SearchFragmentBinding
import me.fonix232.movieapp.viewmodel.SearchViewModel
import me.fonix232.movieapp.ui.adapter.MovieListAdapter

class SearchFragment :
    BaseFragment<SearchViewModel, SearchFragmentBinding>(SearchViewModel::class, R.layout.fragment_search) {

    private lateinit var adapter: MovieListAdapter

    override fun afterBind(binding: SearchFragmentBinding) {
        super.afterBind(binding)
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        viewModel.navController = findNavController()

        adapter = MovieListAdapter(viewModel.movies, this) { _, movie -> viewModel.selectMovie(movie) }

        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(context)
    }
}