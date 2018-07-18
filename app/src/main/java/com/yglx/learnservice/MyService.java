package com.yglx.learnservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class MyService extends Service {
    int initSum ;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        initSum = intent.getIntExtra("initSum", -1);
        Log.d("jw", "onBind: "+initSum);
        return remoteService;
    }

    IBinder remoteService = new IMyAidlInterface.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public int add(int a, int b) throws RemoteException {
            return a+b+initSum;
        }
    };
}