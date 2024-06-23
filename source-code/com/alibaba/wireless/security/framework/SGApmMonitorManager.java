package com.alibaba.wireless.security.framework;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge;
import com.alibaba.wireless.security.open.securityguardaccsadapter.OrangeAdapter;
import com.alibaba.wireless.security.open.securityguardaccsadapter.OrangeListener;
import com.android.dingtalk.share.ddsharemodule.ShareConstant;
import com.taobao.accs.common.Constants;
import com.taobao.android.tlog.protocol.model.joint.point.ForegroundJointPoint;
import com.taobao.weex.annotation.JSMethod;
import com.ut.device.UTDevice;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tb.o70;

/* compiled from: Taobao */
public class SGApmMonitorManager {
    private static SGApmMonitorManager q = null;
    private static int r = 5000;
    private static ScheduledExecutorService s;
    private static ScheduledExecutorService t;
    private static JSONObject u = new JSONObject();
    private static long v;
    private ConcurrentHashMap<String, Number> a = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Number> b = new ConcurrentHashMap<>();
    private volatile int c = 0;
    private Context d = null;
    private d e;
    private String f = null;
    private volatile boolean g = false;
    private boolean h = false;
    private int i = 0;
    private boolean j = true;
    private long k = 0;
    private long l = 0;
    private long m = 0;
    private long n = 0;
    private boolean o = false;
    private String p = null;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements Application.ActivityLifecycleCallbacks {
        a() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            SGApmMonitorManager.b(SGApmMonitorManager.this);
            if (SGApmMonitorManager.this.i == 1) {
                SGApmMonitorManager.this.j = true;
                if (SGApmMonitorManager.this.n > 0) {
                    SGApmMonitorManager.this.m += System.currentTimeMillis() - SGApmMonitorManager.this.n;
                }
                SGApmMonitorManager.this.l = System.currentTimeMillis();
            }
        }

