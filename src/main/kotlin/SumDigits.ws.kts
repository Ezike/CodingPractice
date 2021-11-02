fun sumDigits(input: Int): Int {
    // fill in
    // with solution
    var i = input / 10
    if (i == 0) {
        return input
    }

    var result = input
    
    while (i > 0) {
        val a = result / 10
        val b = result % 10
        result = a + b
        i = a
    }
    
    return result
}

sumDigits(388)