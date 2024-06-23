package com.youku.gaiax.provider.module.js;

import com.alient.oneservice.userinfo.YYLoginListener;
import com.youku.gaiax.js.api.IGaiaXCallback;
import com.youku.gaiax.js.api.IGaiaXPromise;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/youku/gaiax/provider/module/js/GaiaXBuildInProviderModule$login$1", "Lcom/alient/oneservice/userinfo/YYLoginListener;", "Ltb/ur2;", "onLoginSuccess", "onLoginFail", "onLoginCancel", "onLogout", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXBuildInProviderModule$login$1 implements YYLoginListener {
    final /* synthetic */ IGaiaXPromise $promise;

    GaiaXBuildInProviderModule$login$1(IGaiaXPromise iGaiaXPromise) {
        this.$promise = iGaiaXPromise;
    }

    @Override // com.alient.oneservice.userinfo.YYLoginListener
    public void onLoginCancel() {
        IGaiaXCallback.DefaultImpls.invoke$default(this.$promise.reject(), null, 1, null);
    }

    @Override // com.alient.oneservice.userinfo.YYLoginListener
    public void onLoginFail() {
        IGaiaXCallback.DefaultImpls.invoke$default(this.$promise.reject(), null, 1, null);
    }

    @Override // com.alient.oneservice.userinfo.YYLoginListener
    public void onLoginSuccess() {
        IGaiaXCallback.DefaultImpls.invoke$default(this.$promise.resolve(), null, 1, null);
    }

    @Override // com.alient.oneservice.userinfo.YYLoginListener
    public void onLogout() {
    }
}
