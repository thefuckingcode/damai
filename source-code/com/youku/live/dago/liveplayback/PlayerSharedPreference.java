package com.youku.live.dago.liveplayback;

import android.content.SharedPreferences;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplugin.AlixPlayerContext;
import java.util.Set;

/* compiled from: Taobao */
public class PlayerSharedPreference {
    private static transient /* synthetic */ IpChange $ipChange;
    private static SharedPreferences.Editor sEditor;
    private static SharedPreferences sSharedPreferences;

    private PlayerSharedPreference() {
    }

    public static boolean commitPreference(AlixPlayerContext alixPlayerContext, String str, Boolean bool) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "805458053")) {
            return getSpe(alixPlayerContext).putBoolean(str, bool.booleanValue()).commit();
        }
        return ((Boolean) ipChange.ipc$dispatch("805458053", new Object[]{alixPlayerContext, str, bool})).booleanValue();
    }

    public static boolean contains(AlixPlayerContext alixPlayerContext, String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2036030403")) {
            return getSp(alixPlayerContext).contains(str);
        }
        return ((Boolean) ipChange.ipc$dispatch("2036030403", new Object[]{alixPlayerContext, str})).booleanValue();
    }

    public static String getPreference(AlixPlayerContext alixPlayerContext, String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2126517409")) {
            return getSp(alixPlayerContext).getString(str, "");
        }
        return (String) ipChange.ipc$dispatch("-2126517409", new Object[]{alixPlayerContext, str});
    }

    public static boolean getPreferenceBoolean(AlixPlayerContext alixPlayerContext, String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1854713397")) {
            return getSp(alixPlayerContext).getBoolean(str, false);
        }
        return ((Boolean) ipChange.ipc$dispatch("-1854713397", new Object[]{alixPlayerContext, str})).booleanValue();
    }

    public static int getPreferenceInt(AlixPlayerContext alixPlayerContext, String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1594046765")) {
            return getSp(alixPlayerContext).getInt(str, 0);
        }
        return ((Integer) ipChange.ipc$dispatch("-1594046765", new Object[]{alixPlayerContext, str})).intValue();
    }

    public static long getPreferenceLong(AlixPlayerContext alixPlayerContext, String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1493687737")) {
            return getSp(alixPlayerContext).getLong(str, 0);
        }
        return ((Long) ipChange.ipc$dispatch("1493687737", new Object[]{alixPlayerContext, str})).longValue();
    }

    public static Set<String> getPreferenceStringSet(AlixPlayerContext alixPlayerContext, String str, Set<String> set) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "526270192")) {
            return getSp(alixPlayerContext).getStringSet(str, set);
        }
        return (Set) ipChange.ipc$dispatch("526270192", new Object[]{alixPlayerContext, str, set});
    }

    public static SharedPreferences getSp(AlixPlayerContext alixPlayerContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "703874601")) {
            return (SharedPreferences) ipChange.ipc$dispatch("703874601", new Object[]{alixPlayerContext});
        }
        if (sSharedPreferences == null) {
            sSharedPreferences = alixPlayerContext.getContext().getApplicationContext().getSharedPreferences("dago_sp", 0);
        }
        return sSharedPreferences;
    }

    public static SharedPreferences.Editor getSpe(AlixPlayerContext alixPlayerContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1657296209")) {
            return (SharedPreferences.Editor) ipChange.ipc$dispatch("-1657296209", new Object[]{alixPlayerContext});
        }
        if (sEditor == null) {
            sEditor = getSp(alixPlayerContext).edit();
        }
        return sEditor;
    }

    public static void savePreference(AlixPlayerContext alixPlayerContext, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1890631152")) {
            ipChange.ipc$dispatch("-1890631152", new Object[]{alixPlayerContext, str, str2});
            return;
        }
        getSpe(alixPlayerContext).putString(str, str2).apply();
    }

    public static boolean commitPreference(AlixPlayerContext alixPlayerContext, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-5000678")) {
            return getSpe(alixPlayerContext).putString(str, str2).commit();
        }
        return ((Boolean) ipChange.ipc$dispatch("-5000678", new Object[]{alixPlayerContext, str, str2})).booleanValue();
    }

    public static String getPreference(AlixPlayerContext alixPlayerContext, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-834945771")) {
            return getSp(alixPlayerContext).getString(str, str2);
        }
        return (String) ipChange.ipc$dispatch("-834945771", new Object[]{alixPlayerContext, str, str2});
    }

    public static boolean getPreferenceBoolean(AlixPlayerContext alixPlayerContext, String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1661494799")) {
            return getSp(alixPlayerContext).getBoolean(str, z);
        }
        return ((Boolean) ipChange.ipc$dispatch("-1661494799", new Object[]{alixPlayerContext, str, Boolean.valueOf(z)})).booleanValue();
    }

    public static int getPreferenceInt(AlixPlayerContext alixPlayerContext, String str, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2124187670")) {
            return getSp(alixPlayerContext).getInt(str, i);
        }
        return ((Integer) ipChange.ipc$dispatch("2124187670", new Object[]{alixPlayerContext, str, Integer.valueOf(i)})).intValue();
    }

    public static void savePreference(AlixPlayerContext alixPlayerContext, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "312503805")) {
            ipChange.ipc$dispatch("312503805", new Object[]{alixPlayerContext, str, Integer.valueOf(i)});
            return;
        }
        getSpe(alixPlayerContext).putInt(str, i).apply();
    }

    public static void savePreference(AlixPlayerContext alixPlayerContext, String str, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "312504766")) {
            ipChange.ipc$dispatch("312504766", new Object[]{alixPlayerContext, str, Long.valueOf(j)});
            return;
        }
        getSpe(alixPlayerContext).putLong(str, j).apply();
    }

    public static void savePreference(AlixPlayerContext alixPlayerContext, String str, Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1814511673")) {
            ipChange.ipc$dispatch("-1814511673", new Object[]{alixPlayerContext, str, bool});
            return;
        }
        getSpe(alixPlayerContext).putBoolean(str, bool.booleanValue()).apply();
    }

    public static void savePreference(AlixPlayerContext alixPlayerContext, String str, Set<String> set) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-651076551")) {
            ipChange.ipc$dispatch("-651076551", new Object[]{alixPlayerContext, str, set});
            return;
        }
        getSpe(alixPlayerContext).putStringSet(str, set).apply();
    }
}
