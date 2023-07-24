package leet

import kotlin.coroutines.suspendCoroutine
import kotlin.math.max
import kotlin.math.round
import kotlin.math.roundToInt

class Task849 {
    fun maxDistToClosest(seats: IntArray): Int {
        var answer: Int = 1
        var indexPrev  = -1
        var indexNow = 0
        for (i in (seats.indices)) {
            if (seats[i] == 1) {
                indexNow = i
                answer = if (indexPrev == -1) max(indexNow, answer) else max(((indexNow - indexPrev) / 2).toDouble().roundToInt(), answer)
                indexPrev = indexNow
            }
        }
        answer = max(seats.size - indexNow - 1, answer)
        return answer
        //
    }
}

fun main() {
    var  s = readLine().toString().split(" ").map { it -> it.toInt() }.toIntArray()
    println(Task849().maxDistToClosest(s))
}