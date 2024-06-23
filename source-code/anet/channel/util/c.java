package anet.channel.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import anet.channel.monitor.BandWidthSampler;
import anet.channel.monitor.NetworkSpeed;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.status.NetworkStatusHelper;
import com.alipay.sdk.m.c.a;
import com.ta.utdid2.device.UTDevice;
import com.taobao.android.ab.api.ABGlobal;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;
import tb.fe0;
import tb.gl1;
import tb.w6;

/* compiled from: Taobao */
public class c {
    public static Context a;
    private static Boolean b;
    private static String c;

    public static String a() {
        return "";
    }

    public static Context b() {
        Context context = a;
        if (context != null) {
            return context;
        }
        synchronized (c.class) {
            Context context2 = a;
            if (context2 != null) {
                return context2;
            }
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(cls, new Object[0]);
                a = (Context) invoke.getClass().getMethod("getApplication", new Class[0]).invoke(invoke, new Object[0]);
            } catch (Exception e) {
                ALog.j("awcn.Utils", "getAppContext", null, e, new Object[0]);
            }
            return a;
        }
    }

    public static String c(Context context) {
        return UTDevice.getUtdid(context);
    }

    public static String d() {
        String str = c;
        if (str != null) {
            return str;
        }
        String str2 = null;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str2 = (String) cls.getDeclaredMethod(gl1.TYPE_OPEN_URL_METHOD_GET, String.class).invoke(cls, a.b);
        } catch (Throwable unused) {
        }
        if (str2 == null) {
            str2 = "";
        }
        c = str2;
        return str2;
    }

    public static String e(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.processName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static float f() {
        NetworkStatusHelper.NetworkStatus i = NetworkStatusHelper.i();
        float f = (i == NetworkStatusHelper.NetworkStatus.G4 || i == NetworkStatusHelper.NetworkStatus.WIFI) ? 0.8f : 1.0f;
        return BandWidthSampler.f().h() == NetworkSpeed.Fast.getCode() ? f * 0.75f : f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    public static String g(Context context, int i) {
        String str = "";
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses == null || runningAppProcesses.size() <= 0) {
                w6.b().commitStat(new ExceptionStatistic(-108, fe0.a(-108, "BuildVersion=" + String.valueOf(Build.VERSION.SDK_INT)), "rt"));
                return !TextUtils.isEmpty(str) ? h(i) : str;
            }
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (next.pid == i) {
                    str = next.processName;
                    break;
                }
            }
            if (!TextUtils.isEmpty(str)) {
            }
        } catch (Exception e) {
            w6.b().commitStat(new ExceptionStatistic(-108, e.toString(), "rt"));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00bf A[SYNTHETIC, Splitter:B:37:0x00bf] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c7 A[Catch:{ IOException -> 0x00c3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d6 A[SYNTHETIC, Splitter:B:46:0x00d6] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00de A[Catch:{ IOException -> 0x00da }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    private static String h(int i) {
        Throwable th;
        DataOutputStream dataOutputStream;
        BufferedReader bufferedReader;
        Exception e;
        String str = "ps  |  grep  " + i;
        try {
            Process exec = Runtime.getRuntime().exec("sh");
            bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            try {
                dataOutputStream = new DataOutputStream(exec.getOutputStream());
                try {
                    dataOutputStream.writeBytes(str + "  &\n");
                    dataOutputStream.flush();
                    dataOutputStream.writeBytes("exit\n");
                    exec.waitFor();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            String[] split = readLine.replaceAll("\\s+", AltriaXLaunchTime.SPACE).split(AltriaXLaunchTime.SPACE);
                            if (split.length >= 9 && !TextUtils.isEmpty(split[1]) && split[1].trim().equals(String.valueOf(i))) {
                                String str2 = split[8];
                                try {
                                    bufferedReader.close();
                                    dataOutputStream.close();
                                } catch (IOException e2) {
                                    ALog.d("awcn.Utils", "getProcessNameNew ", null, e2, new Object[0]);
                                }
                                return str2;
                            }
                        } else {
                            try {
                                bufferedReader.close();
                                dataOutputStream.close();
                                return "";
                            } catch (IOException e3) {
                                ALog.d("awcn.Utils", "getProcessNameNew ", null, e3, new Object[0]);
                                return "";
                            }
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    try {
                        ALog.d("awcn.Utils", "getProcessNameNew ", null, e, new Object[0]);
                        if (bufferedReader != null) {
                        }
                        if (dataOutputStream == null) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e5) {
                                ALog.d("awcn.Utils", "getProcessNameNew ", null, e5, new Object[0]);
                                throw th;
                            }
                        }
                        if (dataOutputStream != null) {
                            dataOutputStream.close();
                        }
                        throw th;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                dataOutputStream = null;
                ALog.d("awcn.Utils", "getProcessNameNew ", null, e, new Object[0]);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e7) {
                        ALog.d("awcn.Utils", "getProcessNameNew ", null, e7, new Object[0]);
                        return "";
                    }
                }
                if (dataOutputStream == null) {
                    return "";
                }
                dataOutputStream.close();
                return "";
            } catch (Throwable th3) {
                th = th3;
                dataOutputStream = null;
                if (bufferedReader != null) {
                }
                if (dataOutputStream != null) {
                }
                throw th;
            }
        } catch (Exception e8) {
            e = e8;
            bufferedReader = null;
            dataOutputStream = null;
            ALog.d("awcn.Utils", "getProcessNameNew ", null, e, new Object[0]);
            if (bufferedReader != null) {
            }
            if (dataOutputStream == null) {
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            dataOutputStream = null;
            if (bufferedReader != null) {
            }
            if (dataOutputStream != null) {
            }
            throw th;
        }
    }

    public static Object i(String str, String str2, Class<?>[] clsArr, Object... objArr) throws Exception {
        Method method;
        if (str == null || str2 == null) {
            return null;
        }
        Class<?> cls = Class.forName(str);
        if (clsArr != null) {
            method = cls.getDeclaredMethod(str2, clsArr);
        } else {
            method = cls.getDeclaredMethod(str2, new Class[0]);
        }
        if (method == null) {
            return null;
        }
        method.setAccessible(true);
        if (objArr != null) {
            return method.invoke(cls, objArr);
        }
        return method.invoke(cls, new Object[0]);
    }

    public static Boolean j(Context context, String str) {
        try {
            boolean isFeatureOpened = ABGlobal.isFeatureOpened(context, str);
            ALog.e("awcn.Utils", "[isABGlobalFeatureOpened]", null, "featureName", str, "status", Boolean.valueOf(isFeatureOpened));
            return Boolean.valueOf(isFeatureOpened);
        } catch (Throwable unused) {
            ALog.e("awcn.Utils", "ABGlobal get error", null, new Object[0]);
            return null;
        }
    }

    public static boolean k() {
        Boolean bool = b;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z = false;
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            z = "harmony".equals(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]));
        } catch (Throwable unused) {
        }
        Boolean bool2 = new Boolean(z);
        b = bool2;
        return bool2.booleanValue();
    }
}
