package com.alibaba.pictures.bricks.orderresult.couponpayresult.bean;

import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class RecommendListMo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private ArrayList<JSONObject> result;

    @Nullable
    public final ArrayList<JSONObject> getResult() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1978451879")) {
            return this.result;
        }
        return (ArrayList) ipChange.ipc$dispatch("1978451879", new Object[]{this});
    }

    public final void setResult(@Nullable ArrayList<JSONObject> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1457782665")) {
            ipChange.ipc$dispatch("1457782665", new Object[]{this, arrayList});
            return;
        }
        this.result = arrayList;
    }
}
