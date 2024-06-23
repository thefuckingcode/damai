package com.alibaba.yymidservice.popup.request;

import android.content.Context;
import com.alibaba.yymidservice.popup.request.requestparam.PopupReportRequestParam;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tb.k21;
import tb.ta0;
import tb.ur2;

/* compiled from: Taobao */
public final class PopupReportRequest {
    public final void a(@NotNull Context context, @NotNull String str, @Nullable String str2, @Nullable JSONObject jSONObject) {
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(str, "comboCityId");
        ta0.a aVar = ta0.Companion;
        PopupReportRequestParam popupReportRequestParam = new PopupReportRequestParam();
        popupReportRequestParam.setComboCityId(str);
        popupReportRequestParam.setPkId(str2);
        popupReportRequestParam.setArgs(jSONObject);
        ur2 ur2 = ur2.INSTANCE;
        aVar.b(popupReportRequestParam).c(context).a().doOnKTSuccess(PopupReportRequest$popupReportRequest$2.INSTANCE).doOnKTFail(new PopupReportRequest$popupReportRequest$3(str, str2, jSONObject)).doOnKTFinish(PopupReportRequest$popupReportRequest$4.INSTANCE);
    }
}
