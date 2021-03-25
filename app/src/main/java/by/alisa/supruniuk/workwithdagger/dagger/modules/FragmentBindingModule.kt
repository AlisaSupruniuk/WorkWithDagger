package by.alisa.supruniuk.workwithdagger.dagger.modules

import androidx.lifecycle.ViewModelProvider
import by.alisa.supruniuk.workwithdagger.ui.fragment_with_custom_view.FragmentOne
import by.alisa.supruniuk.workwithdagger.ui.fragment_with_custom_view.FragmentOneModule
import by.alisa.supruniuk.workwithdagger.ui.fragment_my_name.FragmentThree
import by.alisa.supruniuk.workwithdagger.ui.fragment_my_name.FragmentThreeModule
import by.alisa.supruniuk.workwithdagger.ui.fragment_color_name.FragmentTwo
import by.alisa.supruniuk.workwithdagger.ui.fragment_color_name.FragmentTwoModule
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

    @ContributesAndroidInjector(modules = [FragmentThreeModule::class])
    abstract fun contributeThreeFragment(): FragmentThree
}