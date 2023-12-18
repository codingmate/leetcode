class Solution {
    fun maxProductDifference(nums: IntArray): Int {
        val sorted = nums.sorted()
        
        
        return sorted[nums.size-1] * sorted[nums.size-2] - sorted[0] * sorted[1]
    }
}