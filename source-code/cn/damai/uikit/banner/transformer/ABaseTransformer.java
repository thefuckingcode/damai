package cn.damai.uikit.banner.transformer;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public abstract class ABaseTransformer implements ViewPager.PageTransformer {
    private static transient /* synthetic */ IpChange $ipChange;

    protected static final float c(float f, float f2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "528805947")) {
            return f < f2 ? f2 : f;
        }
        return ((Float) ipChange.ipc$dispatch("528805947", new Object[]{Float.valueOf(f), Float.valueOf(f2)})).floatValue();
    }

    /* access modifiers changed from: protected */
    public boolean a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1673862234")) {
            return true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1673862234", new Object[]{this})).booleanValue();
    }

    /* access modifiers changed from: protected */
    public boolean b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-814086730")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-814086730", new Object[]{this})).booleanValue();
    }

    /* access modifiers changed from: protected */
    public void d(View view, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1224744546")) {
            ipChange.ipc$dispatch("-1224744546", new Object[]{this, view, Float.valueOf(f)});
        }
    }

    /* access modifiers changed from: protected */
    public void e(View view, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-219186317")) {
            ipChange.ipc$dispatch("-219186317", new Object[]{this, view, Float.valueOf(f)});
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
    public abstract void f(View view, float f);

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(View view, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1002904272")) {
            ipChange.ipc$dispatch("1002904272", new Object[]{this, view, Float.valueOf(f)});
            return;
        }
        e(view, f);
        f(view, f);
        d(view, f);
    }
}
