@file:Suppress("UNUSED_PARAMETER")
package lesson2.task2

import lesson1.task1.sqr
import java.lang.Math.*

/**
 * Пример
 *
 * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
 */
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
        sqr(x - x0) + sqr(y - y0) <= sqr(r)

/**
 * Простая
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
fun isNumberHappy(number: Int): Boolean{
    val n1= floorDiv(number,1000)
    val n2= floorDiv(number-1000*n1,100)
    val n3= floorDiv(number-1000*n1-100*n2,10)
    val n4=number-1000*n1-100*n2-10*n3
    if (n1+n2==n3+n4) return true else return false
}

/**
 * Простая
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
    if ((x1==x2)||(y1==y2)||( abs(x1-x2)== abs(y1-y2))) return true else return false
}

/**
 * Средняя
 *
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * Вернуть true, если утверждение верно
 */
fun circleInside(x1: Double, y1: Double, r1: Double,
                 x2: Double, y2: Double, r2: Double): Boolean {
    val r= sqrt(sqr((x1-x2))+ sqr((y1-y2)))
    if (r+r1<=r2) return true else return false
}

/**
 * Средняя
 *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 *
 */
fun min(a:Int,b:Int,c: Int):Int{
    var m=a
    if (m>b) {m=b}
    if (m>c) {m=c}
    return m
}
fun max(a:Int,b:Int,c: Int):Int {
    var m = a
    if (m < b) {
        m = b
    }
    if (m < c) {
        m = c
    }
    return m
}
fun cp(a:Int,b:Int,c:Int):Int{
    if((a!=b)&&(b!=c)&&(c!=a)){
        if ((a!=min(a,b,c))&&(a!=max(a,b,c))) return a
        else{
            if ((b!=min(a,b,c))&&(b!=max(a,b,c))) return b
            else return c
    }
    }
    if((a==b)&&((b==min(a,b,c))||(b==max(a,b,c)))) return a
    else{
        if((b==c)&&((c==min(a,b,c))||(c==max(a,b,c)))) return b
        else return c

    }

}
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean {
    if ((min(a, b, c) <= min(r, s, s)) && cp(a, b, c) <= max(r, s, s)) return true else return false

}