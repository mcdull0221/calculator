package com.example.s.calculatordemo;

import android.test.ActivityInstrumentationTestCase2;
import com.robotium.solo.Solo;
import android.widget.Button;
import android.widget.TextView;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by s on 2017/3/29.
 */

public class MainActivityTest extends ActivityInstrumentationTestCase2 <MainActivity>{
    private Solo solo;

    public MainActivityTest() {
        super(MainActivity.class);
    }
    @Override
    protected void setUp() throws Exception{
        super.setUp();// 重载setup方法
        solo = new Solo(getInstrumentation(),getActivity());
    }
    public void testButton(){
        solo.waitForView(R.id.button_0);
        solo.clickOnButton("3");
        solo.clickOnButton("+");
        solo.clickOnButton("5");
        solo.clickOnButton("=");
        TextView outMsg = (TextView)solo.getView(R.id.input);
        assertEquals("8",outMsg.getText().toString());
    }

    @Override
    protected void tearDown() throws Exception{
        solo.finishOpenedActivities();//销毁app
    }

}