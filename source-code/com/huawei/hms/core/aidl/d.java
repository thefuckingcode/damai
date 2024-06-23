package com.huawei.hms.core.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: Taobao */
public interface d extends IInterface {
    void a(b bVar, c cVar) throws RemoteException;

    /* compiled from: Taobao */
    public static abstract class a extends Binder implements d {

        /* access modifiers changed from: private */
        /* renamed from: com.huawei.hms.core.aidl.d$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public static class C0176a implements d {
            public static d b;
            private IBinder a;

            C0176a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.huawei.hms.core.aidl.d
            public void a(b bVar, c cVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.hms.core.aidl.IAIDLInvoke");
                    if (bVar != null) {
                        obtain.writeInt(1);
                        bVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
                    if (this.a.transact(2, obtain, null, 1) || a.a() == null) {
                        obtain.recycle();
                    } else {
                        a.a().a(bVar, cVar);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.a;
            }
        }

        public static d a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.core.aidl.IAIDLInvoke");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof d)) {
                return new C0176a(iBinder);
            }
            return (d) queryLocalInterface;
        }

        public static d a() {
            return C0176a.b;
        }
    }
}
