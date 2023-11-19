class Solution {
    fun reductionOperations(nums: IntArray): Int {
        
        val numCountMap = HashMap<Int, Int>()        
        nums.forEach { num -> numCountMap[num] = (numCountMap[num]?: 0) + 1 }
        
        
        val distinctSortedDescendingNumList = nums.toSet().toList().sortedDescending()
        val size = distinctSortedDescendingNumList.size
        var answer = 0
        distinctSortedDescendingNumList.forEachIndexed { i, num -> 
            //println("num : ${num} index : $i, answer : $answer")
            if ( i < size - 1 ) {
                val numCount = numCountMap[num]!!
                answer += numCount * (size - 1 - i)
                //println("num : ${num}, numCount : ${numCount}, index : $i, answer : $answer")
            }
        }
        
        return answer
    }
}