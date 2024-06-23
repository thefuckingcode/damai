package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: Taobao */
public class b72 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static String a = xs0.a().getFilesDir().getAbsolutePath();
    public static String b = "damai";
    public static String c;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        String str = File.separator;
        sb.append(str);
        sb.append(b);
        sb.append(str);
        sb.append("1111.zip");
        c = a + str + b + str + "1111";
    }

    public static File a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1748775906")) {
            return (File) ipChange.ipc$dispatch("-1748775906", new Object[]{str});
        }
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        String str2 = File.separator;
        sb.append(str2);
        sb.append(str);
        sb.append(str2);
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static String b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-316726102") ? (String) ipChange.ipc$dispatch("-316726102", new Object[0]) : a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0034, code lost:
        r4 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0035, code lost:
        r0 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0037, code lost:
        r4 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0045, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004c, code lost:
        r1.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0037 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:7:0x001f] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004c  */
    public static String c(File file) throws IOException {
        FileNotFoundException e;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "218953023")) {
            return (String) ipChange.ipc$dispatch("218953023", new Object[]{file});
        }
        String str = "";
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byte[] bArr = new byte[fileInputStream2.available()];
                fileInputStream2.read(bArr);
                String str2 = new String(bArr);
                fileInputStream2.close();
                fileInputStream2.close();
                return str2;
            } catch (FileNotFoundException e2) {
                e = e2;
                fileInputStream = fileInputStream2;
                try {
                    e.printStackTrace();
                    if (fileInputStream != null) {
                    }
                    return str;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    if (fileInputStream != null) {
                    }
                    throw th2;
                }
            } catch (Throwable th3) {
            }
        } catch (FileNotFoundException e3) {
            e = e3;
            e.printStackTrace();
            if (fileInputStream != null) {
            }
            return str;
        }
    }

    public static void d(File file) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1223373532")) {
            ipChange.ipc$dispatch("1223373532", new Object[]{file});
        } else if (file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                file.delete();
                return;
            }
            for (File file2 : listFiles) {
                d(file2);
            }
            file.delete();
        }
    }
}
