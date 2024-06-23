package com.google.android.aidl;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: Taobao */
public class BaseProxy implements IInterface {
    private final String mDescriptor;
    private final IBinder mRemote;

    protected BaseProxy(IBinder iBinder, String str) {
        this.mRemote = iBinder;
        this.mDescriptor = str;
    }

    public IBinder asBinder() {
        return this.mRemote;
    }

    /* access modifiers changed from: protected */
    public Parcel obtainAndWriteInterfaceToken() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.mDescriptor);
        return obtain;
    }

    /* access modifiers changed from: protected */
    public Parcel transactAndReadException(int i, Parcel parcel) throws RemoteException {
        parcel = Parcel.obtain();
        try {
            this.mRemote.transact(i, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e) {
            throw e;
        } finally {
            parcel.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public void transactAndReadExceptionReturnVoid(int i, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.mRemote.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public void transactOneway(int i, Parcel parcel) throws RemoteException {
        try {
            this.mRemote.transact(i, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
