package com.example.flix

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.flix.R.drawable.ic_launcher_background
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

const val MOVIE_EXTRA = "MOVIE_EXTRA"
private const val TAG = "MovieAdapter"

class MovieAdapter(private val context: Context, private val movies: List<Movie>)
    : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {


    // Expensive operation: create a view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.i(TAG, "onCreateViewHolder")
        val view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    // given the viewholder and position, take the data at that position and bind it into that viewholder
    // cheap: simply bind data to an existing viewholder.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i(TAG, "onBindViewHolder position $position")
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount() = movies.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val ivPoster = itemView.findViewById<ImageView>(R.id.ivPoster)
        private val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        private val tvOverview = itemView.findViewById<TextView>(R.id.tvOverview)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(movie: Movie) {
            tvTitle.text = movie.title
            tvOverview.text = movie.overview
            val imageUrl: String
            if (context.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT ) {
                imageUrl = movie.posterImageUrl
            }
            else {
                imageUrl = movie.backdropImageUrl
            }
            val radius = 20
            val margin = 10
            Glide.with(context).load(imageUrl).centerCrop().transform(RoundedCornersTransformation(radius, margin)) .placeholder(R.drawable.ic_loading_foreground).into(ivPoster)
//            Glide.with(context).load(imageUrl).placeholder(R.drawable.ic_loading_foreground).into(ivPoster)

        }

        override fun onClick(p0: View?) {
            // 1. Get notified of the particular movie which was clicked
            val movie = movies[adapterPosition]
//            Toast.makeText(context, movie.title, Toast.LENGTH_SHORT).show()

            // 2. Use the intent system to navigate to the new activity
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(MOVIE_EXTRA, movie)
            context.startActivity(intent)

        }
    }
}
