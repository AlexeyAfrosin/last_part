package com.afrosin.lastpart.ui.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.afrosin.lastpart.R
import com.afrosin.lastpart.mvp.presenter.adapter.PulseRVListPresenter
import com.afrosin.lastpart.mvp.resource.ResourceProvider
import com.afrosin.lastpart.mvp.view.item.PulseItemView
import com.afrosin.lastpart.ui.App
import com.github.terrakok.cicerone.Router
import kotlinx.android.synthetic.main.pulse_item.view.*
import javax.inject.Inject

class PulseRVAdapter(val presenter: PulseRVListPresenter) :
    RecyclerView.Adapter<PulseRVAdapter.PulseViewHolder>() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var resourceProvider: ResourceProvider

    init {
        App.instance.appComponent.inject(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PulseViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.pulse_item, parent, false
        )
    )

    override fun onBindViewHolder(holder: PulseViewHolder, position: Int) {
        holder.pos = position
        presenter.bind(holder)
    }

    override fun getItemCount(): Int = presenter.getCount()

    inner class PulseViewHolder(view: View) : RecyclerView.ViewHolder(view),
        PulseItemView {

        override var pos: Int = -1

        override fun setDateCreated(text: String) {
            itemView.tv_date_created.text = text
        }

        override fun setTopPressure(text: String) {
            itemView.tv_top_pressure.text = text
        }

        override fun setBottomPressure(text: String) {
            itemView.tv_bottom_pressure.text = text
        }

        override fun setPulse(text: String) {
            itemView.tv_pulse.text = text
        }

    }


}