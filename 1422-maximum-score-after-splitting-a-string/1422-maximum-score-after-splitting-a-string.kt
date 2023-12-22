class Solution {
    fun maxScore(s: String): Int {
        var maxScore = Int.MIN_VALUE

        for ( i in 1 until s.length ) {
            val leftScore = s.substring(0, i).filter{ it == '0' }.length
            val rightScore = s.substring(i).filter{ it == '1' }.length
            val score = leftScore + rightScore
            maxScore = maxOf(maxScore, score)
        }

        return maxScore
    }
}