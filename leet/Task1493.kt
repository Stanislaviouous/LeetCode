package leet

import kotlin.math.max


class Task1493 {
    fun longestSubarray(nums: IntArray): Int {
        var answer = 0
        var mass = IntArray(nums.size)
        mass[nums.size - 1] = if (nums[nums.size - 1] == 1) (1) else (0)
        var dp = 0
        var g = 0
        for (i in ( nums.size - 2 downTo 0)) {
            if (nums[i] == 0) {
                mass[i] = 0
                g = 1
            }
            else {
                mass[i] = mass[i + 1] + 1
            }
        }
        if (g == 0){
            return (nums.size - 1)
        }
        for (i in (0 until nums.size - 1)) {
            if (nums[i] == 0) {
                answer = if (i == nums.size - 1) (max(answer, dp)) else (max(answer, dp + mass[i + 1]))
                dp = 0
            }
            else {
                dp += 1
            }
        }
        return answer
    }
}

fun main() {
    var  s = readLine().toString().split(" ").map { it -> it.toInt() }.toIntArray()
    println(Task1493().longestSubarray(s))
}