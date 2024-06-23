package com.alient.gaiax.container.render;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alient.gaiax.container.gaiax.GaiaXBuilder;
import com.alient.gaiax.container.render.GenericGaiaxContract;
import com.alient.onearch.adapter.view.AbsView;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import com.youku.arch.v3.view.AbsPresenter;
import com.youku.gaiax.GaiaX;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.if1;
import tb.jl1;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b\u0016\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u0006B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0015¢\u0006\u0004\b \u0010!J0\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rR\u0016\u0010\u001c\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/alient/gaiax/container/render/GenericGaiaxView;", "Lcom/alient/onearch/adapter/view/AbsView;", "Lcom/youku/arch/v3/core/item/GenericItem;", "Lcom/youku/arch/v3/core/ItemValue;", "Lcom/alient/gaiax/container/render/GenericGaiaxModel;", "Lcom/alient/gaiax/container/render/GenericGaiaxPresenter;", "Lcom/alient/gaiax/container/render/GenericGaiaxContract$View;", "", if1.DIMEN_BIZ, "templateId", "version", "", "width", "Lcom/alibaba/fastjson/JSONObject;", "data", "Ltb/ur2;", "renderGaiax", "viewVisible", "viewInvisible", "Lcom/youku/gaiax/GaiaX$Params;", "targetParams", "Landroid/view/View;", "targetView", "doViewUpdated", "doViewInjected", "type", "", "onCustomMessage", "view", "Landroid/view/View;", "params", "Lcom/youku/gaiax/GaiaX$Params;", "<init>", "(Landroid/view/View;)V", "gaiax-container_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public class GenericGaiaxView extends AbsView<GenericItem<ItemValue>, GenericGaiaxModel, GenericGaiaxPresenter> implements GenericGaiaxContract.View {
    @Nullable
    private GaiaX.Params params;
    @NotNull
    private final View view;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GenericGaiaxView(@NotNull View view2) {
        super(view2);
        k21.i(view2, "view");
        this.view = view2;
    }

    public void doViewInjected(@NotNull GaiaX.Params params2, @NotNull View view2) {
        k21.i(params2, "targetParams");
        k21.i(view2, "targetView");
        Log.d("GaiaxViewHolder", k21.r("doViewInjected targetView=", view2));
    }

    public void doViewUpdated(@NotNull GaiaX.Params params2, @NotNull View view2) {
        k21.i(params2, "targetParams");
        k21.i(view2, "targetView");
        Log.d("GaiaxViewHolder", k21.r("doViewUpdated targetView=", view2));
    }

    public final boolean onCustomMessage(@NotNull String str, @Nullable JSONObject jSONObject) {
        k21.i(str, "type");
        Log.e(AbsPresenter.TAG, "onMessage() called with: this = [" + this + jl1.ARRAY_END);
        if (k21.d("GAIAX_JS_REFRESH_PAGE", str)) {
            return false;
        }
        k21.d("GAIAX_JS_REFRESH_CARD", str);
        return false;
    }

    @Override // com.alient.gaiax.container.render.GenericGaiaxContract.View
    public void renderGaiax(@NotNull String str, @NotNull String str2, @NotNull String str3, int i, @NotNull JSONObject jSONObject) {
        k21.i(str, if1.DIMEN_BIZ);
        k21.i(str2, "templateId");
        k21.i(str3, "version");
        k21.i(jSONObject, "data");
        GaiaXBuilder gaiaXBuilder = new GaiaXBuilder();
        View view2 = this.view;
        Context context = view2.getContext();
        k21.h(context, "view.context");
        this.params = GaiaXBuilder.renderGaiaX$default(gaiaXBuilder, view2, context, str, str2, str3, "", jSONObject, (float) i, -1, new GenericGaiaxView$renderGaiax$1(this, this.view.getContext()), false, false, null, 7168, null);
    }

    @Override // com.alient.gaiax.container.render.GenericGaiaxContract.View
    public void viewInvisible() {
        GaiaX.Params params2 = this.params;
        if (params2 != null) {
            GaiaX.Companion.getInstance().invisibleView(params2);
        }
    }

    @Override // com.alient.gaiax.container.render.GenericGaiaxContract.View
    public void viewVisible() {
        GaiaX.Params params2 = this.params;
        if (params2 != null) {
            GaiaX.Companion.getInstance().visibleView(params2);
        }
    }
}
