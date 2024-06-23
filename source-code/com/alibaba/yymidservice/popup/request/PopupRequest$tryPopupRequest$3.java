package com.alibaba.yymidservice.popup.request;

import android.app.Activity;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.yymidservice.popup.request.bean.PopupResponseBean;
import com.alibaba.yymidservice.popup.request.requestparam.PopupRequestParam;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import tb.fb0;
import tb.k21;
import tb.kr1;
import tb.or1;
import tb.ur2;
import tb.xz2;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n"}, d2 = {"Ltb/fb0;", "Lcom/alibaba/yymidservice/popup/request/bean/PopupResponseBean;", AdvanceSetting.NETWORK_TYPE, "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class PopupRequest$tryPopupRequest$3 extends Lambda implements Function1<fb0<PopupResponseBean>, ur2> {
    final /* synthetic */ JSONObject $args;
    final /* synthetic */ String $comboCityId;
    final /* synthetic */ Activity $context;
    final /* synthetic */ String $eventType;
    final /* synthetic */ PopupListener $listener;
    final /* synthetic */ String $sceneType;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PopupRequest$tryPopupRequest$3(String str, String str2, String str3, JSONObject jSONObject, Activity activity, PopupListener popupListener) {
        super(1);
        this.$comboCityId = str;
        this.$sceneType = str2;
        this.$eventType = str3;
        this.$args = jSONObject;
        this.$context = activity;
        this.$listener = popupListener;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(fb0<PopupResponseBean> fb0) {
        invoke(fb0);
        return ur2.INSTANCE;
    }

    public final void invoke(@NotNull fb0<PopupResponseBean> fb0) {
        k21.i(fb0, AdvanceSetting.NETWORK_TYPE);
        kr1.Companion.a().l().compareAndSet(false, false);
        String ttid = AppInfoProviderProxy.getTTID();
        xz2 xz2 = xz2.INSTANCE;
        String str = new PopupRequestParam().API_NAME;
        String e = fb0.e();
        String f = fb0.f();
        xz2.a(xz2.b(str, "弹窗请求", e, f, "comboChannel :  " + ((Object) ttid) + "  comboCityId : " + this.$comboCityId + " sceneType: " + this.$sceneType + "  eventType：" + ((Object) this.$eventType) + " args : " + this.$args), "-106", "弹窗请求");
        HashMap hashMap = new HashMap();
        String f2 = fb0.f();
        if (f2 == null) {
            f2 = "错误描述为空";
        }
        hashMap.put("message", f2);
        String e2 = fb0.e();
        if (e2 == null) {
            e2 = "错误码为空";
        }
        hashMap.put("code", e2);
        String simpleName = this.$context.getClass().getSimpleName();
        k21.h(simpleName, "context::class.java.simpleName");
        or1.g(simpleName, AgooConstants.MESSAGE_POPUP, "request_fail", hashMap);
        PopupListener popupListener = this.$listener;
        if (popupListener != null) {
            popupListener.onFail(String.valueOf(fb0.e()), fb0.f());
        }
    }
}
