class Solution {
    fun maxArea(height: IntArray): Int {
        
        var maxArea = Int.MIN_VALUE
        
        var l = 0
        var r = height.lastIndex
        
        while( l < r ) {
            val I = height[l]
            val J = height[r]
            val w = r - l
            val h = minOf(I, J)
            
            val area = w * h
            maxArea = maxOf(maxArea, area)
            
            if ( I < J )
                l++
            else
                r--
        }
        
        
        
        return maxArea
    }
}