package com.alipay.sdk.m.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
public class b implements com.alipay.sdk.m.b.b {
    public static final String a = "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";
    public static final int b = 1;
    public static final int c = 2;

    /* renamed from: com.alipay.sdk.m.c.b$b  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static final class ServiceConnectionC0122b implements ServiceConnection {
        public boolean a;
        public final LinkedBlockingQueue<IBinder> b;

        public ServiceConnectionC0122b() {
            this.a = false;
            this.b = new LinkedBlockingQueue<>();
        }

        public IBinder a() throws InterruptedException {
            if (!this.a) {
                this.a = true;
                return this.b.poll(5, TimeUnit.SECONDS);
            }
            throw new IllegalStateException();
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* compiled from: Taobao */
    public static final class c implements IInterface {
        public IBinder a;

        public c(IBinder iBinder) {
            this.a = iBinder;
        }

        public IBinder asBinder() {
            return this.a;
        }

        public String d() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(b.a);
                this.a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public boolean e() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(b.a);
                boolean z = false;
                this.a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() != 0) {
                    z = true;
                }
                return z;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    @Override // com.alipay.sdk.m.b.b
    public String a(Context context) {
        ServiceConnectionC0122b bVar = new ServiceConnectionC0122b();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        if (context.bindService(intent, bVar, 1)) {
            try {
                return new c(bVar.a()).d();
            } catch (Exception unused) {
            } finally {
                context.unbindService(bVar);
            }
        }
        return null;
    }
}
