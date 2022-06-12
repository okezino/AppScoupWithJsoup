package com.example.truecallerappokeh

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.truecallerappokeh.presentation.view.MainActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun confirmAllViewsAreVisibleAndViewStateRespondToButtonClick(): Unit = runBlocking{
        /**
         * Validate Visibility of all views that re suppose to be shown
         */
        onView(withId(R.id.taskA_value)).check(matches(isDisplayed()))
        onView(withId(R.id.taskB_value)).check(matches(isDisplayed()))
        onView(withId(R.id.taskC_value)).check(matches(isDisplayed()))
        onView(withId(R.id.taskA_placeholder)).check(matches(isDisplayed()))
        onView(withId(R.id.taskB_placeholder)).check(matches(isDisplayed()))
        onView(withId(R.id.taskC_placeholder)).check(matches(isDisplayed()))
        onView(withId(R.id.fetchData)).check(matches(isDisplayed()))

        /**
         * Perform a Click function and ensure state of the view that needs to be changed works according
         */
        delay(500)
        onView(withId(R.id.fetchData)).perform(click())
        onView(withId(R.id.taskA_value)).check(matches(withText("Loading...")))
        onView(withId(R.id.taskB_value)).check(matches(withText("Loading...")))
        onView(withId(R.id.taskC_value)).check(matches(withText("Loading...")))

    }
}