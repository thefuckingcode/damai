package cn.damai.tetris.component.rank.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class RankSelectExtraBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String backPic;

    @Nullable
    public final String getBackPic() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1182284351")) {
            return this.backPic;
        }
        return (String) ipChange.ipc$dispatch("-1182284351", new Object[]{this});
    }

    public final void setBackPic(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "387637205")) {
            ipChange.ipc$dispatch("387637205", new Object[]{this, str});
            return;
        }
        this.backPic = str;
    }
}
