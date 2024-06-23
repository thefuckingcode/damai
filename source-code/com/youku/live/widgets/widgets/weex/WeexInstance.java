package com.youku.live.widgets.widgets.weex;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXSDKInstance;
import com.youku.live.widgets.protocol.IEngineInstance;

/* compiled from: Taobao */
public class WeexInstance extends WXSDKInstance {
    private static transient /* synthetic */ IpChange $ipChange;
    private IEngineInstance mEngineInstance;

    public void bindEngineInstance(IEngineInstance iEngineInstance) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-559078989")) {
            ipChange.ipc$dispatch("-559078989", new Object[]{this, iEngineInstance});
            return;
        }
        this.mEngineInstance = iEngineInstance;
    }

    public IEngineInstance getEngineInstance() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1835716212")) {
            return this.mEngineInstance;
        }
        return (IEngineInstance) ipChange.ipc$dispatch("-1835716212", new Object[]{this});
    }
}
