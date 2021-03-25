package by.alisa.supruniuk.workwithdagger.ui.fragment_my_name

import javax.inject.Inject

class UserName @Inject constructor() {
    fun getUserName(): String{
        return "Alisa"
    }
}