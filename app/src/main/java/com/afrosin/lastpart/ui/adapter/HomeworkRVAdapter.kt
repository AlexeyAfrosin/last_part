package com.afrosin.lastpart.ui.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.afrosin.lastpart.R
import com.afrosin.lastpart.mvp.presenter.adapter.HomeworkRVListPresenter
import com.afrosin.lastpart.mvp.resource.ResourceProvider
import com.afrosin.lastpart.mvp.view.item.HomeworkItemView
import com.afrosin.lastpart.ui.App
import com.github.terrakok.cicerone.Router
import kotlinx.android.synthetic.main.homework_item.view.*
import javax.inject.Inject

class HomeworkRVAdapter(val presenter: HomeworkRVListPresenter) :
    RecyclerView.Adapter<HomeworkRVAdapter.HomeworkViewHolder>() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var resourceProvider: ResourceProvider

    init {
        App.instance.appComponent.inject(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HomeworkViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.homework_item, parent, false
        )
    )

    override fun onBindViewHolder(holder: HomeworkViewHolder, position: Int) {
        holder.pos = position
        presenter.bind(holder)
    }

    override fun getItemCount(): Int = presenter.getCount()

    inner class HomeworkViewHolder(view: View) : RecyclerView.ViewHolder(view),
        HomeworkItemView {

        override var pos: Int = -1

        override fun setHomeworkName(text: String) {
            itemView.tv_homework_name.text = text
        }

        override fun setHomeworkDeadlineDate(text: String) {
            itemView.tv_homework_deadline_date.text = text
        }

        override fun setHomeworkDescription(text: String) {
            itemView.tv_homework_description.text = text
        }
    }


}