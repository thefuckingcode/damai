package com.alient.gaiax.container.gaiax;

import android.view.View;
import com.youku.gaiax.GaiaX;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\t"}, d2 = {"com/alient/gaiax/container/gaiax/GaiaXBuilder$renderGaiaX$1$3", "Lcom/youku/gaiax/GaiaX$IStatusDelegate;", "Lcom/youku/gaiax/GaiaX$Params;", "params", "Landroid/view/View;", "resultView", "Ltb/ur2;", "onViewInjected", "onViewUpdated", "gaiax-container_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXBuilder$renderGaiaX$1$3 implements GaiaX.IStatusDelegate {
    final /* synthetic */ PictureGaiaXDelegate $yyDelegate;

    GaiaXBuilder$renderGaiaX$1$3(PictureGaiaXDelegate pictureGaiaXDelegate) {
        this.$yyDelegate = pictureGaiaXDelegate;
    }

    @Override // com.youku.gaiax.GaiaX.IStatusDelegate
    public void onViewInjected(@NotNull GaiaX.Params params, @NotNull View view) {
        k21.i(params, "params");
        k21.i(view, "resultView");
        PictureGaiaXDelegate pictureGaiaXDelegate = this.$yyDelegate;
        if (pictureGaiaXDelegate != null) {
            pictureGaiaXDelegate.doViewInjectedFun(params, view);
        }
    }

    @Override // com.youku.gaiax.GaiaX.IStatusDelegate
    public void onViewUpdated(@NotNull GaiaX.Params params, @NotNull View view) {
        k21.i(params, "params");
        k21.i(view, "resultView");
        PictureGaiaXDelegate pictureGaiaXDelegate = this.$yyDelegate;
        if (pictureGaiaXDelegate != null) {
            pictureGaiaXDelegate.doViewUpdatedFun(params, view);
        }
    }
}
