package com.uc.sandboxExport;

import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.analytics.core.network.NetworkUtil;
import com.uc.crashsdk.export.CrashApi;
import com.uc.sandboxExport.IChildProcessSetup;
import com.uc.sandboxExport.helper.b;
import com.uc.sandboxExport.helper.c;
import com.youku.arch.solid.monitor.SolidMonitor;
import dalvik.system.DexFile;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import tb.jl1;

@Api
/* compiled from: Taobao */
public class SandboxedProcessService extends Service {
    static final /* synthetic */ boolean a = true;
    private final String b = "SandboxedProcessService";
    private String c = "SandboxedProcessService";
    private boolean d;
    private boolean e = false;
    private Constructor<?> f;
    private Method g;
    private Method h;
    private Method i;
    private IBinder j;
    private Object k;
    private Intent l;
    private final IChildProcessSetup.Stub m = new i(this);
    private String n;
    private int o;

    /* access modifiers changed from: protected */
    public void init(ParcelFileDescriptor parcelFileDescriptor, Parcelable[] parcelableArr, ParcelFileDescriptor parcelFileDescriptor2) {
        DexFileClassLoader dexFileClassLoader;
        Class<?> cls;
        Method method;
        Method method2;
        Class<?> cls2;
        DexFile dexFile;
        DexFileClassLoader dexFileClassLoader2;
        Method method3;
        if (!this.d) {
            this.e = b.a();
            c.a(this.c, "doInit 1/4 - initCrashSdkIfNeeded, crashFD: %s", parcelFileDescriptor2);
            if (a || parcelFileDescriptor2 != null) {
                if (parcelFileDescriptor2 != null) {
                    try {
                        int i2 = CrashApi.e;
                        Object invoke = CrashApi.class.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
                        if (invoke != null) {
                            try {
                                method3 = CrashApi.class.getDeclaredMethod("setHostFd", ParcelFileDescriptor.class);
                            } catch (Exception unused) {
                                method3 = CrashApi.class.getDeclaredMethod("setIsolatedHostFd", ParcelFileDescriptor.class);
                            }
                            method3.invoke(invoke, parcelFileDescriptor2);
                        }
                    } catch (Throwable th) {
                        c.a(this.c, "initCrashSdkIfNeeded: init crashsdk failed.", th);
                    }
                }
                c.a(this.c, "doInit 2/4 - initServiceClassIfNeeded, dexFd: %s, libFdInfos: %s", parcelFileDescriptor, String.valueOf(parcelableArr));
                String stringExtra = this.l.getStringExtra("dex.path");
                String stringExtra2 = this.l.getStringExtra("odex.path");
                String stringExtra3 = this.l.getStringExtra("lib.path");
                String stringExtra4 = this.l.getStringExtra("source.dir");
                String stringExtra5 = this.l.getStringExtra("source.dir.prior");
                a(Switches.ENABLE_RENDERER_DEBUG_LOG, false);
                if (stringExtra == null || stringExtra.length() == 0) {
                    dexFileClassLoader = null;
                } else {
                    try {
                        dexFile = (!this.e || stringExtra5 == null || !new File(stringExtra5).exists()) ? null : new DexFile(stringExtra5);
                    } catch (Throwable unused2) {
                        dexFile = null;
                    }
                    try {
                        dexFileClassLoader2 = new DexFileClassLoader(stringExtra, stringExtra2, stringExtra3, getClass().getClassLoader(), parcelFileDescriptor, dexFile == null ? stringExtra4 : stringExtra5, dexFile);
                    } catch (Throwable th2) {
                        a("new DexFileClassLoader failed.", th2);
                        dexFileClassLoader2 = null;
                    }
                    if (parcelFileDescriptor != null && this.e) {
                        this.l.putExtra("isolated", true);
                    }
                    dexFileClassLoader = dexFileClassLoader2;
                }
                String stringExtra6 = this.l.getStringExtra("info.core.version");
                String stringExtra7 = this.l.getStringExtra("info.sdk.version");
                String a2 = a(dexFileClassLoader, "webviewSdkVersion");
                String a3 = a(dexFileClassLoader, "coreVersion");
                c.a(this.c, "main process version: %s, %s", stringExtra7, stringExtra6);
                c.a(this.c, "this process version: %s, %s", a2, a3);
                if (dexFileClassLoader != null) {
                    try {
                        cls2 = Class.forName("org.chromium.content.app.SandboxedProcessService0", false, dexFileClassLoader);
                    } catch (Throwable th3) {
                        if (dexFileClassLoader == null) {
                            a("Class.forName(org.chromium.content.app.SandboxedProcessService0) failed.", th3);
                        } else {
                            a("Class.forName(org.chromium.content.app.SandboxedProcessService0, " + dexFileClassLoader + ") failed.", th3);
                        }
                        cls = null;
                    }
                } else {
                    cls2 = Class.forName("org.chromium.content.app.SandboxedProcessService0");
                }
                cls = cls2;
                try {
                    Constructor<?> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
                    this.f = declaredConstructor;
                    declaredConstructor.setAccessible(true);
                } catch (Throwable th4) {
                    a("initServiceClassIfNeeded: getDeclaredConstructor failed.", th4);
                }
                try {
                    Method method4 = cls.getMethod("onDestroy", new Class[0]);
                    this.g = method4;
                    method4.setAccessible(true);
                } catch (Throwable th5) {
                    a("initServiceClassIfNeeded: getMethod onDestroy failed.", th5);
                }
                try {
                    Method declaredMethod = cls.getDeclaredMethod("initializeEngine", Class.forName("[Landroid.os.ParcelFileDescriptor;"));
                    this.i = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (Throwable th6) {
                    a("initServiceClassIfNeeded: getDeclaredMethod mInitializeMethod failed.", th6);
                }
                try {
                    Method declaredMethod2 = cls.getDeclaredMethod("onBind", Class.forName("android.content.Intent"));
                    this.h = declaredMethod2;
                    declaredMethod2.setAccessible(true);
                } catch (Throwable th7) {
                    a("initServiceClassIfNeeded: getDeclaredMethod onBind failed.", th7);
                }
                Constructor<?> constructor = this.f;
                if (constructor != null) {
                    try {
                        this.k = constructor.newInstance(new Object[0]);
                    } catch (Exception e2) {
                        a("initServiceClassIfNeeded: new SandboxedProcessService failed.", e2);
                    }
                }
                c.a(4, this.c, "doInit 3/4 - attachSandboxedProcessService", null);
                try {
                    Class<?> cls3 = Class.forName("android.app.Service");
                    Field declaredField = cls3.getDeclaredField("mThread");
                    declaredField.setAccessible(true);
                    Field declaredField2 = cls3.getDeclaredField("mClassName");
                    declaredField2.setAccessible(true);
                    Field declaredField3 = cls3.getDeclaredField("mToken");
                    declaredField3.setAccessible(true);
                    Field declaredField4 = cls3.getDeclaredField("mApplication");
                    declaredField4.setAccessible(true);
                    Field declaredField5 = cls3.getDeclaredField("mActivityManager");
                    declaredField5.setAccessible(true);
                    Field declaredField6 = Class.forName("android.content.ContextWrapper").getDeclaredField("mBase");
                    declaredField6.setAccessible(true);
                    cls3.getDeclaredMethod("attach", Context.class, Class.forName("android.app.ActivityThread"), String.class, IBinder.class, Application.class, Object.class).invoke(this.k, declaredField6.get(this), declaredField.get(this), declaredField2.get(this), declaredField3.get(this), declaredField4.get(this), declaredField5.get(this));
                } catch (Exception e3) {
                    a("attachSandboxedProcessService: attach service failed.", e3);
                }
                c.a(this.c, "doInit 4/4 - doInitService, libFdInfos: %s", String.valueOf(parcelableArr));
                Object obj = this.k;
                if (!(obj == null || (method2 = this.h) == null)) {
                    try {
                        this.j = (IBinder) method2.invoke(obj, this.l);
                    } catch (Exception e4) {
                        a("doInitService: invoke onBind failed.", e4);
                    }
                }
                Object obj2 = this.k;
                if (!(obj2 == null || (method = this.i) == null)) {
                    try {
                        method.invoke(obj2, parcelableArr);
                    } catch (Exception e5) {
                        a("doInitService: invoke initialize failed.", e5);
                    }
                }
                c.a(4, this.c, "doInit done.", null);
                this.d = true;
                return;
            }
            throw new AssertionError();
        }
    }

    public IBinder onBind(Intent intent) {
        c.a(4, this.c, "onBind", null);
        this.l = intent;
        stopSelf();
        a();
        return this.m;
    }

    public void onCreate() {
        c.a(4, this.c, "onCreate", null);
        super.onCreate();
    }

    public void onDestroy() {
        c.a(4, this.c, "onDestroy", null);
        super.onDestroy();
        if (this.j != null) {
            Method method = this.g;
            if (method != null) {
                try {
                    method.invoke(this.k, new Object[0]);
                } catch (Throwable th) {
                    c.a(this.c, "onDestroy: onDestroy failed.", th);
                }
            }
            this.k = null;
            this.j = null;
        }
        System.exit(0);
    }

    private void a(String str, Throwable th) {
        a(true, true);
        c.a(this.c, str, th);
        throw new Error(str, th);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00ed, code lost:
        if (r12.c.contains("." + r4 + tb.jl1.ARRAY_END_STR) == false) goto L_0x00ef;
     */
    public void a() {
        StringBuilder sb;
        if (this.l.getExtras() == null) {
            c.a(5, this.c, "extras is null(maybe in pre startup mode), init delay", null);
            return;
        }
        boolean booleanExtra = this.l.getBooleanExtra("org.chromium.base.process_launcher.enable.seccomp", false);
        String stringExtra = this.l.getStringExtra("org.chromium.base.process_launcher.proc_type");
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = "Render";
        }
        String stringExtra2 = this.l.getStringExtra("org.chromium.base.process_launcher.browser_proc_name");
        if (TextUtils.isEmpty(stringExtra2)) {
            stringExtra2 = NetworkUtil.NETWORK_CLASS_UNKNOWN;
        }
        int intExtra = this.l.getIntExtra("org.chromium.base.process_launcher.browser_proc_pid", 0);
        if ("SandboxedProcessService".equals(this.c)) {
            this.n = stringExtra2;
            String str = jl1.ARRAY_START_STR + stringExtra;
            if (!"GPU".equals(stringExtra)) {
                String str2 = str + ".";
                String str3 = "N";
                if (b.a()) {
                    sb = new StringBuilder();
                    sb.append(str2);
                    str3 = "I";
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str2);
                    sb2.append(str3);
                    if (booleanExtra) {
                        str3 = ExifInterface.LATITUDE_SOUTH;
                    }
                    sb = sb2;
                }
                sb.append(str3);
                str = sb.toString();
            }
            this.c = (str + ".Svc." + intExtra + jl1.ARRAY_END_STR) + this.c;
        } else {
            if (this.c.contains(stringExtra)) {
            }
            c.b(this.c, ".\n!!! %s[%d] is crazy, it want me run as %s, I was started by %s !!!\n.", stringExtra2, Integer.valueOf(intExtra), stringExtra, this.n);
        }
        int i2 = this.o + 1;
        this.o = i2;
        c.a(this.c, "onIntentInit - %s, %s, call count %d", this.l, stringExtra2, Integer.valueOf(i2));
    }

