package me.fonix232.movieapp.bindings

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView, url: String?) {
    if(url != null) {
        Glide.with(imageView).load(url).into(imageView)
    }
}