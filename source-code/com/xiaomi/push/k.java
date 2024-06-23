package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class k {

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static final class a {
        private final String a;

        /* renamed from: a  reason: collision with other field name */
        private final boolean f808a;

        a(String str, boolean z) {
            this.a = str;
            this.f808a = z;
        }

        public String a() {
            return this.a;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class b implements ServiceConnection {
        private final LinkedBlockingQueue<IBinder> a;

        /* renamed from: a  reason: collision with other field name */
        boolean f809a;

        private b() {
            this.f809a = false;
            this.a = new LinkedBlockingQueue<>(1);
        }

        public IBinder a() {
            if (!this.f809a) {
                this.f809a = true;
                return this.a.poll(30000, TimeUnit.MILLISECONDS);
            }
            throw new IllegalStateException();
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.a.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class c implements IInterface {
        private IBinder a;

        public c(IBinder iBinder) {
            this.a = iBinder;
        }

        public String a() {
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

        public IBinder asBinder() {
            return this.a;
        }
    }

    public static a a(Context context) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            try {
                context.getPackageManager().getPackageInfo("com.android.vending", 0);
                b bVar = new b();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                if (context.bindService(intent, bVar, 1)) {
                    try {
                        IBinder a2 = bVar.a();
                        if (a2 != null) {
                            a aVar = new a(new c(a2).a(), false);
                            context.unbindService(bVar);
                            return aVar;
                        }
                        context.unbindService(bVar);
                    } catch (Exception e) {
                        throw e;
                    } catch (Throwable th) {
                        context.unbindService(bVar);
                        throw th;
                    }
                }
                throw new IOException("Google Play connection failed");
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
    }
}
