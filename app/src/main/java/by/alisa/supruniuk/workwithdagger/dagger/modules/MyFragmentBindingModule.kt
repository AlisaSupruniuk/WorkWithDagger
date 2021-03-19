package by.alisa.supruniuk.workwithdagger.dagger.modules

import androidx.lifecycle.ViewModelProvider
import by.alisa.supruniuk.workwithdagger.view.MyFragment
import by.alisa.supruniuk.workwithdagger.view.SecondFragment
import by.alisa.supruniuk.workwithdagger.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MyFragmentBindingModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @ContributesAndroidInjector(modules = [MyFragmentModule::class])
    abstract fun contributeMyFragment(): MyFragment

    @ContributesAndroidInjector(modules = [SecondFragmentModule::class])
    abstract fun contributeSecondFragment(): SecondFragment
}