package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class as implements au {
    private static boolean a;

    /* renamed from: a  reason: collision with other field name */
    private volatile int f99a = 0;

    /* renamed from: a  reason: collision with other field name */
    private Context f100a;

    /* renamed from: a  reason: collision with other field name */
    private ServiceConnection f101a;

    /* renamed from: a  reason: collision with other field name */
    private final Object f102a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private volatile String f103a = null;
    private volatile String b = null;

    /* renamed from: b  reason: collision with other field name */
    private volatile boolean f104b = false;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class a implements ServiceConnection {
        private a() {
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0052 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0073 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0030 */
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                as.this.f103a = b.a(iBinder);
                as.this.f104b = b.m255a(iBinder);
                as.this.b();
                as.this.f99a = 2;
                synchronized (as.this.f102a) {
                    as.this.f102a.notifyAll();
                }
            } catch (Exception unused) {
                as.this.b();
                as.this.f99a = 2;
                synchronized (as.this.f102a) {
                    as.this.f102a.notifyAll();
                }
            } catch (Throwable th) {
                as.this.b();
                as.this.f99a = 2;
                synchronized (as.this.f102a) {
                    as.this.f102a.notifyAll();
                    throw th;
                }
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* compiled from: Taobao */
    private static class b {
        static String a(IBinder iBinder) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(com.alipay.sdk.m.c.b.a);
                iBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        static boolean m255a(IBinder iBinder) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(com.alipay.sdk.m.c.b.a);
                boolean z = false;
                iBinder.transact(2, obtain, obtain2, 0);
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

    public as(Context context) {
        this.f100a = context;
        a();
    }

    @Override // com.xiaomi.push.au, com.xiaomi.push.au
    private void a() {
        boolean z;
        this.f101a = new a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        int i = 1;
        try {
            z = this.f100a.bindService(intent, this.f101a, 1);
        } catch (Exception unused) {
            z = false;
        }
        if (!z) {
            i = 2;
        }
        this.f99a = i;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
    private void a(String str) {
        if (this.f99a == 1 && Looper.myLooper() != Looper.getMainLooper()) {
            synchronized (this.f102a) {
                com.xiaomi.channel.commonutils.logger.b.m182a("huawei's " + str + " wait...");
                this.f102a.wait(3000);
            }
        }
    }

    public static boolean a(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hwid", 128);
            boolean z = (packageInfo.applicationInfo.flags & 1) != 0;
            a = packageInfo.versionCode >= 20602000;
            return z;
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b() {
        ServiceConnection serviceConnection = this.f101a;
        if (serviceConnection != null) {
            try {
                this.f100a.unbindService(serviceConnection);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.xiaomi.push.au, com.xiaomi.push.au
    /* renamed from: a  reason: collision with other method in class */
    public String m253a() {
        a("getOAID");
        return this.f103a;
    }

    @Override // com.xiaomi.push.au, com.xiaomi.push.au
    /* renamed from: a  reason: collision with other method in class */
    public boolean m254a() {
        return a;
    }
}
