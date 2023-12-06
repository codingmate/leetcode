class Solution {
    fun totalMoney(n: Int): Int {
        var sum = 0
        for ( day in 1 .. n )
            sum += (day - 1) / 7 + (day - 1) % 7 + 1        
        
        return sum
    }
}