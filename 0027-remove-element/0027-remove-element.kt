class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        
        val removedNums = ArrayList<Int>()
        
        nums.forEach { num ->
            if( num != `val` )
                removedNums.add(num)
        }
        
        for ( i in removedNums.indices )
            nums[i] = removedNums[i]
        
        return removedNums.size
    }
}