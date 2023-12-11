class Solution {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        
        // O(N^4) 200 * 200 * 200 * 200 = 40000 * 40000 = 16 0000 0000 -> Time Over
        // O(N^3) 200 * 200 * 200 = 800 0000 Ok
        
        if ( nums.size < 4 )
            return listOf()
            
        val numCountMap = HashMap<Int, Int>()
        nums.forEach { num -> numCountMap[num] = (numCountMap[num]?: 0) + 1}
        
        val sorted = nums.sorted()
        
        val result = ArrayList<List<Int>>()
        data class Group(val n1: Int, val n2: Int, val n3: Int, val n4: Int) {
            fun toList(): List<Int> {
                return listOf(n1, n2, n3, n4)
            }
        }
        val groupSet = HashSet<Group>()
        for ( i in sorted.indices ) {
            val nI = sorted[i]
            for ( j in i+1 until sorted.size ) {
                val nJ = sorted[j]
                for ( k in j+1 until sorted.size ) {
                    val nK = sorted[k]            
                    
                    val sumLong = nI.toLong() + nJ + nK
                    numCountMap[nI] = numCountMap[nI]!! - 1
                    numCountMap[nJ] = numCountMap[nJ]!! - 1
                    numCountMap[nK] = numCountMap[nK]!! - 1
                    
                    val nLLong = target.toLong() - sumLong
                    if ( !( nLLong in Int.MIN_VALUE .. Int.MAX_VALUE ) )
                        continue
                    val nL = nLLong.toInt()
                    val nLCount = numCountMap[nL.toInt()]?: 0
                    if ( nLCount > 0 ) {
                        // i < j < k
                        // nI <= nJ <= nK
                        // find nL Position
                        val group = if ( nL <= nI )
                                        Group(nL, nI, nJ, nK)
                                    else if ( nL in nI + 1 .. nJ )
                                        Group(nI, nL, nJ, nK)
                                    else if ( nL in nJ + 1 .. nK )
                                        Group(nI, nJ, nL, nK)
                                    else
                                        Group(nI, nJ, nK, nL)
                        if ( !groupSet.contains(group) ) {
                            groupSet.add(group)
                            result.add(group.toList())                            
                        }
                    }
                    
                    numCountMap[nI] = numCountMap[nI]!! + 1
                    numCountMap[nJ] = numCountMap[nJ]!! + 1
                    numCountMap[nK] = numCountMap[nK]!! + 1
                }
            }
        }
        
        return result
    }
}