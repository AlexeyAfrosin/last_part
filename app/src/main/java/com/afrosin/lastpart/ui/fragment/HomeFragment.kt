package com.afrosin.lastpart.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.afrosin.lastpart.R
import com.afrosin.lastpart.databinding.FragmentHomeBinding
import com.afrosin.lastpart.mvp.presenter.HomeFragmentPresenter
import com.afrosin.lastpart.mvp.view.HomeFragmentView
import com.afrosin.lastpart.ui.App
import com.afrosin.lastpart.ui.adapter.HomeworkRVAdapter
import com.afrosin.lastpart.ui.adapter.LessonRVAdapter
import com.afrosin.lastpart.utils.openInApp
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
    private var homeworkRVAdapter: HomeworkRVAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun init() {
        initLessonRecyclerView()
        initHomeworkRecyclerView()
    }

    private fun initLessonRecyclerView() {
        lessonRVAdapter = LessonRVAdapter(presenter.lessonPresenter)
        binding.rvLessons.run {
            adapter = lessonRVAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun initHomeworkRecyclerView() {
        homeworkRVAdapter = HomeworkRVAdapter(presenter.homeworkPresenter)
        binding.rvHomework.run {
            adapter = homeworkRVAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }

    override fun scrollRvLesson(position: Int) {
        binding.rvLessons.scrollToPosition(position)
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
        requireContext().openInApp(appName, packageName)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}