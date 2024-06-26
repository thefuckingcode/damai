package com.uc.webview.export.internal.utility;

import android.content.Context;
import android.os.Process;
import androidx.exifinterface.media.ExifInterface;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.weex.annotation.JSMethod;
import com.uc.webview.export.CDParamKeys;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.UCKnownException;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IGlobalSettings;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.utility.l;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.Stack;

/* compiled from: Taobao */
public final class j {
    public static long a = 2;
    private static final String b = "j";
    private static long c = 1;
    private static long d = 4;
    private static long e = 8;
    private static long f = 16;
    private static String g = "com.eg.android.AlipayGphone";
    private static long h;
    private static long i;
    private static long j;

    /* compiled from: Taobao */
    public static class a {
        public static long a = 1;
        public static long b = 2;
        public static long c = 4;
        public static long d = 8;
        public static long e = 16;
        public static long f = 32;
        public static long g = 64;
        public static long h = 128;
        public static long i = 256;
        public static long j = 512;
        public static long k = 1024;
        public static long l = 2048;
        public static long m = 4096;
        public static long n = 8192;
        public static long o = 16384;
        public static long p = 32768;
        public static long q = 65536;
        public static long r = 131072;
        public long s = 0;

        public final void a(long j2) {
            this.s = j2 | this.s;
        }
    }

    static {
        long j2 = 1 << 1;
        h = j2;
        long j3 = j2 << 1;
        i = j3;
        j = j3 << 1;
    }

