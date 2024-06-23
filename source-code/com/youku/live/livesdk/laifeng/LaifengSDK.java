package com.youku.live.livesdk.laifeng;

import android.app.Application;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.pages.ILaifengLibraryInterface;
import com.youku.live.dsl.pages.ILaifengManagerInterface;

/* compiled from: Taobao */
public class LaifengSDK {
    private static transient /* synthetic */ IpChange $ipChange;
    private static boolean isInitialized;

    public static void registerAll(Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1852107535")) {
            ipChange.ipc$dispatch("-1852107535", new Object[]{application});
        } else if (!isInitialized) {
            isInitialized = true;
            try {
                ((ILaifengLibraryInterface) Dsl.getService(ILaifengLibraryInterface.class)).registerAll(application);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                ((ILaifengManagerInterface) Dsl.getService(ILaifengManagerInterface.class)).registerAll(application);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }
}
