package com.afrosin.lastpart.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.afrosin.lastpart.R
import com.afrosin.lastpart.databinding.FragmentAddPulseDataDialogBinding
import com.afrosin.lastpart.mvp.presenter.AddPulseDataDialogFragmentPresenter
import com.afrosin.lastpart.mvp.view.AddPulseDataFragmentView
import com.afrosin.lastpart.ui.App
import moxy.MvpAppCompatDialogFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class AddPulseDataDialogFragment : MvpAppCompatDialogFragment(), AddPulseDataFragmentView {

    companion object {
        fun newInstance() = AddPulseDataDialogFragment()
    }

    @InjectPresenter
    lateinit var presenter: AddPulseDataDialogFragmentPresenter

    @ProvidePresenter
    fun providePresenter() = AddPulseDataDialogFragmentPresenter().apply {
        App.instance.appComponent.inject(this)
    }

    private var _binding: FragmentAddPulseDataDialogBinding? = null


    private val binding: FragmentAddPulseDataDialogBinding
        get() = checkNotNull(_binding) { getString(R.string.binding_error) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddPulseDataDialogBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    override fun init() {
        initListeners()
    }

    private fun initListeners() {
        with(binding) {
            btCancel.setOnClickListener {
                presenter.btCancelClick()
            }

            btSave.setOnClickListener {
                presenter.saveData(
                    tiTopPressure.text.toString(),
                    tiBottomPressure.text.toString(),
                    tiPulse.text.toString(),
                )
            }
        }
    }

}