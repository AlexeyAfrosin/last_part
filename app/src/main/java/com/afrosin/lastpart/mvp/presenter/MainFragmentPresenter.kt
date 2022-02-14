package com.afrosin.lastpart.mvp.presenter

import com.afrosin.lastpart.mvp.model.Post
import com.afrosin.lastpart.mvp.presenter.adapter.PostRVListPresenter
import com.afrosin.lastpart.mvp.view.MainFragmentView
import com.afrosin.lastpart.mvp.view.PostItemView
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class MainFragmentPresenter : MvpPresenter<MainFragmentView>() {

    val listPresenter = LocalPostRVListPresenter()

    inner class LocalPostRVListPresenter : PostRVListPresenter {
        private val postList = mutableListOf<Post>()


        override fun getCount(): Int = postList.size

        override fun bind(view: PostItemView) {
            initView(view, getPost(view.pos))
        }

        private fun getPost(pos: Int): Post = postList[pos]


        private fun initView(view: PostItemView, post: Post) {
            with(view) {


            }
        }
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }

}