package leet

import java.util.ArrayList

class Task228 {
    fun summaryRanges(nums: IntArray): List<String> {
        if (nums.size == 1) {
            return listOf("${nums[0]}")
        }
        if (nums.isEmpty()) {
            return ArrayList<String>()
        }
        var stroke = ArrayList<String>()
        var p = 0
        for (i in (0 until  nums.size - 1)) {
            if (nums[i + 1] != nums[i] + 1) {
                stroke.add(
                    if (nums[p] == nums[i]) ("${nums[i]}") else ("${nums[p]}->${nums[i]}")
                )
                 p = i + 1
            }
        }
        stroke.add(
            if (nums[p] == nums[nums.size - 1]) ("${nums[nums.size - 1]}") else ("${nums[p]}->${nums[nums.size - 1]}")
        )
        return stroke
    }
}

fun main() {
    var  s = readLine().toString().split(" ").map { it -> it.toInt() }.toIntArray()
    println(Task228().summaryRanges(s))
}