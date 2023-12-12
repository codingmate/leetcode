class Solution {
    fun isValid(s: String): Boolean {

        val opers = Stack<Int>()

        for ( c in s ) {
            when (c) {
                '(' -> opers.push(1)
                '[' -> opers.push(2)
                '{' -> opers.push(3)
                ')' -> if (opers.isEmpty() || opers.pop() != 1) return false
                ']' -> if (opers.isEmpty() || opers.pop() != 2) return false
                '}' -> if (opers.isEmpty() || opers.pop() != 3) return false
            }
        }
        return opers.isEmpty()
    }
}