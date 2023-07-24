package leet

class Task560 {
    fun subarraySum(nums: IntArray, k: Int): Int {
        var count = 0
        var summ = 0
        var map = HashMap<Int, Int>()
        map[k] = 1
        for(i in (nums.indices)){
            summ += nums[i]
            if (map.containsKey(summ)) {
                count += map[summ].toString().toInt()
            }
            map[summ + k] = if (map.containsKey(summ + k)) {map[summ + k].toString().toInt() + 1} else {1}
        }
        return count
    }
}

fun main() {
    var  arr = readLine().toString().split(" ").map { it -> it.toInt() }.toIntArray()
    val k = readLine().toString().toInt()
    println(Task560().subarraySum(arr, k))
}