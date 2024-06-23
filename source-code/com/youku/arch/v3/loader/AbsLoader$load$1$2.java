package com.youku.arch.v3.loader;

import com.ali.user.open.core.util.ParamsConstants;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.EventDispatcher;
import com.youku.arch.v3.data.DataLoadCallback;
import com.youku.arch.v3.event.LoaderEvent;
import com.youku.arch.v3.io.Callback;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.util.ArchMontior;
import com.youku.arch.v3.util.ArchMontiorManager;
import com.youku.arch.v3.util.LogUtil;
import com.youku.middlewareservice.provider.analytics.AnalyticsProviderProxy;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.po2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/youku/arch/v3/loader/AbsLoader$load$1$2", "Lcom/youku/arch/v3/data/DataLoadCallback;", "Lcom/youku/arch/v3/io/IResponse;", "response", "Ltb/ur2;", "onFilter", "onResponse", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class AbsLoader$load$1$2 implements DataLoadCallback {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ int $pageIndex;
    final /* synthetic */ long $start;
    final /* synthetic */ AbsLoader<HOST> this$0;

    AbsLoader$load$1$2(AbsLoader<HOST> absLoader, int i, long j) {
        this.this$0 = absLoader;
        this.$pageIndex = i;
        this.$start = j;
    }

    @Override // com.youku.arch.v3.data.DataLoadCallback
    public void onFilter(@NotNull IResponse iResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "175829590")) {
            ipChange.ipc$dispatch("175829590", new Object[]{this, iResponse});
            return;
        }
        k21.i(iResponse, "response");
        Callback callback = this.this$0.getCallback();
        DataLoadCallback dataLoadCallback = callback instanceof DataLoadCallback ? (DataLoadCallback) callback : null;
        if (dataLoadCallback != null) {
            dataLoadCallback.onFilter(iResponse);
        }
    }

    @Override // com.youku.arch.v3.io.Callback
    public void onResponse(@NotNull IResponse iResponse) {
        ArchMontior archMontior;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1642899731")) {
            ipChange.ipc$dispatch("-1642899731", new Object[]{this, iResponse});
            return;
        }
        k21.i(iResponse, "response");
        if (AppInfoProviderProxy.isDebuggable()) {
            LogUtil.d("AbsLoader", k21.r("onResponse ", Boolean.valueOf(iResponse.isSuccess())));
        }
        if (k21.d(iResponse.getSource(), "remote")) {
            String pageName = this.this$0.getHost().getPageContext().getPageName();
            if (!(pageName == null || (archMontior = ArchMontiorManager.Companion.get(pageName)) == null)) {
                archMontior.setRequestTime(System.currentTimeMillis() - archMontior.getRequestTime());
            }
            HashMap hashMap = new HashMap();
            IRequest request = iResponse.getRequest();
            Map<String, Object> map = null;
            String apiName = request == null ? null : request.getApiName();
            Objects.requireNonNull(apiName, "null cannot be cast to non-null type kotlin.String");
            hashMap.put("apiName", apiName);
            IRequest request2 = iResponse.getRequest();
            if (request2 != null) {
                map = request2.getDataParams();
            }
            Objects.requireNonNull(map, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>");
            hashMap.put("apiParams", po2.c(map));
            String retCode = iResponse.getRetCode();
            if (retCode != null) {
                hashMap.put("retCode", retCode);
            }
            String retMessage = iResponse.getRetMessage();
            if (retMessage != null) {
                hashMap.put("retMessage", retMessage);
            }
            String traceId = iResponse.getTraceId();
            if (traceId != null) {
                hashMap.put(ParamsConstants.Key.PARAM_TRACE_ID, traceId);
            }
            if (iResponse.isSuccess()) {
                EventDispatcher eventDispatcher = this.this$0.getHost().getPageContext().getEventDispatcher();
                if (eventDispatcher != null) {
                    eventDispatcher.dispatchEvent(LoaderEvent.REMOTE_REQUEST_SUCCESS, hashMap);
                }
            } else {
                try {
                    JSONObject jsonObject = iResponse.getJsonObject();
                    if (jsonObject != null) {
                        String jSONString = jsonObject.toJSONString();
                        if (jSONString != null) {
                            hashMap.put("responseData", jSONString);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                EventDispatcher eventDispatcher2 = this.this$0.getHost().getPageContext().getEventDispatcher();
                if (eventDispatcher2 != null) {
                    eventDispatcher2.dispatchEvent(LoaderEvent.REMOTE_REQUEST_FAILED, hashMap);
                }
            }
        }
        if (iResponse.isSuccess()) {
            this.this$0.handleLoadSuccess(iResponse, this.$pageIndex);
        } else {
            this.this$0.handleLoadFailure(iResponse);
        }
        String pageName2 = this.this$0.getHost().getPageContext().getPageName();
        if (pageName2 != null) {
            long j = this.$start;
            String str = (System.currentTimeMillis() - j) + "";
            AnalyticsProviderProxy.utCustomEvent(pageName2, 19999, "abs_load_time", str, this.$pageIndex + "", null);
        }
    }
}
