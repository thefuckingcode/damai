package com.youku.gaiax.fastpreview.ui;

import android.util.Log;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.studio.GXSocket;
import com.youku.gaiax.GaiaX;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.jl1;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"com/youku/gaiax/fastpreview/ui/FastPreviewActivity$buildGaiaXParams$3", "Lcom/youku/gaiax/GaiaX$IHostMessage;", "", "type", "Lcom/alibaba/fastjson/JSONObject;", "data", "", "onMessage", "workspace_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class FastPreviewActivity$buildGaiaXParams$3 implements GaiaX.IHostMessage {
    FastPreviewActivity$buildGaiaXParams$3() {
    }

    @Override // com.youku.gaiax.GaiaX.IHostMessage
    public boolean onMessage(@NotNull String str, @NotNull JSONObject jSONObject) {
        k21.i(str, "type");
        k21.i(jSONObject, "data");
        Log.e(GXSocket.TAG, "onMessage() called with: type = [" + str + "], data = [" + jSONObject + jl1.ARRAY_END);
        return false;
    }
}
