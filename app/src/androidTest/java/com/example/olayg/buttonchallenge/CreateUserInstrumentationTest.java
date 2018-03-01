package com.example.olayg.buttonchallenge;

import android.support.test.espresso.NoMatchingViewException;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.olayg.buttonchallenge.view.createuseractivity.CreateUser;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by olayg on 3/1/2018.
 */
@RunWith(AndroidJUnit4.class)
public class CreateUserInstrumentationTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Rule
    public ActivityTestRule<CreateUser> activityTestRule = new ActivityTestRule<>(CreateUser.class);

    @Test
    public void saveUserAfterFillingNewUserForm() throws NoMatchingViewException {
        String full_name = "Dennis Smith Jr";
        String email = "dsj@mavs.com";

        //find full name edit text and type it in
        onView(withId(R.id.etName)).perform(typeText(full_name), closeSoftKeyboard());

        //find email edit text and type it in
        onView(withId(R.id.etEmail)).perform(typeText(email), closeSoftKeyboard());

        //finish() is called if post is successful, which throws a NoMatchingViewException
        thrown.expect(NoMatchingViewException.class);
        //save user and check if we are back on home screen which would mean it was successful
        onView(withId(R.id.btnSaveUser)).perform(click());
        onView(withId(R.id.fabAddUser)).check(matches(allOf(isDescendantOfA(withId(R.id.layout_view_users)), isDisplayed())));
    }
}
