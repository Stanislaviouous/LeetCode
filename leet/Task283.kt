package leet

class Task283 {
    fun moveZeroes(nums: IntArray): Unit {
        var clone = -1
        var nul = 0
        for (i in (nums.indices)) {
            if (nums[i] != 0) {
                clone += 1
                nul = nums[i]
                nums[i] = 0
                nums[clone] = nul
            }
        }
        println(nums.contentToString())
    }
}

fun main() {
    var  s = readLine().toString().split(",").map { it -> it.toInt() }.toIntArray()
    println(Task283().moveZeroes(s))
}