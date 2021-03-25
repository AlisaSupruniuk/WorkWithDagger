package by.alisa.supruniuk.workwithdagger.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProvider
import by.alisa.supruniuk.workwithdagger.viewmodel.MyViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject
import by.alisa.supruniuk.workwithdagger.R
import by.alisa.supruniuk.workwithdagger.databinding.FragmentMyBinding
import by.alisa.supruniuk.workwithdagger.view.customview.MyCustomView

class MyFragment : DaggerFragment(R.layout.fragment_my) {

    private var _viewBinding: FragmentMyBinding? = null
    private val viewBinding get() = _viewBinding!!

    @Inject
    lateinit var modelFactory: ViewModelProvider.Factory
    private lateinit var model: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _viewBinding = FragmentMyBinding.inflate(inflater, container, false)
        val view = viewBinding.root

        model = ViewModelProvider(this, modelFactory).get(MyViewModel::class.java)

        val btnHeavyDate by lazy {view.findViewById<Button>(R.id.btnHeavyData)}

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
        btnHeavyDate.setOnClickListener {
            viewBinding.tvHeavyData.text = model.getData().toString()
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
    }


}