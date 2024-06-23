package com.uc.crashsdk;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StatFs;
import android.os.StrictMode;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.ali.user.open.core.exception.RpcException;
import com.alibaba.motu.crashreporter2.CrashReporter;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.huawei.hms.utils.FileUtil;
import com.taobao.weex.annotation.JSMethod;
import com.uc.crashsdk.a.f;
import com.uc.crashsdk.a.g;
import com.uc.crashsdk.a.h;
import com.uc.crashsdk.export.LogType;
import com.youku.alixplayer.MsgID;
import com.youku.arch.solid.monitor.SolidMonitor;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.lang.Thread;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mtopsdk.common.util.SymbolExpUtil;
import mtopsdk.mtop.intf.MtopParamType;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import tb.gl1;
import tb.js2;

/* compiled from: Taobao */
public class e implements Thread.UncaughtExceptionHandler {
    private static String A = null;
    private static int B = -1;
    private static int C = -1;
    private static int D = -1;
    private static int E = -1;
    private static int F = -1;
    private static int G = -1;
    private static int H = -1;
    private static String I = "?";
    private static boolean J = false;
    private static boolean K = false;
    private static int L = 0;
    private static int M = 0;
    private static boolean N = false;
    private static com.uc.crashsdk.a.e O = new com.uc.crashsdk.a.e(405);
    private static c P = new c((byte) 0);
    private static boolean Q = false;
    private static final com.uc.crashsdk.a.e R = new com.uc.crashsdk.a.e(412);
    private static Thread.UncaughtExceptionHandler S = null;
    private static Throwable T = null;
    private static boolean U = false;
    private static boolean V = false;
    private static Runnable W = null;
    private static final Object X = new Object();
    private static int Y = 101;
    private static Runnable Z = new com.uc.crashsdk.a.e(407);
    static final /* synthetic */ boolean a = true;
    private static final Object aa = new Object();
    private static volatile boolean ab = false;
    private static ParcelFileDescriptor ac = null;
    private static boolean ad = false;
    private static boolean ae = false;
    private static long b;
    private static final AtomicBoolean c = new AtomicBoolean(false);
    private static boolean d = false;
    private static long f = 0;
    private static long g = -1;
    private static boolean h = true;
    private static String i;
    private static String j = "";
    private static String k = null;
    private static String l = null;
    private static String m = null;
    private static final Object n = new Object();
    private static final Object o = new Object();
    private static final Object p = new Object();
    private static final Object q = new Object();
    private static final ArrayList<String> r = new ArrayList<>();
    private static int s = 0;
    private static String t = null;
    private static boolean u = false;
    private static String v = null;
    private static String w = null;
    private static final Object x = new Object();
    private static final Object y = new Object();
    private static Map<String, Integer> z = null;
    private final List<FileInputStream> e = new ArrayList();

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b implements Comparator<File> {
        private b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(File file, File file2) {
            File file3 = file;
            File file4 = file2;
            if (file3.lastModified() > file4.lastModified()) {
                return 1;
            }
            return file3.lastModified() < file4.lastModified() ? -1 : 0;
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class c extends BroadcastReceiver {
        private c() {
        }

        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.BATTERY_CHANGED".equals(action)) {
                int unused = e.B = intent.getIntExtra("level", -1);
                int unused2 = e.C = intent.getIntExtra("scale", -1);
                int unused3 = e.D = intent.getIntExtra("voltage", -1);
                int unused4 = e.E = intent.getIntExtra("health", -1);
                int unused5 = e.F = intent.getIntExtra("plugged", -1);
                int unused6 = e.G = intent.getIntExtra("status", -1);
                int unused7 = e.H = intent.getIntExtra("temperature", -1);
                String unused8 = e.I = intent.getStringExtra("technology");
                if (e.J() >= 2) {
                    e.K();
                    int unused9 = e.L = 0;
                }
            } else if ("android.intent.action.BATTERY_LOW".equals(action) || "android.intent.action.BATTERY_OKAY".equals(action)) {
                boolean unused10 = e.J = "android.intent.action.BATTERY_LOW".equals(action);
                e.K();
            } else if ("android.intent.action.ANR".equals(action)) {
                try {
                    e.d(context);
                } catch (Throwable th) {
                    g.a(th);
                }
            }
        }

        /* synthetic */ c(byte b) {
            this();
        }
    }

    public e() {
        try {
            M();
        } catch (Throwable th) {
            g.a(th);
        }
    }

    public static void A() {
        if (g.q()) {
            f.a(0, new com.uc.crashsdk.a.e(403), 10000);
        }
    }

    public static void B() {
        if (!ab && !b.L()) {
            f.a(1, new com.uc.crashsdk.a.e(RpcException.ErrorCode.API_UNAUTHORIZED), 1000);
        }
    }

