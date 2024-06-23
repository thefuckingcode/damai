package cn.damai.tetris.componentplugin.bean;

import cn.damai.tetris.v2.common.Node;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.f92;

/* compiled from: Taobao */
public class LoadData {
    private static transient /* synthetic */ IpChange $ipChange;
    public boolean firstPage;
    public boolean hasNextPage;
    public List<Node> sectionList;

    public LoadData(boolean z, boolean z2, List<Node> list) {
        this.firstPage = z;
        this.hasNextPage = z2;
        this.sectionList = list;
    }

    public boolean hasListSize() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1507899933")) {
            return !f92.d(this.sectionList);
        }
        return ((Boolean) ipChange.ipc$dispatch("-1507899933", new Object[]{this})).booleanValue();
    }
}
