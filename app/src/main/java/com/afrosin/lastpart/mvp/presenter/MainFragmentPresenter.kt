package com.afrosin.lastpart.mvp.presenter

import com.afrosin.lastpart.mvp.model.HotPost
import com.afrosin.lastpart.mvp.presenter.adapter.PostRVListPresenter
import com.afrosin.lastpart.mvp.repo.ApiRepo
import com.afrosin.lastpart.mvp.view.MainFragmentView
import com.afrosin.lastpart.mvp.view.PostItemView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class MainFragmentPresenter : MvpPresenter<MainFragmentView>() {


    @Inject
    lateinit var apiRepo: ApiRepo

    val listPresenter = LocalPostRVListPresenter()

    inner class LocalPostRVListPresenter : PostRVListPresenter {
        val postList = mutableListOf<HotPost>()

        override fun getCount(): Int = postList.size

        override fun bind(view: PostItemView) {
            initView(view, getPost(view.pos))
        }

        private fun getPost(pos: Int): HotPost = postList[pos]


        private fun initView(view: PostItemView, post: HotPost) {
            with(view) {
                setPostText(post.title)
            }
        }
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        getHotPost(1, "")
    }

    private fun getHotPost(count: Int, after: String) {
        apiRepo
            .getHotPosts(count, after)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ hotPostListing ->
                val posts = hotPostListing.postContainer.map { it.data }
                listPresenter.postList.addAll(posts)
                viewState.updateAdapter()

            }, {
                it.printStackTrace()
            })
    }

}