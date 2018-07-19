/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: E:\\StudyBaseAn\\LeanService\\app\\src\\main\\aidl\\com\\yglx\\learnservice\\MessageReceiver.aidl
 */
package com.yglx.testapplication;
// Declare any non-default types here with import statements

import android.util.Log;

public interface MessageReceiver extends android.os.IInterface {
    /**
     * Local-side IPC implementation stub class.
     */
    public static abstract class Stub extends android.os.Binder implements MessageReceiver {
        private static final String DESCRIPTOR = "com.yglx.learnservice.MessageReceiver";

        /**
         * Construct the stub at attach it to the interface.
         */
        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        /**
         * Cast an IBinder object into an com.yglx.learnservice.MessageReceiver interface,
         * generating a proxy if needed.
         */
        public static MessageReceiver asInterface(android.os.IBinder obj) {
            if ((obj == null)) {
                return null;
            }
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin != null) && (iin instanceof MessageReceiver))) {
                return ((MessageReceiver) iin);
            }
            return new MessageReceiver.Stub.Proxy(obj);
        }

        @Override
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override
        public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException {
            Log.d("jw", "client receiver onTransact: Thread:"+Thread.currentThread().getId());
            switch (code) {
                case INTERFACE_TRANSACTION: {
                    reply.writeString(DESCRIPTOR);
                    return true;
                }
                case TRANSACTION_onMessageReceived: {
                    data.enforceInterface(DESCRIPTOR);
                    MessageModel _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = MessageModel.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    this.onMessageReceived(_arg0);
                    reply.writeNoException();
                    return true;
                }
            }
            return super.onTransact(code, data, reply, flags);
        }

        private static class Proxy implements MessageReceiver {
            private android.os.IBinder mRemote;

            Proxy(android.os.IBinder remote) {
                mRemote = remote;
            }

            @Override
            public android.os.IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }

            @Override
            public void onMessageReceived(MessageModel receiveMessage) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((receiveMessage != null)) {
                        _data.writeInt(1);
                        receiveMessage.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_onMessageReceived, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        static final int TRANSACTION_onMessageReceived = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    }

    public void onMessageReceived(MessageModel receiveMessage) throws android.os.RemoteException;
}
