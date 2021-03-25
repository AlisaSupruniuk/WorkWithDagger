package by.alisa.supruniuk.workwithdagger.ui.fragment_three

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.alisa.supruniuk.workwithdagger.R
import by.alisa.supruniuk.workwithdagger.databinding.FragmentThreeBinding
import dagger.android.support.DaggerFragment

class FragmentThree : DaggerFragment(R.layout.fragment_three) {

    private var _viewBinding: FragmentThreeBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewBinding = FragmentThreeBinding.inflate(inflater, container, false)
        val view = viewBinding.root

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
    }

}