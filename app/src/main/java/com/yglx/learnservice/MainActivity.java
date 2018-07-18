package com.yglx.learnservice;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    TextView mTextView;
    MusicService mService;
    IMyAidlInterface mRemoteService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.tv);

    }


    public void bindService(View view) {
        bindService(new Intent(MainActivity.this,MusicService.class),mServiceConnection,BIND_AUTO_CREATE );
    }
    ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "onServiceConnected: "+name);
            mService = ((LocalBinder)service).getService();
            mTextView.setText("serviceData:"+mService.getServiceData());
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "onServiceDisconnected: ");
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        unbindService(mServiceConnection);
        super.onDestroy();
    }

    public void serviceAdd(View view) {
        try {
            mTextView.setText("remote add:"+mRemoteService.add(1,8));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void bindRemoteService(View view) {
        Intent intent = new Intent(MainActivity.this,MyService.class);
        intent.putExtra("initSum", 10);
        bindService(intent,mRemoteServiceConnection,BIND_AUTO_CREATE );
    }
    ServiceConnection mRemoteServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mRemoteService = IMyAidlInterface.Stub.asInterface(service);

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "onServiceDisconnected: ");
        }
    };
}