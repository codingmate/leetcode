class Solution {
    fun onesMinusZeros(grid: Array<IntArray>): Array<IntArray> {
        val m = grid.size
        val n = grid[0].size // m >= 1
        
        val onesRows = IntArray(m)
        val onesCols = IntArray(n)
        val zerosRows = IntArray(m)
        val zerosCols = IntArray(n)
        
        for ( r in 0 until m )
            for ( c in 0 until n )
                if ( grid[r][c] == 1 ) {
                    onesRows[r]++
                    onesCols[c]++
                }
                else if ( grid[r][c] == 0 ) {
                    zerosRows[r]++
                    zerosCols[c]++
                } 
        val diff = Array(m){IntArray(n)}
        for ( r in 0 until m )
            for ( c in 0 until n )
                diff[r][c] = onesRows[r] + onesCols[c] - zerosRows[r] - zerosCols[c]
            
        return diff
    }
}