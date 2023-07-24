package leet

class Task567 {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false
        val const = 97
        var arrS1 = IntArray(26)
        var arrS2 = IntArray(26)
        for (i in (s1.indices)) {
            arrS1[s1[i].toInt() - const] += 1
            arrS2[s2[i].toInt() - const] += 1
        }
        if (arrS1.contentEquals(arrS2)) return true
        for (i in (s1.length until s2.length)) {
            arrS2[s2[i - s1.length].toInt() - const] -= 1
            arrS2[s2[i].toInt() - const] += 1
            if (arrS1.contentEquals(arrS2)) return true
        }
        return false
    }
}

fun main(){
    val s1 = readLine().toString()
    val s2 = readLine().toString()
    println(Task567().checkInclusion(s1, s2))
}