package com.alibaba.pictures.bricks.component.script;

import android.util.Log;
import android.view.View;
import cn.damai.category.category.ui.StarFragment;
import com.alibaba.pictures.bricks.component.home.FollowStateBean;
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
public final class ScriptInfoPresent$requestFollow$4 extends Lambda implements Function1<fb0<FollowStateBean>, ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ View $view;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScriptInfoPresent$requestFollow$4(View view) {
        super(1);
        this.$view = view;
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
        if (AndroidInstantRuntime.support(ipChange, "37524521")) {
            ipChange.ipc$dispatch("37524521", new Object[]{this, fb0});
            return;
        }
        k21.i(fb0, AdvanceSetting.NETWORK_TYPE);
        Log.d(StarFragment.KEY_FOLLOW, "follow onfail : " + fb0.e() + " , " + fb0.f());
        BricksToastUtil.INSTANCE.b("服务开小差,请重试");
        this.$view.setClickable(true);
    }
}
