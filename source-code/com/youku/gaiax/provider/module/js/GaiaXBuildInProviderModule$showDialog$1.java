package com.youku.gaiax.provider.module.js;

import android.app.Activity;
import android.content.DialogInterface;
import com.alient.oneservice.appconfig.AppConfigProviderProxy;
import com.youku.gaiax.js.api.IGaiaXCallback;
import com.youku.gaiax.provider.module.proxy.PictureGaiaXProviderProxy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.k21;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
final class GaiaXBuildInProviderModule$showDialog$1 extends Lambda implements Function0<ur2> {
    final /* synthetic */ IGaiaXCallback $callback;
    final /* synthetic */ String $cancelText;
    final /* synthetic */ String $confirmText;
    final /* synthetic */ String $content;
    final /* synthetic */ String $title;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GaiaXBuildInProviderModule$showDialog$1(String str, String str2, String str3, String str4, IGaiaXCallback iGaiaXCallback) {
        super(0);
        this.$title = str;
        this.$content = str2;
        this.$cancelText = str3;
        this.$confirmText = str4;
        this.$callback = iGaiaXCallback;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-2$lambda-0  reason: not valid java name */
    public static final void m910invoke$lambda2$lambda0(IGaiaXCallback iGaiaXCallback, DialogInterface dialogInterface, int i) {
        k21.i(iGaiaXCallback, "$callback");
        dialogInterface.dismiss();
        IGaiaXCallback.DefaultImpls.invoke$default(iGaiaXCallback, null, 1, null);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-2$lambda-1  reason: not valid java name */
    public static final void m911invoke$lambda2$lambda1(IGaiaXCallback iGaiaXCallback, DialogInterface dialogInterface, int i) {
        k21.i(iGaiaXCallback, "$callback");
        dialogInterface.dismiss();
        IGaiaXCallback.DefaultImpls.invoke$default(iGaiaXCallback, null, 1, null);
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        Activity activity = AppConfigProviderProxy.topActivity();
        if (activity != null) {
            String str = this.$title;
            String str2 = this.$content;
            String str3 = this.$cancelText;
            String str4 = this.$confirmText;
            IGaiaXCallback iGaiaXCallback = this.$callback;
            PictureGaiaXProviderProxy.Companion.getMiddleProvider().PictureCommonDialog(activity, str, str2, str3, str4, new d(iGaiaXCallback), new c(iGaiaXCallback)).show();
        }
    }
}
