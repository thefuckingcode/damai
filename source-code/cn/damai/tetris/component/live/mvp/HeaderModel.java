package cn.damai.tetris.component.live.mvp;

import cn.damai.tetris.component.live.bean.LiveHeaderPicBean;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.s41;

/* compiled from: Taobao */
public class HeaderModel extends AbsModel implements HeaderContract$Model {
    private static transient /* synthetic */ IpChange $ipChange;
    private LiveHeaderPicBean bean;

    @Override // cn.damai.tetris.component.live.mvp.HeaderContract$Model
    public LiveHeaderPicBean getHeaderBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1481425981")) {
            return this.bean;
        }
        return (LiveHeaderPicBean) ipChange.ipc$dispatch("1481425981", new Object[]{this});
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-811850340")) {
            ipChange.ipc$dispatch("-811850340", new Object[]{this, baseNode});
            return;
        }
        try {
            this.bean = (LiveHeaderPicBean) s41.d(baseNode.getItem(), LiveHeaderPicBean.class);
        } catch (Exception unused) {
        }
    }
}
