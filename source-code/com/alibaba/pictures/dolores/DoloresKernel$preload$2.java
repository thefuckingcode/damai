package com.alibaba.pictures.dolores;

import com.alibaba.pictures.dolores.preload.IPreloadListener;
import com.alibaba.pictures.dolores.preload.PreloadState;
import com.alibaba.pictures.dolores.request.DoloresRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import tb.is1;
import tb.ur2;
import tb.vp;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"BizResponse", "", "isHit", "bizResponse", "Ltb/ur2;", "invoke", "(ZLjava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class DoloresKernel$preload$2 extends Lambda implements Function2<Boolean, BizResponse, ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ IPreloadListener $preloadListener;
    final /* synthetic */ is1 $wrapper;
    final /* synthetic */ DoloresKernel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DoloresKernel$preload$2(DoloresKernel doloresKernel, is1 is1, IPreloadListener iPreloadListener) {
        super(2);
        this.this$0 = doloresKernel;
        this.$wrapper = is1;
        this.$preloadListener = iPreloadListener;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ ur2 invoke(Boolean bool, Object obj) {
        invoke(bool.booleanValue(), obj);
        return ur2.INSTANCE;
    }

    public final void invoke(boolean z, @Nullable BizResponse bizresponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1137436263")) {
            ipChange.ipc$dispatch("1137436263", new Object[]{this, Boolean.valueOf(z), bizresponse});
            return;
        }
        this.$wrapper.l(PreloadState.STATE_HIT_CACHE);
        this.$wrapper.i(bizresponse);
        IPreloadListener iPreloadListener = this.$preloadListener;
        if (iPreloadListener != null) {
            iPreloadListener.onHitCache(bizresponse);
        }
        String a = DoloresKernel.Companion.a();
        StringBuilder sb = new StringBuilder();
        sb.append("preload:doOnKTHitCache:");
        DoloresRequest m = this.this$0.m();
        sb.append(m != null ? m.getClass().getSimpleName() : null);
        vp.a(a, sb.toString());
    }
}
