package com.alibaba.pictures.bricks.component.home;

import android.util.Log;
import cn.damai.category.category.ui.StarFragment;
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
public final class HomeProjectItemPresent$requestToFollow$4 extends Lambda implements Function1<fb0<FollowStateBean>, ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final HomeProjectItemPresent$requestToFollow$4 INSTANCE = new HomeProjectItemPresent$requestToFollow$4();

    HomeProjectItemPresent$requestToFollow$4() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(fb0<FollowStateBean> fb0) {
        invoke(fb0);
        return ur2.INSTANCE;
    }

    public final void invoke(@NotNull fb0<FollowStateBean> fb0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-621714606")) {
            ipChange.ipc$dispatch("-621714606", new Object[]{this, fb0});
            return;
        }
        k21.i(fb0, AdvanceSetting.NETWORK_TYPE);
        Log.d(StarFragment.KEY_FOLLOW, "follow onfail : " + fb0.e() + fb0.d());
    }
}