    public static void a(String str) {
        if (!p.a(str)) {
            try {
                IGlobalSettings f2 = SDKFactory.f();
                if (f2 != null) {
                    f2.setStringValue("LoadShareCoreHost", str);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static String b(String str) {
        int min;
        if (p.a(str)) {
            return str;
        }
        try {
            String replaceAll = str.replaceAll("Exception", ExifInterface.LONGITUDE_EAST);
            int indexOf = replaceAll.indexOf(":");
            int i2 = -1;
            if (indexOf >= 0) {
                i2 = replaceAll.lastIndexOf(".", indexOf);
            }
            return (i2 < 0 || (min = Math.min(i2 + 30, replaceAll.length())) <= i2) ? replaceAll : replaceAll.substring(i2, min);
        } catch (Throwable unused) {
            return str;
        }
    }

    public static File c(String str) {
        return a(new File(a()), str);
    }

    private static long d(String str) {
        long j2 = 0;
        if (p.a(str)) {
            return 0;
        }
        String[] split = str.split("\\.");
        for (int i2 = 0; i2 < split.length; i2++) {
            j2 += (long) Integer.parseInt(split[i2]);
            if (i2 < split.length - 1) {
                j2 *= 100;
            }
        }
        return j2;
    }

    public static String e(Context context) {
        int i2;
        String[] strArr;
        int i3;
        long j2;
        String str;
        StringBuilder sb;
        long j3 = h;
        try {
            if (!b(context)) {
                str = b;
                Log.d(str, ".getSdcardShareCoreDecFilePath Sdcard配置及权限校验失败");
                j2 = i;
                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_GET_CORE_DEC_FILE_PATH, Long.toString(j2));
                sb = new StringBuilder(".getSdcardShareCoreDecFilePath fStat: ");
            } else {
                String param = UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_CLIENT_SPECIAL_HOST_PKG_NAME_LIST);
                if (p.a(param)) {
                    j2 = j;
                    str = b;
                    Log.d(str, ".getSdcardShareCoreDecFilePath CDKeys.CD_KEY_SHARE_CORE_HOST_PKG_NAME_LIST配置为空");
                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_GET_CORE_DEC_FILE_PATH, Long.toString(j2));
                    sb = new StringBuilder(".getSdcardShareCoreDecFilePath fStat: ");
                } else {
                    String[] split = param.split(CDParamKeys.CD_VALUE_STRING_SPLITER);
                    Stack stack = new Stack();
                    int length = split.length;
                    String str2 = null;
                    int i4 = 0;
                    while (i4 < length) {
                        String str3 = split[i4];
                        if (!p.a(str3)) {
                            File c2 = c(str3);
                            if (!c2.exists()) {
                                Log.d(b, ".getSdcardShareCoreDecFilePath " + c2.getAbsolutePath() + " not exists.");
                            } else {
                                File[] listFiles = c2.listFiles();
                                if (listFiles == null || listFiles.length == 0) {
                                    strArr = split;
                                    i2 = length;
                                    Log.d(b, ".getSdcardShareCoreDecFilePath " + c2.getAbsolutePath() + " empty.");
                                    i4++;
                                    split = strArr;
                                    length = i2;
                                } else {
                                    int length2 = listFiles.length;
                                    int i5 = 0;
                                    while (i5 < length2) {
                                        File file = listFiles[i5];
                                        String str4 = b;
                                        Log.d(str4, ".getSdcardShareCoreDecFilePath coreFile: " + file.getAbsolutePath());
                                        String a2 = a(context, file, UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_CLIENT_UCM_VERSIONS), null);
                                        if (p.a(a2)) {
                                            Log.d(str4, ".getSdcardShareCoreDecFilePath version is empty.");
                                        } else if (w.a(file.getAbsolutePath(), context)) {
                                            Log.d(str4, ".getSdcardShareCoreDecFilePath " + file.getAbsolutePath() + " once shared.");
                                            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_SKIP_ONCE_VERIFY_CORE_FILE);
                                        } else {
                                            i3 = length2;
                                            Log.d(str4, ".getSdcardShareCoreDecFilePath version : " + a2);
                                            if (a(str2, a2) < 0) {
                                                stack.push(file);
                                                str2 = a2;
                                            }
                                            i5++;
                                            split = split;
                                            length = length;
                                            length2 = i3;
                                        }
                                        i3 = length2;
                                        i5++;
                                        split = split;
                                        length = length;
                                        length2 = i3;
                                    }
                                }
                            }
                        }
                        strArr = split;
                        i2 = length;
                        i4++;
                        split = strArr;
                        length = i2;
                    }
                    while (!stack.empty()) {
                        File file2 = (File) stack.pop();
                        if (!UCCyclone.detectZipByFileType(file2.getAbsolutePath()) || a(file2) || l.a(file2.getAbsolutePath(), context, context, new l.b("sc_cvsv"))) {
                            w.a(file2.getAbsolutePath(), context, true);
                            String absolutePath = file2.getAbsolutePath();
                            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_GET_CORE_DEC_FILE_PATH, Long.toString(j3));
                            Log.d(b, ".getSdcardShareCoreDecFilePath fStat: " + j3);
                            return absolutePath;
                        }
                        Log.d(b, ".getSdcardShareCoreDecFilePath verifySignature failure!");
                    }
                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_GET_CORE_DEC_FILE_PATH, Long.toString(j3));
                    Log.d(b, ".getSdcardShareCoreDecFilePath fStat: " + j3);
                    return null;
                }
            }
            sb.append(j2);
            Log.d(str, sb.toString());
            return null;
        } catch (Throwable th) {
            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_GET_CORE_DEC_FILE_PATH, Long.toString(j3));
            Log.d(b, ".getSdcardShareCoreDecFilePath fStat: " + j3);
            throw th;
        }
    }

    public static void f(Context context) {
        String d2 = d(context);
        File a2 = p.a(context, "decompresses2");
        File file = new File(d2);
        String str = b;
        Log.d(str, ".deleteShareCoreDecompressDir decRootDir:" + a2);
        Log.d(str, ".deleteShareCoreDecompressDir scDecDir:" + file);
        int i2 = 5;
        File file2 = file;
        while (true) {
            String str2 = b;
            Log.d(str2, ".deleteShareCoreDecompressDir scParentDir:" + file);
            if (file.getAbsolutePath().equals(a2.getAbsolutePath())) {
                Log.d(str2, ".deleteShareCoreDecompressDir delete share core decompress dir.");
                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_DELETE_DEC_DIR);
                UCCyclone.recursiveDelete(file2, false, null);
                return;
            }
            File parentFile = file2.getParentFile();
            i2--;
            if (i2 > 0) {
                file2 = file;
                file = parentFile;
            } else {
                return;
            }
        }
    }

    public static boolean c(Context context) {
        return g.equals(context.getPackageName());
    }

    private static boolean a(String str, String str2, a aVar) {
        if (p.a(str) || p.a(str2)) {
            if (aVar != null) {
                aVar.a(a.c);
            }
            return false;
        }
        String[] split = str.split(CDParamKeys.CD_VALUE_STRING_SPLITER);
        for (String str3 : split) {
            if (str2.equals(str3) || str2.matches(str3)) {
                return true;
            }
        }
        if (aVar != null) {
            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_SDK_VERSION_CHECK_FAILURE);
        }
        if (aVar != null) {
            aVar.a(a.d);
        }
        return false;
    }

    public static String d(Context context) {
        String str;
        try {
            File[] listFiles = p.a(context, "decompresses2").listFiles();
            if (listFiles.length == 0) {
                return null;
            }
            int length = listFiles.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    str = null;
                    break;
                }
                File file = listFiles[i2];
                if (file.isDirectory()) {
                    str = p.a(file, "sdk_shell");
                    if (!p.a(str)) {
                        if (!p.a(p.a(file, UCCyclone.DecFileOrign.DecFileOrignFlag + UCCyclone.DecFileOrign.Sdcard_Share_Core))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
                i2++;
            }
            if (p.a(str)) {
                return null;
            }
            return new File(str).getParent();
        } catch (Throwable th) {
            Log.d(b, ".getLocationDecDir ", th);
            return null;
        }
    }

    public static boolean b(Context context) {
        return a(context) == a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a2 A[SYNTHETIC, Splitter:B:33:0x00a2] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ac A[Catch:{ all -> 0x00a8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b3 A[Catch:{ all -> 0x00a8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c9  */
    private static String b(Context context, File file, a aVar) {
        Throwable th;
        File file2;
        File file3;
        try {
            String a2 = p.a(file, "sdk_shell");
            if (p.a(a2)) {
                if (aVar != null) {
                    aVar.a(a.e);
                }
                throw new UCKnownException(8004, String.format("[%s] no found after UCCyclone.decompress.", a2));
            }
            if (aVar != null) {
                try {
                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_SDK_VERSION_GET_FROME_DEX_SDK_SHELL_CLASS_LOADER);
                } catch (Throwable th2) {
                    th = th2;
                    file2 = null;
                }
            }
            file2 = null;
            while (true) {
                try {
                    file3 = new File(context.getCacheDir(), "temp_dex_verify_" + Process.myPid() + JSMethod.NOT_SET + Process.myTid() + JSMethod.NOT_SET + String.valueOf(System.currentTimeMillis()));
                } catch (Throwable th3) {
                    th = th3;
                    if (aVar != null) {
                    }
                    if (aVar != null) {
                    }
                    if (aVar != null) {
                    }
                    if (file2 != null) {
                    }
                    return null;
                }
                try {
                    if (!file3.exists()) {
                        break;
                    }
                    file2 = file3;
                } catch (Throwable th4) {
                    th = th4;
                    file2 = file3;
                    if (aVar != null) {
                        try {
                            aVar.a(a.h);
                        } catch (Throwable th5) {
                            if (file2 != null) {
                                UCCyclone.recursiveDelete(file2, false, null);
                            }
                            throw th5;
                        }
                    }
                    if (aVar != null) {
                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_SDK_VERSION_VERIFY_EXCEPTION);
                    }
                    if (aVar != null) {
                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_SDK_VERSION_VERIFY_EXCEPTION_VALUE, b(th.toString()));
                    }
                    if (file2 != null) {
                        UCCyclone.recursiveDelete(file2, false, null);
                    }
                    return null;
                }
            }
            UCCyclone.expectCreateDirFile(file3);
            DexClassLoader dexClassLoader = new DexClassLoader(a2, file3.getAbsolutePath(), "", j.class.getClassLoader());
            if (aVar != null) {
                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_SDK_VERSION_DEX_SDK_SHELL_CLASS_LOADER);
            }
            if (aVar != null) {
                aVar.a(a.r);
            }
            String b2 = h.b(dexClassLoader);
            UCCyclone.recursiveDelete(file3, false, null);
            return b2;
        } catch (Throwable th6) {
            if (aVar != null) {
                aVar.a(a.g);
            }
            if (aVar != null) {
                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_SDK_VERSION_VERIFY_ERROR);
            }
            if (aVar != null) {
                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_SDK_VERSION_VERIFY_ERROR_VALUE, b(th6.toString()));
            }
            Log.d(b, ".getCoreCompressFileVersion", th6);
            return null;
        }
    }

    private static int a(String str, String str2) {
        int i2 = (d(str) > d(str2) ? 1 : (d(str) == d(str2) ? 0 : -1));
        if (i2 > 0) {
            return 1;
        }
        return i2 == 0 ? 0 : -1;
    }

    public static long a(Context context) {
        long j2 = a;
        try {
            String param = UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_COMMONALITY_TARGET_FPATH);
            if (p.a(param)) {
                return d;
            }
            if (context.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", context.getPackageName()) != 0) {
                return e;
            }
            File file = new File(param, "uws");
            UCCyclone.expectCreateDirFile(file);
            if (!file.exists()) {
                return f;
            }
            return j2;
        } catch (Throwable th) {
            Log.d(b, ".sdcardAuthority", th);
            return j2;
        }
    }

    public static String a() {
        return new File(UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_COMMONALITY_TARGET_FPATH), "uws").getAbsolutePath();
    }

    public static File a(File file, String str) {
        return p.b(file, p.e(str));
    }

    public static boolean a(File file) {
        return file.getAbsolutePath().contains("uws") && file.getAbsolutePath().contains(p.e(g));
    }

    public static boolean a(Context context, File file, a aVar) {
        return l.a(file.getAbsolutePath(), context, context, new l.b("sc_cvsv"), aVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x010d A[Catch:{ all -> 0x012e }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0114 A[Catch:{ all -> 0x012e }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x011b A[Catch:{ all -> 0x012e }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x012a A[DONT_GENERATE] */
    public static String a(Context context, File file, String str, a aVar) {
        Throwable th;
        File file2;
        Log.d(b, ".getLegalVersionsFromCoreCompressFile " + file.getAbsolutePath() + AVFSCacheConstants.COMMA_SEP + str);
        File file3 = null;
        while (true) {
            try {
                file2 = new File(context.getCacheDir(), "temp_dec_core_" + Process.myPid() + JSMethod.NOT_SET + Process.myTid() + JSMethod.NOT_SET + String.valueOf(System.currentTimeMillis()));
                try {
                    if (!file2.exists()) {
                        break;
                    }
                    file3 = file2;
                } catch (Throwable th2) {
                    th = th2;
                    file3 = file2;
                    try {
                        Log.d(b, ".getLegalVersionsFromCoreCompressFile", th);
                        if (aVar != null) {
                            aVar.a(a.a);
                        }
                        if (aVar != null) {
                            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_SDK_VERSION_DEC_CORE_FILE_EXCEPTION);
                        }
                        if (aVar != null) {
                            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_SDK_VERSION_DEC_CORE_FILE_EXCEPTION_VALUE, b(th.toString()));
                        }
                        return null;
                    } finally {
                        if (file3 != null) {
                            UCCyclone.recursiveDelete(file3, false, null);
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                Log.d(b, ".getLegalVersionsFromCoreCompressFile", th);
                if (aVar != null) {
                }
                if (aVar != null) {
                }
                if (aVar != null) {
                }
                return null;
            }
        }
        UCCyclone.expectCreateDirFile(file2);
        UCCyclone.decompress(!UCCyclone.detectZipByFileType(file.getAbsolutePath()), context, file.getAbsolutePath(), file2.getAbsolutePath(), "sdk_shell", new k());
        if (aVar != null) {
            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_SDK_VERSION_DEC_CORE_FILE_SUCCESS);
        }
        if (aVar != null) {
            aVar.a(a.q);
        }
        String b2 = b(context, file2, aVar);
        if (!p.a(b2)) {
            if (aVar != null) {
                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_SDK_VERSION_VALUE, b2);
            }
            Log.d(b, ".getLegalVersionsFromCoreDir ucmVersion: " + b2 + " of " + file2.getAbsolutePath());
            if (a(str, b2, aVar)) {
                String a2 = p.a(file2, "sdk_shell");
                if (!a(context, new File(a2), aVar)) {
                    if (aVar != null) {
                        aVar.a(a.f);
                    }
                    throw new UCKnownException(8005, String.format("[%s] verify failure.", a2));
                }
                UCCyclone.recursiveDelete(file2, false, null);
                return b2;
            }
        } else if (aVar != null) {
            aVar.a(a.b);
        }
        b2 = null;
        UCCyclone.recursiveDelete(file2, false, null);
        return b2;
    }
}
