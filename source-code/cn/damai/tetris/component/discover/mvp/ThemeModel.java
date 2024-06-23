package cn.damai.tetris.component.discover.mvp;

import cn.damai.tetris.component.discover.bean.ThemeBean;
import cn.damai.tetris.component.discover.mvp.ThemeContract;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.s41;

/* compiled from: Taobao */
public class ThemeModel extends AbsModel implements ThemeContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    ThemeBean mBean;

    @Override // cn.damai.tetris.component.discover.mvp.ThemeContract.Model
    public ThemeBean getBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "701953732")) {
            return this.mBean;
        }
        return (ThemeBean) ipChange.ipc$dispatch("701953732", new Object[]{this});
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1291646257")) {
            ipChange.ipc$dispatch("1291646257", new Object[]{this, baseNode});
            return;
        }
        ThemeBean themeBean = (ThemeBean) s41.d(baseNode.getItem(), ThemeBean.class);
        this.mBean = themeBean;
        themeBean.pos = baseNode.getOffset();
    }
}
