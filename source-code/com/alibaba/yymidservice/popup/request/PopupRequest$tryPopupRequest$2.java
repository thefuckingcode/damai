package com.alibaba.yymidservice.popup.request;

import android.app.Activity;
import com.alibaba.yymidservice.popup.request.bean.PopupResponseBean;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import tb.bh0;
import tb.br1;
import tb.k21;
import tb.kr1;
import tb.or1;
import tb.ur2;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/alibaba/yymidservice/popup/request/bean/PopupResponseBean;", AdvanceSetting.NETWORK_TYPE, "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class PopupRequest$tryPopupRequest$2 extends Lambda implements Function1<PopupResponseBean, ur2> {
    final /* synthetic */ Activity $context;
    final /* synthetic */ PopupListener $listener;
    final /* synthetic */ String $sceneType;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PopupRequest$tryPopupRequest$2(String str, Activity activity, PopupListener popupListener) {
        super(1);
        this.$sceneType = str;
        this.$context = activity;
        this.$listener = popupListener;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(PopupResponseBean popupResponseBean) {
        invoke(popupResponseBean);
        return ur2.INSTANCE;
    }

    public final void invoke(@NotNull PopupResponseBean popupResponseBean) {
        k21.i(popupResponseBean, AdvanceSetting.NETWORK_TYPE);
        PopupRequest popupRequest = PopupRequest.INSTANCE;
        PopupRequest.a(popupRequest, popupResponseBean.spmab, popupResponseBean.show);
        PopupRequest.a(popupRequest, popupResponseBean.spmab, popupResponseBean.trigger);
        br1.a aVar = br1.Companion;
        aVar.a().n(popupResponseBean.sceneTypes);
        kr1.a aVar2 = kr1.Companion;
        aVar2.a().l().compareAndSet(false, true);
        HashMap hashMap = new HashMap();
        hashMap.put("sceneType", this.$sceneType.toString());
        hashMap.put("sceneTypes", bh0.INSTANCE.e(popupResponseBean.sceneTypes));
        String simpleName = this.$context.getClass().getSimpleName();
        k21.h(simpleName, "context::class.java.simpleName");
        or1.g(simpleName, AgooConstants.MESSAGE_POPUP, "request_success", hashMap);
        aVar.a().f().put(aVar2.a().c(this.$context), popupResponseBean);
        aVar.a().g().put(aVar2.a().c(this.$context), Boolean.TRUE);
        PopupListener popupListener = this.$listener;
        if (popupListener != null) {
            popupListener.onSuccess(popupResponseBean);
        }
    }
}
