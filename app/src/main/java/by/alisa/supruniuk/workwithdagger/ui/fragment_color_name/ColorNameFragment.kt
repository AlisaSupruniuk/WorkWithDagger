package by.alisa.supruniuk.workwithdagger.ui.fragment_color_name

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProvider
import by.alisa.supruniuk.workwithdagger.R
import by.alisa.supruniuk.workwithdagger.databinding.FragmentMyBinding
import dagger.android.support.DaggerFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class ColorNameFragment : DaggerFragment(R.layout.fragment_my) {

    private var _viewBinding: FragmentMyBinding? = null
    private val viewBinding get() = _viewBinding!!

    @Inject
    lateinit var modelFactory: ViewModelProvider.Factory
    private lateinit var model: ViewModelColorNameFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        model = ViewModelProvider(this, modelFactory).get(ViewModelColorNameFragment::class.java)

        _viewBinding = FragmentMyBinding.inflate(inflater, container, false)
        val view = viewBinding.root

        viewBinding.pb.visibility = ProgressBar.GONE

        viewBinding.btnGenerate.setOnClickListener {
            viewBinding.pb.visibility = ProgressBar.VISIBLE
            model.getColorName().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
                    {
                    onNext ->
                        viewBinding.pb.visibility = ProgressBar.GONE
                        viewBinding.myCustomView.colorName = onNext
                    }
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
    }
}