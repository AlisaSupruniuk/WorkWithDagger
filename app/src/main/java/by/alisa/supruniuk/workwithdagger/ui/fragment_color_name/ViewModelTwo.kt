package by.alisa.supruniuk.workwithdagger.ui.fragment_color_name

import androidx.lifecycle.ViewModel
import by.alisa.supruniuk.workwithdagger.data.ColorNameGenerator
import io.reactivex.Observable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class ViewModelTwo @Inject constructor(private val nameGenerator: ColorNameGenerator): ViewModel() {

    fun getColorName(): Observable<String> {

        val observable: Observable<Int> = Observable.create{
            it.onNext((1..5).shuffled().first())
        }
        return observable.delay(2, TimeUnit.SECONDS)
            .map{
                nameGenerator.getNameColor(it)}
    }
}