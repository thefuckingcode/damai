package cn.damai.homepage.ui.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import cn.damai.homepage.R$layout;
import com.alient.onearch.adapter.widget.OneTabLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.animate.AnimatedImageDrawable;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.i42;
import tb.k21;

/* compiled from: Taobao */
public final class HomeWaterFlowTabLayout extends OneTabLayout {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeWaterFlowTabLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        setSelectedIndicatorBackgroundUrl(i42.p("tab_indicator_anim.png"));
    }

    @Override // com.alient.onearch.adapter.widget.OneTabLayout
    public int getItemLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "658136364")) {
            return R$layout.home_water_flow_tab_layout_item;
        }
        return ((Integer) ipChange.ipc$dispatch("658136364", new Object[]{this})).intValue();
    }

    @Override // com.alient.onearch.adapter.widget.OneTabLayout
    public void onLoadIndicatorBackgroundSuccess(@NotNull ImageView imageView, @NotNull Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "285643958")) {
            ipChange.ipc$dispatch("285643958", new Object[]{this, imageView, drawable});
            return;
        }
        k21.i(imageView, "imageView");
        k21.i(drawable, "drawable");
        imageView.setImageDrawable(drawable);
        AnimatedImageDrawable animatedImageDrawable = drawable instanceof AnimatedImageDrawable ? (AnimatedImageDrawable) drawable : null;
        if (animatedImageDrawable != null) {
            if (animatedImageDrawable.p()) {
                animatedImageDrawable.x();
            }
            animatedImageDrawable.v(1);
            animatedImageDrawable.w();
        }
    }
}
