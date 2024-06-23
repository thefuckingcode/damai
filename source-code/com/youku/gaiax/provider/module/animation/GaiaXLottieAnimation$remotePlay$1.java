package com.youku.gaiax.provider.module.animation;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieTask;
import com.airbnb.lottie.a;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.template.GXIExpression;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import tb.up0;
import tb.wq0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/youku/gaiax/provider/module/animation/GaiaXLottieAnimation$remotePlay$1", "Lcom/airbnb/lottie/LottieListener;", "Lcom/airbnb/lottie/a;", "composition", "Ltb/ur2;", "onResult", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXLottieAnimation$remotePlay$1 implements LottieListener<a> {
    final /* synthetic */ LottieTask<a> $downloadTask;
    final /* synthetic */ JSONObject $gxAnimationData;
    final /* synthetic */ up0 $gxNode;
    final /* synthetic */ GXIExpression $gxState;
    final /* synthetic */ wq0 $gxTemplateContext;
    final /* synthetic */ JSONObject $gxTemplateData;
    final /* synthetic */ int $loopCount;
    final /* synthetic */ LottieAnimationView $lottieView;

    GaiaXLottieAnimation$remotePlay$1(LottieTask<a> lottieTask, up0 up0, LottieAnimationView lottieAnimationView, int i, GXIExpression gXIExpression, wq0 wq0, JSONObject jSONObject, JSONObject jSONObject2) {
        this.$downloadTask = lottieTask;
        this.$gxNode = up0;
        this.$lottieView = lottieAnimationView;
        this.$loopCount = i;
        this.$gxState = gXIExpression;
        this.$gxTemplateContext = wq0;
        this.$gxTemplateData = jSONObject;
        this.$gxAnimationData = jSONObject2;
    }

    public void onResult(@Nullable a aVar) {
        this.$downloadTask.k(this);
        this.$gxNode.L(aVar != null);
        if (aVar != null) {
            LottieAnimationView lottieAnimationView = this.$lottieView;
            int i = this.$loopCount;
            up0 up0 = this.$gxNode;
            GXIExpression gXIExpression = this.$gxState;
            wq0 wq0 = this.$gxTemplateContext;
            JSONObject jSONObject = this.$gxTemplateData;
            JSONObject jSONObject2 = this.$gxAnimationData;
            lottieAnimationView.setComposition(aVar);
            lottieAnimationView.setRepeatCount(i);
            lottieAnimationView.addAnimatorListener(new GaiaXLottieAnimation$remotePlay$1$onResult$1$1(up0, lottieAnimationView, gXIExpression, wq0, jSONObject, jSONObject2));
            lottieAnimationView.playAnimation();
        }
    }
}
