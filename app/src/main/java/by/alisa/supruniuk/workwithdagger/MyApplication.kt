package by.alisa.supruniuk.workwithdagger

import android.app.Application
import by.alisa.supruniuk.workwithdagger.dagger.AppComponent
import by.alisa.supruniuk.workwithdagger.dagger.ContextModule
import by.alisa.supruniuk.workwithdagger.dagger.DaggerAppComponent

class MyApplication: Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
                .contextModule(ContextModule(applicationContext))
                .build()
    }
}

