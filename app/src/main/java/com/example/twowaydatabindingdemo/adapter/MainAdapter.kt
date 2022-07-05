package com.example.twowaydatabindingdemo

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.NonNull
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.twowaydatabindingdemo.databinding.AdapterMovieBinding
import com.example.twowaydatabindingdemo.model.Movie

class MainAdapter: RecyclerView.Adapter<MainViewHolder>() {
    var movies = mutableListOf<Movie>()

    @SuppressLint("NotifyDataSetChanged")
    fun setMovieList(movies: List<Movie>) {

        this.movies = movies.toMutableList()
        notifyDataSetChanged()
    }

    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): MainViewHolder =
        MainViewHolder(AdapterMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.apply {
            bind(movies[position])
        }

    }

    override fun getItemCount(): Int {
        return movies.size
    }

    companion object {
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(thumbs: ImageView, url: String) {
            Glide.with(thumbs)
                .load(url)
                .circleCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .fallback(R.drawable.ic_launcher_foreground)
                .into(thumbs)
        }
    }
}
class MainViewHolder(val binding: AdapterMovieBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie) {
        binding.p= movie
    }


}
