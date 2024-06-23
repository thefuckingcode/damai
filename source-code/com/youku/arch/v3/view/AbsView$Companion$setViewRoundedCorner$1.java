package com.youku.arch.v3.view;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.launcher.common.Constants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"com/youku/arch/v3/view/AbsView$Companion$setViewRoundedCorner$1", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", Constants.PARAMETER_OUTLINE, "Ltb/ur2;", "getOutline", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class AbsView$Companion$setViewRoundedCorner$1 extends ViewOutlineProvider {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ float $alpha;
    final /* synthetic */ int $radius;

    AbsView$Companion$setViewRoundedCorner$1(float f, int i) {
        this.$alpha = f;
        this.$radius = i;
    }

    public void getOutline(@NotNull View view, @NotNull Outline outline) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-877398680")) {
            ipChange.ipc$dispatch("-877398680", new Object[]{this, view, outline});
            return;
        }
        k21.i(view, "view");
        k21.i(outline, Constants.PARAMETER_OUTLINE);
        float f = this.$alpha;
        if (f >= 0.0f) {
            outline.setAlpha(f);
        }
        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), (float) this.$radius);
    }
}
