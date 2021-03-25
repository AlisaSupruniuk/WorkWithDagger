package by.alisa.supruniuk.workwithdagger.ui.fragment_one

import io.reactivex.Observable
import androidx.lifecycle.ViewModel
import by.alisa.supruniuk.workwithdagger.data.Color
import by.alisa.supruniuk.workwithdagger.data.ColorsGeneratorInterface
import by.alisa.supruniuk.workwithdagger.data.ColorNameGenerator
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.lang.Exception
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class ViewModelOne @Inject constructor (private val colorsGenerator: ColorsGeneratorInterface,
                                        private val nameGenerator: ColorNameGenerator): ViewModel() {

    private val observable: Observable<Int> = Observable.create {
        o -> o.onNext((1..5).shuffled().first())
        o.onComplete()}

    fun getObject(): Observable<Color> {

        return observable
            .delay(2, TimeUnit.SECONDS)
            .filter{ x -> x != 4}
            .switchIfEmpty(Observable.error(Exception("Oops...")))
            .subscribeOn(Schedulers.io())
            .observeOn((Schedulers.computation()))
            .map { num -> Color(colorsGenerator.changeColor(num),
                nameGenerator.getNameColor(num))}
            .observeOn(AndroidSchedulers.mainThread())
    }
}