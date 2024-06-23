package com.youku.gaiax.impl.register;

import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.render.view.container.GXContainer;
import com.youku.gaiax.api.data.RasterizeRule;
import com.youku.gaiax.api.proxy.IProxyFeatures;
import com.youku.gaiax.common.utils.ScreenUtils;
import com.youku.gaiax.impl.GaiaXKey;
import com.youku.gaiax.impl.GaiaXProxy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.lq0;
import tb.wq0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\"\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¨\u0006\u0012"}, d2 = {"Lcom/youku/gaiax/impl/register/GXExtensionScroll;", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionScroll;", "Ltb/wq0;", "gxTemplateContext", "Lcom/alibaba/gaiax/render/view/container/GXContainer;", "container", "Lcom/alibaba/fastjson/JSONObject;", "extend", "Ltb/ur2;", "scrollIndex", "", "propertyName", "Ltb/lq0;", "scrollConfig", "", "convert", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GXExtensionScroll implements GXRegisterCenter.GXIExtensionScroll {
    @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionScroll
    @Nullable
    public Object convert(@NotNull String str, @NotNull wq0 wq0, @NotNull lq0 lq0) {
        String string;
        RasterizeRule.Result rasterizeRule;
        k21.i(str, "propertyName");
        k21.i(wq0, "gxTemplateContext");
        k21.i(lq0, "scrollConfig");
        if (!k21.d(str, "view-port-width") || (string = lq0.a().getString(GaiaXKey.GAIAX_SCROLL_RESPONSIVE_RULE)) == null) {
            return null;
        }
        RasterizeRule.Config config = new RasterizeRule.Config();
        config.setScreenWidth(ScreenUtils.INSTANCE.getScreenWidthPx(wq0.c()));
        config.setContext(wq0.c());
        config.setEdgeLeft(lq0.c().left);
        config.setEdgeRight(lq0.c().right);
        config.setEdgeTop(lq0.c().top);
        config.setEdgeBottom(lq0.c().bottom);
        config.setLineSpacing(lq0.e());
        config.setRuleName(string);
        IProxyFeatures features = GaiaXProxy.Companion.getInstance().getFeatures();
        if (features == null || (rasterizeRule = features.getRasterizeRule(config)) == null) {
            return null;
        }
        return rasterizeRule.getWidth();
    }

    @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionScroll
    public void scrollIndex(@NotNull wq0 wq0, @NotNull GXContainer gXContainer, @Nullable JSONObject jSONObject) {
        boolean z;
        RecyclerView.LayoutManager layoutManager;
        k21.i(wq0, "gxTemplateContext");
        k21.i(gXContainer, "container");
        GXTemplateEngine.g j = wq0.j();
        if (j != null) {
            int d = j.d();
            if (d <= 0) {
                if (jSONObject == null) {
                    z = false;
                } else {
                    z = jSONObject.getBooleanValue("holding-offset");
                }
                if (!z && (layoutManager = gXContainer.getLayoutManager()) != null) {
                    layoutManager.scrollToPosition(0);
                    return;
                }
                return;
            }
            RecyclerView.LayoutManager layoutManager2 = gXContainer.getLayoutManager();
            if (layoutManager2 != null) {
                layoutManager2.scrollToPosition(d);
            }
        }
    }
}
