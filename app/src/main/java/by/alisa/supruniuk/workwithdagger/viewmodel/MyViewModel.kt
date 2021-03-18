package by.alisa.supruniuk.workwithdagger.viewmodel

import androidx.lifecycle.ViewModel
import by.alisa.supruniuk.workwithdagger.ColorsGenerator
import javax.inject.Inject

class MyViewModel @Inject constructor ( private val colorsGenerator: ColorsGenerator): ViewModel()  {

    fun getColor(colorNum: Int): Int{
        return colorsGenerator.changeColor(colorNum)
    }
}