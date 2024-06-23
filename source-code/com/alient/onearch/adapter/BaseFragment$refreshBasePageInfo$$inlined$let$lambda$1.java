package com.alient.onearch.adapter;

import com.alibaba.fastjson.JSONObject;
import com.youku.arch.v3.data.Repository;
import com.youku.arch.v3.io.Callback;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.IResponse;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.ur2;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Ltb/ur2;", "invoke", "()V", "com/alient/onearch/adapter/BaseFragment$refreshBasePageInfo$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class BaseFragment$refreshBasePageInfo$$inlined$let$lambda$1 extends Lambda implements Function0<ur2> {
    final /* synthetic */ PageRefreshCallBack $callBack$inlined;
    final /* synthetic */ IRequest $it;
    final /* synthetic */ String $pageSection$inlined;
    final /* synthetic */ BaseFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseFragment$refreshBasePageInfo$$inlined$let$lambda$1(IRequest iRequest, BaseFragment baseFragment, String str, PageRefreshCallBack pageRefreshCallBack) {
        super(0);
        this.$it = iRequest;
        this.this$0 = baseFragment;
        this.$pageSection$inlined = str;
        this.$callBack$inlined = pageRefreshCallBack;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        Repository.Companion.getInstance().request(this.$it, new Callback(this) {
            /* class com.alient.onearch.adapter.BaseFragment$refreshBasePageInfo$$inlined$let$lambda$1.AnonymousClass1 */
            final /* synthetic */ BaseFragment$refreshBasePageInfo$$inlined$let$lambda$1 this$0;

            {
                this.this$0 = r1;
            }

            @Override // com.youku.arch.v3.io.Callback
            public void onResponse(@NotNull IResponse iResponse) {
                JSONObject jSONObject;
                JSONObject jSONObject2;
                JSONObject jSONObject3;
                k21.i(iResponse, "response");
                JSONObject jsonObject = iResponse.getJsonObject();
                if (jsonObject != null && (jSONObject = jsonObject.getJSONObject("data")) != null && (jSONObject2 = jSONObject.getJSONObject("data")) != null && (jSONObject3 = jSONObject2.getJSONObject(this.this$0.$pageSection$inlined)) != null) {
                    this.this$0.$callBack$inlined.onCallBack(jSONObject3);
                }
            }
        });
    }
}
