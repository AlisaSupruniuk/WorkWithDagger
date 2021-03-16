package by.alisa.supruniuk.workwithdagger

import android.content.Context
import androidx.core.content.ContextCompat
import javax.inject.Inject

class ColorsGenerator @Inject constructor(private val context : Context) {

    fun changeColor(colorNum : Int) :Int {

        return when (colorNum) {
            1 -> {
                 ContextCompat.getColor(context, R.color.black)
            }
            2 -> {
                 ContextCompat.getColor(context, R.color.white)
            }
            3 -> {
                 ContextCompat.getColor(context, R.color.yellow)
            }
            4 -> {
                 ContextCompat.getColor(context, R.color.green)
            }
            5 -> {
                 ContextCompat.getColor(context, R.color.blue)
            }
            else -> 0
        }

    }
}

