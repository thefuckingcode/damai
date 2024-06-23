package com.youku.gaiax.provider.module;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import androidx.annotation.Keep;
import androidx.core.content.res.ResourcesCompat;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.template.GXIExpression;
import com.taobao.weex.adapter.URIAdapter;
import com.taobao.weex.common.Constants;
import com.youku.gaiax.api.data.RasterizeRule;
import com.youku.gaiax.api.proxy.IProxyApp;
import com.youku.gaiax.api.proxy.IProxyFeatures;
import com.youku.gaiax.common.utils.ScreenUtils;
import com.youku.gaiax.impl.GaiaXProxy;
import com.youku.gaiax.impl.utils.NotchUtils;
import com.youku.gaiax.provider.module.animation.GaiaXLottieAnimation;
import com.youku.gaiax.provider.module.proxy.PictureGaiaXProviderProxy;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import com.youku.middlewareservice.provider.info.NetworkInfoProviderProxy;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.mp0;
import tb.po0;
import tb.ur2;
import tb.yo0;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u001a\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0015H\u0016¨\u0006\u001a"}, d2 = {"Lcom/youku/gaiax/provider/module/GaiaXProxyFeatures;", "Lcom/youku/gaiax/api/proxy/IProxyFeatures;", "", Constants.Name.FONT_FAMILY, "Landroid/graphics/Typeface;", "dmCreateFontFamily", "tppCreateFontFamily", "getParentTypeface", "createFontFamilyFromResFontFolder", "env", "", "getEnvExpressionResult", "", "isNetworkConnected", "createFontFamily", "Ltb/mp0;", "createLottieAnimation", "data", "Ltb/po0;", "createDataBinding", "templateId", "Lcom/alibaba/fastjson/JSONObject;", "Ltb/ur2;", "sendRibutMessage", "<init>", "()V", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXProxyFeatures implements IProxyFeatures {
    private final Typeface createFontFamilyFromResFontFolder(String str) {
        Context applicationContext;
        IProxyApp app2;
        Resources resources;
        int identifier;
        GaiaXProxy.Companion companion = GaiaXProxy.Companion;
        IProxyApp app3 = companion.getInstance().getApp();
        if (app3 == null || (applicationContext = app3.applicationContext()) == null || (app2 = companion.getInstance().getApp()) == null || (resources = app2.resources()) == null || (identifier = resources.getIdentifier(str, URIAdapter.FONT, applicationContext.getPackageName())) == 0) {
            return null;
        }
        try {
            return ResourcesCompat.getFont(applicationContext, identifier);
        } catch (Exception unused) {
            return null;
        }
    }

    private final Typeface dmCreateFontFamily(String str) {
        Resources resources;
        if (k21.d(str, "iconfont")) {
            return getParentTypeface("damai_iconfont");
        }
        if (!k21.d(str, "URWDIN-Medium")) {
            return getParentTypeface(str);
        }
        IProxyApp app2 = GaiaXProxy.Companion.getInstance().getApp();
        if (app2 == null || (resources = app2.resources()) == null) {
            return getParentTypeface(str);
        }
        return Typeface.createFromAsset(resources.getAssets(), "damai_digit.otf");
    }

    private final Typeface getParentTypeface(String str) {
        try {
            return IProxyFeatures.DefaultImpls.createFontFamily(this, str);
        } catch (Exception unused) {
            return null;
        }
    }

    private final Typeface tppCreateFontFamily(String str) {
        Typeface parentTypeface = getParentTypeface(str);
        if (parentTypeface != null) {
            return parentTypeface;
        }
        Typeface createFontFamilyFromResFontFolder = createFontFamilyFromResFontFolder(str);
        if (createFontFamilyFromResFontFolder != null) {
            return createFontFamilyFromResFontFolder;
        }
        return null;
    }

    @Override // com.youku.gaiax.api.proxy.IProxyFeatures
    @Nullable
    public po0 createDataBinding(@NotNull Object obj) {
        GXIExpression a;
        k21.i(obj, "data");
        LinkedHashMap linkedHashMap = null;
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            String string = jSONObject.getString("value");
            String string2 = jSONObject.getString(Constants.Name.PLACEHOLDER);
            String string3 = jSONObject.getString("accessibilityDesc");
            String string4 = jSONObject.getString("accessibilityEnable");
            JSONObject jSONObject2 = jSONObject.getJSONObject("extend");
            yo0 yo0 = yo0.INSTANCE;
            GXIExpression a2 = yo0.a(string);
            GXIExpression a3 = yo0.a(string2);
            GXIExpression a4 = yo0.a(string3);
            GXIExpression a5 = yo0.a(string4);
            if (jSONObject2 != null && (!jSONObject2.isEmpty())) {
                linkedHashMap = new LinkedHashMap();
                for (Map.Entry entry : jSONObject2.entrySet()) {
                    if (!(entry.getKey() == null || entry.getValue() == null || (a = yo0.INSTANCE.a(entry.getValue())) == null)) {
                        Object key = entry.getKey();
                        k21.h(key, "entry.key");
                        linkedHashMap.put(key, a);
                    }
                }
            }
            return new po0(a2, a4, a5, a3, linkedHashMap);
        } else if (obj instanceof String) {
            return new po0(yo0.INSTANCE.a(obj), null, null, null, null, 30, null);
        } else {
            return null;
        }
    }

    @Override // com.youku.gaiax.api.proxy.IProxyFeatures
    @Nullable
    public Typeface createFontFamily(@NotNull String str) {
        k21.i(str, Constants.Name.FONT_FAMILY);
        PictureGaiaXProviderProxy.Companion companion = PictureGaiaXProviderProxy.Companion;
        if (companion.isDamaiApp()) {
            return dmCreateFontFamily(str);
        }
        if (companion.isTppApp()) {
            return tppCreateFontFamily(str);
        }
        return getParentTypeface(str);
    }

    @Override // com.youku.gaiax.api.proxy.IProxyFeatures
    @Nullable
    public mp0 createLottieAnimation() {
        return new GaiaXLottieAnimation();
    }

    @Override // com.youku.gaiax.api.proxy.IProxyFeatures
    public void featuresInit() {
        IProxyFeatures.DefaultImpls.featuresInit(this);
    }

    @Override // com.youku.gaiax.api.proxy.IProxyFeatures
    @Nullable
    public Object getEnvExpressionResult(@NotNull String str) {
        k21.i(str, "env");
        IProxyApp app2 = GaiaXProxy.Companion.getInstance().getApp();
        Context context = app2 == null ? null : app2.topActivity();
        switch (str.hashCode()) {
            case -2007745357:
                if (str.equals("screenHeight") && context != null) {
                    return Float.valueOf(ScreenUtils.INSTANCE.getScreenHeightDP(context));
                }
                return null;
            case -1441169947:
                if (str.equals("isAndroid")) {
                    return Boolean.TRUE;
                }
                break;
            case -50798406:
                if (str.equals("screenWidth") && context != null) {
                    return Float.valueOf(ScreenUtils.INSTANCE.getScreenWidthDP(context));
                }
                return null;
            case 100468355:
                if (str.equals("isIOS")) {
                    return Boolean.FALSE;
                }
                break;
            case 1484112759:
                if (str.equals("appVersion")) {
                    return AppInfoProviderProxy.getVersionName();
                }
                break;
            case 1721112372:
                if (str.equals("isLiuHaiPing")) {
                    if (context == null) {
                        return Boolean.FALSE;
                    }
                    return NotchUtils.INSTANCE.isNotch();
                }
                break;
            case 1874684019:
                if (!str.equals("platform")) {
                    return null;
                }
                return "android";
        }
        return null;
    }

    @Override // com.youku.gaiax.api.proxy.IProxyFeatures
    @Nullable
    public RasterizeRule.Result getRasterizeRule(@NotNull RasterizeRule.Config config) {
        return IProxyFeatures.DefaultImpls.getRasterizeRule(this, config);
    }

    @Override // com.youku.gaiax.api.proxy.IProxyFeatures
    public float getResponsiveLayoutScale() {
        return IProxyFeatures.DefaultImpls.getResponsiveLayoutScale(this);
    }

    @Override // com.youku.gaiax.api.proxy.IProxyFeatures
    public int getResponsiveSpan(@Nullable Float f, int i) {
        return IProxyFeatures.DefaultImpls.getResponsiveSpan(this, f, i);
    }

    @Override // com.youku.gaiax.api.proxy.IProxyFeatures
    public boolean isLargeFontMode() {
        return IProxyFeatures.DefaultImpls.isLargeFontMode(this);
    }

    @Override // com.youku.gaiax.api.proxy.IProxyFeatures
    public boolean isNetworkConnected() {
        return NetworkInfoProviderProxy.isNetworkAvailable() || NetworkInfoProviderProxy.isMobile() || NetworkInfoProviderProxy.isWifi();
    }

    @Override // com.youku.gaiax.api.proxy.IProxyFeatures
    public boolean isSupportResponsiveLayout(@Nullable Context context) {
        return IProxyFeatures.DefaultImpls.isSupportResponsiveLayout(this, context);
    }

    @Override // com.youku.gaiax.api.proxy.IProxyFeatures
    public float largeFontScale() {
        return IProxyFeatures.DefaultImpls.largeFontScale(this);
    }

    @Override // com.youku.gaiax.api.proxy.IProxyFeatures
    public void registerAccs(@NotNull String str, @NotNull Function2<? super String, ? super JSONObject, ur2> function2) {
        IProxyFeatures.DefaultImpls.registerAccs(this, str, function2);
    }

    @Override // com.youku.gaiax.api.proxy.IProxyFeatures
    public void runJSAppBundle(@NotNull Function0<ur2> function0) {
        IProxyFeatures.DefaultImpls.runJSAppBundle(this, function0);
    }

    @Override // com.youku.gaiax.api.proxy.IProxyFeatures
    public void sendRibutMessage(@NotNull String str, @Nullable JSONObject jSONObject) {
        k21.i(str, "templateId");
    }
}
