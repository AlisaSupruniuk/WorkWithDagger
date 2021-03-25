package by.alisa.supruniuk.workwithdagger.ui.fragment_two

import androidx.lifecycle.ViewModel
import by.alisa.supruniuk.workwithdagger.data.ColorsGeneratorInterface
import io.reactivex.Observable
import javax.inject.Inject

class ViewModelTwo @Inject constructor(private val colorsGenerator: ColorsGeneratorInterface): ViewModel() {

    fun getColor(): Observable<Int> {

        val observable: Observable<Int> = Observable.create{
            it.onNext((1..5).shuffled().first())
        }
        return observable.map{
                colorsGenerator.changeColor(it)
        }
    }
}