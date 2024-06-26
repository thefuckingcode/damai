package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.youku.upsplayer.util.YKUpsConvert;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
public class BksUtil {
    private static final String a = "BksUtil";
    private static final String b = "com.huawei.hwid";
    private static final String c = "com.huawei.hwid";
    private static final String d = "com.huawei.hms";
    private static final String e = "com.huawei.hwid.tv";
    private static final Uri f = Uri.parse("content://com.huawei.hwid");
    private static final String g = "files/hmsrootcas.bks";
    private static final String h = "4.0.2.300";
    private static final String i = "aegis";
    private static final String j = "hmsrootcas.bks";
    private static final long k = 604800000;
    private static final String l = "last_update_time";
    private static final String m = "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05";
    private static final String n = "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C";
    private static final String o = "E49D5C2C0E11B3B1B96CA56C6DE2A14EC7DAB5CCC3B5F300D03E5B4DBA44F539";
    private static final String[] p = {"B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05", o};
    private static final String q = "";
    private static final String r = "bks_hash";

    private BksUtil() {
    }

    private static void a(InputStream inputStream, Context context) {
        Throwable th;
        if (inputStream != null && context != null) {
            String a2 = a(context);
            if (!new File(a2).exists()) {
                a(a2);
            }
            File file = new File(a2, "hmsrootcas.bks");
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fileOutputStream = null;
            try {
                g.c(a, "write output stream ");
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int read = inputStream.read(bArr, 0, 2048);
                        if (read != -1) {
                            fileOutputStream2.write(bArr, 0, read);
                        } else {
                            f.a((OutputStream) fileOutputStream2);
                            return;
                        }
                    }
                } catch (IOException unused) {
                    fileOutputStream = fileOutputStream2;
                    try {
                        g.b(a, " IOException");
                        f.a((OutputStream) fileOutputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        f.a((OutputStream) fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = fileOutputStream2;
                    f.a((OutputStream) fileOutputStream);
                    throw th;
                }
            } catch (IOException unused2) {
                g.b(a, " IOException");
                f.a((OutputStream) fileOutputStream);
            }
        }
    }

    private static boolean a(int i2) {
        return i2 >= 40002300;
    }

    private static String b(Context context) {
        return a(context) + File.separator + "hmsrootcas.bks";
    }

    private static boolean c(Context context) {
        return new File(a(context) + File.separator + "hmsrootcas.bks").exists();
    }

    public static synchronized InputStream getBksFromTss(Context context) {
        Throwable th;
        InputStream inputStream;
        ByteArrayInputStream byteArrayInputStream;
        synchronized (BksUtil.class) {
            g.c(a, "get bks from tss begin");
            if (context != null) {
                c.a(context);
            }
            Context a2 = c.a();
            ByteArrayInputStream byteArrayInputStream2 = null;
            if (a2 == null) {
                g.b(a, "context is null");
                return null;
            } else if (!b(h.a("com.huawei.hwid")) && !b(h.a("com.huawei.hms"))) {
                g.b(a, "hms version code is too low : " + h.a("com.huawei.hwid"));
                return null;
            } else if (c(a2, "com.huawei.hwid") || b(a2, "com.huawei.hms")) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    inputStream = a2.getContentResolver().openInputStream(Uri.withAppendedPath(f, g));
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read <= -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        byteArrayOutputStream.flush();
                        byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                    } catch (Exception unused) {
                        try {
                            g.b(a, "Get bks from HMS_VERSION_CODE exception : No content provider");
                            f.a(inputStream);
                            f.a((OutputStream) byteArrayOutputStream);
                            f.a((InputStream) byteArrayInputStream2);
                            return getFilesBksIS(a2);
                        } catch (Throwable th2) {
                            th = th2;
                            f.a(inputStream);
                            f.a((OutputStream) byteArrayOutputStream);
                            f.a((InputStream) byteArrayInputStream2);
                            throw th;
                        }
                    }
                    try {
                        String a3 = i.a(r, "", a2);
                        String b2 = b(byteArrayOutputStream.toByteArray());
                        if (c(a2)) {
                            if (a3.equals(b2)) {
                                g.c(a, "bks not update");
                                f.a(inputStream);
                                f.a((OutputStream) byteArrayOutputStream);
                                f.a((InputStream) byteArrayInputStream);
                                return getFilesBksIS(a2);
                            }
                        }
                        g.c(a, "update bks and sp");
                        a(byteArrayInputStream, a2);
                        i.b(r, b2, a2);
                        f.a(inputStream);
                        f.a((OutputStream) byteArrayOutputStream);
                        f.a((InputStream) byteArrayInputStream);
                    } catch (Exception unused2) {
                        byteArrayInputStream2 = byteArrayInputStream;
                        g.b(a, "Get bks from HMS_VERSION_CODE exception : No content provider");
                        f.a(inputStream);
                        f.a((OutputStream) byteArrayOutputStream);
                        f.a((InputStream) byteArrayInputStream2);
                        return getFilesBksIS(a2);
                    } catch (Throwable th3) {
                        th = th3;
                        byteArrayInputStream2 = byteArrayInputStream;
                        f.a(inputStream);
                        f.a((OutputStream) byteArrayOutputStream);
                        f.a((InputStream) byteArrayInputStream2);
                        throw th;
                    }
                } catch (Exception unused3) {
                    inputStream = null;
                    g.b(a, "Get bks from HMS_VERSION_CODE exception : No content provider");
                    f.a(inputStream);
                    f.a((OutputStream) byteArrayOutputStream);
                    f.a((InputStream) byteArrayInputStream2);
                    return getFilesBksIS(a2);
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = null;
                    f.a(inputStream);
                    f.a((OutputStream) byteArrayOutputStream);
                    f.a((InputStream) byteArrayInputStream2);
                    throw th;
                }
                return getFilesBksIS(a2);
            } else {
                g.b(a, "hms sign error");
                return null;
            }
        }
    }

    public static InputStream getFilesBksIS(Context context) {
        if (!c(context)) {
            return null;
        }
        g.c(a, "getFilesBksIS ");
        try {
            return new FileInputStream(b(context));
        } catch (FileNotFoundException unused) {
            g.b(a, "FileNotFoundExceptio: ");
            return null;
        }
    }

    private static boolean b(String str) {
        int i2;
        int i3;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        g.c(a, "hms version code is : " + str);
        String[] split = str.split("\\.");
        String[] split2 = h.split("\\.");
        int length = split.length;
        int length2 = split2.length;
        int max = Math.max(length, length2);
        for (int i4 = 0; i4 < max; i4++) {
            if (i4 < length) {
                try {
                    i2 = Integer.parseInt(split[i4]);
                } catch (Exception e2) {
                    g.b(a, " exception : " + e2.getMessage());
                    if (i4 >= length2) {
                        return true;
                    }
                    return false;
                }
            } else {
                i2 = 0;
            }
            if (i4 < length2) {
                i3 = Integer.parseInt(split2[i4]);
            } else {
                i3 = 0;
            }
            if (i2 < i3) {
                return false;
            }
            if (i2 > i3) {
                return true;
            }
        }
        return true;
    }

    private static boolean c(Context context, String str) {
        byte[] a2 = a(context, str);
        for (String str2 : p) {
            if (str2.equalsIgnoreCase(c(a2))) {
                return true;
            }
        }
        return false;
    }

    private static String c(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            return a(MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256).digest(bArr));
        } catch (NoSuchAlgorithmException e2) {
            Log.e(a, "NoSuchAlgorithmException" + e2.getMessage());
            return "";
        }
    }

    private static boolean b(Context context, String str) {
        return o.equalsIgnoreCase(c(a(context, str)));
    }

    private static String b(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
            instance.update(bArr);
            return a(instance.digest());
        } catch (NoSuchAlgorithmException unused) {
            g.b(a, "inputstraem exception");
            return "";
        }
    }

    private static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        File file = new File(str);
        if (file.exists()) {
            g.e(a, "The directory  has already exists");
            return 1;
        } else if (file.mkdirs()) {
            g.a(a, "create directory  success");
            return 0;
        } else {
            g.b(a, "create directory  failed");
            return -1;
        }
    }

    private static String a(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return context.createDeviceProtectedStorageContext().getFilesDir() + File.separator + i;
        }
        return context.getApplicationContext().getFilesDir() + File.separator + i;
    }

    private static byte[] a(Context context, String str) {
        PackageInfo packageInfo;
        if (context == null || TextUtils.isEmpty(str)) {
            Log.e(a, "packageName is null or context is null");
            return new byte[0];
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (!(packageManager == null || (packageInfo = packageManager.getPackageInfo(str, 64)) == null)) {
                return packageInfo.signatures[0].toByteArray();
            }
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e(a, "PackageManager.NameNotFoundException : " + e2.getMessage());
        } catch (Exception e3) {
            Log.e(a, "get pm exception : " + e3.getMessage());
        }
        return new byte[0];
    }

    private static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                sb.append(YKUpsConvert.CHAR_ZERO);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }
}
