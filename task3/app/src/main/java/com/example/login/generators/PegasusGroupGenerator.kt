package com.example.login.generators

import com.example.login.models.Pegasus
import kotlin.random.Random

class PegasusGroupGenerator constructor(minCount: Int, maxCount: Int){
    val minCount = minCount
    val maxCount = maxCount

    val pegasusCountRandom = (minCount..maxCount).random()

    private fun randomName(): String = List(5) {
        (('a'..'z') + ('A'..'Z') + ('0'..'9')).random()
    }.joinToString("")

    private fun randomWindsLength(): Double {
        return Random.nextDouble(5.0, 30.0)
    }

    private fun randomPower(): Boolean {
        return Random.nextBoolean()
    }

    private fun randomSpeed(): Int {
        return Random.nextInt(10, 100)
    }

    fun getPegasusGroup(): MutableList<Pegasus> {
        val pegasus: MutableList<Pegasus> = mutableListOf()
        for (i in 1..pegasusCountRandom){
            pegasus.add(Pegasus(randomName(), randomWindsLength(), randomPower(), randomSpeed()))
        }
        return pegasus
    }

}