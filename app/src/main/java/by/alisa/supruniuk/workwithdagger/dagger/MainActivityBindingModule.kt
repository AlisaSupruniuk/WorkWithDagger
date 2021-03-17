package by.alisa.supruniuk.workwithdagger.dagger

import by.alisa.supruniuk.workwithdagger.MainActivity
import by.alisa.supruniuk.workwithdagger.MyFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityBindingModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MyFragment
}