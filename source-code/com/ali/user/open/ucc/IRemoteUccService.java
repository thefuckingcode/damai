package com.ali.user.open.ucc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ali.user.open.ucc.IRemoteUccCallback;
import java.util.Map;

/* compiled from: Taobao */
public interface IRemoteUccService extends IInterface {

    /* compiled from: Taobao */
    public static class Default implements IRemoteUccService {
        public IBinder asBinder() {
            return null;
        }

        @Override // com.ali.user.open.ucc.IRemoteUccService
        public void bind(String str, Map map, IRemoteUccCallback iRemoteUccCallback) throws RemoteException {
        }

        @Override // com.ali.user.open.ucc.IRemoteUccService
        public String getSession(String str) throws RemoteException {
            return null;
        }

        @Override // com.ali.user.open.ucc.IRemoteUccService
        public void logout(String str) throws RemoteException {
        }

        @Override // com.ali.user.open.ucc.IRemoteUccService
        public void logoutAll() throws RemoteException {
        }

        @Override // com.ali.user.open.ucc.IRemoteUccService
        public void trustLogin(String str, Map map, IRemoteUccCallback iRemoteUccCallback) throws RemoteException {
        }

        @Override // com.ali.user.open.ucc.IRemoteUccService
        public void unbind(String str, Map map, IRemoteUccCallback iRemoteUccCallback) throws RemoteException {
        }
    }

    /* compiled from: Taobao */
    public static abstract class Stub extends Binder implements IRemoteUccService {
        private static final String DESCRIPTOR = "com.ali.user.open.ucc.IRemoteUccService";
        static final int TRANSACTION_bind = 2;
        static final int TRANSACTION_getSession = 1;
        static final int TRANSACTION_logout = 5;
        static final int TRANSACTION_logoutAll = 6;
        static final int TRANSACTION_trustLogin = 3;
        static final int TRANSACTION_unbind = 4;

        /* access modifiers changed from: private */
        /* compiled from: Taobao */
        public static class Proxy implements IRemoteUccService {
            public static IRemoteUccService sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.ali.user.open.ucc.IRemoteUccService
            public void bind(String str, Map map, IRemoteUccCallback iRemoteUccCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeMap(map);
                    obtain.writeStrongBinder(iRemoteUccCallback != null ? iRemoteUccCallback.asBinder() : null);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().bind(str, map, iRemoteUccCallback);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.ali.user.open.ucc.IRemoteUccService
            public String getSession(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getSession(str);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ali.user.open.ucc.IRemoteUccService
            public void logout(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(5, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().logout(str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ali.user.open.ucc.IRemoteUccService
            public void logoutAll() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(6, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().logoutAll();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ali.user.open.ucc.IRemoteUccService
            public void trustLogin(String str, Map map, IRemoteUccCallback iRemoteUccCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeMap(map);
                    obtain.writeStrongBinder(iRemoteUccCallback != null ? iRemoteUccCallback.asBinder() : null);
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().trustLogin(str, map, iRemoteUccCallback);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ali.user.open.ucc.IRemoteUccService
            public void unbind(String str, Map map, IRemoteUccCallback iRemoteUccCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeMap(map);
                    obtain.writeStrongBinder(iRemoteUccCallback != null ? iRemoteUccCallback.asBinder() : null);
                    if (this.mRemote.transact(4, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().unbind(str, map, iRemoteUccCallback);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRemoteUccService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IRemoteUccService)) {
                return new Proxy(iBinder);
            }
            return (IRemoteUccService) queryLocalInterface;
        }

        public static IRemoteUccService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IRemoteUccService iRemoteUccService) {
            if (Proxy.sDefaultImpl != null || iRemoteUccService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iRemoteUccService;
            return true;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        String session = getSession(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(session);
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        bind(parcel.readString(), parcel.readHashMap(getClass().getClassLoader()), IRemoteUccCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        trustLogin(parcel.readString(), parcel.readHashMap(getClass().getClassLoader()), IRemoteUccCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        unbind(parcel.readString(), parcel.readHashMap(getClass().getClassLoader()), IRemoteUccCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        logout(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        logoutAll();
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    void bind(String str, Map map, IRemoteUccCallback iRemoteUccCallback) throws RemoteException;

    String getSession(String str) throws RemoteException;

    void logout(String str) throws RemoteException;

    void logoutAll() throws RemoteException;

    void trustLogin(String str, Map map, IRemoteUccCallback iRemoteUccCallback) throws RemoteException;

    void unbind(String str, Map map, IRemoteUccCallback iRemoteUccCallback) throws RemoteException;
}
