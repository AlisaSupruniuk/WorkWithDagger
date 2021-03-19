package by.alisa.supruniuk.workwithdagger.dagger

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MyApplication: Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>


    override fun onCreate() {
        super.onCreate()
        buildComponent()
    }


    fun buildComponent(){
        DaggerAppComponent.builder()
            .application(this)?.build()?.inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }

}

