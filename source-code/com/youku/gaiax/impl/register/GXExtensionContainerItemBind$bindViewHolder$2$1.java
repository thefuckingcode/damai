package com.youku.gaiax.impl.register;

import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.youku.gaiax.GaiaX;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"com/youku/gaiax/impl/register/GXExtensionContainerItemBind$bindViewHolder$2$1", "Lcom/youku/gaiax/GaiaX$IRouterDelegate2;", "Landroid/view/View;", "targetView", "", "targetViewId", "", "targetPosition", "Lcom/alibaba/fastjson/JSONObject;", "targetData", "Lcom/youku/gaiax/GaiaX$Params;", "targetParams", "Ltb/ur2;", "onAction", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GXExtensionContainerItemBind$bindViewHolder$2$1 implements GaiaX.IRouterDelegate2 {
    final /* synthetic */ int $childItemPosition;
    final /* synthetic */ GaiaX.IRouterDelegate2 $parentDelegate;

    GXExtensionContainerItemBind$bindViewHolder$2$1(GaiaX.IRouterDelegate2 iRouterDelegate2, int i) {
        this.$parentDelegate = iRouterDelegate2;
        this.$childItemPosition = i;
    }

    @Override // com.youku.gaiax.GaiaX.IRouterDelegate2
    public void onAction(@NotNull View view, @NotNull String str, int i, @NotNull JSONObject jSONObject, @NotNull GaiaX.Params params) {
        k21.i(view, "targetView");
        k21.i(str, "targetViewId");
        k21.i(jSONObject, "targetData");
        k21.i(params, "targetParams");
        this.$parentDelegate.onAction(view, str, this.$childItemPosition, jSONObject, params);
    }
}
