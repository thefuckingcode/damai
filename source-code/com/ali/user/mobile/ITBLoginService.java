package com.ali.user.mobile;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: Taobao */
public interface ITBLoginService extends IInterface {

    /* compiled from: Taobao */
    public static class Default implements ITBLoginService {
        public IBinder asBinder() {
            return null;
        }

        @Override // com.ali.user.mobile.ITBLoginService
        public String getLoginInfo() throws RemoteException {
            return null;
        }
    }

    /* compiled from: Taobao */
    public static abstract class Stub extends Binder implements ITBLoginService {
        private static final String DESCRIPTOR = "com.ali.user.mobile.ITBLoginService";
        static final int TRANSACTION_getLoginInfo = 1;

        /* access modifiers changed from: private */
        /* compiled from: Taobao */
        public static class Proxy implements ITBLoginService {
            public static ITBLoginService sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.ali.user.mobile.ITBLoginService
            public String getLoginInfo() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getLoginInfo();
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
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ITBLoginService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ITBLoginService)) {
                return new Proxy(iBinder);
            }
            return (ITBLoginService) queryLocalInterface;
        }

        public static ITBLoginService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ITBLoginService iTBLoginService) {
            if (Proxy.sDefaultImpl != null || iTBLoginService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iTBLoginService;
            return true;
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                String loginInfo = getLoginInfo();
                parcel2.writeNoException();
                parcel2.writeString(loginInfo);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    String getLoginInfo() throws RemoteException;
}
