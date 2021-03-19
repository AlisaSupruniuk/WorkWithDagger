package by.alisa.supruniuk.workwithdagger.viewmodel

import androidx.lifecycle.ViewModel
import by.alisa.supruniuk.workwithdagger.data.ColorsGeneratorInterface
import by.alisa.supruniuk.workwithdagger.data.ColorsGeneratorTwo
import by.alisa.supruniuk.workwithdagger.data.HeavyData
import javax.inject.Inject

class SecondViewModel @Inject constructor(private val colorsGenerator: ColorsGeneratorInterface, private val heavyData: HeavyData): ViewModel() {

    fun getColor(colorNum: Int): Int{
        return colorsGenerator.changeColor(colorNum)
    }

    fun getHeavyDate(): Int{
        return heavyData.count
    }
}