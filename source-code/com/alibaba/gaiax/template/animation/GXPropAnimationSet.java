package com.alibaba.gaiax.template.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.template.GXIExpression;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.fq0;
import tb.k21;
import tb.ko0;
import tb.m40;
import tb.nq0;
import tb.up0;
import tb.ur2;
import tb.vo0;
import tb.wq0;
import tb.zo0;

/* compiled from: Taobao */
public final class GXPropAnimationSet implements GXIAnimation, GXIPropAnimation {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private GXPropOrderingType a = GXPropOrderingType.TOGETHER;
    @NotNull
    private final List<GXIPropAnimation> b = new ArrayList();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropInterpolator;", "", "Landroid/view/animation/Interpolator;", "value", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", GXPropInterpolator.KEY_LINEAR, GXPropInterpolator.KEY_ACCELERATE, GXPropInterpolator.KEY_DECELERATE, "STANDARD", GXPropInterpolator.KEY_ANTICIPATE, GXPropInterpolator.KEY_OVERSHOOT, GXPropInterpolator.KEY_SPRING, GXPropInterpolator.KEY_BOUNCE, GXPropInterpolator.KEY_COSINE, "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public enum GXPropInterpolator {
        LINEAR,
        ACCELERATE,
        DECELERATE,
        STANDARD,
        ANTICIPATE,
        OVERSHOOT,
        SPRING,
        BOUNCE,
        COSINE;
        
        @NotNull
        public static final a Companion = new a(null);
        @NotNull
        private static final String KEY_ACCELERATE = "ACCELERATE";
        @NotNull
        private static final String KEY_ANTICIPATE = "ANTICIPATE";
        @NotNull
        private static final String KEY_BOUNCE = "BOUNCE";
        @NotNull
        private static final String KEY_COSINE = "COSINE";
        @NotNull
        private static final String KEY_DECELERATE = "DECELERATE";
        @NotNull
        private static final String KEY_LINEAR = "LINEAR";
        @NotNull
        private static final String KEY_OVERSHOOT = "OVERSHOOT";
        @NotNull
        private static final String KEY_SPRING = "SPRING";
        @NotNull
        private static final String KEY_STANDARD = "STANDARD";

        /* compiled from: Taobao */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(m40 m40) {
                this();
            }

