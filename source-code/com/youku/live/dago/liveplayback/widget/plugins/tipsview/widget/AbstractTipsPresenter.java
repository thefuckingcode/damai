package com.youku.live.dago.liveplayback.widget.plugins.tipsview.widget;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.liveplayback.widget.plugins.tipsview.BaseTipsUiConfig;

/* compiled from: Taobao */
public abstract class AbstractTipsPresenter<T extends BaseTipsUiConfig> implements ITipsPresenter<T> {
    private static transient /* synthetic */ IpChange $ipChange;
    protected boolean mShow = false;
    protected T mTipsUiConfig;
    protected ITipsContainerView mTipsView = null;

    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1527392291")) {
            ipChange.ipc$dispatch("1527392291", new Object[]{this});
            return;
        }
        ITipsContainerView iTipsContainerView = this.mTipsView;
        if (iTipsContainerView != null && this.mShow) {
            iTipsContainerView.animHide();
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.tipsview.widget.ITipsPresenter
    public void ignoredByHighLevel(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2034558783")) {
            ipChange.ipc$dispatch("-2034558783", new Object[]{this, Integer.valueOf(i), str});
        }
    }

    public boolean isShow() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-367998974")) {
            return this.mShow;
        }
        return ((Boolean) ipChange.ipc$dispatch("-367998974", new Object[]{this})).booleanValue();
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.tipsview.widget.ITipsPresenter
    public boolean onControlShowChange(int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "501197807")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("501197807", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)})).booleanValue();
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.tipsview.widget.ITipsPresenter
    public boolean onScreenModeChanged(Integer num, boolean z) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1981087968")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1981087968", new Object[]{this, num, Boolean.valueOf(z)})).booleanValue();
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.tipsview.widget.ITipsPresenter
    public void onTipsDidHide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-588287141")) {
            ipChange.ipc$dispatch("-588287141", new Object[]{this});
            return;
        }
        this.mShow = false;
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.tipsview.widget.ITipsPresenter
    public void onTipsDidShow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "566384576")) {
            ipChange.ipc$dispatch("566384576", new Object[]{this});
            return;
        }
        this.mShow = true;
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.tipsview.widget.ITipsPresenter
    public void setTipsUiConfig(T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "904873736")) {
            ipChange.ipc$dispatch("904873736", new Object[]{this, t});
            return;
        }
        this.mTipsUiConfig = t;
    }

    @Override // com.youku.live.dago.liveplayback.widget.plugins.tipsview.widget.ITipsPresenter
    public void setTipsView(ITipsContainerView iTipsContainerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1812323638")) {
            ipChange.ipc$dispatch("-1812323638", new Object[]{this, iTipsContainerView});
            return;
        }
        this.mTipsView = iTipsContainerView;
    }
}
