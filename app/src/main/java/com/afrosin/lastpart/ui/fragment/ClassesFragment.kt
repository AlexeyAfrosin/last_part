package com.afrosin.lastpart.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.afrosin.lastpart.R
import com.afrosin.lastpart.databinding.FragmentClassesBinding
import com.afrosin.lastpart.mvp.presenter.ClassesFragmentPresenter
import com.afrosin.lastpart.mvp.view.ClassesFragmentView
import com.afrosin.lastpart.ui.App
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class ClassesFragment : MvpAppCompatFragment(), ClassesFragmentView {

    companion object {
        fun newInstance() = ClassesFragment()
    }

    @InjectPresenter
    lateinit var presenter: ClassesFragmentPresenter

    @ProvidePresenter
    fun providePresenter() = ClassesFragmentPresenter().apply {
        App.instance.appComponent.inject(this)
    }

    private var _binding: FragmentClassesBinding? = null

    private val binding: FragmentClassesBinding
        get() = checkNotNull(_binding) { getString(R.string.binding_error) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentClassesBinding.inflate(inflater, container, false)
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