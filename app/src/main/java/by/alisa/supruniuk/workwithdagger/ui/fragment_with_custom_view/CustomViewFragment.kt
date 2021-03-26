package by.alisa.supruniuk.workwithdagger.ui.fragment_with_custom_view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import javax.inject.Inject
import by.alisa.supruniuk.workwithdagger.R
import by.alisa.supruniuk.workwithdagger.databinding.FragmentMyBinding

class CustomViewFragment : DaggerFragment(R.layout.fragment_my) {

    private var _viewBinding: FragmentMyBinding? = null
    private val viewBinding get() = _viewBinding!!

    @Inject
    lateinit var modelFactory: ViewModelProvider.Factory
    private lateinit var model: ViewModelCustomViewFragment

    @SuppressLint("FragmentLiveDataObserve")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _viewBinding = FragmentMyBinding.inflate(inflater, container, false)
        val view = viewBinding.root

        model = ViewModelProvider(this, modelFactory).get(ViewModelCustomViewFragment::class.java)

        viewBinding.pb.visibility = ProgressBar.GONE

        viewBinding.btnGenerate.setOnClickListener {

            viewBinding.pb.visibility = ProgressBar.VISIBLE

            model.getObject().subscribe(
                { onNext ->
                    viewBinding.pb.visibility = ProgressBar.GONE
                    viewBinding.myCustomView.colorNum = onNext.colorNum
                    viewBinding.myCustomView.colorName = onNext.colorName
                },
                {
                    viewBinding.pb.visibility = ProgressBar.GONE
                    viewBinding.myCustomView.colorName = "Oops.."
                },
                {

                })
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
    }
}