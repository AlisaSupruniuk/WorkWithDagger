package by.alisa.supruniuk.workwithdagger.dagger.modules

import android.content.Context
import by.alisa.supruniuk.workwithdagger.data.ColorsGeneratorTwo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ColorsGenerateTwoModule {

        @Provides
        @Singleton
        fun provideColorGenerate(context: Context) : ColorsGeneratorTwo {
            return ColorsGeneratorTwo(context)
        }
}