package com.uc.webview.export.internal.utility;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.setup.af;
import com.uc.webview.export.internal.setup.bt;
import com.uc.webview.export.internal.setup.h;
import com.uc.webview.export.internal.uc.startup.b;
import com.youku.live.dago.module.DagoPlayerInteract;
import com.youku.usercenter.passport.result.VerifyCookieResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class m {
    public static String a = "lastucm";
    public static String b = "SO_DIR_PATH";
    public static String c = "RES_DIR_PATH";
    public static String d = "DATA_DIR_PATH";
    public static String e = "BUILD.TIME";
    public static String f = "aarch";
    public static String g = "COREIMPL_FILE_PATH";
    public static String h = "COREIMPL_ODEX_DIR_PATH";
    public static boolean i = true;
    public static String j = "quickpath";
    public static String k = "PKG_NAME";
    public static boolean l = true;
    public static final int[] m = {126, DagoPlayerInteract.UNIT_ANCHOR_INFO_WIDTH, 115, 241, 101, 198, 215, 134};
    static bt n;
    static a o = a.NUndefined;
    static Object p = new Object();

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public enum a {
        NUndefined,
        NDisable,
        NNoFile,
        NEmptyFile,
        NEmptyLast,
        NNewZip,
        NNewDex,
        NNewLib,
        NNewKrl,
        NNewUrl,
        NBadLast,
        NExceptions,
        YLastOK,
        NEmptyJSON,
        NMisMatchVersion,
        NNoLastWebViewFlag,
        NDiffArch
    }

    public static void a(bt btVar, ConcurrentHashMap<String, Object> concurrentHashMap) {
        if (btVar == null) {
            new Exception("info should not be null").printStackTrace();
            return;
        }
        if (concurrentHashMap.get(UCCore.OPTION_DEX_FILE_PATH) != null) {
            btVar.setInitInfo(UCCore.OPTION_DEX_FILE_PATH, (String) concurrentHashMap.get(UCCore.OPTION_DEX_FILE_PATH));
        }
        if (concurrentHashMap.get(UCCore.OPTION_SO_FILE_PATH) != null) {
            btVar.setInitInfo(UCCore.OPTION_SO_FILE_PATH, (String) concurrentHashMap.get(UCCore.OPTION_SO_FILE_PATH));
        }
        if (concurrentHashMap.get(UCCore.OPTION_RES_FILE_PATH) != null) {
            btVar.setInitInfo(UCCore.OPTION_RES_FILE_PATH, (String) concurrentHashMap.get(UCCore.OPTION_RES_FILE_PATH));
        }
        if (concurrentHashMap.get(UCCore.OPTION_UCM_ZIP_FILE) != null) {
            btVar.setInitInfo(UCCore.OPTION_UCM_ZIP_FILE, (String) concurrentHashMap.get(UCCore.OPTION_UCM_ZIP_FILE));
        }
        if (concurrentHashMap.get(UCCore.OPTION_UCM_LIB_DIR) != null) {
            btVar.setInitInfo(UCCore.OPTION_UCM_LIB_DIR, (String) concurrentHashMap.get(UCCore.OPTION_UCM_LIB_DIR));
        }
        if (concurrentHashMap.get(UCCore.OPTION_UCM_UPD_URL) != null) {
            btVar.setInitInfo(UCCore.OPTION_UCM_UPD_URL, (String) concurrentHashMap.get(UCCore.OPTION_UCM_UPD_URL));
        }
        if (concurrentHashMap.get(UCCore.OPTION_UCM_KRL_DIR) != null) {
            btVar.setInitInfo(UCCore.OPTION_UCM_KRL_DIR, (String) concurrentHashMap.get(UCCore.OPTION_UCM_KRL_DIR));
        }
    }

    public static String b(Context context) {
        return new File(context.getDir("ucmsdk", 0), a).getAbsolutePath();
    }

    public static void c(Context context) {
        if (context != null) {
            a(context, b(context));
        }
    }

    public static void d(Context context) {
        try {
            new File(b(context)).delete();
        } catch (Exception unused) {
        }
    }

    private static JSONObject b(String str) {
        if (p.a(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (ClassCastException | JSONException unused) {
            return null;
        }
    }

    private static boolean c() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 21) {
            return false;
        }
        if (i2 >= 23) {
            return Process.is64Bit();
        }
        if (i2 >= 21) {
            try {
                Object invoke = ClassLoader.class.getDeclaredMethod("findLibrary", String.class).invoke(m.class.getClassLoader(), "art");
                if (invoke != null) {
                    return ((String) invoke).contains("lib64");
                }
            } catch (Exception unused) {
            }
            String property = System.getProperty("os.arch");
            if (property != null) {
                property.contains("64");
            }
        }
        return false;
    }

    private static byte[] b(byte[] bArr, int[] iArr) {
        if (bArr.length >= 2 && iArr != null && iArr.length == 8) {
            int length = bArr.length - 2;
            try {
                byte[] bArr2 = new byte[length];
                byte b2 = 0;
                for (int i2 = 0; i2 < length; i2++) {
                    byte b3 = (byte) (bArr[i2] ^ iArr[i2 % 8]);
                    bArr2[i2] = b3;
                    b2 = (byte) (b2 ^ b3);
                }
                if (bArr[length] == ((byte) ((iArr[0] ^ b2) & 255)) && bArr[length + 1] == ((byte) ((iArr[1] ^ b2) & 255))) {
                    return bArr2;
                }
                return null;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:85:0x01b2 A[Catch:{ all -> 0x01d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01c4 A[Catch:{ all -> 0x01d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01ca A[Catch:{ all -> 0x01d7 }] */
    private static boolean c(Context context, ConcurrentHashMap<String, Object> concurrentHashMap) {
        String str;
        String str2;
        String str3;
        boolean z;
        if (context == null) {
            return false;
        }
        try {
            if (!af.b()) {
                a(a.NDisable);
                return false;
            }
            if (n == null) {
                n = a(context, b(context));
            }
            bt btVar = n;
            if (btVar == null) {
                if (i) {
                    Log.d(j, "willReuseOldCoreInternal false. null");
                }
                return false;
            }
            String initInfo = btVar.getInitInfo(UCCore.OPTION_UCM_ZIP_FILE);
            String initInfo2 = n.getInitInfo(UCCore.OPTION_DEX_FILE_PATH);
            String initInfo3 = n.getInitInfo(UCCore.OPTION_SO_FILE_PATH);
            String initInfo4 = n.getInitInfo(UCCore.OPTION_RES_FILE_PATH);
            String initInfo5 = n.getInitInfo(UCCore.OPTION_UCM_LIB_DIR);
            String initInfo6 = n.getInitInfo(UCCore.OPTION_UCM_KRL_DIR);
            String initInfo7 = n.getInitInfo(UCCore.OPTION_UCM_UPD_URL);
            String initInfo8 = n.getInitInfo(e);
            String initInfo9 = n.getInitInfo(f);
            String str4 = (String) concurrentHashMap.get(UCCore.OPTION_UCM_ZIP_FILE);
            String str5 = (String) concurrentHashMap.get(UCCore.OPTION_DEX_FILE_PATH);
            String str6 = (String) concurrentHashMap.get(UCCore.OPTION_SO_FILE_PATH);
            String str7 = (String) concurrentHashMap.get(UCCore.OPTION_RES_FILE_PATH);
            String str8 = (String) concurrentHashMap.get(UCCore.OPTION_UCM_LIB_DIR);
            String str9 = (String) concurrentHashMap.get(UCCore.OPTION_UCM_KRL_DIR);
            String initInfo10 = n.getInitInfo(UCCore.OPTION_UCM_UPD_URL);
            if (i) {
                String str10 = j;
                str2 = initInfo10;
                str = str9;
                Log.d(str10, "buildtime=" + com.uc.webview.export.Build.TIME + ",lasttime=" + initInfo8);
                String str11 = j;
                Log.d(str11, "zipFilePath=" + str4 + ",last=" + initInfo);
            } else {
                str2 = initInfo10;
                str = str9;
            }
            if (initInfo8 != null) {
                if (initInfo8.equals(com.uc.webview.export.Build.TIME)) {
                    if (p.a((Boolean) concurrentHashMap.get(UCCore.OPTION_SKIP_OLD_KERNEL))) {
                        if (initInfo9 == null) {
                            a(a.NDiffArch);
                            return false;
                        }
                        if (!initInfo9.equals(c() ? "1" : "0")) {
                            a(a.NDiffArch);
                            return false;
                        }
                    }
                    if (str4 != null && !str4.equals(initInfo)) {
                        a(a.NNewZip);
                        return false;
                    } else if (str5 != null && !str5.equals(initInfo2)) {
                        a(a.NNewDex);
                        return false;
                    } else if (str6 != null && !str6.equals(initInfo3)) {
                        a(a.NNewDex);
                        return false;
                    } else if (str7 != null && !str7.equals(initInfo4)) {
                        a(a.NNewDex);
                        return false;
                    } else if (str8 == null || str8.equals(initInfo5)) {
                        if (str != null) {
                            str3 = initInfo6;
                            if (!str.equals(str3)) {
                                a(a.NNewKrl);
                                return false;
                            }
                        } else {
                            str3 = initInfo6;
                        }
                        if (str2 == null || str2.equals(initInfo7)) {
                            boolean z2 = true;
                            if (initInfo == null && initInfo2 == null && initInfo3 == null && initInfo4 == null && initInfo5 == null) {
                                if (str3 == null) {
                                    z = false;
                                    if (!z) {
                                        bt btVar2 = n;
                                        if (btVar2.soDirPath == null && btVar2.resDirPath == null) {
                                            if (btVar2.dataDir == null) {
                                                z2 = false;
                                            }
                                        }
                                    }
                                    if (z2) {
                                        a(a.NBadLast);
                                    } else {
                                        a(a.YLastOK);
                                    }
                                    return z2;
                                }
                            }
                            z = true;
                            if (!z) {
                            }
                            if (z2) {
                            }
                            return z2;
                        }
                        a(a.NNewUrl);
                        return false;
                    } else {
                        a(a.NNewLib);
                        return false;
                    }
                }
            }
            a(a.NMisMatchVersion);
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            a(a.NExceptions);
            return false;
        }
    }

    private static byte[] b(String str, boolean z) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[((int) file.length())];
            fileInputStream.read(bArr);
            fileInputStream.close();
            return z ? b(bArr, m) : bArr;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean b() {
        bt btVar = n;
        return btVar != null && btVar.isFromDisk;
    }

    public static boolean b(Context context, ConcurrentHashMap<String, Object> concurrentHashMap) {
        if (!af.b()) {
            a aVar = a.NDisable;
            a(aVar);
            if (i) {
                String str = j;
                Log.d(str, "willReuseOldCore false. rz=" + aVar);
            }
            return false;
        } else if (!h.a(context)) {
            if (i) {
                Log.d(j, "willReuseOldCore false. no lastwebview flag");
            }
            a(a.NNoLastWebViewFlag);
            return false;
        } else {
            a aVar2 = o;
            a aVar3 = a.YLastOK;
            if (aVar2.equals(aVar3)) {
                if (!i) {
                    return true;
                }
                Log.d(j, "willReuseOldCore true. rz=okincache");
                return true;
            } else if (o.equals(aVar3) || o.equals(a.NUndefined)) {
                boolean c2 = c(context, concurrentHashMap);
                i.a().a("gk_quick_path", Boolean.valueOf(c2));
                return c2;
            } else {
                if (i) {
                    String str2 = j;
                    Log.d(str2, "willReuseOldCore false. rz=" + o);
                }
                return false;
            }
        }
    }

    public static void a(bt btVar, String str) {
        b.a(324);
        if (btVar == null) {
            new Exception("info should not be null").printStackTrace();
            return;
        }
        if (i) {
            Log.d("quickpath", "saveInfoToJsonFile path=" + str + ",isFromDisk=" + btVar.isFromDisk);
        }
        if (!btVar.isFromDisk) {
            try {
                a(a(btVar).toString(), str, l);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            b.a(325);
        }
    }

    private static JSONObject a(bt btVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            a(jSONObject, UCCore.OPTION_DEX_FILE_PATH, btVar.getInitInfo(UCCore.OPTION_DEX_FILE_PATH));
            a(jSONObject, UCCore.OPTION_SO_FILE_PATH, btVar.getInitInfo(UCCore.OPTION_SO_FILE_PATH));
            a(jSONObject, UCCore.OPTION_RES_FILE_PATH, btVar.getInitInfo(UCCore.OPTION_RES_FILE_PATH));
            a(jSONObject, UCCore.OPTION_UCM_ZIP_FILE, btVar.getInitInfo(UCCore.OPTION_UCM_ZIP_FILE));
            a(jSONObject, UCCore.OPTION_UCM_LIB_DIR, btVar.getInitInfo(UCCore.OPTION_UCM_LIB_DIR));
            a(jSONObject, UCCore.OPTION_UCM_UPD_URL, btVar.getInitInfo(UCCore.OPTION_UCM_UPD_URL));
            a(jSONObject, UCCore.OPTION_UCM_KRL_DIR, btVar.getInitInfo(UCCore.OPTION_UCM_KRL_DIR));
            a(jSONObject, k, btVar.pkgName);
            a(jSONObject, b, btVar.soDirPath);
            a(jSONObject, c, btVar.resDirPath);
            a(jSONObject, d, btVar.dataDir);
            a(jSONObject, e, com.uc.webview.export.Build.TIME);
            Pair<String, String> pair = btVar.coreImplModule;
            if (pair != null) {
                a(jSONObject, g, (String) pair.first);
            }
            a(jSONObject, f, c() ? "1" : "0");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static String a(Context context) {
        String b2 = b(context);
        StringBuilder sb = new StringBuilder();
        sb.append("path=");
        sb.append(b2);
        sb.append("\ncontent=");
        if (new File(b2).exists()) {
            sb.append(a(b2, l));
        } else {
            sb.append("[Not Exists]");
        }
        return sb.toString();
    }

    /* JADX INFO: finally extract failed */
    private static bt a(Context context, String str) {
        bt btVar = n;
        if (btVar != null) {
            return btVar;
        }
        synchronized (p) {
            try {
                b.a(322);
                bt btVar2 = n;
                if (btVar2 != null) {
                    b.a(323);
                    return btVar2;
                }
                JSONObject a2 = a(str);
                if (a2 == null) {
                    a(a.NEmptyJSON);
                    b.a(323);
                    return null;
                }
                bt a3 = a(context, a2);
                n = a3;
                if (a3 == null) {
                    a(a.NEmptyLast);
                }
                b.a(323);
                return n;
            } catch (Throwable th) {
                b.a(323);
                throw th;
            }
        }
    }

    private static JSONObject a(String str) {
        if (!new File(str).exists()) {
            a(a.NNoFile);
            return null;
        }
        try {
            String a2 = a(str, l);
            if (a2 == null) {
                a(a.NEmptyFile);
                return null;
            }
            b.a(InputDeviceCompat.SOURCE_DPAD);
            JSONObject b2 = b(a2);
            b.a(514);
            return b2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static String a(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    private static void a(JSONObject jSONObject, String str, String str2) {
        if (str2 != null && str != null) {
            try {
                jSONObject.put(str, str2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private static bt a(Context context, JSONObject jSONObject) {
        Exception e2;
        UCMPackageInfo uCMPackageInfo = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            b.a(512);
            UCMPackageInfo uCMPackageInfo2 = new UCMPackageInfo(context, a(jSONObject, k), a(jSONObject, b), a(jSONObject, c), a(jSONObject, d), null, null, a(jSONObject, g), null, false, true);
            try {
                if (a(jSONObject, e) != null) {
                    String str = e;
                    uCMPackageInfo2.setInitInfo(str, a(jSONObject, str));
                }
                if (a(jSONObject, UCCore.OPTION_DEX_FILE_PATH) != null) {
                    uCMPackageInfo2.setInitInfo(UCCore.OPTION_DEX_FILE_PATH, a(jSONObject, UCCore.OPTION_DEX_FILE_PATH));
                }
                if (a(jSONObject, UCCore.OPTION_SO_FILE_PATH) != null) {
                    uCMPackageInfo2.setInitInfo(UCCore.OPTION_SO_FILE_PATH, a(jSONObject, UCCore.OPTION_SO_FILE_PATH));
                }
                if (a(jSONObject, UCCore.OPTION_RES_FILE_PATH) != null) {
                    uCMPackageInfo2.setInitInfo(UCCore.OPTION_RES_FILE_PATH, a(jSONObject, UCCore.OPTION_RES_FILE_PATH));
                }
                if (a(jSONObject, UCCore.OPTION_UCM_ZIP_FILE) != null) {
                    uCMPackageInfo2.setInitInfo(UCCore.OPTION_UCM_ZIP_FILE, a(jSONObject, UCCore.OPTION_UCM_ZIP_FILE));
                }
                if (a(jSONObject, UCCore.OPTION_UCM_LIB_DIR) != null) {
                    uCMPackageInfo2.setInitInfo(UCCore.OPTION_UCM_LIB_DIR, a(jSONObject, UCCore.OPTION_UCM_LIB_DIR));
                }
                if (a(jSONObject, UCCore.OPTION_UCM_UPD_URL) != null) {
                    uCMPackageInfo2.setInitInfo(UCCore.OPTION_UCM_UPD_URL, a(jSONObject, UCCore.OPTION_UCM_UPD_URL));
                }
                if (a(jSONObject, UCCore.OPTION_UCM_KRL_DIR) != null) {
                    uCMPackageInfo2.setInitInfo(UCCore.OPTION_UCM_KRL_DIR, a(jSONObject, UCCore.OPTION_UCM_KRL_DIR));
                }
                if (a(jSONObject, f) != null) {
                    String str2 = f;
                    uCMPackageInfo2.setInitInfo(str2, a(jSONObject, str2));
                }
                uCMPackageInfo2.isFromDisk = true;
                b.a(VerifyCookieResult.COOKIE_VERIFY_ERROR);
                return uCMPackageInfo2;
            } catch (Exception e3) {
                e2 = e3;
                uCMPackageInfo = uCMPackageInfo2;
                e2.printStackTrace();
                return uCMPackageInfo;
            }
        } catch (Exception e4) {
            e2 = e4;
            e2.printStackTrace();
            return uCMPackageInfo;
        }
    }

    private static byte[] a(byte[] bArr, int[] iArr) {
        byte[] bArr2 = null;
        if (!(bArr == null || iArr == null || iArr.length != 8)) {
            int length = bArr.length;
            try {
                bArr2 = new byte[(length + 2)];
                byte b2 = 0;
                for (int i2 = 0; i2 < length; i2++) {
                    byte b3 = bArr[i2];
                    bArr2[i2] = (byte) (iArr[i2 % 8] ^ b3);
                    b2 = (byte) (b2 ^ b3);
                }
                bArr2[length] = (byte) (iArr[0] ^ b2);
                bArr2[length + 1] = (byte) (iArr[1] ^ b2);
            } catch (Exception unused) {
            }
        }
        return bArr2;
    }

    private static boolean a(String str, String str2, boolean z) {
        if (i) {
            String str3 = j;
            Log.d(str3, "saveStringToFile str=" + str);
        }
        try {
            a(str.getBytes("UTF-8"), str2, z);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }

    private static String a(String str, boolean z) {
        byte[] b2 = b(str, z);
        if (b2 == null) {
            return null;
        }
        try {
            return new String(b2, "UTF-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static boolean a(byte[] bArr, String str, boolean z) {
        try {
            File file = new File(str);
            File file2 = new File(file.getParent());
            if (!file2.exists()) {
                file2.mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            if (z) {
                bArr = a(bArr, m);
            }
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static bt a() {
        return n;
    }

    public static boolean a(Context context, ConcurrentHashMap<String, Object> concurrentHashMap) {
        if (context == null) {
            return true;
        }
        try {
            if (!af.b()) {
                return true;
            }
            if (!o.equals(a.YLastOK) && !o.equals(a.NUndefined)) {
                return true;
            }
            if (n == null) {
                n = a(context, b(context));
            }
            bt btVar = n;
            if (btVar == null) {
                return true;
            }
            String initInfo = btVar.getInitInfo(UCCore.OPTION_UCM_UPD_URL);
            String str = (String) concurrentHashMap.get(UCCore.OPTION_UCM_UPD_URL);
            if (str == null || str.equals(initInfo)) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void a(a aVar) {
        o = aVar;
        if (i) {
            String str = j;
            Log.d(str, "statQuickPathStatus st=" + aVar);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(aVar.ordinal());
        b.a(501, sb.toString());
    }
}
