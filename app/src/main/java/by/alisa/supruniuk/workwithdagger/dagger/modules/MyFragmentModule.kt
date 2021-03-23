package by.alisa.supruniuk.workwithdagger.dagger.modules

import androidx.lifecycle.ViewModel
import by.alisa.supruniuk.workwithdagger.data.ColorsGeneratorInterface
import by.alisa.supruniuk.workwithdagger.data.ColorsGeneratorOne
import by.alisa.supruniuk.workwithdagger.viewmodel.MyViewModel
import by.alisa.supruniuk.workwithdagger.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MyFragmentModule {

    @Binds
    abstract fun provideColorsGeneratorOne(colorsGeneratorOne: ColorsGeneratorOne) : ColorsGeneratorInterface

    @Binds
    @IntoMap
    @ViewModelKey(MyViewModel::class)
    internal abstract fun firstViewModel(viewModel: MyViewModel): ViewModel
}