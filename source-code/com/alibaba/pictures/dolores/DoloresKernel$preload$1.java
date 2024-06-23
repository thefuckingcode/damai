package com.alibaba.pictures.dolores;

import com.alibaba.pictures.dolores.request.DoloresRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import tb.ur2;
import tb.vp;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"BizResponse", "Lcom/alibaba/pictures/dolores/request/DoloresRequest;", AdvanceSetting.NETWORK_TYPE, "Ltb/ur2;", "invoke", "(Lcom/alibaba/pictures/dolores/request/DoloresRequest;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class DoloresKernel$preload$1 extends Lambda implements Function1<DoloresRequest<BizResponse>, ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final DoloresKernel$preload$1 INSTANCE = new DoloresKernel$preload$1();

    DoloresKernel$preload$1() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(Object obj) {
        invoke((DoloresRequest) obj);
        return ur2.INSTANCE;
    }

    public final void invoke(@Nullable DoloresRequest<BizResponse> doloresRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1123902970")) {
            ipChange.ipc$dispatch("-1123902970", new Object[]{this, doloresRequest});
            return;
        }
        String a = DoloresKernel.Companion.a();
        StringBuilder sb = new StringBuilder();
        sb.append("preload:doOnKTStart:");
        sb.append(doloresRequest != null ? doloresRequest.getClass().getSimpleName() : null);
        vp.a(a, sb.toString());
    }
}
