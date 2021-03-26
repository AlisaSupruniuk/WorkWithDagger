package by.alisa.supruniuk.workwithdagger.dagger.modules

import androidx.lifecycle.ViewModelProvider
import by.alisa.supruniuk.workwithdagger.ui.fragment_with_custom_view.CustomViewFragment
import by.alisa.supruniuk.workwithdagger.ui.fragment_with_custom_view.CustomViewFragmentModule
import by.alisa.supruniuk.workwithdagger.ui.fragment_my_name.UserNameFragment
import by.alisa.supruniuk.workwithdagger.ui.fragment_my_name.UserNameFragmentModule
import by.alisa.supruniuk.workwithdagger.ui.fragment_color_name.ColorNameFragment
import by.alisa.supruniuk.workwithdagger.ui.fragment_color_name.ColorNameFragmentModule
import by.alisa.supruniuk.workwithdagger.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @ContributesAndroidInjector(modules = [CustomViewFragmentModule::class])
    abstract fun contributeMyFragment(): CustomViewFragment

    @ContributesAndroidInjector(modules = [ColorNameFragmentModule::class])
    abstract fun contributeSecondFragment(): ColorNameFragment

    @ContributesAndroidInjector(modules = [UserNameFragmentModule::class])
    abstract fun contributeThreeFragment(): UserNameFragment
}