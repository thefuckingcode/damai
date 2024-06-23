package cn.damai.tetris.component.drama.mvp;

import cn.damai.tetris.component.drama.bean.AnchorBean;
import cn.damai.tetris.component.drama.bean.AnchorList;
import cn.damai.tetris.component.drama.mvp.AnchorFloatingContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.v2.structure.section.ISection;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.a03;
import tb.w9;

/* compiled from: Taobao */
public class AnchorFloatingPresenter extends BasePresenter<AnchorFloatingModel, AnchorFloatingView, BaseSection> implements AnchorFloatingContract.Presenter<AnchorFloatingModel, AnchorFloatingView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;

    public AnchorFloatingPresenter(AnchorFloatingView anchorFloatingView, String str, w9 w9Var) {
        super(anchorFloatingView, str, w9Var);
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.core.BasePresenter
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-999899478")) {
            ipChange.ipc$dispatch("-999899478", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.component.drama.mvp.AnchorFloatingContract.Presenter
    public void utClick(AnchorFloatingContract.View view, AnchorBean anchorBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1349817665")) {
            ipChange.ipc$dispatch("-1349817665", new Object[]{this, view, anchorBean, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> g = a03.g();
        g.put("titlelabel", anchorBean.name);
        userTrackClick("tab_" + i, g, false);
    }

    public void init(AnchorFloatingModel anchorFloatingModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-395430541")) {
            ipChange.ipc$dispatch("-395430541", new Object[]{this, anchorFloatingModel});
            return;
        }
        ISection section = getSection();
        if (section != null) {
            Object extra = section.getExtra();
            if (extra instanceof AnchorList) {
                ((AnchorFloatingView) getView()).setData((AnchorList) extra, 0);
            }
        }
    }
}
