package com.alibaba.gaiax;

import android.content.Context;
import android.graphics.Typeface;
import android.view.ViewGroup;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.render.node.GXINodeEvent;
import com.alibaba.gaiax.render.view.container.GXContainer;
import com.alibaba.gaiax.render.view.container.GXContainerViewAdapter;
import com.alibaba.gaiax.template.GXIExpression;
import com.alibaba.gaiax.template.GXTemplateInfo;
import com.taobao.weex.common.Constants;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.cp0;
import tb.dr0;
import tb.fp0;
import tb.k21;
import tb.lq0;
import tb.m40;
import tb.mp0;
import tb.po0;
import tb.uq0;
import tb.vq0;
import tb.wq0;
import tb.xq0;

/* compiled from: Taobao */
public final class GXRegisterCenter {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static final Lazy<GXRegisterCenter> p = b.b(GXRegisterCenter$Companion$instance$2.INSTANCE);
    @Nullable
    private GXIExtensionBizMap a;
    @Nullable
    private GXIExtensionDataBinding b;
    @Nullable
    private GXIExtensionExpression c;
    @Nullable
    private GXIExtensionColor d;
    @Nullable
    private GXIExtensionSize e;
    @Nullable
    private GXIExtensionDynamicProperty f;
    @Nullable
    private GXIExtensionStaticProperty g;
    @Nullable
    private GXIExtensionGrid h;
    @Nullable
    private GXIExtensionScroll i;
    @Nullable
    private GXIExtensionException j;
    @Nullable
    private GXIExtensionCompatibility k;
    @Nullable
    private GXIExtensionNodeEvent l;
    @Nullable
    private GXIExtensionContainerDataUpdate m;
    @Nullable
    private GXIExtensionContainerItemBind n;
    @Nullable
    private GXIExtensionLottieAnimation o;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionBizMap;", "", "Lcom/alibaba/gaiax/GXTemplateEngine$h;", "item", "Ltb/ur2;", "convert", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public interface GXIExtensionBizMap {
        void convert(@NotNull GXTemplateEngine.h hVar);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionColor;", "", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "", "value", "", "convert", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Integer;", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public interface GXIExtensionColor {
        @Nullable
        Integer convert(@Nullable Context context, @NotNull String str);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionCompatibility;", "", "", "isCompatibilityContainerDataPassSequence", "isCompatibilityContainerNestTemplateJudgementCondition", "isPreventContainerDataSourceThrowException", "isPreventIconFontTypefaceThrowException", "isPreventAccessibilityThrowException", "isPreventFitContentThrowException", "isCompatibilityDataBindingFitContent", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public interface GXIExtensionCompatibility {
        boolean isCompatibilityContainerDataPassSequence();

        boolean isCompatibilityContainerNestTemplateJudgementCondition();

        boolean isCompatibilityDataBindingFitContent();

        boolean isPreventAccessibilityThrowException();

        boolean isPreventContainerDataSourceThrowException();

        boolean isPreventFitContentThrowException();

        boolean isPreventIconFontTypefaceThrowException();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&¨\u0006\u000b"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionContainerDataUpdate;", "", "Ltb/wq0;", "gxTemplateContext", "Lcom/alibaba/gaiax/render/view/container/GXContainerViewAdapter;", "gxContainerViewAdapter", "Lcom/alibaba/fastjson/JSONArray;", "old", "new", "Ltb/ur2;", "update", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public interface GXIExtensionContainerDataUpdate {
        void update(@NotNull wq0 wq0, @NotNull GXContainerViewAdapter gXContainerViewAdapter, @NotNull JSONArray jSONArray, @NotNull JSONArray jSONArray2);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JF\u0010\u000f\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH&¨\u0006\u0010"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionContainerItemBind;", "", "tag", "Landroid/view/ViewGroup;", "childItemContainer", "Lcom/alibaba/gaiax/GXTemplateEngine$e;", "childMeasureSize", "Lcom/alibaba/gaiax/GXTemplateEngine$h;", "childTemplateItem", "", "childItemPosition", "Ltb/xq0;", "childVisualNestTemplateNode", "Lcom/alibaba/fastjson/JSONObject;", "childItemData", "bindViewHolder", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public interface GXIExtensionContainerItemBind {
        @Nullable
        Object bindViewHolder(@Nullable Object obj, @NotNull ViewGroup viewGroup, @NotNull GXTemplateEngine.e eVar, @NotNull GXTemplateEngine.h hVar, int i, @Nullable xq0 xq0, @NotNull JSONObject jSONObject);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0001H&¨\u0006\u0007"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionDataBinding;", "", "", "expVersion", "value", "Ltb/po0;", "create", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public interface GXIExtensionDataBinding {
        @Nullable
        po0 create(@Nullable String str, @NotNull Object obj);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0005J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionDynamicProperty;", "", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionDynamicProperty$a;", "params", "convert", "a", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public interface GXIExtensionDynamicProperty {

        /* compiled from: Taobao */
        public static final class a {
            @NotNull
            private final String a;
            @NotNull
            private final Object b;
            @Nullable
            private fp0 c;
            @Nullable
            private uq0 d;

            public a(@NotNull String str, @NotNull Object obj) {
                k21.i(str, "propertyName");
                k21.i(obj, "value");
                this.a = str;
                this.b = obj;
            }

            @Nullable
            public final uq0 a() {
                return this.d;
            }

            @Nullable
            public final fp0 b() {
                return this.c;
            }

            @NotNull
            public final String c() {
                return this.a;
            }

            @NotNull
            public final Object d() {
                return this.b;
            }

            public final void e(@Nullable uq0 uq0) {
                this.d = uq0;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return k21.d(this.a, aVar.a) && k21.d(this.b, aVar.b);
            }

            public final void f(@Nullable cp0 cp0) {
            }

            public final void g(@Nullable fp0 fp0) {
                this.c = fp0;
            }

            public int hashCode() {
                return (this.a.hashCode() * 31) + this.b.hashCode();
            }

            @NotNull
            public String toString() {
                return "GXParams(propertyName=" + this.a + ", value=" + this.b + ')';
            }
        }

        @Nullable
        Object convert(@NotNull a aVar);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0004\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionException;", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "Ltb/ur2;", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public interface GXIExtensionException {
        void exception(@NotNull Exception exc);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0001H&J\u001c\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H&¨\u0006\t"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionExpression;", "", "", "expVersion", "value", "Lcom/alibaba/gaiax/template/GXIExpression;", "create", "", "isTrue", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public interface GXIExtensionExpression {
        @NotNull
        GXIExpression create(@Nullable String str, @NotNull Object obj);

        boolean isTrue(@Nullable String str, @Nullable Object obj);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionFontFamily;", "", "", "fontFamilyName", "Landroid/graphics/Typeface;", Constants.Name.FONT_FAMILY, "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public interface GXIExtensionFontFamily {
        @Nullable
        Typeface fontFamily(@NotNull String str);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¨\u0006\t"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionGrid;", "", "", "propertyName", "Ltb/wq0;", "gxTemplateContext", "Ltb/fp0;", "gridConfig", "convert", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public interface GXIExtensionGrid {
        @Nullable
        Object convert(@NotNull String str, @NotNull wq0 wq0, @NotNull fp0 fp0);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¨\u0006\u0004"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionLottieAnimation;", "", "Ltb/mp0;", "create", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public interface GXIExtensionLottieAnimation {
        @Nullable
        mp0 create();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0004"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionNodeEvent;", "", "Lcom/alibaba/gaiax/render/node/GXINodeEvent;", "create", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public interface GXIExtensionNodeEvent {
        @NotNull
        GXINodeEvent create();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\"\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\u000f"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionScroll;", "", "", "propertyName", "Ltb/wq0;", "gxTemplateContext", "Ltb/lq0;", "scrollConfig", "convert", "Lcom/alibaba/gaiax/render/view/container/GXContainer;", "container", "Lcom/alibaba/fastjson/JSONObject;", "extend", "Ltb/ur2;", "scrollIndex", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public interface GXIExtensionScroll {
        @Nullable
        Object convert(@NotNull String str, @NotNull wq0 wq0, @NotNull lq0 lq0);

        void scrollIndex(@NotNull wq0 wq0, @NotNull GXContainer gXContainer, @Nullable JSONObject jSONObject);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionSize;", "", "", "value", "", "create", "(Ljava/lang/String;)Ljava/lang/Float;", "convert", "(F)Ljava/lang/Float;", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public interface GXIExtensionSize {
        @Nullable
        Float convert(float f);

        @Nullable
        Float create(@NotNull String str);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0005J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionStaticProperty;", "", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionStaticProperty$a;", "params", "convert", "a", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public interface GXIExtensionStaticProperty {

        /* compiled from: Taobao */
        public static final class a {
            @NotNull
            private final String a;
            @NotNull
            private final Object b;

            public a(@NotNull String str, @NotNull Object obj) {
                k21.i(str, "propertyName");
                k21.i(obj, "value");
                this.a = str;
                this.b = obj;
            }

            @NotNull
            public final String a() {
                return this.a;
            }

            @NotNull
            public final Object b() {
                return this.b;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return k21.d(this.a, aVar.a) && k21.d(this.b, aVar.b);
            }

            public int hashCode() {
                return (this.a.hashCode() * 31) + this.b.hashCode();
            }

            @NotNull
            public String toString() {
                return "GXParams(propertyName=" + this.a + ", value=" + this.b + ')';
            }
        }

        @Nullable
        Object convert(@NotNull a aVar);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionTemplateInfoSource;", "", "Lcom/alibaba/gaiax/GXTemplateEngine$h;", "gxTemplateItem", "Lcom/alibaba/gaiax/template/GXTemplateInfo;", "getTemplateInfo", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public interface GXIExtensionTemplateInfoSource {
        @Nullable
        GXTemplateInfo getTemplateInfo(@NotNull GXTemplateEngine.h hVar);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionTemplateSource;", "", "Lcom/alibaba/gaiax/GXTemplateEngine$h;", "gxTemplateItem", "Ltb/vq0;", "getTemplate", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public interface GXIExtensionTemplateSource {
        @Nullable
        vq0 getTemplate(@NotNull GXTemplateEngine.h hVar);
    }

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final GXRegisterCenter a() {
            return (GXRegisterCenter) GXRegisterCenter.p.getValue();
        }
    }

    @NotNull
    public final GXRegisterCenter A(@NotNull GXIExtensionNodeEvent gXIExtensionNodeEvent) {
        k21.i(gXIExtensionNodeEvent, "extensionNodeEvent");
        this.l = gXIExtensionNodeEvent;
        return this;
    }

    @NotNull
    public final GXRegisterCenter B(@NotNull GXIExtensionScroll gXIExtensionScroll) {
        k21.i(gXIExtensionScroll, "extensionScroll");
        this.i = gXIExtensionScroll;
        return this;
    }

    @NotNull
    public final GXRegisterCenter C(@NotNull GXIExtensionSize gXIExtensionSize) {
        k21.i(gXIExtensionSize, "extensionSize");
        this.e = gXIExtensionSize;
        return this;
    }

    @NotNull
    public final GXRegisterCenter D(@NotNull GXIExtensionStaticProperty gXIExtensionStaticProperty) {
        k21.i(gXIExtensionStaticProperty, "extensionStaticProperty");
        this.g = gXIExtensionStaticProperty;
        return this;
    }

    @NotNull
    public final GXRegisterCenter E(@NotNull GXIExtensionTemplateInfoSource gXIExtensionTemplateInfoSource, int i2) {
        k21.i(gXIExtensionTemplateInfoSource, "source");
        GXTemplateEngine.Companion.a().l().c().d(gXIExtensionTemplateInfoSource, i2);
        return this;
    }

    @NotNull
    public final GXRegisterCenter F(@NotNull GXIExtensionTemplateSource gXIExtensionTemplateSource, int i2) {
        k21.i(gXIExtensionTemplateSource, "source");
        GXTemplateEngine.Companion.a().l().d().d(gXIExtensionTemplateSource, i2);
        return this;
    }

    @NotNull
    public final GXRegisterCenter G(@NotNull String str, @NotNull Class<?> cls) {
        k21.i(str, "viewType");
        k21.i(cls, "clazz");
        dr0.INSTANCE.c().put(str, cls);
        return this;
    }

    @Nullable
    public final GXIExtensionBizMap b() {
        return this.a;
    }

    @Nullable
    public final GXIExtensionColor c() {
        return this.d;
    }

    @Nullable
    public final GXIExtensionCompatibility d() {
        return this.k;
    }

    @Nullable
    public final GXIExtensionContainerDataUpdate e() {
        return this.m;
    }

    @Nullable
    public final GXIExtensionContainerItemBind f() {
        return this.n;
    }

    @Nullable
    public final GXIExtensionDataBinding g() {
        return this.b;
    }

    @Nullable
    public final GXIExtensionDynamicProperty h() {
        return this.f;
    }

    @Nullable
    public final GXIExtensionException i() {
        return this.j;
    }

    @Nullable
    public final GXIExtensionExpression j() {
        return this.c;
    }

    @Nullable
    public final GXIExtensionGrid k() {
        return this.h;
    }

    @Nullable
    public final GXIExtensionLottieAnimation l() {
        return this.o;
    }

    @Nullable
    public final GXIExtensionNodeEvent m() {
        return this.l;
    }

    @Nullable
    public final GXIExtensionScroll n() {
        return this.i;
    }

    @Nullable
    public final GXIExtensionSize o() {
        return this.e;
    }

    @Nullable
    public final GXIExtensionStaticProperty p() {
        return this.g;
    }

    @NotNull
    public final GXRegisterCenter q(@NotNull GXIExtensionColor gXIExtensionColor) {
        k21.i(gXIExtensionColor, "extensionColor");
        this.d = gXIExtensionColor;
        return this;
    }

    @NotNull
    public final GXRegisterCenter r(@NotNull GXIExtensionCompatibility gXIExtensionCompatibility) {
        k21.i(gXIExtensionCompatibility, "extensionCompatibility");
        this.k = gXIExtensionCompatibility;
        return this;
    }

    @NotNull
    public final GXRegisterCenter s(@NotNull GXIExtensionContainerDataUpdate gXIExtensionContainerDataUpdate) {
        k21.i(gXIExtensionContainerDataUpdate, "extensionContainerDataUpdate");
        this.m = gXIExtensionContainerDataUpdate;
        return this;
    }

    @NotNull
    public final GXRegisterCenter t(@NotNull GXIExtensionContainerItemBind gXIExtensionContainerItemBind) {
        k21.i(gXIExtensionContainerItemBind, "extensionContainerItemBind");
        this.n = gXIExtensionContainerItemBind;
        return this;
    }

    @NotNull
    public final GXRegisterCenter u(@NotNull GXIExtensionDataBinding gXIExtensionDataBinding) {
        k21.i(gXIExtensionDataBinding, "databindingExtensionDataBinding");
        this.b = gXIExtensionDataBinding;
        return this;
    }

    @NotNull
    public final GXRegisterCenter v(@NotNull GXIExtensionDynamicProperty gXIExtensionDynamicProperty) {
        k21.i(gXIExtensionDynamicProperty, "extensionDynamicProperty");
        this.f = gXIExtensionDynamicProperty;
        return this;
    }

    @NotNull
    public final GXRegisterCenter w(@NotNull GXIExtensionException gXIExtensionException) {
        k21.i(gXIExtensionException, "extensionException");
        this.j = gXIExtensionException;
        return this;
    }

    @NotNull
    public final GXRegisterCenter x(@NotNull GXIExtensionExpression gXIExtensionExpression) {
        k21.i(gXIExtensionExpression, "extensionExpression");
        this.c = gXIExtensionExpression;
        return this;
    }

    @NotNull
    public final GXRegisterCenter y(@NotNull GXIExtensionGrid gXIExtensionGrid) {
        k21.i(gXIExtensionGrid, "extensionGrid");
        this.h = gXIExtensionGrid;
        return this;
    }

    @NotNull
    public final GXRegisterCenter z(@NotNull GXIExtensionLottieAnimation gXIExtensionLottieAnimation) {
        k21.i(gXIExtensionLottieAnimation, "extensionLottieAnimation");
        this.o = gXIExtensionLottieAnimation;
        return this;
    }
}
