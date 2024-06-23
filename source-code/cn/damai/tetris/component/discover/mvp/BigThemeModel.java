package cn.damai.tetris.component.discover.mvp;

import cn.damai.tetris.component.discover.bean.ThemeBean;
import cn.damai.tetris.component.discover.mvp.BigThemeContract;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.s41;

/* compiled from: Taobao */
public class BigThemeModel extends AbsModel implements BigThemeContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    ThemeBean mBean;

    @Override // cn.damai.tetris.component.discover.mvp.BigThemeContract.Model
    public ThemeBean getBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "694193134")) {
            return this.mBean;
        }
        return (ThemeBean) ipChange.ipc$dispatch("694193134", new Object[]{this});
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1239802277")) {
            ipChange.ipc$dispatch("-1239802277", new Object[]{this, baseNode});
            return;
        }
        ThemeBean themeBean = (ThemeBean) s41.d(baseNode.getItem(), ThemeBean.class);
        this.mBean = themeBean;
        themeBean.pos = baseNode.getOffset();
    }
}
