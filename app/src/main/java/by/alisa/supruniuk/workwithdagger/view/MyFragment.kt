package by.alisa.supruniuk.workwithdagger.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import by.alisa.supruniuk.workwithdagger.viewmodel.MyViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

import androidx.lifecycle.ViewModelProviders
import by.alisa.supruniuk.workwithdagger.R

class MyFragment : DaggerFragment() {

    @Inject
    lateinit var modelFactory: ViewModelProvider.Factory
    private lateinit var model: MyViewModel



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        model = ViewModelProviders.of(this, modelFactory).get(MyViewModel::class.java)
        val view : View = inflater.inflate(R.layout.fragment_my, container, false)
        val btnGenerate: Button = view.findViewById(R.id.btnGenerate)
        val myView: View = view.findViewById(R.id.myView)
        val btnHeavyDate by lazy {view.findViewById<Button>(R.id.btnHeavyData)}
        val tvHeavyData: TextView = view.findViewById(R.id.tvHeavyData)

        btnGenerate.setOnClickListener {
            val randomNum : Int = (1..5).shuffled().first()

            myView.setBackgroundColor(model.getColor(randomNum))
            btnGenerate.text = randomNum.toString()
        }

        btnHeavyDate.setOnClickListener {
            tvHeavyData.text = model.getData().toString()
        }

        return view
    }


}