package by.alisa.supruniuk.workwithdagger.dagger

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import by.alisa.supruniuk.workwithdagger.viewmodel.MyViewModel
import by.alisa.supruniuk.workwithdagger.viewmodel.ViewModelFactory
import by.alisa.supruniuk.workwithdagger.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MyViewModel::class)
    internal  abstract fun bindEditPlaceViewModel(editPlaceViewModel: MyViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}