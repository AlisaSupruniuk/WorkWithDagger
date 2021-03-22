package by.alisa.supruniuk.workwithdagger.viewmodel

import io.reactivex.Observable
import androidx.lifecycle.ViewModel
import by.alisa.supruniuk.workwithdagger.data.ColorsGeneratorInterface
import by.alisa.supruniuk.workwithdagger.data.HeavyData
import dagger.Lazy
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class MyViewModel @Inject constructor ( private val colorsGenerator: ColorsGeneratorInterface, val heavyData: Lazy<HeavyData>): ViewModel()  {

    fun getData(): Int{
        return heavyData.get().count
    }

    fun getColor(): Observable<Int>{

        val observable: Observable<Int> = Observable.create{
            it.onNext((1..5).shuffled().first())
        }
            return observable.map{
            colorsGenerator.changeColor(it)
        }
    }

}