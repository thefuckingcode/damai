package tb;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.net.URL;

/* compiled from: Taobao */
public class xh0 {
    public static String a(u21 u21) {
        if (!TextUtils.isEmpty(u21.d)) {
            return u21.d;
        }
        try {
            return new File(new URL(u21.a).getFile()).getName();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String b(String str, u21 u21) {
        String a = a(u21);
        if (TextUtils.isEmpty(a)) {
            return "";
        }
        File file = new File(str, a);
        File file2 = new File(str, a + ".download");
        String absolutePath = file.getAbsolutePath();
        if (file.exists()) {
            long j = u21.b;
            if ((0 == j || j == file.length()) && wb1.c(u21.c, absolutePath)) {
                return file.getAbsolutePath();
            }
        }
        if (file2.exists()) {
            long j2 = u21.b;
            if ((0 == j2 || j2 == file2.length()) && wb1.c(u21.c, file2.getAbsolutePath())) {
                file2.renameTo(file);
                return file.getAbsolutePath();
            }
        }
        return "";
    }

    public static String c(Context context, String str) {
        return d(context, str, true);
    }

    public static String d(Context context, String str, boolean z) {
        File externalCacheDir = z ? context.getExternalCacheDir() : null;
        if (externalCacheDir == null) {
            externalCacheDir = context.getCacheDir();
        }
        StringBuilder sb = new StringBuilder();
        String str2 = File.separator;
        sb.append(str2);
        sb.append("downloadsdk");
        sb.append(str2);
        sb.append(str);
        File file = new File(externalCacheDir, sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static boolean e(File file, File file2) {
        if (!file.exists()) {
            return false;
        }
        if (file2.exists() && !file2.delete()) {
            return false;
        }
        if (!file2.getParentFile().exists() && !file2.getParentFile().mkdirs()) {
            return false;
        }
        if (!file2.getParentFile().canWrite()) {
            file2.getParentFile().setWritable(true);
        }
        if (file.renameTo(file2)) {
            return true;
        }
        m90.e("FileUtils", "mvFile", "rename fail", file.getName());
        return false;
    }
}
