package com.yglx.learnservice;

import android.os.Binder;

public class LocalBinder extends Binder {
    MusicService mService;

    public LocalBinder(MusicService service) {
        mService = service;
    }

    public MusicService getService() {
        return mService;
    }
}
