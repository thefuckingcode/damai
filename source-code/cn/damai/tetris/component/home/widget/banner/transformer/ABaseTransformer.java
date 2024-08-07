package cn.damai.tetris.component.home.widget.banner.transformer;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public abstract class ABaseTransformer implements ViewPager.PageTransformer {
    private static transient /* synthetic */ IpChange $ipChange;

    /* access modifiers changed from: protected */
    public boolean a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "983197582")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("983197582", new Object[]{this})).booleanValue();
    }

    /* access modifiers changed from: protected */
    public boolean b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1948038450")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1948038450", new Object[]{this})).booleanValue();
    }

    /* access modifiers changed from: protected */
    public void c(View view, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1922323786")) {
            ipChange.ipc$dispatch("-1922323786", new Object[]{this, view, Float.valueOf(f)});
        }
    }

    /* access modifiers changed from: protected */
    public void d(View view, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-103141541")) {
            ipChange.ipc$dispatch("-103141541", new Object[]{this, view, Float.valueOf(f)});
            return;
        }
        float width = (float) view.getWidth();
        float f2 = 0.0f;
        view.setRotationX(0.0f);
        view.setRotationY(0.0f);
        view.setRotation(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setPivotX(0.0f);
        view.setPivotY(0.0f);
        view.setTranslationY(0.0f);
        view.setTranslationX(b() ? 0.0f : (-width) * f);
        if (a()) {
            if (f > -1.0f && f < 1.0f) {
                f2 = 1.0f;
            }
            view.setAlpha(f2);
            return;
        }
        view.setAlpha(1.0f);
    }

    /* access modifiers changed from: protected */
    public abstract void e(View view, float f);

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(View view, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1145194984")) {
            ipChange.ipc$dispatch("1145194984", new Object[]{this, view, Float.valueOf(f)});
            return;
        }
        d(view, f);
        e(view, f);
        c(view, f);
    }
}
