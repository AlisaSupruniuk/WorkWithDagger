package by.alisa.supruniuk.workwithdagger.dagger

import android.content.Context
import by.alisa.supruniuk.workwithdagger.ColorsGenerator
import dagger.Module
import dagger.Provides

@Module
class ColorGenerateModule{
    @Provides
    fun provideColorGenerate(context: Context) : ColorsGenerator {
        return ColorsGenerator(context)
    }
}

