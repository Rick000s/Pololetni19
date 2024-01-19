fun main() {
    // Введення даних користувачем - висоти та ваги 5 членів регбійного клубу
    val heights = mutableListOf<Int>() // Список для зберігання висот членів клубу
    val weights = mutableListOf<Int>() // Список для зберігання ваг членів клубу

    println("Доброго дня, задайте висоти та ваги для 5 членів регбійного клубу:")

    // Заповнення списків висот та ваг користувачем
    for (i in 1..5) {
        print("Введіть висоту ${i}-го члена: ")
        heights.add(readLine()!!.toInt()) // Додавання висоти до списку
        print("Введіть вагу ${i}-го члена: ")
        weights.add(readLine()!!.toInt()) // Додавання ваги до списку
    }

    // Вивід на екран таблиці для контролю
    println("Таблиця висот та ваги:")
    println("| Член | Висота | Вага |")
    for (i in 0 until heights.size) {
        println("| ${i + 1}    | ${heights[i]}      | ${weights[i]}   |")
    }

    // Розрахунок статистичних даних (залиште решту програми незмінною)
    val averageHeight = heights.average() // Середня висота
    val averageWeight = weights.average() // Середня вага

    val sortedHeights = heights.sorted() // Сортований список висот
    val sortedWeights = weights.sorted() // Сортований список ваг

    val medianHeight = calculateMedian(sortedHeights) // Медіана висоти
    val medianWeight = calculateMedian(sortedWeights) // Медіана ваги

    val percentile30Height = calculatePercentile(sortedHeights, 0.3) // 30% персентиль висоти
    val percentile30Weight = calculatePercentile(sortedWeights, 0.3) // 30% персентиль ваги

    val upperQuartileHeight = calculatePercentile(sortedHeights, 0.75) // Верхній квартиль висоти
    val upperQuartileWeight = calculatePercentile(sortedWeights, 0.75) // Верхній квартиль ваги

    // Вивід результатів
    println("\nРезультати статистичних операцій:")
    println("1) Середня висота: $averageHeight")
    println("2) Середня вага: $averageWeight")
    println("3) Медіана висоти: $medianHeight")
    println("4) Медіана ваги: $medianWeight")
    println("5) 30% персентиль висоти: $percentile30Height")
    println("6) 30% персентиль ваги: $percentile30Weight")
    println("7) Верхній квартиль висоти: $upperQuartileHeight")
    println("8) Верхній квартиль ваги: $upperQuartileWeight")
}

// Розрахунок медіани списку чисел
fun calculateMedian(sortedList: List<Int>): Double {
    val size = sortedList.size
    return if (size % 2 == 0) {
        (sortedList[size / 2 - 1] + sortedList[size / 2]) / 2.0
    } else {
        sortedList[size / 2].toDouble()
    }
}

// Розрахунок персентилю списку чисел
fun calculatePercentile(sortedList: List<Int>, percentile: Double): Double {
    val index = (percentile * (sortedList.size - 1)).toInt()
    return sortedList[index].toDouble()
}