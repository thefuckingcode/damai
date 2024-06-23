package com.alient.gaiax.container.gaiax;

import com.alibaba.fastjson.JSONObject;
import com.alient.gaiax.container.gaiax.GaiaxAutoEventTrack;
import com.youku.gaiax.GaiaX;
import com.youku.gaiax.api.data.TrackParams;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/alient/gaiax/container/gaiax/GaiaXBuilder$renderGaiaX$1$2", "Lcom/youku/gaiax/GaiaX$ITrackDelegate3;", "Lcom/youku/gaiax/api/data/TrackParams;", "trackParams", "Ltb/ur2;", "onTrack", "gaiax-container_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXBuilder$renderGaiaX$1$2 implements GaiaX.ITrackDelegate3 {
    final /* synthetic */ boolean $autoUtEnable;
    final /* synthetic */ JSONObject $data;
    final /* synthetic */ int $pos;
    final /* synthetic */ PictureGaiaXDelegate $yyDelegate;

    GaiaXBuilder$renderGaiaX$1$2(boolean z, PictureGaiaXDelegate pictureGaiaXDelegate, JSONObject jSONObject, int i) {
        this.$autoUtEnable = z;
        this.$yyDelegate = pictureGaiaXDelegate;
        this.$data = jSONObject;
        this.$pos = i;
    }

    @Override // com.youku.gaiax.GaiaX.ITrackDelegate3
    public void onTrack(@NotNull TrackParams trackParams) {
        k21.i(trackParams, "trackParams");
        JSONObject data = trackParams.getData();
        if (data != null) {
            boolean z = this.$autoUtEnable;
            PictureGaiaXDelegate pictureGaiaXDelegate = this.$yyDelegate;
            JSONObject jSONObject = this.$data;
            int i = this.$pos;
            if (z) {
                GaiaxAutoEventTrack.INSTANCE.trackUt(trackParams.getView(), data, GaiaxAutoEventTrack.UtType.Expose);
            }
            if (pictureGaiaXDelegate != null) {
                pictureGaiaXDelegate.onTrackViewExpose(trackParams, jSONObject, i);
            }
        }
    }
}
