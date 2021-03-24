package by.alisa.supruniuk.workwithdagger.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import by.alisa.supruniuk.workwithdagger.viewmodel.MyViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject
import by.alisa.supruniuk.workwithdagger.R
import java.util.concurrent.TimeUnit
import kotlin.time.toDuration

class MyFragment : DaggerFragment() {

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

        model = ViewModelProvider(this, modelFactory).get(MyViewModel::class.java)
        val view : View = inflater.inflate(R.layout.fragment_my, container, false)
        val btnGenerate: Button = view.findViewById(R.id.btnGenerate)
        val myView: View = view.findViewById(R.id.myView)
        val btnHeavyDate by lazy {view.findViewById<Button>(R.id.btnHeavyData)}
        val tvHeavyData: TextView = view.findViewById(R.id.tvHeavyData)
        val tvNameColor: TextView = view.findViewById(R.id.tvNameColor)
        val pb: ProgressBar = view.findViewById(R.id.pb)
        pb.visibility = ProgressBar.GONE

        btnGenerate.setOnClickListener {

            pb.visibility = ProgressBar.VISIBLE

            model.getObject().subscribe() {
                if (it != null) {
                    pb.visibility = ProgressBar.GONE
                    myView.setBackgroundColor(it.colorNum)
                    tvNameColor.text = it.colorName
                }
            }
        }

        btnHeavyDate.setOnClickListener {
            tvHeavyData.text = model.getData().toString()
        }

        return view
    }


}