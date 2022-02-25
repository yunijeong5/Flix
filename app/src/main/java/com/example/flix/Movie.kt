package com.example.flix

import org.json.JSONArray

// purpose: display one movie info in ui

data class Movie (
    val movieID: Int,
    private val posterPath: String,
    private val backdropPath: String,
    val title: String,
    val overview: String,
) {
    val posterImageUrl = "https://image.tmdb.org/t/p/w342$posterPath"
    val backdropImageUrl = "https://image.tmdb.org/t/p/w342$backdropPath"
    companion object {
        // companion objects allows us to call methods on Movie class
        // without having an instance.

        fun fromJsonArray(movieJsonArray: JSONArray): List<Movie> {
            val movies = mutableListOf<Movie>()
            for (i in 0 until movieJsonArray.length()) {
                val movieJson = movieJsonArray.getJSONObject(i)
                movies.add(
                    Movie(
                        movieJson.getInt("id"),
                        movieJson.getString("poster_path"),
                        movieJson.getString("backdrop_path"),
                        movieJson.getString("title"),
                        movieJson.getString("overview")
                    )
                )
            }
            return movies
        }
    }
}