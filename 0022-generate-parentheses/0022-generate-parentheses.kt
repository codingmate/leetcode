class Solution {
    fun generateParenthesis(n: Int): List<String> {
        
        val l = '(' // left
        val r = ')' // right
        
        val answer = HashSet<String>()
        fun dfs(depth: Int, pL: Int, pR: Int, pS: String) {
            // pL : prevLeftCount
            // pR : prevRightCount
            // pS : prevString
            if ( depth == n * 2 ) {
                answer.add(pS)
                return
            }
            
            if ( n > pL )
                dfs(depth + 1, pL + 1, pR, "${pS}(")
            if ( pL > pR )
                dfs(depth + 1, pL, pR + 1, "${pS})")
            
        }
        dfs(0, 0, 0, "")
        
        return answer.toList()
    }
}