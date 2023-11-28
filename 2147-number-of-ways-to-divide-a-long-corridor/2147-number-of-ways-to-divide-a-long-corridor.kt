class Solution {
    fun numberOfWays(corridor: String): Int {
        val countS = corridor.filter{ it == 'S' }.length
        if ( countS < 2
           || countS % 2 == 1 )
            return 0
        
        data class Interval(val left: Int, val right: Int)
        val intervalList = ArrayList<Interval>()
        var s = 0 // temp S Count
        var left = 0
        for ( i in corridor.indices ) {
            val sp = corridor[i]
            if ( sp == 'S' ) {
                s++
                if ( s == 1 ) {
                    left = i
                } else if ( s == 2 ) {
                    intervalList.add(Interval(left, i))
                    s = 0
                }
            } // if
        } // for
        
        val distanceList = ArrayList<Int>()
        for ( i in 1 until intervalList.size ) {
            val from = intervalList[i-1]
            val to = intervalList[i]
            val distance = to.left - from.right
            distanceList.add(distance)
        }
        var longAnswer = 1L
        val MOD = 1000000007
        distanceList.forEach { longAnswer = (longAnswer % MOD * it % MOD) % MOD }
        
        return longAnswer.toInt()
    }
}