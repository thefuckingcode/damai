package com.youku.arch.v3.loader;

import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.io.Callback;
import com.youku.arch.v3.io.IResponse;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class ModuleLoader$handleLoadSuccess$1 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ int $index;
    final /* synthetic */ IResponse $response;
    final /* synthetic */ ModuleLoader this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModuleLoader$handleLoadSuccess$1(ModuleLoader moduleLoader, IResponse iResponse, int i) {
        super(0);
        this.this$0 = moduleLoader;
        this.$response = iResponse;
        this.$index = i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2086541487")) {
            ipChange.ipc$dispatch("-2086541487", new Object[]{this});
            return;
        }
        Callback callback = this.this$0.getCallback();
        if (callback != null) {
            callback.onResponse(this.$response);
        }
        JSONObject jsonObject = this.$response.getJsonObject();
        if (jsonObject != null) {
            ModuleLoader moduleLoader = this.this$0;
            moduleLoader.createComponents(moduleLoader.parseNode(jsonObject), this.$index);
        }
        this.this$0.setLoadingState(0);
    }
}
