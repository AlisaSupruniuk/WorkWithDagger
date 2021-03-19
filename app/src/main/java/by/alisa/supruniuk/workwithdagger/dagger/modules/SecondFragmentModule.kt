package by.alisa.supruniuk.workwithdagger.dagger.modules

import androidx.lifecycle.ViewModel
import by.alisa.supruniuk.workwithdagger.data.ColorsGeneratorInterface
import by.alisa.supruniuk.workwithdagger.data.ColorsGeneratorTwo
import by.alisa.supruniuk.workwithdagger.viewmodel.MyViewModel
import by.alisa.supruniuk.workwithdagger.viewmodel.SecondViewModel
import by.alisa.supruniuk.workwithdagger.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class SecondFragmentModule {

    @Binds
    abstract fun provideColorsGeneratorTwo(colorsGeneratorTwo: ColorsGeneratorTwo) : ColorsGeneratorInterface

    @Binds
    @IntoMap
    @ViewModelKey(SecondViewModel::class)
    internal abstract fun secondViewModel(viewModel: SecondViewModel): ViewModel
}