package cn.damai.tetris.request;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;

/* compiled from: Taobao */
public class DiscoverRecParams extends TetrisParams {
    private static transient /* synthetic */ IpChange $ipChange;
    public String currentCityId = d20.c();
    public String latitude;
    public String longitude;
    public String pageNo;
    public String targetTypeList = "1,2,5";
    public String topId;
    public String topType;

    public DiscoverRecParams(String str) {
        this.pageNo = str;
    }

    @Override // cn.damai.tetris.request.TetrisParams
    public String getPatternName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1163192522")) {
            return "live";
        }
        return (String) ipChange.ipc$dispatch("-1163192522", new Object[]{this});
    }

    @Override // cn.damai.tetris.request.TetrisParams
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1407387987")) {
            return "2.0";
        }
        return (String) ipChange.ipc$dispatch("1407387987", new Object[]{this});
    }

    public DiscoverRecParams(String str, String str2, String str3) {
        this.pageNo = str;
        this.topType = str2;
        this.topId = str3;
    }
}