            @NotNull
            public final GXPropInterpolator a(@NotNull String str) {
                k21.i(str, "value");
                if (o.w(str, GXPropInterpolator.KEY_LINEAR, true)) {
                    return GXPropInterpolator.LINEAR;
                }
                if (o.w(str, GXPropInterpolator.KEY_ACCELERATE, true)) {
                    return GXPropInterpolator.ACCELERATE;
                }
                if (o.w(str, GXPropInterpolator.KEY_DECELERATE, true)) {
                    return GXPropInterpolator.DECELERATE;
                }
                if (o.w(str, "STANDARD", true)) {
                    return GXPropInterpolator.STANDARD;
                }
                if (o.w(str, GXPropInterpolator.KEY_ANTICIPATE, true)) {
                    return GXPropInterpolator.ANTICIPATE;
                }
                if (o.w(str, GXPropInterpolator.KEY_OVERSHOOT, true)) {
                    return GXPropInterpolator.OVERSHOOT;
                }
                if (o.w(str, GXPropInterpolator.KEY_SPRING, true)) {
                    return GXPropInterpolator.SPRING;
                }
                if (o.w(str, GXPropInterpolator.KEY_BOUNCE, true)) {
                    return GXPropInterpolator.BOUNCE;
                }
                if (o.w(str, GXPropInterpolator.KEY_COSINE, true)) {
                    return GXPropInterpolator.COSINE;
                }
                return GXPropInterpolator.STANDARD;
            }
        }

        @NotNull
        public final Interpolator value() {
            return new LinearInterpolator();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropLoopMode;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "RESET", "REVERSE", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public enum GXPropLoopMode {
        RESET,
        REVERSE;
        
        @NotNull
        public static final a Companion = new a(null);
        @NotNull
        public static final String KEY_LOOP_MODE = "loopMode";

        /* compiled from: Taobao */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(m40 m40) {
                this();
            }

            @NotNull
            public final GXPropLoopMode a(@NotNull String str) {
                k21.i(str, "data");
                if (o.w(str, "RESET", true)) {
                    return GXPropLoopMode.RESET;
                }
                if (o.w(str, "REVERSE", true)) {
                    return GXPropLoopMode.REVERSE;
                }
                return GXPropLoopMode.RESET;
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0010\b\u0001\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0016B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\rH\u0002J\u0016\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0004J\u0016\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\rj\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001d"}, d2 = {"Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropName;", "", "Landroid/view/View;", "targetView", "", "value", "Ltb/ur2;", "setPositionX", "setPositionY", "setOpacity", "setScaleX", "setScaleY", "setRotation", "", "setRenderColor", "finalValue", "setValue", "color", "setColorValue", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "POSITION_X", "POSITION_Y", "OPACITY", "SCALE", "ROTATION", "RENDER_COLOR", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public enum GXPropName {
        POSITION_X,
        POSITION_Y,
        OPACITY,
        SCALE,
        ROTATION,
        RENDER_COLOR;
        
        @NotNull
        public static final a Companion = new a(null);
        @NotNull
        private static final String KEY_OPACITY = "opacity";
        @NotNull
        private static final String KEY_POSITION_X = "positionX";
        @NotNull
        private static final String KEY_POSITION_Y = "positionY";
        @NotNull
        private static final String KEY_RENDER_COLOR = "renderColor";
        @NotNull
        private static final String KEY_ROTATION = "rotation";
        @NotNull
        private static final String KEY_SCALE = "scale";

        /* compiled from: Taobao */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(m40 m40) {
                this();
            }

            @Nullable
            public final GXPropName a(@Nullable String str) {
                if (o.w(str, GXPropName.KEY_POSITION_X, true)) {
                    return GXPropName.POSITION_X;
                }
                if (o.w(str, GXPropName.KEY_POSITION_Y, true)) {
                    return GXPropName.POSITION_Y;
                }
                if (o.w(str, "opacity", true)) {
                    return GXPropName.OPACITY;
                }
                if (o.w(str, "scale", true)) {
                    return GXPropName.SCALE;
                }
                if (o.w(str, "rotation", true)) {
                    return GXPropName.ROTATION;
                }
                if (o.w(str, GXPropName.KEY_RENDER_COLOR, true)) {
                    return GXPropName.RENDER_COLOR;
                }
                return null;
            }
        }

        /* compiled from: Taobao */
        public /* synthetic */ class b {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[GXPropName.values().length];
                iArr[GXPropName.POSITION_X.ordinal()] = 1;
                iArr[GXPropName.POSITION_Y.ordinal()] = 2;
                iArr[GXPropName.OPACITY.ordinal()] = 3;
                iArr[GXPropName.SCALE.ordinal()] = 4;
                iArr[GXPropName.ROTATION.ordinal()] = 5;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private final void setOpacity(View view, float f) {
            view.setAlpha(f);
        }

        private final void setPositionX(View view, float f) {
            view.setTranslationX(nq0.Companion.e(f));
        }

        private final void setPositionY(View view, float f) {
            view.setTranslationY(nq0.Companion.e(f));
        }

        private final void setRenderColor(View view, int i) {
            if (view instanceof TextView) {
                ((TextView) view).setTextColor(i);
            } else {
                view.setBackgroundColor(i);
            }
        }

        private final void setRotation(View view, float f) {
            view.setRotation(f);
        }

        private final void setScaleX(View view, float f) {
            view.setScaleX(f);
        }

        private final void setScaleY(View view, float f) {
            view.setScaleY(f);
        }

        public final void setColorValue(@NotNull View view, int i) {
            k21.i(view, "targetView");
            setRenderColor(view, i);
        }

        public final void setValue(@NotNull View view, float f) {
            k21.i(view, "targetView");
            int i = b.$EnumSwitchMapping$0[ordinal()];
            if (i == 1) {
                setPositionX(view, f);
            } else if (i == 2) {
                setPositionY(view, f);
            } else if (i == 3) {
                setOpacity(view, f);
            } else if (i == 4) {
                setScaleX(view, f);
                setScaleY(view, f);
            } else if (i == 5) {
                setRotation(view, f);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropOrderingType;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "TOGETHER", GXPropOrderingType.KEY_SEQUENTIALLY, "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public enum GXPropOrderingType {
        TOGETHER,
        SEQUENTIALLY;
        
        @NotNull
        public static final a Companion = new a(null);
        @NotNull
        public static final String KEY_ORDERING = "ordering";
        @NotNull
        private static final String KEY_SEQUENTIALLY = "SEQUENTIALLY";

        /* compiled from: Taobao */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(m40 m40) {
                this();
            }

            @NotNull
            public final GXPropOrderingType a(@NotNull String str) {
                k21.i(str, "value");
                return o.w(str, GXPropOrderingType.KEY_SEQUENTIALLY, true) ? GXPropOrderingType.SEQUENTIALLY : GXPropOrderingType.TOGETHER;
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropValueType;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "IntType", "FloatType", "ColorType", "GaiaX"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Taobao */
    public enum GXPropValueType {
        IntType,
        FloatType,
        ColorType;
        
        @NotNull
        public static final a Companion = new a(null);

        /* compiled from: Taobao */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(m40 m40) {
                this();
            }

            @Nullable
            public final GXPropValueType a(@NotNull String str) {
                k21.i(str, "value");
                int hashCode = str.hashCode();
                if (hashCode != -2111334474) {
                    if (hashCode != 1957563337) {
                        if (hashCode == 1980942653 && str.equals("colorType")) {
                            return GXPropValueType.ColorType;
                        }
                    } else if (str.equals("intType")) {
                        return GXPropValueType.IntType;
                    }
                } else if (str.equals("floatType")) {
                    return GXPropValueType.FloatType;
                }
                return null;
            }
        }
    }

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @Nullable
        public final GXPropAnimationSet a(@Nullable JSONObject jSONObject) {
            JSONArray jSONArray;
            if (jSONObject == null || (jSONArray = jSONObject.getJSONArray("animators")) == null || !(!jSONArray.isEmpty())) {
                return null;
            }
            GXPropAnimationSet gXPropAnimationSet = new GXPropAnimationSet();
            for (Object obj : jSONArray) {
                if (obj instanceof JSONObject) {
                    JSONObject jSONObject2 = (JSONObject) obj;
                    if (jSONObject2.containsKey("propAnimatorSet")) {
                        GXPropAnimationSet a = GXPropAnimationSet.Companion.a(jSONObject2.getJSONObject("propAnimatorSet"));
                        if (a != null) {
                            gXPropAnimationSet.a().add(a);
                        }
                    } else if (jSONObject2.containsKey("propAnimator")) {
                        fq0.a aVar = fq0.Companion;
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("propAnimator");
                        k21.h(jSONObject3, "it.getJSONObject(KEY_PROP_ANIMATOR)");
                        fq0 a2 = aVar.a(jSONObject3);
                        if (a2 != null) {
                            gXPropAnimationSet.a().add(a2);
                        }
                    } else {
                        fq0 a3 = fq0.Companion.a(jSONObject2);
                        if (a3 != null) {
                            gXPropAnimationSet.a().add(a3);
                        }
                    }
                }
            }
            String string = jSONObject.getString(GXPropOrderingType.KEY_ORDERING);
            if (string != null) {
                gXPropAnimationSet.d(GXPropOrderingType.Companion.a(string));
            }
            return gXPropAnimationSet;
        }
    }

    /* compiled from: Taobao */
    public static abstract class b {
        @NotNull
        public static final a Companion = new a(null);

        /* compiled from: Taobao */
        public static final class a {

            /* renamed from: com.alibaba.gaiax.template.animation.GXPropAnimationSet$b$a$a  reason: collision with other inner class name */
            /* compiled from: Taobao */
            public /* synthetic */ class C0087a {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[GXPropValueType.values().length];
                    iArr[GXPropValueType.IntType.ordinal()] = 1;
                    iArr[GXPropValueType.FloatType.ordinal()] = 2;
                    iArr[GXPropValueType.ColorType.ordinal()] = 3;
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            private a() {
            }

            public /* synthetic */ a(m40 m40) {
                this();
            }

            @Nullable
            public final b a(@NotNull JSONObject jSONObject) {
                k21.i(jSONObject, "data");
                GXPropValueType a = GXPropValueType.Companion.a(zo0.i(jSONObject, "valueType"));
                if (a == null) {
                    return null;
                }
                int i = C0087a.$EnumSwitchMapping$0[a.ordinal()];
                if (i == 1) {
                    return c.Companion.a(jSONObject);
                }
                if (i == 2) {
                    return c.Companion.a(jSONObject);
                }
                if (i == 3) {
                    return C0088b.Companion.a(jSONObject);
                }
                throw new NoWhenBranchMatchedException();
            }
        }

        /* renamed from: com.alibaba.gaiax.template.animation.GXPropAnimationSet$b$b  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public static final class C0088b extends b {
            @NotNull
            public static final a Companion = new a(null);
            @NotNull
            private final ko0 a;
            @NotNull
            private final ko0 b;

            /* renamed from: com.alibaba.gaiax.template.animation.GXPropAnimationSet$b$b$a */
            /* compiled from: Taobao */
            public static final class a {
                private a() {
                }

                public /* synthetic */ a(m40 m40) {
                    this();
                }

                @Nullable
                public final C0088b a(@NotNull JSONObject jSONObject) {
                    k21.i(jSONObject, "data");
                    String i = zo0.i(jSONObject, "valueFrom");
                    String i2 = zo0.i(jSONObject, "valueTo");
                    boolean z = true;
                    if (!(i.length() > 0)) {
                        return null;
                    }
                    if (i.length() <= 0) {
                        z = false;
                    }
                    if (!z) {
                        return null;
                    }
                    ko0.a aVar = ko0.Companion;
                    ko0 a = aVar.a(i);
                    ko0 a2 = aVar.a(i2);
                    if (a == null || a2 == null) {
                        return null;
                    }
                    return new C0088b(a, a2);
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0088b(@NotNull ko0 ko0, @NotNull ko0 ko02) {
                super(null);
                k21.i(ko0, "valueFrom");
                k21.i(ko02, "valueTo");
                this.a = ko0;
                this.b = ko02;
            }

            @NotNull
            public final ko0 a() {
                return this.a;
            }

            @NotNull
            public final ko0 b() {
                return this.b;
            }
        }

        /* compiled from: Taobao */
        public static final class c extends b {
            @NotNull
            public static final a Companion = new a(null);
            private final float a;
            private final float b;

            /* compiled from: Taobao */
            public static final class a {
                private a() {
                }

                public /* synthetic */ a(m40 m40) {
                    this();
                }

                @Nullable
                public final c a(@NotNull JSONObject jSONObject) {
                    k21.i(jSONObject, "data");
                    String i = zo0.i(jSONObject, "valueFrom");
                    String i2 = zo0.i(jSONObject, "valueTo");
                    boolean z = true;
                    if (!(i.length() > 0)) {
                        return null;
                    }
                    if (i.length() <= 0) {
                        z = false;
                    }
                    if (z) {
                        return new c(Float.parseFloat(i), Float.parseFloat(i2));
                    }
                    return null;
                }
            }

            public c(float f, float f2) {
                super(null);
                this.a = f;
                this.b = f2;
            }

            public final float a() {
                return this.a;
            }

            public final float b() {
                return this.b;
            }
        }

        private b() {
        }

        public /* synthetic */ b(m40 m40) {
            this();
        }
    }

    /* compiled from: Taobao */
    public /* synthetic */ class c {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GXPropOrderingType.values().length];
            iArr[GXPropOrderingType.TOGETHER.ordinal()] = 1;
            iArr[GXPropOrderingType.SEQUENTIALLY.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: Taobao */
    public static final class d extends vo0 {
        final /* synthetic */ wq0 a;
        final /* synthetic */ up0 b;
        final /* synthetic */ View c;

        d(wq0 wq0, up0 up0, View view) {
            this.a = wq0;
            this.b = up0;
            this.c = view;
        }

        @Override // tb.vo0
        public void onAnimationCancel(@Nullable Animator animator) {
            this.b.L(false);
        }

        @Override // tb.vo0
        public void onAnimationEnd(@Nullable Animator animator) {
            GXTemplateEngine.GXIEventListener c2;
            this.b.L(false);
            GXTemplateEngine.g j = this.a.j();
            if (j != null && (c2 = j.c()) != null) {
                GXTemplateEngine.b bVar = new GXTemplateEngine.b();
                up0 up0 = this.b;
                View view = this.c;
                bVar.g(GXTemplateEngine.b.STATE_END);
                bVar.f(up0.g());
                bVar.h(view);
                ur2 ur2 = ur2.INSTANCE;
                c2.onAnimationEvent(bVar);
            }
        }

        @Override // tb.vo0
        public void onAnimationStart(@Nullable Animator animator) {
            GXTemplateEngine.GXIEventListener c2;
            GXTemplateEngine.g j = this.a.j();
            if (j != null && (c2 = j.c()) != null) {
                GXTemplateEngine.b bVar = new GXTemplateEngine.b();
                up0 up0 = this.b;
                View view = this.c;
                bVar.g(GXTemplateEngine.b.STATE_START);
                bVar.f(up0.g());
                bVar.h(view);
                ur2 ur2 = ur2.INSTANCE;
                c2.onAnimationEvent(bVar);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        if (r2 != false) goto L_0x0027;
     */
    private final void c(wq0 wq0, up0 up0, View view) {
        if (up0.l() == null) {
            up0.U((AnimatorSet) createAnimator(view));
        }
        if (!up0.r()) {
            AnimatorSet l = up0.l();
            boolean z = true;
            if (l == null || !l.isRunning()) {
                z = false;
            }
        }
        AnimatorSet l2 = up0.l();
        if (l2 != null) {
            l2.cancel();
        }
        up0.L(false);
        AnimatorSet l3 = up0.l();
        if (l3 != null) {
            l3.removeAllListeners();
        }
        AnimatorSet l4 = up0.l();
        if (l4 != null) {
            l4.addListener(new d(wq0, up0, view));
        }
        AnimatorSet l5 = up0.l();
        if (l5 != null) {
            l5.start();
        }
    }

    @NotNull
    public final List<GXIPropAnimation> a() {
        return this.b;
    }

    @NotNull
    public final GXPropOrderingType b() {
        return this.a;
    }

    @Override // com.alibaba.gaiax.template.animation.GXIPropAnimation
    @NotNull
    public Animator createAnimator(@NotNull View view) {
        k21.i(view, "targetView");
        AnimatorSet animatorSet = new AnimatorSet();
        int i = c.$EnumSwitchMapping$0[b().ordinal()];
        if (i == 1) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = a().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().createAnimator(view));
            }
            animatorSet.playTogether(arrayList);
        } else if (i == 2) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it2 = a().iterator();
            while (it2.hasNext()) {
                arrayList2.add(it2.next().createAnimator(view));
            }
            animatorSet.playSequentially(arrayList2);
        }
        return animatorSet;
    }

    public final void d(@NotNull GXPropOrderingType gXPropOrderingType) {
        k21.i(gXPropOrderingType, "<set-?>");
        this.a = gXPropOrderingType;
    }

    @Override // com.alibaba.gaiax.template.animation.GXIAnimation
    public void executeAnimation(@Nullable GXIExpression gXIExpression, @Nullable GXIExpression gXIExpression2, @NotNull wq0 wq0, @NotNull up0 up0, @NotNull JSONObject jSONObject) {
        k21.i(wq0, "gxTemplateContext");
        k21.i(up0, "gxNode");
        k21.i(jSONObject, "gxTemplateData");
        View p = up0.p();
        if (p != null) {
            c(wq0, up0, p);
        }
    }
}
