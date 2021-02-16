package main

fun main() {
    println("Введите диапазон значений")
    println("Минимальное:")
    val min = readLine()!!.toInt()
    println("Максимальное:")
    val max = readLine()!!.toInt()

    val pegasusGroupGenerator = PegasusGroupGenerator(min, max)
    val pegasusGroup:MutableList<Pegasus> = pegasusGroupGenerator.getPegasusGroup()

    for (i in 0 until pegasusGroup.count()){
        println("Пегас №" + (i + 1))
        println("Имя: " + pegasusGroup[i].name)
        println("Длина крылье: " + "%.2f".format(pegasusGroup[i].wingsLength) + " метров")
        println("Сила перемещения во времени: " + if (pegasusGroup[i].hasPower) "есть" else "Данная сила ответствует")
        println("Скорость: " + pegasusGroup[i].speed + " пг/сек (Пегаметров в секунду)")
        println()
    }

}