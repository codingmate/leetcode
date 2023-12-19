class Solution {
    fun imageSmoother(img: Array<IntArray>): Array<IntArray> {
        
        val output = Array(img.size){ IntArray(img[0].size) } // m, n >= 1
        
        for ( r in img.indices )
            for ( c in img[0].indices ) {
                var count = 0
                for ( i in -1 .. 1 ) {
                    val R = r + i
                    if ( R < 0 || R >= img.size)
                        continue
                    
                    for ( j in -1 .. 1 ) {
                        val C = c + j
                        if( C < 0 || C >= img[0].size )
                            continue
                        output[r][c] += img[R][C]
                        count++
                    }
                }
                output[r][c] /= count
            }
                
        return output
    }
}