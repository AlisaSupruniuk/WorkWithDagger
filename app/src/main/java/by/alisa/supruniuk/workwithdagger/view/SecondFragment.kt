package by.alisa.supruniuk.workwithdagger.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import by.alisa.supruniuk.workwithdagger.R
import by.alisa.supruniuk.workwithdagger.viewmodel.SecondViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class SecondFragment : DaggerFragment() {


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

        model = ViewModelProviders.of(this, modelFactory).get(SecondViewModel::class.java)

        val view : View = inflater.inflate(R.layout.fragment_my, container, false)

        val btnGenerate: Button = view.findViewById(R.id.btnGenerate)
        val myView: View = view.findViewById(R.id.myView)
        val btnHeavyDate: Button = view.findViewById(R.id.btnHeavyData)
        val tvHeavyData: TextView = view.findViewById(R.id.tvHeavyData)
        tvHeavyData.text = model.getHeavyDate().toString()

        btnGenerate.setOnClickListener {
            val randomNum : Int = (1..5).shuffled().first()

            myView.setBackgroundColor(model.getColor(randomNum))
            btnGenerate.text = randomNum.toString()
        }

        btnHeavyDate.setOnClickListener {
            tvHeavyData.text = model.getHeavyDate().toString()
        }

        return view
    }
}