package com.youku.gaiax.provider.module.animation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieTask;
import com.airbnb.lottie.a;
import com.airbnb.lottie.b;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.template.GXIExpression;
import com.youku.gaiax.provider.R;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.mp0;
import tb.up0;
import tb.wq0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0007H\u0002JL\u0010\u001a\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002JL\u0010\u001d\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J4\u0010\u001f\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¨\u0006\""}, d2 = {"Lcom/youku/gaiax/provider/module/animation/GaiaXLottieAnimation;", "Ltb/mp0;", "", "value", "localAppendJson", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Lcom/airbnb/lottie/LottieAnimationView;", "localCreateLottieView", "lottieView", "Ltb/ur2;", "localInitLottieLocalResourceDir", "Landroid/view/ViewGroup;", "lottieContainer", "Ltb/wq0;", "gxTemplateContext", "Ltb/up0;", "gxNode", "Lcom/alibaba/fastjson/JSONObject;", "gxTemplateData", "Lcom/alibaba/gaiax/template/GXIExpression;", "gxState", "gxAnimationData", "localUri", "", "loopCount", "localPlay", "remoteCreateLottieView", "remoteUri", "remotePlay", "gxAnimationExpression", "executeAnimation", "<init>", "()V", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXLottieAnimation extends mp0 {
    private final String localAppendJson(String str) {
        return (str == null || (o.v(str, ".json", false, 2, null))) ? str : k21.r(str, ".json");
    }

    private final LottieAnimationView localCreateLottieView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.gaiax_inner_lottie_auto_play, (ViewGroup) null);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
        LottieAnimationView lottieAnimationView = (LottieAnimationView) inflate;
        lottieAnimationView.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, -1, 0, 0));
        return lottieAnimationView;
    }

    private final void localInitLottieLocalResourceDir(String str, LottieAnimationView lottieAnimationView) {
        int i = StringsKt__StringsKt.f0(str, "/", 0, false, 6, null);
        if (i > 0) {
            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
            boolean z = false;
            String substring = str.substring(0, i);
            k21.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            if (substring.length() > 0) {
                z = true;
            }
            if (z) {
                lottieAnimationView.setImageAssetsFolder(k21.r(substring, "/images/"));
            }
        }
    }

    private final void localPlay(ViewGroup viewGroup, wq0 wq0, up0 up0, JSONObject jSONObject, GXIExpression gXIExpression, JSONObject jSONObject2, String str, int i) {
        LottieAnimationView lottieAnimationView;
        if (viewGroup.getChildCount() == 0) {
            Context context = viewGroup.getContext();
            k21.h(context, "lottieContainer.context");
            lottieAnimationView = localCreateLottieView(context);
        } else {
            View childAt = viewGroup.getChildAt(0);
            lottieAnimationView = childAt instanceof LottieAnimationView ? (LottieAnimationView) childAt : null;
        }
        boolean z = true;
        if (lottieAnimationView == null || !lottieAnimationView.isAnimating()) {
            z = false;
        }
        if (!z && !up0.r() && lottieAnimationView != null) {
            localInitLottieLocalResourceDir(str, lottieAnimationView);
            lottieAnimationView.removeAllAnimatorListeners();
            lottieAnimationView.removeAllUpdateListeners();
            lottieAnimationView.removeAllLottieOnCompositionLoadedListener();
            lottieAnimationView.setAnimation(localAppendJson(str));
            lottieAnimationView.setRepeatCount(i);
            lottieAnimationView.addAnimatorListener(new GaiaXLottieAnimation$localPlay$1(up0, lottieAnimationView, gXIExpression, wq0, jSONObject, jSONObject2));
            lottieAnimationView.playAnimation();
            if (viewGroup.getChildCount() == 0) {
                lottieAnimationView.setClickable(false);
                viewGroup.setClickable(false);
                viewGroup.addView(lottieAnimationView);
            }
        }
    }

    private final LottieAnimationView remoteCreateLottieView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.gaiax_inner_lottie_auto_play, (ViewGroup) null);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
        LottieAnimationView lottieAnimationView = (LottieAnimationView) inflate;
        lottieAnimationView.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, -1, 0, 0));
        return lottieAnimationView;
    }

    private final void remotePlay(ViewGroup viewGroup, wq0 wq0, up0 up0, JSONObject jSONObject, GXIExpression gXIExpression, JSONObject jSONObject2, String str, int i) {
        LottieAnimationView lottieAnimationView;
        boolean z;
        if (viewGroup.getChildCount() == 0) {
            Context context = viewGroup.getContext();
            k21.h(context, "lottieContainer.context");
            lottieAnimationView = remoteCreateLottieView(context);
        } else {
            View childAt = viewGroup.getChildAt(0);
            lottieAnimationView = childAt instanceof LottieAnimationView ? (LottieAnimationView) childAt : null;
        }
        if (lottieAnimationView != null && lottieAnimationView.isAnimating()) {
            z = true;
        } else {
            z = false;
        }
        if (!z && !up0.r() && lottieAnimationView != null) {
            lottieAnimationView.removeAllAnimatorListeners();
            lottieAnimationView.removeAllUpdateListeners();
            lottieAnimationView.removeAllLottieOnCompositionLoadedListener();
            up0.L(true);
            LottieTask<a> s = b.s(lottieAnimationView.getContext(), str);
            s.f(new GaiaXLottieAnimation$remotePlay$1(s, up0, lottieAnimationView, i, gXIExpression, wq0, jSONObject, jSONObject2));
            if (viewGroup.getChildCount() == 0) {
                lottieAnimationView.setClickable(false);
                viewGroup.setClickable(false);
                viewGroup.addView(lottieAnimationView);
            }
        }
    }

    @Override // tb.mp0, com.alibaba.gaiax.template.animation.GXIAnimation
    public void executeAnimation(@Nullable GXIExpression gXIExpression, @Nullable GXIExpression gXIExpression2, @NotNull wq0 wq0, @NotNull up0 up0, @NotNull JSONObject jSONObject) {
        Object obj;
        k21.i(wq0, "gxTemplateContext");
        k21.i(up0, "gxNode");
        k21.i(jSONObject, "gxTemplateData");
        View p = up0.p();
        ViewGroup viewGroup = p instanceof ViewGroup ? (ViewGroup) p : null;
        if (viewGroup != null) {
            if (gXIExpression2 == null) {
                obj = null;
            } else {
                obj = gXIExpression2.value(jSONObject);
            }
            JSONObject jSONObject2 = obj instanceof JSONObject ? (JSONObject) obj : null;
            GXIExpression gxRemoteUri = getGxRemoteUri();
            Object value = gxRemoteUri == null ? null : gxRemoteUri.value(jSONObject);
            String str = value instanceof String ? (String) value : null;
            if (str != null) {
                remotePlay(viewGroup, wq0, up0, jSONObject, gXIExpression, jSONObject2, str, getLoopCount());
                return;
            }
            GXIExpression gxLocalUri = getGxLocalUri();
            Object value2 = gxLocalUri == null ? null : gxLocalUri.value(jSONObject);
            String str2 = value2 instanceof String ? (String) value2 : null;
            if (str2 != null) {
                localPlay(viewGroup, wq0, up0, jSONObject, gXIExpression, jSONObject2, str2, getLoopCount());
            }
        }
    }
}
