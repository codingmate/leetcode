class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        var minDiff = Int.MAX_VALUE
        var minDiffSum = target
        // O(N^3)
        for ( i in nums.indices ) {
            val nI = nums[i]
            for ( j in i+1 until nums.size ) {
                val nJ = nums[j]
                for ( k in j+1 until nums.size ) {
                    val nK = nums[k]
                    val sum = nI + nJ + nK
                    val diff = if(target >= sum) target - sum else sum - target
                    if ( diff == 0 )
                        return target
                    if ( diff < minDiff ) {
                        minDiff = diff
                        minDiffSum = sum
                    }
                }
            }
        }
        
        return minDiffSum
    }
}