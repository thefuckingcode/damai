package com.youku.gaiax.provider.module.animation;

import android.animation.Animator;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.template.GXIExpression;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import tb.up0;
import tb.ur2;
import tb.v;
import tb.vo0;
import tb.wq0;
import tb.yo0;
import tb.zo0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/youku/gaiax/provider/module/animation/GaiaXLottieAnimation$remotePlay$1$onResult$1$1", "Ltb/vo0;", "Landroid/animation/Animator;", v.TAK_ABILITY_SHOW_POP_ANIMATION, "Ltb/ur2;", "onAnimationEnd", "onAnimationStart", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXLottieAnimation$remotePlay$1$onResult$1$1 extends vo0 {
    final /* synthetic */ JSONObject $gxAnimationData;
    final /* synthetic */ up0 $gxNode;
    final /* synthetic */ GXIExpression $gxState;
    final /* synthetic */ wq0 $gxTemplateContext;
    final /* synthetic */ JSONObject $gxTemplateData;
    final /* synthetic */ LottieAnimationView $lottieView;

    GaiaXLottieAnimation$remotePlay$1$onResult$1$1(up0 up0, LottieAnimationView lottieAnimationView, GXIExpression gXIExpression, wq0 wq0, JSONObject jSONObject, JSONObject jSONObject2) {
        this.$gxNode = up0;
        this.$lottieView = lottieAnimationView;
        this.$gxState = gXIExpression;
        this.$gxTemplateContext = wq0;
        this.$gxTemplateData = jSONObject;
        this.$gxAnimationData = jSONObject2;
    }

    @Override // tb.vo0
    public void onAnimationEnd(@Nullable Animator animator) {
        GXTemplateEngine.GXIEventListener c;
        this.$gxNode.L(false);
        this.$lottieView.removeAllAnimatorListeners();
        this.$lottieView.removeAllUpdateListeners();
        this.$lottieView.removeAllLottieOnCompositionLoadedListener();
        this.$lottieView.setProgress(1.0f);
        yo0 yo0 = yo0.INSTANCE;
        GXIExpression gXIExpression = this.$gxState;
        String d = yo0.d(gXIExpression == null ? null : gXIExpression.expression());
        if (d != null) {
            zo0.l(this.$gxTemplateData, d, Boolean.FALSE);
        }
        GXTemplateEngine.g j = this.$gxTemplateContext.j();
        if (j != null && (c = j.c()) != null) {
            GXTemplateEngine.b bVar = new GXTemplateEngine.b();
            up0 up0 = this.$gxNode;
            LottieAnimationView lottieAnimationView = this.$lottieView;
            JSONObject jSONObject = this.$gxAnimationData;
            bVar.g(GXTemplateEngine.b.STATE_END);
            bVar.f(up0.g());
            bVar.h(lottieAnimationView);
            bVar.e(jSONObject);
            ur2 ur2 = ur2.INSTANCE;
            c.onAnimationEvent(bVar);
        }
    }

    @Override // tb.vo0
    public void onAnimationStart(@Nullable Animator animator) {
        GXTemplateEngine.GXIEventListener c;
        this.$gxNode.L(true);
        GXTemplateEngine.g j = this.$gxTemplateContext.j();
        if (j != null && (c = j.c()) != null) {
            GXTemplateEngine.b bVar = new GXTemplateEngine.b();
            up0 up0 = this.$gxNode;
            LottieAnimationView lottieAnimationView = this.$lottieView;
            JSONObject jSONObject = this.$gxAnimationData;
            bVar.g(GXTemplateEngine.b.STATE_START);
            bVar.f(up0.g());
            bVar.h(lottieAnimationView);
            bVar.e(jSONObject);
            ur2 ur2 = ur2.INSTANCE;
            c.onAnimationEvent(bVar);
        }
    }
}
