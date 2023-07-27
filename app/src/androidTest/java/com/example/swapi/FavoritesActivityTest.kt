
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.swapi.FavoritesActivity
import com.example.swapi.R
import org.junit.After
import org.junit.Before
import org.junit.Test

class FavoritesActivityTest {
    private lateinit var activityScenario: ActivityScenario<FavoritesActivity>

    @Before
    fun setup() {
        activityScenario = ActivityScenario.launch(FavoritesActivity::class.java)
    }

    @After
    fun tearDown() {
        activityScenario.close()
    }

    @Test
    fun displayMessageWhenCharacterListEmpty() {
        onView(withId(R.id.textViewCharacter)).check(matches(withText("У вас нет сохраненных персонажей")))
    }

    @Test
    fun displayMessageWhenStarshipsListEmpty() {
        onView(withId(R.id.textViewStarship)).check(matches(withText("У вас нет сохраненных здездолетов")))
    }
}