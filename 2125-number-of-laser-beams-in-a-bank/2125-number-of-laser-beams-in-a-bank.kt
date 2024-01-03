class Solution {
    fun numberOfBeams(bank: Array<String>): Int {
        
        val lineBeamCounts = IntArray(bank.size)
        
        bank.forEachIndexed { i, line ->
            line.forEach { c ->
                val num = c.code - '0'.code
                lineBeamCounts[i] += num // 1 or 0
            }
        }
        
        val filter = lineBeamCounts.filter{ it > 0 }
        var count = 0
        
        for ( i in 1 until filter.size )
            count += filter[i-1] * filter[i]
        
        return count
    }
}