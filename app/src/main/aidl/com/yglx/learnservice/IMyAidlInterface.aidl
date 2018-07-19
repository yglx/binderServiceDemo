// IMyAidlInterface.aidl
package com.yglx.learnservice;
import com.yglx.learnservice.MessageModel;
// Declare any non-default types here with import statements

interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

    int add(int a,int b);

    void sendMessage(in MessageModel messageModle);

    List<MessageModel> getMessage();

}
