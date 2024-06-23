package cn.damai.tetris.mvp;

import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.NodeData;
import cn.damai.tetris.core.TrackInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.w9;

/* compiled from: Taobao */
public class CommonPresenter extends BasePresenter<CommonContract$Model, CommonView, BaseSection> implements CommonContract$Presenter<CommonContract$Model, CommonView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    public w9 mContext;
    public TrackInfo mTrackInfo;
    public CommonView mView;

    public CommonPresenter(CommonView commonView, String str, w9 w9Var) {
        super(commonView, str, w9Var);
        this.mView = commonView;
        this.mContext = w9Var;
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.core.BasePresenter
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "326161748")) {
            ipChange.ipc$dispatch("326161748", new Object[]{this, Integer.valueOf(i), obj});
            return;
        }
        ((CommonView) getView()).setMessage(i, obj);
    }

    @Override // cn.damai.tetris.core.BasePresenter
    public boolean rebindAble() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1524037873")) {
            return ((CommonView) getView()).rebindAble();
        }
        return ((Boolean) ipChange.ipc$dispatch("1524037873", new Object[]{this})).booleanValue();
    }

    public void init(CommonContract$Model commonContract$Model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1271501359")) {
            ipChange.ipc$dispatch("-1271501359", new Object[]{this, commonContract$Model});
            return;
        }
        this.mTrackInfo = commonContract$Model.getTrackInfo();
        ((CommonView) getView()).setCommonPresenter(this);
        ((CommonView) getView()).setData(commonContract$Model.getData(), getSection().getComponentId(), this.mTrackInfo);
    }

    public void rebindData(CommonContract$Model commonContract$Model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1421242137")) {
            ipChange.ipc$dispatch("-1421242137", new Object[]{this, commonContract$Model});
            return;
        }
        NodeData data = ((CommonContract$Model) getModel()).getData();
        getView();
        ((CommonView) getView()).rebindData(data);
    }
}
