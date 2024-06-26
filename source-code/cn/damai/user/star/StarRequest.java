package cn.damai.user.star;

import cn.damai.tetris.request.TetrisParams;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;

/* compiled from: Taobao */
public class StarRequest extends TetrisParams {
    private static transient /* synthetic */ IpChange $ipChange;
    public String artistId;
    public String cityId = d20.c();
    public String pageNum = "1";
    public int pageSize = 15;

    @Override // cn.damai.tetris.request.TetrisParams
    public String getPatternName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "677512647")) {
            return "starHome";
        }
        return (String) ipChange.ipc$dispatch("677512647", new Object[]{this});
    }
}
