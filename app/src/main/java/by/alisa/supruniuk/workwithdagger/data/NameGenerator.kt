package by.alisa.supruniuk.workwithdagger.data

import javax.inject.Inject

class NameGenerator @Inject constructor() {

    fun getNameColor(num: Int): String {

        return when (num) {
            1 -> "black"
            2 -> "white"
            3 -> "yellow"
            4 -> "green"
            5 -> "blue"
            else -> "nothing"
        }

    }
}