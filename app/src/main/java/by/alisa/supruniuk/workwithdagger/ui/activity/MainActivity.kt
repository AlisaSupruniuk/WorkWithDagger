package by.alisa.supruniuk.workwithdagger.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.alisa.supruniuk.workwithdagger.R
import by.alisa.supruniuk.workwithdagger.databinding.ActivityMainBinding
import by.alisa.supruniuk.workwithdagger.ui.fragment_color_name.FragmentTwo
import by.alisa.supruniuk.workwithdagger.ui.fragment_my_name.FragmentThree
import by.alisa.supruniuk.workwithdagger.ui.fragment_with_custom_view.FragmentOne
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity(R.layout.activity_main) {

    lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = viewBinding.root
        setContentView(view)

        viewBinding.navigation.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.squareFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.clNavigation, FragmentOne::class.java, null)
                        .commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.colorNameFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.clNavigation, FragmentTwo::class.java, null)
                        .commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nameFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.clNavigation, FragmentThree::class.java, null)
                        .commit()
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })
    }
}