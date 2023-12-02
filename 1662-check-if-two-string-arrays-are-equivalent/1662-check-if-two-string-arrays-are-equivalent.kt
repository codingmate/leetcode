class Solution {
    fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean {
        
        val sb1 = StringBuilder()
        word1.forEach{ sb1.append(it) }
        val sb2 = StringBuilder()
        word2.forEach{ sb2.append(it) }
        
        return sb1.toString() == sb2.toString()
    }
}