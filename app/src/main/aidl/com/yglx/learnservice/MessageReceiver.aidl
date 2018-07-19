// MessageReceiver.aidl
package com.yglx.learnservice;
import com.yglx.learnservice.MessageModel;

// Declare any non-default types here with import statements

interface MessageReceiver {
    void onMessageReceived(in MessageModel receiveMessage);
}
