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
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        
        
        val list = ArrayList<ListNode>()
        list.add(head!!) // sz >= 1
        
        var tempNext = head!!.next
        while(tempNext != null) {
            list.add(tempNext)
            tempNext = tempNext.next
        }
        if ( list.size == 1 && n == 1 )
            return null
        if ( list.size == n )
            return list[1]
        
        list[list.size - 1 - n ].next = list[list.size - n].next
        
        return list[0]
    }
}