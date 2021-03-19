package by.alisa.supruniuk.workwithdagger.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.alisa.supruniuk.workwithdagger.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        //AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}