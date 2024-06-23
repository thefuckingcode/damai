package com.alibaba.pictures.dolores;

import com.alibaba.pictures.dolores.DoloresKernel;
import com.alibaba.pictures.dolores.business.AsyncResult;
import com.alibaba.pictures.dolores.preload.IPreloadListener;
import com.alibaba.pictures.dolores.preload.PreloadState;
import com.alibaba.pictures.dolores.request.DoloresRequest;
import com.alibaba.pictures.dolores.response.BizResponseType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.fb0;
import tb.hs1;
import tb.is1;
import tb.jl1;
import tb.k21;
import tb.ur2;
import tb.vp;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"BizResponse", "Ltb/ur2;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class DoloresKernel$preload$3 extends Lambda implements Function0<ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ AsyncResult $asyncRequest;
    final /* synthetic */ IPreloadListener $preloadListener;
    final /* synthetic */ long $validTime;
    final /* synthetic */ is1 $wrapper;
    final /* synthetic */ DoloresKernel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DoloresKernel$preload$3(DoloresKernel doloresKernel, AsyncResult asyncResult, is1 is1, long j, IPreloadListener iPreloadListener) {
        super(0);
        this.this$0 = doloresKernel;
        this.$asyncRequest = asyncResult;
        this.$wrapper = is1;
        this.$validTime = j;
        this.$preloadListener = iPreloadListener;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1754151722")) {
            ipChange.ipc$dispatch("1754151722", new Object[]{this});
            return;
        }
        DoloresKernel.a aVar = DoloresKernel.Companion;
        String a = aVar.a();
        StringBuilder sb = new StringBuilder();
        sb.append("preload:doOnKTFinish:");
        DoloresRequest m = this.this$0.m();
        sb.append(m != null ? m.getClass().getSimpleName() : null);
        vp.a(a, sb.toString());
        fb0 response = this.$asyncRequest.getResponse();
        if (response != null) {
            response.k(true);
        }
        this.$wrapper.k(response);
        this.$wrapper.j(System.currentTimeMillis() + this.$validTime);
        this.$wrapper.l(PreloadState.STATE_FINISH);
        AsyncResult b = this.$wrapper.b();
        DoloresKernel c = this.$wrapper.c();
        if (c == null || b == null || response == null) {
            IPreloadListener iPreloadListener = this.$preloadListener;
            if (iPreloadListener != null) {
                iPreloadListener.onPreloadOver(response, false);
            }
            vp.a(aVar.a(), "preload:doOnKTFinish:真实业务请求还没有发出,只缓存!");
            return;
        }
        hs1.INSTANCE.d(this.this$0.m());
        b.setResponse(response);
        response.o(b.getTag());
        if (c.u()) {
            String a2 = aVar.a();
            vp.d(a2, "preload:[" + c.g() + "]->该请求被取消||返回时业务调用页面生命周期已结束");
            b.onFinish();
            c.z();
            return;
        }
        vp.a(aVar.a(), "preload:doOnKTFinish:真实业务已经发出,处理onFail或success!");
        if (response.b() == BizResponseType.RESULT_SUCCESS.getCode()) {
            String a3 = aVar.a();
            vp.a(a3, jl1.ARRAY_START + c.g() + "]->onSuccess call back");
            if (response.a() != null) {
                Object a4 = response.a();
                k21.f(a4);
                b.onSuccess(a4);
            } else if (!b.onSuccessNull(response)) {
                b.onFail(response);
            }
        } else {
            String a5 = aVar.a();
            vp.a(a5, "preload:[" + c.g() + "]->onFail call back");
            b.onFail(response);
        }
        b.onFinish();
        IPreloadListener iPreloadListener2 = this.$preloadListener;
        if (iPreloadListener2 != null) {
            iPreloadListener2.onPreloadOver(response, true);
        }
        c.z();
        String a6 = aVar.a();
        vp.a(a6, "preload:[" + c.g() + "]->AsyncRequestFuture done");
    }
}
