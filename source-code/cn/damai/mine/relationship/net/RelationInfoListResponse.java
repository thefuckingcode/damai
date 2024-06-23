package cn.damai.mine.relationship.net;

import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class RelationInfoListResponse implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 1;
    private List<JSONObject> dataList;
    private boolean hasNext;

    public List<JSONObject> getDataList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "990912361")) {
            return this.dataList;
        }
        return (List) ipChange.ipc$dispatch("990912361", new Object[]{this});
    }

    public boolean isHasNext() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-105224323")) {
            return this.hasNext;
        }
        return ((Boolean) ipChange.ipc$dispatch("-105224323", new Object[]{this})).booleanValue();
    }

    public void setDataList(List<JSONObject> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "163966851")) {
            ipChange.ipc$dispatch("163966851", new Object[]{this, list});
            return;
        }
        this.dataList = list;
    }

    public void setHasNext(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "232492977")) {
            ipChange.ipc$dispatch("232492977", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.hasNext = z;
    }
}
