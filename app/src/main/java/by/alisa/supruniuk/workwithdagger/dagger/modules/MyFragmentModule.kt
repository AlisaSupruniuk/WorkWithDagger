package by.alisa.supruniuk.workwithdagger.dagger.modules

import android.content.Context
import by.alisa.supruniuk.workwithdagger.data.ColorsGeneratorInterface
import by.alisa.supruniuk.workwithdagger.data.ColorsGeneratorOne
import by.alisa.supruniuk.workwithdagger.data.ColorsGeneratorTwo
import by.alisa.supruniuk.workwithdagger.view.MyFragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class MyFragmentModule {

    @Binds
    abstract fun provide(colorsGeneratorOne: ColorsGeneratorOne) : ColorsGeneratorInterface

}