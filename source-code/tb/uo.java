package tb;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import com.taobao.update.datasource.UpdateDataSource;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import tv.cjump.jni.DeviceUtils;

/* compiled from: Taobao */
public class uo {
    public static final int BIT32 = -1;
    public static final int BIT64 = 8;
    public static final int UNKNOWN = -1;
    private static int a = -1;

    private static int a(String str) {
        if (str == null) {
            return -1;
        }
        File file = new File(str);
        if (!file.isDirectory()) {
            return -1;
        }
        String lowerCase = file.getName().toLowerCase();
        if (Build.VERSION.SDK_INT < 21 || !lowerCase.startsWith("arm64")) {
            return -1;
        }
        return 8;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0086 A[SYNTHETIC, Splitter:B:35:0x0086] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0024 A[SYNTHETIC] */
    private static Set<String> b(ApplicationInfo applicationInfo) {
        Throwable th;
        IOException e;
        String[] strArr;
        HashSet<String> hashSet = new HashSet();
        hashSet.add(applicationInfo.sourceDir);
        if (Build.VERSION.SDK_INT >= 21 && (strArr = applicationInfo.splitSourceDirs) != null) {
            hashSet.addAll(Arrays.asList(strArr));
        }
        HashSet hashSet2 = new HashSet();
        for (String str : hashSet) {
            ZipFile zipFile = null;
            try {
                ZipFile zipFile2 = new ZipFile(str);
                try {
                    Enumeration<? extends ZipEntry> entries = zipFile2.entries();
                    while (entries.hasMoreElements()) {
                        File parentFile = new File(((ZipEntry) entries.nextElement()).getName()).getParentFile();
                        if (parentFile != null && parentFile.getPath().startsWith("lib/")) {
                            hashSet2.add(parentFile.getName());
                        }
                    }
                    try {
                        zipFile2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (IOException e3) {
                    e = e3;
                    zipFile = zipFile2;
                    try {
                        e.printStackTrace();
                        if (zipFile == null) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    zipFile = zipFile2;
                    if (zipFile != null) {
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                e.printStackTrace();
                if (zipFile == null) {
                    zipFile.close();
                }
            }
        }
        return hashSet2;
    }

    @NonNull
    public static int getCpuArch() {
        if (getCurrentRuntimeCpuArchValue(UpdateDataSource.sContext) == 8) {
            return 8;
        }
        return getCurrentCpuArchValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002a  */
    public static int getCpuArchValueFromApk(Context context) {
        Set<String> b = b(context.getApplicationInfo());
        if (Build.VERSION.SDK_INT < 21 || Build.SUPPORTED_64_BIT_ABIS.length == 0) {
            return -1;
        }
        if (b == null || b.isEmpty()) {
            return 8;
        }
        for (String str : b) {
            if ("arm64-v8a".endsWith(str) || "x86_64".equals(str) || "mips64".equals(str)) {
                return 8;
            }
            while (r4.hasNext()) {
            }
        }
        return -1;
    }

    public static int getCurrentCpuArchValue() {
        if (Build.VERSION.SDK_INT < 21) {
            return -1;
        }
        String str = Build.SUPPORTED_ABIS[0];
        if (str.toLowerCase().startsWith("arm64") || str.toLowerCase().startsWith("x86_64") || str.toLowerCase().startsWith("mips64")) {
            return 8;
        }
        if (str.toLowerCase().startsWith("armeabi") || str.toLowerCase().startsWith("armeabi-v7a")) {
            return -1;
        }
        str.toLowerCase().startsWith(DeviceUtils.ABI_X86);
        return -1;
    }

    public static int getCurrentRuntimeCpuArchValue(Context context) {
        int i = a;
        if (i != -1) {
            return i;
        }
        int a2 = a(context.getApplicationInfo().nativeLibraryDir);
        if (a2 == -1) {
            a2 = getCpuArchValueFromApk(context);
        }
        a = a2;
        Log.d("CpuArch", "getCpuArchValue " + a2);
        return a2;
    }
}
