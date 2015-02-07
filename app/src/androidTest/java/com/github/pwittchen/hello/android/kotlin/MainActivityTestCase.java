package com.github.pwittchen.hello.android.kotlin;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.suitebuilder.annotation.MediumTest;

/**
 * This test cannot be written in Kotlin due to lack of possibility to call super() constructor
 * Related thread: http://stackoverflow.com/questions/27699184/in-kotlin-how-do-i-extend-a-class-that-has-multiple-constructors
 */
@MediumTest
public class MainActivityTestCase extends ActivityUnitTestCase<MainActivity> {

    public MainActivityTestCase() {
        super(MainActivity.class);
    }

    @MediumTest
    public void testHelloTextViewShouldHaveCorrectString() {
        // given
        MainActivity mainActivity = startActivity(new Intent(Intent.ACTION_MAIN), null, null);
        String expectedString = "Hello world from Kotlin app!";

        // when
        getInstrumentation().callActivityOnStart(mainActivity);
        getInstrumentation().callActivityOnResume(mainActivity);

        // then
        assertEquals(mainActivity.getHello().getText().toString(), expectedString);
        mainActivity.finish();
    }
}
