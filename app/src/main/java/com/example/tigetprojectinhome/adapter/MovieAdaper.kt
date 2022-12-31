package com.example.tigetprojectinhome.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.tigetprojectinhome.R
import com.example.tigetprojectinhome.databinding.MoviesItemBinding
import com.example.tigetprojectinhome.model.MovieModel

class MovieAdaper(
    var movieList: List<MovieModel>,
) : RecyclerView.Adapter<MovieAdaper.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val moviesItemBinding: MoviesItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.movies_item,
            parent,
            false
        )
        return MovieViewHolder(moviesItemBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList[position])
//        Picasso.get().load(movieList[position].imageUrl).into(holder.ivImage)

    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    inner class MovieViewHolder(private val binding: MoviesItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        var ivImage: ImageView = binding.root.findViewById(R.id.iv_movie)

        fun bind(movieModel: MovieModel) {
            binding.tvRealName.text = movieModel.publisher
            binding.tvName.text = movieModel.name
            binding.tvTeam.text = movieModel.team
//            Picasso.get().load(movieModel.imageUrl).into(binding.ivMovie)

            binding.executePendingBindings()
        }
    }

}