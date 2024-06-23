package com.alibaba.pictures.bricks.base;

import com.alibaba.pictures.request.BaseRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public class DamaiBaseRequest<BizResponse> extends BaseRequest<BizResponse> {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.alibaba.pictures.request.BaseRequest, com.alibaba.pictures.dolores.request.DoloresRequest
    @NotNull
    public String markRequestLabel() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "151666165")) {
            return "damai";
        }
        return (String) ipChange.ipc$dispatch("151666165", new Object[]{this});
    }
}
