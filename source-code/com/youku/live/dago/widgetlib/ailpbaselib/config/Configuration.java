package com.youku.live.dago.widgetlib.ailpbaselib.config;

import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.ailpbaselib.net.mtop.LicenceResolveCallback;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: Taobao */
public class Configuration {
    private static transient /* synthetic */ IpChange $ipChange;
    private static ConcurrentMap<String, Configuration> configurations = new ConcurrentHashMap();
    private LicenceResolveCallback licenceCallback = null;
    private String mAppId = null;
    private String mLicence = null;
    private String mRoomId = null;
    private int mTestEnv = -1;

    private Configuration(String str, String str2, String str3) {
        this.mRoomId = str;
        this.mAppId = str2;
        this.mLicence = str3;
    }

    public static Configuration getConfig(@NonNull String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "249135262")) {
            return configurations.get(str);
        }
        return (Configuration) ipChange.ipc$dispatch("249135262", new Object[]{str});
    }

    public static Configuration init(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "738688784")) {
            return configurations.putIfAbsent(str, new Configuration(str, str2, str3));
        }
        return (Configuration) ipChange.ipc$dispatch("738688784", new Object[]{str, str2, str3});
    }

    public static void removeConfig(@NonNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-24674574")) {
            ipChange.ipc$dispatch("-24674574", new Object[]{str});
            return;
        }
        configurations.remove(str);
    }

    public String getAppId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "407553656")) {
            return this.mAppId;
        }
        return (String) ipChange.ipc$dispatch("407553656", new Object[]{this});
    }

    public String getLicence() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "259161325")) {
            return this.mLicence;
        }
        return (String) ipChange.ipc$dispatch("259161325", new Object[]{this});
    }

    public LicenceResolveCallback getLicenceCallback() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2075746054")) {
            return this.licenceCallback;
        }
        return (LicenceResolveCallback) ipChange.ipc$dispatch("-2075746054", new Object[]{this});
    }

    public int getTestEnv() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2097586404")) {
            return this.mTestEnv;
        }
        return ((Integer) ipChange.ipc$dispatch("-2097586404", new Object[]{this})).intValue();
    }

    public void setLicenceCallback(@NonNull LicenceResolveCallback licenceResolveCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1506378206")) {
            ipChange.ipc$dispatch("-1506378206", new Object[]{this, licenceResolveCallback});
            return;
        }
        this.licenceCallback = licenceResolveCallback;
    }

    public void setTestEnv(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1922591854")) {
            ipChange.ipc$dispatch("1922591854", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mTestEnv = i;
    }
}
