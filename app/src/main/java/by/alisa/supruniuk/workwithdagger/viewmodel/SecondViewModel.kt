package by.alisa.supruniuk.workwithdagger.viewmodel

import androidx.lifecycle.ViewModel
import by.alisa.supruniuk.workwithdagger.data.ColorsGeneratorInterface
import by.alisa.supruniuk.workwithdagger.data.HeavyData
import javax.inject.Inject
import javax.inject.Provider

class SecondViewModel @Inject constructor(private val colorsGenerator: ColorsGeneratorInterface, private val heavyData: Provider<HeavyData>): ViewModel() {

    fun getColor(colorNum: Int): Int{
        return colorsGenerator.changeColor(colorNum)
    }

    fun getHeavyDate(): Int{
        return heavyData.get().count
    }
}