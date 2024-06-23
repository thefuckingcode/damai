package cn.damai.livehouse.model;

import android.text.TextUtils;
import cn.damai.tetris.request.TetrisParams;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;

/* compiled from: Taobao */
public class LiveHouseParams extends TetrisParams {
    private static transient /* synthetic */ IpChange $ipChange;
    public String cityId = d20.c();
    public String comboDamaiCityId = d20.c();
    public String outPatternName;
    public String outPatternVersion;
    public String pageNum;
    public String pageSize = "15";

    public LiveHouseParams() {
    }

    @Override // cn.damai.tetris.request.TetrisParams
    public String getPatternName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1153929646")) {
            return !TextUtils.isEmpty(this.outPatternName) ? this.outPatternName : "dm_livehouse_perform_page";
        }
        return (String) ipChange.ipc$dispatch("-1153929646", new Object[]{this});
    }

    @Override // cn.damai.tetris.request.TetrisParams
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-451916177")) {
            return !TextUtils.isEmpty(this.outPatternVersion) ? this.outPatternVersion : "1.0";
        }
        return (String) ipChange.ipc$dispatch("-451916177", new Object[]{this});
    }

    public LiveHouseParams(int i) {
        this.pageNum = i + "";
    }
}
