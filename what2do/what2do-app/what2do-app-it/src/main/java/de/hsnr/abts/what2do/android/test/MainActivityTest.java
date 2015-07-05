package de.hsnr.abts.what2do.android.test;

import android.test.ActivityInstrumentationTestCase2;
import de.hsnr.abts.what2do.android.*;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTest() {
        super(MainActivity.class);
    }

    public void testActivity() {
        MainActivity activity = getActivity();
        assertNotNull(activity);
    }
}

