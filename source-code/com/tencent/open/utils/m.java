package com.tencent.open.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import androidx.core.content.FileProvider;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.youku.live.livesdk.monitor.performance.YoukuLivePerformanceConstants;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class m {
    private static String a = "";
    private static String b = "";
    private static String c = "";
    private static String d = "";
    private static int e = -1;
    private static String f = "0123456789ABCDEF";

    private static char a(int i) {
        int i2 = i & 15;
        return (char) (i2 < 10 ? i2 + 48 : (i2 - 10) + 97);
    }

    public static Bundle a(String str) {
        Bundle bundle = new Bundle();
        if (str == null) {
            return bundle;
        }
        try {
            for (String str2 : str.split("&")) {
                String[] a2 = a(str2, "=");
                if (a2.length == 2) {
                    bundle.putString(URLDecoder.decode(a2[0]), URLDecoder.decode(a2[1]));
                }
            }
            return bundle;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Bundle b(String str) {
        try {
            URL url = new URL(str.replace("auth://", "http://"));
            Bundle a2 = a(url.getQuery());
            a2.putAll(a(url.getRef()));
            return a2;
        } catch (MalformedURLException unused) {
            return new Bundle();
        }
    }

    public static JSONObject c(String str) {
        try {
            URL url = new URL(str.replace("auth://", "http://"));
            JSONObject a2 = a((JSONObject) null, url.getQuery());
            a(a2, url.getRef());
            return a2;
        } catch (MalformedURLException unused) {
            return new JSONObject();
        }
    }

    public static JSONObject d(String str) throws JSONException {
        if (str.equals("false")) {
            str = "{value : false}";
        }
        if (str.equals("true")) {
            str = "{value : true}";
        }
        if (str.contains("allback(")) {
            str = str.replaceFirst("[\\s\\S]*allback\\(([\\s\\S]*)\\);[^\\)]*\\z", "$1").trim();
        }
        if (str.contains("online[0]=")) {
            str = "{online:" + str.charAt(str.length() - 2) + "}";
        }
        return new JSONObject(str);
    }

    public static boolean e(String str) {
        return str == null || str.length() == 0;
    }

    public static String f(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            SLog.e("openSDK_LOG.Util", "urlEncode: UnsupportedEncodingException", e2);
            return "";
        }
    }

    private static boolean g(Context context) {
        Signature[] signatureArr;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.tencent.mtt", 64);
            String str = packageInfo.versionName;
            if (k.a(str, "4.3") >= 0 && !str.startsWith("4.4") && (signatureArr = packageInfo.signatures) != null) {
                try {
                    MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
                    instance.update(signatureArr[0].toByteArray());
                    String a2 = a(instance.digest());
                    instance.reset();
                    if (a2.equals("d8391a394d4a179e6fe7bdb8a301258b")) {
                        return true;
                    }
                } catch (NoSuchAlgorithmException e2) {
                    SLog.e("openSDK_LOG.Util", "isQQBrowerAvailable has exception: " + e2.getMessage());
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static final boolean h(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith("http://") || str.startsWith("https://");
    }

    public static boolean i(String str) {
        if (str != null && new File(str).exists()) {
            return true;
        }
        return false;
    }

    public static byte[] j(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e2) {
            SLog.e("openSDK_LOG.Util", "getBytesUTF8: UnsupportedEncodingException", e2);
            return new byte[0];
        }
    }

    public static String k(String str) {
        return a(str, 2);
    }

    public static File l(String str) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            if (file.getParentFile() == null || file.getParentFile().exists()) {
                file.createNewFile();
            } else if (file.getParentFile().mkdirs()) {
                file.createNewFile();
            } else {
                SLog.d("openSDK_LOG.Util", "createFile failed" + str);
            }
        }
        return file;
    }

    public static boolean m(String str) {
        String b2 = b();
        return !TextUtils.isEmpty(str) && !TextUtils.isEmpty(b2) && str.contains(b2);
    }

    public static String e(Context context, String str) {
        if (context == null) {
            return "";
        }
        String d2 = d(context, str);
        c = d2;
        return d2;
    }

    public static File h(Context context, String str) {
        if (context == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 19) {
            return context.getExternalFilesDir(str);
        }
        File[] externalFilesDirs = context.getExternalFilesDirs(str);
        if (externalFilesDirs == null || externalFilesDirs.length <= 0) {
            return null;
        }
        return externalFilesDirs[0];
    }

    public static boolean e(Context context) {
        return k.c(context, "8.1.8") >= 0;
    }

    public static boolean f(Context context, String str) {
        boolean z = true;
        boolean z2 = !c(context) || k.a(context, Constants.PACKAGE_QQ_PAD) == null;
        if (z2 && k.a(context, Constants.PACKAGE_TIM) != null) {
            z2 = false;
        }
        if (!z2) {
            return z2;
        }
        if (k.c(context, str) >= 0) {
            z = false;
        }
        return z;
    }

    private static boolean i(Context context, String str) {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        try {
            if (context.checkSelfPermission(str) != 0) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.Util", "checkSelfPermission exception", e2);
            return false;
        }
    }

    public static boolean b(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || i(context, "android.permission.ACCESS_NETWORK_STATE") || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return true;
        }
        NetworkInfo[] networkInfoArr = null;
        try {
            networkInfoArr = connectivityManager.getAllNetworkInfo();
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.Util", "Util.isNetWorkAvailable has exception: ", e2);
        }
        if (!(networkInfoArr == null || networkInfoArr.length == 0)) {
            for (NetworkInfo networkInfo : networkInfoArr) {
                if (networkInfo.isConnectedOrConnecting()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String c(Context context, String str) {
        if (context == null) {
            return "";
        }
        b(context, str);
        return b;
    }

    public static boolean f(Context context) {
        return k.c(context, "5.9.5") >= 0;
    }

    public static String[] a(String str, String str2) {
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            return new String[]{str};
        }
        return new String[]{str.substring(0, indexOf), str.substring(indexOf + str2.length())};
    }

    public static boolean c(Context context) {
        double d2;
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            d2 = Math.sqrt(Math.pow((double) (((float) com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics)) / displayMetrics.xdpi), 2.0d) + Math.pow((double) (((float) com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics)) / displayMetrics.ydpi), 2.0d));
        } catch (Throwable unused) {
            d2 = 0.0d;
        }
        return d2 > 6.5d;
    }

    public static String d(Context context, String str) {
        if (context == null) {
            return "";
        }
        b(context, str);
        return a;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0031 */
    public static JSONObject a(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (str != null) {
            for (String str2 : str.split("&")) {
                String[] split = str2.split("=");
                if (split.length == 2) {
                    split[0] = URLDecoder.decode(split[0]);
                    split[1] = URLDecoder.decode(split[1]);
                    try {
                        jSONObject.put(split[0], split[1]);
                    } catch (JSONException e2) {
                        SLog.e("openSDK_LOG.Util", "decodeUrlToJson has exception: " + e2.getMessage());
                    }
                }
            }
        }
        return jSONObject;
    }

    public static boolean d(Context context) {
        return k.c(context, "8.1.5") >= 0;
    }

    public static String g(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(j(str));
            byte[] digest = instance.digest();
            if (digest == null) {
                return str;
            }
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                sb.append(a(b2 >>> 4));
                sb.append(a(b2));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e2) {
            SLog.e("openSDK_LOG.Util", "encrypt has exception: " + e2.getMessage());
            return str;
        }
    }

    public static void b(Context context, String str) {
        if (context != null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
                String str2 = packageInfo.versionName;
                b = str2;
                a = str2.substring(0, str2.lastIndexOf(46));
                String str3 = b;
                d = str3.substring(str3.lastIndexOf(46) + 1, b.length());
                e = packageInfo.versionCode;
            } catch (PackageManager.NameNotFoundException e2) {
                SLog.e("openSDK_LOG.Util", "getPackageInfo has exception: " + e2.getMessage());
            } catch (Exception e3) {
                SLog.e("openSDK_LOG.Util", "getPackageInfo has exception: " + e3.getMessage());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x01e1 A[SYNTHETIC, Splitter:B:101:0x01e1] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01fe A[SYNTHETIC, Splitter:B:106:0x01fe] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0068 A[Catch:{ Exception -> 0x013d, all -> 0x0139 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x016a A[SYNTHETIC, Splitter:B:78:0x016a] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0187 A[SYNTHETIC, Splitter:B:83:0x0187] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01a4 A[SYNTHETIC, Splitter:B:88:0x01a4] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01c4 A[SYNTHETIC, Splitter:B:96:0x01c4] */
    public static String c(Context context, Uri uri) {
        Cursor cursor;
        Exception e2;
        FileOutputStream fileOutputStream;
        Throwable th;
        ParcelFileDescriptor parcelFileDescriptor;
        FileInputStream fileInputStream;
        Exception e3;
        File h;
        FileInputStream fileInputStream2 = null;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        return cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    SLog.e("openSDK_LOG.Util", "queryAbsolutePath error : " + e2.getMessage());
                    if (cursor != null) {
                    }
                    try {
                        parcelFileDescriptor = context.getContentResolver().openFileDescriptor(uri, UploadQueueMgr.MSGTYPE_REALTIME);
                        try {
                            fileInputStream = new FileInputStream(parcelFileDescriptor.getFileDescriptor());
                        } catch (Exception e5) {
                            e3 = e5;
                            fileOutputStream = null;
                            fileInputStream = null;
                            try {
                                SLog.e("openSDK_LOG.Util", "copy file from uri error : " + e3.getMessage());
                                if (fileInputStream != null) {
                                }
                                if (fileOutputStream != null) {
                                }
                                if (parcelFileDescriptor != null) {
                                }
                                return null;
                            } catch (Throwable th2) {
                                th = th2;
                                fileInputStream2 = fileInputStream;
                                if (fileInputStream2 != null) {
                                    try {
                                        fileInputStream2.close();
                                    } catch (IOException e6) {
                                        SLog.e("openSDK_LOG.Util", "close fileIuputStream error" + e6.getMessage());
                                    }
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e7) {
                                        SLog.e("openSDK_LOG.Util", "close fileOutputStream error" + e7.getMessage());
                                    }
                                }
                                if (parcelFileDescriptor != null) {
                                    try {
                                        parcelFileDescriptor.close();
                                    } catch (IOException e8) {
                                        SLog.e("openSDK_LOG.Util", "close ParcelFileDescriptor error" + e8.getMessage());
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fileOutputStream = null;
                            if (fileInputStream2 != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            if (parcelFileDescriptor != null) {
                            }
                            throw th;
                        }
                    } catch (Exception e9) {
                        e3 = e9;
                        fileOutputStream = null;
                        parcelFileDescriptor = null;
                        fileInputStream = null;
                        SLog.e("openSDK_LOG.Util", "copy file from uri error : " + e3.getMessage());
                        if (fileInputStream != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        if (parcelFileDescriptor != null) {
                        }
                        return null;
                    } catch (Throwable th4) {
                        th = th4;
                        fileOutputStream = null;
                        parcelFileDescriptor = null;
                        if (fileInputStream2 != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        if (parcelFileDescriptor != null) {
                        }
                        throw th;
                    }
                    try {
                        h = h(context, "Images");
                        if (h != null) {
                        }
                    } catch (Exception e10) {
                        e3 = e10;
                        fileOutputStream = null;
                        SLog.e("openSDK_LOG.Util", "copy file from uri error : " + e3.getMessage());
                        if (fileInputStream != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        if (parcelFileDescriptor != null) {
                        }
                        return null;
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream = null;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        if (parcelFileDescriptor != null) {
                        }
                        throw th;
                    }
                }
            }
            return null;
        } catch (Exception e11) {
            e2 = e11;
            cursor = null;
            SLog.e("openSDK_LOG.Util", "queryAbsolutePath error : " + e2.getMessage());
            if (cursor != null) {
                cursor.close();
            }
            parcelFileDescriptor = context.getContentResolver().openFileDescriptor(uri, UploadQueueMgr.MSGTYPE_REALTIME);
            fileInputStream = new FileInputStream(parcelFileDescriptor.getFileDescriptor());
            h = h(context, "Images");
            if (h != null) {
                SLog.e("openSDK_LOG.Util", "getExternalFilesDir return null");
                try {
                    fileInputStream.close();
                } catch (IOException e12) {
                    SLog.e("openSDK_LOG.Util", "close fileIuputStream error" + e12.getMessage());
                }
                try {
                    parcelFileDescriptor.close();
                } catch (IOException e13) {
                    SLog.e("openSDK_LOG.Util", "close ParcelFileDescriptor error" + e13.getMessage());
                }
                return null;
            }
            if (!h.exists()) {
                h.mkdirs();
            }
            File file = new File(h, uri.getLastPathSegment());
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream2.write(bArr, 0, read);
                }
                fileOutputStream2.flush();
                String absolutePath = file.getAbsolutePath();
                try {
                    fileInputStream.close();
                } catch (IOException e14) {
                    SLog.e("openSDK_LOG.Util", "close fileIuputStream error" + e14.getMessage());
                }
                try {
                    fileOutputStream2.close();
                } catch (IOException e15) {
                    SLog.e("openSDK_LOG.Util", "close fileOutputStream error" + e15.getMessage());
                }
                try {
                    parcelFileDescriptor.close();
                } catch (IOException e16) {
                    SLog.e("openSDK_LOG.Util", "close ParcelFileDescriptor error" + e16.getMessage());
                }
                return absolutePath;
            } catch (Exception e17) {
                fileOutputStream = fileOutputStream2;
                e3 = e17;
                SLog.e("openSDK_LOG.Util", "copy file from uri error : " + e3.getMessage());
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e18) {
                        SLog.e("openSDK_LOG.Util", "close fileIuputStream error" + e18.getMessage());
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e19) {
                        SLog.e("openSDK_LOG.Util", "close fileOutputStream error" + e19.getMessage());
                    }
                }
                if (parcelFileDescriptor != null) {
                    try {
                        parcelFileDescriptor.close();
                    } catch (IOException e20) {
                        SLog.e("openSDK_LOG.Util", "close ParcelFileDescriptor error" + e20.getMessage());
                    }
                }
                return null;
            } catch (Throwable th6) {
                fileInputStream2 = fileInputStream;
                fileOutputStream = fileOutputStream2;
                th = th6;
                if (fileInputStream2 != null) {
                }
                if (fileOutputStream != null) {
                }
                if (parcelFileDescriptor != null) {
                }
                throw th;
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:22|23|24|25|28) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:14|15|16|17|18|19|33) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002e, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0038, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        return true;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0026 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x002a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x0033 */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0022 A[SYNTHETIC, Splitter:B:14:0x0022] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x002f A[SYNTHETIC, Splitter:B:22:0x002f] */
    public static boolean a(Context context, String str) {
        boolean z;
        try {
            z = g(context);
            if (z) {
                try {
                    a(context, "com.tencent.mtt", "com.tencent.mtt.MainActivity", str);
                    return true;
                } catch (Exception unused) {
                    if (!z) {
                    }
                }
            } else {
                a(context, "com.android.browser", "com.android.browser.BrowserActivity", str);
                return true;
            }
        } catch (Exception unused2) {
            z = false;
            if (!z) {
                a(context, "com.android.browser", "com.android.browser.BrowserActivity", str);
                a(context, "com.google.android.browser", "com.android.browser.BrowserActivity", str);
                a(context, "com.android.chrome", "com.google.android.apps.chrome.Main", str);
                return true;
            }
            a(context, "com.google.android.browser", "com.android.browser.BrowserActivity", str);
            a(context, "com.android.chrome", "com.google.android.apps.chrome.Main", str);
            return true;
        }
    }

    @SuppressLint({"NewApi"})
    public static String b(Context context, Uri uri) {
        Uri uri2;
        if (uri == null) {
            return null;
        }
        if (!(Build.VERSION.SDK_INT >= 19) || !DocumentsContract.isDocumentUri(context, uri)) {
            String scheme = uri.getScheme();
            if ("content".equals(scheme)) {
                return c(context, uri);
            }
            if ("file".equals(scheme)) {
                return uri.getPath();
            }
            return null;
        }
        String authority = uri.getAuthority();
        if ("com.android.externalstorage.documents".equals(authority)) {
            String[] split = DocumentsContract.getDocumentId(uri).split(":");
            String str = split[0];
            if ("primary".equals(str)) {
                return Environment.getExternalStorageDirectory().getAbsolutePath().concat("/").concat(split[1]);
            }
            return "/storage/".concat(str).concat("/").concat(split[1]);
        } else if ("com.android.providers.downloads.documents".equals(authority)) {
            String documentId = DocumentsContract.getDocumentId(uri);
            if (documentId.startsWith("raw:")) {
                return documentId.replaceFirst("raw:", "");
            }
            return c(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.parseLong(documentId)));
        } else {
            if ("com.android.providers.media.documents".equals(authority)) {
                String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                String str2 = split2[0];
                if ("image".equals(str2)) {
                    uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(str2)) {
                    uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(str2)) {
                    uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                return c(context, ContentUris.withAppendedId(uri2, Long.parseLong(split2[1])));
            }
            return null;
        }
    }

    public static boolean g(Context context, String str) {
        boolean z = false;
        boolean z2 = !c(context) || k.a(context, Constants.PACKAGE_QQ_PAD) == null;
        if (!z2) {
            return z2;
        }
        if (k.c(context, str) < 0) {
            z = true;
        }
        return z;
    }

    private static void a(Context context, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str, str2));
        intent.setAction("android.intent.action.VIEW");
        intent.addFlags(1073741824);
        intent.addFlags(268435456);
        intent.setData(Uri.parse(str3));
        context.startActivity(intent);
    }

    public static boolean a() {
        return (Environment.getExternalStorageState().equals("mounted") ? Environment.getExternalStorageDirectory() : null) != null;
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            String num = Integer.toString(b2 & 255, 16);
            if (num.length() == 1) {
                num = "0" + num;
            }
            sb.append(num);
        }
        return sb.toString();
    }

    public static final String a(Context context) {
        CharSequence applicationLabel;
        if (context == null || (applicationLabel = context.getPackageManager().getApplicationLabel(context.getApplicationInfo())) == null) {
            return null;
        }
        return applicationLabel.toString();
    }

    public static final String a(String str, int i, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "UTF-8";
        }
        try {
            if (str.getBytes(str2).length <= i) {
                return str;
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < str.length()) {
                int i4 = i2 + 1;
                i3 += str.substring(i2, i4).getBytes(str2).length;
                if (i3 > i) {
                    String substring = str.substring(0, i2);
                    if (TextUtils.isEmpty(str3)) {
                        return substring;
                    }
                    return substring + str3;
                }
                i2 = i4;
            }
            return str;
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.Util", "Util.subString has exception: " + e2.getMessage());
            return str;
        }
    }

    public static String b() {
        File e2 = g.e();
        if (e2 == null) {
            return null;
        }
        if (!e2.exists()) {
            e2.mkdirs();
        }
        return e2.toString();
    }

    public static Bundle a(String str, String str2, String str3, String str4, String str5, String str6) {
        return a(str, str3, str4, str2, str5, str6, "", "", "", "", "", "");
    }

    public static Bundle a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        Bundle bundle = new Bundle();
        bundle.putString("openid", str);
        bundle.putString(YoukuLivePerformanceConstants.DIM_REPORT_TYPE, str2);
        bundle.putString("act_type", str3);
        bundle.putString("via", str4);
        bundle.putString("app_id", str5);
        bundle.putString("result", str6);
        bundle.putString("type", str7);
        bundle.putString("login_status", str8);
        bundle.putString("need_user_auth", str9);
        bundle.putString("to_uin", str10);
        bundle.putString("call_source", str11);
        bundle.putString("to_type", str12);
        bundle.putString("platform", "1");
        return bundle;
    }

    public static boolean b(String str, String str2) {
        File file = new File(str);
        if (file.exists()) {
            try {
                return a(file, l(str2));
            } catch (IOException e2) {
                SLog.d("openSDK_LOG.Util", "copy fail from " + str + " to " + str2 + " ", e2);
            }
        }
        return false;
    }

    public static boolean c() {
        Context a2 = g.a();
        if (a2 == null || a2.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", a2.getPackageName()) != 0) {
            return false;
        }
        return true;
    }

    public static boolean a(Context context, boolean z) {
        if ((!c(context) || k.a(context, Constants.PACKAGE_QQ_PAD) == null) && k.c(context, "4.1") < 0 && k.a(context, Constants.PACKAGE_TIM) == null) {
            return false;
        }
        return true;
    }

    public static long a(Context context, Uri uri) {
        Cursor query = context.getContentResolver().query(uri, new String[]{"_size"}, null, null, null);
        long j = 0;
        if (query == null || query.getCount() == 0) {
            return 0;
        }
        try {
            int columnIndexOrThrow = query.getColumnIndexOrThrow("_size");
            if (query.moveToFirst()) {
                j = query.getLong(columnIndexOrThrow);
            }
            try {
                query.close();
            } catch (Exception e2) {
                SLog.e("openSDK_LOG.Util", "cursor exception", e2);
            }
        } catch (Exception e3) {
            SLog.e("openSDK_LOG.Util", "cursor exception", e3);
            query.close();
        } catch (Throwable th) {
            try {
                query.close();
            } catch (Exception e4) {
                SLog.e("openSDK_LOG.Util", "cursor exception", e4);
            }
            throw th;
        }
        return j;
    }

    public static String a(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Base64.encodeToString(str.getBytes("UTF-8"), i);
            } catch (UnsupportedEncodingException e2) {
                SLog.e("openSDK_LOG.Util", "convert2Base64String exception: " + e2.getMessage());
            }
        }
        return "";
    }

    public static Drawable a(String str, Context context) {
        Throwable th;
        InputStream inputStream;
        IOException e2;
        StringBuilder sb;
        InputStream inputStream2 = null;
        r1 = null;
        Drawable drawable = null;
        if (context == null) {
            SLog.e("openSDK_LOG.Util", "context null!");
            return null;
        }
        try {
            inputStream = context.getAssets().open(str);
            try {
                drawable = Drawable.createFromStream(inputStream, str);
                try {
                    inputStream.close();
                } catch (Exception e3) {
                    e = e3;
                    sb = new StringBuilder();
                }
            } catch (IOException e4) {
                e2 = e4;
                try {
                    SLog.e("openSDK_LOG.Util", "getDrawable exception: " + e2.getMessage());
                    try {
                        inputStream.close();
                    } catch (Exception e5) {
                        e = e5;
                        sb = new StringBuilder();
                    }
                    return drawable;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream2 = inputStream;
                    try {
                        inputStream2.close();
                    } catch (Exception e6) {
                        SLog.e("openSDK_LOG.Util", "inputStream close exception: " + e6.getMessage());
                    }
                    throw th;
                }
            }
        } catch (IOException e7) {
            e2 = e7;
            inputStream = null;
            SLog.e("openSDK_LOG.Util", "getDrawable exception: " + e2.getMessage());
            inputStream.close();
            return drawable;
        } catch (Throwable th3) {
            th = th3;
            inputStream2.close();
            throw th;
        }
        return drawable;
        sb.append("inputStream close exception: ");
        sb.append(e.getMessage());
        SLog.e("openSDK_LOG.Util", sb.toString());
        return drawable;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0076 A[SYNTHETIC, Splitter:B:47:0x0076] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x008b A[SYNTHETIC, Splitter:B:57:0x008b] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x009c A[SYNTHETIC, Splitter:B:66:0x009c] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00a6 A[SYNTHETIC, Splitter:B:71:0x00a6] */
    public static boolean a(File file, File file2) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        IOException e2;
        OutOfMemoryError e3;
        boolean z = false;
        FileOutputStream fileOutputStream = null;
        try {
            if (file2.exists()) {
                file2.delete();
            }
            if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                file2.getParentFile().mkdirs();
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            } catch (IOException e4) {
                e2 = e4;
                bufferedInputStream = null;
                fileOutputStream = fileOutputStream2;
                SLog.e("openSDK_LOG.Util", "copyFile error, ", e2);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e5) {
                        SLog.e("openSDK_LOG.Util", "copyFile error, ", e5);
                    }
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                return z;
            } catch (OutOfMemoryError e6) {
                e3 = e6;
                bufferedInputStream = null;
                fileOutputStream = fileOutputStream2;
                try {
                    SLog.e("openSDK_LOG.Util", "copyFile error, ", e3);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e7) {
                            SLog.e("openSDK_LOG.Util", "copyFile error, ", e7);
                        }
                    }
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                    }
                    if (bufferedInputStream != null) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = null;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e8) {
                        SLog.e("openSDK_LOG.Util", "copyFile error, ", e8);
                    }
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e9) {
                        SLog.e("openSDK_LOG.Util", "copyFile error, ", e9);
                    }
                }
                throw th;
            }
            try {
                byte[] bArr = new byte[102400];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream2.write(bArr, 0, read);
                    fileOutputStream2.flush();
                }
                z = true;
                try {
                    fileOutputStream2.close();
                } catch (IOException e10) {
                    SLog.e("openSDK_LOG.Util", "copyFile error, ", e10);
                }
                try {
                    bufferedInputStream.close();
                } catch (IOException e11) {
                    SLog.e("openSDK_LOG.Util", "copyFile error, ", e11);
                }
            } catch (IOException e12) {
                e2 = e12;
                fileOutputStream = fileOutputStream2;
                SLog.e("openSDK_LOG.Util", "copyFile error, ", e2);
                if (fileOutputStream != null) {
                }
                if (bufferedInputStream != null) {
                }
                return z;
            } catch (OutOfMemoryError e13) {
                e3 = e13;
                fileOutputStream = fileOutputStream2;
                SLog.e("openSDK_LOG.Util", "copyFile error, ", e3);
                if (fileOutputStream != null) {
                }
                if (bufferedInputStream != null) {
                }
                return z;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                }
                if (bufferedInputStream != null) {
                }
                throw th;
            }
        } catch (IOException e14) {
            e2 = e14;
            bufferedInputStream = null;
            SLog.e("openSDK_LOG.Util", "copyFile error, ", e2);
            if (fileOutputStream != null) {
            }
            if (bufferedInputStream != null) {
            }
            return z;
        } catch (OutOfMemoryError e15) {
            e3 = e15;
            bufferedInputStream = null;
            SLog.e("openSDK_LOG.Util", "copyFile error, ", e3);
            if (fileOutputStream != null) {
            }
            if (bufferedInputStream != null) {
            }
            return z;
        } catch (Throwable th5) {
            th = th5;
            bufferedInputStream = null;
            if (fileOutputStream != null) {
            }
            if (bufferedInputStream != null) {
            }
            throw th;
        }
        return z;
    }

    public static boolean a(Context context, String str, String str2) {
        boolean z;
        if (Build.VERSION.SDK_INT < 19) {
            z = context.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", context.getPackageName()) == 0 ? b(str, str2) : false;
        } else {
            z = b(str, str2);
        }
        SLog.i("openSDK_LOG.Util", "copyFileByCheckPermission() copy success:" + z);
        return z;
    }

    public static String a(String str, Activity activity, String str2, IUiListener iUiListener) {
        String str3;
        try {
            boolean m = m(str2);
            SLog.i("openSDK_LOG.Util", "doPublishMood() check file: isAppSpecificDir=" + m + ",hasSDPermission=" + c());
            if (!m) {
                File a2 = g.a("Images");
                if (a2 != null) {
                    str3 = a2.getAbsolutePath() + File.separator + Constants.QQ_SHARE_TEMP_DIR;
                } else {
                    File cacheDir = g.a().getCacheDir();
                    if (cacheDir == null) {
                        SLog.e("openSDK_LOG.Util", "getMediaFileUri error, cacheDir is null");
                        return null;
                    }
                    str3 = cacheDir.getAbsolutePath() + File.separator + Constants.QQ_SHARE_TEMP_DIR;
                }
                File file = new File(str2);
                String absolutePath = file.getAbsolutePath();
                String str4 = str3 + File.separator + file.getName();
                str2 = b(absolutePath, str4) ? str4 : null;
            }
            Uri a3 = a(activity, str, str2);
            if (a3 == null) {
                return null;
            }
            return a3.toString();
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.Util", "getMediaFileUri error", e2);
            return null;
        }
    }

    public static boolean a(Map<String, Object> map, String str, boolean z) {
        if (map == null) {
            SLog.e("openSDK_LOG.Util", "getBoolean error, params==null");
            return z;
        } else if (!map.containsKey(str)) {
            SLog.e("openSDK_LOG.Util", "getBoolean error, not comtain : " + str);
            return z;
        } else {
            Object obj = map.get(str);
            return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
        }
    }

    public static String a(Map<String, Object> map, String str, String str2) {
        if (map == null) {
            SLog.e("openSDK_LOG.Util", "getString error, params==null");
            return str2;
        } else if (!map.containsKey(str)) {
            SLog.e("openSDK_LOG.Util", "getString error, not comtain : " + str);
            return str2;
        } else {
            Object obj = map.get(str);
            return obj instanceof String ? (String) obj : str2;
        }
    }

    public static Uri a(Activity activity, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            SLog.e("openSDK_LOG.Util", "grantUriPermissionToAllQQVersion -- stringForFileUri is empty");
            return null;
        }
        try {
            String authorities = Tencent.getAuthorities(str);
            if (TextUtils.isEmpty(authorities)) {
                return null;
            }
            Uri uriForFile = FileProvider.getUriForFile(activity, authorities, new File(str2));
            activity.grantUriPermission("com.tencent.mobileqq", uriForFile, 3);
            activity.grantUriPermission(Constants.PACKAGE_TIM, uriForFile, 3);
            activity.grantUriPermission(Constants.PACKAGE_QQ_PAD, uriForFile, 3);
            activity.grantUriPermission(Constants.PACKAGE_QQ_SPEED, uriForFile, 3);
            return uriForFile;
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.Util", "grantUriPermissionToAllQQVersion exception:", e2);
            return null;
        }
    }
}
