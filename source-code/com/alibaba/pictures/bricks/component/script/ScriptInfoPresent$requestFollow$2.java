package com.alibaba.pictures.bricks.component.script;

import com.alibaba.pictures.bricks.component.home.FollowStateBean;
import com.alibaba.pictures.dolores.request.DoloresRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import tb.ur2;

/* compiled from: Taobao */
public final class ScriptInfoPresent$requestFollow$2 extends Lambda implements Function1<DoloresRequest<FollowStateBean>, ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final ScriptInfoPresent$requestFollow$2 INSTANCE = new ScriptInfoPresent$requestFollow$2();

    ScriptInfoPresent$requestFollow$2() {
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
        if (AndroidInstantRuntime.support(ipChange, "1885435443")) {
            ipChange.ipc$dispatch("1885435443", new Object[]{this, doloresRequest});
        }
    }
}
