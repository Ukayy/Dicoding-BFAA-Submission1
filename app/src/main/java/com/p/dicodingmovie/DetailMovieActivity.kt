package com.p.dicodingmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail_movie.*
import kotlinx.android.synthetic.main.activity_detail_movie.tv_movie_title

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_person"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        val movie = intent.getParcelableExtra(EXTRA_MOVIE) as Movie

        tv_movie_title.text = movie.title
        tv_movie_description.text = movie.description
        tv_movie_distributedby.text = movie.distributedBy
        tv_movie_durationtime.text = movie.durationTime
        tv_movie_releasedate.text = movie.releaseDate
        iv_movie_poster.setImageResource(movie.poster)

    }
}
