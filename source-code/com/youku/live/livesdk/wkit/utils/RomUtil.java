package com.youku.live.livesdk.wkit.utils;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: Taobao */
public class RomUtil {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String KEY_VERSION_EMUI = "ro.build.version.emui";
    private static final String KEY_VERSION_MIUI = "ro.miui.ui.version.name";
    private static final String KEY_VERSION_OPPO = "ro.build.version.opporom";
    private static final String KEY_VERSION_SMARTISAN = "ro.smartisan.version";
    private static final String KEY_VERSION_VIVO = "ro.vivo.os.version";
    public static final String ROM_EMUI = "EMUI";
    public static final String ROM_FLYME = "FLYME";
    public static final String ROM_MIUI = "MIUI";
    public static final String ROM_OPPO = "OPPO";
    public static final String ROM_QIKU = "QIKU";
    public static final String ROM_SMARTISAN = "SMARTISAN";
    public static final String ROM_VIVO = "VIVO";
    private static final String TAG = "Rom";
    private static String sName;
    private static String sVersion;

    public static boolean check(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1528671745")) {
            return ((Boolean) ipChange.ipc$dispatch("-1528671745", new Object[]{str})).booleanValue();
        }
        String str2 = sName;
        if (str2 != null) {
            return str2.equals(str);
        }
        String prop = getProp(KEY_VERSION_MIUI);
        sVersion = prop;
        if (!TextUtils.isEmpty(prop)) {
            sName = "MIUI";
        } else {
            String prop2 = getProp("ro.build.version.emui");
            sVersion = prop2;
            if (!TextUtils.isEmpty(prop2)) {
                sName = "EMUI";
            } else {
                String prop3 = getProp(KEY_VERSION_OPPO);
                sVersion = prop3;
                if (!TextUtils.isEmpty(prop3)) {
                    sName = "OPPO";
                } else {
                    String prop4 = getProp(KEY_VERSION_VIVO);
                    sVersion = prop4;
                    if (!TextUtils.isEmpty(prop4)) {
                        sName = "VIVO";
                    } else {
                        String prop5 = getProp(KEY_VERSION_SMARTISAN);
                        sVersion = prop5;
                        if (!TextUtils.isEmpty(prop5)) {
                            sName = "SMARTISAN";
                        } else {
                            String str3 = Build.DISPLAY;
                            sVersion = str3;
                            if (str3.toUpperCase().contains("FLYME")) {
                                sName = "FLYME";
                            } else {
                                sVersion = "unknown";
                                sName = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER().toUpperCase();
                            }
                        }
                    }
                }
            }
        }
        return sName.equals(str);
    }

    public static String getName() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "123329224")) {
            return (String) ipChange.ipc$dispatch("123329224", new Object[0]);
        }
        if (sName == null) {
            check("");
        }
        return sName;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0079 A[SYNTHETIC, Splitter:B:31:0x0079] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0083 A[SYNTHETIC, Splitter:B:36:0x0083] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x008b A[SYNTHETIC, Splitter:B:43:0x008b] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0095 A[SYNTHETIC, Splitter:B:48:0x0095] */
    public static String getProp(String str) {
        Throwable th;
        Process process;
        IOException e;
        BufferedReader bufferedReader;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2098345194")) {
            return (String) ipChange.ipc$dispatch("-2098345194", new Object[]{str});
        }
        BufferedReader bufferedReader2 = null;
        try {
            process = Runtime.getRuntime().exec("getprop " + str);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()), 1024);
                try {
                    String readLine = bufferedReader.readLine();
                    bufferedReader.close();
                    try {
                        bufferedReader.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    try {
                        process.destroy();
                    } catch (Throwable unused) {
                    }
                    return readLine;
                } catch (IOException e3) {
                    e = e3;
                    try {
                        Log.e(TAG, "Unable to read prop " + str, e);
                        if (bufferedReader != null) {
                        }
                        if (process != null) {
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader2 = bufferedReader;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        if (process != null) {
                            try {
                                process.destroy();
                            } catch (Throwable unused2) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e5) {
                e = e5;
                bufferedReader = null;
                Log.e(TAG, "Unable to read prop " + str, e);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                if (process != null) {
                    try {
                        process.destroy();
                    } catch (Throwable unused3) {
                    }
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                if (bufferedReader2 != null) {
                }
                if (process != null) {
                }
                throw th;
            }
        } catch (IOException e7) {
            e = e7;
            process = null;
            bufferedReader = null;
            Log.e(TAG, "Unable to read prop " + str, e);
            if (bufferedReader != null) {
            }
            if (process != null) {
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            process = null;
            if (bufferedReader2 != null) {
            }
            if (process != null) {
            }
            throw th;
        }
    }

    public static String getVersion() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1919202161")) {
            return (String) ipChange.ipc$dispatch("1919202161", new Object[0]);
        }
        if (sVersion == null) {
            check("");
        }
        return sVersion;
    }

    public static boolean is360() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2055788762")) {
            return ((Boolean) ipChange.ipc$dispatch("2055788762", new Object[0])).booleanValue();
        }
        return check("QIKU") || check("360");
    }

    public static boolean isEmui() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-259600465") ? ((Boolean) ipChange.ipc$dispatch("-259600465", new Object[0])).booleanValue() : check("EMUI");
    }

    public static boolean isFlyme() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1517652380") ? ((Boolean) ipChange.ipc$dispatch("1517652380", new Object[0])).booleanValue() : check("FLYME");
    }

    public static boolean isMiui() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1864022213") ? ((Boolean) ipChange.ipc$dispatch("-1864022213", new Object[0])).booleanValue() : check("MIUI");
    }

    public static boolean isOppo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "106950347") ? ((Boolean) ipChange.ipc$dispatch("106950347", new Object[0])).booleanValue() : check("OPPO");
    }

    public static boolean isSmartisan() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1509978201") ? ((Boolean) ipChange.ipc$dispatch("-1509978201", new Object[0])).booleanValue() : check("SMARTISAN");
    }

    public static boolean isVivo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1829645887") ? ((Boolean) ipChange.ipc$dispatch("1829645887", new Object[0])).booleanValue() : check("VIVO");
    }
}
