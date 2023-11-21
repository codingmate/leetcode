class Solution {
    fun countNicePairs(nums: IntArray): Int {
        
        val revNums = nums.map{ it.toString().reversed().toLong() }
        var count = 0L
        val candidateMap = HashMap<Long, Long>()
        
        for ( i in nums.indices ) {
            val candidate = nums[i] - revNums[i]
            candidateMap[candidate] = (candidateMap[candidate]?: 0) + 1
        }
        for ( key in candidateMap.keys ) {
            val num = candidateMap[key]!!
            if ( num > 1 ) {
                count += (num * (num-1)) / 2 // num Combination 2
            }       
        }
        
        return (count % 1000000007).toInt()
    }
}