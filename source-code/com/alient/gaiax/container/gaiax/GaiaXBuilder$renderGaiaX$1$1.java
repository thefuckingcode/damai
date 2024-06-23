package com.alient.gaiax.container.gaiax;

import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alient.gaiax.container.gaiax.GaiaxAutoEventTrack;
import com.taobao.weex.WXGlobalEventReceiver;
import com.youku.gaiax.GaiaX;
import com.youku.gaiax.api.data.EventParams;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/alient/gaiax/container/gaiax/GaiaXBuilder$renderGaiaX$1$1", "Lcom/youku/gaiax/GaiaX$IEventDelegate;", "Lcom/youku/gaiax/api/data/EventParams;", WXGlobalEventReceiver.EVENT_PARAMS, "Ltb/ur2;", "onEvent", "gaiax-container_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXBuilder$renderGaiaX$1$1 implements GaiaX.IEventDelegate {
    final /* synthetic */ boolean $autoEventEnable;
    final /* synthetic */ boolean $autoUtEnable;
    final /* synthetic */ JSONObject $data;
    final /* synthetic */ View $gaiaxContainerView;
    final /* synthetic */ int $pos;
    final /* synthetic */ PictureGaiaXDelegate $yyDelegate;

    GaiaXBuilder$renderGaiaX$1$1(PictureGaiaXDelegate pictureGaiaXDelegate, View view, JSONObject jSONObject, int i, boolean z, boolean z2) {
        this.$yyDelegate = pictureGaiaXDelegate;
        this.$gaiaxContainerView = view;
        this.$data = jSONObject;
        this.$pos = i;
        this.$autoEventEnable = z;
        this.$autoUtEnable = z2;
    }

    @Override // com.youku.gaiax.GaiaX.IEventDelegate
    public void onEvent(@NotNull EventParams eventParams) {
        k21.i(eventParams, WXGlobalEventReceiver.EVENT_PARAMS);
        JSONObject data = eventParams.getData();
        ur2 ur2 = null;
        Object obj = data == null ? null : data.get("eventName");
        String str = obj instanceof String ? (String) obj : null;
        if (str != null) {
            PictureGaiaXDelegate pictureGaiaXDelegate = this.$yyDelegate;
            View view = this.$gaiaxContainerView;
            JSONObject jSONObject = this.$data;
            int i = this.$pos;
            boolean z = this.$autoEventEnable;
            if (k21.d("item", str)) {
                if (pictureGaiaXDelegate != null) {
                    pictureGaiaXDelegate.onItemViewClick(view, jSONObject, i);
                }
            } else if (pictureGaiaXDelegate != null) {
                pictureGaiaXDelegate.onGaiaXEvent(eventParams, jSONObject, i);
            }
            if (z) {
                GaiaxAutoEventTrack.INSTANCE.eventClick(eventParams, jSONObject, Integer.valueOf(i));
            }
            ur2 = ur2.INSTANCE;
        }
        if (ur2 == null) {
            PictureGaiaXDelegate pictureGaiaXDelegate2 = this.$yyDelegate;
            JSONObject jSONObject2 = this.$data;
            int i2 = this.$pos;
            if (pictureGaiaXDelegate2 != null) {
                pictureGaiaXDelegate2.onGaiaXEvent(eventParams, jSONObject2, i2);
            }
        }
        JSONObject data2 = eventParams.getData();
        if (data2 != null) {
            boolean z2 = this.$autoUtEnable;
            PictureGaiaXDelegate pictureGaiaXDelegate3 = this.$yyDelegate;
            JSONObject jSONObject3 = this.$data;
            int i3 = this.$pos;
            if (z2) {
                GaiaxAutoEventTrack.INSTANCE.trackUt(eventParams.getView(), data2, GaiaxAutoEventTrack.UtType.Click);
            }
            if (pictureGaiaXDelegate3 != null) {
                pictureGaiaXDelegate3.onTrackViewClick(eventParams, jSONObject3, i3);
            }
        }
    }
}
