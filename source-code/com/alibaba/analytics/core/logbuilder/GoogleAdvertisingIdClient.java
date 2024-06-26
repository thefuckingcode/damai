package com.alibaba.analytics.core.logbuilder;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.alibaba.analytics.utils.Logger;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
public class GoogleAdvertisingIdClient {
    private static b a;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class AdvertisingInterface implements IInterface {
        private IBinder a;

        public AdvertisingInterface(IBinder iBinder) {
            this.a = iBinder;
        }

        public IBinder asBinder() {
            return this.a;
        }

        public String d() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public boolean e(boolean z) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean z2 = true;
                obtain.writeInt(z ? 1 : 0);
                this.a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z2 = false;
                }
                return z2;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    /* compiled from: Taobao */
    public static final class b {
        private final String a;
        private final boolean b;

        b(String str, boolean z) {
            this.a = str;
            this.b = z;
        }

        public String a() {
            return this.a;
        }

        public boolean b() {
            return this.b;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class c implements ServiceConnection {
        boolean a;
        private final LinkedBlockingQueue<IBinder> b;

        private c() {
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

    static b a() {
        return a;
    }

    public static synchronized void b(Context context) {
        synchronized (GoogleAdvertisingIdClient.class) {
            if (a == null) {
                try {
                    c cVar = new c();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    if (context.bindService(intent, cVar, 1)) {
                        try {
                            IBinder a2 = cVar.a();
                            if (a2 != null) {
                                AdvertisingInterface advertisingInterface = new AdvertisingInterface(a2);
                                a = new b(advertisingInterface.d(), advertisingInterface.e(true));
                            }
                        } catch (Exception e) {
                            Logger.u("GoogleAdvertisingIdClient", e, new Object[0]);
                        } catch (Throwable th) {
                            context.unbindService(cVar);
                            throw th;
                        }
                        context.unbindService(cVar);
                    }
                } catch (Throwable unused) {
                }
                if (a == null) {
                    a = new b("", true);
                }
            }
        }
    }
}
