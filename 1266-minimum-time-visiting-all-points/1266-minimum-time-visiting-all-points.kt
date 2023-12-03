class Solution {
    fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {
        var count = 0
        for ( i in 1 .. points.size - 1 ) {
            val cur = points[i-1]
            val next = points[i]
            
            val deltaX = if (next[0] >= cur[0] ) next[0] - cur[0] else cur[0] - next[0]
            val deltaY = if (next[1] >= cur[1] ) next[1] - cur[1] else cur[1] - next[1]
            
            val distance = deltaX + deltaY - minOf(deltaX, deltaY)
            
            count += distance
        }
        return count
    }
}