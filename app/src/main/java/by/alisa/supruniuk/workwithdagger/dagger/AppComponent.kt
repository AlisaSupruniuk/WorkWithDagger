package by.alisa.supruniuk.workwithdagger.dagger

import by.alisa.supruniuk.workwithdagger.MyFragment
import dagger.Component

@Component(modules = [ColorGenerateModule::class, ContextModule::class])
interface AppComponent {
    fun injectsMainActivity(myFragment: MyFragment) {
    }
}