package by.alisa.supruniuk.workwithdagger.ui.fragment_with_custom_view

import android.content.Context
import androidx.core.content.ContextCompat
import by.alisa.supruniuk.workwithdagger.R
import by.alisa.supruniuk.workwithdagger.data.ColorsGeneratorInterface
import javax.inject.Inject

class ColorsGeneratorOne @Inject constructor(private val context : Context):
    ColorsGeneratorInterface {

    override fun changeColor(colorNum : Int) :Int {

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