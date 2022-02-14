package com.afrosin.lastpart.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.afrosin.lastpart.R
import com.afrosin.lastpart.mvp.presenter.adapter.PostRVListPresenter
import com.afrosin.lastpart.mvp.resource.ResourceProvider
import com.afrosin.lastpart.mvp.view.PostItemView
import com.afrosin.lastpart.ui.App
import com.github.terrakok.cicerone.Router
import kotlinx.android.synthetic.main.post_item.view.*
import javax.inject.Inject

class PostRVAdapter(val presenter: PostRVListPresenter) :
    RecyclerView.Adapter<PostRVAdapter.PostViewHolder>() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var resourceProvider: ResourceProvider

    init {
        App.instance.appComponent.inject(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PostViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.post_item, parent, false
        )
    )

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.pos = position
        presenter.bind(holder)
    }


    override fun getItemCount(): Int = presenter.getCount()

    inner class PostViewHolder(view: View) : RecyclerView.ViewHolder(view),
        PostItemView {

        override var pos: Int = -1

        override fun setPostText(text: String) {
            itemView.tv_post_text.text = text
        }
    }


}