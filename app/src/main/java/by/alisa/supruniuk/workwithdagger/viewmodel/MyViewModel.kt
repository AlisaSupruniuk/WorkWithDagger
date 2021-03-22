package by.alisa.supruniuk.workwithdagger.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import io.reactivex.Observable
import kotlinx.android.synthetic.main.fragment_my.*
import androidx.lifecycle.ViewModel
import by.alisa.supruniuk.workwithdagger.data.ColorsGeneratorInterface
import by.alisa.supruniuk.workwithdagger.data.HeavyData
import dagger.Lazy
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Flow
import javax.inject.Inject


class MyViewModel @Inject constructor ( private val colorsGenerator: ColorsGeneratorInterface, val heavyData: Lazy<HeavyData>): ViewModel()  {

    fun getData(): Int{
        return heavyData.get().count
    }

    fun getColor(): Observable<Int>{

        var observable: Observable<Int> = Observable.create{
            it.onNext((1..5).shuffled().first())
        }
            return observable.map{
            colorsGenerator.changeColor(it)
        }
    }

}