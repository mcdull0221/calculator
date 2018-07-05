package com.tencent.news;

import android.app.Activity;
import com.robotium.recorder.executor.Executor;

@SuppressWarnings("rawtypes")
public class SplashActivityExecutor extends Executor {

	@SuppressWarnings("unchecked")
	public SplashActivityExecutor() throws Exception {
		super((Class<? extends Activity>) Class.forName("com.tencent.news.activity.SplashActivity"), null, new android.R.id(), false, true, "1489463295877");
	}

	public void setUp() throws Exception { 
		super.setUp();
	}
}
