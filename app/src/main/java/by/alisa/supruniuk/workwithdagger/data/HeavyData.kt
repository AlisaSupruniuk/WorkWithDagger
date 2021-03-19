package by.alisa.supruniuk.workwithdagger.data

import javax.inject.Inject

class HeavyData @Inject constructor() {

    var count: Int = 0

    init {
        ++count
    }

    val numbersOne: Array<Int> = Array(300000, {(1..5).random()})
    val numbersTwo: Array<Int> = Array(300000, {(6..10).random()})



}