package com.yglx.learnservice;

import android.app.Application;
import android.util.Log;

public class App extends Application {
    @Override
    public void onCreate() {
        Log.d("jw", "server Application onCreate: "+Thread.currentThread().getId());
        super.onCreate();
    }
}
