package com.udacity.nanodegree.bakingapp;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.nanodegree.bakingapp.ui.activity.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void openItem() throws Exception {
        onView(withId(R.id.refresh_layout)).check(matches(isDisplayed()));
        onView(withId(R.id.recipes_recycler)).check(matches(isDisplayed()));
       Thread.sleep(10000);

        onView(withId(R.id.recipes_recycler)).perform(
                RecyclerViewActions.actionOnItemAtPosition(0, ViewActions.click()));
        Espresso.pressBack();


    }
}


