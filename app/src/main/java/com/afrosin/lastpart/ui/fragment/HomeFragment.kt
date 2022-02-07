package com.afrosin.lastpart.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.afrosin.lastpart.R
import com.afrosin.lastpart.databinding.FragmentHomeBinding
import com.afrosin.lastpart.mvp.presenter.HomeFragmentPresenter
import com.afrosin.lastpart.mvp.view.HomeFragmentView
import com.afrosin.lastpart.ui.App
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class HomeFragment : MvpAppCompatFragment(), HomeFragmentView {

    companion object {
        fun newInstance() = HomeFragment()
    }

    @InjectPresenter
    lateinit var presenter: HomeFragmentPresenter

    @ProvidePresenter
    fun providePresenter() = HomeFragmentPresenter().apply {
        App.instance.appComponent.inject(this)
    }

    private var _binding: FragmentHomeBinding? = null

    private val binding: FragmentHomeBinding
        get() = checkNotNull(_binding) { getString(R.string.binding_error) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun init() {
//        initListeners()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}