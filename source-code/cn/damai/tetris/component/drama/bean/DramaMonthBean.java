package cn.damai.tetris.component.drama.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import tb.f92;

/* compiled from: Taobao */
public class DramaMonthBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public List<DramaV1Bean> content;
    public int headPosInTotalList = -1;
    public boolean isExpand = false;
    public boolean isLastTab = false;
    public String labelName;
    public int tabIndex = -1;

    public void utParamsInset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1737960514")) {
            ipChange.ipc$dispatch("1737960514", new Object[]{this});
        } else if (!f92.d(this.content)) {
            for (DramaV1Bean dramaV1Bean : this.content) {
                dramaV1Bean.tempLabelName = this.labelName;
            }
        }
    }
}
