package android.taobao.windvane.extra.uc;

import android.os.Build;
import android.os.Process;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.util.TaoLog;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import tb.jl1;

/* compiled from: Taobao */
public class WVUCUtils {
    public static final String CONFIG_KEY = "ISX86";
    public static final String TAG = "WVUCUtils";
    public static final long VAL_ARM = 2;
    public static final long VAL_DEAFAULT = 0;
    public static final long VAL_X86 = 1;
    private static String sAbi;
    private static String sAbi2;
    private static String[] sAbiList;
    private static String sArch;
    private static String sCpuAbi;
    private static String[] sSupportedABIs;

    private static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static String getFromSystemProp(String str) {
        BufferedReader bufferedReader;
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        Throwable th;
        try {
            fileInputStream = new FileInputStream(new File("/system/build.prop"));
            try {
                inputStreamReader = new InputStreamReader(fileInputStream);
            } catch (Throwable th2) {
                th = th2;
                inputStreamReader = null;
                bufferedReader = null;
                try {
                    th.printStackTrace();
                    close(bufferedReader);
                    close(inputStreamReader);
                    close(fileInputStream);
                    return null;
                } catch (Throwable th3) {
                    close(bufferedReader);
                    close(inputStreamReader);
                    close(fileInputStream);
                    throw th3;
                }
            }
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        } else if (readLine.contains(str)) {
                            String[] split = readLine.split("=");
                            if (split.length == 2 && split[0].trim().equals(str)) {
                                String trim = split[1].trim();
                                close(bufferedReader);
                                close(inputStreamReader);
                                close(fileInputStream);
                                return trim;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        th.printStackTrace();
                        close(bufferedReader);
                        close(inputStreamReader);
                        close(fileInputStream);
                        return null;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                bufferedReader = null;
                th.printStackTrace();
                close(bufferedReader);
                close(inputStreamReader);
                close(fileInputStream);
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            inputStreamReader = null;
            fileInputStream = null;
            bufferedReader = null;
            th.printStackTrace();
            close(bufferedReader);
            close(inputStreamReader);
            close(fileInputStream);
            return null;
        }
        close(bufferedReader);
        close(inputStreamReader);
        close(fileInputStream);
        return null;
    }

    public static boolean is64Bit() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            boolean is64Bit = Process.is64Bit();
            TaoLog.i(TAG, "is 64 bit = [" + is64Bit + jl1.ARRAY_END_STR);
            return is64Bit;
        } else if (i >= 21) {
            return isART64();
        } else {
            return false;
        }
    }

    private static boolean is64bitCPU() {
        String str;
        if (Build.VERSION.SDK_INT >= 21) {
            String[] strArr = Build.SUPPORTED_ABIS;
            str = strArr.length > 0 ? strArr[0] : null;
        } else {
            str = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getCPU_ABI();
        }
        if (str == null || !str.contains("arm64")) {
            return false;
        }
        return true;
    }

    private static boolean isART64() {
        try {
            ClassLoader classLoader = GlobalConfig.context.getClassLoader();
            Object invoke = ClassLoader.class.getDeclaredMethod("findLibrary", String.class).invoke(classLoader, "art");
            if (invoke != null) {
                return ((String) invoke).contains("lib64");
            }
            return false;
        } catch (Exception unused) {
            return is64bitCPU();
        }
    }

    public static boolean isArchContains(String str) {
        String fromSystemProp;
        if (sArch == null) {
            sArch = System.getProperty("os.arch");
        }
        String str2 = sArch;
        if (str2 != null && str2.toLowerCase().contains(str)) {
            return true;
        }
        if (sAbi == null) {
            try {
                sAbi = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getCPU_ABI();
                sAbi2 = Build.CPU_ABI2;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String str3 = sAbi;
        if (str3 != null && str3.toLowerCase().contains(str)) {
            return true;
        }
        if (sSupportedABIs == null && Build.VERSION.SDK_INT >= 21) {
            try {
                sSupportedABIs = (String[]) Build.class.getField("SUPPORTED_ABIS").get(null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        String[] strArr = sSupportedABIs;
        if (strArr != null && strArr.length > 0 && strArr[0] != null && strArr[0].toLowerCase().contains(str)) {
            return true;
        }
        if (sCpuAbi == null) {
            sCpuAbi = getFromSystemProp("ro.product.cpu.abi");
        }
        String str4 = sCpuAbi;
        if (str4 != null && str4.toLowerCase().contains(str)) {
            return true;
        }
        if (!(sAbiList != null || (fromSystemProp = getFromSystemProp("ro.product.cpu.abilist")) == null || fromSystemProp.length() == 0)) {
            sAbiList = fromSystemProp.split(",");
        }
        String[] strArr2 = sAbiList;
        if (strArr2 == null || strArr2.length <= 0 || strArr2[0] == null || !strArr2[0].toLowerCase().contains(str)) {
            return false;
        }
        return true;
    }
}
