package by.alisa.supruniuk.workwithdagger.dagger.modules

import androidx.lifecycle.ViewModel
import by.alisa.supruniuk.workwithdagger.data.ColorsGeneratorInterface
import by.alisa.supruniuk.workwithdagger.ui.fragment_one.ColorsGeneratorOne
import by.alisa.supruniuk.workwithdagger.ui.fragment_one.ViewModelOne
import by.alisa.supruniuk.workwithdagger.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class FragmentOneModule {

    @Binds
    abstract fun provideColorsGeneratorOne(colorsGeneratorOne: ColorsGeneratorOne) : ColorsGeneratorInterface

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelOne::class)
    internal abstract fun firstViewModel(viewModel: ViewModelOne): ViewModel
}