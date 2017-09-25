@file:Suppress("UNUSED_PARAMETER")
package lesson3.task1

import lesson1.task1.sqr
import java.lang.Math.*
/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    for (m in 2..Math.sqrt(n.toDouble()).toInt()) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n/2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
        when {
            n == m -> 1
            n < 10 -> 0
            else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
        }

/**
 * Тривиальная
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 */
fun digitNumber(n: Int):Int {
    var a:Int=n
    var i:Int=0
    if (a==0) return 1
    while(a!=0){
        a=a/10
        i++
    }
    return i
}



/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    var t :Int
    var i=2
    var fib1=1
    var fib2=1
    while (i<n){
        i++
        t=fib2
        fib2=fib1+fib2
        fib1 =t
    }
    return fib2

}
/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var x=m*n
    var a=m
    var b=n
    while(a!=b){
        if (a>b) {a=a-b} else {b=b-a}
    }
    return (x/a)
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var i:Int=2
    while ((n%i!=0)&&(i<= sqrt(n.toDouble()))){
        i++
   }
    if (n%i!=0) return n else
    return i
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    return n/minDivisor(n)
}

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    if (m*n/ lcm(m,n) ==1) return true else return false
}

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    if (m==n) return true else{
    if (floor(sqrt(n.toDouble()))- floor(sqrt(m.toDouble())) >0) return true
    else return false }
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun sin(x: Double, eps: Double):Double{
    var s:Double = x
    var a:Double = x
    var i=1.0
    var s1=1.0
    if (x==0.0) return 0.0
    while (abs(s/s1) >= abs(eps)) {
        s=s*x*x*(-1.0)
        s1=s1*(i+1.0)*(i+2.0)

        a=a+ s/s1
        i=i+2.0
    }
        return a
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun cos(x: Double, eps: Double): Double{
    var s: Double = 1.0
    var a: Double = 1.0
    var i = 0.0
    var s1 = 1.0
    while (abs(s/s1) >= abs(eps)) {
        s1 = s1 * (i + 1.0) * (i + 2.0)
        s = s * x * x * (-1.0)
        a = a + s / s1
        i = i + 2.0
    }
    return a
}
/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 * Не использовать строки при решении задачи.
 */
fun revert(n: Int): Int {
    var result=0
    var number=n
    while(number>0) {
        result= (result*10)+number%10
        number/=10
    }
    return result
}
/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 */
fun isPalindrome(n: Int): Boolean {
    if (n== revert(n))return true else return false
}

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 */
fun hasDifferentDigits(n: Int): Boolean {
    var i:Int=1
    var j:Int=0
    if (n==0) return false
    while (n/i!=0) {
        i = i * 10
        j = j * 10 + 1
    }
    if (n%j==0) return false else return true

}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 */
fun squareSequenceDigit(n: Int): Int{
    var a:Int=1
    var j:Int=1
    var b:Int=3
    var c:Int=n
    var k:Int
    var m:Int=1
    if (n==1) return 1
    if (n==2) return 4
    if (n==3) return 9 else{
    while (c-b*j>0) {
        c=c-b*j
        a=a*10
        if (sqrt(a.toDouble ())-sqrt(a.toDouble()).toInt()>0) {
            b= sqrt((a*10-1).toDouble()).toInt()- sqrt(a.toDouble()).toInt()}
            else {b= sqrt((a*10-1).toDouble()).toInt()- sqrt(a.toDouble()).toInt()+1 }
        j=j+1
    }

    if (sqrt(a.toDouble())-sqrt(a.toDouble()).toInt()>0) {
        if (c%j==0) {a= sqrt(a.toDouble()).toInt()+c/j } else {a= sqrt(a.toDouble()).toInt()+c/j+1}}
    else { if (c%j==0) {a= sqrt(a.toDouble()).toInt() +c/j-1} else a= sqrt(a.toDouble()).toInt() +c/j}
    if (c%j==0) {c=c} else c=c%j
    a=a*a

    for(k in 1..(j-c)) {
        m = m * 10
    }
    a=(a/m)%10
    return a}
    }

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 */
fun fibSequenceDigit(n: Int): Int {
    var i:Int=1
    var j:Int=1
    var m:Int=1
    var a:Int=0
    var f:Int=0


    while (i<n) {
        j++
        i=i + digitNumber(fib(j))
    }
    f= fib(j)
    for (k in 1..(i-n)) {
        a =f%10
        f=(f-a)/10
    }

    return f%10
}
