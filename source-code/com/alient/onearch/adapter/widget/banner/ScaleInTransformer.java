package com.alient.onearch.adapter.widget.banner;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;

/* compiled from: Taobao */
public class ScaleInTransformer implements ViewPager2.PageTransformer {
    private static final float DEFAULT_CENTER = 0.5f;
    private float mMinScale = 0.85f;

    public ScaleInTransformer() {
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(View view, float f) {
        int width = view.getWidth();
        view.setPivotY((float) (view.getHeight() >> 1));
        view.setPivotX((float) (width >> 1));
        if (f < -1.0f) {
            view.setScaleX(this.mMinScale);
            view.setScaleY(this.mMinScale);
            view.setPivotX((float) width);
        } else if (f > 1.0f) {
            view.setPivotX(0.0f);
            view.setScaleX(this.mMinScale);
            view.setScaleY(this.mMinScale);
        } else if (f < 0.0f) {
            float f2 = this.mMinScale;
            float f3 = ((f + 1.0f) * (1.0f - f2)) + f2;
            view.setScaleX(f3);
            view.setScaleY(f3);
            view.setPivotX(((float) width) * (((-f) * 0.5f) + 0.5f));
        } else {
            float f4 = 1.0f - f;
            float f5 = this.mMinScale;
            float f6 = ((1.0f - f5) * f4) + f5;
            view.setScaleX(f6);
            view.setScaleY(f6);
            view.setPivotX(((float) width) * f4 * 0.5f);
        }
    }

    public ScaleInTransformer(float f) {
        this.mMinScale = f;
    }
}
