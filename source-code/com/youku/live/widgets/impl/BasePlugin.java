package com.youku.live.widgets.impl;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.widgets.constants.AppearState;
import com.youku.live.widgets.monitor.IPerfMonitor;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.protocol.IPlugin;
import com.youku.live.widgets.protocol.IPluginData;
import com.youku.live.widgets.protocol.IProps;

/* compiled from: Taobao */
public class BasePlugin implements IPlugin {
    private static transient /* synthetic */ IpChange $ipChange;
    public String id;
    public boolean isDynamic;
    public AppearState mAppearState = AppearState.DID_DISAPPEAR;
    private IEngineInstance mEngineInstance;
    public boolean mIsAppearLevel;
    private IPluginData mPluginData;
    private IProps mProps;
    public boolean mRecycled;
    public String name;

    public void bindEngineInstance(IEngineInstance iEngineInstance) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1837598020")) {
            ipChange.ipc$dispatch("1837598020", new Object[]{this, iEngineInstance});
            return;
        }
        this.mEngineInstance = iEngineInstance;
    }

    @Override // com.youku.live.widgets.protocol.IDestroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1275028727")) {
            ipChange.ipc$dispatch("1275028727", new Object[]{this});
        }
    }

    public void destroyImp() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "698416007")) {
            ipChange.ipc$dispatch("698416007", new Object[]{this});
        } else if (!this.mRecycled) {
            destroy();
        }
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener
    public void didAppear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "161728701")) {
            ipChange.ipc$dispatch("161728701", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener
    public void didDisappear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1929054421")) {
            ipChange.ipc$dispatch("1929054421", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IMountStateChangedListener
    public void didMount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-321615329")) {
            ipChange.ipc$dispatch("-321615329", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IMountStateChangedListener
    public void didUnmount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "326050552")) {
            ipChange.ipc$dispatch("326050552", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol2.IAppearState
    public AppearState getAppearState() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-312981467")) {
            return this.mAppearState;
        }
        return (AppearState) ipChange.ipc$dispatch("-312981467", new Object[]{this});
    }

    @Override // com.youku.live.widgets.protocol.IPlugin
    public IEngineInstance getEngineInstance() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2061154979")) {
            return this.mEngineInstance;
        }
        return (IEngineInstance) ipChange.ipc$dispatch("-2061154979", new Object[]{this});
    }

    @Override // com.youku.live.widgets.protocol.IPlugin
    public IProps getProps() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2034567433")) {
            return this.mProps;
        }
        return (IProps) ipChange.ipc$dispatch("-2034567433", new Object[]{this});
    }

    @Override // com.youku.live.widgets.protocol.IPlugin
    public void initWithData(IEngineInstance iEngineInstance, IPluginData iPluginData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1650790675")) {
            ipChange.ipc$dispatch("1650790675", new Object[]{this, iEngineInstance, iPluginData});
            return;
        }
        this.mEngineInstance = iEngineInstance;
        this.mPluginData = iPluginData;
        this.mProps = iPluginData != null ? iPluginData.getProps() : null;
    }

    @Override // com.youku.live.widgets.protocol.IElementAppearLevel
    public boolean isAppearLevel() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1250304848")) {
            return this.mIsAppearLevel;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1250304848", new Object[]{this})).booleanValue();
    }

    public void perfMonitorPoint(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1481324274")) {
            ipChange.ipc$dispatch("-1481324274", new Object[]{this, str, str2});
            return;
        }
        IEngineInstance engineInstance = getEngineInstance();
        IPerfMonitor iPerfMonitor = null;
        if (engineInstance != null) {
            iPerfMonitor = engineInstance.getPerfMonitor();
        }
        if (iPerfMonitor != null) {
            iPerfMonitor.point(str, str2);
        }
    }

    public void perfMonitorPointError(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "129896252")) {
            ipChange.ipc$dispatch("129896252", new Object[]{this, str, str2});
            return;
        }
        IEngineInstance engineInstance = getEngineInstance();
        IPerfMonitor iPerfMonitor = null;
        if (engineInstance != null) {
            iPerfMonitor = engineInstance.getPerfMonitor();
        }
        if (iPerfMonitor != null) {
            iPerfMonitor.pointError(str, str2);
        }
    }

    public void perfMonitorPointWarn(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-624809688")) {
            ipChange.ipc$dispatch("-624809688", new Object[]{this, str, str2});
            return;
        }
        IEngineInstance engineInstance = getEngineInstance();
        IPerfMonitor iPerfMonitor = null;
        if (engineInstance != null) {
            iPerfMonitor = engineInstance.getPerfMonitor();
        }
        if (iPerfMonitor != null) {
            iPerfMonitor.pointWarn(str, str2);
        }
    }

    @Override // com.youku.live.widgets.protocol2.IAppearState
    public void setAppearState(AppearState appearState) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2138772447")) {
            ipChange.ipc$dispatch("-2138772447", new Object[]{this, appearState});
            return;
        }
        this.mAppearState = appearState;
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener
    public void willAppear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1587283758")) {
            ipChange.ipc$dispatch("-1587283758", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener
    public void willDisappear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-652843872")) {
            ipChange.ipc$dispatch("-652843872", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IMountStateChangedListener
    public void willMount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-655129750")) {
            ipChange.ipc$dispatch("-655129750", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IMountStateChangedListener
    public void willUnmount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1941239171")) {
            ipChange.ipc$dispatch("1941239171", new Object[]{this});
        }
    }
}
