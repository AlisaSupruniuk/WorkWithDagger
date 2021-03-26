package by.alisa.supruniuk.workwithdagger.ui.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import by.alisa.supruniuk.workwithdagger.R
import by.alisa.supruniuk.workwithdagger.databinding.ActivityMainBinding
import by.alisa.supruniuk.workwithdagger.ui.fragment_color_name.ColorNameFragment
import by.alisa.supruniuk.workwithdagger.ui.fragment_my_name.UserNameFragment
import by.alisa.supruniuk.workwithdagger.ui.fragment_with_custom_view.CustomViewFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity(R.layout.activity_main) {

    lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = viewBinding.root
        setContentView(view)

        supportFragmentManager.beginTransaction()
            .replace(R.id.clNavigation, CustomViewFragment::class.java, null)
            .commit()

        viewBinding.navigation.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.squareFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.clNavigation, CustomViewFragment::class.java, null)
                        .commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.colorNameFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.clNavigation, ColorNameFragment::class.java, null)
                        .commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nameFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.clNavigation, UserNameFragment::class.java, null)
                        .commit()
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflate: MenuInflater = menuInflater
        menuInflater.inflate(R.menu.menu_item, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.getItemId()
                when (id) {
            R.id.my_theme -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                return true
            }
            R.id.app_theme -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}