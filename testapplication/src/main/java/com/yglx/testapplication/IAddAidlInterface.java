/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: E:\\StudyBaseAn\\LeanService\\testapplication\\src\\main\\aidl\\com\\yglx\\testapplication\\IAddAidlInterface.aidl
 */
package com.yglx.testapplication;
// Declare any non-default types here with import statements

import android.util.Log;

public interface IAddAidlInterface extends android.os.IInterface {
    /**
     * Local-side IPC implementation stub class.
     */
    public static abstract class Stub extends android.os.Binder implements IAddAidlInterface {
        private static final String DESCRIPTOR = "com.yglx.learnservice.IMyAidlInterface";

        /**
         * Construct the stub at attach it to the interface.
         */
        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        /**
         * Cast an IBinder object into an com.yglx.testapplication.IAddAidlInterface interface,
         * generating a proxy if needed.
         */
        public static IAddAidlInterface asInterface(android.os.IBinder obj) {
            if ((obj == null)) {
                return null;
            }
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin != null) && (iin instanceof IAddAidlInterface))) {
                return ((IAddAidlInterface) iin);
            }
            return new Proxy(obj);
        }

        @Override
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override
        public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException {
            Log.d("jw", "aidl onTransact: Thread:"+Thread.currentThread().getId());
            switch (code) {
                case INTERFACE_TRANSACTION: {
                    reply.writeString(DESCRIPTOR);
                    return true;
                }
                case TRANSACTION_basicTypes: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    long _arg1;
                    _arg1 = data.readLong();
                    boolean _arg2;
                    _arg2 = (0 != data.readInt());
                    float _arg3;
                    _arg3 = data.readFloat();
                    double _arg4;
                    _arg4 = data.readDouble();
                    String _arg5;
                    _arg5 = data.readString();
                    this.basicTypes(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_add: {
                    data.enforceInterface(DESCRIPTOR);
                    Log.d("jw", "aidl stub onTransact: Thread:"+Thread.currentThread().getId());
                    int _arg0;
                    _arg0 = data.readInt();
                    int _arg1;
                    _arg1 = data.readInt();
                    int _result = this.add(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_sendMessage: {
                    data.enforceInterface(DESCRIPTOR);
                    MessageModel _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = MessageModel.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    this.sendMessage(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getMessage: {
                    data.enforceInterface(DESCRIPTOR);
                    java.util.List<MessageModel> _result = this.getMessage();
                    reply.writeNoException();
                    reply.writeTypedList(_result);
                    return true;
                }
            }
            return super.onTransact(code, data, reply, flags);
        }

        private static class Proxy implements IAddAidlInterface {
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

            /**
             * Demonstrates some basic types that you can use as parameters
             * and return values in AIDL.
             */
            @Override
            public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(anInt);
                    _data.writeLong(aLong);
                    _data.writeInt(((aBoolean) ? (1) : (0)));
                    _data.writeFloat(aFloat);
                    _data.writeDouble(aDouble);
                    _data.writeString(aString);
                    mRemote.transact(Stub.TRANSACTION_basicTypes, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public int add(int a, int b) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    Log.d("jw", "aidl proxy add: "+Thread.currentThread().getId());
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(a);
                    _data.writeInt(b);
                    mRemote.transact(Stub.TRANSACTION_add, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            @Override
            public void sendMessage(MessageModel messageModle) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((messageModle != null)) {
                        _data.writeInt(1);
                        messageModle.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_sendMessage, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
            @Override
            public java.util.List<MessageModel> getMessage() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                java.util.List<MessageModel> _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getMessage, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.createTypedArrayList(MessageModel.CREATOR);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            @Override
            public void registerReceiver(MessageReceiver messageReceiver) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((messageReceiver != null)) ? (messageReceiver.asBinder()) : (null)));
                    mRemote.transact(Stub.TRANSACTION_registerReceiver, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void unregisterReceiver(MessageReceiver messageReceiver) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((messageReceiver != null)) ? (messageReceiver.asBinder()) : (null)));
                    mRemote.transact(Stub.TRANSACTION_unregisterReceiver, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        static final int TRANSACTION_basicTypes = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
        static final int TRANSACTION_add = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
        static final int TRANSACTION_sendMessage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
        static final int TRANSACTION_getMessage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
        static final int TRANSACTION_registerReceiver = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
        static final int TRANSACTION_unregisterReceiver = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
    }

    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws android.os.RemoteException;

    public int add(int a, int b) throws android.os.RemoteException;

    public void sendMessage(MessageModel messageModle) throws android.os.RemoteException;

    public java.util.List<MessageModel> getMessage() throws android.os.RemoteException;

    public void registerReceiver(MessageReceiver messageReceiver) throws android.os.RemoteException;

    public void unregisterReceiver(MessageReceiver messageReceiver) throws android.os.RemoteException;

}
