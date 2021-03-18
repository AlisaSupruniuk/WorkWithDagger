package by.alisa.supruniuk.workwithdagger

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import by.alisa.supruniuk.workwithdagger.viewmodel.MyViewModel
import dagger.android.AndroidInjection
import dagger.android.HasAndroidInjector
import dagger.android.support.DaggerFragment
import javax.inject.Inject

import androidx.lifecycle.ViewModelProviders

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

       // MyApplication.appComponent.injectsMainActivity(this)


        btnGenerate.setOnClickListener {
            val randomNum : Int = (1..5).shuffled().first()

            myView.setBackgroundColor(model.getColor(randomNum))
            btnGenerate.text = randomNum.toString()
        }

        return view
    }


}