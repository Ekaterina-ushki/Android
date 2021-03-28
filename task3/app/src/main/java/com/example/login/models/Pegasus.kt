package com.example.login.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pegasus")
class Pegasus constructor(
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "wingsLength") val wingsLength: Double,
    @ColumnInfo(name = "hasPower") val hasPower: Boolean,
    @ColumnInfo(name = "speed") val speed: Int
){
    @PrimaryKey(autoGenerate = true) var id: Int = 0

    override fun toString(): String {
        val powerText = if (hasPower) "есть" else "Данная сила ответствует"
        val pegasusStr = "Имя: " + name + "\n" +
                "Длина крылье: " + "%.2f".format(wingsLength) + " метров" + "\n" +
                "Сила перемещения во времени: " + powerText + "\n" +
                "Скорость: " + speed + " пг/сек (Пегаметров в секунду)"
        return pegasusStr
    }
}

