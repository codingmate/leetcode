class Solution {
    fun findDifferentBinaryString(nums: Array<String>): String {
        
        val numSet = HashSet<String>()
        val len = nums[0].length
        nums.forEach { numSet.add(it) }
        
        var result = ""
        fun dfs(depth: Int, prev: String) {
            if ( depth == len ) {
                result = prev
                return
            }
                
            
            val next0 = "${prev}0"
            if ( !numSet.contains(next0) )
                dfs(depth + 1, next0)
                
            val next1 = "${prev}1"
            if ( !numSet.contains(next1) )
                dfs(depth + 1, next1)
        }
        dfs(0, "")
        
        return result
    }
}