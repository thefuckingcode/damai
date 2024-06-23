package cn.damai.tetris.request;

import cn.damai.common.AppConfig;
import com.alibaba.fastjson.annotation.JSONField;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.d20;

/* compiled from: Taobao */
public abstract class TetrisParams implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String comboDamaiCityId = d20.c();
    public String dmChannel = AppConfig.p();

    @JSONField(serialize = false)
    public abstract String getPatternName();

    @JSONField(serialize = false)
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1507159629")) {
            return "1.0";
        }
        return (String) ipChange.ipc$dispatch("-1507159629", new Object[]{this});
    }
}
