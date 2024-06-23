package com.youku.gaiax.provider.module.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.Keep;
import androidx.core.content.res.ResourcesCompat;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.render.view.basic.GXImageView;
import com.taobao.weex.common.Constants;
import com.youku.gaiax.common.utils.Log;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;
import tb.ur2;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B\u0011\u0012\b\u0010&\u001a\u0004\u0018\u00010%¢\u0006\u0004\b'\u0010(J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0004J´\u0002\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u000226\u0010\u0013\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00120\u000f26\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00120\u000f26\u0010\u0015\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00120\u000f26\u0010\u0016\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00120\u000f2:\b\u0002\u0010\u0017\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000fJ\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0004J\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001aJ\u0016\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0004J\u0012\u0010\u001e\u001a\u00020\u00122\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R$\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006*"}, d2 = {"Lcom/youku/gaiax/provider/module/views/GaiaXImageView;", "Lcom/alibaba/gaiax/render/view/basic/GXImageView;", "Lcom/alibaba/fastjson/JSONObject;", "data", "", "getUriByCompatibility", "uri", "getLocalUri", "getResUri", "", "isNetUri", "isResUri", "isLocalUri", "Landroid/widget/ImageView;", "imageView", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Ltb/ur2;", "dispatchNet", "dispatchLocal", "dispatchRes", "dispatchDefault", "dispatchPlaceholder", "doBindUri", "Landroid/graphics/drawable/Drawable;", "", "resId", "getDrawableByResId", "getResIdByUri", "onBindData", "placeHolderResId", "Ljava/lang/Integer;", "getPlaceHolderResId", "()Ljava/lang/Integer;", "setPlaceHolderResId", "(Ljava/lang/Integer;)V", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "<init>", "(Landroid/content/Context;)V", "Companion", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXImageView extends GXImageView {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String GAIAX_RES_PREFIX = "gaiax_res:";
    @NotNull
    public static final String LOCAL_PREFIX = "local:";
    @NotNull
    public static final String NET_HTTPS_PREFIX = "https:";
    @NotNull
    public static final String NET_HTTP_PREFIX = "http:";
    @NotNull
    public static final String RES_PREFIX = "res:";
    @Nullable
    private Integer placeHolderResId;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/youku/gaiax/provider/module/views/GaiaXImageView$Companion;", "", "", "GAIAX_RES_PREFIX", "Ljava/lang/String;", "LOCAL_PREFIX", "NET_HTTPS_PREFIX", "NET_HTTP_PREFIX", "RES_PREFIX", "<init>", "()V", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(m40 m40) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GaiaXImageView(@Nullable Context context) {
        super(context);
        k21.f(context);
        setImageDrawable(new ColorDrawable(0));
        setBackgroundDrawable(new ColorDrawable(0));
    }

    public static /* synthetic */ void doBindUri$default(GaiaXImageView gaiaXImageView, ImageView imageView, JSONObject jSONObject, Function2 function2, Function2 function22, Function2 function23, Function2 function24, Function2 function25, int i, Object obj) {
        gaiaXImageView.doBindUri(imageView, jSONObject, function2, function22, function23, function24, (i & 64) != 0 ? null : function25);
    }

    private final String getLocalUri(String str) {
        return o.F(str, "local:", "", false, 4, null);
    }

    private final String getResUri(String str) {
        return o.F(str, RES_PREFIX, "", false, 4, null);
    }

    private final String getUriByCompatibility(JSONObject jSONObject) {
        String str = null;
        String string = jSONObject == null ? null : jSONObject.getString("url");
        if (jSONObject != null) {
            str = jSONObject.getString("value");
        }
        boolean z = true;
        if (string != null) {
            if (string.length() > 0) {
                return StringsKt__StringsKt.T0(string).toString();
            }
        }
        if (str != null) {
            if (str.length() <= 0) {
                z = false;
            }
            if (z) {
                return StringsKt__StringsKt.T0(str).toString();
            }
        }
        return "";
    }

    @Nullable
    public final Drawable dispatchRes(@NotNull ImageView imageView, @NotNull String str) {
        k21.i(imageView, "imageView");
        k21.i(str, "uri");
        try {
            int identifier = imageView.getResources().getIdentifier(str, "drawable", imageView.getContext().getPackageName());
            Resources.Theme theme = imageView.getContext().getTheme();
            k21.h(theme, "imageView.context.theme");
            Drawable drawable = ResourcesCompat.getDrawable(imageView.getResources(), identifier, theme);
            imageView.setImageDrawable(drawable);
            return drawable;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void doBindUri(@NotNull ImageView imageView, @Nullable JSONObject jSONObject, @NotNull Function2<? super ImageView, ? super String, ur2> function2, @NotNull Function2<? super ImageView, ? super String, ur2> function22, @NotNull Function2<? super ImageView, ? super String, ur2> function23, @NotNull Function2<? super ImageView, ? super String, ur2> function24, @Nullable Function2<? super ImageView, ? super String, ur2> function25) {
        String string;
        k21.i(imageView, "imageView");
        k21.i(function2, "dispatchNet");
        k21.i(function22, "dispatchLocal");
        k21.i(function23, "dispatchRes");
        k21.i(function24, "dispatchDefault");
        String uriByCompatibility = getUriByCompatibility(jSONObject);
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("[GaiaX][Image]", k21.r("doBindUri() called with: uri = ", uriByCompatibility));
        }
        if (isNetUri(uriByCompatibility)) {
            if (!(jSONObject == null || (string = jSONObject.getString(Constants.Name.PLACEHOLDER)) == null || function25 == null)) {
                function25.invoke(imageView, string);
            }
            function2.invoke(imageView, uriByCompatibility);
        } else if (isLocalUri(uriByCompatibility)) {
            function22.invoke(imageView, getLocalUri(uriByCompatibility));
        } else if (isResUri(uriByCompatibility)) {
            function23.invoke(imageView, getResUri(uriByCompatibility));
        } else if (!TextUtils.isEmpty(uriByCompatibility)) {
            function23.invoke(imageView, uriByCompatibility);
        } else {
            function24.invoke(imageView, "");
        }
    }

    @Nullable
    public final Drawable getDrawableByResId(@NotNull ImageView imageView, int i) {
        k21.i(imageView, "imageView");
        Resources.Theme theme = imageView.getContext().getTheme();
        k21.h(theme, "imageView.context.theme");
        return ResourcesCompat.getDrawable(imageView.getResources(), i, theme);
    }

    @Nullable
    public final Integer getPlaceHolderResId() {
        return this.placeHolderResId;
    }

    public final int getResIdByUri(@NotNull ImageView imageView, @NotNull String str) {
        k21.i(imageView, "imageView");
        k21.i(str, "uri");
        try {
            return imageView.getResources().getIdentifier(str, "drawable", imageView.getContext().getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public final boolean isLocalUri(@NotNull String str) {
        k21.i(str, "uri");
        return o.L(str, "local:", false, 2, null);
    }

    public final boolean isNetUri(@NotNull String str) {
        k21.i(str, "uri");
        return (o.L(str, "http:", false, 2, null)) || (o.L(str, "https:", false, 2, null));
    }

    public final boolean isResUri(@NotNull String str) {
        k21.i(str, "uri");
        return o.L(str, RES_PREFIX, false, 2, null);
    }

    @Override // com.alibaba.gaiax.render.view.basic.GXIImageView, com.alibaba.gaiax.render.view.basic.GXImageView, com.alibaba.gaiax.render.view.GXIViewBindData
    public void onBindData(@Nullable JSONObject jSONObject) {
        doBindUri(this, jSONObject, new GaiaXImageView$onBindData$1(this), new GaiaXImageView$onBindData$2(jSONObject, this), new GaiaXImageView$onBindData$3(this), new GaiaXImageView$onBindData$4(jSONObject, this), new GaiaXImageView$onBindData$5(this));
    }

    public final void setPlaceHolderResId(@Nullable Integer num) {
        this.placeHolderResId = num;
    }
}
