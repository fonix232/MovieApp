package me.fonix232.movieapp.ui.adapter

import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import me.fonix232.common.ui.adapter.BaseAdapter
import me.fonix232.common.ui.adapter.BaseViewHolder
import me.fonix232.movieapp.R
import me.fonix232.movieapp.model.Rating
import me.fonix232.movieapp.bindings.RatingItemBinding

class RatingsAdapter(items: LiveData<List<Rating>>, owner: LifecycleOwner) : BaseAdapter<Rating, RatingItemBinding, RatingsVH>(items, owner, R.layout.item_rating, {_,_ -> }) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatingsVH = RatingsVH(inflate(parent))
}

class RatingsVH(binding: RatingItemBinding): BaseViewHolder<Rating, RatingItemBinding>(binding, {_,_ -> })