package by.alisa.supruniuk.workwithdagger.dagger

import android.app.Application
import android.content.Context
import by.alisa.supruniuk.workwithdagger.MyApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        MainActivityBindingModule::class,
        ColorGenerateModule::class,
        ContextModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder?
        fun build(): AppComponent?
    }

    fun inject(app: MyApplication)

}