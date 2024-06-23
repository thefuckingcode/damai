package org.android.spdy;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.alibaba.analytics.core.network.NetworkUtil;
import com.youku.arch.solid.monitor.SolidMonitor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/* compiled from: Taobao */
public class SoInstallMgrSdk {
    private static final String ARMEABI = "armeabi";
    private static final int EventID_SO_INIT = 21033;
    static final String LOGTAG = "INIT_SO";
    private static final String MIPS = "mips";
    private static final String X86 = "x86";
    static Context mContext;

    private static String _cpuType() {
        String _getFieldReflectively = _getFieldReflectively(new Build(), "CPU_ABI");
        if (_getFieldReflectively == null || _getFieldReflectively.length() == 0 || _getFieldReflectively.equals(NetworkUtil.NETWORK_CLASS_UNKNOWN)) {
            _getFieldReflectively = ARMEABI;
        }
        return _getFieldReflectively.toLowerCase();
    }

    private static String _getFieldReflectively(Build build, String str) {
        try {
            return Build.class.getField(str).get(build).toString();
        } catch (Exception unused) {
            return NetworkUtil.NETWORK_CLASS_UNKNOWN;
        }
    }

    static boolean _loadUnzipSo(String str, int i, ClassLoader classLoader) {
        try {
            if (!isExist(str, i)) {
                return true;
            }
            if (classLoader == null) {
                System.load(_targetSoFile(str, i));
                return true;
            }
            Runtime runtime = Runtime.getRuntime();
            Method declaredMethod = Runtime.class.getDeclaredMethod("load", String.class, ClassLoader.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(runtime, _targetSoFile(str, i), classLoader);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return false;
        } catch (Error e3) {
            e3.printStackTrace();
            return false;
        }
    }

    static String _targetSoFile(String str, int i) {
        Context context = mContext;
        if (context == null) {
            return "";
        }
        String str2 = "/data/data/" + context.getPackageName() + "/files";
        File filesDir = context.getFilesDir();
        if (filesDir != null) {
            str2 = filesDir.getPath();
        }
        return str2 + "/lib" + str + "bk" + i + ".so";
    }

    public static void init(Context context) {
        mContext = context;
    }

    public static boolean initSo(String str, int i) {
        return initSo(str, i, null);
    }

    static boolean isExist(String str, int i) {
        return new File(_targetSoFile(str, i)).exists();
    }

    static void removeSoIfExit(String str, int i) {
        File file = new File(_targetSoFile(str, i));
        if (file.exists()) {
            file.delete();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x00d5 A[SYNTHETIC, Splitter:B:57:0x00d5] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00df A[SYNTHETIC, Splitter:B:62:0x00df] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00e9 A[SYNTHETIC, Splitter:B:67:0x00e9] */
    static boolean unZipSelectedFiles(String str, int i, ClassLoader classLoader) throws ZipException, IOException {
        FileChannel fileChannel;
        Throwable th;
        FileOutputStream fileOutputStream;
        String str2 = "lib/armeabi/lib" + str + ".so";
        String str3 = "";
        try {
            Context context = mContext;
            if (context == null) {
                return false;
            }
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo != null) {
                str3 = applicationInfo.sourceDir;
            }
            ZipFile zipFile = new ZipFile(str3);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                String name = zipEntry.getName();
                if (!name.contains("..") && !name.contains("\\")) {
                    if (!name.contains("%")) {
                        if (zipEntry.getName().startsWith(str2)) {
                            InputStream inputStream = null;
                            try {
                                removeSoIfExit(str, i);
                                InputStream inputStream2 = zipFile.getInputStream(zipEntry);
                                try {
                                    fileOutputStream = context.openFileOutput(SolidMonitor.CHECK_TYPE_LIB + str + "bk" + i + ".so", 0);
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileChannel = null;
                                    fileOutputStream = null;
                                    inputStream = inputStream2;
                                    if (inputStream != null) {
                                    }
                                    if (fileChannel != null) {
                                    }
                                    if (fileOutputStream != null) {
                                    }
                                    zipFile.close();
                                    throw th;
                                }
                                try {
                                    FileChannel channel = fileOutputStream.getChannel();
                                    byte[] bArr = new byte[1024];
                                    int i2 = 0;
                                    while (true) {
                                        int read = inputStream2.read(bArr);
                                        if (read > 0) {
                                            channel.write(ByteBuffer.wrap(bArr, 0, read));
                                            i2 += read;
                                        } else {
                                            try {
                                                break;
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }
                                    inputStream2.close();
                                    if (channel != null) {
                                        try {
                                            channel.close();
                                        } catch (Exception e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                    try {
                                        fileOutputStream.close();
                                    } catch (Exception e3) {
                                        e3.printStackTrace();
                                    }
                                    zipFile.close();
                                    if (i2 > 0) {
                                        return _loadUnzipSo(str, i, classLoader);
                                    }
                                    return false;
                                } catch (Throwable th3) {
                                    th = th3;
                                    fileChannel = null;
                                    inputStream = inputStream2;
                                    if (inputStream != null) {
                                    }
                                    if (fileChannel != null) {
                                    }
                                    if (fileOutputStream != null) {
                                    }
                                    zipFile.close();
                                    throw th;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                fileChannel = null;
                                fileOutputStream = null;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                if (fileChannel != null) {
                                    try {
                                        fileChannel.close();
                                    } catch (Exception e5) {
                                        e5.printStackTrace();
                                    }
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Exception e6) {
                                        e6.printStackTrace();
                                    }
                                }
                                zipFile.close();
                                throw th;
                            }
                        }
                    }
                }
                return false;
            }
            return false;
        } catch (IOException e7) {
            e7.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003d A[SYNTHETIC, Splitter:B:13:0x003d] */
    public static boolean initSo(String str, int i, ClassLoader classLoader) {
        boolean z = true;
        if (classLoader == null) {
            try {
                System.loadLibrary(str);
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
                if (!z) {
                }
                return z;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                z = false;
                if (!z) {
                }
                return z;
            } catch (Error e3) {
                e3.printStackTrace();
                z = false;
                if (!z) {
                }
                return z;
            }
        } else {
            Runtime runtime = Runtime.getRuntime();
            Method declaredMethod = Runtime.class.getDeclaredMethod("loadLibrary", String.class, ClassLoader.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(runtime, str, classLoader);
        }
        if (!z) {
            try {
                if (isExist(str, i)) {
                    boolean _loadUnzipSo = _loadUnzipSo(str, i, classLoader);
                    if (_loadUnzipSo) {
                        return _loadUnzipSo;
                    }
                    removeSoIfExit(str, i);
                }
                String _cpuType = _cpuType();
                if (!_cpuType.equalsIgnoreCase("mips") && !_cpuType.equalsIgnoreCase("x86")) {
                    try {
                        return unZipSelectedFiles(str, i, classLoader);
                    } catch (ZipException e4) {
                        e4.printStackTrace();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
            } catch (Exception e6) {
                e6.printStackTrace();
                return false;
            } catch (UnsatisfiedLinkError e7) {
                e7.printStackTrace();
                return false;
            } catch (Error e8) {
                e8.printStackTrace();
                return false;
            }
        }
        return z;
    }
}
