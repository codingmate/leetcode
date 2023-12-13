class Solution {
    fun numSpecial(mat: Array<IntArray>): Int {
        
        val rowCount = mat.size
        val colCount = mat[0].size // row >= 1
        
        val rowSumList = IntArray(rowCount)
        val colSumList = IntArray(colCount)
        for ( r in 0 until rowCount )
            for ( c in 0 until colCount ) {
                rowSumList[r] += mat[r][c]
                colSumList[c] += mat[r][c]
        }
        
        
        var count = 0
        for ( r in 0 until rowCount )
            for ( c in 0 until colCount )
                count += if ( mat[r][c] == 1 && rowSumList[r] == 1 && colSumList[c] == 1 ) 1 else 0
    
        return count
    }
}