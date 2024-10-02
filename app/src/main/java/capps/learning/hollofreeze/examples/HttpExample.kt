package capps.learning.hollofreeze.examples

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

fun main() {

    println("Hey there brother, can you hear me")

    httpGetRequest()
    httpPostRequest()

    println("Hey there bro, I can hear you now.")
}

fun httpGetRequest() {
    // Specify the URL
    val url = URL("https://jsonplaceholder.typicode.com/users")

    // Open a connection
    val connection = url.openConnection() as HttpURLConnection

    try {
        connection.requestMethod = "GET"  // HTTP GET method

        // Check the response code
        if (connection.responseCode == HttpURLConnection.HTTP_OK) {
            val response = connection.inputStream.bufferedReader().use { it.readText() }

            val gson = Gson()
            val type = object : TypeToken<List<User>>() {}.type
            val listOfUsers = gson.fromJson<List<User>>(response, type)
            println("Response: ${listOfUsers.first()}")
        } else {
            println("Error: ${connection.responseCode}")
        }
    } catch (e: Exception) {
        println("Failed because: ${e.message}")
    } finally {
        connection.disconnect()  // Always close the connection
    }

}

fun httpPostRequest() {
    val url = URL("https://jsonplaceholder.typicode.com/users")
    /*val postData = """
        {
            "title": "foo",
            "body": "bar",
            "userId": 1
        }
    """.trimIndent()*/

    val geo = Geo("0.885", "0.27277")
    val address = Address("Eket", geo, "Grace Bill Road", "Suite", "524102")
    val company = Company("bs", "learn. Connect. Grow", "Fhenix Africa")
    val user = User(
        address = address,
        company = company,
        email = "christopherbartholomewokeke@gmail.com",
        id = 12345678,
        phone = "09012649483",
        name = "Christophy",
        website = "www.google.com",
        username = "christophy",
    )

    // Open a connection
    val connection = url.openConnection() as HttpURLConnection

    try {
        // Configure the connection
        connection.requestMethod = "PUT"
        connection.doOutput = true
        connection.setRequestProperty("Content-Type", "application/json")

        // Write the request body
        val outputWriter = OutputStreamWriter(connection.outputStream)

        val gson = Gson()
        val jsonString = gson.toJson(user, User::class.java)

        outputWriter.write(jsonString)
        outputWriter.flush()

        // Check the response code
        if (connection.responseCode == HttpURLConnection.HTTP_CREATED) {
            val response = connection.inputStream.bufferedReader().use { it.readText() }
            println("Response: $response")
        } else {
            println("Error: ${connection.responseCode}")
        }
    } finally {
        connection.disconnect()
    }
}

