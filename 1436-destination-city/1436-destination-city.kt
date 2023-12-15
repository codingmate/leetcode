class Solution {
    fun destCity(paths: List<List<String>>): String {
        
        val citySet = HashSet<String>()
        val fromCitySet = HashSet<String>()
        paths.forEach { path ->
            val from = path[0]
            val to = path[1]
            citySet.add(from)
            citySet.add(to)
            fromCitySet.add(from)
        }
        
        for ( city in citySet )
            if ( !fromCitySet.contains(city) )
                return city
        
        return ""
    }
}