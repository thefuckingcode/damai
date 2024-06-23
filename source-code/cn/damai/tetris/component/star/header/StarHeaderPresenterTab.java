package cn.damai.tetris.component.star.header;

import cn.damai.tetris.component.star.bean.StarHeaderData;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.w9;

/* compiled from: Taobao */
public class StarHeaderPresenterTab extends StarHeaderPresenterBase {
    private static transient /* synthetic */ IpChange $ipChange;

    public StarHeaderPresenterTab(StarHeaderView starHeaderView, String str, w9 w9Var) {
        super(starHeaderView, str, w9Var);
    }

    @Override // cn.damai.tetris.component.star.header.StarHeaderPresenterBase
    public int getType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "16414458")) {
            return StarHeaderData.TYPE_TAB;
        }
        return ((Integer) ipChange.ipc$dispatch("16414458", new Object[]{this})).intValue();
    }
}
