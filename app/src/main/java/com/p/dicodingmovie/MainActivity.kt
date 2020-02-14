package com.p.dicodingmovie

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MovieAdapter
    private lateinit var dataTitle: Array<String>
    private lateinit var dataDescription: Array<String>
    private lateinit var dataPoster: TypedArray
    private lateinit var dataRelease: Array<String>
    private lateinit var dataDuration: Array<String>
    private lateinit var dataDistributed: Array<String>
    private var movies = arrayListOf<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView:ListView = findViewById(R.id.lv_movie)

        adapter = MovieAdapter(this)

        listView.adapter = adapter

        prepare()
        addItem()

        listView.onItemClickListener = AdapterView.OnItemClickListener{ _, _, position, _ ->
           val moveWithObjectIntent = Intent(this, DetailMovieActivity::class.java)
            moveWithObjectIntent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movies[position])
            startActivity(moveWithObjectIntent)
            //Toast.makeText(this@MainActivity, movies[position].title, Toast.LENGTH_SHORT).show()
        }
    }

    private fun prepare(){
        dataTitle = resources.getStringArray(R.array.movie_titles)
        dataDescription = resources.getStringArray(R.array.movie_descriptions)
        dataPoster = resources.obtainTypedArray(R.array.movie_posters)
        dataRelease = resources.getStringArray(R.array.movie_releasedate)
        dataDuration = resources.getStringArray(R.array.movie_runningtimes)
        dataDistributed = resources.getStringArray(R.array.movie_distributedby)
    }

    private fun addItem(){
        for (position in dataTitle.indices){
            val movie = Movie(
                dataTitle[position],
                dataDescription[position],
                dataPoster.getResourceId(position, -1),
                dataRelease[position],
                dataDuration[position],
                dataDistributed[position]
            )
            movies.add(movie)
        }
        adapter.movies = movies
    }
}