    private String a(ClassLoader classLoader, String str) {
        Class<?> cls;
        if (classLoader == null) {
            try {
                cls = Class.forName("org.chromium.base.utils.MiscUtil");
            } catch (Throwable th) {
                c.a(this.c, "getVersion exception", th);
                return "";
            }
        } else {
            cls = Class.forName("org.chromium.base.utils.MiscUtil", false, classLoader);
        }
        Method method = cls.getMethod(str, new Class[0]);
        method.setAccessible(true);
        return (String) method.invoke(null, new Object[0]);
    }

    private void a(boolean z, boolean z2) {
        String[] stringArrayExtra;
        String stringExtra = this.l.getStringExtra("dex.path");
        String stringExtra2 = this.l.getStringExtra("odex.path");
        String stringExtra3 = this.l.getStringExtra("lib.path");
        String stringExtra4 = this.l.getStringExtra("source.dir");
        String stringExtra5 = this.l.getStringExtra("source.dir.prior");
        c.a(this.c, "core info:\n        dexPath: %s\n       odexPath: %s\n        libPath: %s\n      sourceDir: %s\n sourceDirPrior: %s", stringExtra, stringExtra2, stringExtra3, stringExtra4, stringExtra5);
        if (z) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(stringExtra);
            arrayList.add(stringExtra2);
            arrayList.add(stringExtra4);
            arrayList.add(stringExtra5);
            arrayList.add(stringExtra3);
            if (!TextUtils.isEmpty(stringExtra3) && !stringExtra3.equals(getApplicationInfo().nativeLibraryDir) && (stringArrayExtra = this.l.getStringArrayExtra("info.core.libs")) != null) {
                for (String str : stringArrayExtra) {
                    if (!TextUtils.isEmpty(str)) {
                        if (str.endsWith(".so")) {
                            arrayList.add(new File(stringExtra3, str).getPath());
                        } else {
                            arrayList.add(new File(stringExtra3, SolidMonitor.CHECK_TYPE_LIB + str + ".so").getPath());
                        }
                    }
                }
            }
            a(arrayList, z2);
        }
    }

    private void a(ArrayList<String> arrayList, boolean z) {
        c.a(4, this.c, "file info:", null);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!TextUtils.isEmpty(next)) {
                c.a(this.c, " %s", next);
                try {
                    File file = new File(next);
                    if (!file.exists()) {
                        c.a(4, this.c, " | not exists", null);
                    } else if (file.isDirectory()) {
                        c.a(4, this.c, " | is directory", null);
                    } else if (!file.isFile()) {
                        c.a(4, this.c, " | is not file", null);
                    } else {
                        c.a(this.c, " | size: %d, last modify time: %s", Long.valueOf(file.length()), a(file.lastModified()));
                        if (z) {
                            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
                            FileInputStream fileInputStream = new FileInputStream(file);
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int read = fileInputStream.read(bArr);
                                if (read <= 0) {
                                    break;
                                }
                                instance.update(bArr, 0, read);
                            }
                            byte[] digest = instance.digest();
                            String str = this.c;
                            c.a(4, str, " |  md5: " + a(digest), null);
                            fileInputStream.close();
                        }
                    }
                } catch (Throwable th) {
                    c.a(this.c, " | get info exception", th);
                }
            }
        }
    }

    private static String a(long j2) {
        try {
            return new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date(j2));
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length);
        for (byte b2 : bArr) {
            stringBuffer.append(Integer.toString((b2 & 255) + 256, 16).substring(1));
        }
        return stringBuffer.toString();
    }
}
