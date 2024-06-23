package com.youku.gaiax.impl.register;

import android.view.ViewGroup;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.GXTemplateEngine;
import com.youku.gaiax.GaiaX;
import com.youku.gaiax.LoadType;
import com.youku.gaiax.common.utils.ScreenUtils;
import com.youku.gaiax.impl.GaiaXKey;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.xq0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012JF\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¨\u0006\u0013"}, d2 = {"Lcom/youku/gaiax/impl/register/GXExtensionContainerItemBind;", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionContainerItemBind;", "", "tag", "Landroid/view/ViewGroup;", "childItemContainer", "Lcom/alibaba/gaiax/GXTemplateEngine$e;", "childMeasureSize", "Lcom/alibaba/gaiax/GXTemplateEngine$h;", "childTemplateItem", "", "childItemPosition", "Ltb/xq0;", "childVisualNestTemplateNode", "Lcom/alibaba/fastjson/JSONObject;", "childItemData", "bindViewHolder", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GXExtensionContainerItemBind implements GXRegisterCenter.GXIExtensionContainerItemBind {
    @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionContainerItemBind
    @Nullable
    public Object bindViewHolder(@Nullable Object obj, @NotNull ViewGroup viewGroup, @NotNull GXTemplateEngine.e eVar, @NotNull GXTemplateEngine.h hVar, int i, @Nullable xq0 xq0, @NotNull JSONObject jSONObject) {
        LoadType loadType;
        Map<GaiaX.IRule, GaiaX.IDataPipeline5> dataPipelines5;
        GaiaX.IScrollItemStatusDelegate scrollItemStatusDelegate;
        GaiaX.IScrollDelegate scrollDelegate;
        GaiaX.IAnimationDelegate animationDelegate;
        GaiaX.ITrackDelegate3 trackDelegate3;
        GaiaX.IRouterDelegate2 routerDelegate2;
        GaiaX.IEventDelegate eventDelegate;
        k21.i(viewGroup, "childItemContainer");
        k21.i(eVar, "childMeasureSize");
        k21.i(hVar, "childTemplateItem");
        k21.i(jSONObject, "childItemData");
        jSONObject.put((Object) GaiaXKey.GAIAX_SCROLL_POSITION, (Object) Integer.valueOf(i));
        GaiaX.IHostMessage iHostMessage = null;
        GaiaX.Params params = obj instanceof GaiaX.Params ? (GaiaX.Params) obj : null;
        GaiaX.Params.Builder data = new GaiaX.Params.Builder().templateId(hVar.d()).templateBiz(hVar.a()).container(viewGroup).data(jSONObject);
        if (params == null) {
            loadType = null;
        } else {
            loadType = params.getChildLoadMode$GaiaX_Android();
        }
        if (loadType == null) {
            loadType = params == null ? null : params.getMode();
            if (loadType == null) {
                loadType = LoadType.ASYNC_NORMAL;
            }
        }
        GaiaX.Params.Builder mode = data.mode(loadType);
        Float b = eVar.b();
        GaiaX.Params.Builder width = mode.width(b == null ? ScreenUtils.INSTANCE.getScreenWidthPx() : b.floatValue());
        Float a = eVar.a();
        if (a != null) {
            width.height(a.floatValue());
        }
        GaiaX.Params build = width.build();
        build.setIndexPosition$GaiaX_Android(i);
        if (!(params == null || (eventDelegate = params.getEventDelegate()) == null)) {
            build.setEventDelegate(new GXExtensionContainerItemBind$bindViewHolder$1$1(i, eventDelegate));
        }
        if (!(params == null || (routerDelegate2 = params.getRouterDelegate2()) == null)) {
            build.setRouterDelegate2(new GXExtensionContainerItemBind$bindViewHolder$2$1(routerDelegate2, i));
        }
        if (!(params == null || (trackDelegate3 = params.getTrackDelegate3()) == null)) {
            build.setTrackDelegate3(new GXExtensionContainerItemBind$bindViewHolder$3$1(i, trackDelegate3));
        }
        if (!(params == null || (animationDelegate = params.getAnimationDelegate()) == null)) {
            build.setAnimationDelegate(animationDelegate);
        }
        if (!(params == null || (scrollDelegate = params.getScrollDelegate()) == null)) {
            build.setScrollDelegate(scrollDelegate);
        }
        if (!(params == null || (scrollItemStatusDelegate = params.getScrollItemStatusDelegate()) == null)) {
            build.setScrollItemStatusDelegate(scrollItemStatusDelegate);
        }
        if (!(params == null || (dataPipelines5 = params.getDataPipelines5()) == null)) {
            build.getDataPipelines5().putAll(dataPipelines5);
        }
        if (params != null) {
            iHostMessage = params.getMessage();
        }
        build.setMessage(iHostMessage);
        build.setChildVisualNestTemplateNode(xq0);
        GaiaX.Companion.getInstance().bindView(build);
        return build;
    }
}
