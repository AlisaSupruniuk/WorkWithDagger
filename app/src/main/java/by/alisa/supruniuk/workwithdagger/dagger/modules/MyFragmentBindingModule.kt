package by.alisa.supruniuk.workwithdagger.dagger.modules

import by.alisa.supruniuk.workwithdagger.view.MyFragment
import by.alisa.supruniuk.workwithdagger.view.SecondFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MyFragmentBindingModule {

    @ContributesAndroidInjector(modules = [MyFragmentModule::class])
    abstract fun contributeMyFragment(): MyFragment

    @ContributesAndroidInjector(modules = [SecondFragmentModule::class])
    abstract fun contributeSecondFragment(): SecondFragment
}