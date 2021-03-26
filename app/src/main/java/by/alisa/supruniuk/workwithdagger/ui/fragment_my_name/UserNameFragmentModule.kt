package by.alisa.supruniuk.workwithdagger.ui.fragment_my_name

import androidx.lifecycle.ViewModel
import by.alisa.supruniuk.workwithdagger.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class UserNameFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelUserNameFragment::class)
    internal abstract fun firstViewModel(viewModel: ViewModelUserNameFragment): ViewModel
}