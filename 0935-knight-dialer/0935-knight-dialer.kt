class Solution {
    fun knightDialer(n: Int): Int {
            
        val dp = Array(n+1){ LongArray(10) }
        for ( num in 0 .. 9 ) 
            dp[1][num] = 1
        
        val MOD = 1000000007
        for ( i in 2 .. n ) {
            for ( from in 0 .. 9) {
                val fromValue = dp[i-1][from] % MOD
                when( from ) {
                    0 -> {
                        dp[i][4] = (dp[i][4] % MOD + fromValue) % MOD
                        dp[i][6] = (dp[i][6] % MOD + fromValue) % MOD
                    }
                    1 -> {
                        dp[i][6] = (dp[i][6] % MOD + fromValue) % MOD
                        dp[i][8] = (dp[i][8] % MOD + fromValue) % MOD
                    }
                    2 -> {
                        dp[i][7] = (dp[i][7] % MOD + fromValue) % MOD
                        dp[i][9] = (dp[i][9] % MOD + fromValue) % MOD
                    }
                    3 -> {
                        dp[i][4] = (dp[i][4] % MOD + fromValue) % MOD
                        dp[i][8] = (dp[i][8] % MOD + fromValue) % MOD
                    }
                    4 -> {
                        dp[i][3] = (dp[i][3] % MOD + fromValue) % MOD
                        dp[i][9] = (dp[i][9] % MOD + fromValue) % MOD
                        dp[i][0] = (dp[i][0] % MOD + fromValue) % MOD
                    }
                    6 -> {
                        dp[i][1] = (dp[i][1] % MOD + fromValue) % MOD
                        dp[i][7] = (dp[i][7] % MOD + fromValue) % MOD
                        dp[i][0] = (dp[i][0] % MOD + fromValue) % MOD
                    }
                    7 -> {
                        dp[i][2] = (dp[i][2] % MOD + fromValue) % MOD
                        dp[i][6] = (dp[i][6] % MOD + fromValue) % MOD
                    }
                    8 -> {
                        dp[i][1] = (dp[i][1] % MOD + fromValue) % MOD
                        dp[i][3] = (dp[i][3] % MOD + fromValue) % MOD
                    }
                    9 -> {
                        dp[i][2] = (dp[i][2] % MOD + fromValue) % MOD
                        dp[i][4] = (dp[i][4] % MOD + fromValue) % MOD
                    }
                }
            }            
        }
        var result = 0L
        dp[n].forEach {
            result += it
        }
        
        return (result % MOD).toInt()
    }
}