package tb;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/* compiled from: Taobao */
public class ir0 {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0071  */
    public static byte[] a(File file) throws IOException {
        GZIPInputStream gZIPInputStream;
        FileInputStream fileInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th2;
        GZIPInputStream gZIPInputStream2;
        FileInputStream fileInputStream2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1154196628")) {
            return (byte[]) ipChange.ipc$dispatch("-1154196628", new Object[]{file});
        } else if (file == null || !file.exists()) {
            throw new IOException("decode gzip error. Gzip file is null!!");
        } else if (!c(file)) {
            return null;
        } else {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    fileInputStream2 = new FileInputStream(file);
                } catch (Throwable th3) {
                    th2 = th3;
                    gZIPInputStream2 = null;
                    th = th2;
                    gZIPInputStream = gZIPInputStream2;
                    fileInputStream = gZIPInputStream2;
                    if (gZIPInputStream != null) {
                    }
                    if (fileInputStream != 0) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    throw th;
                }
                try {
                    gZIPInputStream = new GZIPInputStream(fileInputStream2);
                } catch (Throwable th4) {
                    th = th4;
                    gZIPInputStream = null;
                    fileInputStream = fileInputStream2;
                    if (gZIPInputStream != null) {
                    }
                    if (fileInputStream != 0) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    throw th;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = gZIPInputStream.read(bArr, 0, 1024);
                        if (read != -1) {
                            byteArrayOutputStream.write(bArr, 0, read);
                        } else {
                            byteArrayOutputStream.flush();
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            gZIPInputStream.close();
                            fileInputStream2.close();
                            byteArrayOutputStream.close();
                            return byteArray;
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = fileInputStream2;
                    if (gZIPInputStream != null) {
                    }
                    if (fileInputStream != 0) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th2 = th6;
                byteArrayOutputStream = null;
                gZIPInputStream2 = null;
                th = th2;
                gZIPInputStream = gZIPInputStream2;
                fileInputStream = gZIPInputStream2;
                if (gZIPInputStream != null) {
                    gZIPInputStream.close();
                }
                if (fileInputStream != 0) {
                    fileInputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th;
            }
        }
    }

    public static byte[] b(String str) throws IOException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "865944185")) {
            return (byte[]) ipChange.ipc$dispatch("865944185", new Object[]{str});
        } else if (!TextUtils.isEmpty(str)) {
            return a(new File(str));
        } else {
            throw new IOException("gzip file name not exists!!");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x005d A[SYNTHETIC, Splitter:B:33:0x005d] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0069 A[SYNTHETIC, Splitter:B:40:0x0069] */
    public static boolean c(File file) {
        Throwable th;
        FileInputStream fileInputStream;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "696038830")) {
            return ((Boolean) ipChange.ipc$dispatch("696038830", new Object[]{file})).booleanValue();
        } else if (file == null || !file.exists() || file.isDirectory()) {
            return false;
        } else {
            FileInputStream fileInputStream2 = null;
            try {
                fileInputStream = new FileInputStream(file);
            } catch (IOException unused) {
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                throw th;
            }
            try {
                byte[] bArr = new byte[2];
                if (fileInputStream.read(bArr) < 2) {
                    fileInputStream.read(bArr);
                }
                if (((bArr[0] << 8) | (bArr[1] & 255)) != 8075) {
                    z = false;
                }
                try {
                    fileInputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                return z;
            } catch (IOException unused2) {
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                }
                return false;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                }
                throw th;
            }
        }
    }
}
