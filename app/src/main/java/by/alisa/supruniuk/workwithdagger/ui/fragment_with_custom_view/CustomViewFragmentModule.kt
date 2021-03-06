package by.alisa.supruniuk.workwithdagger.ui.fragment_with_custom_view

import androidx.lifecycle.ViewModel
import by.alisa.supruniuk.workwithdagger.data.ColorsGeneratorInterface
import by.alisa.supruniuk.workwithdagger.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class CustomViewFragmentModule {

    @Binds
    abstract fun provideColorsGeneratorOne(colorsGeneratorOne: ColorsGeneratorOne) : ColorsGeneratorInterface

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelCustomViewFragment::class)
    internal abstract fun firstViewModel(viewModel: ViewModelCustomViewFragment): ViewModel
}