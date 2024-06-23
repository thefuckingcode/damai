package cn.damai.tetris.component.online.mvp;

import cn.damai.tetris.component.online.bean.ArtistBean;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.s41;

/* compiled from: Taobao */
public class HeaderModel extends AbsModel implements HeaderContract$Model {
    private static transient /* synthetic */ IpChange $ipChange;
    private ArtistBean bean;

    @Override // cn.damai.tetris.component.online.mvp.HeaderContract$Model
    public ArtistBean getTopBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "553254547")) {
            return this.bean;
        }
        return (ArtistBean) ipChange.ipc$dispatch("553254547", new Object[]{this});
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1643103851")) {
            ipChange.ipc$dispatch("-1643103851", new Object[]{this, baseNode});
            return;
        }
        try {
            this.bean = (ArtistBean) s41.d(baseNode.getItem(), ArtistBean.class);
        } catch (Exception unused) {
        }
    }
}
