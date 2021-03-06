package com.drvector
object VectorDrawableFixinator {

    private val regexMap = mapOf(
            "\n" to " ",
            "(-)(\\.\\d)" to " -0$2",
            " (\\.\\d)" to " 0$1",
            "([a-z])(\\.\\d)" to "$1 0$2"
    )

    fun getContentWithFixedFloatingPoints(value: String): String {
        var result = value as CharSequence

        val prepareRegex = "(\\.\\d+)(\\.\\d)".toRegex()

        while (result.contains(prepareRegex)) { // adds spaces
            result = result.replace(prepareRegex, "$1 $2")
        }

        regexMap.forEach {
            result = result.replace(it.key.toRegex(), it.value)
        }


        val finalRegex = "\\s{2,}".toRegex()
        result = result.replace(finalRegex, " ")

        return result.toString()
    }
}
