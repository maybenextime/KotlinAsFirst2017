@file:Suppress("UNUSED_PARAMETER")
package lesson4.task1

import lesson1.task1.discriminant
import lesson1.task1.sqr
import lesson3.task1.digitNumber
import lesson3.task1.isPrime
import java.awt.Stroke
import java.lang.Math.*
import javax.swing.text.html.HTML.Tag.I

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
        when {
            y < 0 -> listOf()
            y == 0.0 -> listOf(0.0)
            else -> {
                val root = Math.sqrt(y)
                // Результат!
                listOf(-root, root)
            }
        }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + Math.sqrt(d)) / (2 * a)
    val y2 = (-b - Math.sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.toLowerCase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double {
    var t = 0.0
    if (v.size == 0) return 0.0
    for (i in 0..v.size - 1 ) {
        t +=  sqr(v[i])
    }
    return sqrt(t)
}

/**
 * Простая
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double {
    var result = 0.0
    if (list.size == 0) return 0.0
    for (i in 0.. list.size - 1) { result += list[i]}
    return result / list.size
}

/**
 * Средняя
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> {
    val m = mean(list)
    for (i in 0 .. list.size - 1){
        list[i] = list[i] - m
    }
    return list
}

/**
 * Средняя
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.0.
 */
fun times(a: List<Double>, b: List<Double>): Double {
    var result = 0.0
    if (a.size * b.size == 0) return 0.0
    for (i in 0.. min(a.size - 1,b.size - 1)){
        result += a[i] * b[i]
    }
    return result
}

/**
 * Средняя
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0.0 при любом x.
 */
fun polynom(p: List<Double>, x: Double): Double{
    var a = 1.0
    if (p.size == 0) return 0.0
    var result = p[0]
    if (p.size == 1) return p[0]
    for (i in 1..p.size-1) {
        a = a*x
        result += p[i]*a
    }
    return result
}

/**
 * Средняя
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Double>): MutableList<Double> {
    var sum = 0.0
    while (list.size < 2) return list
    var a = list[list.size-1]
    for (i in 0.. list.size -1){
        sum += list [i]
    }
    for ( i in list.size-1 downTo 1) {
        list[i] = sum
        sum = sum - a
        a = list[i - 1]
    }
    return list
}

/**
 * Средняя
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> {
    val list = mutableListOf<Int>()
    var av = n
    var i = 2
    if (isPrime(n) == true) {
        list.add(n)
        return list
    }
    while (i <= sqrt(av*1.0).toInt()) {
        if (isPrime(i) == true) {
            while (av % i == 0) {
                av = av/i
                list.add(i)
            }
            i++
        }
        else i++
        if (isPrime(av)) {
            list.add(av)
            return list
        }
        }
    return list
    }



/**
 * Сложная
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 */
fun factorizeToString(n: Int): String {
    return factorize(n).joinToString(separator = "*")
}

/**
 * Средняя
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> {
    val av = mutableListOf<Int>()
    var n1 = n
    var t: Int
    if (n==0) return listOf(0)
    while (n1 > 0) {
        av.add(n1 % base)
        n1 = n1 / base
    }
    return av.reversed()
}

/**
 * Сложная
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 */
fun convertToString(n: Int, base: Int): String {
    val list = mutableListOf<Int>()
    val list2 = mutableListOf<Char>()
    var n1 = n
    if (n == 0) return "0"
    while (n1 > 0) {
        list.add(n1 % base)
        n1 = n1 / base
    }
    list.reverse()
    for (i in 0..list.size - 1){
        if (list[i] >= 10 && list[i] <= 36) {
            list2.add((list[i] + 87).toChar())
        } else list2.add((list[i] + 48).toChar())
        }

    return list2.joinToString (separator = "")
}

/**
 * Средняя
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int {
    var result = digits[0]
    if (digits.size == 1 ) return digits[0]
    for (i in 1..digits.size - 1){
        result = result * base + digits[i]
    }
    return result
}
/**
 *
 *  Сложная
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 */
fun decimalFromString(str: String, base: Int): Int {
    val listch = str.toCharArray()
    val listint = mutableListOf<Int>()
    var av = 0.0
    var j=0.0
    for (i in 0..listch.size-1) {
        if (listch[i].toInt() >= 97) {listint.add(listch[i].toInt()-87)}
        else listint.add(listch[i].toInt()-48)
    }
    for (i in listint.size-1 downTo 0){
        av += listint[i] * pow(base*1.0,j)
        j=j+1
    }
    return av.toInt()
}

/**
 * Сложная
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String {
    var n1 = n
    val list1: List<String> = listOf("","I","II","III","IV","V","VI","VII","VIII","IX")
    val list2: List<String> = listOf("","X","XX","XXX","XL","L","LX","LXX","LXXX","XC")
    val list3: List<String> = listOf("","C","CC","CCC","CD","D","DC","DCC","DCCC","CM")
    var av =""
    for (i in 1..digitNumber(n))
    {
        if (i == 1){av = list1[n1%10] + av}
        if (i == 2){av = list2[n1%10] + av}
        if (i == 3){av = list3[n1%10] + av}
        if (i > 3)break
        n1 = n1/10
    }
    for (i in 1..n1) {av= "M"+av}
    return av
}
/**
 * Очень сложная
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russian3(n: Int): MutableList<String>{
    val lstr1  = mutableListOf<String>()
    var n1 = n
    val list12: List<String> = listOf("","один","два","три","четыре","пять","шесть","семь","восемь","девять","десять",
                                    "одиннадцать","двенадцать","тринадцать","четырнадцать","пятнадцать","шестнадцать",
                                    "семнадцать","восемнадцать","девятнадцать")
    val list2: List<String> = listOf("","","двадцать","тридцать","сорок","пятьдесят",
                                    "шестьдесят","семьдесят","восемьдесят","девяносто")
    val list3: List<String> = listOf("","сто","двести","триста","четыреста","пятьсот",
                                    "шестьсот","семьсот","восемьсот","девятьсот")

    if(n1%100 < 20) {
        lstr1.add(list12[n1 % 100])
        lstr1.add(list3[n1 / 100])
    }
    else {
        for (i in 1..digitNumber(n))
        {
            if (i == 1){lstr1.add(list12[n1 % 10])}
            if (i == 2){lstr1.add(list2[n1 % 10])}
            if (i == 3){lstr1.add(list3[n1 % 10])}
            n1 = n1 / 10
        }
    }
    lstr1.remove(element = "")
    lstr1.reverse()
    return lstr1
}

fun russian(n: Int): String {
    val list = mutableListOf<String>()
    val n1 = n % 1000
    val n2 = n / 1000
    if (n2 != 0) {
        if (n2 % 100 == 1) {
            list.addAll(russian3(n2-1))
            list.add("одна тысяча")
            list.addAll(russian3(n1))
            list.remove("")
            return list.joinToString(separator = " ")
        }
        if (n2 % 100 == 2) {
            list.addAll(russian3(n2-2))
            list.add("две тысячи")
            list.addAll(russian3(n1))
            list.remove("")
            return list.joinToString(separator = " ")
        } else {
            if (n2 % 100 >= 20) {
                if (n2 % 10 == 1) {
                    list.addAll(russian3(n2-1))
                    list.add("одна тысяча")
                    list.addAll(russian3(n1))
                    return list.joinToString(separator = " ")
                }
                if (n2 % 10 == 2) {
                    list.addAll(russian3(n2-2))
                    list.add("две тысячи")
                    list.addAll(russian3(n1))
                    return list.joinToString(separator = " ")
                }
                if ((n2 % 10 == 3) || (n2 % 10 == 4)) {
                    list.addAll(russian3(n2))
                    list.add("тысячи")
                    list.addAll(russian3(n1))
                    return list.joinToString(separator = " ")
                } else {
                    list.addAll(russian3(n2))
                    list.add("тысяч")
                    list.addAll(russian3(n1))
                    return list.joinToString(separator = " ")
                }
            } else {
                if ((n2 % 100 == 3) || (n2 % 100 == 4)) {
                    list.addAll(russian3(n2))
                    list.add("тысячи")
                    list.addAll(russian3(n1))
                    return list.joinToString(separator = " ")
                } else {
                    list.addAll(russian3(n2))
                    list.add("тысяч")
                    list.addAll(russian3(n1))
                    list.remove(element = "")
                    return list.joinToString(separator = " ")
                }
            }
        }
    }
    else return russian3(n1).joinToString (separator = " ")
}

