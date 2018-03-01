package com.example.olayg.buttonchallenge;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.olayg.buttonchallenge.view.homescreen.HomeScreen;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by olayg on 3/1/2018.
 */
@RunWith(AndroidJUnit4.class)
public class HomeScreenInstrumentationTest {

    @Rule
    public ActivityTestRule<HomeScreen> activityTestRule = new ActivityTestRule<>(HomeScreen.class);

    @Test
    public void TestAddUserFab() {
        onView(withId(R.id.fabAddUser)).perform(click());
        onView(withId(R.id.input_user_full_name)).check(matches(allOf(isDescendantOfA(withId(R.id.layout_create_new_user)), isDisplayed())));
    }
}
