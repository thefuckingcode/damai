package com.youku.gaiax.provider.module.js;

import android.app.Activity;
import android.content.DialogInterface;
import com.alibaba.fastjson.JSONObject;
import com.alient.oneservice.appconfig.AppConfigProviderProxy;
import com.taobao.android.purchase.core.utils.PurchaseConstants;
import com.youku.gaiax.js.api.IGaiaXCallback;
import com.youku.gaiax.provider.module.proxy.PictureGaiaXProviderProxy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.k21;
import tb.ur2;

final class GaiaXBuildInProviderModule$showAlert$1 extends Lambda implements Function0<ur2> {
    final /* synthetic */ IGaiaXCallback $callback;
    final /* synthetic */ String $message;
    final /* synthetic */ String $title;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GaiaXBuildInProviderModule$showAlert$1(String str, String str2, IGaiaXCallback iGaiaXCallback) {
        super(0);
        this.$title = str;
        this.$message = str2;
        this.$callback = iGaiaXCallback;
    }

    /* renamed from: invoke$lambda-4$lambda-1 */
    public static final void m908invoke$lambda4$lambda1(IGaiaXCallback iGaiaXCallback, DialogInterface dialogInterface, int i) {
        k21.i(iGaiaXCallback, "$callback");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put((Object) "canceled", (Object) Boolean.FALSE);
        ur2 ur2 = ur2.INSTANCE;
        iGaiaXCallback.invoke(jSONObject);
        dialogInterface.dismiss();
    }

    /* renamed from: invoke$lambda-4$lambda-3 */
    public static final void m909invoke$lambda4$lambda3(IGaiaXCallback iGaiaXCallback, DialogInterface dialogInterface, int i) {
        k21.i(iGaiaXCallback, "$callback");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put((Object) "canceled", (Object) Boolean.TRUE);
        ur2 ur2 = ur2.INSTANCE;
        iGaiaXCallback.invoke(jSONObject);
        dialogInterface.dismiss();
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        Activity activity = AppConfigProviderProxy.topActivity();
        if (activity != null) {
            String str = this.$title;
            String str2 = this.$message;
            IGaiaXCallback iGaiaXCallback = this.$callback;
            PictureGaiaXProviderProxy.Companion.getMiddleProvider().PictureCommonDialog(activity, str, str2, "取消", PurchaseConstants.CONFIRM, new b(iGaiaXCallback), new a(iGaiaXCallback)).show();
        }
    }
}
