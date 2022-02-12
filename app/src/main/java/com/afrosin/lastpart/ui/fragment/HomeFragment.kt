package com.afrosin.lastpart.ui.fragment

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.afrosin.lastpart.R
import com.afrosin.lastpart.databinding.FragmentHomeBinding
import com.afrosin.lastpart.mvp.presenter.HomeFragmentPresenter
import com.afrosin.lastpart.mvp.view.HomeFragmentView
import com.afrosin.lastpart.ui.App
import com.afrosin.lastpart.ui.adapter.LessonRVAdapter
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

    private var lessonRVAdapter: LessonRVAdapter? = null

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
        initRecyclerView()
    }

    private fun initRecyclerView() {
        lessonRVAdapter = LessonRVAdapter(presenter.listPresenter)
        binding.rvClasses.run {
            adapter = lessonRVAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }

    override fun setDay1ToExam(text: String) {
        binding.incCounDownTimer.tvDay1ToExam.text = text
    }

    override fun setDay2ToExam(text: String) {
        binding.incCounDownTimer.tvDay2ToExam.text = text
    }

    override fun setHour1ToExam(text: String) {
        binding.incCounDownTimer.tvHour1ToExam.text = text
    }

    override fun setHour2ToExam(text: String) {
        binding.incCounDownTimer.tvHour2ToExam.text = text
    }

    override fun setMinute1ToExam(text: String) {
        binding.incCounDownTimer.tvMinute1ToExam.text = text
    }

    override fun setMinute2ToExam(text: String) {
        binding.incCounDownTimer.tvMinute2ToExam.text = text
    }

    override fun setSecond1ToExam(text: String) {
        binding.incCounDownTimer.tvSecond1ToExam.text = text
    }

    override fun setSecond2ToExam(text: String) {
        binding.incCounDownTimer.tvSecond2ToExam.text = text
    }

    override fun openApp(appName: String, packageName: String?) {
        val contextTmp = requireContext()
        if (isAppInstalled(contextTmp, packageName!!)) {
            if (isAppEnabled(
                    requireContext(),
                    packageName
                )
            ) {
                contextTmp.startActivity(
                    contextTmp.packageManager.getLaunchIntentForPackage(
                        packageName
                    )
                )
            } else {
                Toast.makeText(contextTmp, "$appName app is not enabled.", Toast.LENGTH_SHORT)
                    .show()
            }
        } else {
            Toast.makeText(
                contextTmp,
                "$appName app is not installed.", Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun isAppInstalled(context: Context, packageName: String): Boolean {
        val pm = context.packageManager
        try {
            pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES)
            return true
        } catch (ignored: PackageManager.NameNotFoundException) {
        }
        return false
    }

    private fun isAppEnabled(context: Context, packageName: String): Boolean {
        var appStatus = false
        try {
            val ai: ApplicationInfo = context.getPackageManager().getApplicationInfo(packageName, 0)
            if (ai != null) {
                appStatus = ai.enabled
            }
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return appStatus
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}