        public void onActivityStopped(Activity activity) {
            SGApmMonitorManager.c(SGApmMonitorManager.this);
            if (SGApmMonitorManager.this.i == 0) {
                SGApmMonitorManager.this.j = false;
                if (SGApmMonitorManager.this.l == 0) {
                    SGApmMonitorManager.this.l = SGApmMonitorManager.v;
                }
                SGApmMonitorManager.this.k += System.currentTimeMillis() - SGApmMonitorManager.this.l;
                SGApmMonitorManager.this.n = System.currentTimeMillis();
            }
        }
    }

    /* compiled from: Taobao */
    class b implements ThreadFactory {
        b(SGApmMonitorManager sGApmMonitorManager) {
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "SGApmMonitor-1");
        }
    }

    /* compiled from: Taobao */
    class c implements ThreadFactory {
        c(SGApmMonitorManager sGApmMonitorManager) {
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "SGApmMonitor-2");
        }
    }

    /* compiled from: Taobao */
    class d implements Runnable {
        d() {
        }

        public void run() {
            SGApmMonitorManager.this.f();
        }
    }

    /* compiled from: Taobao */
    class e implements Runnable {
        e() {
        }

        public void run() {
            SGApmMonitorManager.this.p();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class f implements Runnable {
        final /* synthetic */ boolean a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        f(boolean z, String str, String str2) {
            this.a = z;
            this.b = str;
            this.c = str2;
        }

        public void run() {
            String str = SGApmMonitorManager.this.f;
            String str2 = SGApmMonitorManager.this.p;
            UserTrackMethodJniBridge.addUtRecord("100171", 0, 1, str, 0, null, str2, "" + this.a, this.b, this.c);
        }
    }

    /* compiled from: Taobao */
    class g implements Runnable {
        private String a;

        public g(String str, int i) {
            this.a = Base64.encodeToString(SGApmMonitorManager.this.a((SGApmMonitorManager) str, (String) i).getBytes(), 2);
        }

        public void run() {
            String str = this.a;
            if (str != null) {
                SGApmMonitorManager.this.a((SGApmMonitorManager) str);
            }
        }
    }

    /* compiled from: Taobao */
    class h implements Runnable {
        h() {
        }

        public void run() {
            if (SGApmMonitorManager.this.h) {
                SGApmMonitorManager.t.submit(new g("always", 1));
            }
            if (SGApmMonitorManager.this.c == 0 && SGApmMonitorManager.this.isAllPluginLoaded()) {
                SGApmMonitorManager.this.g();
                SGApmMonitorManager.this.g = false;
                JSONObject unused = SGApmMonitorManager.u = null;
                SGApmMonitorManager.s.shutdown();
                SGApmMonitorManager.t.shutdown();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class i implements Runnable {
        private String a;
        private int b;
        private int c;

        /* compiled from: Taobao */
        class a implements Runnable {
            a() {
            }

            public void run() {
                SGApmMonitorManager.this.h();
            }
        }

        public i(String str, int i, int i2) {
            this.a = str;
            this.b = i;
            this.c = i2;
        }

        public void run() {
            if (this.a != null && SGApmMonitorManager.this.g && SGApmMonitorManager.u != null && this.b <= 5) {
                try {
                    if (((Number) SGApmMonitorManager.this.b.get(this.a)) == null) {
                        SGApmMonitorManager.t.submit(new a());
                        ScheduledExecutorService scheduledExecutorService = SGApmMonitorManager.t;
                        SGApmMonitorManager sGApmMonitorManager = SGApmMonitorManager.this;
                        scheduledExecutorService.submit(new g(this.a + "_f", this.b));
                        SGApmMonitorManager.i(SGApmMonitorManager.this);
                        SGApmMonitorManager.s.schedule(new i(this.a, this.b + 1, this.c), (long) this.c, TimeUnit.MILLISECONDS);
                    } else if (this.b > 1) {
                        ScheduledExecutorService scheduledExecutorService2 = SGApmMonitorManager.t;
                        SGApmMonitorManager sGApmMonitorManager2 = SGApmMonitorManager.this;
                        scheduledExecutorService2.submit(new g(this.a + "_s", this.b));
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    private String a(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String a(String str, int i2) {
        String str2 = "";
        String packageName = this.d.getPackageName();
        try {
            str2 = this.d.getPackageManager().getPackageInfo(packageName, 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e("SGApmMonitor", str2, e2);
        }
        long j2 = this.k;
        long j3 = this.m;
        if (this.l == 0) {
            this.l = v;
        }
        if (this.j) {
            j2 += System.currentTimeMillis() - this.l;
        } else if (this.n > 0) {
            j3 += System.currentTimeMillis() - this.n;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("utdid", j());
            jSONObject.put("sysver", Build.VERSION.getRELEASE());
            jSONObject.put("model", Build.getMODEL());
            jSONObject.put("brand", Build.getBRAND());
            jSONObject.put("reason", str);
            jSONObject.put("wsv", this.f);
            jSONObject.put("wsd", k());
            jSONObject.put(ForegroundJointPoint.TYPE, this.j);
            jSONObject.put("foregroundtime", j2);
            jSONObject.put("backgroundtime", j3);
            jSONObject.put("fulltrack", this.o);
            jSONObject.put("sample", this.h);
            jSONObject.put("tryround", i2);
            jSONObject.put("initts", v);
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put("appver", str2);
            jSONObject.put("pkgname", packageName);
            jSONObject.put("pid", Process.myPid());
            jSONObject.put("process", a(this.d));
            jSONObject.put("tracklog", u);
            jSONObject.put("costlog", a(this.b));
            jSONObject.put("nt", this.e.getRouter().doCommand(11154, new Object[0]));
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    private JSONObject a(ConcurrentHashMap<String, Number> concurrentHashMap) {
        try {
            ArrayList<String> arrayList = new ArrayList(concurrentHashMap.keySet());
            Collections.sort(arrayList);
            JSONObject jSONObject = new JSONObject();
            for (String str : arrayList) {
                jSONObject.put(str, concurrentHashMap.get(str));
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00dc A[SYNTHETIC, Splitter:B:48:0x00dc] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ec A[SYNTHETIC, Splitter:B:55:0x00ec] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    private void a(String str) {
        Context context;
        String str2;
        Throwable th;
        HttpURLConnection httpURLConnection;
        Exception e2;
        if (str != null && (context = this.d) != null) {
            String packageName = context.getPackageName();
            try {
                str2 = this.d.getPackageManager().getPackageInfo(packageName, 0).versionName;
            } catch (PackageManager.NameNotFoundException unused) {
                str2 = "";
            }
            BufferedReader bufferedReader = null;
            try {
                httpURLConnection = (HttpURLConnection) new URL("https://mum.alibabachengdun.com/repTd.json?" + "e=" + 2040 + "&pn=" + packageName + "&os=" + 0 + "&pv=" + str2 + "&pt=" + 1).openConnection();
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.setConnectTimeout(20000);
                        httpURLConnection.setReadTimeout(20000);
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setRequestProperty("Content-Type", "text/plain;charset=UTF-8");
                        httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.connect();
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        outputStream.write(str.getBytes());
                        outputStream.flush();
                        if (httpURLConnection.getResponseCode() != 200) {
                            httpURLConnection.disconnect();
                            return;
                        }
                        InputStream inputStream = httpURLConnection.getInputStream();
                        if (inputStream == null) {
                            httpURLConnection.disconnect();
                            return;
                        }
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                        do {
                            try {
                            } catch (Exception e3) {
                                e2 = e3;
                                bufferedReader = bufferedReader2;
                                try {
                                    e2.printStackTrace();
                                    if (bufferedReader != null) {
                                    }
                                    if (httpURLConnection == null) {
                                    }
                                    httpURLConnection.disconnect();
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (IOException e4) {
                                            e4.printStackTrace();
                                        }
                                    }
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                bufferedReader = bufferedReader2;
                                if (bufferedReader != null) {
                                }
                                if (httpURLConnection != null) {
                                }
                                throw th;
                            }
                        } while (bufferedReader2.readLine() != null);
                        bufferedReader = bufferedReader2;
                    } catch (Exception e5) {
                        e2 = e5;
                        e2.printStackTrace();
                        if (bufferedReader != null) {
                        }
                        if (httpURLConnection == null) {
                        }
                        httpURLConnection.disconnect();
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                if (httpURLConnection == null) {
                    return;
                }
            } catch (Exception e7) {
                e2 = e7;
                httpURLConnection = null;
                e2.printStackTrace();
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                }
                if (httpURLConnection == null) {
                    return;
                }
                httpURLConnection.disconnect();
            } catch (Throwable th4) {
                th = th4;
                httpURLConnection = null;
                if (bufferedReader != null) {
                }
                if (httpURLConnection != null) {
                }
                throw th;
            }
            httpURLConnection.disconnect();
        }
    }

    private void a(String str, String str2) {
        try {
            if (TextUtils.equals(str2, "7L2OvtRdxzOJAe7ImU+4I2bAxvq1oDLyTCzRgSPGufNIb7ZY5FsHDFaEzD98Mn7K")) {
                boolean delete = new File(b(this.d), "init.config").delete();
                this.e.a(k());
                t.schedule(new f(delete, str, str2), 5, TimeUnit.SECONDS);
            }
        } catch (Exception unused) {
        }
    }

    private boolean a() {
        if (n()) {
            return true;
        }
        double d2 = 0.001d;
        File b2 = b(this.d);
        File file = new File(b2, "." + i());
        if (file.exists()) {
            String a2 = com.alibaba.wireless.security.framework.utils.a.a(file);
            try {
                if (!TextUtils.isEmpty(a2)) {
                    d2 = Double.parseDouble(a2);
                }
            } catch (NumberFormatException unused) {
            }
        }
        return new Random().nextDouble() < d2;
    }

    static /* synthetic */ int b(SGApmMonitorManager sGApmMonitorManager) {
        int i2 = sGApmMonitorManager.i;
        sGApmMonitorManager.i = i2 + 1;
        return i2;
    }

    private File b(Context context) {
        String str;
        File dir;
        if (context == null) {
            return null;
        }
        try {
            String str2 = context.getApplicationInfo().sourceDir;
            if (str2 != null) {
                File file = new File(str2);
                if (file.exists()) {
                    str = (file.lastModified() / 1000) + "";
                    if (str != null || (dir = context.getDir("SGLib", 0)) == null) {
                        return null;
                    }
                    return new File(dir, "app_" + str);
                }
            }
        } catch (Throwable unused) {
        }
        str = null;
        if (str != null) {
            return null;
        }
        return new File(dir, "app_" + str);
    }

    static /* synthetic */ int c(SGApmMonitorManager sGApmMonitorManager) {
        int i2 = sGApmMonitorManager.i;
        sGApmMonitorManager.i = i2 - 1;
        return i2;
    }

    private void c(Context context) {
        if (!(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        ((Application) context).registerActivityLifecycleCallbacks(new a());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x008d A[Catch:{ Exception -> 0x00cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0093 A[Catch:{ Exception -> 0x00cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00c2 A[Catch:{ Exception -> 0x00cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c8 A[Catch:{ Exception -> 0x00cd }] */
    private void f() {
        String str;
        String str2;
        String str3 = null;
        try {
            int i2 = OrangeListener.a;
            Method method = OrangeListener.class.getMethod("getOrangeConfig", String.class, String.class, String.class);
            if (method != null) {
                str2 = (String) method.invoke(OrangeListener.class, OrangeAdapter.SECURITYGUARD_ORANGE_NAMESPACE, "128", "1");
                try {
                    str = (String) method.invoke(OrangeListener.class, OrangeAdapter.SECURITYGUARD_ORANGE_NAMESPACE, "129", "1");
                } catch (Throwable unused) {
                }
                str3 = str2;
                Log.e("SGApmMonitor", "enable1: " + str3 + ", enable2: " + str);
                try {
                    File file = new File(b(this.d), ".pma_" + i());
                    boolean exists = file.exists();
                    if ("1".equals(str3)) {
                        if (!exists) {
                            file.createNewFile();
                        }
                    } else if (exists) {
                        file.delete();
                    }
                    File file2 = new File(b(this.d), ".istbg_" + i());
                    boolean exists2 = file2.exists();
                    if ("1".equals(str)) {
                        if (!exists2) {
                            file2.createNewFile();
                        }
                    } else if (exists2) {
                        file2.delete();
                    }
                } catch (Exception unused2) {
                }
            } else {
                str = null;
                Log.e("SGApmMonitor", "enable1: " + str3 + ", enable2: " + str);
                File file3 = new File(b(this.d), ".pma_" + i());
                boolean exists3 = file3.exists();
                if ("1".equals(str3)) {
                }
                File file22 = new File(b(this.d), ".istbg_" + i());
                boolean exists22 = file22.exists();
                if ("1".equals(str)) {
                }
            }
        } catch (Throwable unused3) {
            str2 = null;
            str = null;
            str3 = str2;
            Log.e("SGApmMonitor", "enable1: " + str3 + ", enable2: " + str);
            File file32 = new File(b(this.d), ".pma_" + i());
            boolean exists32 = file32.exists();
            if ("1".equals(str3)) {
            }
            File file222 = new File(b(this.d), ".istbg_" + i());
            boolean exists222 = file222.exists();
            if ("1".equals(str)) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void g() {
        Context context = this.d;
        if (context != null) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("sgloadfailed", 0);
                int i2 = sharedPreferences.getInt(Constants.KEY_TIMES, 0);
                if (i2 > 5) {
                    File file = new File(this.d.getDir("SGLib", 0), ".nt");
                    if (file.exists()) {
                        file.delete();
                        return;
                    }
                    return;
                }
                sharedPreferences.edit().putInt(Constants.KEY_TIMES, i2 + 1).commit();
            } catch (Exception unused) {
            }
        }
    }

    public static SGApmMonitorManager getInstance() {
        if (q == null) {
            synchronized (SGApmMonitorManager.class) {
                if (q == null) {
                    q = new SGApmMonitorManager();
                }
            }
        }
        return q;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void h() {
        Context context = this.d;
        if (context != null) {
            File file = new File(context.getDir("SGLib", 0), ".nt");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            try {
                SharedPreferences sharedPreferences = this.d.getSharedPreferences("sgloadfailed", 0);
                if (sharedPreferences.getInt(Constants.KEY_TIMES, 0) != 0) {
                    sharedPreferences.edit().putInt(Constants.KEY_TIMES, 0).commit();
                }
            } catch (Exception unused) {
            }
        }
    }

    static /* synthetic */ int i(SGApmMonitorManager sGApmMonitorManager) {
        int i2 = sGApmMonitorManager.c;
        sGApmMonitorManager.c = i2 + 1;
        return i2;
    }

    private String i() {
        try {
            return this.d.getPackageManager().getPackageInfo(this.d.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return null;
        }
    }

    private String j() {
        Context context = this.d;
        try {
            String str = (String) UTDevice.class.getMethod("getUtdid", Context.class).invoke(null, context);
            if (str != null) {
                try {
                    if (!str.isEmpty()) {
                        if (str.contains("?")) {
                        }
                        return str;
                    }
                } catch (Exception unused) {
                }
            }
            String str2 = (String) com.ta.utdid2.device.UTDevice.class.getMethod("getUtdid", Context.class).invoke(null, context);
            try {
                if (str2.contains("?")) {
                    return "";
                }
            } catch (Exception unused2) {
            }
            return str2;
        } catch (Exception unused3) {
            return "";
        }
    }

    private String k() {
        if (this.p == null) {
            try {
                b a2 = b.a(new File(b(this.d), "init.config"));
                this.p = "" + a2.b();
            } catch (Exception unused) {
            }
        }
        return this.p;
    }

    private boolean l() {
        File b2 = b(this.d);
        StringBuilder sb = new StringBuilder();
        sb.append(".pma_");
        sb.append(i());
        return new File(b2, sb.toString()).exists();
    }

    private boolean m() {
        Context context = this.d;
        if (context == null) {
            return false;
        }
        String packageName = context.getPackageName();
        return "com.taobao.taobao".equals(packageName) || ShareConstant.DD_APP_PACKAGE.equals(packageName) || "com.alibaba.wireless.securityguard".equals(packageName);
    }

    private boolean n() {
        try {
            return m() && o() && i().split("\\.").length == 4;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean o() {
        File b2 = b(this.d);
        StringBuilder sb = new StringBuilder();
        sb.append(".istbg_");
        sb.append(i());
        return new File(b2, sb.toString()).exists();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b7 A[SYNTHETIC, Splitter:B:40:0x00b7] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00c8 A[SYNTHETIC, Splitter:B:50:0x00c8] */
    /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    private void p() {
        String str;
        HttpURLConnection httpURLConnection;
        Throwable th;
        Context context = this.d;
        if (context != null) {
            String packageName = context.getPackageName();
            try {
                str = this.d.getPackageManager().getPackageInfo(packageName, 0).versionName;
            } catch (Exception unused) {
                str = "";
            }
            String k2 = k();
            if (k2 != null) {
                String str2 = "http://cdn-mum.alibabachengdun.com/sg7sX1/rYxU/pDDw/" + k2 + "?pn=" + packageName + "&pv=" + str;
                BufferedReader bufferedReader = null;
                try {
                    httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
                    try {
                        httpURLConnection.setConnectTimeout(20000);
                        httpURLConnection.setReadTimeout(20000);
                        httpURLConnection.setRequestMethod("GET");
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setRequestProperty("Content-Type", "text/plain;charset=UTF-8");
                        httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
                        if (httpURLConnection.getResponseCode() == 200) {
                            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                            try {
                                char[] cArr = new char[1100];
                                StringBuffer stringBuffer = new StringBuffer();
                                int read = bufferedReader2.read(cArr);
                                if (read < 1024) {
                                    stringBuffer.append(cArr, 0, read);
                                }
                                a(str2, stringBuffer.toString());
                                bufferedReader = bufferedReader2;
                            } catch (Exception unused2) {
                                bufferedReader = bufferedReader2;
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                if (httpURLConnection == null) {
                                    return;
                                }
                                httpURLConnection.disconnect();
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedReader = bufferedReader2;
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                throw th;
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                    } catch (Exception unused3) {
                        if (bufferedReader != null) {
                        }
                        if (httpURLConnection == null) {
                        }
                        httpURLConnection.disconnect();
                    } catch (Throwable th3) {
                        th = th3;
                        if (bufferedReader != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        throw th;
                    }
                } catch (Exception unused4) {
                    httpURLConnection = null;
                    if (bufferedReader != null) {
                    }
                    if (httpURLConnection == null) {
                    }
                    httpURLConnection.disconnect();
                } catch (Throwable th4) {
                    th = th4;
                    httpURLConnection = null;
                    if (bufferedReader != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    throw th;
                }
                httpURLConnection.disconnect();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:6|(1:8)(1:9)|10|11|12|17|18|19|20|22) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0059 */
    public synchronized void addTrackInfo(String str) {
        JSONArray jSONArray;
        if (str != null) {
            if (this.g) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(o70.DINAMIC_PREFIX_AT);
                sb.append(this.j ? "1" : "0");
                String sb2 = sb.toString();
                String str2 = "" + Process.myPid() + JSMethod.NOT_SET + Process.myTid();
                try {
                    jSONArray = (JSONArray) u.get(str2);
                } catch (Exception unused) {
                    jSONArray = new JSONArray();
                    u.put(str2, jSONArray);
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", sb2);
                jSONObject.put("ts", System.currentTimeMillis());
                jSONArray.put(jSONObject);
            }
        }
    }

    public void init(Context context) {
        this.d = context;
        v = System.currentTimeMillis();
        Context context2 = this.d;
        if (context2 != null && com.alibaba.wireless.security.framework.utils.e.b(context2)) {
            s = Executors.newSingleThreadScheduledExecutor(new b(this));
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new c(this));
            t = newSingleThreadScheduledExecutor;
            if (s != null && newSingleThreadScheduledExecutor != null) {
                newSingleThreadScheduledExecutor.schedule(new d(), 5, TimeUnit.SECONDS);
                boolean l2 = l();
                this.h = a();
                Log.e("SGApmMonitor", "1 : " + l2 + ", 2 : " + this.h);
                if (l2) {
                    this.g = true;
                    this.o = isEnableFullTrackRecord();
                    c(this.d);
                    s.schedule(new h(), (long) (r * 5), TimeUnit.MILLISECONDS);
                    t.submit(new e());
                }
            }
        }
    }

    public boolean isAllPluginLoaded() {
        return this.b.containsKey("getInstance") && this.b.containsKey("securitybody") && this.b.containsKey("middletier");
    }

    public boolean isEnableFullTrackRecord() {
        if (this.d == null) {
            return false;
        }
        if (n()) {
            return true;
        }
        return new File(this.d.getDir("SGLib", 0), ".nt").exists();
    }

    public boolean isForeground() {
        return this.j;
    }

    public void monitorEnd(String str) {
        if (str != null && this.g) {
            addTrackInfo("j_" + str + "_e");
            Number number = this.a.get(str);
            if (number != null && this.b.get(str) == null) {
                this.b.put(str, Long.valueOf(System.currentTimeMillis() - number.longValue()));
            }
        }
    }

    public void monitorStart(String str) {
        monitorStartWithTimeout(str, r);
    }

    public void monitorStartWithTimeout(String str, int i2) {
        if (str != null && this.g) {
            addTrackInfo("j_" + str + "_s");
            if (this.a.get(str) == null) {
                this.a.put(str, Long.valueOf(System.currentTimeMillis()));
                s.schedule(new i(str, 1, i2), (long) i2, TimeUnit.MILLISECONDS);
            }
        }
    }

    public void setMainPluginVersion(String str) {
        this.f = str;
    }

    public void setSGPluginManager(d dVar) {
        this.e = dVar;
    }
}
