class Solution {
    fun convert(s: String, numRows: Int): String {
        
        if ( numRows == 1 )
            return s
        
        val matrix = Array(numRows){CharArray(s.length)}
        
        //println("c : ${CharArray(5)[0] == '\u0000'}")
        var pR = -1 // prev r
        var pC = 0 // prev c
        var direct = "down"
        for ( i in s.indices ) {
            var char = s[i]
            if ( direct == "down" ) {
                val r = pR + 1
                
                matrix[r][pC] = char
                pR = r
            }
            else if ( direct == "rightUp" ) {
                val r = pR - 1
                val c = pC + 1
                
                matrix[r][c] = char
                
                pR = r
                pC = c
            }
            
            if (direct == "down" && pR == numRows - 1)
                direct = "rightUp"
            else if(direct == "rightUp" && pR == 0)
                direct = "down"
        }
        
        val sb = StringBuilder()
        for ( r in matrix.indices )
            for ( c in matrix[0].indices )
                if( matrix[r][c] != '\u0000' ) // Not Null
                    sb.append(matrix[r][c])
        
        
        return sb.toString()
    }
}
