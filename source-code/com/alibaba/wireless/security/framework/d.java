package com.alibaba.wireless.security.framework;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alibaba.wireless.security.framework.utils.FLOG;
import com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;
import com.alibaba.wireless.security.open.securityguardaccsadapter.OrangeAdapter;
import com.alibaba.wireless.security.open.securityguardaccsadapter.OrangeListener;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.taobao.weex.annotation.JSMethod;
import com.tencent.connect.common.Constants;
import com.youku.arch.solid.monitor.SolidMonitor;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONException;
import org.json.JSONObject;
import tb.jl1;
import tb.js2;
import tv.cjump.jni.DeviceUtils;

/* compiled from: Taobao */
public class d implements ISGPluginManager {
    private static Boolean u = null;
    private static String[] v = {"armeabi", "armeabi-v7a", DeviceUtils.ABI_X86, "arm64-v8a", "x86_64"};
    private static String w = null;
    private static volatile boolean x = true;
    private HandlerThread a = null;
    private List<Runnable> b;
    private Context c;
    private final ConcurrentHashMap<String, c> d = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Class, Object> e = new ConcurrentHashMap<>();
    private IRouterComponent f = null;
    com.alibaba.wireless.security.framework.utils.b g = null;
    private boolean h = true;
    private String i = null;
    private String j = null;
    private b k = null;
    private boolean l = false;
    private boolean m = false;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;
    private File r = null;
    private File s = null;
    private File t = null;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements Runnable {
        final /* synthetic */ File a;

        a(File file) {
            this.a = file;
        }

        public void run() {
            d.this.a(100179, 4, this.a.getAbsolutePath(), "", "", "", "");
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b implements Runnable {
        final /* synthetic */ File a;

        b(File file) {
            this.a = file;
        }

        public void run() {
            d.this.a(100179, 2, this.a.getAbsolutePath(), "", "", "", "");
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class c implements Runnable {
        final /* synthetic */ File a;
        final /* synthetic */ String b;

        c(File file, String str) {
            this.a = file;
            this.b = str;
        }

        public void run() {
            File filesDir;
            File[] listFiles;
            File[] listFiles2;
            try {
                File file = this.a;
                if (file != null && file.isDirectory() && (listFiles2 = this.a.listFiles()) != null && listFiles2.length > 0) {
                    for (File file2 : listFiles2) {
                        if (file2.isDirectory() && file2.getName().startsWith("app_") && !file2.getName().equals(this.b)) {
                            d.this.a((d) file2);
                        } else if (file2.getName().startsWith("libsg")) {
                            file2.delete();
                        }
                    }
                }
                if (!(d.this.c == null || (filesDir = d.this.c.getFilesDir()) == null || !filesDir.isDirectory() || (listFiles = filesDir.listFiles()) == null || listFiles.length <= 0)) {
                    for (File file3 : listFiles) {
                        if (file3.getName().startsWith("libsecuritysdk")) {
                            file3.delete();
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.alibaba.wireless.security.framework.d$d  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public class RunnableC0117d implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        RunnableC0117d(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        public void run() {
            try {
                d.this.e(this.a, this.b, true);
            } catch (SecException e) {
                FLOG.w("load weak dependency notDelay", e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class e implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        e(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        public void run() {
            try {
                d.this.e(this.a, this.b, true);
            } catch (SecException e) {
                FLOG.w("load weak dependency", e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class f implements Runnable {
        f() {
        }

        public void run() {
            d.this.i();
            d.this.c();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class g implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        g(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        public void run() {
            try {
                d.this.e(this.a, this.b, true);
            } catch (SecException e) {
                FLOG.w("load weak dependency notDelay", e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class h implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        h(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        public void run() {
            try {
                d.this.e(this.a, this.b, true);
            } catch (SecException e) {
                FLOG.w("load weak dependency", e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class i implements Runnable {
        i() {
        }

        public void run() {
            d.this.i();
            d.this.c();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class j implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ int b;

        j(String str, int i) {
            this.a = str;
            this.b = i;
        }

        public void run() {
            d.this.a(100048, 140, "Dynamic update rejected", "Arch=" + this.a, "DeployVersion=" + this.b, "", "");
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class k implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ File b;
        final /* synthetic */ File c;

        k(String str, File file, File file2) {
            this.a = str;
            this.b = file;
            this.c = file2;
        }

        public void run() {
            d dVar = d.this;
            dVar.a(100179, 4, "updInfo=" + this.a, this.b.getAbsolutePath(), this.c.getAbsolutePath(), "", "");
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class l {
        File a;
        File b;
        File c;
        boolean d;

        public l(File file, File file2, File file3, boolean z) {
            this.a = file;
            this.b = file2;
            this.c = file3;
            this.d = z;
        }
    }

    private PackageInfo a(String str, l lVar, String str2) throws SecException {
        PackageInfo packageInfo;
        String str3 = "";
        try {
            packageInfo = this.c.getPackageManager().getPackageArchiveInfo(lVar.a.getAbsolutePath(), 133);
        } catch (Throwable th) {
            String str4 = str3 + th;
            String d2 = d(lVar.a.getAbsolutePath() + str3);
            File file = lVar.c;
            a(100043, 133, "getPackageArchiveInfo failed", str4, d2, file != null ? d(file.getAbsolutePath()) : str3, str2);
            if (lVar.a.exists() && !e(lVar.a)) {
                lVar.a.delete();
            }
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo;
        }
        String str5 = str + jl1.ARRAY_START_STR + str2 + jl1.ARRAY_END_STR;
        String d3 = d(lVar.a.getAbsolutePath());
        File file2 = lVar.c;
        if (file2 != null) {
            str3 = d(file2.getAbsolutePath());
        }
        a(100043, 134, "packageInfo == null", str5, d3, str3, j());
        throw new SecException(134);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:220:0x05e9, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x05ea, code lost:
        r27 = "zipfile:";
        r31 = r14;
        r30 = "src:";
        r22 = r5;
        r24 = r10;
        r15 = r40;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x0619, code lost:
        r5 = r11.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x0628, code lost:
        if (r48.length() == 0) goto L_0x062a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x062a, code lost:
        r13 = r46;
        r6 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x062f, code lost:
        r13 = r46;
        r6 = r48 + r31 + r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x064c, code lost:
        if (r13.c != null) goto L_0x064e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x064e, code lost:
        r1 = new java.lang.StringBuilder();
        r1.append(r30);
        r7 = d(r13.c.getAbsolutePath());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x0662, code lost:
        r1.append(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x0666, code lost:
        r1 = new java.lang.StringBuilder();
        r1.append(r27);
        r7 = d(r13.a.getAbsolutePath());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x067b, code lost:
        a(100043, 103, "", r5, r6, r1.toString(), d(r12.getAbsolutePath()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x068e, code lost:
        if (r13.d == false) goto L_0x0690;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x0690, code lost:
        r44.g.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x0699, code lost:
        if (r12.exists() != false) goto L_0x069b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x069b, code lost:
        r12.delete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x06a0, code lost:
        if (r13.d == false) goto L_0x06a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x06a2, code lost:
        r1 = r44.g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:0x06a4, code lost:
        r1.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x06a8, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x06a9, code lost:
        r11 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x06ac, code lost:
        if (r13.d == false) goto L_0x06ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:0x06ae, code lost:
        r1 = r44.g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x06b1, code lost:
        a(100043, com.alibaba.wireless.security.SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR, "native exception occurred", r11.toString(), "soName=" + r22 + ", authCode=" + r44.j + ", errorCode=" + r11.getErrorCode(), d(r46.a.getAbsolutePath()), d(r12.getAbsolutePath()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x0704, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:257:0x0707, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:276:0x0784, code lost:
        r0 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x023a  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x023d  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x025c  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x02c0 A[SYNTHETIC, Splitter:B:115:0x02c0] */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x05e9 A[ExcHandler: SecException (e com.alibaba.wireless.security.open.SecException), Splitter:B:173:0x04dc] */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x0619  */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x06b1  */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x01d3 A[EDGE_INSN: B:291:0x01d3->B:93:0x01d3 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0119 A[SYNTHETIC, Splitter:B:59:0x0119] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0170 A[SYNTHETIC, Splitter:B:69:0x0170] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01f6  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01f9  */
    private c a(String str, l lVar, Context context, String str2) throws SecException {
        l lVar2;
        String str3;
        Throwable th;
        String str4;
        Boolean bool;
        String str5;
        boolean z;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        Throwable th2;
        String str11;
        String str12;
        StringBuilder sb;
        String d2;
        String str13;
        long j2;
        String str14;
        String str15;
        char c2;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        c cVar;
        c cVar2;
        Throwable th3;
        Throwable e2;
        char c3;
        long j3;
        String str21;
        String str22;
        StringBuilder sb2;
        String d3;
        String str23;
        StringBuilder sb3;
        String d4;
        String str24;
        String str25;
        String str26;
        StringBuilder sb4;
        String d5;
        StringBuilder sb5;
        String d6;
        String[] split;
        int i2;
        String str27;
        String optString;
        String str28 = str;
        String str29 = FLOG.get_currentFuncName();
        long j4 = FLOG.get_currentTime();
        String absolutePath = lVar.a.getAbsolutePath();
        String absolutePath2 = lVar.b.getAbsolutePath();
        Boolean bool2 = Boolean.FALSE;
        StringBuilder sb6 = new StringBuilder();
        sb6.append(absolutePath2);
        Boolean bool3 = bool2;
        sb6.append(File.separator);
        sb6.append(str28);
        sb6.append(JSMethod.NOT_SET);
        sb6.append(lVar.a.lastModified() / 1000);
        sb6.append(".pkgInfo");
        a aVar = new a(sb6.toString());
        ApmMonitorAdapter.jstageStart(str28, "1_0");
        try {
            if (aVar.b()) {
                try {
                    if (!com.alibaba.wireless.security.framework.utils.e.c(this.c)) {
                        try {
                            JSONObject a2 = aVar.a();
                            if (a2 != null) {
                                String string = a2.getString("version");
                                try {
                                    str27 = a2.getString("dependencies");
                                    try {
                                        optString = a2.optString("keepaliveprocs");
                                        try {
                                            if (optString.equals("")) {
                                                optString = null;
                                            }
                                            bool = Boolean.valueOf(Boolean.parseBoolean(a2.getString("hasso")));
                                        } catch (JSONException unused) {
                                            str6 = optString;
                                            bool = bool3;
                                            str3 = string;
                                            str4 = null;
                                            str5 = str27;
                                            z = false;
                                            if (!z) {
                                            }
                                            ApmMonitorAdapter.jstageEnd(str28, "1_0");
                                            if (str28 != null) {
                                            }
                                            ApmMonitorAdapter.jstageEnd(str28, "1_0");
                                            FLOG.printTimeCost(str28, str29, "getPackageInfo", j4);
                                            long j5 = FLOG.get_currentTime();
                                            split = str6.split(";");
                                            String a3 = com.alibaba.wireless.security.framework.utils.e.a(context);
                                            i2 = 0;
                                            while (true) {
                                                if (i2 >= split.length) {
                                                }
                                                i2++;
                                            }
                                            FLOG.i("MockTaobaoChannel - keepAliveProcs: " + str6);
                                            StringBuilder sb7 = new StringBuilder();
                                            sb7.append("MockTaobaoChannel - isKeepAliveProcess: ");
                                            sb7.append(!this.m ? BQCCameraParam.VALUE_YES : "no");
                                            FLOG.i(sb7.toString());
                                            FLOG.i("MockTaobaoChannel - pluginName: " + str28);
                                            String str30 = str28 + jl1.BRACKET_START_STR + str8 + jl1.BRACKET_END_STR;
                                            if (str2.length() != 0) {
                                            }
                                            if (e(str9, str11, false)) {
                                            }
                                        } catch (Throwable unused2) {
                                            str6 = optString;
                                            bool = bool3;
                                            str3 = string;
                                            str4 = null;
                                            str5 = str27;
                                            z = false;
                                            if (!z) {
                                            }
                                            ApmMonitorAdapter.jstageEnd(str28, "1_0");
                                            if (str28 != null) {
                                            }
                                            ApmMonitorAdapter.jstageEnd(str28, "1_0");
                                            FLOG.printTimeCost(str28, str29, "getPackageInfo", j4);
                                            long j52 = FLOG.get_currentTime();
                                            split = str6.split(";");
                                            String a32 = com.alibaba.wireless.security.framework.utils.e.a(context);
                                            i2 = 0;
                                            while (true) {
                                                if (i2 >= split.length) {
                                                }
                                                i2++;
                                            }
                                            FLOG.i("MockTaobaoChannel - keepAliveProcs: " + str6);
                                            StringBuilder sb72 = new StringBuilder();
                                            sb72.append("MockTaobaoChannel - isKeepAliveProcess: ");
                                            sb72.append(!this.m ? BQCCameraParam.VALUE_YES : "no");
                                            FLOG.i(sb72.toString());
                                            FLOG.i("MockTaobaoChannel - pluginName: " + str28);
                                            String str302 = str28 + jl1.BRACKET_START_STR + str8 + jl1.BRACKET_END_STR;
                                            if (str2.length() != 0) {
                                            }
                                            if (e(str9, str11, false)) {
                                            }
                                        }
                                    } catch (JSONException unused3) {
                                        bool = bool3;
                                        str3 = string;
                                        str6 = null;
                                        str4 = null;
                                        str5 = str27;
                                        z = false;
                                        if (!z) {
                                        }
                                        ApmMonitorAdapter.jstageEnd(str28, "1_0");
                                        if (str28 != null) {
                                        }
                                        ApmMonitorAdapter.jstageEnd(str28, "1_0");
                                        FLOG.printTimeCost(str28, str29, "getPackageInfo", j4);
                                        long j522 = FLOG.get_currentTime();
                                        split = str6.split(";");
                                        String a322 = com.alibaba.wireless.security.framework.utils.e.a(context);
                                        i2 = 0;
                                        while (true) {
                                            if (i2 >= split.length) {
                                            }
                                            i2++;
                                        }
                                        FLOG.i("MockTaobaoChannel - keepAliveProcs: " + str6);
                                        StringBuilder sb722 = new StringBuilder();
                                        sb722.append("MockTaobaoChannel - isKeepAliveProcess: ");
                                        sb722.append(!this.m ? BQCCameraParam.VALUE_YES : "no");
                                        FLOG.i(sb722.toString());
                                        FLOG.i("MockTaobaoChannel - pluginName: " + str28);
                                        String str3022 = str28 + jl1.BRACKET_START_STR + str8 + jl1.BRACKET_END_STR;
                                        if (str2.length() != 0) {
                                        }
                                        if (e(str9, str11, false)) {
                                        }
                                    } catch (Throwable unused4) {
                                        bool = bool3;
                                        str3 = string;
                                        str6 = null;
                                        str4 = null;
                                        str5 = str27;
                                        z = false;
                                        if (!z) {
                                        }
                                        ApmMonitorAdapter.jstageEnd(str28, "1_0");
                                        if (str28 != null) {
                                        }
                                        ApmMonitorAdapter.jstageEnd(str28, "1_0");
                                        FLOG.printTimeCost(str28, str29, "getPackageInfo", j4);
                                        long j5222 = FLOG.get_currentTime();
                                        split = str6.split(";");
                                        String a3222 = com.alibaba.wireless.security.framework.utils.e.a(context);
                                        i2 = 0;
                                        while (true) {
                                            if (i2 >= split.length) {
                                            }
                                            i2++;
                                        }
                                        FLOG.i("MockTaobaoChannel - keepAliveProcs: " + str6);
                                        StringBuilder sb7222 = new StringBuilder();
                                        sb7222.append("MockTaobaoChannel - isKeepAliveProcess: ");
                                        sb7222.append(!this.m ? BQCCameraParam.VALUE_YES : "no");
                                        FLOG.i(sb7222.toString());
                                        FLOG.i("MockTaobaoChannel - pluginName: " + str28);
                                        String str30222 = str28 + jl1.BRACKET_START_STR + str8 + jl1.BRACKET_END_STR;
                                        if (str2.length() != 0) {
                                        }
                                        if (e(str9, str11, false)) {
                                        }
                                    }
                                } catch (JSONException unused5) {
                                    bool = bool3;
                                    str3 = string;
                                    str6 = null;
                                    str27 = null;
                                    str4 = null;
                                    str5 = str27;
                                    z = false;
                                    if (!z) {
                                    }
                                    ApmMonitorAdapter.jstageEnd(str28, "1_0");
                                    if (str28 != null) {
                                    }
                                    ApmMonitorAdapter.jstageEnd(str28, "1_0");
                                    FLOG.printTimeCost(str28, str29, "getPackageInfo", j4);
                                    long j52222 = FLOG.get_currentTime();
                                    split = str6.split(";");
                                    String a32222 = com.alibaba.wireless.security.framework.utils.e.a(context);
                                    i2 = 0;
                                    while (true) {
                                        if (i2 >= split.length) {
                                        }
                                        i2++;
                                    }
                                    FLOG.i("MockTaobaoChannel - keepAliveProcs: " + str6);
                                    StringBuilder sb72222 = new StringBuilder();
                                    sb72222.append("MockTaobaoChannel - isKeepAliveProcess: ");
                                    sb72222.append(!this.m ? BQCCameraParam.VALUE_YES : "no");
                                    FLOG.i(sb72222.toString());
                                    FLOG.i("MockTaobaoChannel - pluginName: " + str28);
                                    String str302222 = str28 + jl1.BRACKET_START_STR + str8 + jl1.BRACKET_END_STR;
                                    if (str2.length() != 0) {
                                    }
                                    if (e(str9, str11, false)) {
                                    }
                                } catch (Throwable unused6) {
                                    bool = bool3;
                                    str3 = string;
                                    str6 = null;
                                    str27 = null;
                                    str4 = null;
                                    str5 = str27;
                                    z = false;
                                    if (!z) {
                                    }
                                    ApmMonitorAdapter.jstageEnd(str28, "1_0");
                                    if (str28 != null) {
                                    }
                                    ApmMonitorAdapter.jstageEnd(str28, "1_0");
                                    FLOG.printTimeCost(str28, str29, "getPackageInfo", j4);
                                    long j522222 = FLOG.get_currentTime();
                                    split = str6.split(";");
                                    String a322222 = com.alibaba.wireless.security.framework.utils.e.a(context);
                                    i2 = 0;
                                    while (true) {
                                        if (i2 >= split.length) {
                                        }
                                        i2++;
                                    }
                                    FLOG.i("MockTaobaoChannel - keepAliveProcs: " + str6);
                                    StringBuilder sb722222 = new StringBuilder();
                                    sb722222.append("MockTaobaoChannel - isKeepAliveProcess: ");
                                    sb722222.append(!this.m ? BQCCameraParam.VALUE_YES : "no");
                                    FLOG.i(sb722222.toString());
                                    FLOG.i("MockTaobaoChannel - pluginName: " + str28);
                                    String str3022222 = str28 + jl1.BRACKET_START_STR + str8 + jl1.BRACKET_END_STR;
                                    if (str2.length() != 0) {
                                    }
                                    if (e(str9, str11, false)) {
                                    }
                                }
                                try {
                                    str4 = a2.getString("pluginclass");
                                    try {
                                        bool3 = Boolean.valueOf(a2.getBoolean("thirdpartyso"));
                                        str6 = optString;
                                        str3 = string;
                                        str5 = str27;
                                        z = true;
                                    } catch (JSONException unused7) {
                                        str6 = optString;
                                        str3 = string;
                                        str5 = str27;
                                        z = false;
                                        if (!z) {
                                        }
                                        ApmMonitorAdapter.jstageEnd(str28, "1_0");
                                        if (str28 != null) {
                                        }
                                        ApmMonitorAdapter.jstageEnd(str28, "1_0");
                                        FLOG.printTimeCost(str28, str29, "getPackageInfo", j4);
                                        long j5222222 = FLOG.get_currentTime();
                                        split = str6.split(";");
                                        String a3222222 = com.alibaba.wireless.security.framework.utils.e.a(context);
                                        i2 = 0;
                                        while (true) {
                                            if (i2 >= split.length) {
                                            }
                                            i2++;
                                        }
                                        FLOG.i("MockTaobaoChannel - keepAliveProcs: " + str6);
                                        StringBuilder sb7222222 = new StringBuilder();
                                        sb7222222.append("MockTaobaoChannel - isKeepAliveProcess: ");
                                        sb7222222.append(!this.m ? BQCCameraParam.VALUE_YES : "no");
                                        FLOG.i(sb7222222.toString());
                                        FLOG.i("MockTaobaoChannel - pluginName: " + str28);
                                        String str30222222 = str28 + jl1.BRACKET_START_STR + str8 + jl1.BRACKET_END_STR;
                                        if (str2.length() != 0) {
                                        }
                                        if (e(str9, str11, false)) {
                                        }
                                    }
                                } catch (JSONException unused8) {
                                    str6 = optString;
                                    str3 = string;
                                    str4 = null;
                                    str5 = str27;
                                    z = false;
                                    if (!z) {
                                    }
                                    ApmMonitorAdapter.jstageEnd(str28, "1_0");
                                    if (str28 != null) {
                                    }
                                    ApmMonitorAdapter.jstageEnd(str28, "1_0");
                                    FLOG.printTimeCost(str28, str29, "getPackageInfo", j4);
                                    long j52222222 = FLOG.get_currentTime();
                                    split = str6.split(";");
                                    String a32222222 = com.alibaba.wireless.security.framework.utils.e.a(context);
                                    i2 = 0;
                                    while (true) {
                                        if (i2 >= split.length) {
                                        }
                                        i2++;
                                    }
                                    FLOG.i("MockTaobaoChannel - keepAliveProcs: " + str6);
                                    StringBuilder sb72222222 = new StringBuilder();
                                    sb72222222.append("MockTaobaoChannel - isKeepAliveProcess: ");
                                    sb72222222.append(!this.m ? BQCCameraParam.VALUE_YES : "no");
                                    FLOG.i(sb72222222.toString());
                                    FLOG.i("MockTaobaoChannel - pluginName: " + str28);
                                    String str302222222 = str28 + jl1.BRACKET_START_STR + str8 + jl1.BRACKET_END_STR;
                                    if (str2.length() != 0) {
                                    }
                                    if (e(str9, str11, false)) {
                                    }
                                } catch (Throwable unused9) {
                                    str6 = optString;
                                    str3 = string;
                                    str4 = null;
                                    str5 = str27;
                                    z = false;
                                    if (!z) {
                                    }
                                    ApmMonitorAdapter.jstageEnd(str28, "1_0");
                                    if (str28 != null) {
                                    }
                                    ApmMonitorAdapter.jstageEnd(str28, "1_0");
                                    FLOG.printTimeCost(str28, str29, "getPackageInfo", j4);
                                    long j522222222 = FLOG.get_currentTime();
                                    split = str6.split(";");
                                    String a322222222 = com.alibaba.wireless.security.framework.utils.e.a(context);
                                    i2 = 0;
                                    while (true) {
                                        if (i2 >= split.length) {
                                        }
                                        i2++;
                                    }
                                    FLOG.i("MockTaobaoChannel - keepAliveProcs: " + str6);
                                    StringBuilder sb722222222 = new StringBuilder();
                                    sb722222222.append("MockTaobaoChannel - isKeepAliveProcess: ");
                                    sb722222222.append(!this.m ? BQCCameraParam.VALUE_YES : "no");
                                    FLOG.i(sb722222222.toString());
                                    FLOG.i("MockTaobaoChannel - pluginName: " + str28);
                                    String str3022222222 = str28 + jl1.BRACKET_START_STR + str8 + jl1.BRACKET_END_STR;
                                    if (str2.length() != 0) {
                                    }
                                    if (e(str9, str11, false)) {
                                    }
                                }
                                if (!z) {
                                    try {
                                        PackageInfo a4 = a(str28, lVar, str2);
                                        str3 = a4.versionName;
                                        str7 = "";
                                        String string2 = a4.applicationInfo.metaData.getString("dependencies");
                                        String string3 = a4.applicationInfo.metaData.getString("keepaliveprocs");
                                        bool = Boolean.valueOf(a4.applicationInfo.metaData.getBoolean("hasso", false));
                                        str4 = a4.applicationInfo.metaData.getString("pluginclass");
                                        Boolean valueOf = Boolean.valueOf(a4.applicationInfo.metaData.getBoolean("thirdpartyso", false));
                                        aVar.c = a4;
                                        aVar.a(a4, str28);
                                        str9 = string2;
                                        str8 = str3;
                                        str6 = string3;
                                        bool3 = valueOf;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        lVar2 = lVar;
                                        try {
                                            a(lVar2, str28, str3);
                                            throw th;
                                        } catch (Throwable th5) {
                                            SGPluginExtras.slot = 0;
                                            throw th5;
                                        }
                                    }
                                } else {
                                    str7 = "";
                                    str8 = str3;
                                    str9 = str5;
                                }
                                ApmMonitorAdapter.jstageEnd(str28, "1_0");
                                if (str28 != null) {
                                    try {
                                        if (str28.equalsIgnoreCase(getMainPluginName())) {
                                            SGApmMonitorManager.getInstance().setMainPluginVersion(str8);
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        str3 = str8;
                                        lVar2 = lVar;
                                        a(lVar2, str28, str3);
                                        throw th;
                                    }
                                }
                                ApmMonitorAdapter.jstageEnd(str28, "1_0");
                                FLOG.printTimeCost(str28, str29, "getPackageInfo", j4);
                                long j5222222222 = FLOG.get_currentTime();
                                if (this.o && str6 != null && getMainPluginName().equals(str28)) {
                                    split = str6.split(";");
                                    String a3222222222 = com.alibaba.wireless.security.framework.utils.e.a(context);
                                    if (a3222222222 != null && split != null) {
                                        i2 = 0;
                                        while (true) {
                                            if (i2 >= split.length) {
                                                break;
                                            }
                                            String trim = split[i2].trim();
                                            if (trim.length() != 0 && a3222222222.equals(trim)) {
                                                this.m = true;
                                                this.n = true;
                                                break;
                                            }
                                            i2++;
                                        }
                                        FLOG.i("MockTaobaoChannel - keepAliveProcs: " + str6);
                                        StringBuilder sb7222222222 = new StringBuilder();
                                        sb7222222222.append("MockTaobaoChannel - isKeepAliveProcess: ");
                                        sb7222222222.append(!this.m ? BQCCameraParam.VALUE_YES : "no");
                                        FLOG.i(sb7222222222.toString());
                                        FLOG.i("MockTaobaoChannel - pluginName: " + str28);
                                        String str30222222222 = str28 + jl1.BRACKET_START_STR + str8 + jl1.BRACKET_END_STR;
                                        if (str2.length() != 0) {
                                            str11 = str30222222222;
                                        } else {
                                            str11 = str2 + "->" + str30222222222;
                                        }
                                        if (e(str9, str11, false)) {
                                            if (str2.length() != 0) {
                                                str30222222222 = str2 + "->" + str30222222222;
                                            }
                                            if (lVar.c != null) {
                                                sb5 = new StringBuilder();
                                                sb5.append("src:");
                                                d6 = d(lVar.c.getAbsolutePath());
                                            } else {
                                                sb5 = new StringBuilder();
                                                sb5.append("zipfile:");
                                                d6 = d(lVar.a.getAbsolutePath());
                                            }
                                            sb5.append(d6);
                                            a(100043, 136, "loadRequirements failed", str9, str30222222222, sb5.toString(), "");
                                            throw new SecException(136);
                                        }
                                        try {
                                            a(str28, str8);
                                            ApmMonitorAdapter.jstageStart(str28, "1_1");
                                            if (bool.booleanValue()) {
                                                try {
                                                    str24 = "libsg" + str28 + "so-" + str8 + ".so";
                                                    str25 = "sg" + str28 + "so-" + str8;
                                                    str10 = str8;
                                                    str14 = str7;
                                                    c2 = 0;
                                                    str17 = "1_1";
                                                    j2 = j5222222222;
                                                    str15 = str29;
                                                    str16 = "->";
                                                    str18 = str30222222222;
                                                    str13 = absolutePath2;
                                                } catch (Throwable th7) {
                                                    th = th7;
                                                    str10 = str8;
                                                    str28 = str;
                                                    th = th;
                                                    lVar2 = lVar;
                                                    str3 = str10;
                                                    a(lVar2, str28, str3);
                                                    throw th;
                                                }
                                                try {
                                                    if (!a(absolutePath, absolutePath2, lVar.c, str24, lVar.d)) {
                                                        if (str2.length() == 0) {
                                                            str26 = str18;
                                                        } else {
                                                            str26 = str2 + str16 + str18;
                                                        }
                                                        if (lVar.c != null) {
                                                            sb4 = new StringBuilder();
                                                            sb4.append("src:");
                                                            d5 = d(lVar.c.getAbsolutePath());
                                                        } else {
                                                            sb4 = new StringBuilder();
                                                            sb4.append("zipfile:");
                                                            d5 = d(lVar.a.getAbsolutePath());
                                                        }
                                                        sb4.append(d5);
                                                        a(100043, 107, "", str9, str26, sb4.toString(), "");
                                                        throw new SecException(107);
                                                    }
                                                    str20 = str24;
                                                    str19 = str25;
                                                } catch (Throwable th8) {
                                                    th = th8;
                                                    str28 = str;
                                                    th = th;
                                                    lVar2 = lVar;
                                                    str3 = str10;
                                                    a(lVar2, str28, str3);
                                                    throw th;
                                                }
                                            } else {
                                                j2 = j5222222222;
                                                str18 = str30222222222;
                                                str10 = str8;
                                                str13 = absolutePath2;
                                                str14 = str7;
                                                c2 = 0;
                                                str17 = "1_1";
                                                str15 = str29;
                                                str16 = "->";
                                                str20 = str14;
                                                str19 = str20;
                                            }
                                            if (str4 == null) {
                                                if (str2.length() == 0) {
                                                    str23 = str18;
                                                } else {
                                                    str23 = str2 + str16 + str18;
                                                }
                                                if (lVar.c != null) {
                                                    sb3 = new StringBuilder();
                                                    sb3.append("src:");
                                                    d4 = d(lVar.c.getAbsolutePath());
                                                } else {
                                                    sb3 = new StringBuilder();
                                                    sb3.append("zipfile:");
                                                    d4 = d(lVar.a.getAbsolutePath());
                                                }
                                                sb3.append(d4);
                                                a(100043, SecExceptionCode.SEC_ERROR_INIT_PLUGIN_CLASS_ERROR, "miss pluginclass", str9, str23, sb3.toString(), "");
                                                throw new SecException(SecExceptionCode.SEC_ERROR_INIT_PLUGIN_CLASS_ERROR);
                                            }
                                            str28 = str;
                                            try {
                                                ApmMonitorAdapter.jstageEnd(str28, str17);
                                                String trim2 = str4.trim();
                                                FLOG.printTimeCost(str28, str15, "extractSoInPlugin", j2);
                                                long j6 = FLOG.get_currentTime();
                                                ApmMonitorAdapter.jstageStart(str28, "1_2");
                                                ClassLoader a5 = a(absolutePath, str13, lVar.d);
                                                Class<?> a6 = a(a5, trim2);
                                                FLOG.printTimeCost(str28, str15, "createClassLoader", j6);
                                                long j7 = FLOG.get_currentTime();
                                                if (a6 == null) {
                                                    try {
                                                        FLOG.i("load " + trim2 + " failed from plugin ");
                                                        if (str2.length() == 0) {
                                                            str22 = str18;
                                                        } else {
                                                            str22 = str2 + str16 + str18;
                                                        }
                                                        if (lVar.c != null) {
                                                            sb2 = new StringBuilder();
                                                            sb2.append("src:");
                                                            d3 = d(lVar.c.getAbsolutePath());
                                                        } else {
                                                            sb2 = new StringBuilder();
                                                            sb2.append("zipfile:");
                                                            d3 = d(lVar.a.getAbsolutePath());
                                                        }
                                                        sb2.append(d3);
                                                        a(100043, SecExceptionCode.SEC_ERROR_INIT_CLAZZ_NULL_ERROR, "clazz == null", str9, str22, sb2.toString(), trim2);
                                                        throw new SecException(SecExceptionCode.SEC_ERROR_INIT_CLAZZ_NULL_ERROR);
                                                    } catch (Throwable th9) {
                                                        th = th9;
                                                        th = th;
                                                        lVar2 = lVar;
                                                        str3 = str10;
                                                        a(lVar2, str28, str3);
                                                        throw th;
                                                    }
                                                } else {
                                                    try {
                                                        try {
                                                            ISecurityGuardPlugin iSecurityGuardPlugin = (ISecurityGuardPlugin) a6.newInstance();
                                                            String str31 = "zipfile:";
                                                            String str32 = "src:";
                                                            String str33 = str18;
                                                            String str34 = str16;
                                                            String str35 = str20;
                                                            String str36 = str13;
                                                            try {
                                                                cVar = new c(absolutePath, this, str, a5, aVar, iSecurityGuardPlugin);
                                                                boolean z2 = this.h;
                                                                if (str28.equalsIgnoreCase(getMainPluginName())) {
                                                                    if (this.l) {
                                                                        z2 = (z2 ? 1 : 0) | true;
                                                                    }
                                                                    String str37 = this.i;
                                                                    if (str37 != null && str37.length() > 0) {
                                                                        boolean z3 = z2 ? 1 : 0;
                                                                        char c4 = z2 ? 1 : 0;
                                                                        z2 = z3 | true;
                                                                    }
                                                                    if (com.alibaba.wireless.security.framework.utils.e.c(this.c)) {
                                                                        boolean z4 = z2 ? 1 : 0;
                                                                        char c5 = z2 ? 1 : 0;
                                                                        z2 = z4 | true;
                                                                    }
                                                                    if (com.alibaba.wireless.security.framework.utils.e.d(this.c)) {
                                                                        boolean z5 = z2 ? 1 : 0;
                                                                        char c6 = z2 ? 1 : 0;
                                                                        char c7 = z2 ? 1 : 0;
                                                                        z2 = z5 | true;
                                                                    }
                                                                    try {
                                                                        b bVar = this.k;
                                                                        if (bVar != null) {
                                                                            str21 = bVar.a().toString();
                                                                            Object[] objArr = new Object[4];
                                                                            int i3 = z2 ? 1 : 0;
                                                                            int i4 = z2 ? 1 : 0;
                                                                            int i5 = z2 ? 1 : 0;
                                                                            int i6 = z2 ? 1 : 0;
                                                                            objArr[c2] = Integer.valueOf(i3);
                                                                            c3 = 1;
                                                                            objArr[1] = str21;
                                                                            objArr[2] = this.s.getAbsolutePath();
                                                                            objArr[3] = this.j;
                                                                            this.f = iSecurityGuardPlugin.onPluginLoaded(context, null, cVar, str19, objArr);
                                                                            FLOG.printTimeCost(str28, str15, "onPluginLoaded", j7);
                                                                            j3 = FLOG.get_currentTime();
                                                                        }
                                                                    } catch (Throwable unused10) {
                                                                    }
                                                                    str21 = str14;
                                                                    Object[] objArr2 = new Object[4];
                                                                    int i32 = z2 ? 1 : 0;
                                                                    int i42 = z2 ? 1 : 0;
                                                                    int i52 = z2 ? 1 : 0;
                                                                    int i62 = z2 ? 1 : 0;
                                                                    objArr2[c2] = Integer.valueOf(i32);
                                                                    c3 = 1;
                                                                    objArr2[1] = str21;
                                                                    objArr2[2] = this.s.getAbsolutePath();
                                                                    objArr2[3] = this.j;
                                                                    this.f = iSecurityGuardPlugin.onPluginLoaded(context, null, cVar, str19, objArr2);
                                                                    FLOG.printTimeCost(str28, str15, "onPluginLoaded", j7);
                                                                    j3 = FLOG.get_currentTime();
                                                                } else {
                                                                    c3 = 1;
                                                                    SGPluginExtras.slot = 0;
                                                                    IRouterComponent iRouterComponent = this.f;
                                                                    Object[] objArr3 = new Object[1];
                                                                    int i7 = z2 ? 1 : 0;
                                                                    int i8 = z2 ? 1 : 0;
                                                                    objArr3[c2] = Integer.valueOf(i7);
                                                                    iSecurityGuardPlugin.onPluginLoaded(context, iRouterComponent, cVar, str19, objArr3);
                                                                    j3 = j7;
                                                                }
                                                                ApmMonitorAdapter.jstageEnd(str28, "1_2");
                                                                if (bool.booleanValue() && !bool3.booleanValue()) {
                                                                    String a7 = com.alibaba.wireless.security.framework.utils.e.a(a5, str19);
                                                                    ApmMonitorAdapter.jstageStart(str28, "1_3");
                                                                    IRouterComponent iRouterComponent2 = this.f;
                                                                    Object[] objArr4 = new Object[3];
                                                                    objArr4[c2] = str28;
                                                                    objArr4[c3] = str10;
                                                                    objArr4[2] = a7;
                                                                    iRouterComponent2.doCommand(Constants.REQUEST_APPBAR, objArr4);
                                                                    ApmMonitorAdapter.jstageEnd(str28, "1_3");
                                                                    FLOG.printTimeCost(str28, str15, "10102", j3);
                                                                }
                                                            } catch (IllegalAccessException | InstantiationException e3) {
                                                                th3 = e3;
                                                                cVar2 = cVar;
                                                                FLOG.w(str14, th3);
                                                                cVar = cVar2;
                                                                SGPluginExtras.slot = 0;
                                                                return cVar;
                                                            } catch (SecException e4) {
                                                                SecException e5 = e4;
                                                                SecException secException = e5;
                                                                try {
                                                                    File file = new File(str36 + File.separator + str35);
                                                                    if (secException.getErrorCode() != 103) {
                                                                    }
                                                                    throw secException;
                                                                } catch (Throwable th10) {
                                                                    th2 = th10;
                                                                    lVar2 = lVar;
                                                                    th = th2;
                                                                    str3 = str10;
                                                                    a(lVar2, str28, str3);
                                                                    throw th;
                                                                }
                                                            }
                                                        } catch (InstantiationException e6) {
                                                            e2 = e6;
                                                            th3 = e2;
                                                            cVar2 = null;
                                                            FLOG.w(str14, th3);
                                                            cVar = cVar2;
                                                            SGPluginExtras.slot = 0;
                                                            return cVar;
                                                        } catch (IllegalAccessException e7) {
                                                            e2 = e7;
                                                            th3 = e2;
                                                            cVar2 = null;
                                                            FLOG.w(str14, th3);
                                                            cVar = cVar2;
                                                            SGPluginExtras.slot = 0;
                                                            return cVar;
                                                        } catch (SecException e42) {
                                                            SecException e52 = e42;
                                                            SecException secException2 = e52;
                                                            try {
                                                                File file2 = new File(str36 + File.separator + str35);
                                                                if (secException2.getErrorCode() != 103) {
                                                                }
                                                                throw secException2;
                                                            } catch (Throwable th102) {
                                                                th2 = th102;
                                                                lVar2 = lVar;
                                                                th = th2;
                                                                str3 = str10;
                                                                a(lVar2, str28, str3);
                                                                throw th;
                                                            }
                                                        }
                                                    } catch (InstantiationException e62) {
                                                        e2 = e62;
                                                        th3 = e2;
                                                        cVar2 = null;
                                                        FLOG.w(str14, th3);
                                                        cVar = cVar2;
                                                        SGPluginExtras.slot = 0;
                                                        return cVar;
                                                    } catch (IllegalAccessException e72) {
                                                        e2 = e72;
                                                        th3 = e2;
                                                        cVar2 = null;
                                                        FLOG.w(str14, th3);
                                                        cVar = cVar2;
                                                        SGPluginExtras.slot = 0;
                                                        return cVar;
                                                    } catch (SecException e8) {
                                                    }
                                                    SGPluginExtras.slot = 0;
                                                    return cVar;
                                                }
                                            } catch (Throwable th11) {
                                                th2 = th11;
                                                lVar2 = lVar;
                                                th = th2;
                                                str3 = str10;
                                                a(lVar2, str28, str3);
                                                throw th;
                                            }
                                        } catch (SecException e9) {
                                            if (str2.length() == 0) {
                                                str12 = str30222222222;
                                            } else {
                                                str12 = str2 + "->" + str30222222222;
                                            }
                                            if (lVar.c != null) {
                                                sb = new StringBuilder();
                                                sb.append("src:");
                                                d2 = d(lVar.c.getAbsolutePath());
                                            } else {
                                                sb = new StringBuilder();
                                                sb.append("zipfile:");
                                                d2 = d(lVar.a.getAbsolutePath());
                                            }
                                            sb.append(d2);
                                            a(100043, 137, "isMeetReverseDependencies failed", str9, str12, sb.toString(), "");
                                            throw e9;
                                        }
                                    }
                                }
                                FLOG.i("MockTaobaoChannel - keepAliveProcs: " + str6);
                                StringBuilder sb72222222222 = new StringBuilder();
                                sb72222222222.append("MockTaobaoChannel - isKeepAliveProcess: ");
                                sb72222222222.append(!this.m ? BQCCameraParam.VALUE_YES : "no");
                                FLOG.i(sb72222222222.toString());
                                FLOG.i("MockTaobaoChannel - pluginName: " + str28);
                                String str302222222222 = str28 + jl1.BRACKET_START_STR + str8 + jl1.BRACKET_END_STR;
                                if (str2.length() != 0) {
                                }
                                if (e(str9, str11, false)) {
                                }
                            }
                        } catch (JSONException unused11) {
                            bool = bool3;
                            str3 = null;
                            str6 = null;
                            str27 = null;
                            str4 = null;
                            str5 = str27;
                            z = false;
                            if (!z) {
                            }
                            ApmMonitorAdapter.jstageEnd(str28, "1_0");
                            if (str28 != null) {
                            }
                            ApmMonitorAdapter.jstageEnd(str28, "1_0");
                            FLOG.printTimeCost(str28, str29, "getPackageInfo", j4);
                            long j52222222222 = FLOG.get_currentTime();
                            split = str6.split(";");
                            String a32222222222 = com.alibaba.wireless.security.framework.utils.e.a(context);
                            i2 = 0;
                            while (true) {
                                if (i2 >= split.length) {
                                }
                                i2++;
                            }
                            FLOG.i("MockTaobaoChannel - keepAliveProcs: " + str6);
                            StringBuilder sb722222222222 = new StringBuilder();
                            sb722222222222.append("MockTaobaoChannel - isKeepAliveProcess: ");
                            sb722222222222.append(!this.m ? BQCCameraParam.VALUE_YES : "no");
                            FLOG.i(sb722222222222.toString());
                            FLOG.i("MockTaobaoChannel - pluginName: " + str28);
                            String str3022222222222 = str28 + jl1.BRACKET_START_STR + str8 + jl1.BRACKET_END_STR;
                            if (str2.length() != 0) {
                            }
                            if (e(str9, str11, false)) {
                            }
                        } catch (Throwable unused12) {
                            bool = bool3;
                            str3 = null;
                            str6 = null;
                            str27 = null;
                            str4 = null;
                            str5 = str27;
                            z = false;
                            if (!z) {
                            }
                            ApmMonitorAdapter.jstageEnd(str28, "1_0");
                            if (str28 != null) {
                            }
                            ApmMonitorAdapter.jstageEnd(str28, "1_0");
                            FLOG.printTimeCost(str28, str29, "getPackageInfo", j4);
                            long j522222222222 = FLOG.get_currentTime();
                            split = str6.split(";");
                            String a322222222222 = com.alibaba.wireless.security.framework.utils.e.a(context);
                            i2 = 0;
                            while (true) {
                                if (i2 >= split.length) {
                                }
                                i2++;
                            }
                            FLOG.i("MockTaobaoChannel - keepAliveProcs: " + str6);
                            StringBuilder sb7222222222222 = new StringBuilder();
                            sb7222222222222.append("MockTaobaoChannel - isKeepAliveProcess: ");
                            sb7222222222222.append(!this.m ? BQCCameraParam.VALUE_YES : "no");
                            FLOG.i(sb7222222222222.toString());
                            FLOG.i("MockTaobaoChannel - pluginName: " + str28);
                            String str30222222222222 = str28 + jl1.BRACKET_START_STR + str8 + jl1.BRACKET_END_STR;
                            if (str2.length() != 0) {
                            }
                            if (e(str9, str11, false)) {
                            }
                        }
                    }
                } catch (Throwable th12) {
                    th = th12;
                    lVar2 = lVar;
                    str3 = null;
                    a(lVar2, str28, str3);
                    throw th;
                }
            }
            bool = bool3;
            str3 = null;
            str6 = null;
            z = false;
            str5 = null;
            str4 = null;
            if (!z) {
            }
            try {
                ApmMonitorAdapter.jstageEnd(str28, "1_0");
                if (str28 != null) {
                }
                ApmMonitorAdapter.jstageEnd(str28, "1_0");
                FLOG.printTimeCost(str28, str29, "getPackageInfo", j4);
                long j5222222222222 = FLOG.get_currentTime();
                split = str6.split(";");
                String a3222222222222 = com.alibaba.wireless.security.framework.utils.e.a(context);
                i2 = 0;
                while (true) {
                    if (i2 >= split.length) {
                    }
                    i2++;
                }
                FLOG.i("MockTaobaoChannel - keepAliveProcs: " + str6);
                StringBuilder sb72222222222222 = new StringBuilder();
                sb72222222222222.append("MockTaobaoChannel - isKeepAliveProcess: ");
                sb72222222222222.append(!this.m ? BQCCameraParam.VALUE_YES : "no");
                FLOG.i(sb72222222222222.toString());
                FLOG.i("MockTaobaoChannel - pluginName: " + str28);
                String str302222222222222 = str28 + jl1.BRACKET_START_STR + str8 + jl1.BRACKET_END_STR;
                if (str2.length() != 0) {
                }
                if (e(str9, str11, false)) {
                }
            } catch (Throwable th13) {
                th2 = th13;
                str10 = str8;
                lVar2 = lVar;
                th = th2;
                str3 = str10;
                a(lVar2, str28, str3);
                throw th;
            }
        } catch (Throwable th14) {
            lVar2 = lVar;
            th = th14;
            str3 = null;
            a(lVar2, str28, str3);
            throw th;
        }
    }

    private File a(Context context) throws SecException {
        if (context != null) {
            String str = null;
            try {
                String str2 = context.getApplicationInfo().sourceDir;
                if (str2 != null) {
                    File file = new File(str2);
                    if (file.exists()) {
                        str = (file.lastModified() / 1000) + "";
                    }
                }
                if (str != null) {
                    File dir = context.getDir("SGLib", 0);
                    this.s = dir;
                    if (dir == null || !dir.exists()) {
                        a(100038, 109, "", "" + this.s, "", "", "");
                        throw new SecException(109);
                    }
                    File file2 = new File(this.s.getAbsolutePath(), "app_" + str);
                    if (!file2.exists()) {
                        file2.mkdirs();
                        if (!file2.exists()) {
                            file2.mkdirs();
                        }
                    }
                    if (x && file2.exists()) {
                        x = false;
                        a(this.s, "app_" + str);
                    }
                    if (file2.exists()) {
                        return file2;
                    }
                    a(100038, 114, "", "", "", "", "");
                    throw new SecException(114);
                }
                throw new SecException(115);
            } catch (Throwable th) {
                a(100038, 115, "", "" + th, "", "", "");
                throw new SecException(th, 115);
            }
        } else {
            a(100038, 116, "", "", "", "", "");
            throw new SecException(116);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x006a, code lost:
        if (a(r6, r7.b()) == false) goto L_0x006c;
     */
    private File a(Context context, b bVar) {
        File file;
        if (com.alibaba.wireless.security.framework.utils.e.c(context) || bVar == null || bVar.b() == 0 || bVar.c() == null || bVar.c().length() <= 0) {
            return null;
        }
        if (h()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.s.getAbsolutePath());
            String str = File.separator;
            sb.append(str);
            sb.append("upds");
            sb.append(str);
            sb.append("libs");
            sb.append(str);
            sb.append(bVar.b());
            sb.append(str);
            sb.append(bVar.c());
            file = new File(sb.toString());
        }
        file = null;
        if (file == null || !file.isDirectory()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.r.getAbsolutePath());
            String str2 = File.separator;
            sb2.append(str2);
            sb2.append("libs");
            sb2.append(str2);
            sb2.append(bVar.b());
            sb2.append(str2);
            sb2.append(bVar.c());
            file = new File(sb2.toString());
            if (!a(file, bVar.b())) {
                file = null;
            }
        }
        if (file == null || file.exists()) {
            return file;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0088 A[SYNTHETIC, Splitter:B:29:0x0088] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0090 A[SYNTHETIC, Splitter:B:36:0x0090] */
    private File a(String str, File file) {
        String str2;
        Throwable th;
        IOException e2;
        ZipFile zipFile;
        ZipFile zipFile2 = null;
        File file2 = null;
        try {
            str2 = this.c.getApplicationInfo().sourceDir;
        } catch (Throwable unused) {
            str2 = null;
        }
        if (str2 == null) {
            return null;
        }
        String str3 = "libsg" + str + ".so";
        try {
            FLOG.i("Plugin not existed in the application library path, maybe installed in x86 phone, or the armeabi-v7a existed");
            zipFile = new ZipFile(str2);
            try {
                String[] strArr = v;
                int length = strArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 < length) {
                        String str4 = strArr[i2];
                        StringBuilder sb = new StringBuilder();
                        sb.append(SolidMonitor.CHECK_TYPE_LIB);
                        String str5 = File.separator;
                        sb.append(str5);
                        sb.append(str4);
                        sb.append(str5);
                        sb.append(str3);
                        String sb2 = sb.toString();
                        if (zipFile.getEntry(sb2) != null) {
                            w = str4;
                            file2 = a(str, file, zipFile, sb2);
                            break;
                        }
                        i2++;
                    }
                }
                try {
                    zipFile.close();
                } catch (Throwable unused2) {
                }
                return file2;
            } catch (IOException e3) {
                e2 = e3;
                try {
                    FLOG.w("getPluginFile throws exception", e2);
                    a(100047, 3, e2.toString(), str, d(str2), "", "");
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    zipFile2 = zipFile;
                    if (zipFile2 != null) {
                    }
                    throw th;
                }
            }
        } catch (IOException e4) {
            e2 = e4;
            zipFile = null;
            FLOG.w("getPluginFile throws exception", e2);
            a(100047, 3, e2.toString(), str, d(str2), "", "");
            if (zipFile != null) {
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (zipFile2 != null) {
                try {
                    zipFile2.close();
                } catch (Throwable unused4) {
                }
            }
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0038, code lost:
        if (r1 != null) goto L_0x0014;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0040 A[SYNTHETIC, Splitter:B:23:0x0040] */
    private File a(String str, File file, String str2, String str3) {
        Throwable th;
        IOException e2;
        ZipFile zipFile;
        ZipFile zipFile2 = null;
        r0 = null;
        File file2 = null;
        if (str2 == null || str3 == null) {
            return null;
        }
        try {
            FLOG.i("Plugin not existed in the application library path, maybe installed in x86 phone, or the armeabi-v7a existed");
            zipFile = new ZipFile(str2);
            try {
                file2 = a(str, file, zipFile, str3);
            } catch (IOException e3) {
                e2 = e3;
                try {
                    FLOG.w("getPluginFile throws exception", e2);
                    a(100047, 3, e2.toString(), str, d(str2), "", "");
                } catch (Throwable th2) {
                    th = th2;
                    zipFile2 = zipFile;
                    if (zipFile2 != null) {
                    }
                    throw th;
                }
            }
        } catch (IOException e4) {
            e2 = e4;
            zipFile = null;
            FLOG.w("getPluginFile throws exception", e2);
            a(100047, 3, e2.toString(), str, d(str2), "", "");
        } catch (Throwable th3) {
            th = th3;
            if (zipFile2 != null) {
                try {
                    zipFile2.close();
                } catch (Throwable unused) {
                }
            }
            throw th;
        }
        try {
            zipFile.close();
        } catch (Throwable unused2) {
        }
        return file2;
    }

    private File a(String str, File file, ZipFile zipFile, String str2) throws IOException {
        ZipEntry entry;
        if (!(zipFile == null || str2 == null || (entry = zipFile.getEntry(str2)) == null || !com.alibaba.wireless.security.framework.utils.a.a(entry.getName()))) {
            File file2 = new File(file, "libsg" + str + "_inner" + entry.getTime() + ".zip");
            if ((!file2.exists() || file2.length() != entry.getSize()) && !com.alibaba.wireless.security.framework.utils.e.a(zipFile, entry, file2)) {
                FLOG.i("Extract failed!!");
            } else {
                FLOG.i("Extract success");
                return file2;
            }
        }
        return null;
    }

    private Class<?> a(ClassLoader classLoader, String str) {
        Class<?> cls;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            cls = Class.forName(str, true, classLoader);
        } catch (Throwable th) {
            a(100042, 132, "Class.forName failed", "" + th, str, classLoader.toString(), "");
            cls = null;
        }
        FLOG.i("    loadClassFromClassLoader( " + str + " ) used time: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return cls;
    }

    private ClassLoader a(String str, String str2, boolean z) {
        if (!z) {
            try {
                this.g.a();
            } catch (Throwable th) {
                if (!z) {
                    this.g.b();
                }
                throw th;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.c.getApplicationInfo().nativeLibraryDir);
        String str3 = File.pathSeparator;
        sb.append(str3);
        sb.append(str2);
        String sb2 = sb.toString();
        if (this.i != null) {
            sb2 = sb2 + str3 + this.i;
            FLOG.i("add path to native classloader " + sb2);
        }
        if (w != null) {
            sb2 = sb2 + str3 + this.c.getApplicationInfo().sourceDir + "!/lib/" + w;
        }
        ClassLoader dexClassLoader = (Build.VERSION.SDK_INT < 21 || "6.0.1".equalsIgnoreCase(Build.VERSION.getRELEASE())) ? new DexClassLoader(str, str2, sb2, d.class.getClassLoader()) : new PathClassLoader(str, sb2, d.class.getClassLoader());
        if (!z) {
            this.g.b();
        }
        return dexClassLoader;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(int i2, int i3, String str, String str2, String str3, String str4, String str5) {
        UserTrackMethodJniBridge.addUtRecord("" + i2, i3, 0, com.alibaba.wireless.security.open.initialize.c.a(), 0, str, str2, str3, str4, str5);
    }

    private void a(l lVar, String str, String str2) {
        if (c(lVar.c)) {
            int b2 = this.k.b();
            String str3 = "PluginName=" + str;
            String str4 = "PluginVersion=" + str2;
            String str5 = "LibDeployVersion=" + b2;
            a(100048, 135, "Write dyInit.config", str3, str4, str5, "write success=" + com.alibaba.wireless.security.framework.utils.a.a(new File(this.r, "dyInit.config"), Integer.toString(b2)));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(File file) {
        String[] list;
        if (file.isDirectory() && (list = file.list()) != null) {
            for (String str : list) {
                a(new File(file, str));
            }
        }
        file.delete();
    }

    private void a(File file, String str) {
        new Thread(new c(file, str), "SGCleanFile").start();
    }

    private boolean a(File file, int i2) {
        return new File(file, ".finish").isFile();
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c0 A[SYNTHETIC, Splitter:B:39:0x00c0] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00cb A[SYNTHETIC, Splitter:B:44:0x00cb] */
    private boolean a(File file, File file2) {
        FileChannel fileChannel;
        FileChannel fileChannel2;
        Throwable th;
        FileChannel channel;
        File file3 = new File(file2.getAbsolutePath() + ".tmp." + Process.myPid());
        boolean z = false;
        try {
            if (file3.exists()) {
                file3.delete();
            }
            try {
                FileChannel channel2 = new FileInputStream(file).getChannel();
                try {
                    channel = new FileOutputStream(file3).getChannel();
                } catch (Throwable th2) {
                    th = th2;
                    fileChannel = null;
                    fileChannel2 = channel2;
                    try {
                        FLOG.w("", th);
                        a(100047, 2, th.toString(), d(file.getAbsolutePath()), d(file2.getAbsolutePath()), d(file3.getAbsolutePath()), "");
                        if (fileChannel2 != null) {
                        }
                        if (fileChannel != null) {
                        }
                        file3.delete();
                        return z;
                    } catch (Throwable th3) {
                        FLOG.w("", th3);
                    }
                }
                try {
                    channel.transferFrom(channel2, 0, channel2.size());
                    channel2.close();
                } catch (Throwable th4) {
                    th = th4;
                    fileChannel2 = channel2;
                    fileChannel = channel;
                    FLOG.w("", th);
                    a(100047, 2, th.toString(), d(file.getAbsolutePath()), d(file2.getAbsolutePath()), d(file3.getAbsolutePath()), "");
                    if (fileChannel2 != null) {
                    }
                    if (fileChannel != null) {
                    }
                    file3.delete();
                    return z;
                }
            } catch (Throwable th5) {
                th = th5;
                fileChannel2 = null;
                fileChannel = null;
                FLOG.w("", th);
                a(100047, 2, th.toString(), d(file.getAbsolutePath()), d(file2.getAbsolutePath()), d(file3.getAbsolutePath()), "");
                if (fileChannel2 != null) {
                }
                if (fileChannel != null) {
                }
                file3.delete();
                return z;
            }
            try {
                channel.close();
                if (file3.length() == file.length()) {
                    if (file2.exists()) {
                        if (file2.length() == file.length()) {
                            z = true;
                        } else {
                            file2.delete();
                        }
                    }
                    z = file3.renameTo(file2);
                }
            } catch (Throwable th6) {
                th = th6;
                fileChannel2 = null;
                fileChannel = channel;
                FLOG.w("", th);
                a(100047, 2, th.toString(), d(file.getAbsolutePath()), d(file2.getAbsolutePath()), d(file3.getAbsolutePath()), "");
                if (fileChannel2 != null) {
                    try {
                        fileChannel2.close();
                    } catch (Throwable th7) {
                        FLOG.w("", th7);
                    }
                }
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (Throwable th8) {
                        FLOG.w("", th8);
                    }
                }
                file3.delete();
                return z;
            }
        } catch (Throwable th9) {
            th = th9;
            fileChannel2 = null;
            fileChannel = null;
            FLOG.w("", th);
            a(100047, 2, th.toString(), d(file.getAbsolutePath()), d(file2.getAbsolutePath()), d(file3.getAbsolutePath()), "");
            if (fileChannel2 != null) {
            }
            if (fileChannel != null) {
            }
            file3.delete();
            return z;
        }
        file3.delete();
        return z;
        file3.delete();
        throw th;
        if (fileChannel != null) {
            fileChannel.close();
        }
        file3.delete();
        throw th;
    }

    private boolean a(String str, String str2) throws SecException {
        for (Map.Entry<String, c> entry : this.d.entrySet()) {
            String key = entry.getKey();
            c value = entry.getValue();
            String a2 = value.a("reversedependencies");
            if (a2 != null) {
                String[] split = a2.split(";");
                for (int i2 = 0; i2 < split.length; i2++) {
                    String trim = split[i2].trim();
                    if (trim.length() != 0) {
                        String[] split2 = trim.split(":");
                        if (split2.length != 2) {
                            a(100041, 131, "nameVersionPair.length != 2", str + jl1.BRACKET_START_STR + str2 + jl1.BRACKET_END_STR, key + jl1.BRACKET_START_STR + value.getVersion() + jl1.BRACKET_END_STR, d(value.getPluginPath()), a2);
                            throw new SecException(131);
                        } else if (split2[0].equalsIgnoreCase(str) && b(str2, split2[1]) < 0) {
                            String str3 = "plugin " + str + jl1.BRACKET_START_STR + str2 + ") is not meet the reverse dependency of " + key + jl1.BRACKET_START_STR + value.getVersion() + "): " + split2[0] + jl1.BRACKET_START_STR + split2[1] + jl1.BRACKET_END_STR;
                            a(100041, 117, str3, d.class.getClassLoader().toString(), d(value.getPluginPath()), a2, "" + i2);
                            throw new SecException(str3, 117);
                        }
                    }
                }
                continue;
            }
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0133, code lost:
        if (r21 == false) goto L_0x0173;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0179, code lost:
        return false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x014d A[Catch:{ all -> 0x017a }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0164  */
    private synchronized boolean a(String str, String str2, File file, String str3, boolean z) {
        String str4;
        Throwable th;
        if (com.alibaba.wireless.security.framework.utils.e.c(this.c) && Build.VERSION.SDK_INT > 19) {
            return true;
        }
        if (this.i != null) {
            return true;
        }
        if (file != null) {
            if (new File(file.getParent(), str3).exists()) {
                if (!c(file)) {
                    return true;
                }
                if (this.l) {
                    File file2 = new File(str2, str3);
                    if (file2.exists()) {
                        return true;
                    }
                    a(100039, 126, "return true without extraction", "apkPath=" + str + ",srcLibDir=" + file, file2.getAbsolutePath(), str3, com.alibaba.wireless.security.framework.utils.e.a(this.c));
                }
            }
            str4 = file.getAbsolutePath();
        } else {
            str4 = str;
        }
        if (!z) {
            this.g.a();
        }
        File file3 = null;
        try {
            File file4 = new File(str2, str3);
            try {
                if (file4.exists()) {
                    if (!z) {
                        this.g.b();
                    }
                    return true;
                } else if (com.alibaba.wireless.security.framework.utils.e.a(str4, str3, file4)) {
                    if (!this.l && c(file)) {
                        a(100039, 127, "so extracted in child process", str4, file4.getAbsolutePath(), str3, com.alibaba.wireless.security.framework.utils.e.a(this.c));
                    }
                    if (!z) {
                        this.g.b();
                    }
                    return true;
                } else if (com.alibaba.wireless.security.framework.utils.e.a(this.c.getApplicationInfo().sourceDir, str3, file4)) {
                    if (!z) {
                        this.g.b();
                    }
                    return true;
                } else {
                    String[] strArr = new String[0];
                    if (Build.VERSION.SDK_INT >= 21) {
                        strArr = this.c.getApplicationInfo().splitSourceDirs;
                    }
                    for (int i2 = 0; i2 < strArr.length; i2++) {
                        FLOG.i("zipFilePath3[" + i2 + "] = " + strArr[i2]);
                        if (com.alibaba.wireless.security.framework.utils.e.a(strArr[i2], str3, file4)) {
                            if (!z) {
                                this.g.b();
                            }
                            return true;
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                file3 = file4;
                try {
                    a(100039, 107, th.toString(), j(), d(str4), file3 == null ? d(file3.getAbsolutePath()) : "", file == null ? d(file.getAbsolutePath()) : "");
                    FLOG.w("", th);
                } finally {
                    if (!z) {
                        this.g.b();
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            a(100039, 107, th.toString(), j(), d(str4), file3 == null ? d(file3.getAbsolutePath()) : "", file == null ? d(file.getAbsolutePath()) : "");
            FLOG.w("", th);
        }
    }

    private int b(String str, String str2) {
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int length = split.length < split2.length ? split.length : split2.length;
        for (int i2 = 0; i2 < length; i2++) {
            int parseInt = Integer.parseInt(split[i2]);
            int parseInt2 = Integer.parseInt(split2[i2]);
            if (parseInt > parseInt2) {
                return 1;
            }
            if (parseInt < parseInt2) {
                return -1;
            }
        }
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0056 A[SYNTHETIC, Splitter:B:17:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0081 A[Catch:{ all -> 0x0062 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b7 A[Catch:{ all -> 0x0062 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00b5 A[EDGE_INSN: B:73:0x00b5->B:34:0x00b5 ?: BREAK  , SYNTHETIC] */
    private l b(String str, String str2, boolean z) throws SecException {
        boolean z2;
        File file;
        File file2;
        l lVar;
        String absolutePath;
        int length;
        File file3 = this.t;
        int i2 = 0;
        if (file3 != null) {
            file = new File(file3, "libsg" + str + ".so");
            if (file.exists()) {
                file2 = b(this.t);
                if (file2 != this.t) {
                    z2 = true;
                    if (file2 == null) {
                        file2 = b(this.r);
                        z2 = file2 != this.r;
                    }
                    if (!z2) {
                        this.g.a();
                    }
                    if (file == null) {
                        try {
                            file = b(str);
                            if (!d(file)) {
                                file = null;
                            }
                        } catch (Throwable th) {
                            if (!z2) {
                                this.g.b();
                            }
                            throw th;
                        }
                    }
                    if (file != null && (absolutePath = file.getAbsolutePath()) != null && absolutePath.contains("!/")) {
                        String[] split = absolutePath.split("!/", 2);
                        String str3 = split[0];
                        String str4 = split[1];
                        String[] strArr = v;
                        length = strArr.length;
                        while (true) {
                            if (i2 >= length) {
                                break;
                            }
                            String str5 = strArr[i2];
                            StringBuilder sb = new StringBuilder();
                            sb.append(SolidMonitor.CHECK_TYPE_LIB);
                            String str6 = File.separator;
                            sb.append(str6);
                            sb.append(str5);
                            sb.append(str6);
                            sb.append("libsg");
                            sb.append(str);
                            sb.append(".so");
                            if (sb.toString().equals(str4)) {
                                w = str5;
                                file = a(str, file2, str3, str4);
                                break;
                            }
                            i2++;
                        }
                    }
                    if (file == null) {
                        file = c(str);
                    }
                    if (file == null && z) {
                        file = a(str, file2);
                    }
                    if (file != null) {
                        if (file.getAbsolutePath().endsWith(".zip")) {
                            lVar = new l(file, file2, null, z2);
                        } else if (com.alibaba.wireless.security.framework.utils.e.a()) {
                            lVar = new l(file, file2, file, z2);
                        } else {
                            File file4 = new File(file2, "libsg" + str + JSMethod.NOT_SET + file.lastModified() + ".zip");
                            if (!file4.exists() || !e(file4) || c(file4, file)) {
                                file4.delete();
                                if (b(file, file4)) {
                                    lVar = new l(file4, file2, file, z2);
                                } else {
                                    File file5 = new File(file2, "libsg" + str + "_cp" + file.lastModified() + ".zip");
                                    lVar = ((!file5.exists() || file5.length() != file.length()) && !a(file, file5)) ? null : new l(file5, file2, file, z2);
                                }
                            } else {
                                lVar = new l(file4, file2, file, z2);
                            }
                        }
                        if (!z2) {
                            this.g.b();
                        }
                        return lVar;
                    } else if (z2) {
                        return null;
                    } else {
                        this.g.b();
                        return null;
                    }
                }
                z2 = false;
                if (file2 == null) {
                }
                if (!z2) {
                }
                if (file == null) {
                }
                String[] split2 = absolutePath.split("!/", 2);
                String str32 = split2[0];
                String str42 = split2[1];
                String[] strArr2 = v;
                length = strArr2.length;
                while (true) {
                    if (i2 >= length) {
                    }
                    i2++;
                }
                if (file == null) {
                }
                file = a(str, file2);
                if (file != null) {
                }
            }
        }
        file2 = null;
        file = null;
        z2 = false;
        if (file2 == null) {
        }
        if (!z2) {
        }
        if (file == null) {
        }
        String[] split22 = absolutePath.split("!/", 2);
        String str322 = split22[0];
        String str422 = split22[1];
        String[] strArr22 = v;
        length = strArr22.length;
        while (true) {
            if (i2 >= length) {
            }
            i2++;
        }
        if (file == null) {
        }
        file = a(str, file2);
        if (file != null) {
        }
    }

    private File b(File file) {
        if (!file.exists() || !file.isDirectory() || !this.l) {
            return file;
        }
        File file2 = new File(file, js2.MAIN);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2.exists() ? file2 : file;
    }

    private File b(String str) {
        if (this.i != null) {
            return null;
        }
        String a2 = com.alibaba.wireless.security.framework.utils.e.a(d.class.getClassLoader(), "sg" + str);
        if (a2 == null || a2.length() <= 0) {
            return null;
        }
        return new File(a2);
    }

    private boolean b(File file, File file2) {
        Method method;
        try {
            Object obj = null;
            if (Build.VERSION.SDK_INT >= 21) {
                method = Class.forName("android.system.Os").getDeclaredMethod("symlink", String.class, String.class);
            } else {
                Field declaredField = Class.forName("libcore.io.Libcore").getDeclaredField("os");
                declaredField.setAccessible(true);
                obj = declaredField.get(null);
                method = obj.getClass().getMethod("symlink", String.class, String.class);
            }
            method.invoke(obj, file.getAbsolutePath(), file2.getAbsolutePath());
            return true;
        } catch (Throwable th) {
            FLOG.w("create symbolic link( " + file2.getAbsolutePath() + " -> " + file.getAbsolutePath() + " ) failed", th);
            String th2 = th.toString();
            String absolutePath = file.getAbsolutePath();
            String absolutePath2 = file2.getAbsolutePath();
            a(100047, 1, th2, absolutePath, absolutePath2, "" + Build.VERSION.SDK_INT, "");
            return false;
        }
    }

    private synchronized ISGPluginInfo c(String str, String str2, boolean z) throws SecException {
        File file;
        StringBuilder sb;
        if (SecurityGuardManager.getSilentMode()) {
            a(true);
        }
        if (this.o && this.m && this.d.get(getMainPluginName()) != null) {
            return this.d.get(str);
        }
        String str3 = FLOG.get_currentFuncName();
        long j2 = FLOG.get_currentTime();
        c cVar = this.d.get(str);
        if (cVar != null) {
            return cVar;
        }
        SGApmMonitorManager.getInstance().monitorStart(str);
        ApmMonitorAdapter.jstageStart(str, "2");
        File file2 = this.r;
        if (file2 == null || !file2.exists()) {
            g();
        }
        ApmMonitorAdapter.jstageEnd(str, "2");
        ApmMonitorAdapter.jstageStart(str, "0");
        l b2 = b(str, str2, z);
        ApmMonitorAdapter.jstageEnd(str, "0");
        if (b2 != null && (file = b2.a) != null && file.exists()) {
            FLOG.printTimeCost(str, str3, "getPluginFile", j2);
            long j3 = FLOG.get_currentTime();
            ApmMonitorAdapter.jstageStart(str, "1");
            c a2 = a(str, b2, this.c, str2);
            ApmMonitorAdapter.jstageEnd(str, "1");
            if (this.o && this.m && !getMainPluginName().equals(str)) {
                return this.d.get(str);
            }
            if (a2 == null) {
                if (b2.c != null) {
                    sb = new StringBuilder();
                    sb.append("src:");
                    sb.append(d(b2.c.getAbsolutePath()));
                } else {
                    sb = new StringBuilder();
                    sb.append("zipfile:");
                    sb.append(d(b2.a.getAbsolutePath()));
                }
                a(100044, 110, "", str, str2, sb.toString(), "");
                throw new SecException(str, 111);
            }
            FLOG.printTimeCost(str, str3, "loadApk", j3);
            this.d.put(str, a2);
            String str4 = str + jl1.BRACKET_START_STR + a2.getVersion() + jl1.BRACKET_END_STR;
            String a3 = a2.a("weakdependencies");
            String a4 = a2.a("weakdependenciesNotDelay");
            if (str2.length() != 0) {
                str4 = str2 + "->" + str4;
            }
            Looper myLooper = Looper.myLooper();
            if (myLooper == null || myLooper == Looper.getMainLooper()) {
                FLOG.w("looper of current thread is null, try to create a new thread with a looper");
                if (this.a == null) {
                    HandlerThread handlerThread = new HandlerThread("SGBackgroud");
                    this.a = handlerThread;
                    handlerThread.start();
                }
                myLooper = this.a.getLooper();
            }
            if (myLooper == null) {
                FLOG.w("looper is still null");
                return a2;
            }
            Handler handler = new Handler(myLooper);
            if (!(a4 == null || a4.trim().length() == 0)) {
                handler.post(new RunnableC0117d(a4, str4));
            }
            if (!(a3 == null || a3.trim().length() == 0)) {
                handler.postDelayed(new e(a3, str4), DateUtils.MILLIS_PER_MINUTE);
            }
            handler.postDelayed(new f(), 10000);
            SGApmMonitorManager.getInstance().monitorEnd(str);
            if (SGApmMonitorManager.getInstance().isAllPluginLoaded()) {
                SGApmMonitorManager.getInstance().monitorEnd("plugin");
            }
            return a2;
        } else if (!z) {
            return null;
        } else {
            String str5 = "plugin " + str + " not existed";
            if (str2.length() != 0) {
                str5 = str5 + ", depended by " + str2;
            }
            a(100044, 110, "", str, str2, "", "");
            throw new SecException(str5, 110);
        }
    }

    private File c(String str) {
        String str2 = this.i;
        if (str2 == null) {
            try {
                str2 = this.c.getApplicationInfo().nativeLibraryDir;
            } catch (Throwable unused) {
            }
        }
        if (str2 != null && str2.length() > 0) {
            File file = new File(str2 + File.separator + "libsg" + str + ".so");
            if (file.exists()) {
                return file;
            }
        }
        return null;
    }

    private String c(Class<?> cls) {
        InterfacePluginInfo interfacePluginInfo = (InterfacePluginInfo) cls.getAnnotation(InterfacePluginInfo.class);
        if (interfacePluginInfo == null) {
            return null;
        }
        return interfacePluginInfo.pluginName();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void c() {
        try {
            int i2 = OrangeListener.a;
            Method method = OrangeListener.class.getMethod("getOrangeConfig", String.class, String.class, String.class);
            if (method != null) {
                String str = (String) method.invoke(OrangeListener.class, OrangeAdapter.SECURITYGUARD_ORANGE_NAMESPACE, "130", "0");
                try {
                    File file = new File(a(this.c), ".giw");
                    boolean exists = file.exists();
                    if (str == null) {
                        if (exists) {
                            file.delete();
                        }
                    } else if (!TextUtils.equals(com.alibaba.wireless.security.framework.utils.a.a(file), str)) {
                        com.alibaba.wireless.security.framework.utils.a.a(file, str);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        } catch (Throwable th) {
            FLOG.e("checkGetInterfaceLockSwitch : " + th.getMessage());
        }
    }

    private boolean c(File file) {
        String str;
        IOException e2;
        if (file == null || file.getParentFile() == null || this.t == null) {
            return false;
        }
        String str2 = null;
        try {
            str = file.getParentFile().getCanonicalPath();
            try {
                str2 = this.t.getCanonicalPath();
            } catch (IOException e3) {
                e2 = e3;
            }
        } catch (IOException e4) {
            e2 = e4;
            str = null;
            FLOG.w("", e2);
            return str == null ? false : false;
        }
        if (str == null && TextUtils.equals(str, str2)) {
            return true;
        }
    }

    private boolean c(File file, File file2) {
        try {
            return file.getCanonicalPath().equals(file2.getCanonicalPath());
        } catch (Throwable th) {
            FLOG.w("", th);
            a(100046, 0, th.toString(), file.getAbsolutePath(), file2.getAbsolutePath(), "", "");
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01b5, code lost:
        com.alibaba.wireless.security.framework.SGApmMonitorManager.getInstance().monitorEnd(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01c4, code lost:
        if (com.alibaba.wireless.security.framework.SGApmMonitorManager.getInstance().isAllPluginLoaded() == false) goto L_0x01cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01c6, code lost:
        com.alibaba.wireless.security.framework.SGApmMonitorManager.getInstance().monitorEnd("plugin");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01cf, code lost:
        return r15;
     */
    private ISGPluginInfo d(String str, String str2, boolean z) throws SecException {
        File file;
        StringBuilder sb;
        String d2;
        if (this.o && this.m && this.d.get(getMainPluginName()) != null) {
            return this.d.get(str);
        }
        String str3 = FLOG.get_currentFuncName();
        long j2 = FLOG.get_currentTime();
        c cVar = this.d.get(str);
        if (cVar != null) {
            return cVar;
        }
        SGApmMonitorManager.getInstance().monitorStart(str);
        ApmMonitorAdapter.jstageStart(str, "2");
        synchronized (d.class) {
            c cVar2 = this.d.get(str);
            if (cVar2 != null) {
                return cVar2;
            }
            File file2 = this.r;
            if (file2 == null || !file2.exists()) {
                g();
            }
            ApmMonitorAdapter.jstageEnd(str, "2");
            ApmMonitorAdapter.jstageStart(str, "0");
            l b2 = b(str, str2, z);
            ApmMonitorAdapter.jstageEnd(str, "0");
            if (!(b2 == null || (file = b2.a) == null)) {
                if (file.exists()) {
                    FLOG.printTimeCost(str, str3, "getPluginFile", j2);
                    long j3 = FLOG.get_currentTime();
                    ApmMonitorAdapter.jstageStart(str, "1");
                    c a2 = a(str, b2, this.c, str2);
                    ApmMonitorAdapter.jstageEnd(str, "1");
                    if (this.o && this.m && !getMainPluginName().equals(str)) {
                        return this.d.get(str);
                    }
                    if (a2 == null) {
                        if (b2.c != null) {
                            sb = new StringBuilder();
                            sb.append("src:");
                            d2 = d(b2.c.getAbsolutePath());
                        } else {
                            sb = new StringBuilder();
                            sb.append("zipfile:");
                            d2 = d(b2.a.getAbsolutePath());
                        }
                        sb.append(d2);
                        a(100044, 110, "", str, str2, sb.toString(), "");
                        throw new SecException(str, 111);
                    }
                    FLOG.printTimeCost(str, str3, "loadApk", j3);
                    this.d.put(str, a2);
                    String str4 = str + jl1.BRACKET_START_STR + a2.getVersion() + jl1.BRACKET_END_STR;
                    String a3 = a2.a("weakdependencies");
                    String a4 = a2.a("weakdependenciesNotDelay");
                    if (str2.length() != 0) {
                        str4 = str2 + "->" + str4;
                    }
                    Looper myLooper = Looper.myLooper();
                    if (myLooper == null || myLooper == Looper.getMainLooper()) {
                        FLOG.w("looper of current thread is null, try to create a new thread with a looper");
                        if (this.a == null) {
                            HandlerThread handlerThread = new HandlerThread("SGBackgroud");
                            this.a = handlerThread;
                            handlerThread.start();
                        }
                        myLooper = this.a.getLooper();
                    }
                    if (myLooper == null) {
                        FLOG.w("looper is still null");
                        return a2;
                    }
                    Handler handler = new Handler(myLooper);
                    if (!(a4 == null || a4.trim().length() == 0)) {
                        handler.post(new g(a4, str4));
                    }
                    if (!(a3 == null || a3.trim().length() == 0)) {
                        handler.postDelayed(new h(a3, str4), DateUtils.MILLIS_PER_MINUTE);
                    }
                    handler.postDelayed(new i(), 10000);
                }
            }
            if (!z) {
                return null;
            }
            String str5 = "plugin " + str + " not existed";
            if (str2.length() != 0) {
                str5 = str5 + ", depended by " + str2;
            }
            a(100044, 110, "", str, str2, "", "");
            throw new SecException(str5, 110);
        }
    }

    private String d(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        File file = new File(str);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (e(file)) {
            sb.append("->");
            try {
                sb.append(file.getCanonicalPath());
            } catch (Throwable unused) {
            }
        }
        sb.append(jl1.ARRAY_START);
        sb.append("exists:" + file.exists() + ",");
        sb.append("size:" + file.length() + ",");
        sb.append("canRead:" + file.canRead() + ",");
        sb.append("canWrite:" + file.canWrite() + ",");
        sb.append("totalSpace:" + file.getTotalSpace() + ",");
        sb.append("freeSpace:" + file.getFreeSpace() + ",");
        sb.append(jl1.ARRAY_END);
        return sb.toString();
    }

    /* JADX INFO: finally extract failed */
    private boolean d() {
        b a2;
        File file = new File(b(), "upds");
        File file2 = new File(file, "update.config");
        File file3 = new File(a(), "update.config");
        if (!file2.isFile() || (a2 = b.a(file2)) == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(file);
        String str = File.separator;
        sb.append(str);
        sb.append("libs");
        sb.append(str);
        sb.append(a2.b());
        File file4 = new File(sb.toString(), "FBD");
        HashMap<String, String> d2 = a2.d();
        HashMap<String, String> f2 = f();
        if (!file4.exists() && d2 != null && d2.equals(f2)) {
            try {
                this.g.a();
                file3.delete();
                String a3 = com.alibaba.wireless.security.framework.utils.a.a(file2);
                if (a3 == null || !com.alibaba.wireless.security.framework.utils.a.a(file3, a3)) {
                    this.b.add(new k(a3, file3, file2));
                    this.g.b();
                } else {
                    this.g.b();
                    return true;
                }
            } catch (Throwable th) {
                this.g.b();
                throw th;
            }
        }
        return false;
    }

    private boolean d(File file) {
        if (file != null) {
            try {
                String absolutePath = file.getAbsolutePath();
                if (absolutePath != null) {
                    if (absolutePath.length() > 0) {
                        if (com.alibaba.wireless.security.framework.utils.e.c(this.c) || !absolutePath.startsWith("/system/")) {
                            return true;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private b e() {
        b bVar;
        String a2;
        b bVar2;
        File file = new File(this.r, "update.config");
        File file2 = new File(this.r, "init.config");
        if (this.l) {
            if (!file2.isFile() && h()) {
                d();
            }
            bVar2 = b.a(file);
            if (bVar2 != null) {
                try {
                    this.g.a();
                    file2.delete();
                    file.renameTo(file2);
                } catch (Throwable th) {
                    this.g.b();
                    throw th;
                }
            } else {
                bVar = b.a(file2);
                if (bVar != null || (a2 = com.alibaba.wireless.security.framework.utils.a.a(new File(this.r, "dyInit.config"))) == null || !a2.equals(Integer.toString(bVar.b()))) {
                    return bVar;
                }
                this.b.add(new j(bVar.c(), bVar.b()));
                return null;
            }
        } else {
            try {
                this.g.a();
                bVar2 = b.a(file2);
            } catch (Throwable th2) {
                this.g.b();
                throw th2;
            }
        }
        this.g.b();
        bVar = bVar2;
        return bVar != null ? bVar : bVar;
    }

    private boolean e(File file) {
        try {
            File canonicalFile = file.getCanonicalFile();
            if (canonicalFile != null) {
                File parentFile = file.getParentFile();
                File parentFile2 = canonicalFile.getParentFile();
                if (parentFile == null || parentFile2 == null || parentFile.getCanonicalPath().equals(parentFile2.getCanonicalPath())) {
                    if (!file.getName().equals(canonicalFile.getName())) {
                        return true;
                    }
                }
                return true;
            }
        } catch (Throwable th) {
            FLOG.w("", th);
            a(100047, 0, th.toString(), file.getAbsolutePath(), "", "", "");
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean e(String str, String str2, boolean z) throws SecException {
        SecException th;
        if (!(str == null || str.trim().length() == 0)) {
            String[] split = str.split(";");
            char c2 = 0;
            for (int i2 = 0; i2 < split.length; i2++) {
                String trim = split[i2].trim();
                if (trim.length() != 0) {
                    String[] split2 = trim.split(":");
                    if (split2.length == 2) {
                        int indexOf = str2.indexOf(split2[c2]);
                        if (indexOf >= 0) {
                            int indexOf2 = str2.indexOf(jl1.BRACKET_START_STR, indexOf);
                            int indexOf3 = str2.indexOf(jl1.BRACKET_END_STR, indexOf);
                            if (indexOf2 < 0 || indexOf3 < 0 || indexOf2 > indexOf3) {
                                a(100040, SecExceptionCode.SEC_ERROR_INIT_INDEX_ERROR, "indexLeftP < 0 || indexRightP < 0 || indexLeftP > indexRightP", "" + indexOf2, "" + indexOf3, "", "" + i2);
                                throw new SecException(SecExceptionCode.SEC_ERROR_INIT_INDEX_ERROR);
                            }
                            String substring = str2.substring(indexOf2 + 1, indexOf3);
                            if (b(substring, split2[1]) < 0) {
                                String str3 = "version " + substring + " of " + split2[0] + " is not meet the requirement: " + split2[1];
                                if (str2.length() != 0) {
                                    str3 = str3 + ", depended by: " + str2;
                                }
                                if (!z) {
                                    a(100040, 113, "versionCompare(parentPluginVersion, nameVersionPair[1]) < 0", substring, split2[0], split2[1], "" + i2);
                                }
                                throw new SecException(str3, 113);
                            }
                        } else {
                            c cVar = this.d.get(split2[0]);
                            if (cVar == null) {
                                try {
                                    cVar = this.q ? d(split2[0], str2, !z) : c(split2[0], str2, !z);
                                    th = null;
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                                if (cVar == null) {
                                    if (!z) {
                                        if (th instanceof SecException) {
                                            throw th;
                                        }
                                        a(100040, 130, "throwable in loadPluginInner", "" + th, str, str2, "" + i2);
                                        throw new SecException(str2, 130);
                                    }
                                }
                            }
                            if (b(cVar.getVersion(), split2[1]) < 0) {
                                String str4 = "version " + cVar.getVersion() + " of " + split2[0] + " is not meet the requirement: " + split2[1];
                                if (str2.length() != 0) {
                                    str4 = str4 + ", depended by: " + str2;
                                }
                                if (!z) {
                                    a(100040, 113, "versionCompare(dependPlugin.getVersion(), nameVersionPair[1]) < 0", cVar.getVersion(), split2[0], split2[1], "" + i2);
                                }
                                throw new SecException(str4, 113);
                            }
                        }
                        c2 = 0;
                    } else {
                        a(100040, 128, "nameVersionPair.length != 2", trim, str2, "" + z, "" + i2);
                        throw new SecException(128);
                    }
                }
            }
        }
        return true;
    }

    private HashMap<String, String> f() {
        String str;
        if (this.c.getApplicationInfo() == null || (str = this.c.getApplicationInfo().nativeLibraryDir) == null) {
            return null;
        }
        String[] strArr = {"libsgmain", "libsgsecuritybody", "libsgmiddletier"};
        HashMap<String, String> hashMap = new HashMap<>();
        for (int i2 = 0; i2 < 3; i2++) {
            String str2 = strArr[i2];
            File file = new File(str, str2 + "so.version.so");
            if (file.isFile()) {
                hashMap.put(str2, com.alibaba.wireless.security.framework.utils.a.a(file));
            }
        }
        return hashMap;
    }

    private void g() throws SecException {
        File a2 = a(this.c);
        this.r = a2;
        if (a2 != null) {
            Context context = this.c;
            this.g = new com.alibaba.wireless.security.framework.utils.b(context, this.r + File.separator + "lock.lock");
            b e2 = e();
            this.k = e2;
            this.t = a(this.c, e2);
        }
    }

    private boolean h() {
        if (u == null) {
            u = Boolean.valueOf(new File(b(), ".sgdynkp").isFile());
        }
        return u.booleanValue();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void i() {
        List<Runnable> list = this.b;
        if (list != null) {
            try {
                for (Runnable runnable : list) {
                    runnable.run();
                }
            } catch (Exception unused) {
            }
            this.b.clear();
        }
    }

    private String j() {
        StringBuilder sb = new StringBuilder();
        File file = this.r;
        if (file == null || !file.exists() || !file.isDirectory()) {
            sb.append("not exists!");
        } else {
            try {
                sb.append(jl1.ARRAY_START_STR);
                File[] listFiles = file.listFiles();
                int i2 = 0;
                while (listFiles != null && i2 < listFiles.length) {
                    File file2 = listFiles[i2];
                    if (file2.getName().startsWith("libsg") && (file2.getName().endsWith("zip") || file2.getName().endsWith(".so"))) {
                        sb.append(file2.getName());
                        sb.append(jl1.BRACKET_START_STR);
                        sb.append(e(file2) + " , ");
                        sb.append(file2.length());
                        sb.append(") , ");
                    }
                    i2++;
                }
                sb.append(jl1.ARRAY_END_STR);
            } catch (Throwable unused) {
            }
        }
        return sb.toString();
    }

    public File a() {
        return this.r;
    }

    public <T> T a(Class<T> cls) throws SecException {
        String str;
        Object obj = this.e.get(cls);
        if (obj != null) {
            return cls.cast(obj);
        }
        b bVar = this.k;
        if (bVar != null) {
            str = bVar.e();
            if (str == null || str.length() == 0) {
                str = this.k.a(cls.getName());
            }
        } else {
            str = null;
        }
        if (str == null || str.length() == 0) {
            str = c((Class<?>) cls);
        }
        if (str == null || str.length() == 0) {
            throw new SecException(150);
        }
        ISGPluginInfo pluginInfo = getPluginInfo(str);
        if (pluginInfo != null) {
            Object obj2 = pluginInfo.getSGPluginEntry().getInterface(cls);
            if (obj2 != null) {
                this.e.put(cls, obj2);
                return cls.cast(obj2);
            }
            a(100045, 112, "", cls.getName(), str + jl1.BRACKET_START_STR + pluginInfo.getVersion() + jl1.BRACKET_END_STR, d(pluginInfo.getPluginPath()), "");
            throw new SecException(112);
        } else if (!this.m || !getMainPluginName().equals(str)) {
            return null;
        } else {
            throw new SecException(110);
        }
    }

    public void a(Context context, String str, String str2, boolean z, Object... objArr) {
        String str3 = "0";
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this.c = context;
        this.j = str;
        this.l = com.alibaba.wireless.security.framework.utils.e.b(context);
        this.h = z;
        this.b = new ArrayList();
        UserTrackMethodJniBridge.init(this.c);
        if (str2 != null && !str2.isEmpty()) {
            this.i = str2;
        }
        boolean z2 = false;
        try {
            g();
            this.q = new Random().nextDouble() < Double.parseDouble(com.alibaba.wireless.security.framework.utils.a.a(new File(a(this.c), ".giw")));
        } catch (SecException | Exception unused) {
        }
        try {
            int i2 = OrangeListener.a;
            Method method = OrangeListener.class.getMethod("getOrangeConfig", String.class, String.class, String.class);
            if (method != null) {
                str3 = (String) method.invoke(OrangeListener.class, OrangeAdapter.SECURITYGUARD_ORANGE_NAMESPACE, "113", str3);
            }
        } catch (Throwable th) {
            FLOG.e("getKeepAliveOrangeSwitch : " + th.getMessage());
        }
        this.o |= "1".equals(str3);
        try {
            Class<?> cls = Class.forName("com.taobao.adaemon.ADaemon");
            Method method2 = cls.getMethod("isChannelMemOptimizeEnable", Context.class);
            if (method2 != null) {
                z2 = ((Boolean) method2.invoke(cls, this.c)).booleanValue();
            }
        } catch (Throwable th2) {
            FLOG.e("ADaemon.isChannelMemOptimizeEnable: " + th2.getMessage());
        }
        boolean z3 = this.o | z2;
        this.o = z3;
        this.p = z3;
    }

    public void a(String str) {
        if (h()) {
            File b2 = b();
            File file = new File(b2, "upds/libs/" + str);
            if (file.isDirectory()) {
                File file2 = new File(file, "FBD");
                if (!com.alibaba.wireless.security.framework.utils.a.a(file2, "1")) {
                    this.b.add(new a(file2));
                    return;
                }
                return;
            }
            this.b.add(new b(file));
        }
    }

    public void a(boolean z) {
        boolean z2;
        if (z) {
            z2 = true;
            this.o = true;
        } else {
            this.o = this.p;
            z2 = this.n;
        }
        this.m = z2;
    }

    public File b() {
        return this.s;
    }

    public synchronized <T> T b(Class<T> cls) throws SecException {
        return (T) a(cls);
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginManager
    public <T> T getInterface(Class<T> cls) throws SecException {
        return this.q ? (T) a(cls) : (T) b(cls);
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginManager
    public String getMainPluginName() {
        return js2.MAIN;
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginManager
    public ISGPluginInfo getPluginInfo(String str) throws SecException {
        FLOG.i("MockTaobaoChannel - getPluginInfo: " + str);
        return this.q ? d(str, "", true) : c(str, "", true);
    }

    @Override // com.alibaba.wireless.security.framework.ISGPluginManager
    public IRouterComponent getRouter() {
        return this.f;
    }
}
