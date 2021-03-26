package by.alisa.supruniuk.workwithdagger.ui.fragment_color_name

import androidx.lifecycle.ViewModel
import by.alisa.supruniuk.workwithdagger.data.ColorsGeneratorInterface
import by.alisa.supruniuk.workwithdagger.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ColorNameFragmentModule {

    @Binds
    abstract fun provideColorsGeneratorTwo(colorsGeneratorTwo: ColorsGeneratorTwo) : ColorsGeneratorInterface

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelColorNameFragment::class)
    internal abstract fun secondViewModel(viewModel: ViewModelColorNameFragment): ViewModel
}