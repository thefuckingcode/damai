package tb;

import android.annotation.TargetApi;
import android.os.StatFs;
import com.taobao.android.sopatch.storage.FileStorage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public final class rh0 {
    private static final FileStorage a = new qh0(ps0.d().b().getFilesDir());
    private static final Map<String, File> b = new HashMap();

    /* access modifiers changed from: private */
    @TargetApi(14)
    /* compiled from: Taobao */
    public static class a {
        private static final FileStorage a;

        static {
            File externalCacheDir = ps0.d().b().getExternalCacheDir();
            a = externalCacheDir != null ? new qh0(externalCacheDir) : new gd0();
        }
    }

    public static void a() {
        a.deleteInvalidFiles();
        a.a.deleteInvalidFiles();
    }

    public static File b(pc2 pc2) {
        Map<String, File> map = b;
        File file = map.get(h(pc2));
        if (file != null) {
            return file;
        }
        File soFile = a.getSoFile(pc2);
        if (g(soFile) && f(soFile, pc2.d())) {
            return soFile;
        }
        File soFile2 = a.a.getSoFile(pc2);
        if (!g(soFile2)) {
            return null;
        }
        map.put(h(pc2), soFile2);
        return soFile2;
    }

    public static File c() {
        File soPatchCacheFile = a.getSoPatchCacheFile();
        if (g(soPatchCacheFile)) {
            return soPatchCacheFile;
        }
        return null;
    }

    public static File d(String str, long j) {
        File tmpFile = a.getTmpFile(str);
        if (!g(tmpFile) || !f(tmpFile, j)) {
            return j(a.a.getTmpFile(str));
        }
        return tmpFile;
    }

    public static File e(sc2 sc2) {
        Map<String, File> map = b;
        File file = map.get(i(sc2));
        if (file != null) {
            return file;
        }
        File zipFile = a.getZipFile(sc2);
        if (g(zipFile) && f(zipFile, sc2.f())) {
            return zipFile;
        }
        File zipFile2 = a.a.getZipFile(sc2);
        if (!g(zipFile2)) {
            return null;
        }
        map.put(i(sc2), zipFile2);
        return zipFile2;
    }

    private static boolean f(File file, long j) {
        if (file.length() >= j) {
            return true;
        }
        try {
            StatFs statFs = new StatFs(file.getParentFile().toString());
            if (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize()) > j * 2) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean g(File file) {
        if (file != null) {
            try {
                if (!file.exists() || !file.canRead() || !file.canWrite() || !file.isFile()) {
                    return false;
                }
                return true;
            } catch (Throwable th) {
                s91.e(th);
            }
        }
        return false;
    }

    private static String h(pc2 pc2) {
        return pc2.a() + pc2.b();
    }

    private static String i(sc2 sc2) {
        return sc2.c();
    }

    private static File j(File file) {
        if (g(file)) {
            return file;
        }
        return null;
    }
}
