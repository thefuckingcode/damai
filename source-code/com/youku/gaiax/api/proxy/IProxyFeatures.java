package com.youku.gaiax.api.proxy;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import androidx.annotation.Keep;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.common.Constants;
import com.youku.arch.v3.event.Subject;
import com.youku.gaiax.api.data.RasterizeRule;
import com.youku.gaiax.impl.GaiaXProxy;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.mp0;
import tb.po0;
import tb.ur2;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000 .2\u00020\u0001:\u0001.J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0001H\u0016J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J!\u0010\u0010\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\b\u0010\u001c\u001a\u00020\tH\u0016J\b\u0010\u001d\u001a\u00020\u000bH\u0016JJ\u0010%\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u001626\u0010$\u001a2\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110#¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00020\u001fH\u0016J\n\u0010'\u001a\u0004\u0018\u00010&H\u0016J\b\u0010(\u001a\u00020\tH&J\u0016\u0010+\u001a\u00020\u00022\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020)H\u0016J\u001a\u0010-\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u00162\b\u0010\u0004\u001a\u0004\u0018\u00010#H\u0016¨\u0006/"}, d2 = {"Lcom/youku/gaiax/api/proxy/IProxyFeatures;", "", "Ltb/ur2;", "featuresInit", "data", "Ltb/po0;", "createDataBinding", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "", "isSupportResponsiveLayout", "", "getResponsiveLayoutScale", "containerWidth", "", "span", "getResponsiveSpan", "(Ljava/lang/Float;I)I", "Lcom/youku/gaiax/api/data/RasterizeRule$Config;", "ruleConfig", "Lcom/youku/gaiax/api/data/RasterizeRule$Result;", "getRasterizeRule", "", Constants.Name.FONT_FAMILY, "Landroid/graphics/Typeface;", "createFontFamily", "env", "getEnvExpressionResult", "isLargeFontMode", "largeFontScale", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "content", "Lcom/alibaba/fastjson/JSONObject;", Subject.FUNCTION, "registerAccs", "Ltb/mp0;", "createLottieAnimation", "isNetworkConnected", "Lkotlin/Function0;", "task", "runJSAppBundle", "templateId", "sendRibutMessage", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public interface IProxyFeatures {
    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/youku/gaiax/api/proxy/IProxyFeatures$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        @NotNull
        private static final String TAG = "[GaiaX]";

        private Companion() {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class DefaultImpls {
        @Nullable
        public static po0 createDataBinding(@NotNull IProxyFeatures iProxyFeatures, @NotNull Object obj) {
            k21.i(iProxyFeatures, "this");
            k21.i(obj, "data");
            return null;
        }

        @Nullable
        public static Typeface createFontFamily(@NotNull IProxyFeatures iProxyFeatures, @NotNull String str) {
            AssetManager assetManager;
            k21.i(iProxyFeatures, "this");
            k21.i(str, Constants.Name.FONT_FAMILY);
            try {
                IProxyApp app2 = GaiaXProxy.Companion.getInstance().getApp();
                if (app2 != null) {
                    Context applicationContext = app2.applicationContext();
                    if (applicationContext != null) {
                        assetManager = applicationContext.getAssets();
                        return Typeface.createFromAsset(assetManager, k21.r(str, ".ttf"));
                    }
                }
                assetManager = null;
                return Typeface.createFromAsset(assetManager, k21.r(str, ".ttf"));
            } catch (Exception unused) {
                return null;
            }
        }

        @Nullable
        public static mp0 createLottieAnimation(@NotNull IProxyFeatures iProxyFeatures) {
            k21.i(iProxyFeatures, "this");
            return null;
        }

        public static void featuresInit(@NotNull IProxyFeatures iProxyFeatures) {
            k21.i(iProxyFeatures, "this");
        }

        @Nullable
        public static Object getEnvExpressionResult(@NotNull IProxyFeatures iProxyFeatures, @NotNull String str) {
            k21.i(iProxyFeatures, "this");
            k21.i(str, "env");
            return null;
        }

        @Nullable
        public static RasterizeRule.Result getRasterizeRule(@NotNull IProxyFeatures iProxyFeatures, @NotNull RasterizeRule.Config config) {
            k21.i(iProxyFeatures, "this");
            k21.i(config, "ruleConfig");
            return null;
        }

        public static float getResponsiveLayoutScale(@NotNull IProxyFeatures iProxyFeatures) {
            k21.i(iProxyFeatures, "this");
            return 1.0f;
        }

        public static int getResponsiveSpan(@NotNull IProxyFeatures iProxyFeatures, @Nullable Float f, int i) {
            k21.i(iProxyFeatures, "this");
            return i;
        }

        public static boolean isLargeFontMode(@NotNull IProxyFeatures iProxyFeatures) {
            k21.i(iProxyFeatures, "this");
            return false;
        }

        public static boolean isSupportResponsiveLayout(@NotNull IProxyFeatures iProxyFeatures, @Nullable Context context) {
            k21.i(iProxyFeatures, "this");
            return false;
        }

        public static float largeFontScale(@NotNull IProxyFeatures iProxyFeatures) {
            k21.i(iProxyFeatures, "this");
            return 1.0f;
        }

        public static void registerAccs(@NotNull IProxyFeatures iProxyFeatures, @NotNull String str, @NotNull Function2<? super String, ? super JSONObject, ur2> function2) {
            k21.i(iProxyFeatures, "this");
            k21.i(str, "action");
            k21.i(function2, Subject.FUNCTION);
        }

        public static /* synthetic */ void registerAccs$default(IProxyFeatures iProxyFeatures, String str, Function2 function2, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = "";
                }
                iProxyFeatures.registerAccs(str, function2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: registerAccs");
        }

        public static void runJSAppBundle(@NotNull IProxyFeatures iProxyFeatures, @NotNull Function0<ur2> function0) {
            k21.i(iProxyFeatures, "this");
            k21.i(function0, "task");
            function0.invoke();
        }

        public static void sendRibutMessage(@NotNull IProxyFeatures iProxyFeatures, @NotNull String str, @Nullable JSONObject jSONObject) {
            k21.i(iProxyFeatures, "this");
            k21.i(str, "templateId");
        }
    }

    @Nullable
    po0 createDataBinding(@NotNull Object obj);

    @Nullable
    Typeface createFontFamily(@NotNull String str);

    @Nullable
    mp0 createLottieAnimation();

    void featuresInit();

    @Nullable
    Object getEnvExpressionResult(@NotNull String str);

    @Nullable
    RasterizeRule.Result getRasterizeRule(@NotNull RasterizeRule.Config config);

    float getResponsiveLayoutScale();

    int getResponsiveSpan(@Nullable Float f, int i);

    boolean isLargeFontMode();

    boolean isNetworkConnected();

    boolean isSupportResponsiveLayout(@Nullable Context context);

    float largeFontScale();

    void registerAccs(@NotNull String str, @NotNull Function2<? super String, ? super JSONObject, ur2> function2);

    void runJSAppBundle(@NotNull Function0<ur2> function0);

    void sendRibutMessage(@NotNull String str, @Nullable JSONObject jSONObject);
}
