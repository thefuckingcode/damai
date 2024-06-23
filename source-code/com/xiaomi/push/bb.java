package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import java.security.MessageDigest;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class bb implements au {
    private static boolean a;

    /* renamed from: a  reason: collision with other field name */
    private volatile int f122a = 0;

    /* renamed from: a  reason: collision with other field name */
    private Context f123a;

    /* renamed from: a  reason: collision with other field name */
    private ServiceConnection f124a;

    /* renamed from: a  reason: collision with other field name */
    private volatile a f125a = null;

    /* renamed from: a  reason: collision with other field name */
    private final Object f126a = new Object();

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class a {

        /* renamed from: a  reason: collision with other field name */
        String f127a;
        String b;
        String c;
        String d;

        private a() {
            this.f127a = null;
            this.b = null;
            this.c = null;
            this.d = null;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public class b implements ServiceConnection {
        private b() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (bb.this.f125a == null) {
                new Thread(new bd(this, iBinder)).start();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class c {
        static String a(IBinder iBinder, String str, String str2, String str3) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                obtain.writeString(str);
                obtain.writeString(str2);
                obtain.writeString(str3);
                iBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public bb(Context context) {
        this.f123a = context;
        a();
    }

    @Override // com.xiaomi.push.au, com.xiaomi.push.au
    private void a() {
        boolean z;
        this.f124a = new b();
        Intent intent = new Intent();
        intent.setClassName("com.heytap.openid", "com.heytap.openid.IdentifyService");
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        int i = 1;
        try {
            z = this.f123a.bindService(intent, this.f124a, 1);
        } catch (Exception unused) {
            z = false;
        }
        if (!z) {
            i = 2;
        }
        this.f122a = i;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
    private void a(String str) {
        if (this.f122a == 1 && Looper.myLooper() != Looper.getMainLooper()) {
            synchronized (this.f126a) {
                com.xiaomi.channel.commonutils.logger.b.m182a("oppo's " + str + " wait...");
                this.f126a.wait(3000);
            }
        }
    }

    public static boolean a(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 128);
            if (packageInfo != null) {
                long longVersionCode = Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : (long) packageInfo.versionCode;
                boolean z = (packageInfo.applicationInfo.flags & 1) != 0;
                a = longVersionCode >= 1;
                if (z) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String b() {
        byte[] digest;
        try {
            Signature[] signatureArr = this.f123a.getPackageManager().getPackageInfo(this.f123a.getPackageName(), 64).signatures;
            MessageDigest instance = MessageDigest.getInstance("SHA1");
            StringBuilder sb = new StringBuilder();
            for (byte b2 : instance.digest(signatureArr[0].toByteArray())) {
                sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: b  reason: collision with other method in class */
    private void m276b() {
        ServiceConnection serviceConnection = this.f124a;
        if (serviceConnection != null) {
            try {
                this.f123a.unbindService(serviceConnection);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.xiaomi.push.au, com.xiaomi.push.au
    /* renamed from: a  reason: collision with other method in class */
    public String m277a() {
        a("getOAID");
        if (this.f125a == null) {
            return null;
        }
        return this.f125a.b;
    }

    @Override // com.xiaomi.push.au, com.xiaomi.push.au
    /* renamed from: a  reason: collision with other method in class */
    public boolean m278a() {
        return a;
    }
}
