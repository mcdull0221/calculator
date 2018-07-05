package com.example.s.calculatordemo;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;
import com.robotium.solo.Solo;

public class testBlack extends ActivityInstrumentationTestCase2<MainActivity> {
    private Solo solo;
    private static final String MainActivity = "com.example.s.calculatordemo.MainActivity";
    private static Class launchActivityClass;

    static {
        try{
            launchActivityClass=Class.forName(MainActivity);
        }
        catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
    @SuppressWarnings("unchecked")//它对被批注的代码元素内部的某些警告保持静默。
    public testBlack()throws ClassNotFoundException{
        super(launchActivityClass);
    }
    @Override
    protected void setUp() throws Exception{
        super.setUp();// 重载setup方法
        solo = new Solo(getInstrumentation(),getActivity());
    }
    public void testButton(){
        Activity act = solo.getCurrentActivity();
        int btnID=act.getResources().getIdentifier("button_0","id",act.getPackageName());
        solo.waitForView(btnID);
        solo.clickOnButton("3");
        solo.clickOnButton("+");
        solo.clickOnButton("5");
        solo.clickOnButton("=");

        int textID = act.getResources().getIdentifier("input","id",act.getPackageName());
        TextView outMsg = (TextView)solo.getView(textID);
        assertEquals("8",outMsg.getText().toString());
    }

    @Override
    protected void tearDown() throws Exception{
        solo.finishOpenedActivities();//销毁app
    }
}

