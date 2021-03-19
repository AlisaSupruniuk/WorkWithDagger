package by.alisa.supruniuk.workwithdagger.dagger.modules

import by.alisa.supruniuk.workwithdagger.data.ColorsGeneratorInterface
import by.alisa.supruniuk.workwithdagger.data.ColorsGeneratorTwo
import dagger.Binds
import dagger.Module

@Module
abstract class SecondFragmentModule {

    @Binds
    abstract fun provide(colorsGeneratorTwo: ColorsGeneratorTwo) : ColorsGeneratorInterface
}