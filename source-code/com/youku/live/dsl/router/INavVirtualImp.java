package com.youku.live.dsl.router;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class INavVirtualImp implements INav {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.live.dsl.router.INav
    public INav from(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1341274647")) {
            return this;
        }
        return (INav) ipChange.ipc$dispatch("-1341274647", new Object[]{this, context});
    }

    @Override // com.youku.live.dsl.router.INav
    public boolean toUri(Uri uri) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-559209433")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-559209433", new Object[]{this, uri})).booleanValue();
    }

    @Override // com.youku.live.dsl.router.INav
    public boolean toUri(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1739683442")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1739683442", new Object[]{this, str})).booleanValue();
    }

    @Override // com.youku.live.dsl.router.INav
    public INav withCategory(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-328277")) {
            return this;
        }
        return (INav) ipChange.ipc$dispatch("-328277", new Object[]{this, str});
    }

    @Override // com.youku.live.dsl.router.INav
    public INav withExtras(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2034417118")) {
            return this;
        }
        return (INav) ipChange.ipc$dispatch("2034417118", new Object[]{this, bundle});
    }

    @Override // com.youku.live.dsl.router.INav
    public INav withFlags(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "798762167")) {
            return this;
        }
        return (INav) ipChange.ipc$dispatch("798762167", new Object[]{this, Integer.valueOf(i)});
    }
}
