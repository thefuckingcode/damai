package com.alient.gaiax.container.gaiax;

import android.util.Log;
import com.alibaba.fastjson.JSONObject;
import com.youku.arch.v3.view.AbsPresenter;
import com.youku.gaiax.GaiaX;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.jl1;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"com/alient/gaiax/container/gaiax/GaiaXBuilder$renderGaiaX$1$4", "Lcom/youku/gaiax/GaiaX$IHostMessage;", "", "type", "Lcom/alibaba/fastjson/JSONObject;", "data", "", "onMessage", "gaiax-container_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXBuilder$renderGaiaX$1$4 implements GaiaX.IHostMessage {
    final /* synthetic */ PictureGaiaXDelegate $yyDelegate;

    GaiaXBuilder$renderGaiaX$1$4(PictureGaiaXDelegate pictureGaiaXDelegate) {
        this.$yyDelegate = pictureGaiaXDelegate;
    }

    @Override // com.youku.gaiax.GaiaX.IHostMessage
    public boolean onMessage(@NotNull String str, @NotNull JSONObject jSONObject) {
        k21.i(str, "type");
        k21.i(jSONObject, "data");
        Log.e(AbsPresenter.TAG, "onMessage() called with: this = [" + this + jl1.ARRAY_END);
        if (!k21.d("GAIAX_JS_REFRESH_PAGE", str)) {
            k21.d("GAIAX_JS_REFRESH_CARD", str);
        }
        PictureGaiaXDelegate pictureGaiaXDelegate = this.$yyDelegate;
        if (pictureGaiaXDelegate == null) {
            return false;
        }
        return pictureGaiaXDelegate.onMessage(str, jSONObject);
    }
}
