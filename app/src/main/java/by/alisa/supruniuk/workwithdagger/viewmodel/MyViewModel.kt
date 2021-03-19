package by.alisa.supruniuk.workwithdagger.viewmodel

import androidx.lifecycle.ViewModel
import by.alisa.supruniuk.workwithdagger.data.ColorsGeneratorOne
import by.alisa.supruniuk.workwithdagger.data.HeavyData
import dagger.Lazy
import javax.inject.Inject

class MyViewModel @Inject constructor ( private val colorsGenerator: ColorsGeneratorOne, val heavyData: Lazy<HeavyData>): ViewModel()  {


    fun getColor(colorNum: Int): Int{
        return colorsGenerator.changeColor(colorNum)
    }

    fun getData(): Int{

        return heavyData.get().count
    }
}