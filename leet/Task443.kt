package leet

class Task443{
    fun compress(chars: CharArray): Int {
        var count: Int = 1
        var index = 0
        for (i in (chars.indices)) {
            if (i == chars.size - 1 || chars[i] != chars[i + 1]){
                val stroke = count.toString()
                chars[index] = chars[i]
                if (count > 1) {
                    for (j in (stroke.indices)) {
                        chars[index + j + 1] = stroke[j]
                    }
                    index += stroke.length
                }
                index += 1
                count = 0
            }
            count += 1
        }
        return index
    }
}

fun main() {
    var  s = readLine().toString().toCharArray()
    println(Task443().compress(s))
}