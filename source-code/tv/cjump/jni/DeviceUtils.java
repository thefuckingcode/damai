package tv.cjump.jni;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;

/* compiled from: Taobao */
public class DeviceUtils {
    public static final String ABI_MIPS = "mips";
    public static final String ABI_X86 = "x86";
    private static ARCH a = ARCH.Unknown;

    /* compiled from: Taobao */
    public enum ARCH {
        Unknown,
        ARM,
        X86,
        MIPS,
        ARM64
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0084 A[SYNTHETIC, Splitter:B:37:0x0084] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0090 A[SYNTHETIC, Splitter:B:43:0x0090] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0098 A[SYNTHETIC, Splitter:B:47:0x0098] */
    public static synchronized ARCH a() {
        Throwable th;
        FileNotFoundException e;
        IOException e2;
        synchronized (DeviceUtils.class) {
            byte[] bArr = new byte[20];
            File file = new File(Environment.getRootDirectory(), "lib/libc.so");
            if (file.canRead()) {
                RandomAccessFile randomAccessFile = null;
                try {
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, UploadQueueMgr.MSGTYPE_REALTIME);
                    try {
                        randomAccessFile2.readFully(bArr);
                        int i = bArr[18] | (bArr[19] << 8);
                        if (i == 3) {
                            a = ARCH.X86;
                        } else if (i == 8) {
                            a = ARCH.MIPS;
                        } else if (i == 40) {
                            a = ARCH.ARM;
                        } else if (i != 183) {
                            Log.e("NativeBitmapFactory", "libc.so is unknown arch: " + Integer.toHexString(i));
                        } else {
                            a = ARCH.ARM64;
                        }
                        try {
                            randomAccessFile2.close();
                        } catch (IOException e3) {
                            e = e3;
                        }
                    } catch (FileNotFoundException e4) {
                        e = e4;
                        randomAccessFile = randomAccessFile2;
                        e.printStackTrace();
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException e5) {
                                e = e5;
                            }
                        }
                        return a;
                    } catch (IOException e6) {
                        e2 = e6;
                        randomAccessFile = randomAccessFile2;
                        try {
                            e2.printStackTrace();
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (IOException e7) {
                                    e = e7;
                                }
                            }
                            return a;
                        } catch (Throwable th2) {
                            th = th2;
                            if (randomAccessFile != null) {
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        randomAccessFile = randomAccessFile2;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException e8) {
                                e8.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e9) {
                    e = e9;
                    e.printStackTrace();
                    if (randomAccessFile != null) {
                    }
                    return a;
                } catch (IOException e10) {
                    e2 = e10;
                    e2.printStackTrace();
                    if (randomAccessFile != null) {
                    }
                    return a;
                }
            }
        }
        return a;
        e.printStackTrace();
        return a;
    }

    public static String b() {
        return Build.getCPU_ABI();
    }

    public static String c() {
        try {
            Field declaredField = android.os.Build.class.getDeclaredField("CPU_ABI2");
            if (declaredField == null) {
                return null;
            }
            Object obj = declaredField.get(null);
            if (!(obj instanceof String)) {
                return null;
            }
            return (String) obj;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean d() {
        return Build.getMANUFACTURER().equalsIgnoreCase("MagicBox") && Build.getPRODUCT().equalsIgnoreCase("MagicBox");
    }

    public static boolean e() {
        return Build.getMANUFACTURER().equalsIgnoreCase("Xiaomi") && Build.getPRODUCT().equalsIgnoreCase("dredd");
    }

    public static boolean f() {
        return e() || d();
    }

    public static boolean g() {
        return (i("armeabi-v7a") || i("armeabi")) && ARCH.ARM.equals(a());
    }

    public static boolean h() {
        return i(ABI_X86) || ARCH.X86.equals(a());
    }

    public static boolean i(String str) {
        try {
            String b = b();
            if (!TextUtils.isEmpty(b) && b.equalsIgnoreCase(str)) {
                return true;
            }
            String c = c();
            if (TextUtils.isEmpty(c) || !c.equalsIgnoreCase(str)) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
