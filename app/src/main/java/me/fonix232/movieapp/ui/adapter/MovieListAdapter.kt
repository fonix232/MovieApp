package me.fonix232.movieapp.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import me.fonix232.common.ui.adapter.BaseAdapter
import me.fonix232.common.ui.adapter.BaseViewHolder
import me.fonix232.movieapp.R
import me.fonix232.movieapp.bindings.MovieItemBinding
import me.fonix232.movieapp.model.Movie

class MovieListAdapter(items: LiveData<List<Movie>>, owner: LifecycleOwner, onClick: (View, Movie) -> Unit):
    BaseAdapter<Movie, MovieItemBinding,MovieViewHolder>(items, owner, R.layout.item_movie, onClick) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder = MovieViewHolder(inflate(parent), onClick)
}

class MovieViewHolder(binding: MovieItemBinding, onClick: (View, Movie)-> Unit): BaseViewHolder<Movie, MovieItemBinding>(binding, onClick)