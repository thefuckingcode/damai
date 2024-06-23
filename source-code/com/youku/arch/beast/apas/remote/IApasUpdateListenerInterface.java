package com.youku.arch.beast.apas.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public interface IApasUpdateListenerInterface extends IInterface {

    /* compiled from: Taobao */
    public static class Default implements IApasUpdateListenerInterface {
        private static transient /* synthetic */ IpChange $ipChange;

        public IBinder asBinder() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1689913251")) {
                return null;
            }
            return (IBinder) ipChange.ipc$dispatch("-1689913251", new Object[]{this});
        }

        @Override // com.youku.arch.beast.apas.remote.IApasUpdateListenerInterface
        public void onConfigUpdate(String str, String str2, String str3) throws RemoteException {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-202398192")) {
                ipChange.ipc$dispatch("-202398192", new Object[]{this, str, str2, str3});
            }
        }
    }

    /* compiled from: Taobao */
    public static abstract class Stub extends Binder implements IApasUpdateListenerInterface {
        private static transient /* synthetic */ IpChange $ipChange = null;
        private static final String DESCRIPTOR = "com.youku.arch.beast.apas.remote.IApasUpdateListenerInterface";
        static final int TRANSACTION_onConfigUpdate = 1;

        /* compiled from: Taobao */
        public static class Proxy implements IApasUpdateListenerInterface {
            private static transient /* synthetic */ IpChange $ipChange;
            public static IApasUpdateListenerInterface sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "1759771274")) {
                    return this.mRemote;
                }
                return (IBinder) ipChange.ipc$dispatch("1759771274", new Object[]{this});
            }

            public String getInterfaceDescriptor() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-1051134205")) {
                    return Stub.DESCRIPTOR;
                }
                return (String) ipChange.ipc$dispatch("-1051134205", new Object[]{this});
            }

            @Override // com.youku.arch.beast.apas.remote.IApasUpdateListenerInterface
            public void onConfigUpdate(String str, String str2, String str3) throws RemoteException {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1488569725")) {
                    ipChange.ipc$dispatch("-1488569725", new Object[]{this, str, str2, str3});
                    return;
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onConfigUpdate(str, str2, str3);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IApasUpdateListenerInterface asInterface(IBinder iBinder) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1369497676")) {
                return (IApasUpdateListenerInterface) ipChange.ipc$dispatch("-1369497676", new Object[]{iBinder});
            } else if (iBinder == null) {
                return null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
                if (queryLocalInterface == null || !(queryLocalInterface instanceof IApasUpdateListenerInterface)) {
                    return new Proxy(iBinder);
                }
                return (IApasUpdateListenerInterface) queryLocalInterface;
            }
        }

        public static IApasUpdateListenerInterface getDefaultImpl() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-870912823") ? (IApasUpdateListenerInterface) ipChange.ipc$dispatch("-870912823", new Object[0]) : Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IApasUpdateListenerInterface iApasUpdateListenerInterface) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2133436579")) {
                return ((Boolean) ipChange.ipc$dispatch("-2133436579", new Object[]{iApasUpdateListenerInterface})).booleanValue();
            } else if (Proxy.sDefaultImpl != null || iApasUpdateListenerInterface == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iApasUpdateListenerInterface;
                return true;
            }
        }

        public IBinder asBinder() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "81819892")) {
                return this;
            }
            return (IBinder) ipChange.ipc$dispatch("81819892", new Object[]{this});
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-732914336")) {
                return ((Boolean) ipChange.ipc$dispatch("-732914336", new Object[]{this, Integer.valueOf(i), parcel, parcel2, Integer.valueOf(i2)})).booleanValue();
            } else if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onConfigUpdate(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    void onConfigUpdate(String str, String str2, String str3) throws RemoteException;
}
