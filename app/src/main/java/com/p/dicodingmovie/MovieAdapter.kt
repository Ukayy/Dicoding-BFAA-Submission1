package com.p.dicodingmovie

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class MovieAdapter internal constructor(private  val context: Context):BaseAdapter(){

    internal  var movies = arrayListOf<Movie>()

    override fun getItem(i: Int): Any = movies[i]

    override fun getItemId(i: Int): Long = i.toLong()

    override fun getCount(): Int = movies.size

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View? {
        var itemView = view
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_list, viewGroup,false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val movie = getItem(position) as Movie
        viewHolder.bind(movie)
        return itemView
    }
    private inner class ViewHolder internal constructor(view: View) {
        private val dataTitle: TextView = view.findViewById(R.id.tv_movie_title)
        private val dataDuration: TextView = view.findViewById(R.id.tv_movie_durationtime)
        private val dataPoster: ImageView = view.findViewById(R.id.iv_movie_poster)

        internal fun bind(movie: Movie) {
            dataTitle.text = movie.title
            dataDuration.text = movie.durationTime
            dataPoster.setImageResource(movie.poster)
        }
    }
}