class Solution {
    fun largestOddNumber(num: String): String {
        for ( i in num.length - 1 downTo 0 ) {
            val toInt = num[i].code - '0'.code
            if ( toInt % 2 == 1 )
                return num.substring(0, i+1)
        }
        return ""
    }
}