package com.alibaba.yymidservice.popup.request;

import com.alibaba.yymidservice.popup.request.bean.PopupReportResponseBean;
import com.alibaba.yymidservice.popup.request.requestparam.PopupRequestParam;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tb.fb0;
import tb.k21;
import tb.ur2;
import tb.xz2;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n"}, d2 = {"Ltb/fb0;", "Lcom/alibaba/yymidservice/popup/request/bean/PopupReportResponseBean;", AdvanceSetting.NETWORK_TYPE, "Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class PopupReportRequest$popupReportRequest$3 extends Lambda implements Function1<fb0<PopupReportResponseBean>, ur2> {
    final /* synthetic */ JSONObject $args;
    final /* synthetic */ String $comboCityId;
    final /* synthetic */ String $pkId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PopupReportRequest$popupReportRequest$3(String str, String str2, JSONObject jSONObject) {
        super(1);
        this.$comboCityId = str;
        this.$pkId = str2;
        this.$args = jSONObject;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(fb0<PopupReportResponseBean> fb0) {
        invoke(fb0);
        return ur2.INSTANCE;
    }

    public final void invoke(@NotNull fb0<PopupReportResponseBean> fb0) {
        k21.i(fb0, AdvanceSetting.NETWORK_TYPE);
        xz2 xz2 = xz2.INSTANCE;
        String str = new PopupRequestParam().API_NAME;
        String e = fb0.e();
        if (e == null) {
            e = null;
        }
        String f = fb0.f();
        xz2.a(xz2.b(str, "弹窗上报请求", e, f, "comboCityId: " + this.$comboCityId + "  pkId: " + ((Object) this.$pkId) + "  args : " + this.$args), "-107", "弹窗上报请求");
    }
}
