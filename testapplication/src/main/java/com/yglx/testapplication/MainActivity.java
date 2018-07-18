package com.yglx.testapplication;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    IAddAidlInterface addService;
    boolean serviceConnected = false;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);
    }

    ServiceConnection mAddServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            addService = IAddAidlInterface.Stub.asInterface(service);
            serviceConnected = true;
            tv.setText("bind success");

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            serviceConnected =false;
        }
    };

    public void bindAddService(View view) {
        Intent intent = new Intent();
/*        intent.setAction("com.yglx.learnservice.myservice");
        intent.setPackage("com.yglx.learnservice");*/
        intent.setClassName("com.yglx.learnservice", "com.yglx.learnservice.MyService");
//        intent.setComponent(new ComponentName("com.yglx.learnservice", "com.yglx.learnservice.MyService"));
        bindService(intent, mAddServiceConnection, BIND_AUTO_CREATE);
    }

    public void serviceAdd(View view) {
        if(serviceConnected){
            EditText editText = findViewById(R.id.editText);
            String numStr = editText.getText().toString();
            int b = Integer.parseInt(numStr);


            int ans = 0;
            try {
               ans = addService.add(3, b);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            tv.setText(""+ans);
        }
    }
}
