package by.alisa.supruniuk.workwithdagger.ui.fragment_my_name

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import by.alisa.supruniuk.workwithdagger.R
import by.alisa.supruniuk.workwithdagger.databinding.FragmentThreeBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class UserNameFragment : DaggerFragment(R.layout.fragment_three) {

    private var _viewBinding: FragmentThreeBinding? = null
    private val viewBinding get() = _viewBinding

    @Inject
    lateinit var modelFactory: ViewModelProvider.Factory
    private lateinit var model: ViewModelUserNameFragment

    @SuppressLint("CheckResult")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        model = ViewModelProvider(this, modelFactory).get(ViewModelUserNameFragment::class.java)
        _viewBinding = FragmentThreeBinding.inflate(inflater, container, false)
        val view = viewBinding?.root
        model.getUserName().subscribe() { onNext ->

            viewBinding?.tvMyName?.text = onNext
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
    }

}