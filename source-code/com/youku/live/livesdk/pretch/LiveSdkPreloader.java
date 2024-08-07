package com.youku.live.livesdk.pretch;

import android.app.Application;
import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.arch.Arch;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.config.OptConfigUtils;
import com.youku.live.dsl.preloader.IPreloaderMananger;
import com.youku.live.dsl.thread.ILiveThreadFactory;
import com.youku.live.livesdk.LiveSDK;
import com.youku.live.livesdk.ailp.AilpSDK;
import com.youku.live.livesdk.dago.DagoSDK;
import com.youku.live.livesdk.laifeng.LaifengSDK;
import com.youku.live.livesdk.preloader.templates.TemplateCacheMananger;

/* compiled from: Taobao */
public class LiveSdkPreloader {
    private static transient /* synthetic */ IpChange $ipChange;
    private static volatile boolean sInitedAilpSDK;
    private static volatile boolean sInitedDagoSDK;
    private static volatile boolean sInitedLaifengSDK;
    private static volatile boolean sIsArch;
    private static volatile boolean sIsLiveSDK;

    public static void initAilpSDK(Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-161076039")) {
            ipChange.ipc$dispatch("-161076039", new Object[]{application});
        } else if (!sInitedAilpSDK) {
            AilpSDK.registerAll(application);
            sInitedAilpSDK = true;
        }
    }

    public static synchronized void initArch(Application application) {
        synchronized (LiveSdkPreloader.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1516869569")) {
                ipChange.ipc$dispatch("-1516869569", new Object[]{application});
                return;
            }
            if (!sIsArch) {
                Arch.init(application);
                sIsArch = true;
            }
        }
    }

    public static void initDagoSDK(Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1149984544")) {
            ipChange.ipc$dispatch("1149984544", new Object[]{application});
        } else if (!sInitedDagoSDK) {
            DagoSDK.registerAll(application);
            sInitedDagoSDK = true;
        }
    }

    public static void initLaifengSDK(Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1752285449")) {
            ipChange.ipc$dispatch("-1752285449", new Object[]{application});
        } else if (!sInitedLaifengSDK) {
            LaifengSDK.registerAll(application);
            sInitedLaifengSDK = true;
        }
    }

    public static synchronized void initLiveSDK(Context context) {
        synchronized (LiveSdkPreloader.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1704396702")) {
                ipChange.ipc$dispatch("-1704396702", new Object[]{context});
                return;
            }
            if (!sIsLiveSDK) {
                LiveSDK.initWithContext(context);
                sIsLiveSDK = true;
            }
        }
    }

    public static void preRegisterAll(final Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "394236756")) {
            ipChange.ipc$dispatch("394236756", new Object[]{application});
            return;
        }
        if (OptConfigUtils.getConfig("supportPreRegisterLiveSDK", true)) {
            ((ILiveThreadFactory) Dsl.getService(ILiveThreadFactory.class)).excute(new Runnable() {
                /* class com.youku.live.livesdk.pretch.LiveSdkPreloader.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1463047500")) {
                        ipChange.ipc$dispatch("1463047500", new Object[]{this});
                        return;
                    }
                    LiveSdkPreloader.registerAll(application);
                }
            });
        }
        if (OptConfigUtils.getConfig("supportPrefetchLayoutFromCache", true)) {
            ((ILiveThreadFactory) Dsl.getService(ILiveThreadFactory.class)).excute(new Runnable() {
                /* class com.youku.live.livesdk.pretch.LiveSdkPreloader.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1266533995")) {
                        ipChange.ipc$dispatch("1266533995", new Object[]{this});
                        return;
                    }
                    TemplateCacheMananger.getInstance().init();
                }
            });
        }
        if (OptConfigUtils.getConfig("supportPrecreatePlayerPreloader", false)) {
            ((ILiveThreadFactory) Dsl.getService(ILiveThreadFactory.class)).excute(new Runnable() {
                /* class com.youku.live.livesdk.pretch.LiveSdkPreloader.AnonymousClass3 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1070020490")) {
                        ipChange.ipc$dispatch("1070020490", new Object[]{this});
                        return;
                    }
                    ((IPreloaderMananger) Dsl.getService(IPreloaderMananger.class)).createPlayerPreloader();
                }
            });
        }
    }

    public static void preRegisterLaifeng(final Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2042109183")) {
            ipChange.ipc$dispatch("2042109183", new Object[]{application});
            return;
        }
        ((ILiveThreadFactory) Dsl.getService(ILiveThreadFactory.class)).excute(new Runnable() {
            /* class com.youku.live.livesdk.pretch.LiveSdkPreloader.AnonymousClass4 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "873506985")) {
                    ipChange.ipc$dispatch("873506985", new Object[]{this});
                    return;
                }
                LiveSdkPreloader.initLaifengSDK(application);
            }
        });
    }

    public static synchronized void registerAll(Application application) {
        synchronized (LiveSdkPreloader.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1047087367")) {
                ipChange.ipc$dispatch("-1047087367", new Object[]{application});
                return;
            }
            initLiveSDK(application);
            initArch(application);
            initAilpSDK(application);
            initDagoSDK(application);
            initLaifengSDK(application);
        }
    }
}
