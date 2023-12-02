class Solution {
    fun countCharacters(words: Array<String>, chars: String): Int {
        val charCountMap = HashMap<Char, Int>()
        
        for ( c in chars )
            charCountMap[c] = (charCountMap[c]?: 0) + 1
        
        
        var answer = 0
        for ( word in words ) {
            val alphaCountMap = HashMap<Char, Int>()
            for ( c in word ) {
                val alpha = c
                alphaCountMap[c] = (alphaCountMap[c]?: 0) + 1
            }
            
            var isCorrect = true
            for ( c in alphaCountMap.keys ) {
                val charCount = charCountMap[c]?: 0
                val alphaCount = alphaCountMap[c]?: 0
                if ( charCount < alphaCount ) {
                    isCorrect = false
                    break
                }
            }
            answer += if (isCorrect) word.length else 0
        }
        return answer

    }
}