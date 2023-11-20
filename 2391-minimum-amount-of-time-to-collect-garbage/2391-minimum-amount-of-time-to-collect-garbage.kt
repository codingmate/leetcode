class Solution {
    fun garbageCollection(garbage: Array<String>, travel: IntArray): Int {
        
        
        var mTime = 0
        var pTime = 0
        var gTime = 0
        var mLastIndex = 0
        var pLastIndex = 0
        var gLastIndex = 0
        
        garbage.forEachIndexed { i, g ->
            g.forEach { c ->
               when(c) {
                   'M' -> {
                       mTime++
                       mLastIndex = i
                   }
                   'P' -> {
                       pTime++
                       pLastIndex = i
                   }
                   'G' -> {
                       gTime++
                       gLastIndex = i
                   }
               }
            }
        }
        val travelDp = ArrayList<Int>()
        travelDp.add(0)
        for ( i in travel.indices )
            travelDp.add(travelDp[i] + travel[i])
        
        mTime += travelDp[mLastIndex]
        pTime += travelDp[pLastIndex]
        gTime += travelDp[gLastIndex]
        
        return mTime + pTime + gTime
    }
}