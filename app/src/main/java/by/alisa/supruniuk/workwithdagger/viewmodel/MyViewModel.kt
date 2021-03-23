package by.alisa.supruniuk.workwithdagger.viewmodel

import io.reactivex.Observable
import androidx.lifecycle.ViewModel
import by.alisa.supruniuk.workwithdagger.data.ColorsGeneratorInterface
import by.alisa.supruniuk.workwithdagger.data.HeavyData
import by.alisa.supruniuk.workwithdagger.data.NameGenerator
import by.alisa.supruniuk.workwithdagger.data.SomeObject
import dagger.Lazy
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.logging.ErrorManager
import javax.inject.Inject


class MyViewModel @Inject constructor (private val colorsGenerator: ColorsGeneratorInterface, private val heavyData: Lazy<HeavyData>,
                                       private val nameGenerator: NameGenerator): ViewModel() {

    private val observable: Observable<Int> = Observable.create {
        it.onNext((1..5).shuffled().first()) }

    fun getObject(): Observable<SomeObject> {
        return observable.filter{x -> x != 4}
            .subscribeOn(Schedulers.io())
            .observeOn((Schedulers.computation()))
            .map { num -> SomeObject(colorsGenerator.changeColor(num),
                nameGenerator.getNameColor(num))}
            .observeOn(AndroidSchedulers.mainThread())
    }


    fun getData(): Int {
        return heavyData.get().count
    }

}