package cn.damai.tetris.component.star.header;

import cn.damai.tetris.component.star.bean.StarHeaderData;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.w9;

/* compiled from: Taobao */
public class StarHeaderPresenterClub extends StarHeaderPresenterBase {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int TETRIS_COMPONENT_USERINFO = 103;

    public StarHeaderPresenterClub(StarHeaderView starHeaderView, String str, w9 w9Var) {
        super(starHeaderView, str, w9Var);
    }

    @Override // cn.damai.tetris.component.star.header.StarHeaderPresenterBase
    public int getType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-677164093")) {
            return StarHeaderData.TYPE_CLUB;
        }
        return ((Integer) ipChange.ipc$dispatch("-677164093", new Object[]{this})).intValue();
    }
}
