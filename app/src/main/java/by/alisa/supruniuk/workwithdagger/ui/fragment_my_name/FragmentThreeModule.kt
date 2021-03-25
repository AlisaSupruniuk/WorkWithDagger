package by.alisa.supruniuk.workwithdagger.ui.fragment_my_name

import androidx.lifecycle.ViewModel
import by.alisa.supruniuk.workwithdagger.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class FragmentThreeModule {

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelThree::class)
    internal abstract fun firstViewModel(viewModel: ViewModelThree): ViewModel
}