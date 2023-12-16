class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        val sCharCountMap = HashMap<Char, Int>()
        s.forEach { c ->
            sCharCountMap[c] = (sCharCountMap[c]?: 0) + 1
        }
        
        val tCharCountMap = HashMap<Char, Int>()
        t.forEach { c ->
            tCharCountMap[c] = (tCharCountMap[c]?: 0) + 1
        }
        
        for ( c in sCharCountMap.keys )
            if ( !tCharCountMap.contains(c)
               || tCharCountMap[c] == null
               || sCharCountMap[c]!! != tCharCountMap[c]!! )
                return false
        
        for ( c in tCharCountMap.keys )
            if ( !sCharCountMap.contains(c) )
                return false
        
        return true
    }
}