package com.alipay.euler.andfix;

import android.os.Build;
import com.alipay.euler.andfix.log.Log;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import tb.gl1;
import tv.cjump.jni.DeviceUtils;

/* compiled from: Taobao */
public class Compat {
    private static AndFixVM a;

    static {
        AndFixVM andFixVM = AndFixVM.NotSupport;
        a = andFixVM;
        if (!a() || !c() || !b() || d()) {
            a = andFixVM;
        } else if (!AndFix.setup()) {
            Log.e("Compat", "AndFix.setup() => false");
            a = andFixVM;
        }
        Log.i("Compat", "AndFix.Compat: sAndFixVM=" + a);
    }

    private static boolean a() {
        return true;
    }

    private static boolean b() {
        if (isYunOS()) {
            if (isAOC()) {
                a = AndFixVM.AOC;
                return true;
            }
            a = AndFixVM.Lemur;
        }
        return true;
    }

    private static boolean c() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 8) {
            if (i < 8 || i >= 21) {
                if (i >= 21 && i <= 25) {
                    a = AndFixVM.ART;
                    return true;
                }
            } else if (!System.getProperty("java.vm.version").startsWith("2")) {
                a = AndFixVM.Dalvik;
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:20|21|22|23|24|25|65) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:10|11|12|13|14|15|(2:16|17)|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        return false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x003f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0042 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0049 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x004c */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0069 A[SYNTHETIC, Splitter:B:39:0x0069] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0070 A[SYNTHETIC, Splitter:B:43:0x0070] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0077 A[SYNTHETIC, Splitter:B:47:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x007f A[SYNTHETIC, Splitter:B:54:0x007f] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0086 A[SYNTHETIC, Splitter:B:58:0x0086] */
    /* JADX WARNING: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    private static boolean d() {
        InputStreamReader inputStreamReader;
        Process process;
        BufferedReader bufferedReader;
        Throwable th;
        BufferedReader bufferedReader2 = null;
        try {
            process = Runtime.getRuntime().exec("getprop ro.product.cpu.abi");
            try {
                inputStreamReader = new InputStreamReader(process.getInputStream());
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine.contains(DeviceUtils.ABI_X86)) {
                            Log.i("Compat", "AndFix.Compat: cpu: " + readLine);
                            bufferedReader.close();
                            inputStreamReader.close();
                            try {
                                process.destroy();
                            } catch (Exception unused) {
                            }
                            return true;
                        }
                        bufferedReader.close();
                        inputStreamReader.close();
                        process.destroy();
                        return false;
                    } catch (Exception unused2) {
                        bufferedReader2 = bufferedReader;
                        if (bufferedReader2 != null) {
                        }
                        if (inputStreamReader != null) {
                        }
                        if (process == null) {
                        }
                        process.destroy();
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedReader != null) {
                        }
                        if (inputStreamReader != null) {
                        }
                        if (process != null) {
                        }
                        throw th;
                    }
                } catch (Exception unused3) {
                    if (bufferedReader2 != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (process == null) {
                    }
                    process.destroy();
                    return false;
                } catch (Throwable th3) {
                    bufferedReader = null;
                    th = th3;
                    if (bufferedReader != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (process != null) {
                    }
                    throw th;
                }
            } catch (Exception unused4) {
                inputStreamReader = null;
                if (bufferedReader2 != null) {
                }
                if (inputStreamReader != null) {
                }
                if (process == null) {
                }
                process.destroy();
                return false;
            } catch (Throwable th4) {
                bufferedReader = null;
                th = th4;
                inputStreamReader = null;
                if (bufferedReader != null) {
                }
                if (inputStreamReader != null) {
                }
                if (process != null) {
                }
                throw th;
            }
        } catch (Exception unused5) {
            process = null;
            inputStreamReader = null;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception unused6) {
                }
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (Exception unused7) {
                }
            }
            if (process == null) {
                return false;
            }
            process.destroy();
            return false;
        } catch (Throwable th5) {
            inputStreamReader = null;
            bufferedReader = null;
            th = th5;
            process = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception unused8) {
                }
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (Exception unused9) {
                }
            }
            if (process != null) {
                try {
                    process.destroy();
                } catch (Exception unused10) {
                }
            }
            throw th;
        }
    }

    public static AndFixVM getAndFixVM() {
        return a;
    }

    public static boolean isAOC() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Method method = cls.getMethod(gl1.TYPE_OPEN_URL_METHOD_GET, String.class);
            String str = (String) method.invoke(cls, "persist.sys.dalvik.vm.lib");
            Log.d("Compat", "runtimeLib is " + str);
            if (str != null && "libart.so".equals(str)) {
                return true;
            }
            String str2 = (String) method.invoke(cls, "persist.sys.dalvik.vm.lib.2");
            Log.d("Compat", "runtimeLib2 is " + str2);
            return str2 != null && "libart.so".equals(str2);
        } catch (Exception unused) {
        }
    }

    public static boolean isSupport() {
        return a.value > AndFixVM.NotSupport.value;
    }

    public static boolean isYunOS() {
        String str;
        String str2 = null;
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod(gl1.TYPE_OPEN_URL_METHOD_GET, String.class);
            str = (String) method.invoke(null, "ro.yunos.version");
            try {
                str2 = (String) method.invoke(null, "java.vm.name");
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            str = null;
        }
        return (str2 != null && str2.toLowerCase().contains("lemur")) || (str != null && str.trim().length() > 0);
    }
}
