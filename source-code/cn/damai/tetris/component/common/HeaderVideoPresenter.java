package cn.damai.tetris.component.common;

import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.v2.structure.section.ISection;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.w9;

/* compiled from: Taobao */
public class HeaderVideoPresenter extends BasePresenter<HeaderVideoContract$Model, HeaderVideoView, BaseSection> implements HeaderVideoContract$Presenter<HeaderVideoContract$Model, HeaderVideoView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    private ISection lastSection;
    public w9 mContext;
    public TrackInfo mTrackInfo;
    public HeaderVideoView mView;

    public HeaderVideoPresenter(HeaderVideoView headerVideoView, String str, w9 w9Var) {
        super(headerVideoView, str, w9Var);
        this.mView = headerVideoView;
        this.mContext = w9Var;
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.core.BasePresenter
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-947998549")) {
            ipChange.ipc$dispatch("-947998549", new Object[]{this, Integer.valueOf(i), obj});
            return;
        }
        ((HeaderVideoView) getView()).setMessage(i, obj);
    }

    public void init(HeaderVideoContract$Model headerVideoContract$Model) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-967071425")) {
            ipChange.ipc$dispatch("-967071425", new Object[]{this, headerVideoContract$Model});
            return;
        }
        this.mTrackInfo = headerVideoContract$Model.getTrackInfo();
        ISection iSection = this.lastSection;
        if (iSection == null || iSection != getSection()) {
            z = true;
        }
        this.lastSection = getSection();
        ((HeaderVideoView) getView()).setData(headerVideoContract$Model.getData(), getSection().getComponentId(), this.mTrackInfo, z);
    }
}
