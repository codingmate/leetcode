class Solution {
    fun letterCombinations(digits: String): List<String> {
        if ( digits.length == 0 )
            return listOf()
        val chars = digits.toCharArray()
        val depthChildMap = HashMap<Int, List<Char>>()
        
        for ( depth in 0 until chars.size )
            depthChildMap[depth] = when ( chars[depth] ) {
                '2' ->
                    listOf('a', 'b', 'c')
                '3' ->
                    listOf('d', 'e', 'f')
                '4' ->
                    listOf('g', 'h', 'i')
                '5' ->
                    listOf('j', 'k', 'l')
                '6' ->
                    listOf('m', 'n', 'o')
                '7' ->
                    listOf('p', 'q', 'r', 's')
                '8' ->
                    listOf('t', 'u', 'v')
                '9' ->
                    listOf('w', 'x', 'y', 'z')
                else ->
                    listOf()
            }
        
        val result = ArrayList<String>()
        fun dfs(depth: Int, prev: String) {
            if (depth == chars.size) {
                result.add(prev)
                return
            }
            for ( c in depthChildMap[depth]!! )
                dfs(depth+1, "$prev$c")
        }
        
        dfs(0, "")
        return result
    }
}