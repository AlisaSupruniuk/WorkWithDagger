package by.alisa.supruniuk.workwithdagger.viewmodel

import androidx.lifecycle.ViewModel
import by.alisa.supruniuk.workwithdagger.data.ColorsGeneratorInterface
import by.alisa.supruniuk.workwithdagger.data.HeavyData
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Provider

class SecondViewModel @Inject constructor(private val colorsGenerator: ColorsGeneratorInterface, private val heavyData: Provider<HeavyData>): ViewModel() {

    fun getColor(): Observable<Int> {

        var observable: Observable<Int> = Observable.create{
            it.onNext((1..5).shuffled().first())
        }
        return observable.map{
            colorsGenerator.changeColor(it)
        }
    }

    fun getHeavyDate(): Int{
        return heavyData.get().count
    }
}