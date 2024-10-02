package capps.learning.hollofreeze.examples

enum class Day {
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday,
    Sunday
}

fun selectedDay(day: Day) {
    when (day) {
        Day.Monday -> {}
        Day.Tuesday -> {}
        Day.Wednesday -> TODO()
        Day.Thursday -> TODO()
        Day.Friday -> TODO()
        Day.Saturday -> TODO()
        Day.Sunday -> TODO()
    }
}

enum class Result {
    Successful,
    Failed
}

fun fetchUserFromInternet(email: String): Result {
    if (email == "Chris") {
        return Result.Successful
    } else {
        return Result.Failed
    }
}


fun main() {
    test()
}

fun test() {
    val response = fetchUserFromInternet("Chriss")

    if (response == Result.Successful) {
        println("Going to the home screen")
    } else if (response == Result.Failed) {
        println("Failed to login")
    }
}