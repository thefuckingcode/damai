package tb;

import android.os.Process;
import com.taobao.weex.annotation.JSMethod;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* compiled from: Taobao */
public final class w23 {
    private static final Random a = new Random();

    public static String a(File file) {
        return l(file);
    }

    public static String b(g23 g23) {
        StringBuilder sb = new StringBuilder();
        sb.append(g23.a.a);
        sb.append(JSMethod.NOT_SET);
        sb.append(g23.a.d);
        sb.append(JSMethod.NOT_SET);
        sb.append(g23.a.e);
        sb.append(JSMethod.NOT_SET);
        sb.append((int) g23.a.b);
        sb.append(JSMethod.NOT_SET);
        sb.append(Process.myPid());
        sb.append(JSMethod.NOT_SET);
        sb.append(a.nextInt(10000));
        sb.append(JSMethod.NOT_SET);
        r03.c();
        sb.append(r03.e());
        return sb.toString();
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                t43.c("efs.util.file", "safe close error", th);
            }
        }
    }

    public static void d(File file, File file2) {
        Throwable th;
        FileOutputStream fileOutputStream;
        Exception e;
        byte[] bArr = new byte[524288];
        File parentFile = file2.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (file2.isDirectory()) {
            file2 = new File(file2, file.getName());
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                while (true) {
                    try {
                        int read = fileInputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    } catch (Exception e2) {
                        e = e2;
                        fileInputStream = fileInputStream2;
                        try {
                            t43.c("efs.util.file", "error when copy", e);
                            c(fileInputStream);
                            c(fileOutputStream);
                            i(file);
                        } catch (Throwable th2) {
                            th = th2;
                            c(fileInputStream);
                            c(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = fileInputStream2;
                        c(fileInputStream);
                        c(fileOutputStream);
                        throw th;
                    }
                }
                c(fileInputStream2);
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                t43.c("efs.util.file", "error when copy", e);
                c(fileInputStream);
                c(fileOutputStream);
                i(file);
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                c(fileInputStream);
                c(fileOutputStream);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream = null;
            t43.c("efs.util.file", "error when copy", e);
            c(fileInputStream);
            c(fileOutputStream);
            i(file);
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
            c(fileInputStream);
            c(fileOutputStream);
            throw th;
        }
        c(fileOutputStream);
        i(file);
    }

    public static boolean e(File file, String str) {
        return f(file, str.getBytes());
    }

    /* JADX INFO: finally extract failed */
    public static boolean f(File file, byte[] bArr) {
        Throwable th;
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(bArr);
                fileOutputStream2.flush();
                c(fileOutputStream2);
                return true;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                try {
                    t43.c("efs.util.file", "write file error, filename is " + file.getName(), th);
                    c(fileOutputStream);
                    return false;
                } catch (Throwable th3) {
                    c(fileOutputStream);
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            t43.c("efs.util.file", "write file error, filename is " + file.getName(), th);
            c(fileOutputStream);
            return false;
        }
    }

    public static byte[] g(String str) {
        FileInputStream fileInputStream = new FileInputStream(str);
        byte[] bArr = new byte[fileInputStream.available()];
        fileInputStream.read(bArr);
        return bArr;
    }

    public static g23 h(String str) {
        String[] split = str.split(JSMethod.NOT_SET);
        if (split.length != 7) {
            t43.b("efs.util.file", "File name error, name is ".concat(str), null);
            return null;
        }
        String str2 = split[0];
        String str3 = split[1];
        byte byteValue = Byte.valueOf(split[2]).byteValue();
        g23 g23 = new g23(str2, Byte.valueOf(split[3]).byteValue());
        g23.d(str3);
        g23.c(byteValue);
        return g23;
    }

    public static void i(File file) {
        File[] listFiles;
        if (file != null && file.exists()) {
            if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    i(file2);
                }
            }
            file.delete();
        }
    }

    public static long j(File file) {
        long j = 0;
        if (!file.isDirectory()) {
            return 0 + file.length();
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return 0;
        }
        for (File file2 : listFiles) {
            j += j(file2);
        }
        return j;
    }

    public static List<File> k(File file) {
        if (file.isFile()) {
            return Collections.emptyList();
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (File file2 : listFiles) {
            if (file2.isFile()) {
                arrayList.add(file2);
            } else {
                arrayList.addAll(k(file2));
            }
        }
        return arrayList;
    }

    private static String l(File file) {
        Throwable th;
        String str = "";
        if (!file.exists()) {
            return str;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byte[] bArr = new byte[1024];
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    sb.append(new String(bArr, 0, read));
                }
                str = sb.toString();
                c(fileInputStream2);
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                try {
                    t43.c("efs.util.file", "read file error", th);
                    return str;
                } finally {
                    c(fileInputStream);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            t43.c("efs.util.file", "read file error", th);
            return str;
        }
        return str;
    }
}
