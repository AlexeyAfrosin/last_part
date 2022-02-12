package com.afrosin.lastpart.ui.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.afrosin.lastpart.R
import com.afrosin.lastpart.mvp.presenter.adapter.LessonRVListPresenter
import com.afrosin.lastpart.mvp.resource.ResourceProvider
import com.afrosin.lastpart.mvp.view.item.LessonItemView
import com.afrosin.lastpart.ui.App
import com.github.terrakok.cicerone.Router
import kotlinx.android.synthetic.main.lesson_item.view.*
import javax.inject.Inject

class LessonRVAdapter(val presenter: LessonRVListPresenter) :
    RecyclerView.Adapter<LessonRVAdapter.LessonViewHolder>() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var resourceProvider: ResourceProvider

    init {
        App.instance.appComponent.inject(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = LessonViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.lesson_item, parent, false
        )
    )

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        holder.pos = position
        presenter.bind(holder)
        initListeners(holder)
    }

    private fun initListeners(holder: LessonViewHolder) {
        holder.itemView.iv_open_in.setOnClickListener {
            presenter.openSkype(holder)
        }
    }

    override fun getItemCount(): Int = presenter.getCount()

    inner class LessonViewHolder(view: View) : RecyclerView.ViewHolder(view),
        LessonItemView {

        override var pos: Int = -1

        override fun setLessonName(text: String) {
            itemView.tv_lesson_name.text = text
        }

        override fun setLessonDate(text: String) {
            itemView.tv_lesson_date.text = text
        }

        override fun setLessonOpenInShow() {
            itemView.iv_open_in.visibility = View.VISIBLE
        }

        override fun setLessonOpenInHide() {
            itemView.iv_open_in.visibility = View.GONE
        }
    }


}