package com.youku.live.dago.widgetlib.util;

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
        if (AndroidInstantRuntime.support(ipChange, "-1790318483")) {
            return ((Boolean) ipChange.ipc$dispatch("-1790318483", new Object[]{str})).booleanValue();
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
        if (AndroidInstantRuntime.support(ipChange, "602214938")) {
            return (String) ipChange.ipc$dispatch("602214938", new Object[0]);
        }
        if (sName == null) {
            check("");
        }
        return sName;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x006f A[SYNTHETIC, Splitter:B:22:0x006f] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007c A[SYNTHETIC, Splitter:B:30:0x007c] */
    public static String getProp(String str) {
        Throwable th;
        BufferedReader bufferedReader;
        IOException e;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "776770024")) {
            return (String) ipChange.ipc$dispatch("776770024", new Object[]{str});
        }
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return readLine;
            } catch (IOException e3) {
                e = e3;
                try {
                    Log.e(TAG, "Unable to read prop " + str, e);
                    if (bufferedReader != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                    }
                    throw th;
                }
            }
        } catch (IOException e4) {
            e = e4;
            bufferedReader = null;
            Log.e(TAG, "Unable to read prop " + str, e);
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static String getVersion() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "522150623")) {
            return (String) ipChange.ipc$dispatch("522150623", new Object[0]);
        }
        if (sVersion == null) {
            check("");
        }
        return sVersion;
    }

    public static boolean is360() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1841090248")) {
            return ((Boolean) ipChange.ipc$dispatch("1841090248", new Object[0])).booleanValue();
        }
        return check("QIKU") || check("360");
    }

    public static boolean isEmui() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1674680193") ? ((Boolean) ipChange.ipc$dispatch("1674680193", new Object[0])).booleanValue() : check("EMUI");
    }

    public static boolean isFlyme() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1350810634") ? ((Boolean) ipChange.ipc$dispatch("1350810634", new Object[0])).booleanValue() : check("FLYME");
    }

    public static boolean isMiui() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "70258445") ? ((Boolean) ipChange.ipc$dispatch("70258445", new Object[0])).booleanValue() : check("MIUI");
    }

    public static boolean isOppo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2041231005") ? ((Boolean) ipChange.ipc$dispatch("2041231005", new Object[0])).booleanValue() : check("OPPO");
    }

    public static boolean isSmartisan() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1414341867") ? ((Boolean) ipChange.ipc$dispatch("-1414341867", new Object[0])).booleanValue() : check("SMARTISAN");
    }

    public static boolean isVivo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-531040751") ? ((Boolean) ipChange.ipc$dispatch("-531040751", new Object[0])).booleanValue() : check("VIVO");
    }
}
