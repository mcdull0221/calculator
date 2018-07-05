package com.example.s.calculatordemo;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.robotium.solo.Solo;

@SuppressWarnings("rawtypes")
public class anBlackTest extends ActivityInstrumentationTestCase2{
    private Solo solo;
    private static final String MainActivity = "com.backeytech.safetycloud.ui.login.LoginActivity";
    private static Class launcherActivityClass;

    static {
        try {
            launcherActivityClass = Class.forName(MainActivity);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    public anBlackTest() throws ClassNotFoundException {
        super(launcherActivityClass);
    }
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void clickLogin(){
        Activity act = solo.getCurrentActivity();
        int loginId =act.getResources().getIdentifier("sign_in_button","id",act.getPackageName());
        TextView loginView = (TextView) solo.getView(loginId);

        solo.clickLongOnView(loginView);
        assertTrue("enter success",solo.waitForText("最后刷新时间",1,3000));
    }



    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }
}

