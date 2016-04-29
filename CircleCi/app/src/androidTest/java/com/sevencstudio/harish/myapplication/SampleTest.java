package com.sevencstudio.harish.myapplication;

import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by harish on 29/04/16.
 */
public class SampleTest extends ActivityInstrumentationTestCase2<MainActivity>{
    public SampleTest() {
        super(MainActivity.class);
    }

    SoloWrapper soloWrapper;
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        soloWrapper = new SoloWrapper(getInstrumentation(),getActivity());


    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void test() {

     soloWrapper.sleep(1000);
        soloWrapper.clickButton(R.id.toast);
        soloWrapper.sleep(1000);

        assertEquals(false,true);

    }
}
