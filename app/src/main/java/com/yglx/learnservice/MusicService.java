package com.yglx.learnservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MusicService extends Service {
    int serviceData = 0;
    public MusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new LocalBinder(this);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    public int getServiceData() {
        return serviceData;
    }
    public void addServiceData() {
        serviceData++;
    }


}
