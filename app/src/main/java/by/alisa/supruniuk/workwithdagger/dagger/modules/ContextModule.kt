package by.alisa.supruniuk.workwithdagger.dagger.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ContextModule() {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context{
        return application.applicationContext
    }
}