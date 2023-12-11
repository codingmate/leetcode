class Solution {
    fun findSpecialInteger(arr: IntArray): Int {
        val numCountMap = HashMap<Int, Int>()
        for ( num in arr ) {
            numCountMap[num] = (numCountMap[num]?: 0) + 1
            if ( numCountMap[num]!! * 4 > arr.size )
                return num
        }
        
        return -1
    }
}