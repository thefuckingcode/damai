package com.youku.live.dsl.app;

import android.app.Application;
import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.xs0;

/* compiled from: Taobao */
public class IAppInfoImp implements IAppInfo {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.live.dsl.app.IAppInfo
    public Application getApplication() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-208110079")) {
            return xs0.a();
        }
        return (Application) ipChange.ipc$dispatch("-208110079", new Object[]{this});
    }

    @Override // com.youku.live.dsl.app.IAppInfo
    public Context getApplicationContext() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-959942623")) {
            return xs0.a().getApplicationContext();
        }
        return (Context) ipChange.ipc$dispatch("-959942623", new Object[]{this});
    }
}
