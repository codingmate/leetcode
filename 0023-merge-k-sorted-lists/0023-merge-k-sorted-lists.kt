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
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if ( lists.size == 0 )
            return null
        fun listNodeToList(root: ListNode): List<ListNode> {
            val list = ArrayList<ListNode>()
            list.add(root)
            var temp = root
            while(temp.next != null) {
                list.add(temp.next!!)
                temp = temp.next
            }
            return list
        }
        
        val totalNodeList = ArrayList<ListNode>()
        
        lists.forEach { listNode ->
            if(listNode != null) {
                for ( node in listNodeToList(listNode) )
                    totalNodeList.add(node)
            }
        }
        
        val sorted = totalNodeList.sortedBy{it.`val`}
        for ( node in sorted )
            print("${node.`val`} ")
        
        fun listToListNode(list: List<ListNode>): ListNode? {
            if ( list.size == 0 )
                return null
            val result = list[0]
            for ( i in 0 .. list.size - 2 )
                list[i].next = list[i+1]
            
            return result
        }
        
        return listToListNode(sorted)
    }
}