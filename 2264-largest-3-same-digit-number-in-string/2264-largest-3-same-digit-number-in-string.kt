class Solution {
    fun largestGoodInteger(num: String): String {
        var max = ""
        for ( i in 2 until num.length )
            if ( num[i-2] == num[i-1] && num[i-1] == num[i] ) {
                val numGroup = "${num[i-2]}${num[i-1]}${num[i]}"
                max = maxOf(max, numGroup)
            }
            
        return max
    }
}