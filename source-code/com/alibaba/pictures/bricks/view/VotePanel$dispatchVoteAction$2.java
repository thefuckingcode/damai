package com.alibaba.pictures.bricks.view;

import com.alibaba.pictures.bricks.bean.VoteActionRes;
import com.alibaba.pictures.bricks.util.toast.BricksToastUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.fb0;
import tb.k21;
import tb.ur2;

/* compiled from: Taobao */
public final class VotePanel$dispatchVoteAction$2 extends Lambda implements Function1<fb0<VoteActionRes>, ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ VotePanel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VotePanel$dispatchVoteAction$2(VotePanel votePanel) {
        super(1);
        this.this$0 = votePanel;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(fb0<VoteActionRes> fb0) {
        invoke(fb0);
        return ur2.INSTANCE;
    }

    public final void invoke(@NotNull fb0<VoteActionRes> fb0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "373992329")) {
            ipChange.ipc$dispatch("373992329", new Object[]{this, fb0});
            return;
        }
        k21.i(fb0, AdvanceSetting.NETWORK_TYPE);
        this.this$0.g.showActivityLoading(false);
        BricksToastUtil.INSTANCE.b(fb0.d());
    }
}
