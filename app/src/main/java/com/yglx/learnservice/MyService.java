package com.yglx.learnservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MyService extends Service {
    int initSum ;
    private static final String TAG = "jw";

    List<MessageModel> mMessageModels = new ArrayList<>();

    private RemoteCallbackList<MessageReceiver> mRemoteCallbackList = new RemoteCallbackList<>();

    public MyService() {
        Log.d(TAG, "MyService: Thread:"+Thread.currentThread().getId());
    }

    @Override
    public IBinder onBind(Intent intent) {
        initSum = intent.getIntExtra("initSum", -1);
        Log.d("jw", "onBind: Thread:"+Thread.currentThread().getId());
        return remoteService;
    }

    IBinder remoteService = new IMyAidlInterface.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public int add(int a, int b) throws RemoteException {
            Log.d("jw", "add thread: "+Thread.currentThread().getId());
            return a+b+initSum;
        }

        @Override
        public void sendMessage(MessageModel messageModle) throws RemoteException {
            synchronized (mMessageModels) {
                mMessageModels.add(messageModle);
            }
            int count = mRemoteCallbackList.beginBroadcast();
            for (int i = 0; i < count; i++) {
                MessageReceiver receiver = mRemoteCallbackList.getBroadcastItem(i);
                if (receiver != null) {
                    receiver.onMessageReceived(messageModle);
                }
            }
            mRemoteCallbackList.finishBroadcast();
        }

        @Override
        public List<MessageModel> getMessage() throws RemoteException {
            return mMessageModels;
        }

        @Override
        public void registerReceiver(MessageReceiver messageReceiver) throws RemoteException {
            mRemoteCallbackList.register(messageReceiver);
        }

        @Override
        public void unregisterReceiver(MessageReceiver messageReceiver) throws RemoteException {
            mRemoteCallbackList.unregister(messageReceiver);
        }
    };
}
