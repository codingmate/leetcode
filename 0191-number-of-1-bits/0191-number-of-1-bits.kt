class Solution {
    // you need treat n as an unsigned value
    fun hammingWeight(n:Int):Int {
        
        val positiveN = if ( n < 0 ) -n else n
        var unsignedBinary = "00000000000000000000000000000000${positiveN.toString(2)}"
        unsignedBinary = unsignedBinary.substring(unsignedBinary.length - 32)
        //println("$unsignedBinary : uB1, ${positiveN.toString(2)} : n")
        
        if ( n >= 0 )
            return unsignedBinary.filter{it == '1'}.length
        else {
            var inverted = unsignedBinary.map { if (it == '0') '1' else '0' }.joinToString("")
            //println("$inverted : inverted")
            var carry = 1
            
            val twoComplement = CharArray(32)
            
            for (i in 31 downTo 0) {
                val sum = inverted[i].digitToInt() + carry
                twoComplement[i] = if (sum % 2 == 0) '0' else '1'
                carry = sum / 2
            }
            
            //println("${twoComplement.joinToString("")} : twoComplement")
            return twoComplement.filter{it == '1'}.size
        }
        
    }
}