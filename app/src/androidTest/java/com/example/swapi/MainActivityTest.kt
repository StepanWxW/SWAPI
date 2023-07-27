
import com.example.swapi.MainActivity
import com.example.swapi.R

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

class MainActivityTest {

    private lateinit var activityScenario: ActivityScenario<MainActivity>
    @Before
    fun setup() {
        activityScenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @After
    fun tearDown() {
        activityScenario.close()
    }

    @Test
    fun searchWithValidInput_shouldDisplayRecyclerView() {
        onView(withId(R.id.enterNameTextView)).perform(replaceText("Luke"))

        onView(withId(R.id.spinner)).perform(click())
        onView(withText("персонажу")).perform(click())

        onView(withId(R.id.startSearchButton)).perform(click())
        runBlocking {
            delay(5000)
        }
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()))
    }

    @Test
    fun searchWithInvalidInput_shouldDisplayErrorMessage() {
        onView(withId(R.id.enterNameTextView)).perform(replaceText("L"))

        onView(withId(R.id.spinner)).perform(click())
        onView(withText("персонажу")).perform(click())

        onView(withId(R.id.startSearchButton)).perform(click())

        onView(withId(R.id.textViewMessage)).check(matches(isDisplayed()))
        onView(withId(R.id.textViewMessage)).check(matches(withText("Введите больше 2 символов")))
    }

    @Test
    fun searchWithNoResults_shouldDisplayNoResultsMessage() {
        onView(withId(R.id.enterNameTextView)).perform(replaceText("NonExistent"))
        onView(withId(R.id.spinner)).perform(click())
        onView(withText("персонажу")).perform(click())

        onView(withId(R.id.startSearchButton)).perform(click())
        runBlocking {
            delay(5000)
        }
        onView(withId(R.id.textViewMessage)).check(matches(isDisplayed()))
        onView(withId(R.id.textViewMessage)).check(matches(withText("Нет таких персонажей")))
    }
    @Test
    fun displayStarshipListOnSuccessfulSearch() {
        onView(withId(R.id.enterNameTextView)).perform(replaceText("X-wing"))

        onView(withId(R.id.spinner)).perform(click())
        onView(withText("звездолету")).perform(click())

        onView(withId(R.id.startSearchButton)).perform(click())
        runBlocking {
            delay(5000)
        }
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()))
    }
}