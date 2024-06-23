package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: Taobao */
public class yh0 {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0050 A[SYNTHETIC, Splitter:B:30:0x0050] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x005b A[SYNTHETIC, Splitter:B:38:0x005b] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0063 A[SYNTHETIC, Splitter:B:45:0x0063] */
    public static byte[] a(File file) {
        Throwable th;
        FileNotFoundException e;
        FileInputStream fileInputStream;
        IOException e2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-444414245")) {
            return (byte[]) ipChange.ipc$dispatch("-444414245", new Object[]{file});
        }
        FileInputStream fileInputStream2 = null;
        if (!file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                if (fileInputStream.getChannel().size() == 0) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused) {
                    }
                    return null;
                }
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                try {
                    fileInputStream.close();
                } catch (IOException unused2) {
                }
                return bArr;
            } catch (FileNotFoundException e3) {
                e = e3;
                e.printStackTrace();
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                return null;
            } catch (IOException e4) {
                e2 = e4;
                try {
                    e2.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                    }
                    throw th;
                }
            }
        } catch (FileNotFoundException e5) {
            e = e5;
            fileInputStream = null;
            e.printStackTrace();
            if (fileInputStream != null) {
            }
            return null;
        } catch (IOException e6) {
            e2 = e6;
            fileInputStream = null;
            e2.printStackTrace();
            if (fileInputStream != null) {
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
    }
}
