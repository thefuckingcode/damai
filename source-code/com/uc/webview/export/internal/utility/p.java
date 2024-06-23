package com.uc.webview.export.internal.utility;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.system.Os;
import android.text.TextUtils;
import android.util.Log;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.ta.utdid2.device.UTDevice;
import com.taobao.accs.common.Constants;
import com.taobao.orange.OConstant;
import com.tencent.open.SocialConstants;
import com.uc.webview.export.Build;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.UCElapseTime;
import com.uc.webview.export.cyclone.UCKnownException;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.setup.UCMRunningInfo;
import com.uc.webview.export.internal.setup.UCSetupException;
import com.uc.webview.export.internal.setup.bt;
import com.youku.arch.solid.monitor.SolidMonitor;
import com.youku.playerservice.axp.utils.Utils;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.StringUtils;
import tb.gl1;
import tv.cjump.jni.DeviceUtils;

/* compiled from: Taobao */
public class p {
    public static final String[] a = {"armeabi-v7a", "arm64-v8a", "armeabi", DeviceUtils.ABI_X86};
    public static String b = "3032";
    private static a c;
    private static a d;
    private static final Map<String, String> e = new q();
    private static volatile Method f = null;
    private static final String[] g = {"3032"};
    private static boolean h = false;
    private static boolean i = false;
    private static String j;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public enum a {
        NOT_INITED,
        ENABLE,
        DISABLE
    }

    /* compiled from: Taobao */
    public static class b {
        private static String a;

