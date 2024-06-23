package cn.damai.tetris.component.common;

import cn.damai.tetris.component.common.CommonTitleContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.TrackInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.w9;

/* compiled from: Taobao */
public class CommonTitlePresenter extends BasePresenter<CommonTitleContract.Model, CommonTitleContract.View, BaseSection> implements CommonTitleContract.Presenter<CommonTitleContract.Model, CommonTitleContract.View, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    private TrackInfo mTrackInfo;

    public CommonTitlePresenter(CommonTitleView commonTitleView, String str, w9 w9Var) {
        super(commonTitleView, str, w9Var);
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.core.BasePresenter
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2100146676")) {
            ipChange.ipc$dispatch("-2100146676", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    public void init(CommonTitleContract.Model model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1187315393")) {
            ipChange.ipc$dispatch("1187315393", new Object[]{this, model});
            return;
        }
        this.mTrackInfo = model.getTrackInfo();
        ((CommonTitleContract.View) getView()).setTip(model.getTitle());
        ((CommonTitleContract.View) getView()).setSchema(model.getSchema());
    }
}
