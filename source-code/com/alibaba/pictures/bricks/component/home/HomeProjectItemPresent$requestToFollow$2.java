package com.alibaba.pictures.bricks.component.home;

import com.alibaba.pictures.dolores.request.DoloresRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import tb.ur2;

/* compiled from: Taobao */
public final class HomeProjectItemPresent$requestToFollow$2 extends Lambda implements Function1<DoloresRequest<FollowStateBean>, ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final HomeProjectItemPresent$requestToFollow$2 INSTANCE = new HomeProjectItemPresent$requestToFollow$2();

    HomeProjectItemPresent$requestToFollow$2() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(DoloresRequest<FollowStateBean> doloresRequest) {
        invoke(doloresRequest);
        return ur2.INSTANCE;
    }

    public final void invoke(@Nullable DoloresRequest<FollowStateBean> doloresRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-148767844")) {
            ipChange.ipc$dispatch("-148767844", new Object[]{this, doloresRequest});
        }
    }
}
