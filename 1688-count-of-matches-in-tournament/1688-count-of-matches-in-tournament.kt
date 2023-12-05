class Solution {
    fun numberOfMatches(n: Int): Int {
        
        var sum = 0
        var tempN = n
        while( tempN > 1 ) {            
            sum += tempN / 2
            tempN = tempN / 2 + if( tempN % 2 == 0 ) 0 else 1
        }
        
        return sum
    }
}