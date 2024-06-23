package com.alibaba.security.common.d;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.alibaba.security.common.c.a;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/* compiled from: Taobao */
public final class e {
    private static final String a = "FileUtils";
    private static final String b = "/realidentity";

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0072 A[SYNTHETIC, Splitter:B:33:0x0072] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0079 A[SYNTHETIC, Splitter:B:37:0x0079] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0081 A[SYNTHETIC, Splitter:B:44:0x0081] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0088 A[SYNTHETIC, Splitter:B:48:0x0088] */
    /* JADX WARNING: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    public static String a(Context context, String str, boolean z) {
        InputStream inputStream;
        FileInputStream fileInputStream;
        Throwable th;
        InputStream inputStream2;
        String str2;
        StringBuilder sb;
        File file = new File(str);
        FileInputStream fileInputStream2 = null;
        if (z) {
            try {
                sb = new StringBuilder();
                inputStream2 = context.getAssets().open(str);
            } catch (Exception unused) {
                fileInputStream = null;
                inputStream = null;
                if (fileInputStream != null) {
                }
                if (inputStream == null) {
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream2 = null;
                if (fileInputStream2 != null) {
                }
                if (inputStream2 != null) {
                }
                throw th;
            }
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream2));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                str2 = sb.toString();
            } catch (Exception unused2) {
                inputStream = inputStream2;
                fileInputStream = null;
                if (fileInputStream != null) {
                }
                if (inputStream == null) {
                }
            } catch (Throwable th3) {
                th = th3;
                if (fileInputStream2 != null) {
                }
                if (inputStream2 != null) {
                }
                throw th;
            }
        } else {
            fileInputStream = new FileInputStream(file);
            try {
                FileChannel channel = fileInputStream.getChannel();
                str2 = Charset.forName("utf-8").decode(channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size())).toString();
                fileInputStream2 = fileInputStream;
                inputStream2 = null;
            } catch (Exception unused3) {
                inputStream = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                if (inputStream == null) {
                    return null;
                }
                try {
                    inputStream.close();
                    return null;
                } catch (IOException unused5) {
                    return null;
                }
            } catch (Throwable th4) {
                th = th4;
                fileInputStream2 = fileInputStream;
                inputStream2 = null;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused6) {
                    }
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException unused7) {
                    }
                }
                throw th;
            }
        }
        if (fileInputStream2 != null) {
            try {
                fileInputStream2.close();
            } catch (IOException unused8) {
            }
        }
        if (inputStream2 != null) {
            try {
                inputStream2.close();
            } catch (IOException unused9) {
            }
        }
        return str2;
    }

    private static String b(Context context) {
        return context.getFilesDir().getAbsolutePath() + b;
    }

    @SuppressLint({"NewApi"})
    private static String c(Context context, Uri uri) {
        if (DocumentsContract.isDocumentUri(context, uri)) {
            String documentId = DocumentsContract.getDocumentId(uri);
            if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                return a(context, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id=?", new String[]{documentId.split(":")[1]});
            } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                return a(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()), null, null);
            } else {
                return null;
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            return a(context, uri, null, null);
        } else {
            if ("file".equals(uri.getScheme())) {
                return uri.getPath();
            }
            return null;
        }
    }

    private static boolean d(String str) throws Exception {
        return new File(str).createNewFile();
    }

    private static String b(Context context, Uri uri) {
        return a(context, uri, null, null);
    }

    private static boolean d(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile() && file.delete();
        }
        return true;
    }

    private static boolean b(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    private static boolean b(File file) {
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            return c(file);
        }
        if (!file.exists()) {
            return true;
        }
        if (!file.isFile() || !file.delete()) {
            return false;
        }
        return true;
    }

    private static boolean b(Context context, String str, String str2) {
        byte[] a2 = a(context, str);
        if (a2 == null) {
            return false;
        }
        return a(str2, a2);
    }

    private static boolean c(String str) {
        return new File(str).exists();
    }

    private static boolean c(File file) {
        if (file == null) {
            return false;
        }
        if (!file.exists()) {
            return true;
        }
        if (!file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    if (!file2.delete()) {
                        return false;
                    }
                } else if (file2.isDirectory() && !c(file2)) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x006d A[SYNTHETIC, Splitter:B:37:0x006d] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0077  */
    public static boolean a(String str, byte[] bArr, String str2) {
        FileOutputStream fileOutputStream;
        Throwable th;
        ByteArrayInputStream byteArrayInputStream = null;
        boolean z = false;
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, str2);
            if (file2.exists()) {
                file2.delete();
            }
            ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr2 = new byte[1024];
                    while (true) {
                        int read = byteArrayInputStream2.read(bArr2);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr2, 0, read);
                    }
                    fileOutputStream.flush();
                    z = true;
                    try {
                        byteArrayInputStream2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayInputStream = byteArrayInputStream2;
                    try {
                        a.c(a, "saveBytes2File got error " + th.getMessage());
                        if (byteArrayInputStream != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        return z;
                    } catch (Throwable th3) {
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                byteArrayInputStream = byteArrayInputStream2;
                a.c(a, "saveBytes2File got error " + th.getMessage());
                if (byteArrayInputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                return z;
            }
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
            a.c(a, "saveBytes2File got error " + th.getMessage());
            if (byteArrayInputStream != null) {
                try {
                    byteArrayInputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return z;
        }
        return z;
    }

    private static String a(Context context, String str, String str2) {
        StringBuilder sb;
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir != null) {
            sb = new StringBuilder();
            sb.append(externalCacheDir.getAbsolutePath());
            sb.append(File.separator);
        } else {
            File a2 = a(context);
            if (a2 != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(a2.getAbsolutePath());
                sb2.append(File.separator);
                sb = sb2;
            } else {
                sb = null;
            }
        }
        if (!TextUtils.isEmpty(str) && sb != null) {
            sb.append(str);
            sb.append(File.separator);
            sb.append(str2);
        }
        return sb.toString();
    }

    public static File a(Context context) {
        if (Build.VERSION.SDK_INT >= 8) {
            try {
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir != null) {
                    if (!externalCacheDir.exists()) {
                        externalCacheDir.mkdirs();
                    }
                    return externalCacheDir;
                }
            } catch (Exception unused) {
            }
        }
        File file = new File(Environment.getExternalStorageDirectory().getPath() + ("/Android/data/" + l.a(context) + "/cache/"));
        try {
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception unused2) {
        }
        return file;
    }

    public static long a(String str) {
        try {
            return a(new File(str));
        } catch (Exception e) {
            a.d(a, e.getLocalizedMessage());
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x002d A[SYNTHETIC, Splitter:B:22:0x002d] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0037 A[SYNTHETIC, Splitter:B:27:0x0037] */
    private static long a(File file) {
        Throwable th;
        Exception e;
        FileInputStream fileInputStream;
        if (file.exists()) {
            FileInputStream fileInputStream2 = null;
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Exception e2) {
                e = e2;
                try {
                    a.d(a, e.getLocalizedMessage());
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException unused) {
                            a.b();
                        }
                    }
                    return 0;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream2 != null) {
                    }
                    throw th;
                }
            }
            try {
                long available = (long) fileInputStream.available();
                try {
                    fileInputStream.close();
                    return available;
                } catch (IOException unused2) {
                    a.b();
                    return available;
                }
            } catch (Exception e3) {
                e = e3;
                fileInputStream2 = fileInputStream;
                a.d(a, e.getLocalizedMessage());
                if (fileInputStream2 != null) {
                }
                return 0;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused3) {
                        a.b();
                    }
                }
                throw th;
            }
        }
        return 0;
    }

    private static String a(Context context, Uri uri) {
        if (Build.VERSION.SDK_INT < 19) {
            return a(context, uri, null, null);
        }
        if (DocumentsContract.isDocumentUri(context, uri)) {
            String documentId = DocumentsContract.getDocumentId(uri);
            if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                return a(context, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id=?", new String[]{documentId.split(":")[1]});
            } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                return a(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()), null, null);
            } else {
                return null;
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            return a(context, uri, null, null);
        } else {
            if ("file".equals(uri.getScheme())) {
                return uri.getPath();
            }
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    public static String a(Context context, Uri uri, String str, String[] strArr) {
        Cursor cursor;
        String[] strArr2 = {"_data"};
        try {
            cursor = context.getContentResolver().query(uri, strArr2, str, strArr, null);
            if (cursor == null) {
                return null;
            }
            try {
                if (cursor.moveToFirst()) {
                    return cursor.getString(cursor.getColumnIndexOrThrow(strArr2[0]));
                }
                return null;
            } catch (Exception unused) {
                if (cursor != null) {
                }
            }
        } catch (Exception unused2) {
            cursor = null;
            if (cursor != null) {
                return null;
            }
            cursor.close();
            return null;
        }
    }

    private static boolean a(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static synchronized boolean a(String str, byte[] bArr) {
        boolean a2;
        synchronized (e.class) {
            a2 = a(new File(str), bArr);
        }
        return a2;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:4|5|(1:7)(2:8|9)|12|13|14|15|16|(5:17|18|19|20|21)|22|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0041, code lost:
        if (r3 == null) goto L_0x0047;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0033 */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x003c A[SYNTHETIC, Splitter:B:30:0x003c] */
    public static synchronized boolean a(File file, byte[] bArr) {
        boolean z;
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        synchronized (e.class) {
            z = false;
            if (bArr != null) {
                file.mkdirs();
                if (file.exists()) {
                    file.delete();
                } else {
                    try {
                        file.createNewFile();
                    } catch (Throwable th) {
                        a.b();
                        th.printStackTrace();
                    }
                }
                BufferedOutputStream bufferedOutputStream2 = null;
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                    } catch (Throwable unused) {
                        if (bufferedOutputStream2 != null) {
                        }
                    }
                    try {
                        bufferedOutputStream.write(bArr);
                        bufferedOutputStream.flush();
                        z = true;
                        bufferedOutputStream.close();
                    } catch (Throwable unused2) {
                        bufferedOutputStream2 = bufferedOutputStream;
                        if (bufferedOutputStream2 != null) {
                            try {
                                bufferedOutputStream2.close();
                            } catch (IOException unused3) {
                            }
                        }
                    }
                } catch (Throwable unused4) {
                    fileOutputStream = null;
                    if (bufferedOutputStream2 != null) {
                    }
                }
                fileOutputStream.close();
            }
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x002e A[SYNTHETIC, Splitter:B:17:0x002e] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    public static byte[] a(Context context, String str) {
        InputStream inputStream;
        try {
            inputStream = context.getAssets().open(str);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr, 0, 100);
                    if (read <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
                return byteArray;
            } catch (Throwable unused2) {
                if (inputStream != null) {
                }
            }
        } catch (Throwable unused3) {
            inputStream = null;
            if (inputStream != null) {
                return null;
            }
            try {
                inputStream.close();
                return null;
            } catch (IOException unused4) {
                return null;
            }
        }
    }

    private static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 100);
            if (read > 0) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(17:4|(1:6)|7|(1:9)|10|11|12|13|14|15|(2:16|(1:18)(1:55))|19|20|21|22|23|56) */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        return true;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0041 */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0057 A[SYNTHETIC, Splitter:B:36:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x005e A[SYNTHETIC, Splitter:B:40:0x005e] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0065 A[SYNTHETIC, Splitter:B:47:0x0065] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x006c A[SYNTHETIC, Splitter:B:51:0x006c] */
    public static boolean a(File file, File file2) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        Throwable th;
        FileInputStream fileInputStream = null;
        try {
            if (file.exists()) {
                if (!file2.getParentFile().exists()) {
                    file2.getParentFile().mkdirs();
                }
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int read = fileInputStream2.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        fileOutputStream.flush();
                        fileInputStream2.close();
                        fileOutputStream.close();
                        return true;
                    } catch (Exception unused) {
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        return false;
                    } catch (Throwable th2) {
                        fileInputStream = fileInputStream2;
                        fileOutputStream2 = fileOutputStream;
                        th = th2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused4) {
                            }
                        }
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException unused5) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception unused6) {
                    fileOutputStream = null;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    return false;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream2 = null;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                    }
                    if (fileOutputStream2 != null) {
                    }
                    throw th;
                }
            }
        } catch (Exception unused7) {
            fileOutputStream = null;
            if (fileInputStream != null) {
            }
            if (fileOutputStream != null) {
            }
            return false;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream2 = null;
            if (fileInputStream != null) {
            }
            if (fileOutputStream2 != null) {
            }
            throw th;
        }
        return false;
    }

    private static void a(Context context, String str, File file) throws IOException {
        InputStream open = context.getAssets().open(str);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = open.read(bArr);
            if (read != -1) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                fileOutputStream.flush();
                open.close();
                fileOutputStream.close();
                file.setReadable(true);
                return;
            }
        }
    }
}
