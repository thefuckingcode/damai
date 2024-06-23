package com.alibaba.pictures.bricks.component.script;

import android.view.View;
import com.alibaba.pictures.R$raw;
import com.alibaba.pictures.bricks.component.home.FollowStateBean;
import com.alibaba.pictures.bricks.util.toast.BricksToastUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.ur2;

/* compiled from: Taobao */
public final class ScriptInfoPresent$requestFollow$3 extends Lambda implements Function1<FollowStateBean, ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ View $view;
    final /* synthetic */ ScriptInfoPresent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScriptInfoPresent$requestFollow$3(ScriptInfoPresent scriptInfoPresent, View view) {
        super(1);
        this.this$0 = scriptInfoPresent;
        this.$view = view;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(FollowStateBean followStateBean) {
        invoke(followStateBean);
        return ur2.INSTANCE;
    }

    public final void invoke(@NotNull FollowStateBean followStateBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2059688373")) {
            ipChange.ipc$dispatch("2059688373", new Object[]{this, followStateBean});
            return;
        }
        k21.i(followStateBean, AdvanceSetting.NETWORK_TYPE);
        ScriptInfoPresent scriptInfoPresent = this.this$0;
        View view = this.$view;
        boolean isFollowed = followStateBean.isFollowed();
        scriptInfoPresent.setCurrentUserFollowed(isFollowed);
        String str = followStateBean.status;
        if (str != null) {
            k21.h(str, "status");
            String str2 = followStateBean.status;
            k21.h(str2, "status");
            scriptInfoPresent.setFavoriteFlag(str2);
        }
        ScriptInfoPresent.access$followStatusChanged(scriptInfoPresent, followStateBean.status, true);
        if (isFollowed) {
            BricksToastUtil.INSTANCE.d("想玩成功", "已添加到\"我的-想看&想玩\"", R$raw.toast_lottie_peach_heart);
        } else {
            BricksToastUtil.INSTANCE.b("已取消想玩");
        }
        view.setClickable(true);
    }
}
