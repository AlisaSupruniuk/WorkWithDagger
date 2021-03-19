package by.alisa.supruniuk.workwithdagger.data

import android.content.Context
import androidx.core.content.ContextCompat
import by.alisa.supruniuk.workwithdagger.R
import javax.inject.Inject

class ColorsGeneratorTwo @Inject constructor(private val context : Context): ColorsGeneratorInterface {

    override fun changeColor(colorNum : Int) :Int {

        return when (colorNum) {
            1 -> {
                ContextCompat.getColor(context, R.color.red)
            }
            2 -> {
                ContextCompat.getColor(context, R.color.gray)
            }
            3 -> {
                ContextCompat.getColor(context, R.color.orange)
            }
            4 -> {
                ContextCompat.getColor(context, R.color.brown)
            }
            5 -> {
                ContextCompat.getColor(context, R.color.purple)
            }
            else -> 0
        }

    }
}