        public static String a(Context context) {
            String str;
            if (!p.a(a)) {
                return a;
            }
            if (!(SDKFactory.c == null || context == null)) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        str = (String) ReflectionUtil.invoke((Class<?>) UTDevice.class, "getUtdid", new Class[]{Context.class}, new Object[]{context});
                    } catch (Throwable unused) {
                        str = (String) ReflectionUtil.invoke(Class.forName(OConstant.REFLECT_UTDID, true, SDKFactory.c), "getUtdid", new Class[]{Context.class}, new Object[]{context});
                    }
                    Log.d(Utils.TAG, "getUtdidBySdk time: " + (System.currentTimeMillis() - currentTimeMillis) + " milliseconds");
                    StringBuilder sb = new StringBuilder("getUtdidBySdk utdid: ");
                    sb.append(str);
                    Log.d(Utils.TAG, sb.toString());
                    if (!p.a(str)) {
                        a = str;
                    }
                    return str;
                } catch (Throwable th) {
                    Log.d(Utils.TAG, "getUtdidBySdk cd exception : " + th.getMessage());
                }
            }
            return null;
        }
    }

    static {
        a aVar = a.NOT_INITED;
        c = aVar;
        d = aVar;
    }

    public static boolean a(Object obj) {
        return obj == null;
    }

    public static boolean a(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean b(String str) {
        return !a(str) && "true".equalsIgnoreCase(str);
    }

    public static int c() {
        Integer num = (Integer) i.a().a(UCCore.OPTION_CONNECTION_CONNECT_TIMEOUT);
        if (num != null) {
            return num.intValue();
        }
        return 5000;
    }

    public static int d() {
        Integer num = (Integer) i.a().a(UCCore.OPTION_CONNECTION_READ_TIMEOUT);
        if (num != null) {
            return num.intValue();
        }
        return 5000;
    }

    public static String e() {
        for (Map.Entry<String, String> entry : e.entrySet()) {
            String i2 = i(entry.getKey());
            if (i2 != null && i2.length() > 0) {
                return entry.getValue();
            }
        }
        return "UNKNOWN";
    }

    public static boolean f() {
        a aVar = c;
        a aVar2 = a.NOT_INITED;
        if (aVar == aVar2) {
            synchronized (c) {
                if (c == aVar2) {
                    try {
                        Class.forName("com.uc.webkit.sdk.CoreFactoryImpl");
                        c = a.ENABLE;
                    } catch (ClassNotFoundException unused) {
                        c = a.DISABLE;
                    }
                }
            }
        }
        return c == a.ENABLE;
    }

    public static String g() {
        return "/unexists/" + System.currentTimeMillis();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v6, resolved type: java.io.BufferedReader */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0035 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003a A[DONT_GENERATE] */
    private static String h(String str) {
        FileReader fileReader;
        FileReader fileReader2;
        Throwable th;
        BufferedReader bufferedReader;
        try {
            fileReader2 = new FileReader(str);
            try {
                bufferedReader = new BufferedReader(fileReader2);
            } catch (Throwable th2) {
                th = th2;
                fileReader = null;
                try {
                    th.printStackTrace();
                    return "";
                } finally {
                    if (fileReader2 != null) {
                        UCCyclone.close(fileReader2);
                    }
                    if (fileReader != null) {
                        UCCyclone.close(fileReader);
                    }
                }
            }
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                    } else {
                        String sb2 = sb.toString();
                        UCCyclone.close(fileReader2);
                        UCCyclone.close(bufferedReader);
                        return sb2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                fileReader = bufferedReader;
                th.printStackTrace();
                return "";
            }
        } catch (Throwable th4) {
            fileReader2 = null;
            th = th4;
            fileReader = fileReader2;
            th.printStackTrace();
            return "";
        }
    }

    private static String i(String str) {
        try {
            if (f == null) {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod(gl1.TYPE_OPEN_URL_METHOD_GET, String.class);
                f = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            Object invoke = f.invoke(null, str);
            if (invoke == null) {
                return null;
            }
            return invoke.toString();
        } catch (Throwable th) {
            Log.i(Utils.TAG, "getSystemProperty " + th.getMessage());
            return null;
        }
    }

    private static File j(String str) throws UCSetupException {
        File file = new File(str);
        if (file.exists()) {
            return file;
        }
        throw new UCSetupException(1002, String.format("Directory [%s] not exists.", file.getAbsolutePath()));
    }

    public static boolean a(Boolean bool) {
        return bool != null && bool.booleanValue();
    }

    public static boolean b(Boolean bool) {
        return bool == null || !bool.booleanValue();
    }

    public static File g(String str) throws UCSetupException {
        File[] listFiles;
        int i2 = Build.PACK_TYPE;
        if ((i2 == 34 || i2 == 43) && (listFiles = j(str).listFiles(new s())) != null && listFiles.length > 0) {
            return listFiles[0];
        }
        return null;
    }

    public static String a() {
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new r());
            Log.d(Utils.TAG, "CPU Count: " + listFiles.length);
            return String.valueOf(listFiles.length);
        } catch (Throwable th) {
            Log.d(Utils.TAG, "CPU Count: Failed.");
            th.printStackTrace();
            return "1";
        }
    }

    public static boolean b(Object obj) {
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        if (obj instanceof Integer) {
            return 1 == ((Integer) obj).intValue();
        }
        if (!(obj instanceof String)) {
            return false;
        }
        String lowerCase = ((String) obj).trim().toLowerCase(Locale.getDefault());
        return "1".equals(lowerCase) || BQCCameraParam.VALUE_YES.equals(lowerCase) || "true".equals(lowerCase);
    }

    public static int c(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static long d(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static boolean c(Context context, String str, String str2) {
        File a2 = a(context, "decompresses2");
        if (!str.startsWith(a2.getAbsolutePath())) {
            return false;
        }
        File file = new File(str2);
        return !str.startsWith(new File(new File(a2, UCCyclone.getSourceHash(file.getAbsolutePath())), UCCyclone.getSourceHash(file.length(), file.lastModified())).getAbsolutePath());
    }

    private static bt d(Context context, String str, String str2) throws UCSetupException {
        String str3;
        loop0:
        while (true) {
            File j2 = j(str);
            try {
                String absolutePath = UCCyclone.expectFile(j2, "libcore_jar_kj_uc.so").getAbsolutePath();
                String str4 = null;
                try {
                    str3 = UCCyclone.expectFile(j2, "libsdk_shell_jar_kj_uc.so").getAbsolutePath();
                } catch (Throwable unused) {
                    str3 = null;
                }
                try {
                    str4 = UCCyclone.expectFile(j2, "libbrowser_if_jar_kj_uc.so").getAbsolutePath();
                } catch (Throwable unused2) {
                }
                return new UCMPackageInfo(context, SocialConstants.PARAM_SPECIFIED, j2.getAbsolutePath(), j2.getAbsolutePath(), j2.getAbsolutePath(), str3, str4, absolutePath, str2, true, false);
            } catch (UCKnownException e2) {
                File[] listFiles = j2.listFiles();
                if (listFiles == null) {
                    break;
                }
                String[] strArr = a;
                for (String str5 : strArr) {
                    for (File file : listFiles) {
                        if (str5.equals(file.getName()) && file.isDirectory()) {
                            str = file.getAbsolutePath();
                        }
                    }
                }
                break loop0;
                throw e2;
            }
        }
        throw e2;
    }

    public static String e(String str) {
        return String.valueOf(str.hashCode()).replace('-', '_');
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002a */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0041 A[SYNTHETIC, Splitter:B:19:0x0041] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0048 A[SYNTHETIC, Splitter:B:23:0x0048] */
    public static void a(File file, File file2) throws IOException {
        FileChannel fileChannel;
        Throwable th;
        FileChannel fileChannel2 = null;
        try {
            FileChannel channel = new FileInputStream(file).getChannel();
            try {
                fileChannel2 = new FileOutputStream(file2).getChannel();
                if (fileChannel2.transferFrom(channel, 0, channel.size()) == file.length()) {
                    channel.close();
                    try {
                        fileChannel2.close();
                    } catch (Throwable unused) {
                    }
                } else {
                    file2.delete();
                    throw new RuntimeException("Size mismatch.");
                }
            } catch (Throwable th2) {
                th = th2;
                fileChannel = fileChannel2;
                fileChannel2 = channel;
                if (fileChannel2 != null) {
                    try {
                        fileChannel2.close();
                    } catch (Throwable unused2) {
                    }
                }
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (Throwable unused3) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileChannel = null;
            if (fileChannel2 != null) {
            }
            if (fileChannel != null) {
            }
            throw th;
        }
    }

    public static String f(String str) {
        if (a(str)) {
            return str;
        }
        File file = new File(str);
        return file.exists() ? file.getAbsolutePath() : str;
    }

    public static boolean b(File file, File file2) {
        try {
            if (!file.getCanonicalPath().startsWith(file2.getCanonicalPath())) {
                return false;
            }
            while (file.getCanonicalPath().contains(file2.getCanonicalPath()) && !file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                if (!g.b(file)) {
                    return false;
                }
                file = file.getParentFile();
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String c(Context context) {
        String str = j;
        if (str != null) {
            return str;
        }
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            j = (String) cls.getMethod("getProcessName", new Class[0]).invoke(cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]), new Object[0]);
        } catch (Exception unused) {
            int myPid = Process.myPid();
            Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (next.pid == myPid) {
                    j = next.processName;
                    break;
                }
            }
        }
        if (TextUtils.isEmpty(j)) {
            return "";
        }
        return j;
    }

    public static synchronized List<bt> b(Context context, ConcurrentHashMap<String, Object> concurrentHashMap) {
        synchronized (p.class) {
            List<bt> arrayList = new ArrayList<>();
            com.uc.webview.export.internal.uc.startup.b.a(285);
            String str = (String) concurrentHashMap.get(UCCore.OPTION_DEX_FILE_PATH);
            Log.i(Utils.TAG, " listFromOptions dexPath:" + str);
            if (!a(str)) {
                arrayList = a(context, new File(str), arrayList);
            }
            String str2 = (String) concurrentHashMap.get(UCCore.OPTION_SET_ODEX_ROOT_PATH);
            if (str2 == null) {
                str2 = a(context, "odexs").getAbsolutePath();
            }
            if (arrayList.size() == 0) {
                bt a2 = a(context, (String) concurrentHashMap.get(UCCore.OPTION_DEX_FILE_PATH), (String) concurrentHashMap.get(UCCore.OPTION_SO_FILE_PATH), (String) concurrentHashMap.get(UCCore.OPTION_RES_FILE_PATH), str2);
                if (a2 != null) {
                    arrayList.add(a2);
                }
                if (f()) {
                    com.uc.webview.export.internal.uc.startup.b.a(286);
                    return arrayList;
                }
            }
            String str3 = (String) concurrentHashMap.get(UCCore.OPTION_UCM_KRL_DIR);
            if (!a(str3)) {
                arrayList = a(context, new File(str3), arrayList);
            }
            String str4 = (String) concurrentHashMap.get(UCCore.OPTION_UCM_LIB_DIR);
            if (!a(str4)) {
                arrayList.add(d(context, str4, str2));
            }
            if (arrayList != null && arrayList.size() > 1) {
                Collections.sort(arrayList, new u());
            }
            com.uc.webview.export.internal.uc.startup.b.a(286);
            return arrayList;
        }
    }

    public static boolean h() {
        Object globalOption = UCCore.getGlobalOption(UCCore.GLOBAL_OPTION_IS_BROWSER_RUNTIME);
        if (globalOption != null) {
            return ((Boolean) globalOption).booleanValue();
        }
        a aVar = d;
        a aVar2 = a.NOT_INITED;
        if (aVar == aVar2) {
            synchronized (d) {
                if (d == aVar2) {
                    try {
                        Class.forName("com.uc.webview.browser.BrowserCore");
                        d = a.ENABLE;
                    } catch (ClassNotFoundException unused) {
                        d = a.DISABLE;
                    }
                }
            }
        }
        return d == a.ENABLE;
    }

    public static boolean d(Context context) {
        return !c(context).contains(":");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r10.delete();
        r9 = new java.io.File(r10.getAbsolutePath() + ".tmp");
        r9.createNewFile();
        a(r8, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0109, code lost:
        if (r9.renameTo(r10) != false) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x010b, code lost:
        r10.setLastModified(r8.lastModified());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x011c, code lost:
        if (r10.lastModified() != r8.lastModified()) goto L_0x011e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x011e, code lost:
        r10.renameTo(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0121, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0122, code lost:
        return r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0123, code lost:
        r9.delete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x013c, code lost:
        throw new com.uc.webview.export.internal.setup.UCSetupException(1005, java.lang.String.format("Rename [%s] to [%s] failed.", r9, r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x013d, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0145, code lost:
        throw new com.uc.webview.export.internal.setup.UCSetupException(1007, r8);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x00e2 */
    public static File a(File file, File file2, File file3) {
        if (file2.exists()) {
            return file2;
        }
        if (file3.exists() && file.length() == file3.length() && file.lastModified() == file3.lastModified()) {
            return file3;
        }
        String parent = file3.getParent();
        File file4 = new File(parent, "bak_" + file3.getName());
        if (file4.exists()) {
            if (file.length() == file4.length()) {
                file4.setLastModified(file.lastModified());
                if (file4.lastModified() != file.lastModified()) {
                    return file4;
                }
            }
            file4.delete();
        }
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                Os.symlink(file.getAbsolutePath(), file2.getAbsolutePath());
                return file2;
            } catch (Exception unused) {
            }
        }
        Process exec = Runtime.getRuntime().exec("ln -s " + file.getAbsolutePath() + " " + file2.getAbsolutePath());
        UCElapseTime uCElapseTime = new UCElapseTime();
        while (true) {
            if (uCElapseTime.getMilis() >= 500) {
                break;
            }
            try {
                if (exec.exitValue() != 0) {
                    throw new Throwable();
                }
            } catch (IllegalThreadStateException unused2) {
            }
        }
        if (file.getName().equals("libar_pak_kr_uc.so")) {
            Log.i("ThinEnvTask", "linkOrCopyFile Time:" + uCElapseTime.getMilis());
        }
        return file2;
    }

    public static int c(Context context, String str) {
        File a2 = a(context, Constants.KEY_FLAGS);
        String a3 = w.a(str);
        Log.d(Utils.TAG, "checkQuickVerifiedResult filePath:" + str + ", prefix:" + a3);
        if (new File(a2, a3 + "_n").exists()) {
            return 2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(a3);
        sb.append("_y");
        return new File(a2, sb.toString()).exists() ? 1 : 0;
    }

    public static String b(Context context, String str) {
        return (context == null || a(str) || str.indexOf(context.getPackageName()) <= 0) ? str : str.substring(str.indexOf(context.getPackageName()), str.length());
    }

    public static File b(File file, String str) throws UCSetupException {
        return UCCyclone.expectCreateDirFile(new File(file, str));
    }

    public static void b(Context context) {
        File[] listFiles = context.getCacheDir().listFiles(new v());
        if (listFiles != null && listFiles.length > 0) {
            for (File file : listFiles) {
                UCCyclone.recursiveDelete(file, false, null);
            }
        }
    }

    private static File[] a(File[] fileArr, File[] fileArr2, File[] fileArr3) {
        boolean z;
        File[] fileArr4 = new File[fileArr.length];
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                for (int i2 = 0; i2 < fileArr.length; i2++) {
                    if (fileArr2[i2].exists()) {
                        fileArr4[i2] = fileArr2[i2];
                    } else {
                        Os.symlink(fileArr[i2].getAbsolutePath(), fileArr2[i2].getAbsolutePath());
                        fileArr4[i2] = fileArr2[i2];
                    }
                }
                return fileArr4;
            }
            UCElapseTime uCElapseTime = new UCElapseTime();
            Process process = null;
            try {
                Process exec = Runtime.getRuntime().exec("sh");
                DataOutputStream dataOutputStream = new DataOutputStream(exec.getOutputStream());
                new BufferedReader(new InputStreamReader(exec.getInputStream()));
                for (int i3 = 0; i3 < fileArr.length; i3++) {
                    if (fileArr2[i3].exists()) {
                        fileArr4[i3] = fileArr2[i3];
                    } else {
                        dataOutputStream.writeBytes(String.format("ln -s %s %s", fileArr[i3].getAbsolutePath(), fileArr2[i3].getAbsolutePath()));
                        dataOutputStream.writeBytes(StringUtils.LF);
                        dataOutputStream.flush();
                        fileArr4[i3] = fileArr2[i3];
                    }
                }
                dataOutputStream.writeBytes("exit\n");
                dataOutputStream.flush();
                exec.waitFor();
                dataOutputStream.close();
                exec.destroy();
                z = true;
            } catch (Exception e2) {
                Log.e(Utils.TAG, "symlink exception.", e2);
                if (0 != 0) {
                    process.destroy();
                }
                z = false;
            } catch (Throwable th) {
                if (0 != 0) {
                    process.destroy();
                }
                throw th;
            }
            if (z) {
                Log.e(Utils.TAG, "link success! Time:" + uCElapseTime.getMilis());
                return fileArr4;
            }
            throw new Throwable();
        } catch (Throwable th2) {
            throw new UCSetupException(1007, th2);
        }
    }

    public static String b(Context context, String str, String str2) {
        if (a(str2)) {
            return null;
        }
        File file = new File(str2);
        String name = file.getName();
        if (!name.startsWith(SolidMonitor.CHECK_TYPE_LIB) || !name.endsWith("_jar_kj_uc.so")) {
            return str2;
        }
        String str3 = name.substring(3, name.length() - 13) + ".jar";
        String e2 = e(str);
        return a(file, new File(b(a(context, "kjlinks"), e2), str3), new File(b(a(context, "kjcopies"), e2), str3)).getAbsolutePath();
    }

    private static String b(File file) {
        return file.exists() ? file.getAbsolutePath() : "";
    }

    public static String b() {
        return String.valueOf(c(h("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq").trim()));
    }

    public static Boolean a(ConcurrentHashMap<String, Object> concurrentHashMap, String str) {
        Object obj = concurrentHashMap.get(str);
        if (obj == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            return Boolean.valueOf(Boolean.parseBoolean((String) obj));
        }
        throw new UCSetupException(3012, String.format("\"true\" or \"false\" or boolean expected with key:[%s], now is [%s]", str, obj));
    }

    public static void a(Map<String, String> map) {
        try {
            Log.d(Utils.TAG, "addHeaderInfoToCrashSdk headerInfos: " + map);
            Object invoke = ReflectionUtil.invoke("com.uc.crashsdk.export.CrashApi", "getInstance");
            if (invoke != null && map.size() > 0) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    ReflectionUtil.invoke(invoke, "addHeaderInfo", new Class[]{String.class, String.class}, new Object[]{entry.getKey(), entry.getValue()});
                }
            }
        } catch (Throwable th) {
            Log.i(Utils.TAG, "addHeaderInfoToCrashSdk " + th.getMessage());
        }
    }

    public static int a(boolean z) {
        if (f()) {
            return 1;
        }
        return z ? 4 : 2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: java.io.ByteArrayOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Context context) {
        Throwable th;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        FileOutputStream fileOutputStream3;
        FileOutputStream fileOutputStream4;
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream = null;
        try {
            File file = new File(a(context, Constants.KEY_FLAGS), "fpathhash");
            String sourceHash = UCCyclone.getSourceHash(file.getAbsolutePath());
            if (!file.exists() || file.length() <= 0) {
                fileOutputStream = new FileOutputStream(file);
                try {
                    fileOutputStream.write(sourceHash.getBytes());
                    fileOutputStream4 = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = null;
                    try {
                        th.printStackTrace();
                        fileOutputStream4 = fileOutputStream2;
                        UCCyclone.close(fileInputStream);
                        UCCyclone.close(fileOutputStream);
                        UCCyclone.close(fileOutputStream4);
                    } catch (Throwable th3) {
                        UCCyclone.close(fileInputStream);
                        UCCyclone.close(fileOutputStream);
                        UCCyclone.close(fileOutputStream2);
                        throw th3;
                    }
                }
                UCCyclone.close(fileInputStream);
                UCCyclone.close(fileOutputStream);
                UCCyclone.close(fileOutputStream4);
            }
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream3 = null;
                fileInputStream = fileInputStream2;
                fileOutputStream = fileOutputStream3;
                fileOutputStream2 = fileOutputStream3;
                th.printStackTrace();
                fileOutputStream4 = fileOutputStream2;
                UCCyclone.close(fileInputStream);
                UCCyclone.close(fileOutputStream);
                UCCyclone.close(fileOutputStream4);
            }
            try {
                byte[] bArr = new byte[32];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                String str = new String(byteArrayOutputStream.toByteArray());
                Log.d(Utils.TAG, "curHash:" + sourceHash + ", preHash:" + str);
                if (!sourceHash.equals(str)) {
                    IWaStat.WaStat.stat(IWaStat.KEY_MULTI_PROCESS_FILE_PATH_COMPATIBILITY);
                }
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                fileOutputStream4 = byteArrayOutputStream;
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                fileOutputStream2 = byteArrayOutputStream;
                th.printStackTrace();
                fileOutputStream4 = fileOutputStream2;
                UCCyclone.close(fileInputStream);
                UCCyclone.close(fileOutputStream);
                UCCyclone.close(fileOutputStream4);
            }
            UCCyclone.close(fileInputStream);
            UCCyclone.close(fileOutputStream);
            UCCyclone.close(fileOutputStream4);
        } catch (Throwable th6) {
            th = th6;
            fileOutputStream3 = null;
            fileOutputStream = fileOutputStream3;
            fileOutputStream2 = fileOutputStream3;
            th.printStackTrace();
            fileOutputStream4 = fileOutputStream2;
            UCCyclone.close(fileInputStream);
            UCCyclone.close(fileOutputStream);
            UCCyclone.close(fileOutputStream4);
        }
    }

    public static boolean a(UCMRunningInfo uCMRunningInfo) {
        if (uCMRunningInfo != null) {
            return uCMRunningInfo.coreType == 2 && i.a().b(UCCore.OPTION_MULTI_CORE_TYPE);
        }
        return true;
    }

    public static String a(File file, String str) {
        return a(file, str, true);
    }

    public static String a(File file, String str, boolean z) {
        File[] listFiles = file.listFiles();
        if (!(listFiles == null || listFiles.length == 0)) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    if (z) {
                        String a2 = a(file2, str, true);
                        if (!a(a2)) {
                            return a2;
                        }
                    } else {
                        continue;
                    }
                }
                if (file2.getName().contains(str)) {
                    return file2.getAbsolutePath();
                }
            }
        }
        return null;
    }

    public static synchronized List<bt> a(Context context, ConcurrentHashMap<String, Object> concurrentHashMap) {
        List<bt> arrayList;
        bt a2;
        synchronized (p.class) {
            arrayList = new ArrayList<>();
            com.uc.webview.export.internal.uc.startup.b.a(283);
            if (!a((String) concurrentHashMap.get(UCCore.OPTION_SO_FILE_PATH)) && (a2 = a(context, null, (String) concurrentHashMap.get(UCCore.OPTION_SO_FILE_PATH), (String) concurrentHashMap.get(UCCore.OPTION_RES_FILE_PATH), null)) != null) {
                arrayList.add(a2);
            }
            String str = (String) concurrentHashMap.get(UCCore.OPTION_UCM_KRL_DIR);
            if (!a(str)) {
                arrayList = a(context, new File(str), arrayList);
            }
            com.uc.webview.export.internal.uc.startup.b.a(284);
        }
        return arrayList;
    }

    public static File a(Context context, String str) throws UCSetupException {
        File dir = context.getDir("ucmsdk", 0);
        if (str == null) {
            return dir;
        }
        return UCCyclone.expectCreateDirFile(new File(dir, str));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x003d, code lost:
        if (r2 != null) goto L_0x0041;
     */
    public static void a(Context context, File file, File file2) throws UCSetupException {
        boolean z = true;
        File file3 = null;
        if (!file.isFile()) {
            if (file.isDirectory()) {
                File expectCreateDirFile = UCCyclone.expectCreateDirFile(new File(UCCyclone.expectCreateDirFile(new File(a(context, Constants.KEY_FLAGS), "setup_delete")), UCCyclone.getSourceHash(file.getAbsolutePath())));
                if (expectCreateDirFile.list().length < 12) {
                    file3 = expectCreateDirFile;
                }
            }
            z = false;
        }
        if (z) {
            UCCyclone.recursiveDelete(file, false, file2);
            if (!file.exists() && file3 != null) {
                try {
                    if (!new File(file3, String.valueOf(System.currentTimeMillis())).createNewFile()) {
                        throw new Exception("createNewFile return false");
                    }
                } catch (Throwable th) {
                    throw new UCKnownException(1006, th);
                }
            }
        }
    }

    public static boolean a(ConcurrentHashMap<String, Object> concurrentHashMap) {
        Boolean bool;
        a aVar;
        if (c != a.NOT_INITED || concurrentHashMap == null || (bool = (Boolean) concurrentHashMap.get(UCCore.OPTION_THICK_INTEGRATION)) == null) {
            return f();
        }
        boolean a2 = a(bool);
        synchronized (c) {
            aVar = a2 ? a.ENABLE : a.DISABLE;
            c = aVar;
        }
        return aVar == a.ENABLE;
    }

    public static String a(Context context, String str, String str2) {
        File j2;
        String[] list;
        if (a(str2) || (list = (j2 = j(str2)).list(new t())) == null || list.length == 0) {
            return null;
        }
        String e2 = e(str);
        File b2 = b(a(context, "krlinks"), e2);
        File b3 = b(a(context, "krcopies"), e2);
        File b4 = b(b2, bt.RES_PAKS_DIR_NAME);
        File b5 = b(b3, bt.RES_PAKS_DIR_NAME);
        File[] fileArr = new File[list.length];
        File[] fileArr2 = new File[list.length];
        File[] fileArr3 = new File[list.length];
        UCElapseTime uCElapseTime = new UCElapseTime();
        boolean z = false;
        int i2 = 0;
        while (i2 < list.length) {
            String str3 = list[i2];
            boolean endsWith = str3.endsWith("_pak_kr_uc.so");
            String substring = str3.substring(3, str3.length() - 9);
            int lastIndexOf = substring.lastIndexOf(95);
            String str4 = substring.substring(0, lastIndexOf) + '.' + substring.substring(lastIndexOf + 1);
            File file = new File(j2, str3);
            File file2 = new File(endsWith ? b4 : b2, str4);
            File file3 = new File(endsWith ? b5 : b3, str4);
            fileArr[i2] = file;
            fileArr2[i2] = file2;
            fileArr3[i2] = file3;
            i2++;
            b5 = b5;
            b4 = b4;
        }
        File[] a2 = a(fileArr, fileArr2, fileArr3);
        Log.i(Utils.TAG, "getLnkOrCpyResDirFromSO: file count:" + list.length + " time:" + uCElapseTime.getMilis());
        if (a2[0] == fileArr2[0]) {
            z = true;
        }
        if (!z) {
            return b3.getAbsolutePath();
        }
        return b2.getAbsolutePath();
    }

    private static bt a(Context context, String str, String str2, String str3, String str4) throws UCSetupException {
        String str5;
        String str6;
        String str7;
        String str8;
        boolean a2 = a(str);
        boolean a3 = a(str2);
        boolean a4 = a(str3);
        String str9 = null;
        if (!a2 || f()) {
            if (!a2) {
                File j2 = j(str);
                String absolutePath = UCCyclone.expectFile(j2, "core.jar").getAbsolutePath();
                try {
                    str8 = UCCyclone.expectFile(j2, "sdk_shell.jar").getAbsolutePath();
                } catch (Throwable unused) {
                    str8 = null;
                }
                try {
                    str9 = UCCyclone.expectFile(j2, "browser_if.jar").getAbsolutePath();
                } catch (Throwable unused2) {
                }
                str5 = absolutePath;
                str7 = str8;
                str6 = str9;
            } else {
                str7 = null;
                str6 = null;
                str5 = null;
            }
            return new UCMPackageInfo(context, SocialConstants.PARAM_SPECIFIED, str2, str3, str, str7, str6, str5, str4, false, false);
        } else if (a3 && a4) {
            return null;
        } else {
            throw new UCSetupException(3002, "No ucm dex file specified.");
        }
    }

    private static List<bt> a(Context context, File file, List<bt> list) throws UCSetupException {
        boolean z;
        List<bt> arrayList = list != null ? list : new ArrayList<>();
        Log.i(Utils.TAG, " listUninstalls ucmDirFile :" + file.getAbsolutePath());
        if (file.exists() && file.isDirectory()) {
            File file2 = new File(file, "sdk_shell.jar");
            File file3 = new File(file, "browser_if.jar");
            File file4 = new File(file, "core.jar");
            File file5 = new File(file, SolidMonitor.CHECK_TYPE_LIB);
            i.a().b(UCCore.OPTION_USE_SDK_SETUP);
            if (f()) {
                z = file5.isDirectory();
            } else {
                z = file4.exists() && (!i.a().b(UCCore.OPTION_USE_SDK_SETUP) || file2.exists()) && file5.isDirectory();
            }
            if (z) {
                String[] strArr = a;
                int length = strArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    File file6 = new File(file5, strArr[i2]);
                    if (file6.isDirectory()) {
                        file5 = file6;
                        break;
                    }
                    i2++;
                }
                File file7 = new File(file, "assets");
                Log.i(Utils.TAG, " listUninstalls resDirFile :" + file7.getAbsolutePath());
                if (z) {
                    arrayList.add(new UCMPackageInfo(context, SocialConstants.PARAM_SPECIFIED, b(file5), b(file7), b(file), b(file2), b(file3), b(file4), null, false, false));
                }
            }
            Log.i(Utils.TAG, " listUninstalls retUCMpis size :" + arrayList.size());
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file8 : listFiles) {
                    if (file8.isDirectory()) {
                        a(context, file8, arrayList);
                    }
                }
            }
        }
        return arrayList;
    }

    public static final String a(Throwable th) {
        String str;
        if (th == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(th.getMessage());
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null && stackTrace.length > 0) {
            int min = Math.min(8, stackTrace.length);
            for (int i2 = 0; i2 < min; i2++) {
                StackTraceElement stackTraceElement = stackTrace[i2];
                if (i2 < 2) {
                    str = stackTraceElement.getClassName();
                } else {
                    str = "";
                }
                int lineNumber = stackTraceElement.getLineNumber();
                sb.append(" ");
                sb.append(str);
                sb.append(":");
                sb.append(lineNumber);
            }
        }
        return sb.toString();
    }

    public static File a(File file) {
        for (String str : a) {
            File file2 = new File(file, str);
            if (file2.isDirectory()) {
                return file2;
            }
        }
        return file;
    }
}
