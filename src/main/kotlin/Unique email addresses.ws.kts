fun numUniqueEmails(
    emails: Array<String> = arrayOf(
        "test.email+alex@leetcode.com",
        "test.e.mail+bob.cathy@leetcode.com",
        "testemail+david@lee.tcode.com"
    )
): Int {
    // # divide the string between local and domain names
    // # Loop through the local name and find the .s and +s
    // # Add the characters left to a String

    val set = mutableSetOf<String>()

    for (string in emails) {
        val splitted = string.split("@")
        val local = splitted[0]
        val domain = splitted[1]
        var localName = ""
        for (char in local) {
            if (char == '.') {
                continue
            }
            if (char == '+') {
                break
            }
            localName += char
        }
        set.add("$localName" + "@" + "$domain")
    }
    return set.size
}

println(numUniqueEmails())

