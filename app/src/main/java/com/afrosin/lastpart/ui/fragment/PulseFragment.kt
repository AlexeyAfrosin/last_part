package com.afrosin.lastpart.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.afrosin.lastpart.R
import com.afrosin.lastpart.databinding.FragmentPulseBinding
import com.afrosin.lastpart.mvp.presenter.PulseFragmentPresenter
import com.afrosin.lastpart.mvp.view.PulseFragmentView
import com.afrosin.lastpart.ui.App
import com.afrosin.lastpart.ui.adapter.PulseRVAdapter
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class PulseFragment : MvpAppCompatFragment(), PulseFragmentView {

    companion object {
        fun newInstance() = PulseFragment()
    }

    @InjectPresenter
    lateinit var presenter: PulseFragmentPresenter

    @ProvidePresenter
    fun providePresenter() = PulseFragmentPresenter().apply {
        App.instance.appComponent.inject(this)
    }

    private var _binding: FragmentPulseBinding? = null

    private var pulseRVAdapter: PulseRVAdapter? = null

    private val binding: FragmentPulseBinding
        get() = checkNotNull(_binding) { getString(R.string.binding_error) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPulseBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    override fun init() {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        pulseRVAdapter = PulseRVAdapter(presenter.listPresenter)
        binding.rvPulse.run {
            adapter = pulseRVAdapter
            layoutManager =
                LinearLayoutManager(requireContext())
        }
    }
}