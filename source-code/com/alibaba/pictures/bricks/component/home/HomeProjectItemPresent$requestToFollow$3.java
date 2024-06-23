package com.alibaba.pictures.bricks.component.home;

import com.alibaba.pictures.bricks.bean.HomeProjectItemBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.youku.arch.v3.core.EventDispatcher;
import com.youku.arch.v3.core.item.GenericItem;
import java.util.HashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.ur2;

/* compiled from: Taobao */
public final class HomeProjectItemPresent$requestToFollow$3 extends Lambda implements Function1<FollowStateBean, ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ HomeProjectItemPresent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeProjectItemPresent$requestToFollow$3(HomeProjectItemPresent homeProjectItemPresent) {
        super(1);
        this.this$0 = homeProjectItemPresent;
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
        if (AndroidInstantRuntime.support(ipChange, "1940888620")) {
            ipChange.ipc$dispatch("1940888620", new Object[]{this, followStateBean});
            return;
        }
        k21.i(followStateBean, AdvanceSetting.NETWORK_TYPE);
        HomeProjectItemPresent homeProjectItemPresent = this.this$0;
        boolean isFollowed = followStateBean.isFollowed();
        ((HomeProjectItemBean) ((HomeProjectItemModel) homeProjectItemPresent.getModel()).getValue()).isFollow = isFollowed ? "true" : "false";
        ((GenericItem) homeProjectItemPresent.getItem()).getComponent().getProperty().getData();
        ((HomeProjectItemView) homeProjectItemPresent.getView()).updateWantSeeBtn(isFollowed);
        if (isFollowed) {
            HashMap hashMap = new HashMap();
            hashMap.put("id", ((HomeProjectItemBean) ((HomeProjectItemModel) homeProjectItemPresent.getModel()).getValue()).id);
            EventDispatcher eventDispatcher = ((GenericItem) homeProjectItemPresent.getItem()).getPageContext().getEventDispatcher();
            if (eventDispatcher != null) {
                eventDispatcher.dispatchEvent("EventBus://fragment/notification/home/item/follow-request", hashMap);
            }
        }
    }
}
