package by.alisa.supruniuk.workwithdagger.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProvider
import by.alisa.supruniuk.workwithdagger.R
import by.alisa.supruniuk.workwithdagger.databinding.FragmentMyBinding
import by.alisa.supruniuk.workwithdagger.viewmodel.SecondViewModel
import dagger.android.support.DaggerFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class SecondFragment : DaggerFragment(R.layout.fragment_my) {

    private var _viewBinding: FragmentMyBinding? = null
    private val viewBinding get() = _viewBinding!!

    @Inject
    lateinit var modelFactory: ViewModelProvider.Factory
    private lateinit var model: SecondViewModel


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        model = ViewModelProvider(this, modelFactory).get(SecondViewModel::class.java)

        _viewBinding = FragmentMyBinding.inflate(inflater, container, false)
        val view = viewBinding.root

        viewBinding.tvHeavyData.text = model.getHeavyDate().toString()
        viewBinding.pb.visibility = ProgressBar.GONE

        viewBinding.btnGenerate.setOnClickListener {
            model.getColor().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(){
                    onNext -> viewBinding.myCustomView.setBackgroundColor(onNext)}
        }

        viewBinding.btnHeavyData.setOnClickListener {
            viewBinding.tvHeavyData.text = model.getHeavyDate().toString()
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
    }
}