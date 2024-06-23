package com.youku.gaiax.provider.module.js;

import android.app.Activity;
import com.alient.oneservice.appconfig.AppConfigProviderProxy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Ltb/ur2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* compiled from: Taobao */
final class GaiaXBuildInProviderModule$showToast$1 extends Lambda implements Function0<ur2> {
    final /* synthetic */ int $durationType;
    final /* synthetic */ String $title;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GaiaXBuildInProviderModule$showToast$1(String str, int i) {
        super(0);
        this.$title = str;
        this.$durationType = i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        Activity activity = AppConfigProviderProxy.topActivity();
        if (activity != null) {
            AppConfigProviderProxy.showToast(activity, this.$title, this.$durationType);
        }
    }
}
