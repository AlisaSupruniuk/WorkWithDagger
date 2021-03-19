package by.alisa.supruniuk.workwithdagger.dagger.modules

import android.content.Context
import by.alisa.supruniuk.workwithdagger.data.ColorsGeneratorOne
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ColorsGenerateOneModule{

    @Provides
    @Singleton
    fun provideColorGenerate(context: Context) : ColorsGeneratorOne {
        return ColorsGeneratorOne(context)
    }
}

