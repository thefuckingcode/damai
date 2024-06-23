package tb;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.view.View;
import com.alibaba.aliweex.adapter.module.audio.IWXAudio;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.template.GXIExpression;
import com.alibaba.gaiax.template.animation.GXIPropAnimation;
import com.alibaba.gaiax.template.animation.GXPropAnimationSet;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class fq0 implements GXIPropAnimation {
    @NotNull
    public static final a Companion = new a(null);
    @Nullable
    private static ArgbEvaluator h;
    @NotNull
    private final GXPropAnimationSet.GXPropName a;
    @NotNull
    private final GXPropAnimationSet.b b;
    private int c = 300;
    @NotNull
    private GXPropAnimationSet.GXPropInterpolator d = GXPropAnimationSet.GXPropInterpolator.STANDARD;
    private int e;
    @NotNull
    private GXPropAnimationSet.GXPropLoopMode f = GXPropAnimationSet.GXPropLoopMode.RESET;
    private long g;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @Nullable
        public final fq0 a(@NotNull JSONObject jSONObject) {
            k21.i(jSONObject, "data");
            GXPropAnimationSet.GXPropName a = GXPropAnimationSet.GXPropName.Companion.a(jSONObject.getString("propName"));
            GXPropAnimationSet.b a2 = GXPropAnimationSet.b.Companion.a(jSONObject);
            if (a == null || a2 == null) {
                return null;
            }
            fq0 fq0 = new fq0(a, a2);
            String string = jSONObject.getString("duration");
            if (string != null) {
                fq0.f(Integer.parseInt(string));
            }
            String string2 = jSONObject.getString("interpolator");
            if (string2 != null) {
                fq0.g(GXPropAnimationSet.GXPropInterpolator.Companion.a(string2));
            }
            String string3 = jSONObject.getString(GXPropAnimationSet.GXPropLoopMode.KEY_LOOP_MODE);
            if (string3 != null) {
                fq0.i(GXPropAnimationSet.GXPropLoopMode.Companion.a(string3));
            }
            if (jSONObject.containsKey(IWXAudio.KEY_LOOP) && zo0.d(jSONObject, IWXAudio.KEY_LOOP)) {
                fq0.h(Integer.MAX_VALUE);
            } else if (jSONObject.containsKey("loopCount")) {
                if (fq0.c() == GXPropAnimationSet.GXPropLoopMode.REVERSE) {
                    fq0.h(Math.max(1, (jSONObject.getIntValue("loopCount") * 2) - 1));
                } else {
                    fq0.h(Math.max(0, jSONObject.getIntValue("loopCount") - 1));
                }
            }
            if (jSONObject.containsKey("delay")) {
                fq0.e(jSONObject.getLongValue("delay"));
            }
            return fq0;
        }
    }

    public fq0(@NotNull GXPropAnimationSet.GXPropName gXPropName, @NotNull GXPropAnimationSet.b bVar) {
        k21.i(gXPropName, "name");
        k21.i(bVar, "value");
        this.a = gXPropName;
        this.b = bVar;
    }

    /* access modifiers changed from: private */
    public static final void b(fq0 fq0, View view, ValueAnimator valueAnimator) {
        k21.i(fq0, "this$0");
        k21.i(view, "$targetView");
        if (valueAnimator.getAnimatedValue() instanceof Float) {
            GXPropAnimationSet.GXPropName d2 = fq0.d();
            Object animatedValue = valueAnimator.getAnimatedValue();
            Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            d2.setValue(view, ((Float) animatedValue).floatValue());
        } else if (valueAnimator.getAnimatedValue() instanceof Integer) {
            GXPropAnimationSet.GXPropName d3 = fq0.d();
            Object animatedValue2 = valueAnimator.getAnimatedValue();
            Objects.requireNonNull(animatedValue2, "null cannot be cast to non-null type kotlin.Int");
            d3.setColorValue(view, ((Integer) animatedValue2).intValue());
        }
    }

    @NotNull
    public final GXPropAnimationSet.GXPropLoopMode c() {
        return this.f;
    }

    @Override // com.alibaba.gaiax.template.animation.GXIPropAnimation
    @NotNull
    public Animator createAnimator(@NotNull View view) {
        k21.i(view, "targetView");
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setRepeatCount(this.e);
        valueAnimator.setRepeatMode(this.f == GXPropAnimationSet.GXPropLoopMode.RESET ? 1 : 2);
        valueAnimator.setDuration((long) this.c);
        valueAnimator.setInterpolator(this.d.value());
        GXPropAnimationSet.b bVar = this.b;
        if (bVar instanceof GXPropAnimationSet.b.c) {
            valueAnimator.setFloatValues(((GXPropAnimationSet.b.c) bVar).a(), ((GXPropAnimationSet.b.c) this.b).b());
        } else if (bVar instanceof GXPropAnimationSet.b.C0088b) {
            if (h == null) {
                h = new ArgbEvaluator();
            }
            valueAnimator.setEvaluator(h);
            valueAnimator.setIntValues(ko0.c(((GXPropAnimationSet.b.C0088b) this.b).a(), null, 1, null), ko0.c(((GXPropAnimationSet.b.C0088b) this.b).b(), null, 1, null));
        }
        valueAnimator.addUpdateListener(new eq0(this, view));
        valueAnimator.setStartDelay(this.g);
        return valueAnimator;
    }

    @NotNull
    public final GXPropAnimationSet.GXPropName d() {
        return this.a;
    }

    public final void e(long j) {
        this.g = j;
    }

    @Override // com.alibaba.gaiax.template.animation.GXIAnimation
    public void executeAnimation(@Nullable GXIExpression gXIExpression, @Nullable GXIExpression gXIExpression2, @NotNull wq0 wq0, @NotNull up0 up0, @NotNull JSONObject jSONObject) {
        k21.i(wq0, "gxTemplateContext");
        k21.i(up0, "gxNode");
        k21.i(jSONObject, "gxTemplateData");
    }

    public final void f(int i) {
        this.c = i;
    }

    public final void g(@NotNull GXPropAnimationSet.GXPropInterpolator gXPropInterpolator) {
        k21.i(gXPropInterpolator, "<set-?>");
        this.d = gXPropInterpolator;
    }

    public final void h(int i) {
        this.e = i;
    }

    public final void i(@NotNull GXPropAnimationSet.GXPropLoopMode gXPropLoopMode) {
        k21.i(gXPropLoopMode, "<set-?>");
        this.f = gXPropLoopMode;
    }
}
