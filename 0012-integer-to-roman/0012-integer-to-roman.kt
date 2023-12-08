class Solution {
    fun intToRoman(num: Int): String {
        
        val pairList: List<Pair<Int, String>> = listOf(
            Pair(1000, "M"),
            Pair(900, "CM"),
            Pair(500, "D"),
            Pair(400, "CD"),
            Pair(100, "C"),
            Pair(90, "XC"),
            Pair(50, "L"),
            Pair(40, "XL"),
            Pair(10, "X"),
            Pair(9, "IX"),
            Pair(5, "V"),
            Pair(4, "IV"),
            Pair(1, "I")
        )
        
        val sb = StringBuilder()
        var tempNum = num
        for ( p in pairList ) {
            val pNum = p.first
            val s = p.second
            while(tempNum >= pNum ) {
                tempNum -= pNum
                sb.append(s)
            }
        }
        
        return sb.toString()
    }
}