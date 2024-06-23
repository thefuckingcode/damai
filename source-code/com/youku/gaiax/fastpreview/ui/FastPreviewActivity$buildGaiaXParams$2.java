package com.youku.gaiax.fastpreview.ui;

import android.util.Log;
import com.alibaba.gaiax.studio.GXSocket;
import com.taobao.weex.WXGlobalEventReceiver;
import com.youku.gaiax.GaiaX;
import com.youku.gaiax.api.data.EventParams;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.jl1;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/youku/gaiax/fastpreview/ui/FastPreviewActivity$buildGaiaXParams$2", "Lcom/youku/gaiax/GaiaX$IEventDelegate;", "Lcom/youku/gaiax/api/data/EventParams;", WXGlobalEventReceiver.EVENT_PARAMS, "Ltb/ur2;", "onEvent", "workspace_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class FastPreviewActivity$buildGaiaXParams$2 implements GaiaX.IEventDelegate {
    FastPreviewActivity$buildGaiaXParams$2() {
    }

    @Override // com.youku.gaiax.GaiaX.IEventDelegate
    public void onEvent(@NotNull EventParams eventParams) {
        k21.i(eventParams, WXGlobalEventReceiver.EVENT_PARAMS);
        Log.d(GXSocket.TAG, "onEvent() called with: eventParams = [" + eventParams + jl1.ARRAY_END);
    }
}
