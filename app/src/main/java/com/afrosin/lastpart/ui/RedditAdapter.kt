package com.afrosin.lastpart.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.afrosin.lastpart.R
import com.afrosin.lastpart.models.RedditPost
import com.afrosin.lastpart.utils.DiffUtilCallBack
import kotlinx.android.synthetic.main.adapter_row.view.*

class RedditAdapter :
    PagingDataAdapter<RedditPost, RedditAdapter.RedditViewHolder>(DiffUtilCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RedditViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_row, parent, false)
        return RedditViewHolder(view)
    }

    override fun onBindViewHolder(holder: RedditViewHolder, position: Int) {
        getItem(position)?.let { holder.bindPost(it) }
    }

    class RedditViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleText: TextView = itemView.tv_post_text

        fun bindPost(redditPost: RedditPost) {
            with(redditPost) {
                titleText.text = title
            }
        }
    }
}