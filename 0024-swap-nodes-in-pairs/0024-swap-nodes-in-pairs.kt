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
    fun swapPairs(head: ListNode?): ListNode? {
        
        if ( head == null )
            return null
        
        var prevRight: ListNode? = null
        
        var newHead = head
        var node = head
        while(node != null && node.next != null) {
            
            val left = node!!
            val right = node.next!!
            
            left.next = right.next
            right.next = left
            
            if ( prevRight != null )
                prevRight.next = right
            if ( prevRight == null )
                newHead = right
            
            node = left.next
            prevRight = left
        }
        return newHead
    }
}