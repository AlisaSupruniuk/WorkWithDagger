package by.alisa.supruniuk.workwithdagger.dagger.modules

import androidx.lifecycle.ViewModelProvider
import by.alisa.supruniuk.workwithdagger.ui.fragment_one.FragmentOne
import by.alisa.supruniuk.workwithdagger.ui.fragment_two.FragmentTwo
import by.alisa.supruniuk.workwithdagger.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @ContributesAndroidInjector(modules = [FragmentOneModule::class])
    abstract fun contributeMyFragment(): FragmentOne

    @ContributesAndroidInjector(modules = [FragmentTwoModule::class])
    abstract fun contributeSecondFragment(): FragmentTwo
}