    static void C() {
        f.a(1, new com.uc.crashsdk.a.e(409), 7000);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003f, code lost:
        if ((java.lang.System.currentTimeMillis() % 3) == 0) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
        if (r0 == 1) goto L_0x0011;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    public static void D() {
        int L2 = g.L();
        boolean z2 = true;
        boolean z3 = false;
        if (L2 == 0 || L2 == 3 || L2 == 4) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 21 && i2 <= 25) {
                boolean z4 = L2 != 0;
                if (L2 == 3) {
                    z4 = System.currentTimeMillis() % 10 == 0;
                }
                if (L2 != 4) {
                    z2 = z4;
                }
            }
            if (!z2) {
                com.uc.crashsdk.a.a.a("crashsdk", "SIG 3 is disabled by settings");
            }
            boolean L3 = b.L();
            if (Looper.getMainLooper() != Looper.myLooper() || !z2) {
                z3 = z2;
            } else {
                f.a(2, new com.uc.crashsdk.a.e(413));
            }
            JNIBridge.nativeCmd(7, L3 ? 1 : 0, null, null);
            if (!z3) {
                JNIBridge.cmd(8);
                return;
            }
            return;
        }
        z2 = false;
        if (!z2) {
        }
        boolean L32 = b.L();
        if (Looper.getMainLooper() != Looper.myLooper()) {
        }
        z3 = z2;
        JNIBridge.nativeCmd(7, L32 ? 1 : 0, null, null);
        if (!z3) {
        }
    }

    public static ParcelFileDescriptor E() {
        if (!b.d) {
            com.uc.crashsdk.a.a.d("crashsdk", "Crash so is not loaded!");
            return null;
        }
        ParcelFileDescriptor parcelFileDescriptor = ac;
        if (parcelFileDescriptor != null) {
            return parcelFileDescriptor;
        }
        int cmd = (int) JNIBridge.cmd(14);
        if (cmd == -1) {
            return null;
        }
        ParcelFileDescriptor adoptFd = ParcelFileDescriptor.adoptFd(cmd);
        ac = adoptFd;
        ad = true;
        return adoptFd;
    }

    public static boolean F() {
        return ae;
    }

    public static void G() {
        String V2 = g.V();
        File file = new File(V2);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                com.uc.crashsdk.a.a.b("Ucebu can not list folder: " + V2);
                return;
            }
            for (File file2 : listFiles) {
                if (file2.isFile() && file2.getName().contains("ucebu")) {
                    a(false, false);
                    return;
                }
            }
        }
    }

    static /* synthetic */ int J() {
        int i2 = L + 1;
        L = i2;
        return i2;
    }

    static /* synthetic */ void K() {
        StringBuilder X2;
        if (b.d && (X2 = X()) != null) {
            JNIBridge.set(125, X2.toString());
        }
        K = true;
        Y();
    }

    private void M() {
        int G2 = g.G();
        for (int i2 = 0; i2 < G2; i2++) {
            try {
                this.e.add(new FileInputStream("/dev/null"));
            } catch (Exception e2) {
                g.a(e2);
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public static boolean N() {
        if (g.N()) {
            return true;
        }
        return a();
    }

    private static String O() {
        return g.e() + JSMethod.NOT_SET;
    }

    private static String P() {
        return b.B() ? "fg" : "bg";
    }

    private static byte[] Q() {
        byte[] bArr = null;
        int i2 = 1024;
        while (bArr == null && i2 > 0) {
            try {
                bArr = new byte[i2];
            } catch (Throwable unused) {
                i2 /= 2;
                if (i2 < 16) {
                    break;
                }
            }
        }
        return bArr;
    }

    private static String R() {
        return (!b.F() || d) ? "java" : "ucebujava";
    }

    private static void S() {
        String str;
        BufferedReader bufferedReader;
        FileReader fileReader;
        Throwable th;
        String str2 = "-";
        try {
            str = Build.HARDWARE;
        } catch (Throwable th2) {
            g.a(th2);
            str = str2;
        }
        try {
            fileReader = new FileReader(new File("/proc/cpuinfo"));
            try {
                bufferedReader = new BufferedReader(fileReader, 512);
                int i2 = 0;
                do {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (readLine.startsWith("Hardware")) {
                            str = readLine.substring(readLine.indexOf(":") + 1).trim();
                        } else if (readLine.startsWith("Processor")) {
                            str2 = readLine.substring(readLine.indexOf(":") + 1).trim();
                        }
                        i2++;
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            g.a(th);
                            g.a(fileReader);
                            g.a(bufferedReader);
                            k = str;
                            l = str2;
                        } catch (Throwable th4) {
                            g.a(fileReader);
                            g.a(bufferedReader);
                            throw th4;
                        }
                    }
                } while (i2 < 2);
                g.a(fileReader);
            } catch (Throwable th5) {
                bufferedReader = null;
                th = th5;
                g.a(th);
                g.a(fileReader);
                g.a(bufferedReader);
                k = str;
                l = str2;
            }
        } catch (Throwable th6) {
            bufferedReader = null;
            th = th6;
            fileReader = null;
            g.a(th);
            g.a(fileReader);
            g.a(bufferedReader);
            k = str;
            l = str2;
        }
        g.a(bufferedReader);
        k = str;
        l = str2;
    }

    private static String T() {
        return g.U() + "bytes";
    }

    private static boolean U() {
        return Build.VERSION.SDK_INT < 29;
    }

    private static void V() {
        if (!N && !b.F() && !b.L()) {
            JNIBridge.cmd(18);
        }
    }

    private static void W() {
        f.a(3, new com.uc.crashsdk.a.e(414), 1000);
    }

    private static StringBuilder X() {
        String str;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("level: ");
            sb.append(B);
            sb.append(StringUtils.LF);
            sb.append("scale: ");
            sb.append(C);
            sb.append(StringUtils.LF);
            String str2 = " (Unknown)";
            switch (E) {
                case 1:
                    str = str2;
                    break;
                case 2:
                    str = " (Good)";
                    break;
                case 3:
                    str = " (Overheat)";
                    break;
                case 4:
                    str = " (Dead)";
                    break;
                case 5:
                    str = " (Over voltage)";
                    break;
                case 6:
                    str = " (Unspecified failure)";
                    break;
                case 7:
                    str = " (Cold)";
                    break;
                default:
                    str = " (?)";
                    break;
            }
            sb.append("health: ");
            sb.append(E);
            sb.append(str);
            sb.append(StringUtils.LF);
            int i2 = F;
            String str3 = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 4 ? " (?)" : " (Wireless)" : " (USB port)" : " (AC charger)" : " (None)";
            sb.append("pluged: ");
            sb.append(F);
            sb.append(str3);
            sb.append(StringUtils.LF);
            int i3 = G;
            if (i3 != 1) {
                str2 = i3 != 2 ? i3 != 3 ? i3 != 4 ? i3 != 5 ? " (?)" : " (Full)" : " (Not charging)" : " (Discharging)" : " (Charging)";
            }
            sb.append("status: ");
            sb.append(G);
            sb.append(str2);
            sb.append(StringUtils.LF);
            sb.append("voltage: ");
            sb.append(D);
            sb.append(StringUtils.LF);
            sb.append("temperature: ");
            sb.append(H);
            sb.append(StringUtils.LF);
            sb.append("technology: ");
            sb.append(I);
            sb.append(StringUtils.LF);
            sb.append("battery low: ");
            sb.append(J);
            sb.append(StringUtils.LF);
            return sb;
        } catch (Throwable th) {
            g.a(th);
            return null;
        }
    }

    private static void Y() {
        if (b.c && K && a.c) {
            K = false;
            if (!f.b(O)) {
                f.a(0, O, 2000);
            }
        }
    }

    private static boolean Z() {
        return b.d && JNIBridge.nativeIsCrashing();
    }

    public static boolean a() {
        if (f == 0) {
            f = 2;
            if (h(b.b("logs")) == 1) {
                f = 1;
            }
        }
        return f == 1;
    }

    private static void aa() {
        String W2 = g.W();
        File file = new File(W2);
        if (file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 150) {
                    Arrays.sort(listFiles, new b((byte) 0));
                    int length = listFiles.length - 150;
                    int i2 = length < 0 ? 0 : length;
                    long currentTimeMillis = System.currentTimeMillis();
                    int i3 = 0;
                    int i4 = 0;
                    int i5 = 0;
                    while (i3 < listFiles.length) {
                        File file2 = listFiles[i3];
                        boolean z2 = i3 < i2;
                        if (!z2 && currentTimeMillis - file2.lastModified() >= 432000000) {
                            z2 = true;
                        }
                        if (!z2) {
                            break;
                        }
                        try {
                            file2.delete();
                            i4++;
                            i5 = 0;
                        } catch (Throwable th) {
                            i5++;
                            g.a(th);
                        }
                        if (i5 >= 3) {
                            break;
                        }
                        i3++;
                    }
                    com.uc.crashsdk.a.a.a("Removed " + i4 + " logs in " + W2);
                }
            } catch (Throwable th2) {
                g.a(th2);
            }
        }
    }

    static long b() {
        if (g == -1) {
            g = h(b.b("local"));
        }
        return g;
    }

    private static String j(String str) {
        if (str == null) {
            str = String.valueOf(System.currentTimeMillis()) + new Random().nextInt(65536);
        }
        return String.format(Locale.US, "%s%s_%s_%s_%s_%s_", O(), g.R(), g.T(), i(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL()), i(Build.VERSION.getRELEASE()), str);
    }

    private static String k(String str) {
        return String.format(Locale.US, "%s%s_%s_%s.log", d(), n(), P(), str);
    }

    private static String l(String str) {
        if (!g.b(str)) {
            return "";
        }
        int indexOf = str.indexOf(0);
        if (indexOf >= 0) {
            str = str.substring(0, indexOf);
        }
        return str.trim();
    }

    private static String m(String str) {
        String a2 = com.uc.crashsdk.a.b.a(str, g.w(), g.v());
        if (!str.equals(a2)) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
        return a2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0051, code lost:
        if (r7.endsWith(r3) != false) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0068, code lost:
        if (r7.indexOf(".log", r7.lastIndexOf(95)) != r7.lastIndexOf(".log")) goto L_0x005a;
     */
    private static boolean[] n(String str) {
        boolean v2 = g.v();
        boolean x2 = g.x();
        if (v2 || x2) {
            if (!str.endsWith(".tmp") && !str.contains(".ec")) {
                int lastIndexOf = str.lastIndexOf(File.separatorChar);
                if (lastIndexOf < 0) {
                    lastIndexOf = 0;
                }
                int i2 = 0;
                do {
                    lastIndexOf = str.indexOf(95, lastIndexOf);
                    if (lastIndexOf >= 0) {
                        i2++;
                        lastIndexOf++;
                        continue;
                    }
                } while (lastIndexOf >= 0);
                if (i2 == 8) {
                    String w2 = g.w();
                    if (!str.endsWith(".log")) {
                        if (!g.a(w2)) {
                        }
                    } else if (!g.a(w2)) {
                    }
                    v2 = false;
                }
            }
            v2 = false;
            x2 = false;
        }
        return new boolean[]{v2, x2};
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ae  */
    private static boolean o(String str) {
        boolean z2;
        boolean z3;
        Throwable th;
        Exception e2;
        FileWriter fileWriter;
        int i2;
        synchronized (q) {
            File file = new File(g.U() + "customlog");
            String a2 = g.a(file, 1024, false);
            long currentTimeMillis = System.currentTimeMillis();
            StringBuffer stringBuffer = new StringBuffer();
            if (a2 != null) {
                stringBuffer.append(a2);
                Matcher matcher = Pattern.compile("([^\\n\\r\\t\\s]+) (\\d+) (\\d+)").matcher(stringBuffer);
                int i3 = 0;
                while (true) {
                    if (!matcher.find(i3)) {
                        break;
                    } else if (!str.equals(matcher.group(1))) {
                        i3 = matcher.end();
                    } else {
                        long parseLong = Long.parseLong(matcher.group(2));
                        if (currentTimeMillis - parseLong < 86400000) {
                            try {
                                i2 = Integer.parseInt(matcher.group(3));
                            } catch (Exception e3) {
                                g.a(e3);
                            }
                        } else {
                            parseLong = currentTimeMillis;
                            i2 = 0;
                        }
                        int D2 = g.D();
                        z2 = D2 >= 0 && i2 >= D2;
                        stringBuffer.replace(matcher.start(), matcher.end(), String.format(Locale.US, "%s %d %d", str, Long.valueOf(parseLong), Integer.valueOf(i2 + 1)));
                        z3 = true;
                    }
                }
                if (!z3) {
                    stringBuffer.append(String.format(Locale.US, "%s %d 1\n", str, Long.valueOf(currentTimeMillis)));
                }
                FileWriter fileWriter2 = null;
                fileWriter = new FileWriter(file);
                String stringBuffer2 = stringBuffer.toString();
                fileWriter.write(stringBuffer2, 0, stringBuffer2.length());
                g.a(fileWriter);
            }
            z3 = false;
            z2 = false;
            if (!z3) {
            }
            FileWriter fileWriter22 = null;
            try {
                fileWriter = new FileWriter(file);
                try {
                    String stringBuffer22 = stringBuffer.toString();
                    fileWriter.write(stringBuffer22, 0, stringBuffer22.length());
                    g.a(fileWriter);
                } catch (Exception e4) {
                    e2 = e4;
                    fileWriter22 = fileWriter;
                    try {
                        g.a(e2);
                        g.a(fileWriter22);
                        return z2;
                    } catch (Throwable th2) {
                        th = th2;
                        g.a(fileWriter22);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileWriter22 = fileWriter;
                    g.a(fileWriter22);
                    throw th;
                }
            } catch (Exception e5) {
                e2 = e5;
                g.a(e2);
                g.a(fileWriter22);
                return z2;
            }
        }
        return z2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b0  */
    private static boolean p(String str) {
        boolean z2;
        int i2;
        boolean z3;
        Integer num;
        synchronized (y) {
            z2 = false;
            if (z == null) {
                z = q(g.a(b.l(), "all:1", false));
            }
            if (z.containsKey("all")) {
                num = z.get("all");
            } else if (z.containsKey(str)) {
                num = z.get(str);
            } else {
                if (!"java".equals(str) && !LogType.NATIVE_TYPE.equals(str) && !"anr".equals(str)) {
                    if (!LogType.UNEXP_TYPE.equals(str)) {
                        z3 = false;
                        if (!z3 && z.containsKey("crash")) {
                            num = z.get("crash");
                        } else if (z3 && z.containsKey("nocrash")) {
                            num = z.get("nocrash");
                        } else if (!z.containsKey("other")) {
                            num = z.get("other");
                        } else {
                            i2 = 1;
                            if (i2 != 0) {
                                long j2 = (long) i2;
                                if (j2 < 0) {
                                    long j3 = 30;
                                    if (j2 == -2) {
                                        j3 = 7;
                                    } else if (j2 == -3) {
                                        j3 = 15;
                                    } else if (j2 == -4) {
                                        j3 = 60;
                                    }
                                    long b2 = a.b();
                                    long currentTimeMillis = b2 == 0 ? -1 : (System.currentTimeMillis() - b2) / 86400000;
                                    j2 = currentTimeMillis <= j3 ? 1 : currentTimeMillis - j3;
                                }
                                if (j2 != 1) {
                                    if (j2 > 0) {
                                        if (System.currentTimeMillis() % j2 == 0) {
                                        }
                                    }
                                }
                                z2 = true;
                            }
                        }
                    }
                }
                z3 = true;
                if (!z3) {
                }
                if (z3) {
                }
                if (!z.containsKey("other")) {
                }
            }
            i2 = num.intValue();
            if (i2 != 0) {
            }
        }
        return z2;
    }

    private static Map<String, Integer> q(String str) {
        HashMap hashMap = new HashMap();
        for (String str2 : str.split(SymbolExpUtil.SYMBOL_VERTICALBAR, 30)) {
            String[] split = str2.split(":", 3);
            if (split.length == 2) {
                String trim = split[0].trim();
                if (!g.a(trim)) {
                    int i2 = 1;
                    try {
                        i2 = Integer.parseInt(split[1].trim(), 10);
                    } catch (Throwable th) {
                        g.a(th);
                    }
                    hashMap.put(trim, Integer.valueOf(i2));
                }
            }
        }
        return hashMap;
    }

    private static void r(String str) {
        if (g.q()) {
            try {
                aa();
            } catch (Throwable th) {
                g.a(th);
            }
            if (str != null && !"".equals(str)) {
                try {
                    File file = new File(g.W());
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    com.uc.crashsdk.a.a.a("crashsdk", "copy log to: " + file);
                    g.a(new File(str), file);
                } catch (Throwable th2) {
                    g.a(th2);
                }
            }
        }
    }

    private static String s(String str) {
        return String.format("$^%s^$", str);
    }

    public static void t() {
        Thread.setDefaultUncaughtExceptionHandler(S);
    }

    static boolean u() {
        return c.get() || Z();
    }

    public static Throwable v() {
        return T;
    }

    public static int w() {
        if (b.I() == 5) {
            return Y;
        }
        return 100;
    }

    public static void x() {
        long o2 = (long) g.o();
        if (o2 >= 0) {
            boolean z2 = b.I() == 5;
            f.a(0, new com.uc.crashsdk.a.e(401));
            if (z2) {
                com.uc.crashsdk.a.e eVar = new com.uc.crashsdk.a.e(402);
                W = eVar;
                f.a(0, eVar, o2);
            }
        }
    }

    static void y() {
        if (b.c && a.c && !f.b(Z)) {
            f.a(0, Z, 1000);
        }
    }

    public static boolean z() {
        synchronized (X) {
            Runnable runnable = W;
            if (runnable == null || V) {
                return false;
            }
            f.a(runnable);
            W = null;
            return true;
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        a(thread, th, false);
    }

    static String d() {
        String str = i;
        if (str != null) {
            return str;
        }
        String j2 = j(null);
        i = j2;
        return j2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00af A[Catch:{ all -> 0x00d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d1  */
    public static String e() {
        String str;
        String str2;
        Throwable th;
        Method declaredMethod;
        String str3;
        String str4;
        boolean z2;
        if (!g.a(j)) {
            return j;
        }
        String str5 = null;
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                Field declaredField = android.os.Build.class.getDeclaredField("SUPPORTED_ABIS");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(null);
                if (obj != null && (obj instanceof String[])) {
                    String[] strArr = (String[]) obj;
                    StringBuilder sb = new StringBuilder();
                    int length = strArr.length;
                    int i2 = 0;
                    boolean z3 = true;
                    while (i2 < length) {
                        String str6 = strArr[i2];
                        if (!z3) {
                            sb.append(",");
                        }
                        sb.append(str6);
                        i2++;
                        z3 = false;
                    }
                    j = sb.toString();
                }
            }
        } catch (Throwable unused) {
        }
        if (g.a(j)) {
            try {
                str4 = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getCPU_ABI();
                try {
                    str3 = android.os.Build.CPU_ABI2;
                } catch (Throwable unused2) {
                }
            } catch (Throwable unused3) {
                str4 = null;
                str3 = null;
                z2 = !g.a(str4);
                if (z2) {
                }
                if (!g.a(str3)) {
                }
                declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod(gl1.TYPE_OPEN_URL_METHOD_GET, String.class, String.class);
                if (declaredMethod == null) {
                }
            }
            z2 = !g.a(str4);
            if (z2) {
                j = str4;
            }
            if (!g.a(str3)) {
                if (z2) {
                    j += ",";
                    j += str3;
                } else {
                    j = str3;
                }
            }
        }
        try {
            declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod(gl1.TYPE_OPEN_URL_METHOD_GET, String.class, String.class);
            if (declaredMethod == null) {
                declaredMethod.setAccessible(true);
                str2 = (String) declaredMethod.invoke(null, "ro.product.cpu.abi", null);
                try {
                    str = (String) declaredMethod.invoke(null, "ro.product.cpu.abi2", null);
                } catch (Throwable th2) {
                    th = th2;
                }
                str5 = str2;
                try {
                    if (!g.a(str5) && !j.contains(str5)) {
                        j += ",";
                        j += str5;
                    }
                    if (!g.a(str) && !j.contains(str)) {
                        j += ",";
                        j += str;
                    }
                } catch (Throwable th3) {
                    g.a(th3);
                }
                return j;
            }
            str = null;
            j += ",";
            j += str5;
            j += ",";
            j += str;
            return j;
        } catch (Throwable th4) {
            th = th4;
            str2 = null;
            g.a(th);
            str = null;
            str5 = str2;
            j += ",";
            j += str5;
            j += ",";
            j += str;
            return j;
        }
    }

    public static String f() {
        if (g.a(k)) {
            S();
        }
        return k;
    }

    private static long h(String str) {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("getLong", String.class, Long.TYPE);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                return ((Long) declaredMethod.invoke(null, str, 0L)).longValue();
            }
        } catch (Throwable th) {
            g.a(th);
        }
        return 0;
    }

    private static String i(String str) {
        try {
            return str.replaceAll("[^0-9a-zA-Z-.]", "-");
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static void s() {
        S = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new e());
    }

    static void c() {
        i = null;
    }

    static boolean i() {
        return d;
    }

    public static boolean b(int i2, Object[] objArr) {
        if (i2 != 451) {
            if (i2 != 452) {
                if (a) {
                    return false;
                }
                throw new AssertionError();
            } else if (a || objArr != null) {
                d dVar = (d) objArr[1];
                return g.a(new File((String) objArr[0]), String.format(Locale.US, "%d %d %d %d", Long.valueOf(dVar.a), Long.valueOf(dVar.b), Integer.valueOf(dVar.c), Integer.valueOf(dVar.d)).getBytes());
            } else {
                throw new AssertionError();
            }
        } else if (a || objArr != null) {
            return a((String) objArr[0], (d) objArr[1]);
        } else {
            throw new AssertionError();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x006e A[Catch:{ all -> 0x0080 }] */
    private static void c(OutputStream outputStream) {
        HashSet hashSet;
        File[] listFiles;
        Throwable th;
        try {
            outputStream.write("disk info:\n".getBytes("UTF-8"));
        } catch (Throwable th2) {
            a(th2, outputStream);
        }
        if (ae) {
            h = false;
            try {
                outputStream.write(s("FSSTAT").getBytes("UTF-8"));
            } catch (Throwable th3) {
                a(th3, outputStream);
            }
            h = true;
        } else {
            try {
                hashSet = new HashSet();
                try {
                    a(outputStream, a(new File(g.b())), hashSet);
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Throwable th5) {
                hashSet = null;
                th = th5;
                a(th, outputStream);
                a(outputStream, a(Environment.getExternalStorageDirectory()), hashSet);
                File file = new File("/storage");
                while (r2 < r3) {
                }
                a(outputStream);
            }
            try {
                a(outputStream, a(Environment.getExternalStorageDirectory()), hashSet);
                File file2 = new File("/storage");
                if (file2.exists() && (listFiles = file2.listFiles()) != null) {
                    for (File file3 : listFiles) {
                        if (file3.isDirectory()) {
                            a(outputStream, a(file3), hashSet);
                        }
                    }
                }
            } catch (Throwable th6) {
                a(th6, outputStream);
            }
        }
        a(outputStream);
    }

    static String g() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("JavaMax:    ");
            sb.append(Runtime.getRuntime().maxMemory() / 1024);
            sb.append(" kB\n");
            sb.append("JavaTotal:  ");
            sb.append(Runtime.getRuntime().totalMemory() / 1024);
            sb.append(" kB\n");
            sb.append("JavaFree:   ");
            sb.append(Runtime.getRuntime().freeMemory() / 1024);
            sb.append(" kB\n");
            sb.append("NativeHeap: ");
            sb.append(Debug.getNativeHeapSize() / 1024);
            sb.append(" kB\n");
            sb.append("NativeAllocated: ");
            sb.append(Debug.getNativeHeapAllocatedSize() / 1024);
            sb.append(" kB\n");
            sb.append("NativeFree: ");
            sb.append(Debug.getNativeHeapFreeSize() / 1024);
            sb.append(" kB\n");
            try {
                ActivityManager activityManager = (ActivityManager) g.a().getSystemService("activity");
                if (activityManager != null) {
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    sb.append("availMem:   ");
                    sb.append(memoryInfo.availMem / 1024);
                    sb.append(" kB\n");
                    sb.append("threshold:  ");
                    sb.append(memoryInfo.threshold / 1024);
                    sb.append(" kB\n");
                    sb.append("lowMemory:  ");
                    sb.append(memoryInfo.lowMemory);
                    sb.append(StringUtils.LF);
                }
            } catch (Throwable th) {
                g.a(th);
            }
            return sb.toString();
        } catch (Throwable th2) {
            g.a(th2);
            return "";
        }
    }

    private static void d(OutputStream outputStream) {
        if (b.d) {
            String o2 = b.o();
            h = false;
            if (1 == JNIBridge.cmd(17, o2)) {
                File file = new File(o2);
                try {
                    byte[] e2 = g.e(file);
                    if (e2 != null) {
                        outputStream.write(e2);
                    }
                } catch (Throwable th) {
                    a(th, outputStream);
                }
                try {
                    file.delete();
                } catch (Throwable th2) {
                    a(th2, outputStream);
                }
                h = true;
                a(outputStream);
            }
            h = true;
            return;
        }
        File[] fileArr = null;
        int i2 = 900;
        try {
            i2 = g.H();
            fileArr = new File("/proc/self/fd").listFiles();
            if (fileArr != null) {
                outputStream.write(String.format(Locale.US, "opened file count: %d, write limit: %d.\n", Integer.valueOf(fileArr.length), Integer.valueOf(i2)).getBytes("UTF-8"));
            } else {
                outputStream.write("[DEBUG] listFiles failed!\n".getBytes("UTF-8"));
            }
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        if (fileArr != null) {
            try {
                if (fileArr.length >= i2) {
                    outputStream.write("opened files:\n".getBytes("UTF-8"));
                    StringBuilder sb = new StringBuilder();
                    try {
                        for (File file2 : fileArr) {
                            sb.append(file2.getName());
                            sb.append(" -> ");
                            sb.append(file2.getCanonicalPath());
                            sb.append(StringUtils.LF);
                        }
                    } catch (Throwable th4) {
                        a(th4, outputStream);
                    }
                    outputStream.write(sb.toString().getBytes("UTF-8"));
                }
            } catch (Throwable th5) {
                a(th5, outputStream);
            }
        }
        a(outputStream);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x006f A[SYNTHETIC, Splitter:B:33:0x006f] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x009b  */
    private static void f(OutputStream outputStream) {
        BufferedReader bufferedReader;
        Throwable th;
        int indexOf;
        boolean z2;
        if (b.d) {
            try {
                outputStream.write("solib build id:\n".getBytes("UTF-8"));
            } catch (Throwable th2) {
                a(th2, outputStream);
            }
            FileReader fileReader = null;
            try {
                ArrayList arrayList = new ArrayList();
                FileReader fileReader2 = new FileReader(new File("/proc/self/maps"));
                try {
                    bufferedReader = new BufferedReader(fileReader2, 512);
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            } else if (readLine.endsWith(".so") && (indexOf = readLine.indexOf(47)) != -1) {
                                String substring = readLine.substring(indexOf);
                                if (!substring.contains("/data/")) {
                                    if (!substring.contains(a.a)) {
                                        z2 = false;
                                        if (z2 && !arrayList.contains(substring)) {
                                            arrayList.add(substring);
                                            if (!ae) {
                                                try {
                                                    outputStream.write((String.format("$^%s`%s^$", "SOBUILDID", substring) + StringUtils.LF).getBytes("UTF-8"));
                                                } catch (Throwable th3) {
                                                    a(th3, outputStream);
                                                }
                                            } else {
                                                outputStream.write(String.format(Locale.US, "%s: %s\n", substring, JNIBridge.nativeGet(3, 0, substring)).getBytes("UTF-8"));
                                            }
                                        }
                                    }
                                }
                                z2 = true;
                                arrayList.add(substring);
                                if (!ae) {
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            fileReader = fileReader2;
                            try {
                                a(th, outputStream);
                                g.a(fileReader);
                                g.a(bufferedReader);
                                a(outputStream);
                            } catch (Throwable th5) {
                                g.a(fileReader);
                                g.a(bufferedReader);
                                throw th5;
                            }
                        }
                    }
                    g.a(fileReader2);
                } catch (Throwable th6) {
                    th = th6;
                    bufferedReader = null;
                    fileReader = fileReader2;
                    a(th, outputStream);
                    g.a(fileReader);
                    g.a(bufferedReader);
                    a(outputStream);
                }
            } catch (Throwable th7) {
                th = th7;
                bufferedReader = null;
                a(th, outputStream);
                g.a(fileReader);
                g.a(bufferedReader);
                a(outputStream);
            }
            g.a(bufferedReader);
            a(outputStream);
        }
    }

    public static String k() {
        String str = w;
        if (g.a(str)) {
            synchronized (x) {
                str = g.a(b.i(), g.P() ? "https://up4-intl.ucweb.com/upload" : "https://up4.ucweb.com/upload", true);
                w = str;
            }
        }
        return str;
    }

    public static void l() {
        synchronized (x) {
            w = null;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0171, code lost:
        if (com.uc.crashsdk.b.q() != false) goto L_0x01f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0177, code lost:
        if (com.uc.crashsdk.a.d.e() != false) goto L_0x0183;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0179, code lost:
        com.uc.crashsdk.a.a.c("DEBUG", com.uc.crashsdk.a.d.b());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0182, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x018a, code lost:
        if (d(com.uc.crashsdk.export.LogType.UNEXP_TYPE) != false) goto L_0x0195;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x018c, code lost:
        com.uc.crashsdk.a.a.d("DEBUG", "unexp sample miss");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0194, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0195, code lost:
        r8 = com.uc.crashsdk.JNIBridge.nativeGenerateUnexpLog((long) com.uc.crashsdk.g.o(), com.uc.crashsdk.g.p());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x01a2, code lost:
        if (r8 == 0) goto L_0x01ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x01a4, code lost:
        com.uc.crashsdk.f.a(11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x01ab, code lost:
        if ((r8 & com.uc.crashsdk.export.LogType.UNEXP_KILL_PROCESS) == 0) goto L_0x01b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x01ad, code lost:
        com.uc.crashsdk.e.Y = 105;
        r8 = 30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x01b3, code lost:
        com.uc.crashsdk.f.a(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x01b9, code lost:
        if ((r8 & 8448) == 0) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x01bb, code lost:
        com.uc.crashsdk.e.Y = 104;
        r8 = 31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x01c4, code lost:
        if ((r8 & com.uc.crashsdk.export.LogType.UNEXP_RESTART) == 0) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x01c6, code lost:
        com.uc.crashsdk.e.Y = 106;
        r8 = 32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x01cf, code lost:
        if ((r8 & 1280) == 0) goto L_0x01d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x01d1, code lost:
        com.uc.crashsdk.e.Y = 103;
        com.uc.crashsdk.f.a(10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x01db, code lost:
        if ((r8 & 2304) == 0) goto L_0x01e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x01dd, code lost:
        com.uc.crashsdk.e.Y = 107;
        com.uc.crashsdk.f.a(29);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x01e5, code lost:
        com.uc.crashsdk.e.Y = 102;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x01e9, code lost:
        a(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x01ec, code lost:
        monitor-enter(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:?, code lost:
        com.uc.crashsdk.e.W = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x01ef, code lost:
        monitor-exit(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x01f0, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x01f4, code lost:
        return;
     */
    public static void a(int i2, Object[] objArr) {
        switch (i2) {
            case 401:
                JNIBridge.nativeCmd(10, b.I() == 5 ? 1 : 0, null, null);
                a.c = true;
                a.a(false);
                K = true;
                Y();
                y();
                return;
            case 402:
                Object obj = X;
                synchronized (obj) {
                    if (W != null) {
                        V = true;
                        break;
                    } else {
                        return;
                    }
                }
            case 403:
                aa();
                return;
            case 404:
            default:
                if (!a) {
                    throw new AssertionError();
                }
                return;
            case 405:
                K = false;
                StringBuilder X2 = X();
                String g2 = b.g();
                if (X2 != null) {
                    g.a(new File(g2), X2.toString());
                    return;
                }
                return;
            case 406:
                if (a || objArr != null) {
                    a((String) objArr[0], ((Boolean) objArr[1]).booleanValue(), ((Boolean) objArr[2]).booleanValue());
                    return;
                }
                throw new AssertionError();
            case 407:
                try {
                    a.d();
                    return;
                } catch (Throwable th) {
                    g.a(th);
                    return;
                }
            case RpcException.ErrorCode.API_UNAUTHORIZED:
                synchronized (aa) {
                    if (!ab && g.O()) {
                        if (b.z()) {
                            b.s();
                            h.f();
                            f.c();
                            if (b.F()) {
                                C();
                            }
                            if (g.O()) {
                                a(Calendar.getInstance());
                            }
                            ab = true;
                            return;
                        }
                    }
                    return;
                }
            case 409:
                d(false);
                return;
            case 410:
                a(false, true);
                return;
            case 411:
                if (b.d) {
                    JNIBridge.set(28, d(LogType.NATIVE_TYPE));
                    JNIBridge.set(29, d("anr"));
                    return;
                }
                return;
            case 412:
                if (!Q && b.B() && g.K()) {
                    b(g.a());
                    return;
                } else if (!Q) {
                    return;
                } else {
                    if (!b.B() || !g.K()) {
                        try {
                            g.a().unregisterReceiver(P);
                            Q = false;
                            return;
                        } catch (Throwable th2) {
                            g.a(th2);
                            return;
                        }
                    } else {
                        return;
                    }
                }
            case 413:
                JNIBridge.cmd(8);
                return;
            case 414:
                try {
                    if (!d(g.a())) {
                        int i3 = M + 1;
                        M = i3;
                        if (i3 < 10) {
                            W();
                            return;
                        } else if (b.d) {
                            JNIBridge.set(130, "(get failed)");
                            return;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th3) {
                    g.a(th3);
                    return;
                }
            case 415:
                if (a || objArr != null) {
                    long longValue = ((Long) objArr[0]).longValue();
                    Calendar instance = Calendar.getInstance();
                    if (instance.getTimeInMillis() >= longValue) {
                        h.g();
                        f.a(100);
                        d(true);
                        f.a(true);
                        h.b();
                    } else {
                        h.h();
                        h.i();
                        h.c();
                    }
                    a(instance);
                    break;
                } else {
                    throw new AssertionError();
                }
            case TypedValues.Cycle.TYPE_PATH_ROTATE:
                break;
        }
        V();
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a extends OutputStream {
        private final long a;
        private final OutputStream b;
        private int c = 0;
        private int d = 0;
        private boolean e = false;

        a(long j, OutputStream outputStream) {
            this.a = j;
            this.b = outputStream;
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0027  */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0030  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0037  */
        private int a(byte[] bArr, int i, int i2) {
            int i3;
            this.d += i2;
            if (this.e) {
                return 0;
            }
            int y = g.y();
            if (y > 0) {
                int i4 = this.c;
                if (i4 + i2 > y) {
                    i3 = y - i4;
                    this.c += i3;
                    if (this.a == 0) {
                        b(new String(bArr, i, i3));
                    } else {
                        this.b.write(bArr, i, i3);
                    }
                    if (i3 < i2) {
                        this.e = true;
                    }
                    return i3;
                }
            }
            i3 = i2;
            this.c += i3;
            if (this.a == 0) {
            }
            if (i3 < i2) {
            }
            return i3;
        }

        private void b(String str) {
            if (b.d) {
                JNIBridge.nativeClientWriteData(this.a, str);
            }
        }

        @Override // java.io.OutputStream
        public final void write(int i) {
            if (e.h && e.N()) {
                com.uc.crashsdk.a.a.d("DEBUG", String.format(Locale.US, "%c", Integer.valueOf(i)));
            }
            if (this.a != 0) {
                b(String.format(Locale.US, "%c", Integer.valueOf(i)));
            } else {
                this.b.write(i);
            }
            this.c++;
            this.d++;
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr, int i, int i2) {
            if (e.h && e.N()) {
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArr, i, bArr2, 0, i2);
                if (!(i2 == 1 && bArr2[0] == 10)) {
                    try {
                        com.uc.crashsdk.a.a.d("DEBUG", new String(bArr2));
                    } catch (Throwable unused) {
                    }
                }
            }
            a(bArr, i, i2);
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            try {
                if (this.d - this.c > 0) {
                    a(StringUtils.LF);
                    a("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n");
                }
                int y = g.y();
                a(String.format(Locale.US, "Full: %d bytes, write: %d bytes, limit: %d bytes, reject: %d bytes.\n", Integer.valueOf(this.d), Integer.valueOf(this.c), Integer.valueOf(y), Integer.valueOf(this.d - this.c)));
            } catch (Throwable th) {
                g.a(th);
            }
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr) {
            if (e.h && e.N() && !(bArr.length == 1 && bArr[0] == 10)) {
                try {
                    com.uc.crashsdk.a.a.d("DEBUG", new String(bArr));
                } catch (Throwable unused) {
                }
            }
            a(bArr, 0, bArr.length);
        }

        /* access modifiers changed from: package-private */
        public final void a(String str) {
            if (e.h && e.N()) {
                com.uc.crashsdk.a.a.d("DEBUG", str);
            }
            if (this.a != 0) {
                b(str);
            } else {
                this.b.write(str.getBytes("UTF-8"));
            }
        }
    }

    public static String h() {
        String str = m;
        if (str != null) {
            return str;
        }
        String a2 = a(Process.myPid());
        m = a2;
        return a2;
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class d {
        long a;
        long b;
        int c;
        int d;
        boolean e;
        boolean f;
        boolean g;

        private d() {
            this.a = 0;
            this.b = 0;
            this.c = 0;
            this.d = 0;
            this.e = false;
            this.f = false;
            this.g = false;
        }

        /* synthetic */ d(byte b2) {
            this();
        }
    }

    public static void j() {
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(StrictMode.getThreadPolicy()).permitNetwork().build());
        } catch (Throwable th) {
            g.a(th);
        }
    }

    public static void m() {
        if (!ae) {
            f.a(1, new com.uc.crashsdk.a.e(411), 1000);
        }
    }

    public static void p() {
        String str;
        Throwable th;
        if (g.a(A)) {
            String str2 = null;
            try {
                File file = new File(g.U() + "unique");
                if (file.exists()) {
                    str = g.a(file, 48, false);
                    if (str != null) {
                        try {
                            if (str.length() == 36) {
                                str2 = str.replaceAll("[^0-9a-zA-Z-]", "-");
                            }
                        } catch (Exception e2) {
                            g.a(e2);
                        } catch (Throwable th2) {
                            th = th2;
                            g.a(th);
                            str2 = str;
                            A = str2;
                        }
                    }
                    str2 = str;
                }
                if (g.a(str2)) {
                    b.G();
                    str2 = UUID.randomUUID().toString();
                    if (!g.a(str2)) {
                        g.a(file, str2.getBytes());
                    }
                }
            } catch (Throwable th3) {
                str = null;
                th = th3;
                g.a(th);
                str2 = str;
                A = str2;
            }
            A = str2;
        }
    }

    public static String q() {
        return A;
    }

    static void r() {
        N = false;
        if (!b.B()) {
            f.a(3, new com.uc.crashsdk.a.e(TypedValues.Cycle.TYPE_PATH_ROTATE), 11000);
        }
        if (!U()) {
            M = 0;
            W();
        }
    }

    private static void b(OutputStream outputStream, String str, String str2) {
        String str3;
        String str4;
        try {
            outputStream.write("*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            a(th, outputStream);
        }
        try {
            Locale locale = Locale.US;
            outputStream.write(String.format(locale, "Basic Information: 'pid: %d/tid: %d/time: %s'\n", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()), n()).getBytes("UTF-8"));
            Object[] objArr = new Object[3];
            objArr[0] = e();
            if (g.a(l)) {
                S();
            }
            objArr[1] = l;
            objArr[2] = f();
            outputStream.write(String.format(locale, "Cpu Information: 'abi: %s/processor: %s/hardware: %s'\n", objArr).getBytes("UTF-8"));
        } catch (Throwable th2) {
            a(th2, outputStream);
        }
        try {
            Locale locale2 = Locale.US;
            outputStream.write(String.format(locale2, "Mobile Information: 'model: %s/version: %s/sdk: %d'\n", com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL(), Build.VERSION.getRELEASE(), Integer.valueOf(Build.VERSION.SDK_INT)).getBytes("UTF-8"));
            outputStream.write(("Build fingerprint: '" + android.os.Build.FINGERPRINT + "'\n").getBytes("UTF-8"));
            Object[] objArr2 = new Object[4];
            objArr2[0] = a(new Date(b));
            objArr2[1] = Long.valueOf(Runtime.getRuntime().maxMemory());
            objArr2[2] = g.d();
            objArr2[3] = b.B() ? "fg" : "bg";
            outputStream.write(String.format(locale2, "Runtime Information: 'start: %s/maxheap: %s/primaryabi: %s/ground: %s'\n", objArr2).getBytes("UTF-8"));
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        try {
            Locale locale3 = Locale.US;
            outputStream.write(String.format(locale3, "Application Information: 'version: %s/subversion: %s/buildseq: %s/versioncode: %d'\n", g.R(), g.S(), g.T(), Integer.valueOf(a.c())).getBytes("UTF-8"));
            String str5 = "0";
            String str6 = "";
            if (b.d) {
                String nativeGet = JNIBridge.nativeGet(1, 0, null);
                str4 = JNIBridge.nativeGet(2, 0, null);
                str5 = nativeGet;
            } else {
                str4 = str6;
            }
            outputStream.write(String.format(locale3, "CrashSDK Information: 'version: %s/nativeseq: %s/javaseq: %s/arch: %s/target: %s'\n", CrashReporter._VERSION, str5, "200915125514", str4, "release").getBytes("UTF-8"));
            if (str != null) {
                str6 = str;
            }
            outputStream.write(("Report Name: " + str6.substring(str6.lastIndexOf(47) + 1) + StringUtils.LF).getBytes("UTF-8"));
        } catch (Throwable th4) {
            a(th4, outputStream);
        }
        try {
            if (ae) {
                str3 = s("UUID");
            } else {
                str3 = A;
            }
            outputStream.write(String.format("UUID: %s\n", str3).getBytes("UTF-8"));
            outputStream.write(("Log Type: " + str2 + StringUtils.LF).getBytes("UTF-8"));
        } catch (Throwable th5) {
            a(th5, outputStream);
        }
        try {
            String E2 = b.E();
            if (g.a(E2)) {
                E2 = "(none)";
            }
            outputStream.write(("Activity: " + E2 + StringUtils.LF).getBytes("UTF-8"));
        } catch (Throwable th6) {
            a(th6, outputStream);
        }
        a(outputStream);
        try {
            a.a(outputStream, "UTF-8");
            if (ae) {
                h = false;
                outputStream.write(s(MtopParamType.HEADER).getBytes("UTF-8"));
                h = true;
            }
        } catch (Throwable th7) {
            a(th7, outputStream);
        }
        a(outputStream);
    }

    static String n() {
        return a(new Date());
    }

    private static void g(OutputStream outputStream) {
        String str;
        try {
            outputStream.write("recent status:\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            a(th, outputStream);
        }
        try {
            if (ae) {
                str = s("LASTVER");
            } else {
                str = a.m();
            }
            outputStream.write(String.format(Locale.US, "last version: '%s'\n", str).getBytes("UTF-8"));
        } catch (Throwable th2) {
            a(th2, outputStream);
        }
        try {
            ArrayList<String> arrayList = r;
            synchronized (arrayList) {
                if (t != null) {
                    outputStream.write(String.format(Locale.US, "generating log: %s\n", t).getBytes("UTF-8"));
                }
                if (s > 0 || arrayList.size() > 0) {
                    outputStream.write(String.format(Locale.US, "generated %d logs, recent are:\n", Integer.valueOf(s)).getBytes("UTF-8"));
                    Iterator<String> it = arrayList.iterator();
                    while (it.hasNext()) {
                        outputStream.write(String.format(Locale.US, "* %s\n", it.next()).getBytes("UTF-8"));
                    }
                }
            }
            Locale locale = Locale.US;
            outputStream.write(String.format(locale, "dumping all threads: %s\n", Boolean.valueOf(u)).getBytes("UTF-8"));
            String str2 = v;
            if (str2 != null) {
                outputStream.write(String.format(locale, "dumping threads: %s\n", str2).getBytes("UTF-8"));
            }
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        a(outputStream);
    }

    public static void c(String str) {
        synchronized (y) {
            String l2 = b.l();
            com.uc.crashsdk.a.b.a(l2, str + StringUtils.LF);
        }
    }

    static void c(boolean z2) {
        boolean z3 = true;
        if (!Q ? !z2 || !g.K() : z2 && g.K()) {
            z3 = false;
        }
        if (z3) {
            com.uc.crashsdk.a.e eVar = R;
            if (f.b(eVar)) {
                f.a(eVar);
            }
            f.a(0, eVar, 3000);
        }
    }

    static void a(boolean z2) {
        File[] listFiles;
        try {
            if (b.y() && (listFiles = new File(g.V()).listFiles()) != null) {
                int l2 = g.l();
                int m2 = g.m();
                if (listFiles.length >= Math.min(l2, m2)) {
                    int i2 = 0;
                    int i3 = 0;
                    for (File file : listFiles) {
                        if (b(file)) {
                            i2++;
                        } else {
                            i3++;
                        }
                    }
                    int i4 = (!z2 || i2 < l2) ? 0 : (i2 - l2) + 1;
                    int i5 = (z2 || i3 < m2) ? 0 : (i3 - m2) + 1;
                    if (!(i4 == 0 && i5 == 0)) {
                        Arrays.sort(listFiles, new b((byte) 0));
                        int i6 = i4;
                        int i7 = i5;
                        for (File file2 : listFiles) {
                            boolean b2 = b(file2);
                            if (b2 && i6 > 0) {
                                com.uc.crashsdk.a.a.a("crashsdk", "Delete oldest crash log: " + file2.getPath());
                                file2.delete();
                                i6 += -1;
                            } else if (!b2 && i7 > 0) {
                                com.uc.crashsdk.a.a.a("crashsdk", "Delete oldest custom log: " + file2.getPath());
                                file2.delete();
                                i7 += -1;
                            }
                            if (i6 == 0 && i7 == 0) {
                                break;
                            }
                        }
                        f.a(16, i4 + i5);
                        if (i4 > 0) {
                            f.a(22, i4);
                        }
                        if (i5 > 0) {
                            f.a(23, i5);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            g.a(th);
        }
    }

    public static int f(boolean z2) {
        int i2;
        if (z2) {
            i2 = f.a(b.c()) ? 1 : 0;
        } else {
            i2 = f.b();
        }
        int b2 = f.b(z2);
        return b2 > i2 ? b2 : i2;
    }

    public static void o() {
        b = System.currentTimeMillis();
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0025 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0026  */
    private static void e(OutputStream outputStream) {
        int i2;
        int i3;
        Throwable th;
        File[] fileArr = null;
        try {
            i3 = g.I();
            try {
                fileArr = new File("/proc/self/task").listFiles();
                if (fileArr == null || (i2 = fileArr.length) < i3) {
                    return;
                }
            } catch (Throwable th2) {
                th = th2;
                g.a(th);
                i2 = 0;
                if (fileArr != null) {
                }
            }
        } catch (Throwable th3) {
            th = th3;
            i3 = 300;
            g.a(th);
            i2 = 0;
            if (fileArr != null) {
            }
        }
        if (fileArr != null) {
            try {
                outputStream.write("threads info:\n".getBytes("UTF-8"));
                outputStream.write(String.format(Locale.US, "threads count: %d, dump limit: %d.\n", Integer.valueOf(i2), Integer.valueOf(i3)).getBytes("UTF-8"));
                outputStream.write(" tid     name\n".getBytes("UTF-8"));
                for (File file : fileArr) {
                    outputStream.write(String.format(Locale.US, "%5s %s\n", file.getName(), l(g.a(new File(file.getPath(), "comm"), 128, false))).getBytes("UTF-8"));
                }
            } catch (Throwable th4) {
                a(th4, outputStream);
            }
            a(outputStream);
        }
    }

    static StringBuilder f(String str) {
        return a(Thread.currentThread().getStackTrace(), str);
    }

    static boolean d(String str) {
        if (ae) {
            return true;
        }
        try {
            return p(str);
        } catch (Throwable th) {
            g.a(th);
            return true;
        }
    }

    /* access modifiers changed from: private */
    public static boolean d(Context context) {
        List<ActivityManager.ProcessErrorStateInfo> processesInErrorState;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        boolean z2 = false;
        if (activityManager == null || (processesInErrorState = activityManager.getProcessesInErrorState()) == null) {
            return false;
        }
        int myPid = Process.myPid();
        Iterator<ActivityManager.ProcessErrorStateInfo> it = processesInErrorState.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ActivityManager.ProcessErrorStateInfo next = it.next();
            if (next.pid == myPid) {
                N = true;
                if (N()) {
                    com.uc.crashsdk.a.a.d("crashsdk", "ANR occurred in process: " + next.processName);
                }
                if (b.d) {
                    JNIBridge.set(130, next.longMsg);
                }
                z2 = true;
            }
        }
        if (!z2 && b.d) {
            V();
        }
        return true;
    }

    static String a(String str, String str2) {
        String[] strArr;
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                strArr = new String[]{IRequestConst.PS, "-ef"};
            } else {
                strArr = new String[]{IRequestConst.PS};
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(strArr).getInputStream()));
            boolean b2 = g.b(str);
            boolean b3 = g.b(str2);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return byteArrayOutputStream.toString("UTF-8");
                }
                boolean z2 = true;
                if ((!b2 || !readLine.contains(str)) && ((!b3 || !readLine.contains(str2)) && (readLine.indexOf(47) >= 0 || readLine.indexOf(46) <= 0))) {
                    z2 = false;
                }
                if (z2) {
                    byteArrayOutputStream.write(readLine.getBytes("UTF-8"));
                    byteArrayOutputStream.write(StringUtils.LF.getBytes("UTF-8"));
                }
            }
        } catch (Throwable th) {
            g.a(th);
            return "exception exists.";
        }
    }

    public static void d(boolean z2) {
        f.d(false);
        if (z2) {
            f.a(b.c(), false);
            h.i();
            return;
        }
        f.a();
        h.i();
    }

    public static boolean e(String str) {
        try {
            if (!g.b(str) || !str.startsWith(SolidMonitor.CHECK_TYPE_LIB) || !str.endsWith(".so")) {
                return false;
            }
            System.loadLibrary(str.substring(3, str.length() - 3));
            return true;
        } catch (Throwable th) {
            g.a(th);
            return false;
        }
    }

    public static int e(boolean z2) {
        return f.a(z2);
    }

    private static BufferedReader a(InputStreamReader inputStreamReader) {
        BufferedReader bufferedReader = null;
        int i2 = 8192;
        while (bufferedReader == null && i2 > 0) {
            try {
                bufferedReader = new BufferedReader(inputStreamReader, i2);
            } catch (Throwable unused) {
                i2 /= 2;
                if (i2 < 512) {
                    break;
                }
            }
        }
        return bufferedReader;
    }

    private static void a(OutputStream outputStream) {
        try {
            outputStream.write("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            a(th, outputStream);
        }
    }

    private static String a(File file) {
        String str;
        try {
            str = file.getCanonicalPath();
        } catch (Throwable unused) {
            str = null;
        }
        return g.a(str) ? file.getPath() : str;
    }

    private static void a(OutputStream outputStream, String str, Set<String> set) {
        if (!g.a(str) && !set.contains(str) && !str.equals("/storage/emulated")) {
            set.add(str);
            try {
                StatFs statFs = new StatFs(str);
                long a2 = a(statFs, "getBlockCountLong", "getBlockCount");
                long a3 = a(statFs, "getBlockSizeLong", "getBlockSize");
                if ((a2 / 1024) * a3 >= FileUtil.LOCAL_REPORT_FILE_MAX_SIZE) {
                    long a4 = a(statFs, "getAvailableBlocksLong", "getAvailableBlocks");
                    long a5 = a(statFs, "getFreeBlocksLong", "getFreeBlocks");
                    try {
                        Locale locale = Locale.US;
                        outputStream.write(String.format(locale, "%s:\n", str).getBytes("UTF-8"));
                        double d2 = (double) a3;
                        outputStream.write(String.format(locale, "  total:      %d kB\n", Long.valueOf((long) (((((double) a2) * 1.0d) * d2) / 1024.0d))).getBytes("UTF-8"));
                        outputStream.write(String.format(locale, "  available:  %d kB\n", Long.valueOf((long) (((((double) a4) * 1.0d) * d2) / 1024.0d))).getBytes("UTF-8"));
                        outputStream.write(String.format(locale, "  free:       %d kB\n", Long.valueOf((long) (((((double) a5) * 1.0d) * d2) / 1024.0d))).getBytes("UTF-8"));
                        outputStream.write(String.format(locale, "  block size: %d B\n\n", Long.valueOf(a3)).getBytes("UTF-8"));
                    } catch (Throwable th) {
                        a(th, outputStream);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static void b(OutputStream outputStream) {
        BufferedReader bufferedReader = null;
        try {
            outputStream.write("logcat:\n".getBytes("UTF-8"));
            if (g.n() <= 0) {
                try {
                    outputStream.write("[DEBUG] custom java logcat lines count is 0!\n".getBytes("UTF-8"));
                } catch (Throwable th) {
                    a(th, outputStream);
                }
                a(outputStream);
                g.a((Closeable) null);
                return;
            }
            int n2 = g.n();
            bufferedReader = a(new InputStreamReader(Runtime.getRuntime().exec(new String[]{"logcat", "-d", "-b", "events", "-b", js2.MAIN, "-v", "threadtime", "-t", String.valueOf(n2)}).getInputStream()));
            if (bufferedReader == null) {
                try {
                    outputStream.write("[DEBUG] alloc buffer failed!\n".getBytes("UTF-8"));
                } catch (Throwable th2) {
                    a(th2, outputStream);
                }
                a(outputStream);
                g.a(bufferedReader);
                return;
            }
            h = false;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    i2++;
                    if (i3 < n2 && !readLine.contains(" I auditd ") && !readLine.contains(" I liblog ")) {
                        outputStream.write(readLine.getBytes("UTF-8"));
                        outputStream.write(StringUtils.LF.getBytes("UTF-8"));
                        i3++;
                    }
                } else {
                    try {
                        break;
                    } catch (Throwable th3) {
                        a(th3, outputStream);
                    }
                }
            }
            outputStream.write(String.format(Locale.US, "[DEBUG] Read %d lines, wrote %d lines.\n", Integer.valueOf(i2), Integer.valueOf(i3)).getBytes("UTF-8"));
            h = true;
            g.a(bufferedReader);
            a(outputStream);
        } catch (Throwable th4) {
            g.a((Closeable) null);
            throw th4;
        }
    }

    private static long a(StatFs statFs, String str, String str2) {
        try {
            if (Build.VERSION.SDK_INT >= 18) {
                Method declaredMethod = StatFs.class.getDeclaredMethod(str, new Class[0]);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(statFs, new Object[0]);
                if (invoke != null && (invoke instanceof Long)) {
                    return ((Long) invoke).longValue();
                }
            }
        } catch (Throwable unused) {
        }
        try {
            Method declaredMethod2 = StatFs.class.getDeclaredMethod(str2, new Class[0]);
            declaredMethod2.setAccessible(true);
            Object invoke2 = declaredMethod2.invoke(statFs, new Object[0]);
            if (invoke2 == null || !(invoke2 instanceof Integer)) {
                return 0;
            }
            return (long) ((Integer) invoke2).intValue();
        } catch (Throwable th) {
            g.a(th);
            return 0;
        }
    }

    private static void b(a aVar) {
        h = false;
        try {
            aVar.write((s("LOG_END") + StringUtils.LF).getBytes("UTF-8"));
        } catch (Throwable th) {
            g.a(th);
        }
        h = true;
    }

    private static void a(a aVar) {
        try {
            aVar.a(String.format(Locale.US, "log end: %s\n", n()));
        } catch (Throwable th) {
            a(th, aVar);
        }
    }

    /* JADX INFO: finally extract failed */
    static int b(OutputStream outputStream, String str, int i2) {
        int i3;
        Throwable th;
        DataInputStream dataInputStream;
        int i4;
        DataInputStream dataInputStream2 = null;
        int i5 = 0;
        try {
            File file = new File(str);
            if (file.exists()) {
                byte[] Q2 = Q();
                if (Q2 == null) {
                    outputStream.write("(alloc buffer failed!)\n".getBytes("UTF-8"));
                    g.a((Closeable) null);
                    return 0;
                }
                dataInputStream = new DataInputStream(new FileInputStream(file));
                i4 = 0;
                i3 = 0;
                loop0:
                while (true) {
                    boolean z2 = false;
                    while (true) {
                        try {
                            int read = dataInputStream.read(Q2);
                            if (read == -1) {
                                break loop0;
                            }
                            i4 += read;
                            int i6 = i2 - i3;
                            if (read <= i6 + 32) {
                                i6 = read;
                            }
                            if (i6 > 0 && !z2) {
                                outputStream.write(Q2, 0, i6);
                                i3 += i6;
                            }
                            if (!z2) {
                                if (i6 < read || i3 >= i2) {
                                    z2 = true;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            i5 = i3;
                            dataInputStream2 = dataInputStream;
                            try {
                                a(th, outputStream);
                                g.a(dataInputStream2);
                                i3 = i5;
                                a(outputStream);
                                return i3;
                            } catch (Throwable th3) {
                                g.a(dataInputStream2);
                                throw th3;
                            }
                        }
                    }
                }
            } else {
                outputStream.write(("file: '" + str + "' not exists!\n").getBytes("UTF-8"));
                dataInputStream = null;
                i4 = 0;
                i3 = 0;
            }
            if (i3 > 0) {
                outputStream.write(StringUtils.LF.getBytes("UTF-8"));
            }
            if (i3 < i4) {
                outputStream.write(String.format(Locale.US, "(truncated %d bytes)\n", Integer.valueOf(i4 - i3)).getBytes("UTF-8"));
            }
            g.a(dataInputStream);
        } catch (Throwable th4) {
            th = th4;
            a(th, outputStream);
            g.a(dataInputStream2);
            i3 = i5;
            a(outputStream);
            return i3;
        }
        a(outputStream);
        return i3;
    }

    static int a(OutputStream outputStream, String str, int i2) {
        Throwable th;
        int i3 = 0;
        if (str == null) {
            a(outputStream);
            return 0;
        }
        try {
            String a2 = com.uc.crashsdk.a.b.a(str);
            if (a2 == null) {
                a2 = "file: '" + str + "' not found or decode failed!";
            }
            int length = a2.length();
            if (length <= i2 + 32) {
                i2 = length;
            }
            if (i2 > 0) {
                try {
                    outputStream.write(a2.getBytes("UTF-8"), 0, i2);
                    outputStream.write(StringUtils.LF.getBytes("UTF-8"));
                } catch (Throwable th2) {
                    th = th2;
                    i3 = i2;
                    a(th, outputStream);
                    i2 = i3;
                    a(outputStream);
                    return i2;
                }
            }
            if (i2 < a2.length()) {
                outputStream.write(String.format(Locale.US, "(truncated %d bytes)\n", Integer.valueOf(a2.length() - i2)).getBytes("UTF-8"));
            }
        } catch (Throwable th3) {
            th = th3;
            a(th, outputStream);
            i2 = i3;
            a(outputStream);
            return i2;
        }
        a(outputStream);
        return i2;
    }

    static String a(int i2) {
        try {
            String a2 = g.a(new File(String.format(Locale.US, "/proc/%d/cmdline", Integer.valueOf(i2))), 128, false);
            if (g.b(a2)) {
                return l(a2);
            }
            return "unknown";
        } catch (Throwable th) {
            g.a(th);
            return "unknown";
        }
    }

    static void b(boolean z2) {
        try {
            boolean z3 = g.r() && b.F() && !d;
            if (!z3) {
                z3 = g.s();
            }
            if (z3) {
                if (z2) {
                    String k2 = k();
                    if (!g.a(k2)) {
                        j();
                        a(k2, false, false);
                        return;
                    }
                    return;
                }
                a(true, false);
            }
        } catch (Throwable th) {
            g.a(th);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r11v1, resolved type: com.uc.crashsdk.e$a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x02d9  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0305  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x032c  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0340 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x034a  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0351 A[Catch:{ all -> 0x0361 }] */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x035a A[Catch:{ all -> 0x0361 }] */
    private static String a(Throwable th, String str, long j2, boolean z2) {
        Throwable th2;
        a aVar = 0;
        try {
            if (!b.L()) {
                g.a();
                a(true);
            }
            int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
            a aVar2 = new a(j2, i2 == 0 ? new FileOutputStream(str) : aVar);
            try {
                if (b.d) {
                    JNIBridge.set(126, str);
                }
            } catch (Throwable th3) {
                th2 = th3;
                aVar = aVar2;
                try {
                    a(th2, aVar);
                    if (!ae) {
                    }
                    b(ae ? a(m(str)) : str, "java");
                    return str;
                } finally {
                    if (j2 != 0) {
                        b(aVar);
                    }
                    g.a(aVar);
                }
            }
            b(aVar2, str, R());
            if (z2) {
                try {
                    aVar2.flush();
                } catch (Throwable th4) {
                    g.a(th4);
                }
            }
            try {
                aVar2.write(("Process Name: '" + h() + "'\n").getBytes("UTF-8"));
                aVar2.write(("Thread Name: '" + Thread.currentThread().getName() + "'\n").getBytes("UTF-8"));
            } catch (Throwable th5) {
                g.a(th5);
            }
            try {
                aVar2.write("Back traces starts.\n".getBytes("UTF-8"));
                try {
                    Field declaredField = Throwable.class.getDeclaredField("detailMessage");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(th);
                    if (obj != null) {
                        declaredField.set(th, ((String) obj).replaceAll("\n\t", "\n->  "));
                    }
                } catch (Throwable th6) {
                    g.a(th6);
                }
                String message = th.getMessage();
                if (message != null && !message.equals(th.getLocalizedMessage())) {
                    aVar2.write(("Message: " + message + StringUtils.LF).getBytes("UTF-8"));
                }
            } catch (Throwable th7) {
                g.a(th7);
            }
            try {
                th.printStackTrace(new PrintStream(aVar2));
            } catch (Throwable th8) {
                g.a(th8);
            }
            try {
                aVar2.write("Back traces ends.\n".getBytes("UTF-8"));
            } catch (Throwable th9) {
                g.a(th9);
            }
            a((OutputStream) aVar2);
            try {
                aVar2.flush();
            } catch (Throwable th10) {
                g.a(th10);
            }
            try {
                a.a(aVar2, "UTF-8", "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n");
            } catch (Throwable th11) {
                g.a(th11);
            }
            if (z2) {
                try {
                    aVar2.flush();
                } catch (Throwable th12) {
                    g.a(th12);
                }
            }
            try {
                aVar2.write("meminfo:\n".getBytes("UTF-8"));
                b(aVar2, "/proc/meminfo", (int) MsgID.MEDIA_INFO_VIDEO_START_RECOVER);
            } catch (Throwable th13) {
                a(th13, aVar2);
            }
            try {
                String format = String.format(Locale.US, "/proc/%d/status", Integer.valueOf(Process.myPid()));
                aVar2.write("status:\n".getBytes("UTF-8"));
                b(aVar2, format, (int) MsgID.MEDIA_INFO_VIDEO_START_RECOVER);
            } catch (Throwable th14) {
                a(th14, aVar2);
            }
            try {
                aVar2.write(("memory info:\n" + g()).getBytes("UTF-8"));
            } catch (Throwable th15) {
                a(th15, aVar2);
            }
            a((OutputStream) aVar2);
            g(aVar2);
            try {
                a.a(aVar2, "UTF-8", (ArrayList<String>) aVar);
            } catch (Throwable th16) {
                a(th16, aVar2);
            }
            if (ae) {
                h = false;
                try {
                    aVar2.write(s("JAVADUMPFILES").getBytes("UTF-8"));
                } catch (Throwable th17) {
                    a(th17, aVar2);
                }
                h = true;
            }
            try {
                aVar2.flush();
            } catch (Throwable th18) {
                g.a(th18);
            }
            b((OutputStream) aVar2);
            try {
                aVar2.flush();
            } catch (Throwable th19) {
                g.a(th19);
            }
            try {
                aVar2.write("battery info:\n".getBytes("UTF-8"));
            } catch (Throwable th20) {
                a(th20, aVar2);
            }
            try {
                if (ae) {
                    h = false;
                    aVar2.write(s("BATTERYINFO").getBytes("UTF-8"));
                    h = true;
                } else {
                    StringBuilder X2 = X();
                    if (X2 != null) {
                        aVar2.write(X2.toString().getBytes("UTF-8"));
                    }
                }
            } catch (Throwable th21) {
                a(th21, aVar2);
            }
            a((OutputStream) aVar2);
            c(aVar2);
            try {
                aVar2.write("device status:\n".getBytes("UTF-8"));
            } catch (Throwable th22) {
                a(th22, aVar2);
            }
            if (ae) {
                try {
                    h = false;
                    aVar2.write(s("DEVICESTATUS").getBytes("UTF-8"));
                    h = true;
                } catch (Throwable th23) {
                    th = th23;
                }
            } else {
                try {
                    Locale locale = Locale.US;
                    aVar2.write(String.format(locale, "has root: %s\n", Boolean.valueOf(g.e())).getBytes("UTF-8"));
                    String str2 = "";
                    String str3 = android.os.Build.TAGS;
                    if (str3 != null) {
                        str2 = str3;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("build tags: ");
                    sb.append(str2);
                    if (g.f()) {
                        sb.append(" (default root)");
                    }
                    sb.append(StringUtils.LF);
                    aVar2.write(sb.toString().getBytes("UTF-8"));
                    String h2 = g.h();
                    if (g.b(h2)) {
                        aVar2.write(String.format(locale, "su binary: %s\n", h2).getBytes("UTF-8"));
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("su permission: ");
                        sb2.append(g.g() ? "valid (" : "invalid (");
                        sb2.append(g.i());
                        sb2.append(")\n");
                        aVar2.write(sb2.toString().getBytes("UTF-8"));
                    }
                } catch (Throwable th24) {
                    th = th24;
                    a(th, aVar2);
                    a((OutputStream) aVar2);
                    d(aVar2);
                    e(aVar2);
                    a.b(aVar2, "UTF-8", "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n", aVar);
                    if (ae) {
                    }
                    aVar2.flush();
                    a.a(aVar2, "UTF-8", "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n", aVar);
                    if (ae) {
                    }
                    aVar2.a();
                    a(aVar2);
                    aVar2.flush();
                    if (i2 != 0) {
                    }
                    g.a(aVar2);
                    if (!ae) {
                    }
                    b(ae ? a(m(str)) : str, "java");
                    return str;
                }
            }
            a((OutputStream) aVar2);
            d(aVar2);
            e(aVar2);
            try {
                a.b(aVar2, "UTF-8", "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n", aVar);
            } catch (Throwable th25) {
                a(th25, aVar2);
            }
            if (ae) {
                h = false;
                try {
                    aVar2.write(s("JAVACACHEDINFOS").getBytes("UTF-8"));
                } catch (Throwable th26) {
                    a(th26, aVar2);
                }
                h = true;
            }
            try {
                aVar2.flush();
            } catch (Throwable th27) {
                g.a(th27);
            }
            try {
                a.a(aVar2, "UTF-8", "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n", aVar);
            } catch (Throwable th28) {
                a(th28, aVar2);
            }
            if (ae) {
                h = false;
                try {
                    aVar2.write(s("JAVACALLBACKINFOS").getBytes("UTF-8"));
                } catch (Throwable th29) {
                    a(th29, aVar2);
                }
                h = true;
            }
            aVar2.a();
            a(aVar2);
            try {
                aVar2.flush();
            } catch (Throwable th30) {
                g.a(th30);
            }
            if (i2 != 0) {
                b(aVar2);
            }
            g.a(aVar2);
        } catch (Throwable th31) {
            th2 = th31;
            a(th2, aVar);
            if (!ae) {
            }
            b(ae ? a(m(str)) : str, "java");
            return str;
        }
        if (!ae) {
            r(str);
        }
        try {
            b(ae ? a(m(str)) : str, "java");
        } catch (Throwable th32) {
            g.a(th32);
        }
        return str;
    }

    private static boolean b(File file) {
        int indexOf;
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(95);
        if (lastIndexOf <= 0 || (indexOf = name.indexOf(46, lastIndexOf)) <= 0) {
            return false;
        }
        String substring = name.substring(lastIndexOf + 1, indexOf);
        if ("java".equals(substring) || "ucebujava".equals(substring) || LogType.NATIVE_TYPE.equals(substring) || "ucebujni".equals(substring) || LogType.UNEXP_TYPE.equals(substring) || "anr".equals(substring)) {
            return true;
        }
        return false;
    }

    private static String b(String str, boolean z2, boolean z3) {
        if (z2) {
            try {
                str = m(str);
            } catch (Throwable th) {
                g.a(th);
            }
        }
        if (!z3) {
            return str;
        }
        try {
            return a(str);
        } catch (Throwable th2) {
            g.a(th2);
            return str;
        }
    }

    static void b(String str, String str2, boolean z2) {
        h.a(str, str2, false, z2);
    }

    public static void b(String str) {
        synchronized (x) {
            w = str;
            com.uc.crashsdk.a.b.a(b.i(), str + StringUtils.LF);
        }
    }

    private static void b(String str, String str2) {
        try {
            d.a(str, h(), str2);
        } catch (Throwable th) {
            g.a(th);
        }
    }

    public static void b(Context context) {
        if (g.K()) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
                intentFilter.addAction("android.intent.action.BATTERY_LOW");
                intentFilter.addAction("android.intent.action.BATTERY_OKAY");
                context.registerReceiver(P, intentFilter, null, f.a(1));
                Q = true;
            } catch (Throwable th) {
                g.a(th);
            }
        }
    }

    public static void b(int i2) {
        f.a(0, new com.uc.crashsdk.a.e(410), (long) (i2 * 1000));
    }

    static String a(String str) {
        int lastIndexOf;
        int indexOf;
        int i2;
        int indexOf2;
        File file;
        byte[] e2;
        if (!g.x() || (lastIndexOf = str.lastIndexOf(47)) <= 0 || (indexOf = str.indexOf(95, lastIndexOf)) <= lastIndexOf || (indexOf2 = str.indexOf(95, (i2 = indexOf + 1))) <= indexOf) {
            return str;
        }
        String d2 = g.d(CrashReporter._MAGIC + str.substring(lastIndexOf + 1, indexOf) + str.substring(i2, indexOf2));
        if (d2 == null || (e2 = g.e((file = new File(str)))) == null || e2.length <= 0) {
            return str;
        }
        byte[] bArr = null;
        try {
            bArr = com.uc.crashsdk.a.c.b(e2, d2.substring(0, 16).getBytes());
        } catch (Throwable th) {
            g.a(th);
        }
        if (bArr == null) {
            return str;
        }
        String str2 = str + ".ec";
        File file2 = new File(str2 + ".tmp");
        if (!g.a(file2, bArr)) {
            return str;
        }
        if (!file2.renameTo(new File(str2))) {
            file2.delete();
            return str;
        }
        file.delete();
        return str2;
    }

    static void a(Throwable th, OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.write("[DEBUG] CrashHandler occurred new exception:\n".getBytes("UTF-8"));
                th.printStackTrace(new PrintStream(outputStream));
                outputStream.write("\n\n".getBytes("UTF-8"));
            } catch (Throwable th2) {
                g.a(th2);
            }
        }
        g.a(th);
    }

    /* JADX WARNING: Removed duplicated region for block: B:111:0x02e7  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x02f2  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0348  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x03a1  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x03b9  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x03ae A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01d8  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01f2 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x020d  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x02ad  */
    private static void a(String str, boolean z2, boolean z3) {
        Object obj;
        int i2;
        boolean z4;
        boolean z5;
        int i3;
        String path;
        String b2;
        File a2;
        int i4;
        String str2;
        int i5;
        String str3;
        Throwable th;
        File file;
        boolean z6;
        com.uc.crashsdk.a.a.a("crashsdk", "crashsdk uploading logs");
        synchronized (n) {
            try {
                if (g.b(str)) {
                    String V2 = g.V();
                    File file2 = new File(V2);
                    if (!file2.exists()) {
                        com.uc.crashsdk.a.a.a("crashsdk", "Folder not exist: " + V2);
                    } else {
                        File[] listFiles = file2.listFiles();
                        if (listFiles == null) {
                            com.uc.crashsdk.a.a.b("List folder failed: " + V2);
                        } else {
                            int length = listFiles.length;
                            int i6 = 0;
                            int i7 = 0;
                            int i8 = 0;
                            int i9 = 0;
                            int i10 = 0;
                            int i11 = 0;
                            int i12 = 0;
                            int i13 = 0;
                            int i14 = 0;
                            boolean z7 = false;
                            boolean z8 = false;
                            boolean z9 = false;
                            while (true) {
                                if (i6 >= length) {
                                    i2 = i9;
                                    z4 = z7;
                                    z5 = z8;
                                    break;
                                }
                                File file3 = listFiles[i6];
                                if (!file3.isFile()) {
                                    g.a(file3);
                                } else {
                                    String name = file3.getName();
                                    if (!name.endsWith(".tmp")) {
                                        i3 = length;
                                        z4 = z7;
                                        z5 = z8;
                                        if (file3.length() == 0) {
                                            i7++;
                                            g.a(file3);
                                        } else {
                                            if (z2) {
                                                long currentTimeMillis = (System.currentTimeMillis() - file3.lastModified()) / 1000;
                                                if (currentTimeMillis >= 0) {
                                                    if (currentTimeMillis >= 2) {
                                                        if (currentTimeMillis < 5 && file3.getName().endsWith(".log")) {
                                                        }
                                                    }
                                                    z6 = false;
                                                    com.uc.crashsdk.a.a.a(String.format(Locale.US, "file: %s, modify interval: %d s, safe upload: %s", file3.getName(), Long.valueOf(currentTimeMillis), Boolean.valueOf(z6)));
                                                    if (!z6) {
                                                        i9++;
                                                    }
                                                }
                                                z6 = true;
                                                com.uc.crashsdk.a.a.a(String.format(Locale.US, "file: %s, modify interval: %d s, safe upload: %s", file3.getName(), Long.valueOf(currentTimeMillis), Boolean.valueOf(z6)));
                                                if (!z6) {
                                                }
                                            }
                                            try {
                                                if (g.k()) {
                                                    Matcher matcher = Pattern.compile("([^_]+)_([^_]+)_([^_]+)\\.crashsdk").matcher(file3.getName());
                                                    if (matcher.matches()) {
                                                        String group = matcher.group(1);
                                                        String group2 = matcher.group(2);
                                                        i2 = i9;
                                                        try {
                                                            file = new File(g.V() + String.format(Locale.US, "%s%s_%s_%s.%s", j(group2), n(), P(), group, matcher.group(3)));
                                                            com.uc.crashsdk.a.a.a("crashsdk", "File " + file3.getPath() + " matches, rename to " + file.getPath());
                                                            file3.renameTo(file);
                                                            if (file != file3) {
                                                                i13++;
                                                            }
                                                            file3 = file;
                                                        } catch (Throwable th2) {
                                                            th = th2;
                                                        }
                                                        path = file3.getPath();
                                                        boolean[] n2 = n(path);
                                                        b2 = b(path, n2[0], n2[1]);
                                                        if (path != b2) {
                                                            if (n2[0]) {
                                                                i12++;
                                                            }
                                                            if (n2[1]) {
                                                                i10++;
                                                            }
                                                            file3 = new File(b2);
                                                        }
                                                        a2 = d.a(file3);
                                                        if (a2 == null) {
                                                            a2 = null;
                                                        } else if (file3 != a2 && !file3.getName().equals(a2.getName()) && file3.exists()) {
                                                            file3.delete();
                                                        }
                                                        if (a2 == null) {
                                                            com.uc.crashsdk.a.a.b("onBeforeUploadLog return null, skip upload: " + file3.getAbsolutePath());
                                                        } else {
                                                            int z10 = g.z();
                                                            if (z10 <= 0 || a2.length() < ((long) z10)) {
                                                                d dVar = new d((byte) 0);
                                                                dVar.b = 0;
                                                                dVar.a = System.currentTimeMillis();
                                                                String T2 = T();
                                                                if (new File(T2).exists()) {
                                                                    a(T2, new com.uc.crashsdk.a.e(451, new Object[]{T2, dVar}));
                                                                }
                                                                long A2 = g.A();
                                                                int B2 = g.B();
                                                                int C2 = g.C();
                                                                if (A2 >= 0) {
                                                                    i4 = i10;
                                                                    if (dVar.b + a2.length() > A2) {
                                                                        dVar.e = true;
                                                                        str3 = "Reach max upload bytes: " + A2;
                                                                    }
                                                                    if (!g.f()) {
                                                                        if (b(a2)) {
                                                                            if (B2 >= 0 && dVar.c >= B2) {
                                                                                dVar.g = true;
                                                                                str3 = "Reach max upload builtin log count: " + B2;
                                                                            }
                                                                        } else if (C2 >= 0 && dVar.d >= C2) {
                                                                            dVar.f = true;
                                                                            str3 = "Reach max upload custom log count: " + C2;
                                                                        }
                                                                    }
                                                                    if (dVar.e) {
                                                                        i10 = i4;
                                                                        z8 = z5;
                                                                        z4 = true;
                                                                    } else if (dVar.g) {
                                                                        i10 = i4;
                                                                        z8 = true;
                                                                    } else if (dVar.f) {
                                                                        i10 = i4;
                                                                        z8 = z5;
                                                                        z9 = true;
                                                                    } else {
                                                                        String name2 = a2.getName();
                                                                        if (name2.startsWith(O())) {
                                                                            String[] split = name2.split(JSMethod.NOT_SET, 10);
                                                                            if (split.length == 9) {
                                                                                str2 = split[1];
                                                                                boolean z11 = str2 == null && str2.equals(g.R());
                                                                                if (!com.uc.crashsdk.a.c.a(a2, a2.getName(), str)) {
                                                                                    com.uc.crashsdk.a.a.a("crashsdk", "Uploaded log: " + a2.getName(), null);
                                                                                    if (z11) {
                                                                                        f.a(13);
                                                                                    }
                                                                                    dVar.b += a2.length();
                                                                                    if (b(a2)) {
                                                                                        dVar.c++;
                                                                                    } else {
                                                                                        dVar.d++;
                                                                                    }
                                                                                    String T3 = T();
                                                                                    a(T3, new com.uc.crashsdk.a.e(452, new Object[]{T3, dVar}));
                                                                                    a2.delete();
                                                                                    i5 = 3;
                                                                                    i14 = 0;
                                                                                } else {
                                                                                    i14++;
                                                                                    if (z11) {
                                                                                        f.a(14);
                                                                                    }
                                                                                    i5 = 3;
                                                                                }
                                                                                if (i14 < i5) {
                                                                                    com.uc.crashsdk.a.a.a("crashsdk", "Upload failed 3 times continuously, abort upload!", null);
                                                                                    i10 = i4;
                                                                                    break;
                                                                                }
                                                                                i10 = i4;
                                                                                z8 = z5;
                                                                            }
                                                                        }
                                                                        str2 = null;
                                                                        if (str2 == null) {
                                                                        }
                                                                        if (!com.uc.crashsdk.a.c.a(a2, a2.getName(), str)) {
                                                                        }
                                                                        if (i14 < i5) {
                                                                        }
                                                                    }
                                                                    i6++;
                                                                    listFiles = listFiles;
                                                                    length = i3;
                                                                    z7 = z4;
                                                                    i9 = i2;
                                                                } else {
                                                                    i4 = i10;
                                                                    if (!g.f()) {
                                                                    }
                                                                    if (dVar.e) {
                                                                    }
                                                                    i6++;
                                                                    listFiles = listFiles;
                                                                    length = i3;
                                                                    z7 = z4;
                                                                    i9 = i2;
                                                                }
                                                                com.uc.crashsdk.a.a.b(str3);
                                                                if (dVar.e) {
                                                                }
                                                                i6++;
                                                                listFiles = listFiles;
                                                                length = i3;
                                                                z7 = z4;
                                                                i9 = i2;
                                                            } else {
                                                                i11++;
                                                                g.a(a2);
                                                            }
                                                        }
                                                        z8 = z5;
                                                        i6++;
                                                        listFiles = listFiles;
                                                        length = i3;
                                                        z7 = z4;
                                                        i9 = i2;
                                                    }
                                                }
                                                i2 = i9;
                                                file = file3;
                                                if (file != file3) {
                                                }
                                                file3 = file;
                                            } catch (Throwable th3) {
                                                th = th3;
                                                i2 = i9;
                                                g.a(th);
                                                path = file3.getPath();
                                                boolean[] n22 = n(path);
                                                b2 = b(path, n22[0], n22[1]);
                                                if (path != b2) {
                                                }
                                                a2 = d.a(file3);
                                                if (a2 == null) {
                                                }
                                                if (a2 == null) {
                                                }
                                                z8 = z5;
                                                i6++;
                                                listFiles = listFiles;
                                                length = i3;
                                                z7 = z4;
                                                i9 = i2;
                                            }
                                            path = file3.getPath();
                                            boolean[] n222 = n(path);
                                            b2 = b(path, n222[0], n222[1]);
                                            if (path != b2) {
                                            }
                                            a2 = d.a(file3);
                                            if (a2 == null) {
                                            }
                                            if (a2 == null) {
                                            }
                                            z8 = z5;
                                            i6++;
                                            listFiles = listFiles;
                                            length = i3;
                                            z7 = z4;
                                            i9 = i2;
                                        }
                                        i2 = i9;
                                        z8 = z5;
                                        i6++;
                                        listFiles = listFiles;
                                        length = i3;
                                        z7 = z4;
                                        i9 = i2;
                                    } else if ((System.currentTimeMillis() - file3.lastModified()) / 1000 > 30) {
                                        i3 = length;
                                        com.uc.crashsdk.a.a.b("delete legacy tmp file: " + name);
                                        i8++;
                                        g.a(file3);
                                        i2 = i9;
                                        z4 = z7;
                                        i6++;
                                        listFiles = listFiles;
                                        length = i3;
                                        z7 = z4;
                                        i9 = i2;
                                    }
                                }
                                i3 = length;
                                i2 = i9;
                                z4 = z7;
                                i6++;
                                listFiles = listFiles;
                                length = i3;
                                z7 = z4;
                                i9 = i2;
                            }
                            if (i8 > 0) {
                                f.a(200, i8);
                            }
                            if (i7 > 0) {
                                f.a(15, i7);
                            }
                            if (i11 > 0) {
                                f.a(17, i11);
                            }
                            if (z4) {
                                f.a(19);
                            }
                            if (z5) {
                                f.a(20);
                            }
                            if (z9) {
                                f.a(21);
                            }
                            if (z4 || z5 || z9) {
                                f.a(18);
                            }
                            if (i12 > 0) {
                                f.a(24, i12);
                            }
                            if (i10 > 0) {
                                f.a(201, i10);
                            }
                            if (i13 > 0) {
                                f.a(25, i13);
                            }
                            if (i2 > 0) {
                                f.a(26, i2);
                            }
                        }
                    }
                } else {
                    com.uc.crashsdk.a.a.a("crashsdk", "upload url is empty!");
                }
                if (z3) {
                    obj = n;
                    obj.notify();
                }
            } catch (Throwable th4) {
                if (z3) {
                    n.notify();
                }
                throw th4;
            }
        }
    }

    public static boolean a(boolean z2, boolean z3) {
        if (!d) {
            if (b.d) {
                JNIBridge.set(1, true);
            }
            d = true;
        }
        try {
            String k2 = k();
            if (g.a(k2)) {
                com.uc.crashsdk.a.a.a("crashsdk", "CrashHandler url is empty!");
                return false;
            }
            Object obj = n;
            synchronized (obj) {
                if (f.a(z2 ? 1 : 0, new com.uc.crashsdk.a.e(406, new Object[]{k2, Boolean.valueOf(z3), Boolean.valueOf(z2)})) && z2) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e2) {
                        g.a(e2);
                    }
                }
            }
            return true;
        } catch (Throwable th) {
            g.a(th);
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        r6 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0057, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0058, code lost:
        r1 = r5;
        r5 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        com.uc.crashsdk.a.g.a(r5);
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0060, code lost:
        r6 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0061, code lost:
        r5 = r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0024 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:10:0x0018] */
    /* JADX WARNING: Unknown variable types count: 2 */
    private static boolean a(String str, com.uc.crashsdk.a.e eVar) {
        boolean z2;
        Throwable th;
        ?? r5;
        FileChannel fileChannel;
        synchronized (o) {
            File file = new File(str);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Exception e2) {
                    g.a(e2);
                }
            }
            FileLock fileLock = null;
            fileLock = null;
            r5 = null;
            z2 = false;
            try {
                fileChannel = new RandomAccessFile(file, "rw").getChannel();
            } catch (Exception e3) {
                g.a(e3);
                fileChannel = fileLock;
            } catch (Throwable th2) {
            }
            if (fileChannel != null) {
                try {
                    fileLock = fileChannel.lock();
                } catch (Exception e4) {
                    try {
                        g.a(e4);
                    } catch (Exception e5) {
                        Exception e6 = e5;
                        FileLock fileLock2 = fileChannel;
                    }
                }
            }
            try {
                z2 = eVar.a();
                ?? r1 = fileChannel;
                g.a((Closeable) r1);
            } finally {
                if (fileLock != null) {
                    try {
                        fileLock.release();
                    } catch (Exception e7) {
                        g.a(e7);
                    }
                }
            }
        }
        return z2;
        g.a((Closeable) r5);
        throw th;
    }

    private static boolean a(String str, d dVar) {
        String a2 = g.a(new File(str), 64, false);
        if (a2 == null) {
            return false;
        }
        try {
            Matcher matcher = Pattern.compile("(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)").matcher(a2);
            if (matcher.find()) {
                long parseLong = Long.parseLong(matcher.group(1));
                if (System.currentTimeMillis() - parseLong < 86400000) {
                    dVar.b = Long.parseLong(matcher.group(2));
                    dVar.c = Integer.parseInt(matcher.group(3));
                    dVar.d = Integer.parseInt(matcher.group(4));
                    dVar.a = parseLong;
                }
            }
        } catch (Throwable th) {
            g.a(th);
        }
        return true;
    }

    public static boolean a(StringBuffer stringBuffer, String str, long j2, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, String str2) {
        long j3;
        boolean a2;
        long j4;
        if (c.get()) {
            com.uc.crashsdk.a.a.b("Processing java crash, skip generate custom log: " + str);
            return false;
        }
        boolean z2 = ae || b.L();
        if (!z2 && !com.uc.crashsdk.a.d.e()) {
            com.uc.crashsdk.a.a.c("DEBUG", com.uc.crashsdk.a.d.b());
            return false;
        } else if (!d(str)) {
            com.uc.crashsdk.a.a.d("DEBUG", "custom log sample miss: " + str);
            return false;
        } else if (Z()) {
            com.uc.crashsdk.a.a.b("Processing native crash, skip generate custom log: " + str);
            return false;
        } else if (stringBuffer == null || str == null) {
            return false;
        } else {
            String str3 = g.V() + k(str);
            boolean z3 = (j2 & 32) != 0;
            if (z2) {
                if (b.d) {
                    int i2 = z3 ? 1 : 0;
                    int i3 = z3 ? 1 : 0;
                    int i4 = z3 ? 1 : 0;
                    j4 = JNIBridge.nativeClientCreateConnection(str3, "custom", str, i2);
                } else {
                    j4 = 0;
                }
                if (j4 == 0) {
                    com.uc.crashsdk.a.a.d("DEBUG", "skip custom log: " + str);
                    return false;
                }
                j3 = j4;
            } else if (a(h(), str, z3)) {
                return false;
            } else {
                g.a();
                a(false);
                j3 = 0;
            }
            synchronized (p) {
                a2 = a(str3, j3, stringBuffer, str, j2, arrayList, arrayList2, arrayList3, str2);
            }
            if (a2 && !z2) {
                b(h(), str, z3);
            }
            if (j3 != 0) {
                JNIBridge.nativeClientCloseConnection(j3);
            }
            if (!a2) {
                return false;
            }
            if (!z2) {
                r(str3);
            }
            if (!z2) {
                str3 = a(m(str3));
            }
            b(str3, str);
            if (!z3 || z2) {
                return true;
            }
            try {
                a(true, false);
                return true;
            } catch (Throwable th) {
                g.a(th);
                return true;
            }
        }
    }

    static boolean a(String str, String str2, boolean z2) {
        if (!o(str2)) {
            return false;
        }
        h.a(str, str2, true, z2);
        com.uc.crashsdk.a.a.b(String.format(Locale.US, "Custom log '%s' has reach max count!", str2));
        return true;
    }

    private static void a(a aVar, String str, long j2) {
        String str2;
        String str3 = null;
        if (b.d) {
            try {
                aVar.flush();
            } catch (Throwable th) {
                g.a(th);
            }
            str2 = JNIBridge.nativeDumpThreads(str, j2);
            if (ae || str2 == null || str2.length() >= 512 || !str2.startsWith("/") || str2.indexOf(10) >= 0) {
                str3 = str2;
            } else {
                if (!new File(str2).exists()) {
                    str3 = "Can not found " + str2;
                }
                str3 = str2;
                str2 = str3;
            }
        } else {
            str2 = "Native not initialized, skip dump!";
        }
        if (str2 != null) {
            try {
                aVar.write(str2.getBytes("UTF-8"));
                aVar.write(StringUtils.LF.getBytes("UTF-8"));
            } catch (Throwable th2) {
                g.a(th2);
            }
            a((OutputStream) aVar);
        } else if (str3 != null && !ae) {
            b(aVar, str3, 1048576);
            File file = new File(str3);
            if (file.exists()) {
                file.delete();
            }
        }
        try {
            aVar.flush();
        } catch (Throwable th3) {
            g.a(th3);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0043 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0044  */
    private static boolean a(String str, long j2, StringBuffer stringBuffer, String str2, long j3, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, String str3) {
        a aVar;
        FileOutputStream fileOutputStream;
        Throwable th;
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i2 == 0) {
            try {
                fileOutputStream = new FileOutputStream(str);
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                aVar = null;
                g.a(th);
                if (aVar != null) {
                }
            }
        } else {
            fileOutputStream = null;
        }
        try {
            aVar = new a(j2, fileOutputStream);
        } catch (Throwable th3) {
            th = th3;
            aVar = null;
            g.a(th);
            if (aVar != null) {
            }
        }
        try {
            synchronized (r) {
                t = str;
                if (b.d) {
                    JNIBridge.set(126, t);
                }
            }
        } catch (Throwable th4) {
            th = th4;
            g.a(th);
            if (aVar != null) {
            }
        }
        if (aVar != null) {
            return false;
        }
        if ((j3 & 1) != 0) {
            try {
                b(aVar, str, str2);
            } catch (Throwable th5) {
                g.a(aVar);
                g.a(fileOutputStream);
                throw th5;
            }
        }
        try {
            aVar.write(stringBuffer.toString().getBytes());
            aVar.write(StringUtils.LF.getBytes("UTF-8"));
            aVar.flush();
        } catch (Throwable th6) {
            a(th6, aVar);
        }
        a((OutputStream) aVar);
        if ((j3 & 4) != 0) {
            b((OutputStream) aVar);
            try {
                aVar.flush();
            } catch (Throwable th7) {
                g.a(th7);
            }
        }
        if (arrayList != null && arrayList.size() > 0) {
            a.a(aVar, "UTF-8", arrayList);
        }
        if (arrayList2 != null && arrayList2.size() > 0) {
            a.a(aVar, "UTF-8", "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n", arrayList2);
        }
        if (arrayList3 != null && arrayList3.size() > 0) {
            a.b(aVar, "UTF-8", "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n", arrayList3);
        }
        if (str3 != null) {
            try {
                aVar.flush();
            } catch (Throwable th8) {
                a(th8, aVar);
            }
            try {
                aVar.write("threads dump:\n".getBytes("UTF-8"));
            } catch (Throwable th9) {
                a(th9, aVar);
            }
            h = false;
            v = str3;
            try {
                a(aVar, str3, j2);
            } catch (Throwable th10) {
                a(th10, aVar);
            }
            v = null;
            h = true;
        }
        if ((j3 & 8) != 0 && i2 == 0) {
            try {
                aVar.flush();
            } catch (Throwable th11) {
                a(th11, aVar);
            }
            try {
                aVar.write("all threads dump:\n".getBytes("UTF-8"));
            } catch (Throwable th12) {
                a(th12, aVar);
            }
            u = true;
            try {
                a(aVar, "all", 0L);
            } catch (Throwable th13) {
                a(th13, aVar);
            }
            u = false;
        }
        if ((j3 & 16) != 0) {
            f(aVar);
        }
        if ((j3 & 2) != 0) {
            aVar.a();
            a(aVar);
        }
        if (i2 != 0) {
            b(aVar);
        }
        g.a(aVar);
        g.a(fileOutputStream);
        try {
            ArrayList<String> arrayList4 = r;
            synchronized (arrayList4) {
                s++;
                String str4 = t;
                if (str4 != null) {
                    arrayList4.add(str4);
                    if (arrayList4.size() > 3) {
                        arrayList4.remove(0);
                    }
                    if (b.d) {
                        JNIBridge.set(127, t);
                    }
                    t = null;
                }
                if (b.d) {
                    JNIBridge.set(25, (long) s);
                }
            }
        } catch (Throwable th14) {
            g.a(th14);
        }
        return true;
    }

    private static String a(Date date) {
        return String.format(Locale.US, "%d%02d%02d%02d%02d%02d", Integer.valueOf(date.getYear() + 1900), Integer.valueOf(date.getMonth() + 1), Integer.valueOf(date.getDate()), Integer.valueOf(date.getHours()), Integer.valueOf(date.getMinutes()), Integer.valueOf(date.getSeconds()));
    }

    static void a(OutputStream outputStream, String str, String str2, int i2, boolean z2, boolean z3) {
        int i3 = 0;
        h = false;
        try {
            Locale locale = Locale.US;
            Object[] objArr = new Object[5];
            objArr[0] = str;
            objArr[1] = str2;
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = Integer.valueOf(z2 ? 1 : 0);
            if (z3) {
                i3 = 1;
            }
            objArr[4] = Integer.valueOf(i3);
            outputStream.write(String.format(locale, "$^%s`%s`%d`%d,%d^$", objArr).getBytes("UTF-8"));
        } catch (Throwable th) {
            g.a(th);
        }
        h = true;
        a(outputStream);
    }

    static void a(OutputStream outputStream, String str, String str2) {
        h = false;
        try {
            outputStream.write(String.format(Locale.US, "$^%s`%s^$", str, str2).getBytes("UTF-8"));
        } catch (Throwable th) {
            g.a(th);
        }
        h = true;
    }

    public static void a(Context context) {
        try {
            if (U()) {
                context.registerReceiver(new c((byte) 0), new IntentFilter("android.intent.action.ANR"), null, f.a(3));
            }
        } catch (Throwable th) {
            g.a(th);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x01cf A[SYNTHETIC, Splitter:B:132:0x01cf] */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0236 A[Catch:{ all -> 0x025f }] */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x02b5 A[Catch:{ all -> 0x02de }] */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x02eb  */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x02f7  */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x0357 A[Catch:{ all -> 0x0380 }] */
    /* JADX WARNING: Removed duplicated region for block: B:288:0x038d  */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x03d6 A[Catch:{ all -> 0x03ff }] */
    /* JADX WARNING: Removed duplicated region for block: B:333:0x040c  */
    /* JADX WARNING: Removed duplicated region for block: B:341:0x0444  */
    /* JADX WARNING: Removed duplicated region for block: B:354:0x04a2 A[SYNTHETIC, Splitter:B:354:0x04a2] */
    /* JADX WARNING: Removed duplicated region for block: B:369:0x04bf A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:379:0x04da A[Catch:{ all -> 0x0503 }] */
    /* JADX WARNING: Removed duplicated region for block: B:393:0x0510  */
    /* JADX WARNING: Removed duplicated region for block: B:402:0x0536 A[Catch:{ all -> 0x05cd, all -> 0x05f1, all -> 0x05ed, all -> 0x0607, all -> 0x063f }] */
    /* JADX WARNING: Removed duplicated region for block: B:409:0x0557 A[SYNTHETIC, Splitter:B:409:0x0557] */
    /* JADX WARNING: Removed duplicated region for block: B:424:0x0574 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:434:0x058f A[Catch:{ all -> 0x05b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:448:0x05c5  */
    /* JADX WARNING: Removed duplicated region for block: B:471:0x05fb A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008a A[Catch:{ all -> 0x00b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:495:0x064c  */
    /* JADX WARNING: Removed duplicated region for block: B:501:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:503:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:505:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:507:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:509:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:511:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:513:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:515:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x010b A[Catch:{ all -> 0x0134 }] */
    public final void a(Thread thread, Throwable th, boolean z2) {
        long j2;
        boolean z3;
        Throwable th2;
        boolean z4;
        boolean z5;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        Throwable th3;
        boolean z6;
        boolean z7;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler2;
        Throwable th4;
        boolean z8;
        String str;
        boolean z9;
        boolean z10;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler3;
        Throwable th5;
        File file;
        boolean z11;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler4;
        Throwable th6;
        boolean z12;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler5;
        Throwable th7;
        boolean z13;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler6;
        Throwable th8;
        boolean z14;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler7;
        Throwable th9;
        Throwable th10;
        boolean z15;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler8;
        Throwable th11;
        boolean z16;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler9;
        Throwable th12;
        boolean z17 = (ae && b.d) || b.L();
        try {
            if (!c.getAndSet(true) || Process.myPid() <= 0) {
                T = th;
                if (z17 || com.uc.crashsdk.a.d.e()) {
                    com.uc.crashsdk.a.a.d("DEBUG", "begin to generate java report");
                    try {
                        for (FileInputStream fileInputStream : this.e) {
                            g.a(fileInputStream);
                        }
                        this.e.clear();
                    } catch (Throwable th13) {
                        g.a(th13);
                    }
                    try {
                        z8 = g.t();
                        try {
                            String g2 = g.g();
                            if (g2 == null || g2.equals("")) {
                                g2 = k(R());
                            }
                            str = g.V() + g2;
                            z3 = false;
                        } catch (Throwable th14) {
                            th10 = th14;
                            com.uc.crashsdk.a.a.d("DEBUG", "get java log name failed: " + th10);
                            a(th10);
                            com.uc.crashsdk.a.a.d("DEBUG", "original exception is: " + th);
                            a(th);
                            str = null;
                            z3 = true;
                            if (!z17) {
                            }
                            boolean z18 = th instanceof OutOfMemoryError;
                            a(th, str, j2, z18);
                            com.uc.crashsdk.a.a.d("DEBUG", "generate java report finished");
                            String name = new File(str).getName();
                            String W2 = g.W();
                            file = new File(W2);
                            if (!file.exists()) {
                            }
                            String format = String.format(Locale.US, "%s%s.hprof", W2, name);
                            com.uc.crashsdk.a.a.d("DEBUG", "begin dump hprof: " + format);
                            long currentTimeMillis = System.currentTimeMillis();
                            try {
                                Debug.dumpHprofData(format);
                            } catch (Throwable th15) {
                                g.a(th15);
                            }
                            com.uc.crashsdk.a.a.d("DEBUG", "end dump hprof, use " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                            JNIBridge.nativeClientCloseConnection(j2);
                            if (z2) {
                            }
                            z9 = false;
                            if (!z9) {
                            }
                            z10 = false;
                            f.c(z10);
                            boolean i2 = g.i();
                            if (!com.uc.crashsdk.a.d.e()) {
                            }
                            com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i2);
                            uncaughtExceptionHandler3.uncaughtException(thread, th);
                            b.b(g.a());
                            U = true;
                            if (Process.myPid() <= 0) {
                            }
                        }
                    } catch (Throwable th16) {
                        th10 = th16;
                        z8 = false;
                        com.uc.crashsdk.a.a.d("DEBUG", "get java log name failed: " + th10);
                        a(th10);
                        com.uc.crashsdk.a.a.d("DEBUG", "original exception is: " + th);
                        a(th);
                        str = null;
                        z3 = true;
                        if (!z17) {
                        }
                        boolean z182 = th instanceof OutOfMemoryError;
                        a(th, str, j2, z182);
                        com.uc.crashsdk.a.a.d("DEBUG", "generate java report finished");
                        String name2 = new File(str).getName();
                        String W22 = g.W();
                        file = new File(W22);
                        if (!file.exists()) {
                        }
                        String format2 = String.format(Locale.US, "%s%s.hprof", W22, name2);
                        com.uc.crashsdk.a.a.d("DEBUG", "begin dump hprof: " + format2);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        Debug.dumpHprofData(format2);
                        com.uc.crashsdk.a.a.d("DEBUG", "end dump hprof, use " + (System.currentTimeMillis() - currentTimeMillis2) + " ms");
                        JNIBridge.nativeClientCloseConnection(j2);
                        if (z2) {
                        }
                        z9 = false;
                        if (!z9) {
                        }
                        z10 = false;
                        f.c(z10);
                        boolean i22 = g.i();
                        if (!com.uc.crashsdk.a.d.e()) {
                        }
                        com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i22);
                        uncaughtExceptionHandler3.uncaughtException(thread, th);
                        b.b(g.a());
                        U = true;
                        if (Process.myPid() <= 0) {
                        }
                    }
                    if (!z17) {
                        try {
                            g.a();
                            try {
                                if (b.B()) {
                                    f.a(3);
                                } else {
                                    f.a(4);
                                }
                            } catch (Throwable th17) {
                                g.a(th17);
                            }
                        } catch (Throwable th18) {
                            th2 = th18;
                            j2 = 0;
                            try {
                                com.uc.crashsdk.a.a.d("DEBUG", "exception occurs while java log: " + th2);
                                a(th2);
                                if (!z3) {
                                    com.uc.crashsdk.a.a.d("DEBUG", "original exception is: " + th);
                                    a(th);
                                }
                                if (j2 != 0 && b.d) {
                                    JNIBridge.nativeClientCloseConnection(j2);
                                }
                                if (z2) {
                                    try {
                                        if (g.r() && !z17) {
                                            try {
                                                a(true, false);
                                                z6 = true;
                                            } catch (Throwable th19) {
                                                th4 = th19;
                                                z6 = true;
                                                g.a(th4);
                                                if (!z6 || z17) {
                                                    z7 = false;
                                                } else {
                                                    z7 = false;
                                                    b(false);
                                                }
                                                f.c(z7);
                                                boolean i3 = g.i();
                                                if (!com.uc.crashsdk.a.d.e()) {
                                                    i3 = true;
                                                }
                                                com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i3);
                                                if (i3 && (uncaughtExceptionHandler2 = S) != null) {
                                                    uncaughtExceptionHandler2.uncaughtException(thread, th);
                                                }
                                                if (b.B() && !z17) {
                                                    b.b(g.a());
                                                }
                                                U = true;
                                                if (Process.myPid() <= 0) {
                                                    Process.killProcess(Process.myPid());
                                                    return;
                                                }
                                                return;
                                            }
                                            if (!z6) {
                                            }
                                            z7 = false;
                                            f.c(z7);
                                            boolean i32 = g.i();
                                            if (!com.uc.crashsdk.a.d.e()) {
                                            }
                                            com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i32);
                                            uncaughtExceptionHandler2.uncaughtException(thread, th);
                                            b.b(g.a());
                                            U = true;
                                            if (Process.myPid() <= 0) {
                                            }
                                        }
                                    } catch (Throwable th20) {
                                        th4 = th20;
                                        z6 = false;
                                        g.a(th4);
                                        if (!z6) {
                                        }
                                        z7 = false;
                                        f.c(z7);
                                        boolean i322 = g.i();
                                        if (!com.uc.crashsdk.a.d.e()) {
                                        }
                                        com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i322);
                                        uncaughtExceptionHandler2.uncaughtException(thread, th);
                                        b.b(g.a());
                                        U = true;
                                        if (Process.myPid() <= 0) {
                                        }
                                    }
                                }
                                z6 = false;
                                if (!z6) {
                                }
                                z7 = false;
                                try {
                                    f.c(z7);
                                } catch (Throwable th21) {
                                    g.a(th21);
                                }
                                try {
                                    boolean i3222 = g.i();
                                    if (!com.uc.crashsdk.a.d.e()) {
                                    }
                                    com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i3222);
                                    uncaughtExceptionHandler2.uncaughtException(thread, th);
                                    b.b(g.a());
                                } catch (Throwable th22) {
                                    g.a(th22);
                                }
                                U = true;
                                if (Process.myPid() <= 0) {
                                }
                            } catch (Throwable th23) {
                                g.a(th23);
                            }
                        }
                        try {
                            new File(b.b()).createNewFile();
                        } catch (Throwable th24) {
                            g.a(th24);
                        }
                        if (z8) {
                            com.uc.crashsdk.a.a.d("DEBUG", "omit java crash");
                            if (z2) {
                                try {
                                    if (g.r() && !z17) {
                                        try {
                                            a(true, false);
                                            z14 = true;
                                        } catch (Throwable th25) {
                                            th9 = th25;
                                            z14 = true;
                                            g.a(th9);
                                            b(false);
                                            f.c(false);
                                            boolean i4 = g.i();
                                            if (!com.uc.crashsdk.a.d.e()) {
                                            }
                                            com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i4);
                                            uncaughtExceptionHandler7.uncaughtException(thread, th);
                                            b.b(g.a());
                                            U = true;
                                            if (Process.myPid() <= 0) {
                                            }
                                        }
                                        if (!z14 && !z17) {
                                            b(false);
                                        }
                                        f.c(false);
                                        boolean i42 = g.i();
                                        if (!com.uc.crashsdk.a.d.e()) {
                                            i42 = true;
                                        }
                                        com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i42);
                                        if (i42 && (uncaughtExceptionHandler7 = S) != null) {
                                            uncaughtExceptionHandler7.uncaughtException(thread, th);
                                        }
                                        if (b.B() && !z17) {
                                            b.b(g.a());
                                        }
                                        U = true;
                                        if (Process.myPid() <= 0) {
                                            Process.killProcess(Process.myPid());
                                            return;
                                        }
                                        return;
                                    }
                                } catch (Throwable th26) {
                                    th9 = th26;
                                    z14 = false;
                                    g.a(th9);
                                    b(false);
                                    f.c(false);
                                    boolean i422 = g.i();
                                    if (!com.uc.crashsdk.a.d.e()) {
                                    }
                                    com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i422);
                                    uncaughtExceptionHandler7.uncaughtException(thread, th);
                                    b.b(g.a());
                                    U = true;
                                    if (Process.myPid() <= 0) {
                                    }
                                }
                            }
                            z14 = false;
                            b(false);
                            try {
                                f.c(false);
                            } catch (Throwable th27) {
                                g.a(th27);
                            }
                            try {
                                boolean i4222 = g.i();
                                if (!com.uc.crashsdk.a.d.e()) {
                                }
                                com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i4222);
                                uncaughtExceptionHandler7.uncaughtException(thread, th);
                                b.b(g.a());
                            } catch (Throwable th28) {
                                g.a(th28);
                            }
                            U = true;
                            if (Process.myPid() <= 0) {
                            }
                        } else if (!d("java")) {
                            com.uc.crashsdk.a.a.d("DEBUG", "java log sample miss");
                            if (z2) {
                                try {
                                    if (g.r() && !z17) {
                                        try {
                                            a(true, false);
                                            z13 = true;
                                        } catch (Throwable th29) {
                                            th8 = th29;
                                            z13 = true;
                                            g.a(th8);
                                            b(false);
                                            f.c(false);
                                            boolean i5 = g.i();
                                            if (!com.uc.crashsdk.a.d.e()) {
                                            }
                                            com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i5);
                                            uncaughtExceptionHandler6.uncaughtException(thread, th);
                                            b.b(g.a());
                                            U = true;
                                            if (Process.myPid() <= 0) {
                                            }
                                        }
                                        if (!z13 && !z17) {
                                            b(false);
                                        }
                                        f.c(false);
                                        boolean i52 = g.i();
                                        if (!com.uc.crashsdk.a.d.e()) {
                                            i52 = true;
                                        }
                                        com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i52);
                                        if (i52 && (uncaughtExceptionHandler6 = S) != null) {
                                            uncaughtExceptionHandler6.uncaughtException(thread, th);
                                        }
                                        if (b.B() && !z17) {
                                            b.b(g.a());
                                        }
                                        U = true;
                                        if (Process.myPid() <= 0) {
                                            Process.killProcess(Process.myPid());
                                            return;
                                        }
                                        return;
                                    }
                                } catch (Throwable th30) {
                                    th8 = th30;
                                    z13 = false;
                                    g.a(th8);
                                    b(false);
                                    f.c(false);
                                    boolean i522 = g.i();
                                    if (!com.uc.crashsdk.a.d.e()) {
                                    }
                                    com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i522);
                                    uncaughtExceptionHandler6.uncaughtException(thread, th);
                                    b.b(g.a());
                                    U = true;
                                    if (Process.myPid() <= 0) {
                                    }
                                }
                            }
                            z13 = false;
                            b(false);
                            try {
                                f.c(false);
                            } catch (Throwable th31) {
                                g.a(th31);
                            }
                            try {
                                boolean i5222 = g.i();
                                if (!com.uc.crashsdk.a.d.e()) {
                                }
                                com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i5222);
                                uncaughtExceptionHandler6.uncaughtException(thread, th);
                                b.b(g.a());
                            } catch (Throwable th32) {
                                g.a(th32);
                            }
                            U = true;
                            if (Process.myPid() <= 0) {
                            }
                        } else {
                            j2 = 0;
                        }
                    } else {
                        if (z8) {
                            str = "omit";
                            com.uc.crashsdk.a.a.d("DEBUG", "omit java crash");
                        }
                        j2 = b.d ? JNIBridge.nativeClientCreateConnection(str, "java", null, 0) : 0;
                        int i6 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
                        if (i6 == 0) {
                            try {
                                com.uc.crashsdk.a.a.d("DEBUG", "skip java crash:");
                                a(th);
                                if (i6 != 0 && b.d) {
                                    JNIBridge.nativeClientCloseConnection(j2);
                                }
                                if (z2) {
                                    try {
                                        if (g.r() && !z17) {
                                            try {
                                                a(true, false);
                                                z12 = true;
                                            } catch (Throwable th33) {
                                                th7 = th33;
                                                z12 = true;
                                                g.a(th7);
                                                b(false);
                                                f.c(false);
                                                boolean i7 = g.i();
                                                if (!com.uc.crashsdk.a.d.e()) {
                                                }
                                                com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i7);
                                                uncaughtExceptionHandler5.uncaughtException(thread, th);
                                                b.b(g.a());
                                                U = true;
                                                if (Process.myPid() <= 0) {
                                                }
                                            }
                                            if (!z12 && !z17) {
                                                b(false);
                                            }
                                            f.c(false);
                                            boolean i72 = g.i();
                                            if (!com.uc.crashsdk.a.d.e()) {
                                                i72 = true;
                                            }
                                            com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i72);
                                            if (i72 && (uncaughtExceptionHandler5 = S) != null) {
                                                uncaughtExceptionHandler5.uncaughtException(thread, th);
                                            }
                                            if (b.B() && !z17) {
                                                b.b(g.a());
                                            }
                                            U = true;
                                            if (Process.myPid() <= 0) {
                                                Process.killProcess(Process.myPid());
                                                return;
                                            }
                                            return;
                                        }
                                    } catch (Throwable th34) {
                                        th7 = th34;
                                        z12 = false;
                                        g.a(th7);
                                        b(false);
                                        f.c(false);
                                        boolean i722 = g.i();
                                        if (!com.uc.crashsdk.a.d.e()) {
                                        }
                                        com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i722);
                                        uncaughtExceptionHandler5.uncaughtException(thread, th);
                                        b.b(g.a());
                                        U = true;
                                        if (Process.myPid() <= 0) {
                                        }
                                    }
                                }
                                z12 = false;
                                b(false);
                                try {
                                    f.c(false);
                                } catch (Throwable th35) {
                                    g.a(th35);
                                }
                                try {
                                    boolean i7222 = g.i();
                                    if (!com.uc.crashsdk.a.d.e()) {
                                    }
                                    com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i7222);
                                    uncaughtExceptionHandler5.uncaughtException(thread, th);
                                    b.b(g.a());
                                } catch (Throwable th36) {
                                    g.a(th36);
                                }
                                U = true;
                                if (Process.myPid() <= 0) {
                                }
                            } catch (Throwable th37) {
                                th2 = th37;
                                com.uc.crashsdk.a.a.d("DEBUG", "exception occurs while java log: " + th2);
                                a(th2);
                                if (!z3) {
                                }
                                JNIBridge.nativeClientCloseConnection(j2);
                                if (z2) {
                                }
                                z6 = false;
                                if (!z6) {
                                }
                                z7 = false;
                                f.c(z7);
                                boolean i32222 = g.i();
                                if (!com.uc.crashsdk.a.d.e()) {
                                }
                                com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i32222);
                                uncaughtExceptionHandler2.uncaughtException(thread, th);
                                b.b(g.a());
                                U = true;
                                if (Process.myPid() <= 0) {
                                }
                            }
                        } else if (z8) {
                            if (i6 != 0 && b.d) {
                                JNIBridge.nativeClientCloseConnection(j2);
                            }
                            if (z2) {
                                try {
                                    if (g.r() && !z17) {
                                        try {
                                            a(true, false);
                                            z11 = true;
                                        } catch (Throwable th38) {
                                            th6 = th38;
                                            z11 = true;
                                            g.a(th6);
                                            b(false);
                                            f.c(false);
                                            boolean i8 = g.i();
                                            if (!com.uc.crashsdk.a.d.e()) {
                                            }
                                            com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i8);
                                            uncaughtExceptionHandler4.uncaughtException(thread, th);
                                            b.b(g.a());
                                            U = true;
                                            if (Process.myPid() <= 0) {
                                            }
                                        }
                                        if (!z11 && !z17) {
                                            b(false);
                                        }
                                        f.c(false);
                                        boolean i82 = g.i();
                                        if (!com.uc.crashsdk.a.d.e()) {
                                            i82 = true;
                                        }
                                        com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i82);
                                        if (i82 && (uncaughtExceptionHandler4 = S) != null) {
                                            uncaughtExceptionHandler4.uncaughtException(thread, th);
                                        }
                                        if (b.B() && !z17) {
                                            b.b(g.a());
                                        }
                                        U = true;
                                        if (Process.myPid() <= 0) {
                                            Process.killProcess(Process.myPid());
                                            return;
                                        }
                                        return;
                                    }
                                } catch (Throwable th39) {
                                    th6 = th39;
                                    z11 = false;
                                    g.a(th6);
                                    b(false);
                                    f.c(false);
                                    boolean i822 = g.i();
                                    if (!com.uc.crashsdk.a.d.e()) {
                                    }
                                    com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i822);
                                    uncaughtExceptionHandler4.uncaughtException(thread, th);
                                    b.b(g.a());
                                    U = true;
                                    if (Process.myPid() <= 0) {
                                    }
                                }
                            }
                            z11 = false;
                            b(false);
                            try {
                                f.c(false);
                            } catch (Throwable th40) {
                                g.a(th40);
                            }
                            try {
                                boolean i8222 = g.i();
                                if (!com.uc.crashsdk.a.d.e()) {
                                }
                                com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i8222);
                                uncaughtExceptionHandler4.uncaughtException(thread, th);
                                b.b(g.a());
                            } catch (Throwable th41) {
                                g.a(th41);
                            }
                            U = true;
                            if (Process.myPid() <= 0) {
                            }
                        }
                    }
                    boolean z1822 = th instanceof OutOfMemoryError;
                    a(th, str, j2, z1822);
                    com.uc.crashsdk.a.a.d("DEBUG", "generate java report finished");
                    if (!b.L() && z1822 && g.j()) {
                        String name22 = new File(str).getName();
                        String W222 = g.W();
                        file = new File(W222);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        String format22 = String.format(Locale.US, "%s%s.hprof", W222, name22);
                        com.uc.crashsdk.a.a.d("DEBUG", "begin dump hprof: " + format22);
                        long currentTimeMillis22 = System.currentTimeMillis();
                        Debug.dumpHprofData(format22);
                        com.uc.crashsdk.a.a.d("DEBUG", "end dump hprof, use " + (System.currentTimeMillis() - currentTimeMillis22) + " ms");
                    }
                    if (j2 != 0 && b.d) {
                        JNIBridge.nativeClientCloseConnection(j2);
                    }
                    if (z2) {
                        try {
                            if (g.r() && !z17) {
                                try {
                                    a(true, false);
                                    z9 = true;
                                } catch (Throwable th42) {
                                    th5 = th42;
                                    z9 = true;
                                    g.a(th5);
                                    if (!z9) {
                                    }
                                    z10 = false;
                                    f.c(z10);
                                    boolean i222 = g.i();
                                    if (!com.uc.crashsdk.a.d.e()) {
                                    }
                                    com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i222);
                                    uncaughtExceptionHandler3.uncaughtException(thread, th);
                                    b.b(g.a());
                                    U = true;
                                    if (Process.myPid() <= 0) {
                                    }
                                }
                                if (!z9 || z17) {
                                    z10 = false;
                                } else {
                                    z10 = false;
                                    b(false);
                                }
                                f.c(z10);
                                boolean i2222 = g.i();
                                if (!com.uc.crashsdk.a.d.e()) {
                                    i2222 = true;
                                }
                                com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i2222);
                                if (i2222 && (uncaughtExceptionHandler3 = S) != null) {
                                    uncaughtExceptionHandler3.uncaughtException(thread, th);
                                }
                                if (b.B() && !z17) {
                                    b.b(g.a());
                                }
                                U = true;
                                if (Process.myPid() <= 0) {
                                    Process.killProcess(Process.myPid());
                                    return;
                                }
                                return;
                            }
                        } catch (Throwable th43) {
                            th5 = th43;
                            z9 = false;
                            g.a(th5);
                            if (!z9) {
                            }
                            z10 = false;
                            f.c(z10);
                            boolean i22222 = g.i();
                            if (!com.uc.crashsdk.a.d.e()) {
                            }
                            com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i22222);
                            uncaughtExceptionHandler3.uncaughtException(thread, th);
                            b.b(g.a());
                            U = true;
                            if (Process.myPid() <= 0) {
                            }
                        }
                    }
                    z9 = false;
                    if (!z9) {
                    }
                    z10 = false;
                    try {
                        f.c(z10);
                    } catch (Throwable th44) {
                        g.a(th44);
                    }
                    try {
                        boolean i222222 = g.i();
                        if (!com.uc.crashsdk.a.d.e()) {
                        }
                        com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i222222);
                        uncaughtExceptionHandler3.uncaughtException(thread, th);
                        b.b(g.a());
                    } catch (Throwable th45) {
                        g.a(th45);
                    }
                    U = true;
                    if (Process.myPid() <= 0) {
                    }
                } else {
                    com.uc.crashsdk.a.a.c("DEBUG", com.uc.crashsdk.a.d.b());
                    if (z2) {
                        try {
                            if (g.r() && !z17) {
                                try {
                                    a(true, false);
                                    z15 = true;
                                } catch (Throwable th46) {
                                    th11 = th46;
                                    z15 = true;
                                    g.a(th11);
                                    b(false);
                                    f.c(false);
                                    boolean i9 = g.i();
                                    if (!com.uc.crashsdk.a.d.e()) {
                                    }
                                    com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i9);
                                    uncaughtExceptionHandler8.uncaughtException(thread, th);
                                    b.b(g.a());
                                    U = true;
                                    if (Process.myPid() <= 0) {
                                    }
                                }
                                if (!z15 && !z17) {
                                    b(false);
                                }
                                f.c(false);
                                boolean i92 = g.i();
                                if (!com.uc.crashsdk.a.d.e()) {
                                    i92 = true;
                                }
                                com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i92);
                                if (i92 && (uncaughtExceptionHandler8 = S) != null) {
                                    uncaughtExceptionHandler8.uncaughtException(thread, th);
                                }
                                if (b.B() && !z17) {
                                    b.b(g.a());
                                }
                                U = true;
                                if (Process.myPid() <= 0) {
                                    Process.killProcess(Process.myPid());
                                    return;
                                }
                                return;
                            }
                        } catch (Throwable th47) {
                            th11 = th47;
                            z15 = false;
                            g.a(th11);
                            b(false);
                            f.c(false);
                            boolean i922 = g.i();
                            if (!com.uc.crashsdk.a.d.e()) {
                            }
                            com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i922);
                            uncaughtExceptionHandler8.uncaughtException(thread, th);
                            b.b(g.a());
                            U = true;
                            if (Process.myPid() <= 0) {
                            }
                        }
                    }
                    z15 = false;
                    b(false);
                    try {
                        f.c(false);
                    } catch (Throwable th48) {
                        g.a(th48);
                    }
                    try {
                        boolean i9222 = g.i();
                        if (!com.uc.crashsdk.a.d.e()) {
                        }
                        com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i9222);
                        uncaughtExceptionHandler8.uncaughtException(thread, th);
                        b.b(g.a());
                    } catch (Throwable th49) {
                        g.a(th49);
                    }
                    U = true;
                    if (Process.myPid() <= 0) {
                    }
                }
            } else {
                com.uc.crashsdk.a.a.d("DEBUG", "another thread is generating java report!");
                com.uc.crashsdk.a.a.d("DEBUG", "current thread exception is:");
                a(th);
                int i10 = 0;
                while (!U) {
                    try {
                        Thread.sleep(1000);
                    } catch (Throwable th50) {
                        g.a(th50);
                    }
                    i10++;
                    if (i10 >= 4) {
                        break;
                    }
                }
                Process.killProcess(Process.myPid());
                if (z2) {
                    try {
                        if (g.r() && !z17) {
                            try {
                                a(true, false);
                                z16 = true;
                            } catch (Throwable th51) {
                                th12 = th51;
                                z16 = true;
                                g.a(th12);
                                b(false);
                                f.c(false);
                                boolean i11 = g.i();
                                if (!com.uc.crashsdk.a.d.e()) {
                                }
                                com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i11);
                                uncaughtExceptionHandler9.uncaughtException(thread, th);
                                b.b(g.a());
                                U = true;
                                if (Process.myPid() <= 0) {
                                }
                            }
                            if (!z16 && !z17) {
                                b(false);
                            }
                            f.c(false);
                            boolean i112 = g.i();
                            if (!com.uc.crashsdk.a.d.e()) {
                                i112 = true;
                            }
                            com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i112);
                            if (i112 && (uncaughtExceptionHandler9 = S) != null) {
                                uncaughtExceptionHandler9.uncaughtException(thread, th);
                            }
                            if (b.B() && !z17) {
                                b.b(g.a());
                            }
                            U = true;
                            if (Process.myPid() <= 0) {
                                Process.killProcess(Process.myPid());
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th52) {
                        th12 = th52;
                        z16 = false;
                        g.a(th12);
                        b(false);
                        f.c(false);
                        boolean i1122 = g.i();
                        if (!com.uc.crashsdk.a.d.e()) {
                        }
                        com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i1122);
                        uncaughtExceptionHandler9.uncaughtException(thread, th);
                        b.b(g.a());
                        U = true;
                        if (Process.myPid() <= 0) {
                        }
                    }
                }
                z16 = false;
                b(false);
                try {
                    f.c(false);
                } catch (Throwable th53) {
                    g.a(th53);
                }
                try {
                    boolean i11222 = g.i();
                    if (!com.uc.crashsdk.a.d.e()) {
                    }
                    com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i11222);
                    uncaughtExceptionHandler9.uncaughtException(thread, th);
                    b.b(g.a());
                } catch (Throwable th54) {
                    g.a(th54);
                }
                U = true;
                if (Process.myPid() <= 0) {
                }
            }
        } catch (Throwable th55) {
            th2 = th55;
            z3 = false;
            j2 = 0;
            com.uc.crashsdk.a.a.d("DEBUG", "exception occurs while java log: " + th2);
            a(th2);
            if (!z3) {
            }
            JNIBridge.nativeClientCloseConnection(j2);
            if (z2) {
            }
            z6 = false;
            if (!z6) {
            }
            z7 = false;
            f.c(z7);
            boolean i322222 = g.i();
            if (!com.uc.crashsdk.a.d.e()) {
            }
            com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i322222);
            uncaughtExceptionHandler2.uncaughtException(thread, th);
            b.b(g.a());
            U = true;
            if (Process.myPid() <= 0) {
            }
        }
        U = true;
        if (Process.myPid() > 0) {
            Process.killProcess(Process.myPid());
        }
        throw th;
        boolean i12 = g.i();
        if (!com.uc.crashsdk.a.d.e()) {
            i12 = true;
        }
        com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + i12);
        if (i12 && (uncaughtExceptionHandler = S) != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
        if (b.B() && !z17) {
            b.b(g.a());
        }
        U = true;
        if (Process.myPid() > 0) {
        }
        throw th;
    }

    private static void a(Throwable th) {
        try {
            com.uc.crashsdk.a.a.d("DEBUG", a(th.getStackTrace(), (String) null).toString());
        } catch (Throwable unused) {
        }
    }

    private static void a(Calendar calendar) {
        if (g.Q()) {
            long timeInMillis = calendar.getTimeInMillis();
            calendar.add(5, 1);
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            long timeInMillis2 = calendar.getTimeInMillis();
            long j2 = timeInMillis2 - timeInMillis;
            long j3 = DateUtils.MILLIS_PER_HOUR;
            if (j2 <= DateUtils.MILLIS_PER_HOUR) {
                j3 = 1000 + j2;
            }
            f.a(0, new com.uc.crashsdk.a.e(415, new Object[]{Long.valueOf(timeInMillis2)}), j3);
        }
    }

    static StringBuilder a(StackTraceElement[] stackTraceElementArr, String str) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        if (stackTraceElementArr != null && stackTraceElementArr.length > 0) {
            boolean z2 = str == null;
            int i3 = 0;
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                i3++;
                sb.append("  at ");
                sb.append(stackTraceElement.toString());
                sb.append(StringUtils.LF);
                if (!z2 && stackTraceElement.getMethodName().contains(str)) {
                    sb.delete(0, sb.length());
                    z2 = true;
                    i3 = 0;
                }
            }
            i2 = i3;
        }
        if (i2 == 0) {
            sb.append("  (no java stack)\n");
        }
        return sb;
    }

    public static boolean a(ParcelFileDescriptor parcelFileDescriptor) {
        if (ad) {
            com.uc.crashsdk.a.a.d("crashsdk", "Can not call setHostFd and getHostFd in the same process!");
            return false;
        } else if (!b.d) {
            com.uc.crashsdk.a.a.d("crashsdk", "Crash so is not loaded!");
            return false;
        } else {
            if (ac != null) {
                com.uc.crashsdk.a.a.c("crashsdk", "Has already set host fd!");
            }
            ac = parcelFileDescriptor;
            int fd = parcelFileDescriptor.getFd();
            int nativeCmd = (int) JNIBridge.nativeCmd(13, (long) fd, null, null);
            ae = nativeCmd != -1;
            if (fd == -1 || nativeCmd != -1) {
                return true;
            }
            return false;
        }
    }
}
