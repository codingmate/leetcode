class Solution {
    fun myAtoi(s: String): Int {
        val trim = s.trim()
        var isPositive = true
        if ( trim.length > 0 )
            if ( trim[0] == '-' )
                isPositive = false
            else if ( trim[0] != '+' && !(trim[0] in '0' .. '9') )
                return 0
        
        var numberSb = StringBuilder()
        var firstNot0Index = -1
        for ( i in trim.indices ) {
            val c = trim[i]
            if ( i == 0 && ( c == '-' || c == '+' ) )
                continue
            
            if ( firstNot0Index == -1 && c == '0' )
                continue
            else
                firstNot0Index = i            
            
            if ( c in '0' .. '9' )
                numberSb.append(c)            
            else
                break
        }
            
        
        if (numberSb.length == 0)
            return 0
        
        val numberString = numberSb.toString()
        var number: Int? = null
        if ( numberString.length > 10 )
            number = if(isPositive) Int.MAX_VALUE else Int.MIN_VALUE
        else {
            var numStringForCheck = "0000000000${numberString}"
            numStringForCheck = numStringForCheck.substring(numStringForCheck.length - 10, numStringForCheck.length)
            
            if( isPositive && numStringForCheck >= Int.MAX_VALUE.toString())
                number = Int.MAX_VALUE
            else if ( !isPositive && numStringForCheck >= Int.MIN_VALUE.toString().substring(1) )
                number = Int.MIN_VALUE
            else
                number = (if(isPositive) 1 else -1) * numberString.toInt()
        }
        
        return number!!
    }
}