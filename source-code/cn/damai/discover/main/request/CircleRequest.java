package cn.damai.discover.main.request;

import cn.damai.tetris.request.TetrisParams;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class CircleRequest extends TetrisParams {
    private static transient /* synthetic */ IpChange $ipChange;
    public String pageNum = "1";
    public int pageSize = 15;
    public String themeId;

    @Override // cn.damai.tetris.request.TetrisParams
    public String getPatternName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "816528796")) {
            return "themeDetail";
        }
        return (String) ipChange.ipc$dispatch("816528796", new Object[]{this});
    }

    @Override // cn.damai.tetris.request.TetrisParams
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-284011847")) {
            return "2.0";
        }
        return (String) ipChange.ipc$dispatch("-284011847", new Object[]{this});
    }
}
