package cn.damai.tetris.component.home.widget.banner.transformer.carousel;

import android.annotation.TargetApi;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import cn.damai.uikit.banner.transformer.carousel.NonPageTransformer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public abstract class BasePageTransformer implements ViewPager.PageTransformer {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final float DEFAULT_CENTER = 0.5f;
    protected ViewPager.PageTransformer a = NonPageTransformer.INSTANCE;

    /* access modifiers changed from: protected */
    public abstract void a(View view, float f);

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    @TargetApi(11)
    public void transformPage(View view, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-19707291")) {
            ipChange.ipc$dispatch("-19707291", new Object[]{this, view, Float.valueOf(f)});
            return;
        }
        ViewPager.PageTransformer pageTransformer = this.a;
        if (pageTransformer != null) {
            pageTransformer.transformPage(view, f);
        }
        a(view, f);
    }
}
