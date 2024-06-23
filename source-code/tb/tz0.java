package tb;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: Taobao */
public class tz0 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String CACHE = "damaitdplay/cache";
    public static final String CACHE2 = "damaitdplay/imagecache";

    /* compiled from: Taobao */
    public static class b implements Comparator<File> {
        private static transient /* synthetic */ IpChange $ipChange;

        private b() {
        }

        /* renamed from: a */
        public int compare(File file, File file2) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1271169077")) {
                return file.lastModified() > file2.lastModified() ? 1 : 0;
            }
            return ((Integer) ipChange.ipc$dispatch("-1271169077", new Object[]{this, file, file2})).intValue();
        }
    }

    private static void a(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-753322590")) {
            ipChange.ipc$dispatch("-753322590", new Object[]{context});
            return;
        }
        try {
            File[] listFiles = new File(context.getFilesDir() + File.separator).listFiles();
            if (listFiles.length > 400) {
                ArrayList arrayList = new ArrayList();
                for (File file : listFiles) {
                    arrayList.add(file);
                }
                Collections.sort(arrayList, new b());
                int size = arrayList.size() - 200;
                for (int i = 0; i < size; i++) {
                    ((File) arrayList.get(i)).delete();
                }
            }
        } catch (Exception unused) {
        }
    }

    public static String b(Context context) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1861153209")) {
            return (String) ipChange.ipc$dispatch("1861153209", new Object[]{context});
        }
        if (!Environment.getExternalStorageState().equals("mounted") || !hp1.i(lp1.STORAGE)) {
            str = context.getCacheDir().getAbsolutePath();
        } else {
            str = context.getExternalCacheDir().getAbsolutePath();
        }
        File file = new File(str + File.separator + CACHE);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a6 A[SYNTHETIC, Splitter:B:35:0x00a6] */
    public static String c(String str, Context context) {
        Throwable th;
        Exception e;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1316666811")) {
            return (String) ipChange.ipc$dispatch("1316666811", new Object[]{str, context});
        }
        String str2 = "";
        if (str != null) {
            String str3 = uf2.c(str) + ".jpeg";
            FileOutputStream fileOutputStream = null;
            try {
                a(context);
                File file = new File(b(context));
                if (!file.exists() || !file.isDirectory()) {
                    file.mkdirs();
                } else {
                    for (File file2 : file.listFiles()) {
                        file2.delete();
                    }
                }
                str2 = b(context) + File.separator + str3;
                File file3 = new File(str2);
                if (!file3.exists()) {
                    file3.createNewFile();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(str2);
                try {
                    fileOutputStream2.flush();
                    try {
                        fileOutputStream2.close();
                    } catch (Exception unused) {
                    }
                } catch (Exception e2) {
                    fileOutputStream = fileOutputStream2;
                    e = e2;
                    try {
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                        }
                        return str2;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception unused2) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    fileOutputStream = fileOutputStream2;
                    th = th3;
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return str2;
            }
        }
        return str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b2 A[SYNTHETIC, Splitter:B:36:0x00b2] */
    public static String d(String str, Bitmap bitmap, Context context) {
        Throwable th;
        Exception e;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1834925059")) {
            return (String) ipChange.ipc$dispatch("1834925059", new Object[]{str, bitmap, context});
        }
        String str2 = "";
        if (!(bitmap == null || str == null)) {
            String str3 = uf2.c(str) + ".jpeg";
            FileOutputStream fileOutputStream = null;
            try {
                a(context);
                File file = new File(b(context));
                if (!file.exists() || !file.isDirectory()) {
                    file.mkdirs();
                } else {
                    for (File file2 : file.listFiles()) {
                        file2.delete();
                    }
                }
                str2 = b(context) + File.separator + str3;
                File file3 = new File(str2);
                if (!file3.exists()) {
                    file3.createNewFile();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(str2);
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream2);
                    fileOutputStream2.flush();
                    try {
                        fileOutputStream2.close();
                    } catch (Exception unused) {
                    }
                } catch (Exception e2) {
                    fileOutputStream = fileOutputStream2;
                    e = e2;
                    try {
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        return str2;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception unused2) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    fileOutputStream = fileOutputStream2;
                    th = th3;
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                if (fileOutputStream != null) {
                }
                return str2;
            }
        }
        return str2;
    }
}
