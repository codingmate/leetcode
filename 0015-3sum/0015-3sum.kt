class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        
        // O(N)
        val numCountMap = HashMap<Int, Int>()
        nums.forEach { num -> numCountMap[num] = (numCountMap[num] ?: 0) + 1 }
        
        val sorted = nums.sorted()
        data class GroupAsc(val nI: Int, val nJ: Int, val nK: Int)
        val groupSet = HashSet<GroupAsc>()
        for ( i in sorted.indices ) {
            val nI = sorted[i]
            for ( j in i+1 until sorted.size ) {
                val nJ = sorted[j] // nI <= nJ 
                numCountMap[nI] = (numCountMap[nI]?: 0) - 1
                numCountMap[nJ] = (numCountMap[nJ]?: 0) - 1
                
                val nK = -1 * (nI + nJ)
                
                if ( (numCountMap[nK]?: 0) > 0) {
                    if ( nI >= nK )
                        groupSet.add(GroupAsc(nK, nI, nJ))
                    else if ( nJ < nK )
                        groupSet.add(GroupAsc(nI, nJ, nK))
                    else
                        groupSet.add(GroupAsc(nI, nK, nJ))   
                }
                numCountMap[nI] = (numCountMap[nI]?: 0) + 1
                numCountMap[nJ] = (numCountMap[nJ]?: 0) + 1
            }
        }
        
        return groupSet.map{ g -> listOf(g.nI, g.nJ, g.nK) }.toList()
    }
}