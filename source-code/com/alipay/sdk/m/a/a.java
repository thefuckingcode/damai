package com.alipay.sdk.m.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: Taobao */
public interface a extends IInterface {

    /* renamed from: com.alipay.sdk.m.a.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static abstract class AbstractBinderC0119a extends Binder implements a {

        /* renamed from: com.alipay.sdk.m.a.a$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public static class C0120a implements a {
            public IBinder a;

            public C0120a(IBinder iBinder) {
                this.a = iBinder;
            }

            public String a(String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
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

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C0120a(iBinder);
            }
            return (a) queryLocalInterface;
        }
    }

    /* compiled from: Taobao */
    public class b {
        public static boolean a;
        public static boolean b;
    }

    /* compiled from: Taobao */
    public class c {
        public a a = null;
        public String b = null;
        public String c = null;
        public final Object d = new Object();
        public ServiceConnection e = new ServiceConnectionC0121a();

        /* renamed from: com.alipay.sdk.m.a.a$c$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public class ServiceConnectionC0121a implements ServiceConnection {
            public ServiceConnectionC0121a() {
            }

            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                c.this.a = AbstractBinderC0119a.a(iBinder);
                synchronized (c.this.d) {
                    c.this.d.notify();
                }
            }

            public void onServiceDisconnected(ComponentName componentName) {
                c.this.a = null;
            }
        }

        /* compiled from: Taobao */
        public static class b {
            public static final c a = new c(null);
        }

        public /* synthetic */ c(ServiceConnectionC0121a aVar) {
        }

        public boolean a(Context context) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 0);
                if (Build.VERSION.SDK_INT >= 28) {
                    if (packageInfo == null || packageInfo.getLongVersionCode() < 1) {
                        return false;
                    }
                    return true;
                } else if (packageInfo == null || packageInfo.versionCode < 1) {
                    return false;
                } else {
                    return true;
                }
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                return false;
            }
        }

        public final String b(Context context, String str) {
            Signature[] signatureArr;
            if (TextUtils.isEmpty(this.b)) {
                this.b = context.getPackageName();
            }
            if (TextUtils.isEmpty(this.c)) {
                String str2 = null;
                try {
                    signatureArr = context.getPackageManager().getPackageInfo(this.b, 64).signatures;
                } catch (PackageManager.NameNotFoundException e2) {
                    e2.printStackTrace();
                    signatureArr = null;
                }
                if (signatureArr != null && signatureArr.length > 0) {
                    byte[] byteArray = signatureArr[0].toByteArray();
                    try {
                        MessageDigest instance = MessageDigest.getInstance("SHA1");
                        if (instance != null) {
                            byte[] digest = instance.digest(byteArray);
                            StringBuilder sb = new StringBuilder();
                            for (byte b2 : digest) {
                                sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                            }
                            str2 = sb.toString();
                        }
                    } catch (NoSuchAlgorithmException e3) {
                        e3.printStackTrace();
                    }
                }
                this.c = str2;
            }
            String a2 = ((AbstractBinderC0119a.C0120a) this.a).a(this.b, this.c, str);
            return TextUtils.isEmpty(a2) ? "" : a2;
        }

        public synchronized String a(Context context, String str) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                throw new IllegalStateException("Cannot run on MainThread");
            } else if (this.a == null) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
                if (context.bindService(intent, this.e, 1)) {
                    synchronized (this.d) {
                        try {
                            this.d.wait(3000);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                if (this.a == null) {
                    return "";
                }
                try {
                    return b(context, str);
                } catch (RemoteException e3) {
                    e3.printStackTrace();
                    return "";
                }
            } else {
                try {
                    return b(context, str);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                    return "";
                }
            }
        }
    }
}
