import java.util.PriorityQueue
class Solution {
    fun maximumElementAfterDecrementingAndRearranging(arr: IntArray): Int {
        val pq = PriorityQueue<Int>()
        arr.forEach{ pq.add(it) }
        var last = 1
        // first 1
        pq.poll()
        
        while ( pq.size > 0 ) {
            val poll = pq.poll()
            if ( poll == last || poll == last + 1 )
                last = poll
            else
                last += 1
        }
        return last
    }
}