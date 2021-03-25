package by.alisa.supruniuk.workwithdagger.ui.fragment_color_name

import androidx.lifecycle.ViewModel
import by.alisa.supruniuk.workwithdagger.data.ColorsGeneratorInterface
import by.alisa.supruniuk.workwithdagger.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class FragmentTwoModule {

    @Binds
    abstract fun provideColorsGeneratorTwo(colorsGeneratorTwo: ColorsGeneratorTwo) : ColorsGeneratorInterface

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelTwo::class)
    internal abstract fun secondViewModel(viewModel: ViewModelTwo): ViewModel
}