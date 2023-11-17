class Solution {
    fun minPairSum(nums: IntArray): Int {
        
        val sorted = nums.sorted()
        val sumSet = HashSet<Int>()
        for ( i in 0 until sorted.size / 2 ) {
            val left = sorted[i]
            val right = sorted[sorted.size - 1 - i]
            sumSet.add(left+right)
        }
        
        return sumSet.toList().max()
    }
}