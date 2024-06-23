package tb;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
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
public class vo {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int BIT32 = 7;
    public static final int BIT64 = 8;
    public static final int UNKNOWN = -1;
    private static int a = -1;

    @NonNull
    public static int a(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-23212501")) {
            return ((Integer) ipChange.ipc$dispatch("-23212501", new Object[]{context})).intValue();
        } else if (e(context) == 8) {
            return 8;
        } else {
            return d();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0045  */
    public static int b(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1213985108")) {
            return ((Integer) ipChange.ipc$dispatch("-1213985108", new Object[]{context})).intValue();
        }
        Set<String> f = f(context.getApplicationInfo());
        if (Build.VERSION.SDK_INT < 21 || Build.SUPPORTED_64_BIT_ABIS.length == 0) {
            return 7;
        }
        if (f == null || f.isEmpty()) {
            return 8;
        }
        for (String str : f) {
            if ("arm64-v8a".endsWith(str) || "x86_64".equals(str) || "mips64".equals(str)) {
                return 8;
            }
            while (r4.hasNext()) {
            }
        }
        return 7;
    }

    private static int c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1196426611")) {
            return ((Integer) ipChange.ipc$dispatch("1196426611", new Object[]{str})).intValue();
        } else if (str == null) {
            return -1;
        } else {
            File file = new File(str);
            if (!file.isDirectory()) {
                return -1;
            }
            String lowerCase = file.getName().toLowerCase();
            if (Build.VERSION.SDK_INT < 21 || !lowerCase.startsWith("arm64")) {
                return 7;
            }
            return 8;
        }
    }

    public static int d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "959151957")) {
            return ((Integer) ipChange.ipc$dispatch("959151957", new Object[0])).intValue();
        }
        if (Build.VERSION.SDK_INT < 21) {
            return 7;
        }
        String str = Build.SUPPORTED_ABIS[0];
        if (str.toLowerCase().startsWith("arm64") || str.toLowerCase().startsWith("x86_64") || str.toLowerCase().startsWith("mips64")) {
            return 8;
        }
        if (str.toLowerCase().startsWith("armeabi") || str.toLowerCase().startsWith("armeabi-v7a") || str.toLowerCase().startsWith(DeviceUtils.ABI_X86)) {
            return 7;
        }
        return -1;
    }

    public static int e(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "216064017")) {
            return ((Integer) ipChange.ipc$dispatch("216064017", new Object[]{context})).intValue();
        }
        int i = a;
        if (i != -1) {
            return i;
        }
        int c = c(context.getApplicationInfo().nativeLibraryDir);
        if (c == -1) {
            c = b(context);
        }
        a = c;
        Log.d("CpuArch", "getCpuArchValue " + c);
        return c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009d A[SYNTHETIC, Splitter:B:39:0x009d] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x003b A[SYNTHETIC] */
    private static Set<String> f(ApplicationInfo applicationInfo) {
        Throwable th;
        IOException e;
        String[] strArr;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1252377905")) {
            return (Set) ipChange.ipc$dispatch("1252377905", new Object[]{applicationInfo});
        }
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
}
