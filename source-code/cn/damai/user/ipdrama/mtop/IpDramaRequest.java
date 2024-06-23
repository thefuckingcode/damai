package cn.damai.user.ipdrama.mtop;

import cn.damai.tetris.request.TetrisParams;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;

/* compiled from: Taobao */
public class IpDramaRequest extends TetrisParams {
    private static transient /* synthetic */ IpChange $ipChange;
    public String cityId = d20.c();
    @Deprecated
    public String comboDamaiCity;
    public String comboDamaiCityId;
    public String funcVersion;
    public boolean hasContent = true;
    public String ipId;
    public String pageNo = "1";
    public int pageSize = 15;

    @Override // cn.damai.tetris.request.TetrisParams
    public String getPatternName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-115758614")) {
            return "baseIp";
        }
        return (String) ipChange.ipc$dispatch("-115758614", new Object[]{this});
    }
}
