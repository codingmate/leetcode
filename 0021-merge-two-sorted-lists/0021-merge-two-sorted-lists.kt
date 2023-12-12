/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        
        if (list1 == null)
            return list2
        if (list2 == null)
            return list1
        
        var result = ListNode(Int.MIN_VALUE)
        
        var t1 = list1
        var t2 = list2
        
        var prev = result
        while ( t1 != null || t2 != null ) {
            val v1 = t1?.`val`?: Int.MAX_VALUE
            val v2 = t2?.`val`?: Int.MAX_VALUE
            
            if ( v1 < v2 ) {
                prev.next = t1
                t1 = t1!!.next
            }
            else if ( v1 != Int.MAX_VALUE || v2 != Int.MAX_VALUE ) {
                prev.next = t2
                t2 = t2!!.next
            }
            prev = prev.next
        }
        
        return result.next
        /*
        if (list1 == null)
            return list2
        if (list2 == null)
            return list1
        val l1 = ArrayList<ListNode>()
        l1.add(list1!!)
        val l2 = ArrayList<ListNode>()
        l2.add(list2!!)
        
        var t1 = list1!!.next
        while(t1 != null) {
            l1.add(t1)
            t1 = t1.next
        }
        var t2 = list2!!.next
        while(t2 != null) {
            l2.add(t2)
            t2 = t2.next
        }
        
        val resultList = ArrayList<ListNode>()
        var i1 = 0
        var i2 = 0
        while ( i1 < l1.size || i2 < l2.size ) {
            if( i1 < l1.size && i2 < l2.size ) {
                
                val v1 = l1[i1].`val`
                val v2 = l2[i2].`val`
                if (v1 < v2) {
                    resultList.add(l1[i1])
                    i1++
                }
                else {
                    resultList.add(l2[i2])
                    i2++
                }
            }
            else if ( i1 < l1.size ) {
                resultList.add(l1[i1])
                i1++
            }
            else if ( i2 < l2.size ) {
                resultList.add(l2[i2])
                i2++   
            }
            else {
                println("????")
                break
            }
        }
        resultList.forEach {
            println(it.`val`)
        }
        val result = resultList[0]
        var temp = result
        for ( i in 1 until resultList.size ) {
            temp.next = resultList[i]
            temp = temp.next
        }
        
        return result
        */
    }
}
















