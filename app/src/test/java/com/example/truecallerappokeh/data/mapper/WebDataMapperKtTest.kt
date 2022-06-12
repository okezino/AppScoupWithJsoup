package com.example.truecallerappokeh.data.mapper

import org.jsoup.Jsoup
import org.junit.Assert.*
import org.junit.Test

class WebDataMapperKtTest {

    private var mutableList = mutableListOf(
        "<p>", "Have", "you", "ever", "wondered", "how", "it", "is", "to", "be",
        "an", "Android", "Developer", "that", "works", "on", "an", "app", "with", "over", "250",
        "Million", "users?"
    )

    private val element = Jsoup.parse("<p> This is a boy </p>").getElementsByTag("p").first()

    @Test
    fun `get the 10th character in a list of character sequence`() {
        assertEquals(getFirstTask(mutableList), "be")
    }

    @Test
    fun `get Every 10th Character in a list of character sequence`() {
        assertEquals(getSecTask(mutableList), arrayListOf("be", "over"))
    }

    @Test
    fun `get Count of word in a list of character sequence`() {
        assertEquals(
            getThirdTask(mutableList), mapOf(
                Pair("an", 2),
                Pair("<p>", 1),
                Pair("Have", 1),
                Pair("you", 1),
                Pair("ever", 1),
                Pair("wondered", 1),
                Pair("how", 1),
                Pair("it", 1),
                Pair("is", 1),
                Pair("to", 1),
                Pair("be", 1),
                Pair("Android", 1),
                Pair("Developer", 1),
                Pair("that", 1),
                Pair("works", 1),
                Pair("on", 1),
                Pair("app", 1),
                Pair("with", 1),
                Pair("over", 1),
                Pair("250", 1),
                Pair("Million", 1),
                Pair("app", 1),
                Pair("users?", 1)
            )
        )
    }

    @Test
    fun `get String with Tags from an Html Element to a List of String`() {
        assertEquals(getStringElement(element), listOf("<p>", "This", "is", "a", "boy", "</p>"))
    }

}