package cn.damai.performance.model;

import cn.damai.tetris.request.TetrisParams;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;

/* compiled from: Taobao */
public class OnlinePerformanceParams extends TetrisParams {
    private static transient /* synthetic */ IpChange $ipChange;
    public String cityId = d20.c();
    public String comboDamaiCityId = d20.c();
    public String pageNum;
    public String pageSize = "15";

    public OnlinePerformanceParams() {
    }

    @Override // cn.damai.tetris.request.TetrisParams
    public String getPatternName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "435831981")) {
            return "live_perform_page";
        }
        return (String) ipChange.ipc$dispatch("435831981", new Object[]{this});
    }

    @Override // cn.damai.tetris.request.TetrisParams
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "81365578")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("81365578", new Object[]{this});
    }

    public OnlinePerformanceParams(int i) {
        this.pageNum = i + "";
    }
}
