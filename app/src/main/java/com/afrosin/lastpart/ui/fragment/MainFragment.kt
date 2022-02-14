package com.afrosin.lastpart.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.afrosin.lastpart.R
import com.afrosin.lastpart.databinding.FragmentMainBinding
import com.afrosin.lastpart.mvp.presenter.MainFragmentPresenter
import com.afrosin.lastpart.mvp.view.MainFragmentView
import com.afrosin.lastpart.ui.App
import com.afrosin.lastpart.ui.adapter.PostRVAdapter
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class MainFragment : MvpAppCompatFragment(), MainFragmentView {

    companion object {
        fun newInstance() = MainFragment()
    }

    @InjectPresenter
    lateinit var presenter: MainFragmentPresenter

    @ProvidePresenter
    fun providePresenter() = MainFragmentPresenter().apply {
        App.instance.appComponent.inject(this)
    }

    private var _binding: FragmentMainBinding? = null

    private val binding: FragmentMainBinding
        get() = checkNotNull(_binding) { getString(R.string.binding_error) }

    private var postRVAdapter: PostRVAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun init() {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        postRVAdapter = PostRVAdapter(presenter.listPresenter)
        binding.rvPosts.run {
            adapter = postRVAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}