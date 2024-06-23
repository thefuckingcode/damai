package com.alient.gaiax.container.gaiax;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.alibaba.fastjson.JSONObject;
import com.alient.gaiax.container.util.ChannelUtil;
import com.alient.gaiax.container.util.Utils;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.youku.gaiax.GaiaX;
import com.youku.gaiax.LoadType;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import com.youku.middlewareservice.provider.info.DeviceInfoProviderProxy;
import com.youku.uplayer.FileUtils;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.if1;
import tb.k21;
import tb.kr0;
import tb.lr0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ8\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J^\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0014H\u0007J\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00142\b\b\u0002\u0010\u001c\u001a\u00020\u001bH\u0007¨\u0006 "}, d2 = {"Lcom/alient/gaiax/container/gaiax/GaiaXBuilder;", "", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/view/View;", "gaiaxContainerView", "", "bizIdTemp", "templateId", "version", "", "viewWidth", "Ltb/ur2;", "gaiaxModelInfo", "Lcom/alibaba/fastjson/JSONObject;", "data", "", "pos", "Lcom/alient/gaiax/container/gaiax/PictureGaiaXDelegate;", "yyDelegate", "", "autoUtEnable", "autoEventEnable", "Lcom/youku/gaiax/GaiaX$Params;", "renderGaiaXSimple", if1.DIMEN_BIZ, "pageName", "Lcom/youku/gaiax/LoadType;", "mode", "renderGaiaX", "<init>", "()V", "gaiax-container_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXBuilder {
    private final void gaiaxModelInfo(Context context, View view, String str, String str2, String str3, float f) {
        int intValue;
        View childAt;
        ViewGroup.LayoutParams layoutParams;
        View childAt2;
        ViewGroup.LayoutParams layoutParams2;
        if (AppInfoProviderProxy.isDebuggable()) {
            Utils utils = Utils.INSTANCE;
            if (k21.d("1", utils.getString("picture_gaiax_layer_info")) && (view instanceof ViewGroup)) {
                TextView textView = new TextView(context);
                textView.setText("业务id: " + str + "  模版id:  " + str2 + "  模版version:  " + str3);
                int screenWidth = utils.screenWidth(context);
                int dip2px = utils.dip2px(context, 35.0f);
                ViewGroup viewGroup = (ViewGroup) view;
                Integer num = null;
                Integer valueOf = (viewGroup == null || (childAt2 = viewGroup.getChildAt(0)) == null || (layoutParams2 = childAt2.getLayoutParams()) == null) ? null : Integer.valueOf(layoutParams2.width);
                if (!(viewGroup == null || (childAt = viewGroup.getChildAt(0)) == null || (layoutParams = childAt.getLayoutParams()) == null)) {
                    num = Integer.valueOf(layoutParams.height);
                }
                if (valueOf != null && (intValue = valueOf.intValue()) > 0) {
                    int intValue2 = valueOf.intValue();
                    if (num != null) {
                        num.intValue();
                        if (num.intValue() > 0 && intValue < screenWidth) {
                            dip2px = num.intValue();
                        }
                    }
                    screenWidth = intValue2;
                }
                textView.setOnLongClickListener(new lr0(context, str2));
                textView.setClickable(false);
                textView.setWidth(screenWidth);
                textView.setMaxHeight(dip2px);
                textView.setTextColor(Color.parseColor("#ff00ee"));
                viewGroup.addView(textView);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: gaiaxModelInfo$lambda-4  reason: not valid java name */
    public static final boolean m177gaiaxModelInfo$lambda4(Context context, String str, View view) {
        k21.i(context, "$context");
        k21.i(str, "$templateId");
        Utils.INSTANCE.copyAction(context, str, "已复制至剪切板");
        return false;
    }

    public static /* synthetic */ GaiaX.Params renderGaiaX$default(GaiaXBuilder gaiaXBuilder, View view, Context context, String str, String str2, String str3, String str4, JSONObject jSONObject, float f, int i, PictureGaiaXDelegate pictureGaiaXDelegate, boolean z, boolean z2, LoadType loadType, int i2, Object obj) {
        Context context2;
        if ((i2 & 2) != 0) {
            Context context3 = view.getContext();
            k21.h(context3, "fun renderGaiaX(\n       …idth)\n            }\n    }");
            context2 = context3;
        } else {
            context2 = context;
        }
        return gaiaXBuilder.renderGaiaX(view, context2, (i2 & 4) != 0 ? "" : str, str2, (i2 & 16) != 0 ? "" : str3, (i2 & 32) != 0 ? "" : str4, jSONObject, (i2 & 128) != 0 ? (float) DeviceInfoProviderProxy.getWindowWidth() : f, (i2 & 256) != 0 ? -1 : i, (i2 & 512) != 0 ? new PictureGaiaXEventProvider(context2) : pictureGaiaXDelegate, (i2 & 1024) != 0 ? true : z, (i2 & 2048) != 0 ? true : z2, (i2 & 4096) != 0 ? LoadType.SYNC_NORMAL : loadType);
    }

    /* access modifiers changed from: private */
    /* renamed from: renderGaiaX$lambda-1$lambda-0  reason: not valid java name */
    public static final void m178renderGaiaX$lambda1$lambda0(PictureGaiaXDelegate pictureGaiaXDelegate, View view, JSONObject jSONObject, int i, View view2) {
        k21.i(pictureGaiaXDelegate, "$yyDelegate");
        k21.i(view, "$gaiaxContainerView");
        pictureGaiaXDelegate.onItemViewClick(view, jSONObject, i);
    }

    public static /* synthetic */ GaiaX.Params renderGaiaXSimple$default(GaiaXBuilder gaiaXBuilder, View view, Context context, String str, JSONObject jSONObject, float f, int i, PictureGaiaXDelegate pictureGaiaXDelegate, boolean z, boolean z2, int i2, Object obj) {
        return gaiaXBuilder.renderGaiaXSimple(view, context, str, jSONObject, (i2 & 16) != 0 ? (float) DeviceInfoProviderProxy.getWindowWidth() : f, (i2 & 32) != 0 ? -1 : i, (i2 & 64) != 0 ? new PictureGaiaXEventProvider(context) : pictureGaiaXDelegate, (i2 & 128) != 0 ? true : z, (i2 & 256) != 0 ? true : z2);
    }

    @JvmOverloads
    @Nullable
    public final GaiaX.Params renderGaiaX(@NotNull View view, @NotNull Context context, @NotNull String str, @Nullable JSONObject jSONObject) {
        k21.i(view, "gaiaxContainerView");
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(str, "templateId");
        return renderGaiaX$default(this, view, context, null, str, null, null, jSONObject, 0.0f, 0, null, false, false, null, 8116, null);
    }

    @JvmOverloads
    @Nullable
    public final GaiaX.Params renderGaiaX(@NotNull View view, @NotNull Context context, @NotNull String str, @NotNull String str2, @Nullable JSONObject jSONObject) {
        k21.i(view, "gaiaxContainerView");
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(str, if1.DIMEN_BIZ);
        k21.i(str2, "templateId");
        return renderGaiaX$default(this, view, context, str, str2, null, null, jSONObject, 0.0f, 0, null, false, false, null, 8112, null);
    }

    @JvmOverloads
    @Nullable
    public final GaiaX.Params renderGaiaX(@NotNull View view, @NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable JSONObject jSONObject) {
        k21.i(view, "gaiaxContainerView");
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(str, if1.DIMEN_BIZ);
        k21.i(str2, "templateId");
        k21.i(str3, "version");
        return renderGaiaX$default(this, view, context, str, str2, str3, null, jSONObject, 0.0f, 0, null, false, false, null, 8096, null);
    }

    @JvmOverloads
    @Nullable
    public final GaiaX.Params renderGaiaX(@NotNull View view, @NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable JSONObject jSONObject) {
        k21.i(view, "gaiaxContainerView");
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(str, if1.DIMEN_BIZ);
        k21.i(str2, "templateId");
        k21.i(str3, "version");
        k21.i(str4, "pageName");
        return renderGaiaX$default(this, view, context, str, str2, str3, str4, jSONObject, 0.0f, 0, null, false, false, null, 8064, null);
    }

    @JvmOverloads
    @Nullable
    public final GaiaX.Params renderGaiaX(@NotNull View view, @NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable JSONObject jSONObject, float f) {
        k21.i(view, "gaiaxContainerView");
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(str, if1.DIMEN_BIZ);
        k21.i(str2, "templateId");
        k21.i(str3, "version");
        k21.i(str4, "pageName");
        return renderGaiaX$default(this, view, context, str, str2, str3, str4, jSONObject, f, 0, null, false, false, null, 7936, null);
    }

    @JvmOverloads
    @Nullable
    public final GaiaX.Params renderGaiaX(@NotNull View view, @NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable JSONObject jSONObject, float f, int i) {
        k21.i(view, "gaiaxContainerView");
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(str, if1.DIMEN_BIZ);
        k21.i(str2, "templateId");
        k21.i(str3, "version");
        k21.i(str4, "pageName");
        return renderGaiaX$default(this, view, context, str, str2, str3, str4, jSONObject, f, i, null, false, false, null, 7680, null);
    }

    @JvmOverloads
    @Nullable
    public final GaiaX.Params renderGaiaX(@NotNull View view, @NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable JSONObject jSONObject, float f, int i, @NotNull PictureGaiaXDelegate pictureGaiaXDelegate) {
        k21.i(view, "gaiaxContainerView");
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(str, if1.DIMEN_BIZ);
        k21.i(str2, "templateId");
        k21.i(str3, "version");
        k21.i(str4, "pageName");
        k21.i(pictureGaiaXDelegate, "yyDelegate");
        return renderGaiaX$default(this, view, context, str, str2, str3, str4, jSONObject, f, i, pictureGaiaXDelegate, false, false, null, 7168, null);
    }

    @JvmOverloads
    @Nullable
    public final GaiaX.Params renderGaiaX(@NotNull View view, @NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable JSONObject jSONObject, float f, int i, @NotNull PictureGaiaXDelegate pictureGaiaXDelegate, boolean z) {
        k21.i(view, "gaiaxContainerView");
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(str, if1.DIMEN_BIZ);
        k21.i(str2, "templateId");
        k21.i(str3, "version");
        k21.i(str4, "pageName");
        k21.i(pictureGaiaXDelegate, "yyDelegate");
        return renderGaiaX$default(this, view, context, str, str2, str3, str4, jSONObject, f, i, pictureGaiaXDelegate, z, false, null, 6144, null);
    }

    @JvmOverloads
    @Nullable
    public final GaiaX.Params renderGaiaX(@NotNull View view, @NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable JSONObject jSONObject, float f, int i, @NotNull PictureGaiaXDelegate pictureGaiaXDelegate, boolean z, boolean z2) {
        k21.i(view, "gaiaxContainerView");
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(str, if1.DIMEN_BIZ);
        k21.i(str2, "templateId");
        k21.i(str3, "version");
        k21.i(str4, "pageName");
        k21.i(pictureGaiaXDelegate, "yyDelegate");
        return renderGaiaX$default(this, view, context, str, str2, str3, str4, jSONObject, f, i, pictureGaiaXDelegate, z, z2, null, 4096, null);
    }

    @JvmOverloads
    @Nullable
    public final GaiaX.Params renderGaiaX(@NotNull View view, @NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable JSONObject jSONObject, float f, int i, @NotNull PictureGaiaXDelegate pictureGaiaXDelegate, boolean z, boolean z2, @NotNull LoadType loadType) {
        String str5;
        String str6;
        k21.i(view, "gaiaxContainerView");
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(str, if1.DIMEN_BIZ);
        k21.i(str2, "templateId");
        k21.i(str3, "version");
        k21.i(str4, "pageName");
        k21.i(pictureGaiaXDelegate, "yyDelegate");
        k21.i(loadType, "mode");
        if (o.y(str)) {
            ChannelUtil channelUtil = ChannelUtil.INSTANCE;
            if (channelUtil.isDamaiApp()) {
                str6 = "damai";
            } else if (channelUtil.isTppApp()) {
                str6 = "tpp";
            }
            str5 = str6;
            GaiaX.Params build = new GaiaX.Params.Builder().templateBiz(str5).templateId(str2).templateVersion(str3).container(view).mode(loadType).data(jSONObject).width(f).build();
            build.setEventDelegate(new GaiaXBuilder$renderGaiaX$1$1(pictureGaiaXDelegate, view, jSONObject, i, z2, z));
            build.setTrackDelegate3(new GaiaXBuilder$renderGaiaX$1$2(z, pictureGaiaXDelegate, jSONObject, i));
            build.setStatusDelegate(new GaiaXBuilder$renderGaiaX$1$3(pictureGaiaXDelegate));
            build.setMessage(new GaiaXBuilder$renderGaiaX$1$4(pictureGaiaXDelegate));
            view.setOnClickListener(new kr0(pictureGaiaXDelegate, view, jSONObject, i));
            pictureGaiaXDelegate.onItemViewExpose(view, jSONObject, i);
            GaiaX.Companion.getInstance().bindView(build);
            gaiaxModelInfo(context, view, str5, str2, str3, f);
            return build;
        }
        str5 = str;
        GaiaX.Params build2 = new GaiaX.Params.Builder().templateBiz(str5).templateId(str2).templateVersion(str3).container(view).mode(loadType).data(jSONObject).width(f).build();
        build2.setEventDelegate(new GaiaXBuilder$renderGaiaX$1$1(pictureGaiaXDelegate, view, jSONObject, i, z2, z));
        build2.setTrackDelegate3(new GaiaXBuilder$renderGaiaX$1$2(z, pictureGaiaXDelegate, jSONObject, i));
        build2.setStatusDelegate(new GaiaXBuilder$renderGaiaX$1$3(pictureGaiaXDelegate));
        build2.setMessage(new GaiaXBuilder$renderGaiaX$1$4(pictureGaiaXDelegate));
        view.setOnClickListener(new kr0(pictureGaiaXDelegate, view, jSONObject, i));
        pictureGaiaXDelegate.onItemViewExpose(view, jSONObject, i);
        GaiaX.Companion.getInstance().bindView(build2);
        gaiaxModelInfo(context, view, str5, str2, str3, f);
        return build2;
    }

    @JvmOverloads
    @Nullable
    public final GaiaX.Params renderGaiaX(@NotNull View view, @NotNull String str, @Nullable JSONObject jSONObject) {
        k21.i(view, "gaiaxContainerView");
        k21.i(str, "templateId");
        return renderGaiaX$default(this, view, null, null, str, null, null, jSONObject, 0.0f, 0, null, false, false, null, 8118, null);
    }

    @JvmOverloads
    @Nullable
    public final GaiaX.Params renderGaiaXSimple(@NotNull View view, @NotNull Context context, @NotNull String str, @Nullable JSONObject jSONObject) {
        k21.i(view, "gaiaxContainerView");
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(str, "templateId");
        return renderGaiaXSimple$default(this, view, context, str, jSONObject, 0.0f, 0, null, false, false, 496, null);
    }

    @JvmOverloads
    @Nullable
    public final GaiaX.Params renderGaiaXSimple(@NotNull View view, @NotNull Context context, @NotNull String str, @Nullable JSONObject jSONObject, float f) {
        k21.i(view, "gaiaxContainerView");
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(str, "templateId");
        return renderGaiaXSimple$default(this, view, context, str, jSONObject, f, 0, null, false, false, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH, null);
    }

    @JvmOverloads
    @Nullable
    public final GaiaX.Params renderGaiaXSimple(@NotNull View view, @NotNull Context context, @NotNull String str, @Nullable JSONObject jSONObject, float f, int i) {
        k21.i(view, "gaiaxContainerView");
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(str, "templateId");
        return renderGaiaXSimple$default(this, view, context, str, jSONObject, f, i, null, false, false, FileUtils.S_IRWXU, null);
    }

    @JvmOverloads
    @Nullable
    public final GaiaX.Params renderGaiaXSimple(@NotNull View view, @NotNull Context context, @NotNull String str, @Nullable JSONObject jSONObject, float f, int i, @NotNull PictureGaiaXDelegate pictureGaiaXDelegate) {
        k21.i(view, "gaiaxContainerView");
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(str, "templateId");
        k21.i(pictureGaiaXDelegate, "yyDelegate");
        return renderGaiaXSimple$default(this, view, context, str, jSONObject, f, i, pictureGaiaXDelegate, false, false, 384, null);
    }

    @JvmOverloads
    @Nullable
    public final GaiaX.Params renderGaiaXSimple(@NotNull View view, @NotNull Context context, @NotNull String str, @Nullable JSONObject jSONObject, float f, int i, @NotNull PictureGaiaXDelegate pictureGaiaXDelegate, boolean z) {
        k21.i(view, "gaiaxContainerView");
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(str, "templateId");
        k21.i(pictureGaiaXDelegate, "yyDelegate");
        return renderGaiaXSimple$default(this, view, context, str, jSONObject, f, i, pictureGaiaXDelegate, z, false, 256, null);
    }

    @JvmOverloads
    @Nullable
    public final GaiaX.Params renderGaiaXSimple(@NotNull View view, @NotNull Context context, @NotNull String str, @Nullable JSONObject jSONObject, float f, int i, @NotNull PictureGaiaXDelegate pictureGaiaXDelegate, boolean z, boolean z2) {
        k21.i(view, "gaiaxContainerView");
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(str, "templateId");
        k21.i(pictureGaiaXDelegate, "yyDelegate");
        return renderGaiaX$default(this, view, context, "", str, "", "", jSONObject, f, i, pictureGaiaXDelegate, z, z2, null, 4096, null);
    }
}
