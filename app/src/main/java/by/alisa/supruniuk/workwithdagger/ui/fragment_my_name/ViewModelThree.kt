package by.alisa.supruniuk.workwithdagger.ui.fragment_my_name

import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ViewModelThree @Inject constructor(private val userName: UserName): ViewModel() {

    fun getUserName(): Observable<String> {
        return Observable.just(userName.getUserName()).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}