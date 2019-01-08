package me.fonix232.movieapp.ui.adapter

import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import me.fonix232.common.ui.adapter.BaseAdapter
import me.fonix232.common.ui.adapter.BaseViewHolder
import me.fonix232.movieapp.R
import me.fonix232.movieapp.bindings.ActorItemBinding

class ActorAdapter(items: LiveData<List<String>>, owner: LifecycleOwner) :
    BaseAdapter<String, ActorItemBinding, ActorVH>(items, owner, R.layout.item_actor, { _, _ -> }) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ActorVH(inflate(parent))
}

class ActorVH(binding: ActorItemBinding) : BaseViewHolder<String, ActorItemBinding>(binding, { _, _ -> })