package cn.damai.common.util;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import tb.xs0;

/* compiled from: Taobao */
public class a {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String a = "a";

    public a(Context context) {
        if (context == null) {
            Log.i(a, "context is null");
        }
    }

    public static boolean a(byte[] bArr, File file) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1880528642")) {
            return ((Boolean) ipChange.ipc$dispatch("1880528642", new Object[]{bArr, file})).booleanValue();
        } else if (bArr == null || file == null) {
            return false;
        } else {
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(bArr);
                    fileOutputStream2.flush();
                    b(fileOutputStream2);
                    return true;
                } catch (Throwable unused) {
                    fileOutputStream = fileOutputStream2;
                    b(fileOutputStream);
                    return false;
                }
            } catch (Throwable unused2) {
                b(fileOutputStream);
                return false;
            }
        }
    }

    public static boolean b(Closeable closeable) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1043743740")) {
            return ((Boolean) ipChange.ipc$dispatch("1043743740", new Object[]{closeable})).booleanValue();
        }
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                Log.w("StackTrace", e);
                return false;
            }
        } else {
            z = false;
        }
        return z;
    }

    public static boolean c(InputStream inputStream, OutputStream outputStream) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1992562945")) {
            return ((Boolean) ipChange.ipc$dispatch("-1992562945", new Object[]{inputStream, outputStream})).booleanValue();
        } else if (inputStream == null || outputStream == null) {
            return false;
        } else {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read > 0) {
                    outputStream.write(bArr, 0, read);
                } else {
                    outputStream.flush();
                    return true;
                }
            }
        }
    }

    public static File d(String str) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2035695844")) {
            return (File) ipChange.ipc$dispatch("-2035695844", new Object[]{str});
        }
        File file = new File(str);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
        }
        return file;
    }

    public static boolean e(File file) {
        File[] listFiles;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1514596623")) {
            return ((Boolean) ipChange.ipc$dispatch("1514596623", new Object[]{file})).booleanValue();
        } else if (file == null || !file.exists()) {
            return true;
        } else {
            if (file.isFile()) {
                return file.delete();
            }
            for (File file2 : file.listFiles()) {
                z |= e(file2);
            }
            return file.delete() | z;
        }
    }

    public static boolean f(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1526013794")) {
            return ((Boolean) ipChange.ipc$dispatch("1526013794", new Object[]{str})).booleanValue();
        } else if (TextUtils.isEmpty(str)) {
            return false;
        } else {
            return e(new File(str));
        }
    }

    public static boolean g(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1312586065")) {
            return ((Boolean) ipChange.ipc$dispatch("1312586065", new Object[]{str})).booleanValue();
        } else if (TextUtils.isEmpty(str)) {
            return false;
        } else {
            return new File(str).exists();
        }
    }

    public static byte[] h(File file) {
        FileInputStream fileInputStream;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1282481734")) {
            return (byte[]) ipChange.ipc$dispatch("1282481734", new Object[]{file});
        }
        byte[] bArr = null;
        if (file != null && file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    bArr = v(fileInputStream);
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                fileInputStream = null;
            }
            b(fileInputStream);
        }
        return bArr;
    }

    public static Bitmap i(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1438868334")) {
            return (Bitmap) ipChange.ipc$dispatch("1438868334", new Object[]{str});
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inSampleSize = 2;
        return BitmapFactory.decodeFile(str, options);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0049, code lost:
        if (r8 != null) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0053, code lost:
        if (r8 != null) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0055, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0058, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005d  */
    public static String j(Context context, Uri uri, String str, String[] strArr) {
        Throwable th;
        Cursor cursor;
        Exception e;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-513714273")) {
            return (String) ipChange.ipc$dispatch("-513714273", new Object[]{context, uri, str, strArr});
        }
        Cursor cursor2 = null;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                        cursor.close();
                        return string;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        e.printStackTrace();
                    } catch (Throwable th2) {
                        th = th2;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                }
            }
        } catch (Exception e3) {
            e = e3;
            cursor = null;
            e.printStackTrace();
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    public static final String k(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1198707976")) {
            return (String) ipChange.ipc$dispatch("1198707976", new Object[]{str});
        } else if (TextUtils.isEmpty(str)) {
            return null;
        } else {
            int lastIndexOf = str.lastIndexOf("/");
            return (lastIndexOf <= 0 || lastIndexOf >= str.length() - 1) ? str : str.substring(lastIndexOf + 1, str.length());
        }
    }

    public static String l(Context context, Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-406394080")) {
            return (String) ipChange.ipc$dispatch("-406394080", new Object[]{context, uri});
        }
        Uri uri2 = null;
        if (Build.VERSION.SDK_INT < 19 || !DocumentsContract.isDocumentUri(context, uri)) {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                return j(context, uri, null, null);
            }
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        } else if (q(uri)) {
            String[] split = DocumentsContract.getDocumentId(uri).split(":");
            if ("primary".equalsIgnoreCase(split[0])) {
                return context.getExternalCacheDir() + "/" + split[1];
            }
        } else if (o(uri)) {
            return j(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
        } else if (s(uri)) {
            String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
            String str = split2[0];
            if ("image".equals(str)) {
                uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else if ("video".equals(str)) {
                uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else if ("audio".equals(str)) {
                uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }
            return j(context, uri2, "_id=?", new String[]{split2[1]});
        }
        return null;
    }

    public static String m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2133642143")) {
            return (String) ipChange.ipc$dispatch("-2133642143", new Object[0]);
        }
        if (!p() || xs0.a() == null) {
            return null;
        }
        return xs0.a().getExternalCacheDir().toString();
    }

    public static String n(InputStream inputStream) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1175263221")) {
            return (String) ipChange.ipc$dispatch("1175263221", new Object[]{inputStream});
        } else if (inputStream == null) {
            return null;
        } else {
            String str = new String(v(inputStream));
            b(inputStream);
            return str;
        }
    }

    public static boolean o(Uri uri) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1161139900")) {
            return "com.android.providers.downloads.documents".equals(uri.getAuthority());
        }
        return ((Boolean) ipChange.ipc$dispatch("1161139900", new Object[]{uri})).booleanValue();
    }

    public static boolean p() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1727029120")) {
            return ((Boolean) ipChange.ipc$dispatch("-1727029120", new Object[0])).booleanValue();
        }
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static boolean q(Uri uri) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2102298495")) {
            return "com.android.externalstorage.documents".equals(uri.getAuthority());
        }
        return ((Boolean) ipChange.ipc$dispatch("-2102298495", new Object[]{uri})).booleanValue();
    }

    public static final boolean r(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1918664309")) {
            return ((Boolean) ipChange.ipc$dispatch("1918664309", new Object[]{str})).booleanValue();
        } else if (!g(str)) {
            return false;
        } else {
            return new File(str).isDirectory();
        }
    }

    public static boolean s(Uri uri) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "492047925")) {
            return "com.android.providers.media.documents".equals(uri.getAuthority());
        }
        return ((Boolean) ipChange.ipc$dispatch("492047925", new Object[]{uri})).booleanValue();
    }

    public static boolean t(String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-342293261")) {
            return ((Boolean) ipChange.ipc$dispatch("-342293261", new Object[]{str, Boolean.valueOf(z)})).booleanValue();
        }
        File file = new File(str);
        if (g(str) && !r(str)) {
            if (!z) {
                return false;
            }
            e(file);
        }
        try {
            file.mkdirs();
        } catch (Exception e) {
            Log.w("StackTrace", e);
        }
        return file.exists();
    }

    public static void u(Bitmap bitmap, String str) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "205307763")) {
            ipChange.ipc$dispatch("205307763", new Object[]{bitmap, str});
            return;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }

    public static byte[] v(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1388276826")) {
            return (byte[]) ipChange.ipc$dispatch("-1388276826", new Object[]{inputStream});
        }
        byte[] bArr = null;
        if (inputStream == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                c(inputStream, byteArrayOutputStream);
                bArr = byteArrayOutputStream.toByteArray();
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            byteArrayOutputStream = null;
        }
        b(byteArrayOutputStream);
        return bArr;
    }
}
